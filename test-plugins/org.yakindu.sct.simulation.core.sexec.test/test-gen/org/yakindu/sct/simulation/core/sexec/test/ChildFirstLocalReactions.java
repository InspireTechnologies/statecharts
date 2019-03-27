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
 * Unit TestCase for ChildFirstLocalReactions
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class ChildFirstLocalReactions extends AbstractExecutionFlowTest {
	
	@Before
	public void setup() throws Exception{
		ExecutionFlow flow = models.loadExecutionFlowFromResource("executionorder/ChildFirstLocalReactions.sct");
		initInterpreter(flow);
	}
	@Test
	public void expectBottomUpLocalReactionOrder() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("AAA"));
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("AAA"));
		assertTrue(getInteger("aaa_local") == 1l);
		assertTrue(getInteger("aa_local") == 2l);
		assertTrue(getInteger("a_local") == 3l);
		assertTrue(getInteger("sm_local") == 4l);
	}
	@Test
	public void expectParentLocalReactionOnChildLocalTransition() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("AAA"));
		raiseEvent("e");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("AAB"));
		assertTrue(getInteger("aaa_local") == 0l);
		assertTrue(getInteger("aa_local") == 1l);
		assertTrue(getInteger("a_local") == 2l);
		assertTrue(getInteger("sm_local") == 3l);
	}
	@Test
	public void expectGrandparentLocalReactionOnParentLocalTransition() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("AAA"));
		setBoolean("disable_aaa", true);
		raiseEvent("e");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("AB"));
		assertTrue(getInteger("aaa_local") == 1l);
		assertTrue(getInteger("aa_local") == 0l);
		assertTrue(getInteger("a_local") == 2l);
		assertTrue(getInteger("sm_local") == 3l);
	}
	@Test
	public void expectNoLocalReactionOnGrandparentTransition() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("AAA"));
		setBoolean("disable_aaa", true);
		setBoolean("disable_aa", true);
		raiseEvent("e");
		timer.timeLeap(getCyclePeriod());
		assertTrue(isStateActive("B"));
		assertTrue(getInteger("aaa_local") == 1l);
		assertTrue(getInteger("aa_local") == 2l);
		assertTrue(getInteger("a_local") == 0l);
		assertTrue(getInteger("sm_local") == 3l);
	}
}
