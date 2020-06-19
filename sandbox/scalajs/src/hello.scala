// ###########################################
// ###   oooo     oooo ooooo oooooooooo    ###       _____
// ###    88   88  88   888   888    888   ###     .'     `.
// ###     88 888 88    888   888oooo88    ###    /  .-=-.  \   \ __
// ###      888 888     888   888          ###    | (  C\ \  \_.'')
// ###       8   8     o888o o888o         ###   _\  `--' |,'   _/
// ###########################################  /__`.____.'__.-'

//[WIP] https://github.com/lampepfl/dotty/compare/master...FabioPinheiro:enable_ArrayBuilderTest_ClassTagTest_for_Scala_js

// trait M[F[_]] { def pure[A](x: A): F[A] }
// object M {
//   def [A, F[A]](x: A).pure(using m: M[F]): F[A] = m.pure(x)
//   given listMonad as M[List] { def pure[A](x: A): List[A] = List(x) }
//   given optionMonad as M[Option] { def pure[A](x: A): Option[A] = Some(x) }
//   val value1: List[String] = "ola".pure
//   val value2 = "ola".pure
// }

object Test {
  opaque type SomeUnrelatedOpaque = Int
  class A[T](val d: T)
  extension on [T] (x: A[T]) { def value: T = x.d }
}


// object Rates {

//   case class A[T](d: Double)
//   object A {
//     extension on [T] (x: A[T]) { def value: String = "TEST" }
//   }

//   opaque type Rate[T] = Double

//   // object Rate {

//   //   def apply[T](d: Double): Rate[T] = d

//   //   //extension RateOps on (x: Rate[Any]) { def value: Double = x }
//   //   extension on [T] (x: Rate[T]) { def value: Double = x }
//   // }
// }

//import Rates._
//val b1 = Rate(56d).value
//val b2 = Rate(78d).value



// trait A { def [T](t: T).m: String = "trait"}
// given A { def m[T](x: T): String  = "given" }

// -- Error: sandbox/scalajs/src/hello.scala:21:14 --------------------------------
// 21 |given A { def m[T](x: T): String  = "given" }
//    |              ^
//    |         error overriding method m in trait A of type [T](t: T): String;
//    |           method m of type [T](x: T): String needs `override` modifier

// a)bort, s)tack, r)esume: s
// java.lang.Throwable
// 	at dotty.tools.dotc.reporting.Reporter$.loop$1(Reporter.scala:58)
// 	at dotty.tools.dotc.reporting.Reporter$.displayPrompt(Reporter.scala:66)
// 	at dotty.tools.dotc.reporting.ConsoleReporter.doReport(ConsoleReporter.scala:27)
// 	at dotty.tools.dotc.reporting.Reporter.report(Reporter.scala:266)
// 	at dotty.tools.dotc.reporting.Reporting.error(Reporter.scala:129)
// 	at dotty.tools.dotc.core.Contexts$Context.error(Contexts.scala:79)
// 	at dotty.tools.dotc.typer.RefChecks$.emitOverrideError$2(RefChecks.scala:246)
// 	at dotty.tools.dotc.typer.RefChecks$.overrideError$1(RefChecks.scala:253)
// 	at dotty.tools.dotc.typer.RefChecks$.checkOverride$1(RefChecks.scala:368)
// 	at dotty.tools.dotc.typer.RefChecks$.dotty$tools$dotc$typer$RefChecks$$$checkAllOverrides(RefChecks.scala:430)
// 	at dotty.tools.dotc.typer.RefChecks.transformTemplate(RefChecks.scala:1002)
// 	at dotty.tools.dotc.transform.MegaPhase.goTemplate(MegaPhase.scala:971)
// 	at dotty.tools.dotc.transform.MegaPhase.goTemplate(MegaPhase.scala:972)
// 	at dotty.tools.dotc.transform.MegaPhase.goTemplate(MegaPhase.scala:972)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnnamed$1(MegaPhase.scala:340)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:396)
// 	at dotty.tools.dotc.transform.MegaPhase.transformNamed$1(MegaPhase.scala:251)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:394)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStat$2(MegaPhase.scala:404)
// 	at dotty.tools.dotc.transform.MegaPhase.$anonfun$1(MegaPhase.scala:409)
// 	at scala.collection.immutable.List.mapConserve(List.scala:472)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStats(MegaPhase.scala:409)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnnamed$1(MegaPhase.scala:339)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:396)
// 	at dotty.tools.dotc.transform.MegaPhase.transformNamed$1(MegaPhase.scala:251)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:394)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStat$2(MegaPhase.scala:404)
// 	at dotty.tools.dotc.transform.MegaPhase.$anonfun$1(MegaPhase.scala:409)
// 	at scala.collection.immutable.List.mapConserve(List.scala:472)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStats(MegaPhase.scala:409)
// 	at dotty.tools.dotc.transform.MegaPhase.mapPackage$1(MegaPhase.scala:356)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnnamed$1(MegaPhase.scala:359)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:396)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnit(MegaPhase.scala:415)
// 	at dotty.tools.dotc.transform.MegaPhase.run(MegaPhase.scala:427)
// 	at dotty.tools.dotc.core.Phases$Phase.runOn$$anonfun$1(Phases.scala:318)
// 	at scala.collection.immutable.List.map(List.scala:246)
// 	at dotty.tools.dotc.core.Phases$Phase.runOn(Phases.scala:319)
// 	at dotty.tools.dotc.Run.runPhases$4$$anonfun$4(Run.scala:166)
// 	at dotty.runtime.function.JProcedure1.apply(JProcedure1.java:15)
// 	at dotty.runtime.function.JProcedure1.apply(JProcedure1.java:10)
// 	at scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
// 	at dotty.tools.dotc.Run.runPhases$5(Run.scala:176)
// 	at dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:184)
// 	at dotty.runtime.function.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:12)
// 	at dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:64)
// 	at dotty.tools.dotc.Run.compileUnits(Run.scala:191)
// 	at dotty.tools.dotc.Run.compileSources(Run.scala:128)
// 	at dotty.tools.dotc.Run.compile(Run.scala:110)
// 	at dotty.tools.dotc.Driver.doCompile(Driver.scala:38)
// 	at dotty.tools.dotc.Driver.process(Driver.scala:194)
// 	at dotty.tools.dotc.Driver.process(Driver.scala:163)
// 	at dotty.tools.dotc.Driver.process(Driver.scala:175)
// 	at dotty.tools.dotc.Driver.main(Driver.scala:202)
// 	at dotty.tools.dotc.Main.main(Main.scala)




// 21 |given A { override def m[T](x: T): String  = "given" }
//    |                       ^
//    |error overriding method m in trait A of type [T](t: T): String;
//    |  method m of type [T](x: T): String is a normal method, cannot override an extension method

// a)bort, s)tack, r)esume: s
// java.lang.Throwable
// 	at dotty.tools.dotc.reporting.Reporter$.loop$1(Reporter.scala:58)
// 	at dotty.tools.dotc.reporting.Reporter$.displayPrompt(Reporter.scala:66)
// 	at dotty.tools.dotc.reporting.ConsoleReporter.doReport(ConsoleReporter.scala:27)
// 	at dotty.tools.dotc.reporting.Reporter.report(Reporter.scala:266)
// 	at dotty.tools.dotc.reporting.Reporting.error(Reporter.scala:129)
// 	at dotty.tools.dotc.core.Contexts$Context.error(Contexts.scala:79)
// 	at dotty.tools.dotc.typer.RefChecks$.emitOverrideError$2(RefChecks.scala:246)
// 	at dotty.tools.dotc.typer.RefChecks$.overrideError$1(RefChecks.scala:253)
// 	at dotty.tools.dotc.typer.RefChecks$.checkOverride$1(RefChecks.scala:400)
// 	at dotty.tools.dotc.typer.RefChecks$.dotty$tools$dotc$typer$RefChecks$$$checkAllOverrides(RefChecks.scala:430)
// 	at dotty.tools.dotc.typer.RefChecks.transformTemplate(RefChecks.scala:1002)
// 	at dotty.tools.dotc.transform.MegaPhase.goTemplate(MegaPhase.scala:971)
// 	at dotty.tools.dotc.transform.MegaPhase.goTemplate(MegaPhase.scala:972)
// 	at dotty.tools.dotc.transform.MegaPhase.goTemplate(MegaPhase.scala:972)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnnamed$1(MegaPhase.scala:340)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:396)
// 	at dotty.tools.dotc.transform.MegaPhase.transformNamed$1(MegaPhase.scala:251)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:394)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStat$2(MegaPhase.scala:404)
// 	at dotty.tools.dotc.transform.MegaPhase.$anonfun$1(MegaPhase.scala:409)
// 	at scala.collection.immutable.List.mapConserve(List.scala:472)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStats(MegaPhase.scala:409)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnnamed$1(MegaPhase.scala:339)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:396)
// 	at dotty.tools.dotc.transform.MegaPhase.transformNamed$1(MegaPhase.scala:251)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:394)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStat$2(MegaPhase.scala:404)
// 	at dotty.tools.dotc.transform.MegaPhase.$anonfun$1(MegaPhase.scala:409)
// 	at scala.collection.immutable.List.mapConserve(List.scala:472)
// 	at dotty.tools.dotc.transform.MegaPhase.transformStats(MegaPhase.scala:409)
// 	at dotty.tools.dotc.transform.MegaPhase.mapPackage$1(MegaPhase.scala:356)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnnamed$1(MegaPhase.scala:359)
// 	at dotty.tools.dotc.transform.MegaPhase.transformTree(MegaPhase.scala:396)
// 	at dotty.tools.dotc.transform.MegaPhase.transformUnit(MegaPhase.scala:415)
// 	at dotty.tools.dotc.transform.MegaPhase.run(MegaPhase.scala:427)
// 	at dotty.tools.dotc.core.Phases$Phase.runOn$$anonfun$1(Phases.scala:318)
// 	at scala.collection.immutable.List.map(List.scala:246)
// 	at dotty.tools.dotc.core.Phases$Phase.runOn(Phases.scala:319)
// 	at dotty.tools.dotc.Run.runPhases$4$$anonfun$4(Run.scala:166)
// 	at dotty.runtime.function.JProcedure1.apply(JProcedure1.java:15)
// 	at dotty.runtime.function.JProcedure1.apply(JProcedure1.java:10)
// 	at scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
// 	at dotty.tools.dotc.Run.runPhases$5(Run.scala:176)
// 	at dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:184)
// 	at dotty.runtime.function.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:12)
// 	at dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:64)
// 	at dotty.tools.dotc.Run.compileUnits(Run.scala:191)
// 	at dotty.tools.dotc.Run.compileSources(Run.scala:128)
// 	at dotty.tools.dotc.Run.compile(Run.scala:110)
// 	at dotty.tools.dotc.Driver.doCompile(Driver.scala:38)
// 	at dotty.tools.dotc.Driver.process(Driver.scala:194)
// 	at dotty.tools.dotc.Driver.process(Driver.scala:163)
// 	at dotty.tools.dotc.Driver.process(Driver.scala:175)
// 	at dotty.tools.dotc.Driver.main(Driver.scala:202)
// 	at dotty.tools.dotc.Main.main(Main.scala)


//object MyEnumeration extends Enumeration  { val A = Value }

// package hello

// //import scala.scalajs.js
// import scala.reflect._

// object HelloWorld {
//   val a = ClassTag.Nothing.runtimeClass  //all ok
//   val b = classOf[Nothing]  //fail with: Referring to non-existent class scala.Nothing
//   val c = classOf[Int]
//   def main(args: Array[String]): Unit = {
//     //println(a)
//   }
// }

/*
sbt:dotty> sjsSandbox/run
[warn] Multiple main classes detected.  Run 'show discoveredMainClasses' to see the list
[info] Compiling 1 Scala source to /home/fabio/dotty/sandbox/scalajs/../out/bootstrap/sjsSandbox/scala-0.26/classes ...
[info] Fast optimizing /home/fabio/dotty/sandbox/scalajs/../out/bootstrap/sjsSandbox/scala-0.26/sjssandbox-fastopt.js
[error] Referring to non-existent class scala.Nothing
[error]   called from constructor hello.HelloWorld$.<init>()void
[error]   called from static hello.HelloWorld.main([java.lang.String)void
[error]   called from core module module initializers
[error] There were linking errors
[error] (sjsSandbox / Compile / fastOptJS) There were linking errors
[error] Total time: 1 s, completed Jun 10, 2020, 5:09:30 PM


sbt:dotty> sjsSandbox/scalajsp hello.HelloWorld
[warn] Multiple main classes detected.  Run 'show discoveredMainClasses' to see the list
class hello.HelloWorld extends java.lang.Object {
  static def a;Ljava.lang.Class(): java.lang.Class = {
    mod:hello.HelloWorld$.a;Ljava.lang.Class()
  }
  static def b;Ljava.lang.Class(): java.lang.Class = {
    mod:hello.HelloWorld$.b;Ljava.lang.Class()
  }
  static def main;[Ljava.lang.String;V(args: java.lang.String[]) {
    mod:hello.HelloWorld$.main;[Ljava.lang.String;V(args)
  }
}


sbt:dotty> set scalacOptions in sjsSandbox += "-Xprint:all"

... after typer:
[info]     val a: Class[?] = reflect.ClassTag.Nothing.runtimeClass
[info]     val b: Class[Nothing] = classOf[Nothing]
[info]     val c: Class[Int] = classOf[Int]

... after classOf  ...after MegaPhase{elimRepeated, expandSAMs, protectedAccessors, extmethods, cacheAliasImplicits, byNameClosures, hoistSuperArgs, classOf, refchecks}
[info]     val a: Class[?] = reflect.ClassTag.Nothing.runtimeClass
[info]     val b: Class[Nothing] = classOf[Nothing]
[info]     val c: Class[Int] = Integer.TYPE.$asInstanceOf$[Class[Int]]

...at the end
[info]         hello.HelloWorld.a = reflect.ClassTag.Nothing().runtimeClass()
[info]         hello.HelloWorld.b = classOf[Nothing]
[info]         hello.HelloWorld.c = Integer.TYPE:Class

*/


