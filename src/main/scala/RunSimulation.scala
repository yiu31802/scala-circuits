package main.scala

import org.stairwaybook.simulation._

object RunSimulation extends CircuitSimulation {
  def InverterDelay = 1
  def AndGateDelay = 3
  def OrGateDelay = 5

  def main(args: Array[String]) {
    val input1, input2, sum, carry = new Wire

    probe("sum", sum)
    halfAdder(input1, input2, sum, carry)
    input1 setSignal true
    run()
    input2 setSignal true
    run()
  }
}

