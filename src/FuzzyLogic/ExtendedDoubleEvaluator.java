/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuzzyLogic;

import java.util.Iterator;
 
import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;
 
 
public class ExtendedDoubleEvaluator extends DoubleEvaluator {
  /** Define the new functions. parameters are the expression and number of arguments for that function*/
	  private static final Function NOT = new Function("!!", 1);
	  private static final Function AND = new Function("&&", 2);
	  private static final Function OR = new Function("||", 2);
	  private static final Parameters PARAMS;
 
  static {
    // Gets the default DoubleEvaluator's parameters
    PARAMS = DoubleEvaluator.getDefaultParameters();
    // add the new functions to these parameters
    PARAMS.add(OR);
    PARAMS.add(NOT);
    PARAMS.add(AND);
  }
 
  public ExtendedDoubleEvaluator() {
    super(PARAMS);
  }
 
  @Override
  protected Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContext) {
    if (function == AND) {
      return (Math.min(arguments.next(), arguments.next()));
    } else if(function == OR){
    	return Math.min(1,arguments.next()+arguments.next());
    }else if(function == NOT){
      return (1.0-arguments.next());
    }
    else{
    	System.err.println("Invalid Operator");
    	System.exit(0);
    	return null;
    }
  }
}
 


