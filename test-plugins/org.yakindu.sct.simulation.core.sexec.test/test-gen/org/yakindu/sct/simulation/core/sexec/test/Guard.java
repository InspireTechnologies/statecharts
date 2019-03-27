/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.simulation.core.sexec.test;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import com.google.inject.Inject;
import static org.junit.Assert.*;

/**
 * Unit TestCase for Guard
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class Guard extends AbstractExecutionFlowTest {
	
	@Before
	public void setup() throws Exception{
		ExecutionFlow flow = models.loadExecutionFlowFromResource("Guard.sct");
		initInterpreter(flow);
	}
	@Test
	public void guardTest() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("A"));
		raiseEvent("Event1");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("A"));
		raiseEvent("Event2");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("B"));
		raiseEvent("Return");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("A"));
		raiseEvent("Event1");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("B"));
		raiseEvent("Return");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("A"));
	}
}
