// ###########################################
// ###   oooo     oooo ooooo oooooooooo    ###       _____
// ###    88   88  88   888   888    888   ###     .'     `.
// ###     88 888 88    888   888oooo88    ###    /  .-=-.  \   \ __
// ###      888 888     888   888          ###    | (  C\ \  \_.'')
// ###       8   8     o888o o888o         ###   _\  `--' |,'   _/
// ###########################################  /__`.____.'__.-'

//[WIP] https://github.com/lampepfl/dotty/compare/master...FabioPinheiro:enable_ArrayBuilderTest_ClassTagTest_for_Scala_js


object MyEnumeration extends Enumeration  { val A = Value }

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


