Just some type work of the scala circuit simulation api from the book
[Programming in Scala](http://amzn.to/1bi5kUs) by Martin Odersky.

# To use the package from Scala Worksheet in Eclipse

_This instruction is intended for a Scala learner (so does the writer of this section)._

_written by @yiu31802 (Junji Shimagaki)_

In order to use the entire package, e.g., `Similation` and `CircuitSimulation`,
in another Scala worksheet, you have to follow the steps below:

1. **Create a new project.**
You create a new scala worksheet by `New -> Scala Project` to create a
new test project (Say, `circuitTest`), and
`Right clilck circuitTest -> New Scala Worksheet` to create a new
worksheet.

2. **Import this package `org.stairwaybook.simulation` in Eclipse.**
In the sbt console from Terminal, after moving your current path to
the root of this repository `scala-circuits`,
you can type `eclipse` and that will create necessary files that make
Eclipse Application aware that
it is a Scala package. After that, you can import this project in Eclipse.

3. **Include the package in your test project.** In Scala if you want to use
class or object from other path (i.e., the one you did in Step 2) in
your project (i.e., the one you created in Step 1), you can include
it using Eclipse GUI.
`Right click circuitTest -> Properties -> Java Build Path -> Projects -> Add`.

4. **Consistent Scala Compiler in the two projects**. At least, I faced
a situation with `NoSuchMethodException` when the scala worksheet tried to
run the process. It turned out that it happened because of inconsistent
Scala compiler. So be sure to use the same compiler version in the two
different projects. You can make sure this thing by checking
`Right click a project -> Properties -> Scala Compiler -> Scala Installation`.

5. **Completed worksheet example.**

```{scala}
object circuit{
  import org.stairwaybook.simulation._
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  object sim extends CircuitSimulation with Parameters
  import sim._
  val in1, in2, sum, carry = new Wire             //> in1  : circuit.sim.Wire = org.stairwaybook.simulation.BasicCircuitSimulation
                                                  //| $Wire@6e8dacdf
                                                  //| in2  : circuit.sim.Wire = org.stairwaybook.simulation.BasicCircuitSimulation
                                                  //| $Wire@7a79be86
                                                  //| sum  : circuit.sim.Wire = org.stairwaybook.simulation.BasicCircuitSimulation
                                                  //| $Wire@34ce8af7
                                                  //| carry  : circuit.sim.Wire = org.stairwaybook.simulation.BasicCircuitSimulati
                                                  //| on$Wire@b684286

	halfAdder(in1, in2, sum, carry)
	probe("sum", sum)                         //> sum 0 new-value = false
	probe("carry", carry)                     //> carry 0 new-value = false
	in1 setSignal true
	run()                                     //> *** simulation started, time = 0 ***
                                                  //| sum 8 new-value = true
	in1 setSignal false
	run()                                     //> *** simulation started, time = 8 ***
                                                  //| sum 16 new-value = false

	in2 setSignal true
	run()                                     //> *** simulation started, time = 16 ***
}
```
