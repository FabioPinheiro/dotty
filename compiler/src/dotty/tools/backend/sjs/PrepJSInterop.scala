package dotty.tools.backend.sjs

import dotty.tools.FatalError
import dotty.tools.dotc.ast.tpd
import dotty.tools.dotc.CompilationUnit

import dotty.tools.dotc.core._
import Periods._
import SymDenotations._
import Contexts._
import Decorators._
import Flags._
import dotty.tools.dotc.ast.Trees._
import Names._
import Types._
import Symbols._
import Denotations._
import Phases._
import StdNames._

import dotty.tools.dotc.transform.MegaPhase._

/** Prepare ASTs for JavaScript interop.
 *
 * This phase does:
 * - Rewrite calls to scala.Enumeration.Value (include name string)
 */
class PrepJSInterop extends MiniPhase {
  //https://github.com/lampepfl/dotty/blob/f43af58041320a4d7029192ff1f4d295874657d8/compiler/src/dotty/tools/dotc/transform/MegaPhase.scala
  import JSCodeGen._
  import tpd._

  override def phaseName: String = "jsinterop"

  override def isRunnable(implicit ctx: Context): Boolean =
    super.isRunnable && ctx.settings.scalajs.value

  override def transformValDef(tree: ValDef)(implicit ctx: Context): Tree = {
    //println(s"#### transformValDef $tree")
    // // Catch ValDefs in enumerations with simple calls to Value
    // case ValDef(mods, name, tpt, ScalaEnumValue.NoName(optPar))
    //     if anyEnclosingOwner is OwnerKind.Enum =>
    //   val nrhs = ScalaEnumValName(tree.symbol.owner, tree.symbol, optPar)
    //   treeCopy.ValDef(tree, mods, name, transform(tpt), nrhs)
    tree match {
      case ValDef(name, tpt, Ident(simpleName: SimpleName)) =>
        //https://github.com/lampepfl/dotty/blob/master/compiler/src/dotty/tools/dotc/ast/tpd.scala
        //https://github.com/lampepfl/dotty/blob/master/compiler/src/dotty/tools/dotc/ast/Trees.scala
        //println(s"@@ $tpt") //TypeTree[TypeRef(ThisType(TypeRef(ThisType(TypeRef(NoPrefix,module class <empty>)),module class MyEnumeration$)),class Value)]
        //println(s"##### $name ${simpleName}")
        tree
      case ValDef(name, tpt, rhs) =>
        //println(s"@@@ $name , $tpt , $rhs")
        //@@@ MyEnumeration , Ident(MyEnumeration$) , Apply(Select(New(Ident(MyEnumeration$)),<init>),List())
        //@@@ _ , SingletonTypeTree(Ident(MyEnumeration)) , EmptyTree
        if(name.toString == "MyEnumeration") tree
        else tree
      //case _ => tree
    }

  }

  // constructor def <init>;V() {
  //   this.scala.Enumeration::<init>;V();
  //   mod:MyEnumeration$<-this;
  //   this.MyEnumeration$::A = this.Value;Lscala.Enumeration$Value()
  // }


  // constructor def <init>;V() {
  //   this.scala.Enumeration::<init>;V();
  //   mod:MyEnumeration$<-this;
  //   this.MyEnumeration$::A = this.Value;Ljava.lang.String;Lscala.Enumeration$Value(if ((this.nextName;Lscala.collection.Iterator() !== null) && this.nextName;Lscala.collection.Iterator().hasNext;Z()) {
  //     this.nextName;Lscala.collection.Iterator().next;Ljava.lang.Object().asInstanceOf[java.lang.String]
  //   } else {
  //     "A"
  //   })
  // }

  // private def transformScalaValOrDefDef(tree: ValOrDefDef): Tree = {
  //   tree match {
  //     // Catch ValDefs in enumerations with simple calls to Value
  //     case ValDef(mods, name, tpt, ScalaEnumValue.NoName(optPar))
  //         if anyEnclosingOwner is OwnerKind.Enum =>
  //       val nrhs = ScalaEnumValName(tree.symbol.owner, tree.symbol, optPar)
  //       treeCopy.ValDef(tree, mods, name, transform(tpt), nrhs)

  //     // Exporter generation
  //     case _ =>
  //       super.transform(tree)
  //   }
  // }


  //private object ScalaEnumValue extends ScalaEnumFctExtractors(getMemberMethod(ScalaEnumClass, jsnme.Value))
  //private object ScalaEnumVal extends ScalaEnumFctExtractors(getMemberClass(ScalaEnumClass, jsnme.Val).tpe.member(nme.CONSTRUCTOR))

  /**
   * Construct a call to Enumeration.Value
   * @param thisSym  ClassSymbol of enclosing class
   * @param nameOrig Symbol of ValDef where this call will be placed
   *                 (determines the string passed to Value)
   * @param intParam Optional tree with Int passed to Value
   * @return Typed tree with appropriate call to Value
   */
  private def ScalaEnumValName(thisSym: Symbol, nameOrig: Symbol, intParam: Option[Tree]) = {

    // val defaultName = nameOrig.asTerm.getterName.encoded

    // Construct the following tree
    //
    //   if (nextName != null && nextName.hasNext)
    //     nextName.next()
    //   else
    //     <defaultName>
    //
    // val nextNameTree = Select(This(thisSym), jsnme.nextName)
    // val nullCompTree =
    //   Apply(Select(nextNameTree, nme.NE), Literal(Constant(null)) :: Nil)
    // val hasNextTree = Select(nextNameTree, jsnme.hasNext)
    // val condTree = Apply(Select(nullCompTree, nme.ZAND), hasNextTree :: Nil)
    // val nameTree = If(condTree,
    //     Apply(Select(nextNameTree, jsnme.next), Nil),
    //     Literal(Constant(defaultName)))
    // val params = intParam.toList :+ nameTree

    // typer.typed {
    //   Apply(Select(This(thisSym), jsnme.Value), params)
    // }
  }
}
