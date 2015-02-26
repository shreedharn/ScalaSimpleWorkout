/*
   Copyright 2015 Shreedhar Natarajan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
object TailRecursion {
  // Simple Examples demonstrating tail recursions
  def factorial(n:BigInt):BigInt = {
		@annotation.tailrec
  	def factRecurse(i: BigInt, factorialValue: BigInt): BigInt = {
  		if (i == 1)
  			factorialValue
  		else
  			factRecurse(i-1, factorialValue*i)
  	}
  	factRecurse(n,1)
  }                                               //> factorial: (n: BigInt)BigInt
  factorial(5)                                    //> res0: BigInt = 120
  
  def calculatePi(n:BigInt): Double = {
    @annotation.tailrec
  	def simulateMonteCarloApproaximate(i: BigInt, successCount: BigInt):BigInt = {
  		val x = math.random
  		val y = math.random
  		if (i == n)
  			successCount
  		else if	(x*x + y*y <= 1) // equation of unit circle
  			simulateMonteCarloApproaximate(i+1,successCount+1)
  		else
   			simulateMonteCarloApproaximate(i+1,successCount)
  		
	 	}
	 	
	 	val successCount = simulateMonteCarloApproaximate(1,0)
	 	val pibyFour = successCount.toDouble / n.toDouble
	 	return pibyFour* 4
  }                                               //> calculatePi: (n: BigInt)Double
  calculatePi(1000000)                            //> res1: Double = 3.141176

  
}