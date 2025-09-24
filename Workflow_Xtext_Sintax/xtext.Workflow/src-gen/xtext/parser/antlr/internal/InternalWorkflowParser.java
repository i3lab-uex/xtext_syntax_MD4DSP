package xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xtext.services.WorkflowGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWorkflowParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Workflow'", "'{'", "'dataprocessing'", "','", "'}'", "'link'", "'Link'", "'source'", "'target'", "'DataDictionary'", "'fileName'", "'in'", "'out'", "'datafield'", "'onlyPredictions'", "'PMMLModel'", "'origin_function'", "'filePath'", "'outgoing'", "'incoming'", "'('", "')'", "'inputPort'", "'outputPort'", "'test'", "'DataProcessing'", "'initial_accumulated_processing'", "'parameter'", "'ValueField'", "'value'", "'count'", "'id'", "'ordinal'", "'Categorical'", "'dataType'", "'displayName'", "'validValues'", "'invalidValues'", "'missingValues'", "'Continuous'", "'numDecimals'", "'interval'", "'Date'", "'format'", "'intervaldate'", "'-'", "'Interval'", "'leftMargin'", "'rightMargin'", "'clousure'", "'.'", "'E'", "'e'", "'IntervalDate'", "'Test'", "'path'", "'trainSize'", "'testSize'", "'Map'", "'inValue'", "'outvalue'", "'mapOperation'", "'Primitive'", "'DerivedField'", "'der_dataField'", "'FilterValue'", "'filterType'", "'primitive'", "'matchingvalue'", "'minInfinity'", "'maxInfinity'", "'Range'", "'min'", "'max'", "'SpecialValues'", "'specialType'", "'DiscretizeBin'", "'binValue'", "'CastType'", "'type'", "'DerivedValue'", "'imputeValue'", "'NumOp'", "'operation'", "'FixValue'", "'next_operand'", "'previous_operand'", "'FieldRange'", "'operator'", "'dataField'", "'MathOp'", "'operand'", "'Field'", "'Join'", "'DateRange'", "'String'", "'Time'", "'Integer'", "'DateTime'", "'Boolean'", "'Double'", "'Float'", "'openOpen'", "'openClosed'", "'closedOpen'", "'closedClosed'", "'VALUE_MAPPING'", "'SUBSTRING'", "'EXCLUDE'", "'INCLUDE'", "'Missing'", "'Invalid'", "'Outlier'", "'MostFrequent'", "'Previous'", "'Next'", "'Interpolation'", "'Mean'", "'Median'", "'Closest'", "'BELONG'", "'NOTBELONG'", "'SUM'", "'SUBSTRACT'", "'MULTIPLY'", "'DIVIDE'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalWorkflowParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWorkflowParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWorkflowParser.tokenNames; }
    public String getGrammarFileName() { return "InternalWorkflow.g"; }



     	private WorkflowGrammarAccess grammarAccess;

        public InternalWorkflowParser(TokenStream input, WorkflowGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Workflow";
       	}

       	@Override
       	protected WorkflowGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleWorkflow"
    // InternalWorkflow.g:65:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalWorkflow.g:65:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalWorkflow.g:66:2: iv_ruleWorkflow= ruleWorkflow EOF
            {
             newCompositeNode(grammarAccess.getWorkflowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkflow=ruleWorkflow();

            state._fsp--;

             current =iv_ruleWorkflow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkflow"


    // $ANTLR start "ruleWorkflow"
    // InternalWorkflow.g:72:1: ruleWorkflow returns [EObject current=null] : (otherlv_0= 'Workflow' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataprocessing' otherlv_4= '{' ( (lv_dataprocessing_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_dataprocessing_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' (otherlv_9= 'link' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) ) (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )* otherlv_14= '}' )? otherlv_15= '}' ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dataprocessing_5_0 = null;

        EObject lv_dataprocessing_7_0 = null;

        EObject lv_link_11_0 = null;

        EObject lv_link_13_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:78:2: ( (otherlv_0= 'Workflow' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataprocessing' otherlv_4= '{' ( (lv_dataprocessing_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_dataprocessing_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' (otherlv_9= 'link' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) ) (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )* otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalWorkflow.g:79:2: (otherlv_0= 'Workflow' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataprocessing' otherlv_4= '{' ( (lv_dataprocessing_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_dataprocessing_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' (otherlv_9= 'link' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) ) (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )* otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalWorkflow.g:79:2: (otherlv_0= 'Workflow' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataprocessing' otherlv_4= '{' ( (lv_dataprocessing_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_dataprocessing_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' (otherlv_9= 'link' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) ) (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )* otherlv_14= '}' )? otherlv_15= '}' )
            // InternalWorkflow.g:80:3: otherlv_0= 'Workflow' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataprocessing' otherlv_4= '{' ( (lv_dataprocessing_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_dataprocessing_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' (otherlv_9= 'link' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) ) (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )* otherlv_14= '}' )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkflowAccess().getWorkflowKeyword_0());
            		
            // InternalWorkflow.g:84:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:85:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:85:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:86:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getWorkflowAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getWorkflowAccess().getDataprocessingKeyword_3());
            		
            otherlv_4=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflow.g:115:3: ( (lv_dataprocessing_5_0= ruleProcessingStep ) )
            // InternalWorkflow.g:116:4: (lv_dataprocessing_5_0= ruleProcessingStep )
            {
            // InternalWorkflow.g:116:4: (lv_dataprocessing_5_0= ruleProcessingStep )
            // InternalWorkflow.g:117:5: lv_dataprocessing_5_0= ruleProcessingStep
            {

            					newCompositeNode(grammarAccess.getWorkflowAccess().getDataprocessingProcessingStepParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_dataprocessing_5_0=ruleProcessingStep();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            					}
            					add(
            						current,
            						"dataprocessing",
            						lv_dataprocessing_5_0,
            						"xtext.Workflow.ProcessingStep");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:134:3: (otherlv_6= ',' ( (lv_dataprocessing_7_0= ruleProcessingStep ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalWorkflow.g:135:4: otherlv_6= ',' ( (lv_dataprocessing_7_0= ruleProcessingStep ) )
            	    {
            	    otherlv_6=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_6, grammarAccess.getWorkflowAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalWorkflow.g:139:4: ( (lv_dataprocessing_7_0= ruleProcessingStep ) )
            	    // InternalWorkflow.g:140:5: (lv_dataprocessing_7_0= ruleProcessingStep )
            	    {
            	    // InternalWorkflow.g:140:5: (lv_dataprocessing_7_0= ruleProcessingStep )
            	    // InternalWorkflow.g:141:6: lv_dataprocessing_7_0= ruleProcessingStep
            	    {

            	    						newCompositeNode(grammarAccess.getWorkflowAccess().getDataprocessingProcessingStepParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_dataprocessing_7_0=ruleProcessingStep();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getWorkflowRule());
            	    						}
            	    						add(
            	    							current,
            	    							"dataprocessing",
            	    							lv_dataprocessing_7_0,
            	    							"xtext.Workflow.ProcessingStep");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_8, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_7());
            		
            // InternalWorkflow.g:163:3: (otherlv_9= 'link' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) ) (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )* otherlv_14= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalWorkflow.g:164:4: otherlv_9= 'link' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) ) (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )* otherlv_14= '}'
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getWorkflowAccess().getLinkKeyword_8_0());
                    			
                    otherlv_10=(Token)match(input,12,FOLLOW_9); 

                    				newLeafNode(otherlv_10, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_8_1());
                    			
                    // InternalWorkflow.g:172:4: ( (lv_link_11_0= ruleLink ) )
                    // InternalWorkflow.g:173:5: (lv_link_11_0= ruleLink )
                    {
                    // InternalWorkflow.g:173:5: (lv_link_11_0= ruleLink )
                    // InternalWorkflow.g:174:6: lv_link_11_0= ruleLink
                    {

                    						newCompositeNode(grammarAccess.getWorkflowAccess().getLinkLinkParserRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_link_11_0=ruleLink();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    						}
                    						add(
                    							current,
                    							"link",
                    							lv_link_11_0,
                    							"xtext.Workflow.Link");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:191:4: (otherlv_12= ',' ( (lv_link_13_0= ruleLink ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==14) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalWorkflow.g:192:5: otherlv_12= ',' ( (lv_link_13_0= ruleLink ) )
                    	    {
                    	    otherlv_12=(Token)match(input,14,FOLLOW_9); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getWorkflowAccess().getCommaKeyword_8_3_0());
                    	    				
                    	    // InternalWorkflow.g:196:5: ( (lv_link_13_0= ruleLink ) )
                    	    // InternalWorkflow.g:197:6: (lv_link_13_0= ruleLink )
                    	    {
                    	    // InternalWorkflow.g:197:6: (lv_link_13_0= ruleLink )
                    	    // InternalWorkflow.g:198:7: lv_link_13_0= ruleLink
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorkflowAccess().getLinkLinkParserRuleCall_8_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_link_13_0=ruleLink();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"link",
                    	    								lv_link_13_0,
                    	    								"xtext.Workflow.Link");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_14, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_8_4());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkflow"


    // $ANTLR start "entryRuleProcessingStep"
    // InternalWorkflow.g:229:1: entryRuleProcessingStep returns [EObject current=null] : iv_ruleProcessingStep= ruleProcessingStep EOF ;
    public final EObject entryRuleProcessingStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessingStep = null;


        try {
            // InternalWorkflow.g:229:55: (iv_ruleProcessingStep= ruleProcessingStep EOF )
            // InternalWorkflow.g:230:2: iv_ruleProcessingStep= ruleProcessingStep EOF
            {
             newCompositeNode(grammarAccess.getProcessingStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessingStep=ruleProcessingStep();

            state._fsp--;

             current =iv_ruleProcessingStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessingStep"


    // $ANTLR start "ruleProcessingStep"
    // InternalWorkflow.g:236:1: ruleProcessingStep returns [EObject current=null] : (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing ) ;
    public final EObject ruleProcessingStep() throws RecognitionException {
        EObject current = null;

        EObject this_PMMLModel_0 = null;

        EObject this_DataProcessing_1 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:242:2: ( (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing ) )
            // InternalWorkflow.g:243:2: (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing )
            {
            // InternalWorkflow.g:243:2: (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=25 && LA4_0<=26)) ) {
                alt4=1;
            }
            else if ( (LA4_0==36) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalWorkflow.g:244:3: this_PMMLModel_0= rulePMMLModel
                    {

                    			newCompositeNode(grammarAccess.getProcessingStepAccess().getPMMLModelParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PMMLModel_0=rulePMMLModel();

                    state._fsp--;


                    			current = this_PMMLModel_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:253:3: this_DataProcessing_1= ruleDataProcessing
                    {

                    			newCompositeNode(grammarAccess.getProcessingStepAccess().getDataProcessingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataProcessing_1=ruleDataProcessing();

                    state._fsp--;


                    			current = this_DataProcessing_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessingStep"


    // $ANTLR start "entryRuleDataField"
    // InternalWorkflow.g:265:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalWorkflow.g:265:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalWorkflow.g:266:2: iv_ruleDataField= ruleDataField EOF
            {
             newCompositeNode(grammarAccess.getDataFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataField=ruleDataField();

            state._fsp--;

             current =iv_ruleDataField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataField"


    // $ANTLR start "ruleDataField"
    // InternalWorkflow.g:272:1: ruleDataField returns [EObject current=null] : (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        EObject this_Categorical_0 = null;

        EObject this_Continuous_1 = null;

        EObject this_Date_2 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:278:2: ( (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate ) )
            // InternalWorkflow.g:279:2: (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate )
            {
            // InternalWorkflow.g:279:2: (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    switch ( input.LA(3) ) {
                    case 50:
                        {
                        alt5=2;
                        }
                        break;
                    case 43:
                    case 44:
                        {
                        alt5=1;
                        }
                        break;
                    case 53:
                        {
                        alt5=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }

                    }
                    break;
                case 53:
                    {
                    alt5=3;
                    }
                    break;
                case 50:
                    {
                    alt5=2;
                    }
                    break;
                case 43:
                case 44:
                    {
                    alt5=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

                }
                break;
            case 19:
                {
                switch ( input.LA(2) ) {
                case 50:
                    {
                    alt5=2;
                    }
                    break;
                case 43:
                case 44:
                    {
                    alt5=1;
                    }
                    break;
                case 53:
                    {
                    alt5=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }

                }
                break;
            case 43:
            case 44:
                {
                alt5=1;
                }
                break;
            case 50:
                {
                alt5=2;
                }
                break;
            case 53:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalWorkflow.g:280:3: this_Categorical_0= ruleCategorical
                    {

                    			newCompositeNode(grammarAccess.getDataFieldAccess().getCategoricalParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Categorical_0=ruleCategorical();

                    state._fsp--;


                    			current = this_Categorical_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:289:3: this_Continuous_1= ruleContinuous
                    {

                    			newCompositeNode(grammarAccess.getDataFieldAccess().getContinuousParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Continuous_1=ruleContinuous();

                    state._fsp--;


                    			current = this_Continuous_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:298:3: this_Date_2= ruleDate
                    {

                    			newCompositeNode(grammarAccess.getDataFieldAccess().getDateParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Date_2=ruleDate();

                    state._fsp--;


                    			current = this_Date_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataField"


    // $ANTLR start "entryRuleParameter"
    // InternalWorkflow.g:310:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalWorkflow.g:310:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalWorkflow.g:311:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalWorkflow.g:317:1: ruleParameter returns [EObject current=null] : (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_Range_4= ruleRange | this_SpecialValues_5= ruleSpecialValues | this_DiscretizeBin_6= ruleDiscretizeBin | this_CastType_7= ruleCastType | this_DerivedValue_8= ruleDerivedValue | this_NumOp_9= ruleNumOp | this_FixValue_10= ruleFixValue | this_FieldRange_11= ruleFieldRange | this_MathOp_12= ruleMathOp | this_Field_13= ruleField | this_Join_14= ruleJoin | this_DateRange_15= ruleDateRange ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_Map_0 = null;

        EObject this_Primitive_1 = null;

        EObject this_DerivedField_2 = null;

        EObject this_FilterValue_3 = null;

        EObject this_Range_4 = null;

        EObject this_SpecialValues_5 = null;

        EObject this_DiscretizeBin_6 = null;

        EObject this_CastType_7 = null;

        EObject this_DerivedValue_8 = null;

        EObject this_NumOp_9 = null;

        EObject this_FixValue_10 = null;

        EObject this_FieldRange_11 = null;

        EObject this_MathOp_12 = null;

        EObject this_Field_13 = null;

        EObject this_Join_14 = null;

        EObject this_DateRange_15 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:323:2: ( (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_Range_4= ruleRange | this_SpecialValues_5= ruleSpecialValues | this_DiscretizeBin_6= ruleDiscretizeBin | this_CastType_7= ruleCastType | this_DerivedValue_8= ruleDerivedValue | this_NumOp_9= ruleNumOp | this_FixValue_10= ruleFixValue | this_FieldRange_11= ruleFieldRange | this_MathOp_12= ruleMathOp | this_Field_13= ruleField | this_Join_14= ruleJoin | this_DateRange_15= ruleDateRange ) )
            // InternalWorkflow.g:324:2: (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_Range_4= ruleRange | this_SpecialValues_5= ruleSpecialValues | this_DiscretizeBin_6= ruleDiscretizeBin | this_CastType_7= ruleCastType | this_DerivedValue_8= ruleDerivedValue | this_NumOp_9= ruleNumOp | this_FixValue_10= ruleFixValue | this_FieldRange_11= ruleFieldRange | this_MathOp_12= ruleMathOp | this_Field_13= ruleField | this_Join_14= ruleJoin | this_DateRange_15= ruleDateRange )
            {
            // InternalWorkflow.g:324:2: (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_Range_4= ruleRange | this_SpecialValues_5= ruleSpecialValues | this_DiscretizeBin_6= ruleDiscretizeBin | this_CastType_7= ruleCastType | this_DerivedValue_8= ruleDerivedValue | this_NumOp_9= ruleNumOp | this_FixValue_10= ruleFixValue | this_FieldRange_11= ruleFieldRange | this_MathOp_12= ruleMathOp | this_Field_13= ruleField | this_Join_14= ruleJoin | this_DateRange_15= ruleDateRange )
            int alt6=16;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt6=1;
                }
                break;
            case 73:
                {
                alt6=2;
                }
                break;
            case 74:
                {
                alt6=3;
                }
                break;
            case 76:
                {
                alt6=4;
                }
                break;
            case 80:
            case 81:
            case 82:
                {
                alt6=5;
                }
                break;
            case 85:
                {
                alt6=6;
                }
                break;
            case 87:
                {
                alt6=7;
                }
                break;
            case 89:
                {
                alt6=8;
                }
                break;
            case 91:
                {
                alt6=9;
                }
                break;
            case 93:
                {
                alt6=10;
                }
                break;
            case 95:
                {
                alt6=11;
                }
                break;
            case 98:
                {
                alt6=12;
                }
                break;
            case 101:
                {
                alt6=13;
                }
                break;
            case 103:
                {
                alt6=14;
                }
                break;
            case 104:
                {
                alt6=15;
                }
                break;
            case 105:
                {
                alt6=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalWorkflow.g:325:3: this_Map_0= ruleMap
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getMapParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Map_0=ruleMap();

                    state._fsp--;


                    			current = this_Map_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:334:3: this_Primitive_1= rulePrimitive
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Primitive_1=rulePrimitive();

                    state._fsp--;


                    			current = this_Primitive_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:343:3: this_DerivedField_2= ruleDerivedField
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getDerivedFieldParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DerivedField_2=ruleDerivedField();

                    state._fsp--;


                    			current = this_DerivedField_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:352:3: this_FilterValue_3= ruleFilterValue
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getFilterValueParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_FilterValue_3=ruleFilterValue();

                    state._fsp--;


                    			current = this_FilterValue_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:361:3: this_Range_4= ruleRange
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getRangeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Range_4=ruleRange();

                    state._fsp--;


                    			current = this_Range_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:370:3: this_SpecialValues_5= ruleSpecialValues
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getSpecialValuesParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecialValues_5=ruleSpecialValues();

                    state._fsp--;


                    			current = this_SpecialValues_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalWorkflow.g:379:3: this_DiscretizeBin_6= ruleDiscretizeBin
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getDiscretizeBinParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_DiscretizeBin_6=ruleDiscretizeBin();

                    state._fsp--;


                    			current = this_DiscretizeBin_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalWorkflow.g:388:3: this_CastType_7= ruleCastType
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getCastTypeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_CastType_7=ruleCastType();

                    state._fsp--;


                    			current = this_CastType_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalWorkflow.g:397:3: this_DerivedValue_8= ruleDerivedValue
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getDerivedValueParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_DerivedValue_8=ruleDerivedValue();

                    state._fsp--;


                    			current = this_DerivedValue_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalWorkflow.g:406:3: this_NumOp_9= ruleNumOp
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getNumOpParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumOp_9=ruleNumOp();

                    state._fsp--;


                    			current = this_NumOp_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalWorkflow.g:415:3: this_FixValue_10= ruleFixValue
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getFixValueParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixValue_10=ruleFixValue();

                    state._fsp--;


                    			current = this_FixValue_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalWorkflow.g:424:3: this_FieldRange_11= ruleFieldRange
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getFieldRangeParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldRange_11=ruleFieldRange();

                    state._fsp--;


                    			current = this_FieldRange_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalWorkflow.g:433:3: this_MathOp_12= ruleMathOp
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getMathOpParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathOp_12=ruleMathOp();

                    state._fsp--;


                    			current = this_MathOp_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalWorkflow.g:442:3: this_Field_13= ruleField
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getFieldParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_Field_13=ruleField();

                    state._fsp--;


                    			current = this_Field_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalWorkflow.g:451:3: this_Join_14= ruleJoin
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getJoinParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_Join_14=ruleJoin();

                    state._fsp--;


                    			current = this_Join_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalWorkflow.g:460:3: this_DateRange_15= ruleDateRange
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getDateRangeParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateRange_15=ruleDateRange();

                    state._fsp--;


                    			current = this_DateRange_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleMatchingValue"
    // InternalWorkflow.g:472:1: entryRuleMatchingValue returns [EObject current=null] : iv_ruleMatchingValue= ruleMatchingValue EOF ;
    public final EObject entryRuleMatchingValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatchingValue = null;


        try {
            // InternalWorkflow.g:472:54: (iv_ruleMatchingValue= ruleMatchingValue EOF )
            // InternalWorkflow.g:473:2: iv_ruleMatchingValue= ruleMatchingValue EOF
            {
             newCompositeNode(grammarAccess.getMatchingValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMatchingValue=ruleMatchingValue();

            state._fsp--;

             current =iv_ruleMatchingValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMatchingValue"


    // $ANTLR start "ruleMatchingValue"
    // InternalWorkflow.g:479:1: ruleMatchingValue returns [EObject current=null] : (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange ) ;
    public final EObject ruleMatchingValue() throws RecognitionException {
        EObject current = null;

        EObject this_Range_0 = null;

        EObject this_SpecialValues_1 = null;

        EObject this_DateRange_2 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:485:2: ( (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange ) )
            // InternalWorkflow.g:486:2: (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange )
            {
            // InternalWorkflow.g:486:2: (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 80:
            case 81:
            case 82:
                {
                alt7=1;
                }
                break;
            case 85:
                {
                alt7=2;
                }
                break;
            case 105:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalWorkflow.g:487:3: this_Range_0= ruleRange
                    {

                    			newCompositeNode(grammarAccess.getMatchingValueAccess().getRangeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Range_0=ruleRange();

                    state._fsp--;


                    			current = this_Range_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:496:3: this_SpecialValues_1= ruleSpecialValues
                    {

                    			newCompositeNode(grammarAccess.getMatchingValueAccess().getSpecialValuesParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecialValues_1=ruleSpecialValues();

                    state._fsp--;


                    			current = this_SpecialValues_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:505:3: this_DateRange_2= ruleDateRange
                    {

                    			newCompositeNode(grammarAccess.getMatchingValueAccess().getDateRangeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateRange_2=ruleDateRange();

                    state._fsp--;


                    			current = this_DateRange_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMatchingValue"


    // $ANTLR start "entryRuleOperand"
    // InternalWorkflow.g:517:1: entryRuleOperand returns [EObject current=null] : iv_ruleOperand= ruleOperand EOF ;
    public final EObject entryRuleOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperand = null;


        try {
            // InternalWorkflow.g:517:48: (iv_ruleOperand= ruleOperand EOF )
            // InternalWorkflow.g:518:2: iv_ruleOperand= ruleOperand EOF
            {
             newCompositeNode(grammarAccess.getOperandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperand=ruleOperand();

            state._fsp--;

             current =iv_ruleOperand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperand"


    // $ANTLR start "ruleOperand"
    // InternalWorkflow.g:524:1: ruleOperand returns [EObject current=null] : (this_FixValue_0= ruleFixValue | this_Field_1= ruleField ) ;
    public final EObject ruleOperand() throws RecognitionException {
        EObject current = null;

        EObject this_FixValue_0 = null;

        EObject this_Field_1 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:530:2: ( (this_FixValue_0= ruleFixValue | this_Field_1= ruleField ) )
            // InternalWorkflow.g:531:2: (this_FixValue_0= ruleFixValue | this_Field_1= ruleField )
            {
            // InternalWorkflow.g:531:2: (this_FixValue_0= ruleFixValue | this_Field_1= ruleField )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==95) ) {
                alt8=1;
            }
            else if ( (LA8_0==103) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalWorkflow.g:532:3: this_FixValue_0= ruleFixValue
                    {

                    			newCompositeNode(grammarAccess.getOperandAccess().getFixValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixValue_0=ruleFixValue();

                    state._fsp--;


                    			current = this_FixValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:541:3: this_Field_1= ruleField
                    {

                    			newCompositeNode(grammarAccess.getOperandAccess().getFieldParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Field_1=ruleField();

                    state._fsp--;


                    			current = this_Field_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperand"


    // $ANTLR start "entryRuleEString"
    // InternalWorkflow.g:553:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalWorkflow.g:553:47: (iv_ruleEString= ruleEString EOF )
            // InternalWorkflow.g:554:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalWorkflow.g:560:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:566:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalWorkflow.g:567:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalWorkflow.g:567:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalWorkflow.g:568:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:576:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleLink"
    // InternalWorkflow.g:587:1: entryRuleLink returns [EObject current=null] : iv_ruleLink= ruleLink EOF ;
    public final EObject entryRuleLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLink = null;


        try {
            // InternalWorkflow.g:587:45: (iv_ruleLink= ruleLink EOF )
            // InternalWorkflow.g:588:2: iv_ruleLink= ruleLink EOF
            {
             newCompositeNode(grammarAccess.getLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLink=ruleLink();

            state._fsp--;

             current =iv_ruleLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLink"


    // $ANTLR start "ruleLink"
    // InternalWorkflow.g:594:1: ruleLink returns [EObject current=null] : (otherlv_0= 'Link' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'source' ( ( ruleEString ) ) otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= '}' ) ;
    public final EObject ruleLink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:600:2: ( (otherlv_0= 'Link' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'source' ( ( ruleEString ) ) otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:601:2: (otherlv_0= 'Link' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'source' ( ( ruleEString ) ) otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:601:2: (otherlv_0= 'Link' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'source' ( ( ruleEString ) ) otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= '}' )
            // InternalWorkflow.g:602:3: otherlv_0= 'Link' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'source' ( ( ruleEString ) ) otherlv_5= 'target' ( ( ruleEString ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLinkAccess().getLinkKeyword_0());
            		
            // InternalWorkflow.g:606:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:607:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:607:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:608:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLinkAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLinkRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getLinkAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getLinkAccess().getSourceKeyword_3());
            		
            // InternalWorkflow.g:633:3: ( ( ruleEString ) )
            // InternalWorkflow.g:634:4: ( ruleEString )
            {
            // InternalWorkflow.g:634:4: ( ruleEString )
            // InternalWorkflow.g:635:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLinkAccess().getSourceProcessingStepCrossReference_4_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getLinkAccess().getTargetKeyword_5());
            		
            // InternalWorkflow.g:653:3: ( ( ruleEString ) )
            // InternalWorkflow.g:654:4: ( ruleEString )
            {
            // InternalWorkflow.g:654:4: ( ruleEString )
            // InternalWorkflow.g:655:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLinkAccess().getTargetProcessingStepCrossReference_6_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLinkAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLink"


    // $ANTLR start "entryRuleDataDictionary"
    // InternalWorkflow.g:677:1: entryRuleDataDictionary returns [EObject current=null] : iv_ruleDataDictionary= ruleDataDictionary EOF ;
    public final EObject entryRuleDataDictionary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDictionary = null;


        try {
            // InternalWorkflow.g:677:55: (iv_ruleDataDictionary= ruleDataDictionary EOF )
            // InternalWorkflow.g:678:2: iv_ruleDataDictionary= ruleDataDictionary EOF
            {
             newCompositeNode(grammarAccess.getDataDictionaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataDictionary=ruleDataDictionary();

            state._fsp--;

             current =iv_ruleDataDictionary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataDictionary"


    // $ANTLR start "ruleDataDictionary"
    // InternalWorkflow.g:684:1: ruleDataDictionary returns [EObject current=null] : ( () otherlv_1= 'DataDictionary' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'fileName' ( (lv_fileName_5_0= ruleEString ) ) )? (otherlv_6= 'in' ( ( ruleEString ) ) )? (otherlv_8= 'out' ( ( ruleEString ) ) )? (otherlv_10= 'datafield' otherlv_11= '{' ( (lv_datafield_12_0= ruleDataField ) ) (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )* otherlv_15= '}' )? otherlv_16= '}' ) ;
    public final EObject ruleDataDictionary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_fileName_5_0 = null;

        EObject lv_datafield_12_0 = null;

        EObject lv_datafield_14_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:690:2: ( ( () otherlv_1= 'DataDictionary' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'fileName' ( (lv_fileName_5_0= ruleEString ) ) )? (otherlv_6= 'in' ( ( ruleEString ) ) )? (otherlv_8= 'out' ( ( ruleEString ) ) )? (otherlv_10= 'datafield' otherlv_11= '{' ( (lv_datafield_12_0= ruleDataField ) ) (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )* otherlv_15= '}' )? otherlv_16= '}' ) )
            // InternalWorkflow.g:691:2: ( () otherlv_1= 'DataDictionary' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'fileName' ( (lv_fileName_5_0= ruleEString ) ) )? (otherlv_6= 'in' ( ( ruleEString ) ) )? (otherlv_8= 'out' ( ( ruleEString ) ) )? (otherlv_10= 'datafield' otherlv_11= '{' ( (lv_datafield_12_0= ruleDataField ) ) (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )* otherlv_15= '}' )? otherlv_16= '}' )
            {
            // InternalWorkflow.g:691:2: ( () otherlv_1= 'DataDictionary' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'fileName' ( (lv_fileName_5_0= ruleEString ) ) )? (otherlv_6= 'in' ( ( ruleEString ) ) )? (otherlv_8= 'out' ( ( ruleEString ) ) )? (otherlv_10= 'datafield' otherlv_11= '{' ( (lv_datafield_12_0= ruleDataField ) ) (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )* otherlv_15= '}' )? otherlv_16= '}' )
            // InternalWorkflow.g:692:3: () otherlv_1= 'DataDictionary' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'fileName' ( (lv_fileName_5_0= ruleEString ) ) )? (otherlv_6= 'in' ( ( ruleEString ) ) )? (otherlv_8= 'out' ( ( ruleEString ) ) )? (otherlv_10= 'datafield' otherlv_11= '{' ( (lv_datafield_12_0= ruleDataField ) ) (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )* otherlv_15= '}' )? otherlv_16= '}'
            {
            // InternalWorkflow.g:692:3: ()
            // InternalWorkflow.g:693:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataDictionaryAccess().getDataDictionaryAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDataDictionaryAccess().getDataDictionaryKeyword_1());
            		
            // InternalWorkflow.g:703:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:704:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:704:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:705:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataDictionaryAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataDictionaryRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getDataDictionaryAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:726:3: (otherlv_4= 'fileName' ( (lv_fileName_5_0= ruleEString ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalWorkflow.g:727:4: otherlv_4= 'fileName' ( (lv_fileName_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getDataDictionaryAccess().getFileNameKeyword_4_0());
                    			
                    // InternalWorkflow.g:731:4: ( (lv_fileName_5_0= ruleEString ) )
                    // InternalWorkflow.g:732:5: (lv_fileName_5_0= ruleEString )
                    {
                    // InternalWorkflow.g:732:5: (lv_fileName_5_0= ruleEString )
                    // InternalWorkflow.g:733:6: lv_fileName_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDataDictionaryAccess().getFileNameEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_fileName_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataDictionaryRule());
                    						}
                    						set(
                    							current,
                    							"fileName",
                    							lv_fileName_5_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:751:3: (otherlv_6= 'in' ( ( ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalWorkflow.g:752:4: otherlv_6= 'in' ( ( ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataDictionaryAccess().getInKeyword_5_0());
                    			
                    // InternalWorkflow.g:756:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:757:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:757:5: ( ruleEString )
                    // InternalWorkflow.g:758:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataDictionaryRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataDictionaryAccess().getInDataDictionaryCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:773:3: (otherlv_8= 'out' ( ( ruleEString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalWorkflow.g:774:4: otherlv_8= 'out' ( ( ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataDictionaryAccess().getOutKeyword_6_0());
                    			
                    // InternalWorkflow.g:778:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:779:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:779:5: ( ruleEString )
                    // InternalWorkflow.g:780:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataDictionaryRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataDictionaryAccess().getOutDataDictionaryCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:795:3: (otherlv_10= 'datafield' otherlv_11= '{' ( (lv_datafield_12_0= ruleDataField ) ) (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )* otherlv_15= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==24) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalWorkflow.g:796:4: otherlv_10= 'datafield' otherlv_11= '{' ( (lv_datafield_12_0= ruleDataField ) ) (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )* otherlv_15= '}'
                    {
                    otherlv_10=(Token)match(input,24,FOLLOW_4); 

                    				newLeafNode(otherlv_10, grammarAccess.getDataDictionaryAccess().getDatafieldKeyword_7_0());
                    			
                    otherlv_11=(Token)match(input,12,FOLLOW_17); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataDictionaryAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalWorkflow.g:804:4: ( (lv_datafield_12_0= ruleDataField ) )
                    // InternalWorkflow.g:805:5: (lv_datafield_12_0= ruleDataField )
                    {
                    // InternalWorkflow.g:805:5: (lv_datafield_12_0= ruleDataField )
                    // InternalWorkflow.g:806:6: lv_datafield_12_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getDataDictionaryAccess().getDatafieldDataFieldParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_datafield_12_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataDictionaryRule());
                    						}
                    						add(
                    							current,
                    							"datafield",
                    							lv_datafield_12_0,
                    							"xtext.Workflow.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:823:4: (otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==14) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalWorkflow.g:824:5: otherlv_13= ',' ( (lv_datafield_14_0= ruleDataField ) )
                    	    {
                    	    otherlv_13=(Token)match(input,14,FOLLOW_17); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getDataDictionaryAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalWorkflow.g:828:5: ( (lv_datafield_14_0= ruleDataField ) )
                    	    // InternalWorkflow.g:829:6: (lv_datafield_14_0= ruleDataField )
                    	    {
                    	    // InternalWorkflow.g:829:6: (lv_datafield_14_0= ruleDataField )
                    	    // InternalWorkflow.g:830:7: lv_datafield_14_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataDictionaryAccess().getDatafieldDataFieldParserRuleCall_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_datafield_14_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataDictionaryRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"datafield",
                    	    								lv_datafield_14_0,
                    	    								"xtext.Workflow.DataField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_15, grammarAccess.getDataDictionaryAccess().getRightCurlyBracketKeyword_7_4());
                    			

                    }
                    break;

            }

            otherlv_16=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getDataDictionaryAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataDictionary"


    // $ANTLR start "entryRulePMMLModel"
    // InternalWorkflow.g:861:1: entryRulePMMLModel returns [EObject current=null] : iv_rulePMMLModel= rulePMMLModel EOF ;
    public final EObject entryRulePMMLModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePMMLModel = null;


        try {
            // InternalWorkflow.g:861:50: (iv_rulePMMLModel= rulePMMLModel EOF )
            // InternalWorkflow.g:862:2: iv_rulePMMLModel= rulePMMLModel EOF
            {
             newCompositeNode(grammarAccess.getPMMLModelRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePMMLModel=rulePMMLModel();

            state._fsp--;

             current =iv_rulePMMLModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePMMLModel"


    // $ANTLR start "rulePMMLModel"
    // InternalWorkflow.g:868:1: rulePMMLModel returns [EObject current=null] : ( ( (lv_onlyPredictions_0_0= 'onlyPredictions' ) )? otherlv_1= 'PMMLModel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'origin_function' ( (lv_origin_function_5_0= ruleEString ) ) )? (otherlv_6= 'filePath' ( (lv_filePath_7_0= ruleEString ) ) )? (otherlv_8= 'outgoing' ( ( ruleEString ) ) )? (otherlv_10= 'incoming' ( ( ruleEString ) ) )? otherlv_12= 'in' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' otherlv_18= 'out' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' otherlv_24= 'inputPort' otherlv_25= '{' ( (lv_inputPort_26_0= ruleDataDictionary ) ) (otherlv_27= ',' ( (lv_inputPort_28_0= ruleDataDictionary ) ) )* otherlv_29= '}' otherlv_30= 'outputPort' otherlv_31= '{' ( (lv_outputPort_32_0= ruleDataDictionary ) ) (otherlv_33= ',' ( (lv_outputPort_34_0= ruleDataDictionary ) ) )* otherlv_35= '}' (otherlv_36= 'test' ( (lv_test_37_0= ruleTest ) ) )? otherlv_38= '}' ) ;
    public final EObject rulePMMLModel() throws RecognitionException {
        EObject current = null;

        Token lv_onlyPredictions_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_origin_function_5_0 = null;

        AntlrDatatypeRuleToken lv_filePath_7_0 = null;

        EObject lv_inputPort_26_0 = null;

        EObject lv_inputPort_28_0 = null;

        EObject lv_outputPort_32_0 = null;

        EObject lv_outputPort_34_0 = null;

        EObject lv_test_37_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:874:2: ( ( ( (lv_onlyPredictions_0_0= 'onlyPredictions' ) )? otherlv_1= 'PMMLModel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'origin_function' ( (lv_origin_function_5_0= ruleEString ) ) )? (otherlv_6= 'filePath' ( (lv_filePath_7_0= ruleEString ) ) )? (otherlv_8= 'outgoing' ( ( ruleEString ) ) )? (otherlv_10= 'incoming' ( ( ruleEString ) ) )? otherlv_12= 'in' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' otherlv_18= 'out' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' otherlv_24= 'inputPort' otherlv_25= '{' ( (lv_inputPort_26_0= ruleDataDictionary ) ) (otherlv_27= ',' ( (lv_inputPort_28_0= ruleDataDictionary ) ) )* otherlv_29= '}' otherlv_30= 'outputPort' otherlv_31= '{' ( (lv_outputPort_32_0= ruleDataDictionary ) ) (otherlv_33= ',' ( (lv_outputPort_34_0= ruleDataDictionary ) ) )* otherlv_35= '}' (otherlv_36= 'test' ( (lv_test_37_0= ruleTest ) ) )? otherlv_38= '}' ) )
            // InternalWorkflow.g:875:2: ( ( (lv_onlyPredictions_0_0= 'onlyPredictions' ) )? otherlv_1= 'PMMLModel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'origin_function' ( (lv_origin_function_5_0= ruleEString ) ) )? (otherlv_6= 'filePath' ( (lv_filePath_7_0= ruleEString ) ) )? (otherlv_8= 'outgoing' ( ( ruleEString ) ) )? (otherlv_10= 'incoming' ( ( ruleEString ) ) )? otherlv_12= 'in' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' otherlv_18= 'out' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' otherlv_24= 'inputPort' otherlv_25= '{' ( (lv_inputPort_26_0= ruleDataDictionary ) ) (otherlv_27= ',' ( (lv_inputPort_28_0= ruleDataDictionary ) ) )* otherlv_29= '}' otherlv_30= 'outputPort' otherlv_31= '{' ( (lv_outputPort_32_0= ruleDataDictionary ) ) (otherlv_33= ',' ( (lv_outputPort_34_0= ruleDataDictionary ) ) )* otherlv_35= '}' (otherlv_36= 'test' ( (lv_test_37_0= ruleTest ) ) )? otherlv_38= '}' )
            {
            // InternalWorkflow.g:875:2: ( ( (lv_onlyPredictions_0_0= 'onlyPredictions' ) )? otherlv_1= 'PMMLModel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'origin_function' ( (lv_origin_function_5_0= ruleEString ) ) )? (otherlv_6= 'filePath' ( (lv_filePath_7_0= ruleEString ) ) )? (otherlv_8= 'outgoing' ( ( ruleEString ) ) )? (otherlv_10= 'incoming' ( ( ruleEString ) ) )? otherlv_12= 'in' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' otherlv_18= 'out' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' otherlv_24= 'inputPort' otherlv_25= '{' ( (lv_inputPort_26_0= ruleDataDictionary ) ) (otherlv_27= ',' ( (lv_inputPort_28_0= ruleDataDictionary ) ) )* otherlv_29= '}' otherlv_30= 'outputPort' otherlv_31= '{' ( (lv_outputPort_32_0= ruleDataDictionary ) ) (otherlv_33= ',' ( (lv_outputPort_34_0= ruleDataDictionary ) ) )* otherlv_35= '}' (otherlv_36= 'test' ( (lv_test_37_0= ruleTest ) ) )? otherlv_38= '}' )
            // InternalWorkflow.g:876:3: ( (lv_onlyPredictions_0_0= 'onlyPredictions' ) )? otherlv_1= 'PMMLModel' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'origin_function' ( (lv_origin_function_5_0= ruleEString ) ) )? (otherlv_6= 'filePath' ( (lv_filePath_7_0= ruleEString ) ) )? (otherlv_8= 'outgoing' ( ( ruleEString ) ) )? (otherlv_10= 'incoming' ( ( ruleEString ) ) )? otherlv_12= 'in' otherlv_13= '(' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* otherlv_17= ')' otherlv_18= 'out' otherlv_19= '(' ( ( ruleEString ) ) (otherlv_21= ',' ( ( ruleEString ) ) )* otherlv_23= ')' otherlv_24= 'inputPort' otherlv_25= '{' ( (lv_inputPort_26_0= ruleDataDictionary ) ) (otherlv_27= ',' ( (lv_inputPort_28_0= ruleDataDictionary ) ) )* otherlv_29= '}' otherlv_30= 'outputPort' otherlv_31= '{' ( (lv_outputPort_32_0= ruleDataDictionary ) ) (otherlv_33= ',' ( (lv_outputPort_34_0= ruleDataDictionary ) ) )* otherlv_35= '}' (otherlv_36= 'test' ( (lv_test_37_0= ruleTest ) ) )? otherlv_38= '}'
            {
            // InternalWorkflow.g:876:3: ( (lv_onlyPredictions_0_0= 'onlyPredictions' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalWorkflow.g:877:4: (lv_onlyPredictions_0_0= 'onlyPredictions' )
                    {
                    // InternalWorkflow.g:877:4: (lv_onlyPredictions_0_0= 'onlyPredictions' )
                    // InternalWorkflow.g:878:5: lv_onlyPredictions_0_0= 'onlyPredictions'
                    {
                    lv_onlyPredictions_0_0=(Token)match(input,25,FOLLOW_18); 

                    					newLeafNode(lv_onlyPredictions_0_0, grammarAccess.getPMMLModelAccess().getOnlyPredictionsOnlyPredictionsKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPMMLModelRule());
                    					}
                    					setWithLastConsumed(current, "onlyPredictions", lv_onlyPredictions_0_0 != null, "onlyPredictions");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPMMLModelAccess().getPMMLModelKeyword_1());
            		
            // InternalWorkflow.g:894:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:895:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:895:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:896:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPMMLModelAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:917:3: (otherlv_4= 'origin_function' ( (lv_origin_function_5_0= ruleEString ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalWorkflow.g:918:4: otherlv_4= 'origin_function' ( (lv_origin_function_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getPMMLModelAccess().getOrigin_functionKeyword_4_0());
                    			
                    // InternalWorkflow.g:922:4: ( (lv_origin_function_5_0= ruleEString ) )
                    // InternalWorkflow.g:923:5: (lv_origin_function_5_0= ruleEString )
                    {
                    // InternalWorkflow.g:923:5: (lv_origin_function_5_0= ruleEString )
                    // InternalWorkflow.g:924:6: lv_origin_function_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPMMLModelAccess().getOrigin_functionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_origin_function_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPMMLModelRule());
                    						}
                    						set(
                    							current,
                    							"origin_function",
                    							lv_origin_function_5_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:942:3: (otherlv_6= 'filePath' ( (lv_filePath_7_0= ruleEString ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalWorkflow.g:943:4: otherlv_6= 'filePath' ( (lv_filePath_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getPMMLModelAccess().getFilePathKeyword_5_0());
                    			
                    // InternalWorkflow.g:947:4: ( (lv_filePath_7_0= ruleEString ) )
                    // InternalWorkflow.g:948:5: (lv_filePath_7_0= ruleEString )
                    {
                    // InternalWorkflow.g:948:5: (lv_filePath_7_0= ruleEString )
                    // InternalWorkflow.g:949:6: lv_filePath_7_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPMMLModelAccess().getFilePathEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_filePath_7_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPMMLModelRule());
                    						}
                    						set(
                    							current,
                    							"filePath",
                    							lv_filePath_7_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:967:3: (otherlv_8= 'outgoing' ( ( ruleEString ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalWorkflow.g:968:4: otherlv_8= 'outgoing' ( ( ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,29,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getPMMLModelAccess().getOutgoingKeyword_6_0());
                    			
                    // InternalWorkflow.g:972:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:973:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:973:5: ( ruleEString )
                    // InternalWorkflow.g:974:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPMMLModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPMMLModelAccess().getOutgoingLinkCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:989:3: (otherlv_10= 'incoming' ( ( ruleEString ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalWorkflow.g:990:4: otherlv_10= 'incoming' ( ( ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,30,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getPMMLModelAccess().getIncomingKeyword_7_0());
                    			
                    // InternalWorkflow.g:994:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:995:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:995:5: ( ruleEString )
                    // InternalWorkflow.g:996:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPMMLModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPMMLModelAccess().getIncomingLinkCrossReference_7_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,22,FOLLOW_24); 

            			newLeafNode(otherlv_12, grammarAccess.getPMMLModelAccess().getInKeyword_8());
            		
            otherlv_13=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_13, grammarAccess.getPMMLModelAccess().getLeftParenthesisKeyword_9());
            		
            // InternalWorkflow.g:1019:3: ( ( ruleEString ) )
            // InternalWorkflow.g:1020:4: ( ruleEString )
            {
            // InternalWorkflow.g:1020:4: ( ruleEString )
            // InternalWorkflow.g:1021:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPMMLModelRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPMMLModelAccess().getInArgumentCrossReference_10_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1035:3: (otherlv_15= ',' ( ( ruleEString ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==14) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalWorkflow.g:1036:4: otherlv_15= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_15=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_15, grammarAccess.getPMMLModelAccess().getCommaKeyword_11_0());
            	    			
            	    // InternalWorkflow.g:1040:4: ( ( ruleEString ) )
            	    // InternalWorkflow.g:1041:5: ( ruleEString )
            	    {
            	    // InternalWorkflow.g:1041:5: ( ruleEString )
            	    // InternalWorkflow.g:1042:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getPMMLModelRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getPMMLModelAccess().getInArgumentCrossReference_11_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_17=(Token)match(input,32,FOLLOW_26); 

            			newLeafNode(otherlv_17, grammarAccess.getPMMLModelAccess().getRightParenthesisKeyword_12());
            		
            otherlv_18=(Token)match(input,23,FOLLOW_24); 

            			newLeafNode(otherlv_18, grammarAccess.getPMMLModelAccess().getOutKeyword_13());
            		
            otherlv_19=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_19, grammarAccess.getPMMLModelAccess().getLeftParenthesisKeyword_14());
            		
            // InternalWorkflow.g:1069:3: ( ( ruleEString ) )
            // InternalWorkflow.g:1070:4: ( ruleEString )
            {
            // InternalWorkflow.g:1070:4: ( ruleEString )
            // InternalWorkflow.g:1071:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPMMLModelRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPMMLModelAccess().getOutArgumentCrossReference_15_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1085:3: (otherlv_21= ',' ( ( ruleEString ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==14) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalWorkflow.g:1086:4: otherlv_21= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_21=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_21, grammarAccess.getPMMLModelAccess().getCommaKeyword_16_0());
            	    			
            	    // InternalWorkflow.g:1090:4: ( ( ruleEString ) )
            	    // InternalWorkflow.g:1091:5: ( ruleEString )
            	    {
            	    // InternalWorkflow.g:1091:5: ( ruleEString )
            	    // InternalWorkflow.g:1092:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getPMMLModelRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getPMMLModelAccess().getOutArgumentCrossReference_16_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_23=(Token)match(input,32,FOLLOW_27); 

            			newLeafNode(otherlv_23, grammarAccess.getPMMLModelAccess().getRightParenthesisKeyword_17());
            		
            otherlv_24=(Token)match(input,33,FOLLOW_4); 

            			newLeafNode(otherlv_24, grammarAccess.getPMMLModelAccess().getInputPortKeyword_18());
            		
            otherlv_25=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_25, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_19());
            		
            // InternalWorkflow.g:1119:3: ( (lv_inputPort_26_0= ruleDataDictionary ) )
            // InternalWorkflow.g:1120:4: (lv_inputPort_26_0= ruleDataDictionary )
            {
            // InternalWorkflow.g:1120:4: (lv_inputPort_26_0= ruleDataDictionary )
            // InternalWorkflow.g:1121:5: lv_inputPort_26_0= ruleDataDictionary
            {

            					newCompositeNode(grammarAccess.getPMMLModelAccess().getInputPortDataDictionaryParserRuleCall_20_0());
            				
            pushFollow(FOLLOW_7);
            lv_inputPort_26_0=ruleDataDictionary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            					}
            					add(
            						current,
            						"inputPort",
            						lv_inputPort_26_0,
            						"xtext.Workflow.DataDictionary");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1138:3: (otherlv_27= ',' ( (lv_inputPort_28_0= ruleDataDictionary ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==14) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalWorkflow.g:1139:4: otherlv_27= ',' ( (lv_inputPort_28_0= ruleDataDictionary ) )
            	    {
            	    otherlv_27=(Token)match(input,14,FOLLOW_28); 

            	    				newLeafNode(otherlv_27, grammarAccess.getPMMLModelAccess().getCommaKeyword_21_0());
            	    			
            	    // InternalWorkflow.g:1143:4: ( (lv_inputPort_28_0= ruleDataDictionary ) )
            	    // InternalWorkflow.g:1144:5: (lv_inputPort_28_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:1144:5: (lv_inputPort_28_0= ruleDataDictionary )
            	    // InternalWorkflow.g:1145:6: lv_inputPort_28_0= ruleDataDictionary
            	    {

            	    						newCompositeNode(grammarAccess.getPMMLModelAccess().getInputPortDataDictionaryParserRuleCall_21_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_inputPort_28_0=ruleDataDictionary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputPort",
            	    							lv_inputPort_28_0,
            	    							"xtext.Workflow.DataDictionary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_29=(Token)match(input,15,FOLLOW_29); 

            			newLeafNode(otherlv_29, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_22());
            		
            otherlv_30=(Token)match(input,34,FOLLOW_4); 

            			newLeafNode(otherlv_30, grammarAccess.getPMMLModelAccess().getOutputPortKeyword_23());
            		
            otherlv_31=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_31, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_24());
            		
            // InternalWorkflow.g:1175:3: ( (lv_outputPort_32_0= ruleDataDictionary ) )
            // InternalWorkflow.g:1176:4: (lv_outputPort_32_0= ruleDataDictionary )
            {
            // InternalWorkflow.g:1176:4: (lv_outputPort_32_0= ruleDataDictionary )
            // InternalWorkflow.g:1177:5: lv_outputPort_32_0= ruleDataDictionary
            {

            					newCompositeNode(grammarAccess.getPMMLModelAccess().getOutputPortDataDictionaryParserRuleCall_25_0());
            				
            pushFollow(FOLLOW_7);
            lv_outputPort_32_0=ruleDataDictionary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            					}
            					add(
            						current,
            						"outputPort",
            						lv_outputPort_32_0,
            						"xtext.Workflow.DataDictionary");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1194:3: (otherlv_33= ',' ( (lv_outputPort_34_0= ruleDataDictionary ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==14) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalWorkflow.g:1195:4: otherlv_33= ',' ( (lv_outputPort_34_0= ruleDataDictionary ) )
            	    {
            	    otherlv_33=(Token)match(input,14,FOLLOW_28); 

            	    				newLeafNode(otherlv_33, grammarAccess.getPMMLModelAccess().getCommaKeyword_26_0());
            	    			
            	    // InternalWorkflow.g:1199:4: ( (lv_outputPort_34_0= ruleDataDictionary ) )
            	    // InternalWorkflow.g:1200:5: (lv_outputPort_34_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:1200:5: (lv_outputPort_34_0= ruleDataDictionary )
            	    // InternalWorkflow.g:1201:6: lv_outputPort_34_0= ruleDataDictionary
            	    {

            	    						newCompositeNode(grammarAccess.getPMMLModelAccess().getOutputPortDataDictionaryParserRuleCall_26_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_outputPort_34_0=ruleDataDictionary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"outputPort",
            	    							lv_outputPort_34_0,
            	    							"xtext.Workflow.DataDictionary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_35=(Token)match(input,15,FOLLOW_30); 

            			newLeafNode(otherlv_35, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_27());
            		
            // InternalWorkflow.g:1223:3: (otherlv_36= 'test' ( (lv_test_37_0= ruleTest ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalWorkflow.g:1224:4: otherlv_36= 'test' ( (lv_test_37_0= ruleTest ) )
                    {
                    otherlv_36=(Token)match(input,35,FOLLOW_31); 

                    				newLeafNode(otherlv_36, grammarAccess.getPMMLModelAccess().getTestKeyword_28_0());
                    			
                    // InternalWorkflow.g:1228:4: ( (lv_test_37_0= ruleTest ) )
                    // InternalWorkflow.g:1229:5: (lv_test_37_0= ruleTest )
                    {
                    // InternalWorkflow.g:1229:5: (lv_test_37_0= ruleTest )
                    // InternalWorkflow.g:1230:6: lv_test_37_0= ruleTest
                    {

                    						newCompositeNode(grammarAccess.getPMMLModelAccess().getTestTestParserRuleCall_28_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_test_37_0=ruleTest();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPMMLModelRule());
                    						}
                    						set(
                    							current,
                    							"test",
                    							lv_test_37_0,
                    							"xtext.Workflow.Test");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_38=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_38, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_29());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePMMLModel"


    // $ANTLR start "entryRuleDataProcessing"
    // InternalWorkflow.g:1256:1: entryRuleDataProcessing returns [EObject current=null] : iv_ruleDataProcessing= ruleDataProcessing EOF ;
    public final EObject entryRuleDataProcessing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataProcessing = null;


        try {
            // InternalWorkflow.g:1256:55: (iv_ruleDataProcessing= ruleDataProcessing EOF )
            // InternalWorkflow.g:1257:2: iv_ruleDataProcessing= ruleDataProcessing EOF
            {
             newCompositeNode(grammarAccess.getDataProcessingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataProcessing=ruleDataProcessing();

            state._fsp--;

             current =iv_ruleDataProcessing; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataProcessing"


    // $ANTLR start "ruleDataProcessing"
    // InternalWorkflow.g:1263:1: ruleDataProcessing returns [EObject current=null] : (otherlv_0= 'DataProcessing' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'origin_function' ( (lv_origin_function_4_0= ruleEString ) ) )? (otherlv_5= 'outgoing' ( ( ruleEString ) ) )? (otherlv_7= 'incoming' ( ( ruleEString ) ) )? otherlv_9= 'in' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'out' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' (otherlv_21= 'initial_accumulated_processing' ( ( ruleEString ) ) )? otherlv_23= 'inputPort' otherlv_24= '{' ( (lv_inputPort_25_0= ruleDataDictionary ) ) (otherlv_26= ',' ( (lv_inputPort_27_0= ruleDataDictionary ) ) )* otherlv_28= '}' otherlv_29= 'outputPort' otherlv_30= '{' ( (lv_outputPort_31_0= ruleDataDictionary ) ) (otherlv_32= ',' ( (lv_outputPort_33_0= ruleDataDictionary ) ) )* otherlv_34= '}' (otherlv_35= 'parameter' otherlv_36= '{' ( (lv_parameter_37_0= ruleParameter ) ) (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )* otherlv_40= '}' )? otherlv_41= '}' ) ;
    public final EObject ruleDataProcessing() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_origin_function_4_0 = null;

        EObject lv_inputPort_25_0 = null;

        EObject lv_inputPort_27_0 = null;

        EObject lv_outputPort_31_0 = null;

        EObject lv_outputPort_33_0 = null;

        EObject lv_parameter_37_0 = null;

        EObject lv_parameter_39_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1269:2: ( (otherlv_0= 'DataProcessing' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'origin_function' ( (lv_origin_function_4_0= ruleEString ) ) )? (otherlv_5= 'outgoing' ( ( ruleEString ) ) )? (otherlv_7= 'incoming' ( ( ruleEString ) ) )? otherlv_9= 'in' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'out' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' (otherlv_21= 'initial_accumulated_processing' ( ( ruleEString ) ) )? otherlv_23= 'inputPort' otherlv_24= '{' ( (lv_inputPort_25_0= ruleDataDictionary ) ) (otherlv_26= ',' ( (lv_inputPort_27_0= ruleDataDictionary ) ) )* otherlv_28= '}' otherlv_29= 'outputPort' otherlv_30= '{' ( (lv_outputPort_31_0= ruleDataDictionary ) ) (otherlv_32= ',' ( (lv_outputPort_33_0= ruleDataDictionary ) ) )* otherlv_34= '}' (otherlv_35= 'parameter' otherlv_36= '{' ( (lv_parameter_37_0= ruleParameter ) ) (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )* otherlv_40= '}' )? otherlv_41= '}' ) )
            // InternalWorkflow.g:1270:2: (otherlv_0= 'DataProcessing' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'origin_function' ( (lv_origin_function_4_0= ruleEString ) ) )? (otherlv_5= 'outgoing' ( ( ruleEString ) ) )? (otherlv_7= 'incoming' ( ( ruleEString ) ) )? otherlv_9= 'in' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'out' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' (otherlv_21= 'initial_accumulated_processing' ( ( ruleEString ) ) )? otherlv_23= 'inputPort' otherlv_24= '{' ( (lv_inputPort_25_0= ruleDataDictionary ) ) (otherlv_26= ',' ( (lv_inputPort_27_0= ruleDataDictionary ) ) )* otherlv_28= '}' otherlv_29= 'outputPort' otherlv_30= '{' ( (lv_outputPort_31_0= ruleDataDictionary ) ) (otherlv_32= ',' ( (lv_outputPort_33_0= ruleDataDictionary ) ) )* otherlv_34= '}' (otherlv_35= 'parameter' otherlv_36= '{' ( (lv_parameter_37_0= ruleParameter ) ) (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )* otherlv_40= '}' )? otherlv_41= '}' )
            {
            // InternalWorkflow.g:1270:2: (otherlv_0= 'DataProcessing' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'origin_function' ( (lv_origin_function_4_0= ruleEString ) ) )? (otherlv_5= 'outgoing' ( ( ruleEString ) ) )? (otherlv_7= 'incoming' ( ( ruleEString ) ) )? otherlv_9= 'in' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'out' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' (otherlv_21= 'initial_accumulated_processing' ( ( ruleEString ) ) )? otherlv_23= 'inputPort' otherlv_24= '{' ( (lv_inputPort_25_0= ruleDataDictionary ) ) (otherlv_26= ',' ( (lv_inputPort_27_0= ruleDataDictionary ) ) )* otherlv_28= '}' otherlv_29= 'outputPort' otherlv_30= '{' ( (lv_outputPort_31_0= ruleDataDictionary ) ) (otherlv_32= ',' ( (lv_outputPort_33_0= ruleDataDictionary ) ) )* otherlv_34= '}' (otherlv_35= 'parameter' otherlv_36= '{' ( (lv_parameter_37_0= ruleParameter ) ) (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )* otherlv_40= '}' )? otherlv_41= '}' )
            // InternalWorkflow.g:1271:3: otherlv_0= 'DataProcessing' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'origin_function' ( (lv_origin_function_4_0= ruleEString ) ) )? (otherlv_5= 'outgoing' ( ( ruleEString ) ) )? (otherlv_7= 'incoming' ( ( ruleEString ) ) )? otherlv_9= 'in' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'out' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' (otherlv_21= 'initial_accumulated_processing' ( ( ruleEString ) ) )? otherlv_23= 'inputPort' otherlv_24= '{' ( (lv_inputPort_25_0= ruleDataDictionary ) ) (otherlv_26= ',' ( (lv_inputPort_27_0= ruleDataDictionary ) ) )* otherlv_28= '}' otherlv_29= 'outputPort' otherlv_30= '{' ( (lv_outputPort_31_0= ruleDataDictionary ) ) (otherlv_32= ',' ( (lv_outputPort_33_0= ruleDataDictionary ) ) )* otherlv_34= '}' (otherlv_35= 'parameter' otherlv_36= '{' ( (lv_parameter_37_0= ruleParameter ) ) (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )* otherlv_40= '}' )? otherlv_41= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDataProcessingAccess().getDataProcessingKeyword_0());
            		
            // InternalWorkflow.g:1275:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:1276:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:1276:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:1277:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataProcessingAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:1298:3: (otherlv_3= 'origin_function' ( (lv_origin_function_4_0= ruleEString ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==27) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalWorkflow.g:1299:4: otherlv_3= 'origin_function' ( (lv_origin_function_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataProcessingAccess().getOrigin_functionKeyword_3_0());
                    			
                    // InternalWorkflow.g:1303:4: ( (lv_origin_function_4_0= ruleEString ) )
                    // InternalWorkflow.g:1304:5: (lv_origin_function_4_0= ruleEString )
                    {
                    // InternalWorkflow.g:1304:5: (lv_origin_function_4_0= ruleEString )
                    // InternalWorkflow.g:1305:6: lv_origin_function_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDataProcessingAccess().getOrigin_functionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_origin_function_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataProcessingRule());
                    						}
                    						set(
                    							current,
                    							"origin_function",
                    							lv_origin_function_4_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1323:3: (otherlv_5= 'outgoing' ( ( ruleEString ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalWorkflow.g:1324:4: otherlv_5= 'outgoing' ( ( ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,29,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getDataProcessingAccess().getOutgoingKeyword_4_0());
                    			
                    // InternalWorkflow.g:1328:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:1329:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:1329:5: ( ruleEString )
                    // InternalWorkflow.g:1330:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataProcessingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataProcessingAccess().getOutgoingLinkCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1345:3: (otherlv_7= 'incoming' ( ( ruleEString ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==30) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalWorkflow.g:1346:4: otherlv_7= 'incoming' ( ( ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataProcessingAccess().getIncomingKeyword_5_0());
                    			
                    // InternalWorkflow.g:1350:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:1351:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:1351:5: ( ruleEString )
                    // InternalWorkflow.g:1352:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataProcessingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataProcessingAccess().getIncomingLinkCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,22,FOLLOW_24); 

            			newLeafNode(otherlv_9, grammarAccess.getDataProcessingAccess().getInKeyword_6());
            		
            otherlv_10=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_10, grammarAccess.getDataProcessingAccess().getLeftParenthesisKeyword_7());
            		
            // InternalWorkflow.g:1375:3: ( ( ruleEString ) )
            // InternalWorkflow.g:1376:4: ( ruleEString )
            {
            // InternalWorkflow.g:1376:4: ( ruleEString )
            // InternalWorkflow.g:1377:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataProcessingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDataProcessingAccess().getInArgumentCrossReference_8_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1391:3: (otherlv_12= ',' ( ( ruleEString ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==14) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalWorkflow.g:1392:4: otherlv_12= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_12=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_12, grammarAccess.getDataProcessingAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalWorkflow.g:1396:4: ( ( ruleEString ) )
            	    // InternalWorkflow.g:1397:5: ( ruleEString )
            	    {
            	    // InternalWorkflow.g:1397:5: ( ruleEString )
            	    // InternalWorkflow.g:1398:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDataProcessingRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getDataProcessingAccess().getInArgumentCrossReference_9_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_14=(Token)match(input,32,FOLLOW_26); 

            			newLeafNode(otherlv_14, grammarAccess.getDataProcessingAccess().getRightParenthesisKeyword_10());
            		
            otherlv_15=(Token)match(input,23,FOLLOW_24); 

            			newLeafNode(otherlv_15, grammarAccess.getDataProcessingAccess().getOutKeyword_11());
            		
            otherlv_16=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_16, grammarAccess.getDataProcessingAccess().getLeftParenthesisKeyword_12());
            		
            // InternalWorkflow.g:1425:3: ( ( ruleEString ) )
            // InternalWorkflow.g:1426:4: ( ruleEString )
            {
            // InternalWorkflow.g:1426:4: ( ruleEString )
            // InternalWorkflow.g:1427:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataProcessingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDataProcessingAccess().getOutArgumentCrossReference_13_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1441:3: (otherlv_18= ',' ( ( ruleEString ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==14) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalWorkflow.g:1442:4: otherlv_18= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_18=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_18, grammarAccess.getDataProcessingAccess().getCommaKeyword_14_0());
            	    			
            	    // InternalWorkflow.g:1446:4: ( ( ruleEString ) )
            	    // InternalWorkflow.g:1447:5: ( ruleEString )
            	    {
            	    // InternalWorkflow.g:1447:5: ( ruleEString )
            	    // InternalWorkflow.g:1448:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDataProcessingRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getDataProcessingAccess().getOutArgumentCrossReference_14_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            otherlv_20=(Token)match(input,32,FOLLOW_33); 

            			newLeafNode(otherlv_20, grammarAccess.getDataProcessingAccess().getRightParenthesisKeyword_15());
            		
            // InternalWorkflow.g:1467:3: (otherlv_21= 'initial_accumulated_processing' ( ( ruleEString ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==37) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalWorkflow.g:1468:4: otherlv_21= 'initial_accumulated_processing' ( ( ruleEString ) )
                    {
                    otherlv_21=(Token)match(input,37,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getDataProcessingAccess().getInitial_accumulated_processingKeyword_16_0());
                    			
                    // InternalWorkflow.g:1472:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:1473:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:1473:5: ( ruleEString )
                    // InternalWorkflow.g:1474:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataProcessingRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDataProcessingAccess().getInitial_accumulated_processingDataProcessingCrossReference_16_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_23=(Token)match(input,33,FOLLOW_4); 

            			newLeafNode(otherlv_23, grammarAccess.getDataProcessingAccess().getInputPortKeyword_17());
            		
            otherlv_24=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_24, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_18());
            		
            // InternalWorkflow.g:1497:3: ( (lv_inputPort_25_0= ruleDataDictionary ) )
            // InternalWorkflow.g:1498:4: (lv_inputPort_25_0= ruleDataDictionary )
            {
            // InternalWorkflow.g:1498:4: (lv_inputPort_25_0= ruleDataDictionary )
            // InternalWorkflow.g:1499:5: lv_inputPort_25_0= ruleDataDictionary
            {

            					newCompositeNode(grammarAccess.getDataProcessingAccess().getInputPortDataDictionaryParserRuleCall_19_0());
            				
            pushFollow(FOLLOW_7);
            lv_inputPort_25_0=ruleDataDictionary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            					}
            					add(
            						current,
            						"inputPort",
            						lv_inputPort_25_0,
            						"xtext.Workflow.DataDictionary");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1516:3: (otherlv_26= ',' ( (lv_inputPort_27_0= ruleDataDictionary ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==14) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalWorkflow.g:1517:4: otherlv_26= ',' ( (lv_inputPort_27_0= ruleDataDictionary ) )
            	    {
            	    otherlv_26=(Token)match(input,14,FOLLOW_28); 

            	    				newLeafNode(otherlv_26, grammarAccess.getDataProcessingAccess().getCommaKeyword_20_0());
            	    			
            	    // InternalWorkflow.g:1521:4: ( (lv_inputPort_27_0= ruleDataDictionary ) )
            	    // InternalWorkflow.g:1522:5: (lv_inputPort_27_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:1522:5: (lv_inputPort_27_0= ruleDataDictionary )
            	    // InternalWorkflow.g:1523:6: lv_inputPort_27_0= ruleDataDictionary
            	    {

            	    						newCompositeNode(grammarAccess.getDataProcessingAccess().getInputPortDataDictionaryParserRuleCall_20_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_inputPort_27_0=ruleDataDictionary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputPort",
            	    							lv_inputPort_27_0,
            	    							"xtext.Workflow.DataDictionary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_28=(Token)match(input,15,FOLLOW_29); 

            			newLeafNode(otherlv_28, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_21());
            		
            otherlv_29=(Token)match(input,34,FOLLOW_4); 

            			newLeafNode(otherlv_29, grammarAccess.getDataProcessingAccess().getOutputPortKeyword_22());
            		
            otherlv_30=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_30, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_23());
            		
            // InternalWorkflow.g:1553:3: ( (lv_outputPort_31_0= ruleDataDictionary ) )
            // InternalWorkflow.g:1554:4: (lv_outputPort_31_0= ruleDataDictionary )
            {
            // InternalWorkflow.g:1554:4: (lv_outputPort_31_0= ruleDataDictionary )
            // InternalWorkflow.g:1555:5: lv_outputPort_31_0= ruleDataDictionary
            {

            					newCompositeNode(grammarAccess.getDataProcessingAccess().getOutputPortDataDictionaryParserRuleCall_24_0());
            				
            pushFollow(FOLLOW_7);
            lv_outputPort_31_0=ruleDataDictionary();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            					}
            					add(
            						current,
            						"outputPort",
            						lv_outputPort_31_0,
            						"xtext.Workflow.DataDictionary");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:1572:3: (otherlv_32= ',' ( (lv_outputPort_33_0= ruleDataDictionary ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==14) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalWorkflow.g:1573:4: otherlv_32= ',' ( (lv_outputPort_33_0= ruleDataDictionary ) )
            	    {
            	    otherlv_32=(Token)match(input,14,FOLLOW_28); 

            	    				newLeafNode(otherlv_32, grammarAccess.getDataProcessingAccess().getCommaKeyword_25_0());
            	    			
            	    // InternalWorkflow.g:1577:4: ( (lv_outputPort_33_0= ruleDataDictionary ) )
            	    // InternalWorkflow.g:1578:5: (lv_outputPort_33_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:1578:5: (lv_outputPort_33_0= ruleDataDictionary )
            	    // InternalWorkflow.g:1579:6: lv_outputPort_33_0= ruleDataDictionary
            	    {

            	    						newCompositeNode(grammarAccess.getDataProcessingAccess().getOutputPortDataDictionaryParserRuleCall_25_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_outputPort_33_0=ruleDataDictionary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            	    						}
            	    						add(
            	    							current,
            	    							"outputPort",
            	    							lv_outputPort_33_0,
            	    							"xtext.Workflow.DataDictionary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_34=(Token)match(input,15,FOLLOW_34); 

            			newLeafNode(otherlv_34, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_26());
            		
            // InternalWorkflow.g:1601:3: (otherlv_35= 'parameter' otherlv_36= '{' ( (lv_parameter_37_0= ruleParameter ) ) (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )* otherlv_40= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==38) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalWorkflow.g:1602:4: otherlv_35= 'parameter' otherlv_36= '{' ( (lv_parameter_37_0= ruleParameter ) ) (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )* otherlv_40= '}'
                    {
                    otherlv_35=(Token)match(input,38,FOLLOW_4); 

                    				newLeafNode(otherlv_35, grammarAccess.getDataProcessingAccess().getParameterKeyword_27_0());
                    			
                    otherlv_36=(Token)match(input,12,FOLLOW_35); 

                    				newLeafNode(otherlv_36, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_27_1());
                    			
                    // InternalWorkflow.g:1610:4: ( (lv_parameter_37_0= ruleParameter ) )
                    // InternalWorkflow.g:1611:5: (lv_parameter_37_0= ruleParameter )
                    {
                    // InternalWorkflow.g:1611:5: (lv_parameter_37_0= ruleParameter )
                    // InternalWorkflow.g:1612:6: lv_parameter_37_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getDataProcessingAccess().getParameterParameterParserRuleCall_27_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_parameter_37_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataProcessingRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_37_0,
                    							"xtext.Workflow.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:1629:4: (otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==14) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalWorkflow.g:1630:5: otherlv_38= ',' ( (lv_parameter_39_0= ruleParameter ) )
                    	    {
                    	    otherlv_38=(Token)match(input,14,FOLLOW_35); 

                    	    					newLeafNode(otherlv_38, grammarAccess.getDataProcessingAccess().getCommaKeyword_27_3_0());
                    	    				
                    	    // InternalWorkflow.g:1634:5: ( (lv_parameter_39_0= ruleParameter ) )
                    	    // InternalWorkflow.g:1635:6: (lv_parameter_39_0= ruleParameter )
                    	    {
                    	    // InternalWorkflow.g:1635:6: (lv_parameter_39_0= ruleParameter )
                    	    // InternalWorkflow.g:1636:7: lv_parameter_39_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataProcessingAccess().getParameterParameterParserRuleCall_27_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_parameter_39_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataProcessingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_39_0,
                    	    								"xtext.Workflow.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_40=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_40, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_27_4());
                    			

                    }
                    break;

            }

            otherlv_41=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_41, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_28());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataProcessing"


    // $ANTLR start "entryRuleValueField"
    // InternalWorkflow.g:1667:1: entryRuleValueField returns [EObject current=null] : iv_ruleValueField= ruleValueField EOF ;
    public final EObject entryRuleValueField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueField = null;


        try {
            // InternalWorkflow.g:1667:51: (iv_ruleValueField= ruleValueField EOF )
            // InternalWorkflow.g:1668:2: iv_ruleValueField= ruleValueField EOF
            {
             newCompositeNode(grammarAccess.getValueFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueField=ruleValueField();

            state._fsp--;

             current =iv_ruleValueField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueField"


    // $ANTLR start "ruleValueField"
    // InternalWorkflow.g:1674:1: ruleValueField returns [EObject current=null] : ( () otherlv_1= 'ValueField' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEString ) ) )? (otherlv_5= 'count' ( (lv_count_6_0= ruleEInt ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleValueField() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;

        AntlrDatatypeRuleToken lv_count_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1680:2: ( ( () otherlv_1= 'ValueField' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEString ) ) )? (otherlv_5= 'count' ( (lv_count_6_0= ruleEInt ) ) )? otherlv_7= '}' ) )
            // InternalWorkflow.g:1681:2: ( () otherlv_1= 'ValueField' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEString ) ) )? (otherlv_5= 'count' ( (lv_count_6_0= ruleEInt ) ) )? otherlv_7= '}' )
            {
            // InternalWorkflow.g:1681:2: ( () otherlv_1= 'ValueField' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEString ) ) )? (otherlv_5= 'count' ( (lv_count_6_0= ruleEInt ) ) )? otherlv_7= '}' )
            // InternalWorkflow.g:1682:3: () otherlv_1= 'ValueField' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEString ) ) )? (otherlv_5= 'count' ( (lv_count_6_0= ruleEInt ) ) )? otherlv_7= '}'
            {
            // InternalWorkflow.g:1682:3: ()
            // InternalWorkflow.g:1683:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueFieldAccess().getValueFieldAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getValueFieldAccess().getValueFieldKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getValueFieldAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:1697:3: (otherlv_3= 'value' ( (lv_value_4_0= ruleEString ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==40) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalWorkflow.g:1698:4: otherlv_3= 'value' ( (lv_value_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,40,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getValueFieldAccess().getValueKeyword_3_0());
                    			
                    // InternalWorkflow.g:1702:4: ( (lv_value_4_0= ruleEString ) )
                    // InternalWorkflow.g:1703:5: (lv_value_4_0= ruleEString )
                    {
                    // InternalWorkflow.g:1703:5: (lv_value_4_0= ruleEString )
                    // InternalWorkflow.g:1704:6: lv_value_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getValueFieldAccess().getValueEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_value_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getValueFieldRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_4_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1722:3: (otherlv_5= 'count' ( (lv_count_6_0= ruleEInt ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==41) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalWorkflow.g:1723:4: otherlv_5= 'count' ( (lv_count_6_0= ruleEInt ) )
                    {
                    otherlv_5=(Token)match(input,41,FOLLOW_38); 

                    				newLeafNode(otherlv_5, grammarAccess.getValueFieldAccess().getCountKeyword_4_0());
                    			
                    // InternalWorkflow.g:1727:4: ( (lv_count_6_0= ruleEInt ) )
                    // InternalWorkflow.g:1728:5: (lv_count_6_0= ruleEInt )
                    {
                    // InternalWorkflow.g:1728:5: (lv_count_6_0= ruleEInt )
                    // InternalWorkflow.g:1729:6: lv_count_6_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getValueFieldAccess().getCountEIntParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_count_6_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getValueFieldRule());
                    						}
                    						set(
                    							current,
                    							"count",
                    							lv_count_6_0,
                    							"xtext.Workflow.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getValueFieldAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueField"


    // $ANTLR start "entryRuleCategorical"
    // InternalWorkflow.g:1755:1: entryRuleCategorical returns [EObject current=null] : iv_ruleCategorical= ruleCategorical EOF ;
    public final EObject entryRuleCategorical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategorical = null;


        try {
            // InternalWorkflow.g:1755:52: (iv_ruleCategorical= ruleCategorical EOF )
            // InternalWorkflow.g:1756:2: iv_ruleCategorical= ruleCategorical EOF
            {
             newCompositeNode(grammarAccess.getCategoricalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategorical=ruleCategorical();

            state._fsp--;

             current =iv_ruleCategorical; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCategorical"


    // $ANTLR start "ruleCategorical"
    // InternalWorkflow.g:1762:1: ruleCategorical returns [EObject current=null] : ( () ( (lv_id_1_0= 'id' ) )? ( (lv_target_2_0= 'target' ) )? ( (lv_ordinal_3_0= 'ordinal' ) )? otherlv_4= 'Categorical' ( (lv_name_5_0= ruleEString ) ) otherlv_6= '{' (otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) )? (otherlv_9= 'displayName' ( (lv_displayName_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= '}' ) ;
    public final EObject ruleCategorical() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token lv_target_2_0=null;
        Token lv_ordinal_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        AntlrDatatypeRuleToken lv_name_5_0 = null;

        Enumerator lv_dataType_8_0 = null;

        AntlrDatatypeRuleToken lv_displayName_10_0 = null;

        EObject lv_validValues_21_0 = null;

        EObject lv_validValues_23_0 = null;

        EObject lv_invalidValues_27_0 = null;

        EObject lv_invalidValues_29_0 = null;

        EObject lv_missingValues_33_0 = null;

        EObject lv_missingValues_35_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1768:2: ( ( () ( (lv_id_1_0= 'id' ) )? ( (lv_target_2_0= 'target' ) )? ( (lv_ordinal_3_0= 'ordinal' ) )? otherlv_4= 'Categorical' ( (lv_name_5_0= ruleEString ) ) otherlv_6= '{' (otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) )? (otherlv_9= 'displayName' ( (lv_displayName_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= '}' ) )
            // InternalWorkflow.g:1769:2: ( () ( (lv_id_1_0= 'id' ) )? ( (lv_target_2_0= 'target' ) )? ( (lv_ordinal_3_0= 'ordinal' ) )? otherlv_4= 'Categorical' ( (lv_name_5_0= ruleEString ) ) otherlv_6= '{' (otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) )? (otherlv_9= 'displayName' ( (lv_displayName_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= '}' )
            {
            // InternalWorkflow.g:1769:2: ( () ( (lv_id_1_0= 'id' ) )? ( (lv_target_2_0= 'target' ) )? ( (lv_ordinal_3_0= 'ordinal' ) )? otherlv_4= 'Categorical' ( (lv_name_5_0= ruleEString ) ) otherlv_6= '{' (otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) )? (otherlv_9= 'displayName' ( (lv_displayName_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= '}' )
            // InternalWorkflow.g:1770:3: () ( (lv_id_1_0= 'id' ) )? ( (lv_target_2_0= 'target' ) )? ( (lv_ordinal_3_0= 'ordinal' ) )? otherlv_4= 'Categorical' ( (lv_name_5_0= ruleEString ) ) otherlv_6= '{' (otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) )? (otherlv_9= 'displayName' ( (lv_displayName_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= '}'
            {
            // InternalWorkflow.g:1770:3: ()
            // InternalWorkflow.g:1771:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCategoricalAccess().getCategoricalAction_0(),
            					current);
            			

            }

            // InternalWorkflow.g:1777:3: ( (lv_id_1_0= 'id' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==42) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalWorkflow.g:1778:4: (lv_id_1_0= 'id' )
                    {
                    // InternalWorkflow.g:1778:4: (lv_id_1_0= 'id' )
                    // InternalWorkflow.g:1779:5: lv_id_1_0= 'id'
                    {
                    lv_id_1_0=(Token)match(input,42,FOLLOW_39); 

                    					newLeafNode(lv_id_1_0, grammarAccess.getCategoricalAccess().getIdIdKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCategoricalRule());
                    					}
                    					setWithLastConsumed(current, "id", lv_id_1_0 != null, "id");
                    				

                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1791:3: ( (lv_target_2_0= 'target' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalWorkflow.g:1792:4: (lv_target_2_0= 'target' )
                    {
                    // InternalWorkflow.g:1792:4: (lv_target_2_0= 'target' )
                    // InternalWorkflow.g:1793:5: lv_target_2_0= 'target'
                    {
                    lv_target_2_0=(Token)match(input,19,FOLLOW_40); 

                    					newLeafNode(lv_target_2_0, grammarAccess.getCategoricalAccess().getTargetTargetKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCategoricalRule());
                    					}
                    					setWithLastConsumed(current, "target", lv_target_2_0 != null, "target");
                    				

                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1805:3: ( (lv_ordinal_3_0= 'ordinal' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==43) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalWorkflow.g:1806:4: (lv_ordinal_3_0= 'ordinal' )
                    {
                    // InternalWorkflow.g:1806:4: (lv_ordinal_3_0= 'ordinal' )
                    // InternalWorkflow.g:1807:5: lv_ordinal_3_0= 'ordinal'
                    {
                    lv_ordinal_3_0=(Token)match(input,43,FOLLOW_41); 

                    					newLeafNode(lv_ordinal_3_0, grammarAccess.getCategoricalAccess().getOrdinalOrdinalKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCategoricalRule());
                    					}
                    					setWithLastConsumed(current, "ordinal", lv_ordinal_3_0 != null, "ordinal");
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getCategoricalAccess().getCategoricalKeyword_4());
            		
            // InternalWorkflow.g:1823:3: ( (lv_name_5_0= ruleEString ) )
            // InternalWorkflow.g:1824:4: (lv_name_5_0= ruleEString )
            {
            // InternalWorkflow.g:1824:4: (lv_name_5_0= ruleEString )
            // InternalWorkflow.g:1825:5: lv_name_5_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCategoricalAccess().getNameEStringParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_5_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCategoricalRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_5_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,12,FOLLOW_42); 

            			newLeafNode(otherlv_6, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:1846:3: (otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==45) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalWorkflow.g:1847:4: otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) )
                    {
                    otherlv_7=(Token)match(input,45,FOLLOW_43); 

                    				newLeafNode(otherlv_7, grammarAccess.getCategoricalAccess().getDataTypeKeyword_7_0());
                    			
                    // InternalWorkflow.g:1851:4: ( (lv_dataType_8_0= ruleDataType ) )
                    // InternalWorkflow.g:1852:5: (lv_dataType_8_0= ruleDataType )
                    {
                    // InternalWorkflow.g:1852:5: (lv_dataType_8_0= ruleDataType )
                    // InternalWorkflow.g:1853:6: lv_dataType_8_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getDataTypeDataTypeEnumRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_dataType_8_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_8_0,
                    							"xtext.Workflow.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1871:3: (otherlv_9= 'displayName' ( (lv_displayName_10_0= ruleEString ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==46) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalWorkflow.g:1872:4: otherlv_9= 'displayName' ( (lv_displayName_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,46,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getCategoricalAccess().getDisplayNameKeyword_8_0());
                    			
                    // InternalWorkflow.g:1876:4: ( (lv_displayName_10_0= ruleEString ) )
                    // InternalWorkflow.g:1877:5: (lv_displayName_10_0= ruleEString )
                    {
                    // InternalWorkflow.g:1877:5: (lv_displayName_10_0= ruleEString )
                    // InternalWorkflow.g:1878:6: lv_displayName_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getDisplayNameEStringParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_displayName_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    						}
                    						set(
                    							current,
                    							"displayName",
                    							lv_displayName_10_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1896:3: (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==22) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalWorkflow.g:1897:4: otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')'
                    {
                    otherlv_11=(Token)match(input,22,FOLLOW_24); 

                    				newLeafNode(otherlv_11, grammarAccess.getCategoricalAccess().getInKeyword_9_0());
                    			
                    otherlv_12=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getCategoricalAccess().getLeftParenthesisKeyword_9_1());
                    			
                    // InternalWorkflow.g:1905:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:1906:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:1906:5: ( ruleEString )
                    // InternalWorkflow.g:1907:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCategoricalRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getInDataFieldCrossReference_9_2_0());
                    					
                    pushFollow(FOLLOW_25);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:1921:4: (otherlv_14= ',' ( ( ruleEString ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==14) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalWorkflow.g:1922:5: otherlv_14= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_14=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getCategoricalAccess().getCommaKeyword_9_3_0());
                    	    				
                    	    // InternalWorkflow.g:1926:5: ( ( ruleEString ) )
                    	    // InternalWorkflow.g:1927:6: ( ruleEString )
                    	    {
                    	    // InternalWorkflow.g:1927:6: ( ruleEString )
                    	    // InternalWorkflow.g:1928:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getCategoricalRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getCategoricalAccess().getInDataFieldCrossReference_9_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_25);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,32,FOLLOW_46); 

                    				newLeafNode(otherlv_16, grammarAccess.getCategoricalAccess().getRightParenthesisKeyword_9_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:1948:3: (otherlv_17= 'out' ( ( ruleEString ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==23) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalWorkflow.g:1949:4: otherlv_17= 'out' ( ( ruleEString ) )
                    {
                    otherlv_17=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_17, grammarAccess.getCategoricalAccess().getOutKeyword_10_0());
                    			
                    // InternalWorkflow.g:1953:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:1954:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:1954:5: ( ruleEString )
                    // InternalWorkflow.g:1955:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCategoricalRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getOutDataFieldCrossReference_10_1_0());
                    					
                    pushFollow(FOLLOW_47);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1970:3: (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==47) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalWorkflow.g:1971:4: otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}'
                    {
                    otherlv_19=(Token)match(input,47,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getCategoricalAccess().getValidValuesKeyword_11_0());
                    			
                    otherlv_20=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_20, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalWorkflow.g:1979:4: ( (lv_validValues_21_0= ruleValueField ) )
                    // InternalWorkflow.g:1980:5: (lv_validValues_21_0= ruleValueField )
                    {
                    // InternalWorkflow.g:1980:5: (lv_validValues_21_0= ruleValueField )
                    // InternalWorkflow.g:1981:6: lv_validValues_21_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getValidValuesValueFieldParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_validValues_21_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    						}
                    						add(
                    							current,
                    							"validValues",
                    							lv_validValues_21_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:1998:4: (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==14) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalWorkflow.g:1999:5: otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) )
                    	    {
                    	    otherlv_22=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getCategoricalAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalWorkflow.g:2003:5: ( (lv_validValues_23_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2004:6: (lv_validValues_23_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2004:6: (lv_validValues_23_0= ruleValueField )
                    	    // InternalWorkflow.g:2005:7: lv_validValues_23_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getCategoricalAccess().getValidValuesValueFieldParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_validValues_23_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"validValues",
                    	    								lv_validValues_23_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,15,FOLLOW_49); 

                    				newLeafNode(otherlv_24, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_11_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2028:3: (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==48) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalWorkflow.g:2029:4: otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}'
                    {
                    otherlv_25=(Token)match(input,48,FOLLOW_4); 

                    				newLeafNode(otherlv_25, grammarAccess.getCategoricalAccess().getInvalidValuesKeyword_12_0());
                    			
                    otherlv_26=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_26, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_12_1());
                    			
                    // InternalWorkflow.g:2037:4: ( (lv_invalidValues_27_0= ruleValueField ) )
                    // InternalWorkflow.g:2038:5: (lv_invalidValues_27_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2038:5: (lv_invalidValues_27_0= ruleValueField )
                    // InternalWorkflow.g:2039:6: lv_invalidValues_27_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getInvalidValuesValueFieldParserRuleCall_12_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_invalidValues_27_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    						}
                    						add(
                    							current,
                    							"invalidValues",
                    							lv_invalidValues_27_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2056:4: (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==14) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalWorkflow.g:2057:5: otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) )
                    	    {
                    	    otherlv_28=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getCategoricalAccess().getCommaKeyword_12_3_0());
                    	    				
                    	    // InternalWorkflow.g:2061:5: ( (lv_invalidValues_29_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2062:6: (lv_invalidValues_29_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2062:6: (lv_invalidValues_29_0= ruleValueField )
                    	    // InternalWorkflow.g:2063:7: lv_invalidValues_29_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getCategoricalAccess().getInvalidValuesValueFieldParserRuleCall_12_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_invalidValues_29_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"invalidValues",
                    	    								lv_invalidValues_29_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,15,FOLLOW_50); 

                    				newLeafNode(otherlv_30, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_12_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2086:3: (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==49) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalWorkflow.g:2087:4: otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}'
                    {
                    otherlv_31=(Token)match(input,49,FOLLOW_4); 

                    				newLeafNode(otherlv_31, grammarAccess.getCategoricalAccess().getMissingValuesKeyword_13_0());
                    			
                    otherlv_32=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_32, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_13_1());
                    			
                    // InternalWorkflow.g:2095:4: ( (lv_missingValues_33_0= ruleValueField ) )
                    // InternalWorkflow.g:2096:5: (lv_missingValues_33_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2096:5: (lv_missingValues_33_0= ruleValueField )
                    // InternalWorkflow.g:2097:6: lv_missingValues_33_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getMissingValuesValueFieldParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_missingValues_33_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    						}
                    						add(
                    							current,
                    							"missingValues",
                    							lv_missingValues_33_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2114:4: (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==14) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalWorkflow.g:2115:5: otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) )
                    	    {
                    	    otherlv_34=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getCategoricalAccess().getCommaKeyword_13_3_0());
                    	    				
                    	    // InternalWorkflow.g:2119:5: ( (lv_missingValues_35_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2120:6: (lv_missingValues_35_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2120:6: (lv_missingValues_35_0= ruleValueField )
                    	    // InternalWorkflow.g:2121:7: lv_missingValues_35_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getCategoricalAccess().getMissingValuesValueFieldParserRuleCall_13_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_missingValues_35_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"missingValues",
                    	    								lv_missingValues_35_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_36, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_13_4());
                    			

                    }
                    break;

            }

            otherlv_37=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_37, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_14());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategorical"


    // $ANTLR start "entryRuleContinuous"
    // InternalWorkflow.g:2152:1: entryRuleContinuous returns [EObject current=null] : iv_ruleContinuous= ruleContinuous EOF ;
    public final EObject entryRuleContinuous() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuous = null;


        try {
            // InternalWorkflow.g:2152:51: (iv_ruleContinuous= ruleContinuous EOF )
            // InternalWorkflow.g:2153:2: iv_ruleContinuous= ruleContinuous EOF
            {
             newCompositeNode(grammarAccess.getContinuousRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContinuous=ruleContinuous();

            state._fsp--;

             current =iv_ruleContinuous; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContinuous"


    // $ANTLR start "ruleContinuous"
    // InternalWorkflow.g:2159:1: ruleContinuous returns [EObject current=null] : ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Continuous' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'numDecimals' ( (lv_numDecimals_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'interval' otherlv_38= '{' ( (lv_interval_39_0= ruleInterval ) ) (otherlv_40= ',' ( (lv_interval_41_0= ruleInterval ) ) )* otherlv_42= '}' otherlv_43= '}' ) ;
    public final EObject ruleContinuous() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token lv_target_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        Token otherlv_43=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        Enumerator lv_dataType_6_0 = null;

        AntlrDatatypeRuleToken lv_displayName_8_0 = null;

        AntlrDatatypeRuleToken lv_numDecimals_10_0 = null;

        EObject lv_validValues_21_0 = null;

        EObject lv_validValues_23_0 = null;

        EObject lv_invalidValues_27_0 = null;

        EObject lv_invalidValues_29_0 = null;

        EObject lv_missingValues_33_0 = null;

        EObject lv_missingValues_35_0 = null;

        EObject lv_interval_39_0 = null;

        EObject lv_interval_41_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2165:2: ( ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Continuous' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'numDecimals' ( (lv_numDecimals_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'interval' otherlv_38= '{' ( (lv_interval_39_0= ruleInterval ) ) (otherlv_40= ',' ( (lv_interval_41_0= ruleInterval ) ) )* otherlv_42= '}' otherlv_43= '}' ) )
            // InternalWorkflow.g:2166:2: ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Continuous' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'numDecimals' ( (lv_numDecimals_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'interval' otherlv_38= '{' ( (lv_interval_39_0= ruleInterval ) ) (otherlv_40= ',' ( (lv_interval_41_0= ruleInterval ) ) )* otherlv_42= '}' otherlv_43= '}' )
            {
            // InternalWorkflow.g:2166:2: ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Continuous' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'numDecimals' ( (lv_numDecimals_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'interval' otherlv_38= '{' ( (lv_interval_39_0= ruleInterval ) ) (otherlv_40= ',' ( (lv_interval_41_0= ruleInterval ) ) )* otherlv_42= '}' otherlv_43= '}' )
            // InternalWorkflow.g:2167:3: ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Continuous' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'numDecimals' ( (lv_numDecimals_10_0= ruleEIntegerObject ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'interval' otherlv_38= '{' ( (lv_interval_39_0= ruleInterval ) ) (otherlv_40= ',' ( (lv_interval_41_0= ruleInterval ) ) )* otherlv_42= '}' otherlv_43= '}'
            {
            // InternalWorkflow.g:2167:3: ( (lv_id_0_0= 'id' ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==42) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalWorkflow.g:2168:4: (lv_id_0_0= 'id' )
                    {
                    // InternalWorkflow.g:2168:4: (lv_id_0_0= 'id' )
                    // InternalWorkflow.g:2169:5: lv_id_0_0= 'id'
                    {
                    lv_id_0_0=(Token)match(input,42,FOLLOW_51); 

                    					newLeafNode(lv_id_0_0, grammarAccess.getContinuousAccess().getIdIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContinuousRule());
                    					}
                    					setWithLastConsumed(current, "id", lv_id_0_0 != null, "id");
                    				

                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2181:3: ( (lv_target_1_0= 'target' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==19) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalWorkflow.g:2182:4: (lv_target_1_0= 'target' )
                    {
                    // InternalWorkflow.g:2182:4: (lv_target_1_0= 'target' )
                    // InternalWorkflow.g:2183:5: lv_target_1_0= 'target'
                    {
                    lv_target_1_0=(Token)match(input,19,FOLLOW_52); 

                    					newLeafNode(lv_target_1_0, grammarAccess.getContinuousAccess().getTargetTargetKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContinuousRule());
                    					}
                    					setWithLastConsumed(current, "target", lv_target_1_0 != null, "target");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getContinuousAccess().getContinuousKeyword_2());
            		
            // InternalWorkflow.g:2199:3: ( (lv_name_3_0= ruleEString ) )
            // InternalWorkflow.g:2200:4: (lv_name_3_0= ruleEString )
            {
            // InternalWorkflow.g:2200:4: (lv_name_3_0= ruleEString )
            // InternalWorkflow.g:2201:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getContinuousAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContinuousRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_53); 

            			newLeafNode(otherlv_4, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflow.g:2222:3: (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==45) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalWorkflow.g:2223:4: otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) )
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_43); 

                    				newLeafNode(otherlv_5, grammarAccess.getContinuousAccess().getDataTypeKeyword_5_0());
                    			
                    // InternalWorkflow.g:2227:4: ( (lv_dataType_6_0= ruleDataType ) )
                    // InternalWorkflow.g:2228:5: (lv_dataType_6_0= ruleDataType )
                    {
                    // InternalWorkflow.g:2228:5: (lv_dataType_6_0= ruleDataType )
                    // InternalWorkflow.g:2229:6: lv_dataType_6_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getContinuousAccess().getDataTypeDataTypeEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_54);
                    lv_dataType_6_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_6_0,
                    							"xtext.Workflow.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2247:3: (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==46) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalWorkflow.g:2248:4: otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,46,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getContinuousAccess().getDisplayNameKeyword_6_0());
                    			
                    // InternalWorkflow.g:2252:4: ( (lv_displayName_8_0= ruleEString ) )
                    // InternalWorkflow.g:2253:5: (lv_displayName_8_0= ruleEString )
                    {
                    // InternalWorkflow.g:2253:5: (lv_displayName_8_0= ruleEString )
                    // InternalWorkflow.g:2254:6: lv_displayName_8_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getContinuousAccess().getDisplayNameEStringParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_55);
                    lv_displayName_8_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    						}
                    						set(
                    							current,
                    							"displayName",
                    							lv_displayName_8_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2272:3: (otherlv_9= 'numDecimals' ( (lv_numDecimals_10_0= ruleEIntegerObject ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==51) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalWorkflow.g:2273:4: otherlv_9= 'numDecimals' ( (lv_numDecimals_10_0= ruleEIntegerObject ) )
                    {
                    otherlv_9=(Token)match(input,51,FOLLOW_38); 

                    				newLeafNode(otherlv_9, grammarAccess.getContinuousAccess().getNumDecimalsKeyword_7_0());
                    			
                    // InternalWorkflow.g:2277:4: ( (lv_numDecimals_10_0= ruleEIntegerObject ) )
                    // InternalWorkflow.g:2278:5: (lv_numDecimals_10_0= ruleEIntegerObject )
                    {
                    // InternalWorkflow.g:2278:5: (lv_numDecimals_10_0= ruleEIntegerObject )
                    // InternalWorkflow.g:2279:6: lv_numDecimals_10_0= ruleEIntegerObject
                    {

                    						newCompositeNode(grammarAccess.getContinuousAccess().getNumDecimalsEIntegerObjectParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_56);
                    lv_numDecimals_10_0=ruleEIntegerObject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    						}
                    						set(
                    							current,
                    							"numDecimals",
                    							lv_numDecimals_10_0,
                    							"xtext.Workflow.EIntegerObject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2297:3: (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==22) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalWorkflow.g:2298:4: otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')'
                    {
                    otherlv_11=(Token)match(input,22,FOLLOW_24); 

                    				newLeafNode(otherlv_11, grammarAccess.getContinuousAccess().getInKeyword_8_0());
                    			
                    otherlv_12=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getContinuousAccess().getLeftParenthesisKeyword_8_1());
                    			
                    // InternalWorkflow.g:2306:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:2307:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:2307:5: ( ruleEString )
                    // InternalWorkflow.g:2308:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getContinuousAccess().getInDataFieldCrossReference_8_2_0());
                    					
                    pushFollow(FOLLOW_25);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2322:4: (otherlv_14= ',' ( ( ruleEString ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==14) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalWorkflow.g:2323:5: otherlv_14= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_14=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getContinuousAccess().getCommaKeyword_8_3_0());
                    	    				
                    	    // InternalWorkflow.g:2327:5: ( ( ruleEString ) )
                    	    // InternalWorkflow.g:2328:6: ( ruleEString )
                    	    {
                    	    // InternalWorkflow.g:2328:6: ( ruleEString )
                    	    // InternalWorkflow.g:2329:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getContinuousRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getContinuousAccess().getInDataFieldCrossReference_8_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_25);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,32,FOLLOW_57); 

                    				newLeafNode(otherlv_16, grammarAccess.getContinuousAccess().getRightParenthesisKeyword_8_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2349:3: (otherlv_17= 'out' ( ( ruleEString ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==23) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalWorkflow.g:2350:4: otherlv_17= 'out' ( ( ruleEString ) )
                    {
                    otherlv_17=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_17, grammarAccess.getContinuousAccess().getOutKeyword_9_0());
                    			
                    // InternalWorkflow.g:2354:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:2355:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:2355:5: ( ruleEString )
                    // InternalWorkflow.g:2356:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getContinuousAccess().getOutDataFieldCrossReference_9_1_0());
                    					
                    pushFollow(FOLLOW_58);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2371:3: (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==47) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalWorkflow.g:2372:4: otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}'
                    {
                    otherlv_19=(Token)match(input,47,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getContinuousAccess().getValidValuesKeyword_10_0());
                    			
                    otherlv_20=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_20, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_10_1());
                    			
                    // InternalWorkflow.g:2380:4: ( (lv_validValues_21_0= ruleValueField ) )
                    // InternalWorkflow.g:2381:5: (lv_validValues_21_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2381:5: (lv_validValues_21_0= ruleValueField )
                    // InternalWorkflow.g:2382:6: lv_validValues_21_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getContinuousAccess().getValidValuesValueFieldParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_validValues_21_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    						}
                    						add(
                    							current,
                    							"validValues",
                    							lv_validValues_21_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2399:4: (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==14) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // InternalWorkflow.g:2400:5: otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) )
                    	    {
                    	    otherlv_22=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getContinuousAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalWorkflow.g:2404:5: ( (lv_validValues_23_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2405:6: (lv_validValues_23_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2405:6: (lv_validValues_23_0= ruleValueField )
                    	    // InternalWorkflow.g:2406:7: lv_validValues_23_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getContinuousAccess().getValidValuesValueFieldParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_validValues_23_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getContinuousRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"validValues",
                    	    								lv_validValues_23_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,15,FOLLOW_59); 

                    				newLeafNode(otherlv_24, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2429:3: (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==48) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalWorkflow.g:2430:4: otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}'
                    {
                    otherlv_25=(Token)match(input,48,FOLLOW_4); 

                    				newLeafNode(otherlv_25, grammarAccess.getContinuousAccess().getInvalidValuesKeyword_11_0());
                    			
                    otherlv_26=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_26, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalWorkflow.g:2438:4: ( (lv_invalidValues_27_0= ruleValueField ) )
                    // InternalWorkflow.g:2439:5: (lv_invalidValues_27_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2439:5: (lv_invalidValues_27_0= ruleValueField )
                    // InternalWorkflow.g:2440:6: lv_invalidValues_27_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getContinuousAccess().getInvalidValuesValueFieldParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_invalidValues_27_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    						}
                    						add(
                    							current,
                    							"invalidValues",
                    							lv_invalidValues_27_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2457:4: (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==14) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalWorkflow.g:2458:5: otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) )
                    	    {
                    	    otherlv_28=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getContinuousAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalWorkflow.g:2462:5: ( (lv_invalidValues_29_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2463:6: (lv_invalidValues_29_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2463:6: (lv_invalidValues_29_0= ruleValueField )
                    	    // InternalWorkflow.g:2464:7: lv_invalidValues_29_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getContinuousAccess().getInvalidValuesValueFieldParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_invalidValues_29_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getContinuousRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"invalidValues",
                    	    								lv_invalidValues_29_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,15,FOLLOW_60); 

                    				newLeafNode(otherlv_30, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_11_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2487:3: (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==49) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalWorkflow.g:2488:4: otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}'
                    {
                    otherlv_31=(Token)match(input,49,FOLLOW_4); 

                    				newLeafNode(otherlv_31, grammarAccess.getContinuousAccess().getMissingValuesKeyword_12_0());
                    			
                    otherlv_32=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_32, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_12_1());
                    			
                    // InternalWorkflow.g:2496:4: ( (lv_missingValues_33_0= ruleValueField ) )
                    // InternalWorkflow.g:2497:5: (lv_missingValues_33_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2497:5: (lv_missingValues_33_0= ruleValueField )
                    // InternalWorkflow.g:2498:6: lv_missingValues_33_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getContinuousAccess().getMissingValuesValueFieldParserRuleCall_12_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_missingValues_33_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    						}
                    						add(
                    							current,
                    							"missingValues",
                    							lv_missingValues_33_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2515:4: (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==14) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalWorkflow.g:2516:5: otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) )
                    	    {
                    	    otherlv_34=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getContinuousAccess().getCommaKeyword_12_3_0());
                    	    				
                    	    // InternalWorkflow.g:2520:5: ( (lv_missingValues_35_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2521:6: (lv_missingValues_35_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2521:6: (lv_missingValues_35_0= ruleValueField )
                    	    // InternalWorkflow.g:2522:7: lv_missingValues_35_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getContinuousAccess().getMissingValuesValueFieldParserRuleCall_12_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_missingValues_35_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getContinuousRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"missingValues",
                    	    								lv_missingValues_35_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,15,FOLLOW_61); 

                    				newLeafNode(otherlv_36, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_12_4());
                    			

                    }
                    break;

            }

            otherlv_37=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_37, grammarAccess.getContinuousAccess().getIntervalKeyword_13());
            		
            otherlv_38=(Token)match(input,12,FOLLOW_62); 

            			newLeafNode(otherlv_38, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_14());
            		
            // InternalWorkflow.g:2553:3: ( (lv_interval_39_0= ruleInterval ) )
            // InternalWorkflow.g:2554:4: (lv_interval_39_0= ruleInterval )
            {
            // InternalWorkflow.g:2554:4: (lv_interval_39_0= ruleInterval )
            // InternalWorkflow.g:2555:5: lv_interval_39_0= ruleInterval
            {

            					newCompositeNode(grammarAccess.getContinuousAccess().getIntervalIntervalParserRuleCall_15_0());
            				
            pushFollow(FOLLOW_7);
            lv_interval_39_0=ruleInterval();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContinuousRule());
            					}
            					add(
            						current,
            						"interval",
            						lv_interval_39_0,
            						"xtext.Workflow.Interval");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:2572:3: (otherlv_40= ',' ( (lv_interval_41_0= ruleInterval ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==14) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalWorkflow.g:2573:4: otherlv_40= ',' ( (lv_interval_41_0= ruleInterval ) )
            	    {
            	    otherlv_40=(Token)match(input,14,FOLLOW_62); 

            	    				newLeafNode(otherlv_40, grammarAccess.getContinuousAccess().getCommaKeyword_16_0());
            	    			
            	    // InternalWorkflow.g:2577:4: ( (lv_interval_41_0= ruleInterval ) )
            	    // InternalWorkflow.g:2578:5: (lv_interval_41_0= ruleInterval )
            	    {
            	    // InternalWorkflow.g:2578:5: (lv_interval_41_0= ruleInterval )
            	    // InternalWorkflow.g:2579:6: lv_interval_41_0= ruleInterval
            	    {

            	    						newCompositeNode(grammarAccess.getContinuousAccess().getIntervalIntervalParserRuleCall_16_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_interval_41_0=ruleInterval();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContinuousRule());
            	    						}
            	    						add(
            	    							current,
            	    							"interval",
            	    							lv_interval_41_0,
            	    							"xtext.Workflow.Interval");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_42=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_42, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_17());
            		
            otherlv_43=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_43, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContinuous"


    // $ANTLR start "entryRuleDate"
    // InternalWorkflow.g:2609:1: entryRuleDate returns [EObject current=null] : iv_ruleDate= ruleDate EOF ;
    public final EObject entryRuleDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDate = null;


        try {
            // InternalWorkflow.g:2609:45: (iv_ruleDate= ruleDate EOF )
            // InternalWorkflow.g:2610:2: iv_ruleDate= ruleDate EOF
            {
             newCompositeNode(grammarAccess.getDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDate=ruleDate();

            state._fsp--;

             current =iv_ruleDate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDate"


    // $ANTLR start "ruleDate"
    // InternalWorkflow.g:2616:1: ruleDate returns [EObject current=null] : ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Date' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'format' ( (lv_format_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'intervaldate' otherlv_38= '{' ( (lv_intervaldate_39_0= ruleIntervalDate ) ) (otherlv_40= ',' ( (lv_intervaldate_41_0= ruleIntervalDate ) ) )* otherlv_42= '}' otherlv_43= '}' ) ;
    public final EObject ruleDate() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token lv_target_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        Token otherlv_43=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        Enumerator lv_dataType_6_0 = null;

        AntlrDatatypeRuleToken lv_displayName_8_0 = null;

        AntlrDatatypeRuleToken lv_format_10_0 = null;

        EObject lv_validValues_21_0 = null;

        EObject lv_validValues_23_0 = null;

        EObject lv_invalidValues_27_0 = null;

        EObject lv_invalidValues_29_0 = null;

        EObject lv_missingValues_33_0 = null;

        EObject lv_missingValues_35_0 = null;

        EObject lv_intervaldate_39_0 = null;

        EObject lv_intervaldate_41_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2622:2: ( ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Date' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'format' ( (lv_format_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'intervaldate' otherlv_38= '{' ( (lv_intervaldate_39_0= ruleIntervalDate ) ) (otherlv_40= ',' ( (lv_intervaldate_41_0= ruleIntervalDate ) ) )* otherlv_42= '}' otherlv_43= '}' ) )
            // InternalWorkflow.g:2623:2: ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Date' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'format' ( (lv_format_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'intervaldate' otherlv_38= '{' ( (lv_intervaldate_39_0= ruleIntervalDate ) ) (otherlv_40= ',' ( (lv_intervaldate_41_0= ruleIntervalDate ) ) )* otherlv_42= '}' otherlv_43= '}' )
            {
            // InternalWorkflow.g:2623:2: ( ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Date' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'format' ( (lv_format_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'intervaldate' otherlv_38= '{' ( (lv_intervaldate_39_0= ruleIntervalDate ) ) (otherlv_40= ',' ( (lv_intervaldate_41_0= ruleIntervalDate ) ) )* otherlv_42= '}' otherlv_43= '}' )
            // InternalWorkflow.g:2624:3: ( (lv_id_0_0= 'id' ) )? ( (lv_target_1_0= 'target' ) )? otherlv_2= 'Date' ( (lv_name_3_0= ruleEString ) ) otherlv_4= '{' (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )? (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )? (otherlv_9= 'format' ( (lv_format_10_0= ruleEString ) ) )? (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )? (otherlv_17= 'out' ( ( ruleEString ) ) )? (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )? (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )? (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )? otherlv_37= 'intervaldate' otherlv_38= '{' ( (lv_intervaldate_39_0= ruleIntervalDate ) ) (otherlv_40= ',' ( (lv_intervaldate_41_0= ruleIntervalDate ) ) )* otherlv_42= '}' otherlv_43= '}'
            {
            // InternalWorkflow.g:2624:3: ( (lv_id_0_0= 'id' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==42) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalWorkflow.g:2625:4: (lv_id_0_0= 'id' )
                    {
                    // InternalWorkflow.g:2625:4: (lv_id_0_0= 'id' )
                    // InternalWorkflow.g:2626:5: lv_id_0_0= 'id'
                    {
                    lv_id_0_0=(Token)match(input,42,FOLLOW_63); 

                    					newLeafNode(lv_id_0_0, grammarAccess.getDateAccess().getIdIdKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDateRule());
                    					}
                    					setWithLastConsumed(current, "id", lv_id_0_0 != null, "id");
                    				

                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2638:3: ( (lv_target_1_0= 'target' ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==19) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalWorkflow.g:2639:4: (lv_target_1_0= 'target' )
                    {
                    // InternalWorkflow.g:2639:4: (lv_target_1_0= 'target' )
                    // InternalWorkflow.g:2640:5: lv_target_1_0= 'target'
                    {
                    lv_target_1_0=(Token)match(input,19,FOLLOW_64); 

                    					newLeafNode(lv_target_1_0, grammarAccess.getDateAccess().getTargetTargetKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDateRule());
                    					}
                    					setWithLastConsumed(current, "target", lv_target_1_0 != null, "target");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getDateAccess().getDateKeyword_2());
            		
            // InternalWorkflow.g:2656:3: ( (lv_name_3_0= ruleEString ) )
            // InternalWorkflow.g:2657:4: (lv_name_3_0= ruleEString )
            {
            // InternalWorkflow.g:2657:4: (lv_name_3_0= ruleEString )
            // InternalWorkflow.g:2658:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDateAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_65); 

            			newLeafNode(otherlv_4, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflow.g:2679:3: (otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==45) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalWorkflow.g:2680:4: otherlv_5= 'dataType' ( (lv_dataType_6_0= ruleDataType ) )
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_43); 

                    				newLeafNode(otherlv_5, grammarAccess.getDateAccess().getDataTypeKeyword_5_0());
                    			
                    // InternalWorkflow.g:2684:4: ( (lv_dataType_6_0= ruleDataType ) )
                    // InternalWorkflow.g:2685:5: (lv_dataType_6_0= ruleDataType )
                    {
                    // InternalWorkflow.g:2685:5: (lv_dataType_6_0= ruleDataType )
                    // InternalWorkflow.g:2686:6: lv_dataType_6_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getDateAccess().getDataTypeDataTypeEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_66);
                    lv_dataType_6_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_6_0,
                    							"xtext.Workflow.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2704:3: (otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==46) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalWorkflow.g:2705:4: otherlv_7= 'displayName' ( (lv_displayName_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,46,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getDateAccess().getDisplayNameKeyword_6_0());
                    			
                    // InternalWorkflow.g:2709:4: ( (lv_displayName_8_0= ruleEString ) )
                    // InternalWorkflow.g:2710:5: (lv_displayName_8_0= ruleEString )
                    {
                    // InternalWorkflow.g:2710:5: (lv_displayName_8_0= ruleEString )
                    // InternalWorkflow.g:2711:6: lv_displayName_8_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDateAccess().getDisplayNameEStringParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_displayName_8_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRule());
                    						}
                    						set(
                    							current,
                    							"displayName",
                    							lv_displayName_8_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2729:3: (otherlv_9= 'format' ( (lv_format_10_0= ruleEString ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==54) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalWorkflow.g:2730:4: otherlv_9= 'format' ( (lv_format_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,54,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getDateAccess().getFormatKeyword_7_0());
                    			
                    // InternalWorkflow.g:2734:4: ( (lv_format_10_0= ruleEString ) )
                    // InternalWorkflow.g:2735:5: (lv_format_10_0= ruleEString )
                    {
                    // InternalWorkflow.g:2735:5: (lv_format_10_0= ruleEString )
                    // InternalWorkflow.g:2736:6: lv_format_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDateAccess().getFormatEStringParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_68);
                    lv_format_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRule());
                    						}
                    						set(
                    							current,
                    							"format",
                    							lv_format_10_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2754:3: (otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==22) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalWorkflow.g:2755:4: otherlv_11= 'in' otherlv_12= '(' ( ( ruleEString ) ) (otherlv_14= ',' ( ( ruleEString ) ) )* otherlv_16= ')'
                    {
                    otherlv_11=(Token)match(input,22,FOLLOW_24); 

                    				newLeafNode(otherlv_11, grammarAccess.getDateAccess().getInKeyword_8_0());
                    			
                    otherlv_12=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getDateAccess().getLeftParenthesisKeyword_8_1());
                    			
                    // InternalWorkflow.g:2763:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:2764:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:2764:5: ( ruleEString )
                    // InternalWorkflow.g:2765:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDateAccess().getInDataFieldCrossReference_8_2_0());
                    					
                    pushFollow(FOLLOW_25);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2779:4: (otherlv_14= ',' ( ( ruleEString ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==14) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalWorkflow.g:2780:5: otherlv_14= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_14=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getDateAccess().getCommaKeyword_8_3_0());
                    	    				
                    	    // InternalWorkflow.g:2784:5: ( ( ruleEString ) )
                    	    // InternalWorkflow.g:2785:6: ( ruleEString )
                    	    {
                    	    // InternalWorkflow.g:2785:6: ( ruleEString )
                    	    // InternalWorkflow.g:2786:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getDateRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getDateAccess().getInDataFieldCrossReference_8_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_25);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,32,FOLLOW_69); 

                    				newLeafNode(otherlv_16, grammarAccess.getDateAccess().getRightParenthesisKeyword_8_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2806:3: (otherlv_17= 'out' ( ( ruleEString ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==23) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalWorkflow.g:2807:4: otherlv_17= 'out' ( ( ruleEString ) )
                    {
                    otherlv_17=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_17, grammarAccess.getDateAccess().getOutKeyword_9_0());
                    			
                    // InternalWorkflow.g:2811:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:2812:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:2812:5: ( ruleEString )
                    // InternalWorkflow.g:2813:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getDateAccess().getOutDataFieldCrossReference_9_1_0());
                    					
                    pushFollow(FOLLOW_70);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2828:3: (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==47) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalWorkflow.g:2829:4: otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) ) (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )* otherlv_24= '}'
                    {
                    otherlv_19=(Token)match(input,47,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getDateAccess().getValidValuesKeyword_10_0());
                    			
                    otherlv_20=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_20, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_10_1());
                    			
                    // InternalWorkflow.g:2837:4: ( (lv_validValues_21_0= ruleValueField ) )
                    // InternalWorkflow.g:2838:5: (lv_validValues_21_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2838:5: (lv_validValues_21_0= ruleValueField )
                    // InternalWorkflow.g:2839:6: lv_validValues_21_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getDateAccess().getValidValuesValueFieldParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_validValues_21_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRule());
                    						}
                    						add(
                    							current,
                    							"validValues",
                    							lv_validValues_21_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2856:4: (otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==14) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalWorkflow.g:2857:5: otherlv_22= ',' ( (lv_validValues_23_0= ruleValueField ) )
                    	    {
                    	    otherlv_22=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getDateAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalWorkflow.g:2861:5: ( (lv_validValues_23_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2862:6: (lv_validValues_23_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2862:6: (lv_validValues_23_0= ruleValueField )
                    	    // InternalWorkflow.g:2863:7: lv_validValues_23_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDateAccess().getValidValuesValueFieldParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_validValues_23_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDateRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"validValues",
                    	    								lv_validValues_23_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,15,FOLLOW_71); 

                    				newLeafNode(otherlv_24, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2886:3: (otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==48) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalWorkflow.g:2887:4: otherlv_25= 'invalidValues' otherlv_26= '{' ( (lv_invalidValues_27_0= ruleValueField ) ) (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )* otherlv_30= '}'
                    {
                    otherlv_25=(Token)match(input,48,FOLLOW_4); 

                    				newLeafNode(otherlv_25, grammarAccess.getDateAccess().getInvalidValuesKeyword_11_0());
                    			
                    otherlv_26=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_26, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalWorkflow.g:2895:4: ( (lv_invalidValues_27_0= ruleValueField ) )
                    // InternalWorkflow.g:2896:5: (lv_invalidValues_27_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2896:5: (lv_invalidValues_27_0= ruleValueField )
                    // InternalWorkflow.g:2897:6: lv_invalidValues_27_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getDateAccess().getInvalidValuesValueFieldParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_invalidValues_27_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRule());
                    						}
                    						add(
                    							current,
                    							"invalidValues",
                    							lv_invalidValues_27_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2914:4: (otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==14) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalWorkflow.g:2915:5: otherlv_28= ',' ( (lv_invalidValues_29_0= ruleValueField ) )
                    	    {
                    	    otherlv_28=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_28, grammarAccess.getDateAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalWorkflow.g:2919:5: ( (lv_invalidValues_29_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2920:6: (lv_invalidValues_29_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2920:6: (lv_invalidValues_29_0= ruleValueField )
                    	    // InternalWorkflow.g:2921:7: lv_invalidValues_29_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDateAccess().getInvalidValuesValueFieldParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_invalidValues_29_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDateRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"invalidValues",
                    	    								lv_invalidValues_29_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,15,FOLLOW_72); 

                    				newLeafNode(otherlv_30, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_11_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:2944:3: (otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==49) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalWorkflow.g:2945:4: otherlv_31= 'missingValues' otherlv_32= '{' ( (lv_missingValues_33_0= ruleValueField ) ) (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )* otherlv_36= '}'
                    {
                    otherlv_31=(Token)match(input,49,FOLLOW_4); 

                    				newLeafNode(otherlv_31, grammarAccess.getDateAccess().getMissingValuesKeyword_12_0());
                    			
                    otherlv_32=(Token)match(input,12,FOLLOW_48); 

                    				newLeafNode(otherlv_32, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_12_1());
                    			
                    // InternalWorkflow.g:2953:4: ( (lv_missingValues_33_0= ruleValueField ) )
                    // InternalWorkflow.g:2954:5: (lv_missingValues_33_0= ruleValueField )
                    {
                    // InternalWorkflow.g:2954:5: (lv_missingValues_33_0= ruleValueField )
                    // InternalWorkflow.g:2955:6: lv_missingValues_33_0= ruleValueField
                    {

                    						newCompositeNode(grammarAccess.getDateAccess().getMissingValuesValueFieldParserRuleCall_12_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_missingValues_33_0=ruleValueField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRule());
                    						}
                    						add(
                    							current,
                    							"missingValues",
                    							lv_missingValues_33_0,
                    							"xtext.Workflow.ValueField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:2972:4: (otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==14) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalWorkflow.g:2973:5: otherlv_34= ',' ( (lv_missingValues_35_0= ruleValueField ) )
                    	    {
                    	    otherlv_34=(Token)match(input,14,FOLLOW_48); 

                    	    					newLeafNode(otherlv_34, grammarAccess.getDateAccess().getCommaKeyword_12_3_0());
                    	    				
                    	    // InternalWorkflow.g:2977:5: ( (lv_missingValues_35_0= ruleValueField ) )
                    	    // InternalWorkflow.g:2978:6: (lv_missingValues_35_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:2978:6: (lv_missingValues_35_0= ruleValueField )
                    	    // InternalWorkflow.g:2979:7: lv_missingValues_35_0= ruleValueField
                    	    {

                    	    							newCompositeNode(grammarAccess.getDateAccess().getMissingValuesValueFieldParserRuleCall_12_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_missingValues_35_0=ruleValueField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDateRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"missingValues",
                    	    								lv_missingValues_35_0,
                    	    								"xtext.Workflow.ValueField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,15,FOLLOW_73); 

                    				newLeafNode(otherlv_36, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_12_4());
                    			

                    }
                    break;

            }

            otherlv_37=(Token)match(input,55,FOLLOW_4); 

            			newLeafNode(otherlv_37, grammarAccess.getDateAccess().getIntervaldateKeyword_13());
            		
            otherlv_38=(Token)match(input,12,FOLLOW_74); 

            			newLeafNode(otherlv_38, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_14());
            		
            // InternalWorkflow.g:3010:3: ( (lv_intervaldate_39_0= ruleIntervalDate ) )
            // InternalWorkflow.g:3011:4: (lv_intervaldate_39_0= ruleIntervalDate )
            {
            // InternalWorkflow.g:3011:4: (lv_intervaldate_39_0= ruleIntervalDate )
            // InternalWorkflow.g:3012:5: lv_intervaldate_39_0= ruleIntervalDate
            {

            					newCompositeNode(grammarAccess.getDateAccess().getIntervaldateIntervalDateParserRuleCall_15_0());
            				
            pushFollow(FOLLOW_7);
            lv_intervaldate_39_0=ruleIntervalDate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateRule());
            					}
            					add(
            						current,
            						"intervaldate",
            						lv_intervaldate_39_0,
            						"xtext.Workflow.IntervalDate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:3029:3: (otherlv_40= ',' ( (lv_intervaldate_41_0= ruleIntervalDate ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==14) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalWorkflow.g:3030:4: otherlv_40= ',' ( (lv_intervaldate_41_0= ruleIntervalDate ) )
            	    {
            	    otherlv_40=(Token)match(input,14,FOLLOW_74); 

            	    				newLeafNode(otherlv_40, grammarAccess.getDateAccess().getCommaKeyword_16_0());
            	    			
            	    // InternalWorkflow.g:3034:4: ( (lv_intervaldate_41_0= ruleIntervalDate ) )
            	    // InternalWorkflow.g:3035:5: (lv_intervaldate_41_0= ruleIntervalDate )
            	    {
            	    // InternalWorkflow.g:3035:5: (lv_intervaldate_41_0= ruleIntervalDate )
            	    // InternalWorkflow.g:3036:6: lv_intervaldate_41_0= ruleIntervalDate
            	    {

            	    						newCompositeNode(grammarAccess.getDateAccess().getIntervaldateIntervalDateParserRuleCall_16_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_intervaldate_41_0=ruleIntervalDate();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDateRule());
            	    						}
            	    						add(
            	    							current,
            	    							"intervaldate",
            	    							lv_intervaldate_41_0,
            	    							"xtext.Workflow.IntervalDate");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

            otherlv_42=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_42, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_17());
            		
            otherlv_43=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_43, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDate"


    // $ANTLR start "entryRuleEInt"
    // InternalWorkflow.g:3066:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalWorkflow.g:3066:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalWorkflow.g:3067:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalWorkflow.g:3073:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:3079:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalWorkflow.g:3080:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalWorkflow.g:3080:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalWorkflow.g:3081:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalWorkflow.g:3081:3: (kw= '-' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==56) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalWorkflow.g:3082:4: kw= '-'
                    {
                    kw=(Token)match(input,56,FOLLOW_75); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleInterval"
    // InternalWorkflow.g:3099:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalWorkflow.g:3099:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalWorkflow.g:3100:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // InternalWorkflow.g:3106:1: ruleInterval returns [EObject current=null] : ( () otherlv_1= 'Interval' otherlv_2= '{' (otherlv_3= 'leftMargin' ( (lv_leftMargin_4_0= ruleEFloat ) ) )? (otherlv_5= 'rightMargin' ( (lv_rightMargin_6_0= ruleEFloat ) ) )? (otherlv_7= 'clousure' ( (lv_clousure_8_0= ruleClosureType ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_leftMargin_4_0 = null;

        AntlrDatatypeRuleToken lv_rightMargin_6_0 = null;

        Enumerator lv_clousure_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3112:2: ( ( () otherlv_1= 'Interval' otherlv_2= '{' (otherlv_3= 'leftMargin' ( (lv_leftMargin_4_0= ruleEFloat ) ) )? (otherlv_5= 'rightMargin' ( (lv_rightMargin_6_0= ruleEFloat ) ) )? (otherlv_7= 'clousure' ( (lv_clousure_8_0= ruleClosureType ) ) )? otherlv_9= '}' ) )
            // InternalWorkflow.g:3113:2: ( () otherlv_1= 'Interval' otherlv_2= '{' (otherlv_3= 'leftMargin' ( (lv_leftMargin_4_0= ruleEFloat ) ) )? (otherlv_5= 'rightMargin' ( (lv_rightMargin_6_0= ruleEFloat ) ) )? (otherlv_7= 'clousure' ( (lv_clousure_8_0= ruleClosureType ) ) )? otherlv_9= '}' )
            {
            // InternalWorkflow.g:3113:2: ( () otherlv_1= 'Interval' otherlv_2= '{' (otherlv_3= 'leftMargin' ( (lv_leftMargin_4_0= ruleEFloat ) ) )? (otherlv_5= 'rightMargin' ( (lv_rightMargin_6_0= ruleEFloat ) ) )? (otherlv_7= 'clousure' ( (lv_clousure_8_0= ruleClosureType ) ) )? otherlv_9= '}' )
            // InternalWorkflow.g:3114:3: () otherlv_1= 'Interval' otherlv_2= '{' (otherlv_3= 'leftMargin' ( (lv_leftMargin_4_0= ruleEFloat ) ) )? (otherlv_5= 'rightMargin' ( (lv_rightMargin_6_0= ruleEFloat ) ) )? (otherlv_7= 'clousure' ( (lv_clousure_8_0= ruleClosureType ) ) )? otherlv_9= '}'
            {
            // InternalWorkflow.g:3114:3: ()
            // InternalWorkflow.g:3115:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntervalAccess().getIntervalAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,57,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getIntervalAccess().getIntervalKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_76); 

            			newLeafNode(otherlv_2, grammarAccess.getIntervalAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:3129:3: (otherlv_3= 'leftMargin' ( (lv_leftMargin_4_0= ruleEFloat ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==58) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalWorkflow.g:3130:4: otherlv_3= 'leftMargin' ( (lv_leftMargin_4_0= ruleEFloat ) )
                    {
                    otherlv_3=(Token)match(input,58,FOLLOW_77); 

                    				newLeafNode(otherlv_3, grammarAccess.getIntervalAccess().getLeftMarginKeyword_3_0());
                    			
                    // InternalWorkflow.g:3134:4: ( (lv_leftMargin_4_0= ruleEFloat ) )
                    // InternalWorkflow.g:3135:5: (lv_leftMargin_4_0= ruleEFloat )
                    {
                    // InternalWorkflow.g:3135:5: (lv_leftMargin_4_0= ruleEFloat )
                    // InternalWorkflow.g:3136:6: lv_leftMargin_4_0= ruleEFloat
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getLeftMarginEFloatParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_78);
                    lv_leftMargin_4_0=ruleEFloat();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"leftMargin",
                    							lv_leftMargin_4_0,
                    							"xtext.Workflow.EFloat");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3154:3: (otherlv_5= 'rightMargin' ( (lv_rightMargin_6_0= ruleEFloat ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==59) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalWorkflow.g:3155:4: otherlv_5= 'rightMargin' ( (lv_rightMargin_6_0= ruleEFloat ) )
                    {
                    otherlv_5=(Token)match(input,59,FOLLOW_77); 

                    				newLeafNode(otherlv_5, grammarAccess.getIntervalAccess().getRightMarginKeyword_4_0());
                    			
                    // InternalWorkflow.g:3159:4: ( (lv_rightMargin_6_0= ruleEFloat ) )
                    // InternalWorkflow.g:3160:5: (lv_rightMargin_6_0= ruleEFloat )
                    {
                    // InternalWorkflow.g:3160:5: (lv_rightMargin_6_0= ruleEFloat )
                    // InternalWorkflow.g:3161:6: lv_rightMargin_6_0= ruleEFloat
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getRightMarginEFloatParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_79);
                    lv_rightMargin_6_0=ruleEFloat();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"rightMargin",
                    							lv_rightMargin_6_0,
                    							"xtext.Workflow.EFloat");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3179:3: (otherlv_7= 'clousure' ( (lv_clousure_8_0= ruleClosureType ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==60) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalWorkflow.g:3180:4: otherlv_7= 'clousure' ( (lv_clousure_8_0= ruleClosureType ) )
                    {
                    otherlv_7=(Token)match(input,60,FOLLOW_80); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntervalAccess().getClousureKeyword_5_0());
                    			
                    // InternalWorkflow.g:3184:4: ( (lv_clousure_8_0= ruleClosureType ) )
                    // InternalWorkflow.g:3185:5: (lv_clousure_8_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:3185:5: (lv_clousure_8_0= ruleClosureType )
                    // InternalWorkflow.g:3186:6: lv_clousure_8_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getClousureClosureTypeEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_clousure_8_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_8_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getIntervalAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleEIntegerObject"
    // InternalWorkflow.g:3212:1: entryRuleEIntegerObject returns [String current=null] : iv_ruleEIntegerObject= ruleEIntegerObject EOF ;
    public final String entryRuleEIntegerObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEIntegerObject = null;


        try {
            // InternalWorkflow.g:3212:54: (iv_ruleEIntegerObject= ruleEIntegerObject EOF )
            // InternalWorkflow.g:3213:2: iv_ruleEIntegerObject= ruleEIntegerObject EOF
            {
             newCompositeNode(grammarAccess.getEIntegerObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEIntegerObject=ruleEIntegerObject();

            state._fsp--;

             current =iv_ruleEIntegerObject.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEIntegerObject"


    // $ANTLR start "ruleEIntegerObject"
    // InternalWorkflow.g:3219:1: ruleEIntegerObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEIntegerObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:3225:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalWorkflow.g:3226:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalWorkflow.g:3226:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalWorkflow.g:3227:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalWorkflow.g:3227:3: (kw= '-' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==56) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalWorkflow.g:3228:4: kw= '-'
                    {
                    kw=(Token)match(input,56,FOLLOW_75); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntegerObjectAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntegerObjectAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEIntegerObject"


    // $ANTLR start "entryRuleEFloat"
    // InternalWorkflow.g:3245:1: entryRuleEFloat returns [String current=null] : iv_ruleEFloat= ruleEFloat EOF ;
    public final String entryRuleEFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFloat = null;


        try {
            // InternalWorkflow.g:3245:46: (iv_ruleEFloat= ruleEFloat EOF )
            // InternalWorkflow.g:3246:2: iv_ruleEFloat= ruleEFloat EOF
            {
             newCompositeNode(grammarAccess.getEFloatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEFloat=ruleEFloat();

            state._fsp--;

             current =iv_ruleEFloat.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFloat"


    // $ANTLR start "ruleEFloat"
    // InternalWorkflow.g:3252:1: ruleEFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalWorkflow.g:3258:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalWorkflow.g:3259:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalWorkflow.g:3259:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalWorkflow.g:3260:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalWorkflow.g:3260:3: (kw= '-' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==56) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalWorkflow.g:3261:4: kw= '-'
                    {
                    kw=(Token)match(input,56,FOLLOW_81); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEFloatAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:3267:3: (this_INT_1= RULE_INT )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_INT) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalWorkflow.g:3268:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_82); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEFloatAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,61,FOLLOW_75); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEFloatAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_83); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEFloatAccess().getINTTerminalRuleCall_3());
            		
            // InternalWorkflow.g:3288:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=62 && LA90_0<=63)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalWorkflow.g:3289:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalWorkflow.g:3289:4: (kw= 'E' | kw= 'e' )
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==62) ) {
                        alt88=1;
                    }
                    else if ( (LA88_0==63) ) {
                        alt88=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 0, input);

                        throw nvae;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalWorkflow.g:3290:5: kw= 'E'
                            {
                            kw=(Token)match(input,62,FOLLOW_38); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEFloatAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalWorkflow.g:3296:5: kw= 'e'
                            {
                            kw=(Token)match(input,63,FOLLOW_38); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEFloatAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalWorkflow.g:3302:4: (kw= '-' )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==56) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalWorkflow.g:3303:5: kw= '-'
                            {
                            kw=(Token)match(input,56,FOLLOW_75); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEFloatAccess().getHyphenMinusKeyword_4_1());
                            				

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_7);
                    			

                    				newLeafNode(this_INT_7, grammarAccess.getEFloatAccess().getINTTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFloat"


    // $ANTLR start "entryRuleIntervalDate"
    // InternalWorkflow.g:3321:1: entryRuleIntervalDate returns [EObject current=null] : iv_ruleIntervalDate= ruleIntervalDate EOF ;
    public final EObject entryRuleIntervalDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntervalDate = null;


        try {
            // InternalWorkflow.g:3321:53: (iv_ruleIntervalDate= ruleIntervalDate EOF )
            // InternalWorkflow.g:3322:2: iv_ruleIntervalDate= ruleIntervalDate EOF
            {
             newCompositeNode(grammarAccess.getIntervalDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntervalDate=ruleIntervalDate();

            state._fsp--;

             current =iv_ruleIntervalDate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntervalDate"


    // $ANTLR start "ruleIntervalDate"
    // InternalWorkflow.g:3328:1: ruleIntervalDate returns [EObject current=null] : ( () otherlv_1= 'IntervalDate' otherlv_2= '{' (otherlv_3= 'rightMargin' ( (lv_rightMargin_4_0= ruleEString ) ) )? (otherlv_5= 'clousure' ( (lv_clousure_6_0= ruleClosureType ) ) )? (otherlv_7= 'leftMargin' ( (lv_leftMargin_8_0= ruleEString ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleIntervalDate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_rightMargin_4_0 = null;

        Enumerator lv_clousure_6_0 = null;

        AntlrDatatypeRuleToken lv_leftMargin_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3334:2: ( ( () otherlv_1= 'IntervalDate' otherlv_2= '{' (otherlv_3= 'rightMargin' ( (lv_rightMargin_4_0= ruleEString ) ) )? (otherlv_5= 'clousure' ( (lv_clousure_6_0= ruleClosureType ) ) )? (otherlv_7= 'leftMargin' ( (lv_leftMargin_8_0= ruleEString ) ) )? otherlv_9= '}' ) )
            // InternalWorkflow.g:3335:2: ( () otherlv_1= 'IntervalDate' otherlv_2= '{' (otherlv_3= 'rightMargin' ( (lv_rightMargin_4_0= ruleEString ) ) )? (otherlv_5= 'clousure' ( (lv_clousure_6_0= ruleClosureType ) ) )? (otherlv_7= 'leftMargin' ( (lv_leftMargin_8_0= ruleEString ) ) )? otherlv_9= '}' )
            {
            // InternalWorkflow.g:3335:2: ( () otherlv_1= 'IntervalDate' otherlv_2= '{' (otherlv_3= 'rightMargin' ( (lv_rightMargin_4_0= ruleEString ) ) )? (otherlv_5= 'clousure' ( (lv_clousure_6_0= ruleClosureType ) ) )? (otherlv_7= 'leftMargin' ( (lv_leftMargin_8_0= ruleEString ) ) )? otherlv_9= '}' )
            // InternalWorkflow.g:3336:3: () otherlv_1= 'IntervalDate' otherlv_2= '{' (otherlv_3= 'rightMargin' ( (lv_rightMargin_4_0= ruleEString ) ) )? (otherlv_5= 'clousure' ( (lv_clousure_6_0= ruleClosureType ) ) )? (otherlv_7= 'leftMargin' ( (lv_leftMargin_8_0= ruleEString ) ) )? otherlv_9= '}'
            {
            // InternalWorkflow.g:3336:3: ()
            // InternalWorkflow.g:3337:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntervalDateAccess().getIntervalDateAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,64,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getIntervalDateAccess().getIntervalDateKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_76); 

            			newLeafNode(otherlv_2, grammarAccess.getIntervalDateAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:3351:3: (otherlv_3= 'rightMargin' ( (lv_rightMargin_4_0= ruleEString ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==59) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalWorkflow.g:3352:4: otherlv_3= 'rightMargin' ( (lv_rightMargin_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,59,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getIntervalDateAccess().getRightMarginKeyword_3_0());
                    			
                    // InternalWorkflow.g:3356:4: ( (lv_rightMargin_4_0= ruleEString ) )
                    // InternalWorkflow.g:3357:5: (lv_rightMargin_4_0= ruleEString )
                    {
                    // InternalWorkflow.g:3357:5: (lv_rightMargin_4_0= ruleEString )
                    // InternalWorkflow.g:3358:6: lv_rightMargin_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getIntervalDateAccess().getRightMarginEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_84);
                    lv_rightMargin_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalDateRule());
                    						}
                    						set(
                    							current,
                    							"rightMargin",
                    							lv_rightMargin_4_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3376:3: (otherlv_5= 'clousure' ( (lv_clousure_6_0= ruleClosureType ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==60) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalWorkflow.g:3377:4: otherlv_5= 'clousure' ( (lv_clousure_6_0= ruleClosureType ) )
                    {
                    otherlv_5=(Token)match(input,60,FOLLOW_80); 

                    				newLeafNode(otherlv_5, grammarAccess.getIntervalDateAccess().getClousureKeyword_4_0());
                    			
                    // InternalWorkflow.g:3381:4: ( (lv_clousure_6_0= ruleClosureType ) )
                    // InternalWorkflow.g:3382:5: (lv_clousure_6_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:3382:5: (lv_clousure_6_0= ruleClosureType )
                    // InternalWorkflow.g:3383:6: lv_clousure_6_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getIntervalDateAccess().getClousureClosureTypeEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_85);
                    lv_clousure_6_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalDateRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_6_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3401:3: (otherlv_7= 'leftMargin' ( (lv_leftMargin_8_0= ruleEString ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==58) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalWorkflow.g:3402:4: otherlv_7= 'leftMargin' ( (lv_leftMargin_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,58,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntervalDateAccess().getLeftMarginKeyword_5_0());
                    			
                    // InternalWorkflow.g:3406:4: ( (lv_leftMargin_8_0= ruleEString ) )
                    // InternalWorkflow.g:3407:5: (lv_leftMargin_8_0= ruleEString )
                    {
                    // InternalWorkflow.g:3407:5: (lv_leftMargin_8_0= ruleEString )
                    // InternalWorkflow.g:3408:6: lv_leftMargin_8_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getIntervalDateAccess().getLeftMarginEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_leftMargin_8_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalDateRule());
                    						}
                    						set(
                    							current,
                    							"leftMargin",
                    							lv_leftMargin_8_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getIntervalDateAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntervalDate"


    // $ANTLR start "entryRuleTest"
    // InternalWorkflow.g:3434:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalWorkflow.g:3434:45: (iv_ruleTest= ruleTest EOF )
            // InternalWorkflow.g:3435:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // InternalWorkflow.g:3441:1: ruleTest returns [EObject current=null] : ( () otherlv_1= 'Test' otherlv_2= '{' (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'trainSize' ( (lv_trainSize_6_0= ruleEFloat ) ) )? (otherlv_7= 'testSize' ( (lv_testSize_8_0= ruleEFloat ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_path_4_0 = null;

        AntlrDatatypeRuleToken lv_trainSize_6_0 = null;

        AntlrDatatypeRuleToken lv_testSize_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3447:2: ( ( () otherlv_1= 'Test' otherlv_2= '{' (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'trainSize' ( (lv_trainSize_6_0= ruleEFloat ) ) )? (otherlv_7= 'testSize' ( (lv_testSize_8_0= ruleEFloat ) ) )? otherlv_9= '}' ) )
            // InternalWorkflow.g:3448:2: ( () otherlv_1= 'Test' otherlv_2= '{' (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'trainSize' ( (lv_trainSize_6_0= ruleEFloat ) ) )? (otherlv_7= 'testSize' ( (lv_testSize_8_0= ruleEFloat ) ) )? otherlv_9= '}' )
            {
            // InternalWorkflow.g:3448:2: ( () otherlv_1= 'Test' otherlv_2= '{' (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'trainSize' ( (lv_trainSize_6_0= ruleEFloat ) ) )? (otherlv_7= 'testSize' ( (lv_testSize_8_0= ruleEFloat ) ) )? otherlv_9= '}' )
            // InternalWorkflow.g:3449:3: () otherlv_1= 'Test' otherlv_2= '{' (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'trainSize' ( (lv_trainSize_6_0= ruleEFloat ) ) )? (otherlv_7= 'testSize' ( (lv_testSize_8_0= ruleEFloat ) ) )? otherlv_9= '}'
            {
            // InternalWorkflow.g:3449:3: ()
            // InternalWorkflow.g:3450:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTestAccess().getTestAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,65,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTestAccess().getTestKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_86); 

            			newLeafNode(otherlv_2, grammarAccess.getTestAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:3464:3: (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==66) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalWorkflow.g:3465:4: otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,66,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getTestAccess().getPathKeyword_3_0());
                    			
                    // InternalWorkflow.g:3469:4: ( (lv_path_4_0= ruleEString ) )
                    // InternalWorkflow.g:3470:5: (lv_path_4_0= ruleEString )
                    {
                    // InternalWorkflow.g:3470:5: (lv_path_4_0= ruleEString )
                    // InternalWorkflow.g:3471:6: lv_path_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getTestAccess().getPathEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_87);
                    lv_path_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTestRule());
                    						}
                    						set(
                    							current,
                    							"path",
                    							lv_path_4_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3489:3: (otherlv_5= 'trainSize' ( (lv_trainSize_6_0= ruleEFloat ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==67) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalWorkflow.g:3490:4: otherlv_5= 'trainSize' ( (lv_trainSize_6_0= ruleEFloat ) )
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_77); 

                    				newLeafNode(otherlv_5, grammarAccess.getTestAccess().getTrainSizeKeyword_4_0());
                    			
                    // InternalWorkflow.g:3494:4: ( (lv_trainSize_6_0= ruleEFloat ) )
                    // InternalWorkflow.g:3495:5: (lv_trainSize_6_0= ruleEFloat )
                    {
                    // InternalWorkflow.g:3495:5: (lv_trainSize_6_0= ruleEFloat )
                    // InternalWorkflow.g:3496:6: lv_trainSize_6_0= ruleEFloat
                    {

                    						newCompositeNode(grammarAccess.getTestAccess().getTrainSizeEFloatParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_88);
                    lv_trainSize_6_0=ruleEFloat();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTestRule());
                    						}
                    						set(
                    							current,
                    							"trainSize",
                    							lv_trainSize_6_0,
                    							"xtext.Workflow.EFloat");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3514:3: (otherlv_7= 'testSize' ( (lv_testSize_8_0= ruleEFloat ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==68) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalWorkflow.g:3515:4: otherlv_7= 'testSize' ( (lv_testSize_8_0= ruleEFloat ) )
                    {
                    otherlv_7=(Token)match(input,68,FOLLOW_77); 

                    				newLeafNode(otherlv_7, grammarAccess.getTestAccess().getTestSizeKeyword_5_0());
                    			
                    // InternalWorkflow.g:3519:4: ( (lv_testSize_8_0= ruleEFloat ) )
                    // InternalWorkflow.g:3520:5: (lv_testSize_8_0= ruleEFloat )
                    {
                    // InternalWorkflow.g:3520:5: (lv_testSize_8_0= ruleEFloat )
                    // InternalWorkflow.g:3521:6: lv_testSize_8_0= ruleEFloat
                    {

                    						newCompositeNode(grammarAccess.getTestAccess().getTestSizeEFloatParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_testSize_8_0=ruleEFloat();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTestRule());
                    						}
                    						set(
                    							current,
                    							"testSize",
                    							lv_testSize_8_0,
                    							"xtext.Workflow.EFloat");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTestAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleMap"
    // InternalWorkflow.g:3547:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalWorkflow.g:3547:44: (iv_ruleMap= ruleMap EOF )
            // InternalWorkflow.g:3548:2: iv_ruleMap= ruleMap EOF
            {
             newCompositeNode(grammarAccess.getMapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMap=ruleMap();

            state._fsp--;

             current =iv_ruleMap; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMap"


    // $ANTLR start "ruleMap"
    // InternalWorkflow.g:3554:1: ruleMap returns [EObject current=null] : ( () otherlv_1= 'Map' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'inValue' ( (lv_inValue_5_0= ruleEString ) ) )? (otherlv_6= 'outvalue' ( (lv_outvalue_7_0= ruleEString ) ) )? (otherlv_8= 'mapOperation' ( (lv_mapOperation_9_0= ruleMapOperation ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_inValue_5_0 = null;

        AntlrDatatypeRuleToken lv_outvalue_7_0 = null;

        Enumerator lv_mapOperation_9_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3560:2: ( ( () otherlv_1= 'Map' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'inValue' ( (lv_inValue_5_0= ruleEString ) ) )? (otherlv_6= 'outvalue' ( (lv_outvalue_7_0= ruleEString ) ) )? (otherlv_8= 'mapOperation' ( (lv_mapOperation_9_0= ruleMapOperation ) ) )? otherlv_10= '}' ) )
            // InternalWorkflow.g:3561:2: ( () otherlv_1= 'Map' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'inValue' ( (lv_inValue_5_0= ruleEString ) ) )? (otherlv_6= 'outvalue' ( (lv_outvalue_7_0= ruleEString ) ) )? (otherlv_8= 'mapOperation' ( (lv_mapOperation_9_0= ruleMapOperation ) ) )? otherlv_10= '}' )
            {
            // InternalWorkflow.g:3561:2: ( () otherlv_1= 'Map' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'inValue' ( (lv_inValue_5_0= ruleEString ) ) )? (otherlv_6= 'outvalue' ( (lv_outvalue_7_0= ruleEString ) ) )? (otherlv_8= 'mapOperation' ( (lv_mapOperation_9_0= ruleMapOperation ) ) )? otherlv_10= '}' )
            // InternalWorkflow.g:3562:3: () otherlv_1= 'Map' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'inValue' ( (lv_inValue_5_0= ruleEString ) ) )? (otherlv_6= 'outvalue' ( (lv_outvalue_7_0= ruleEString ) ) )? (otherlv_8= 'mapOperation' ( (lv_mapOperation_9_0= ruleMapOperation ) ) )? otherlv_10= '}'
            {
            // InternalWorkflow.g:3562:3: ()
            // InternalWorkflow.g:3563:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMapAccess().getMapAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,69,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getMapAccess().getMapKeyword_1());
            		
            // InternalWorkflow.g:3573:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:3574:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:3574:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:3575:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMapAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_89); 

            			newLeafNode(otherlv_3, grammarAccess.getMapAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:3596:3: (otherlv_4= 'inValue' ( (lv_inValue_5_0= ruleEString ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==70) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalWorkflow.g:3597:4: otherlv_4= 'inValue' ( (lv_inValue_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,70,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getMapAccess().getInValueKeyword_4_0());
                    			
                    // InternalWorkflow.g:3601:4: ( (lv_inValue_5_0= ruleEString ) )
                    // InternalWorkflow.g:3602:5: (lv_inValue_5_0= ruleEString )
                    {
                    // InternalWorkflow.g:3602:5: (lv_inValue_5_0= ruleEString )
                    // InternalWorkflow.g:3603:6: lv_inValue_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMapAccess().getInValueEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_90);
                    lv_inValue_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMapRule());
                    						}
                    						set(
                    							current,
                    							"inValue",
                    							lv_inValue_5_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3621:3: (otherlv_6= 'outvalue' ( (lv_outvalue_7_0= ruleEString ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==71) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalWorkflow.g:3622:4: otherlv_6= 'outvalue' ( (lv_outvalue_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,71,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getMapAccess().getOutvalueKeyword_5_0());
                    			
                    // InternalWorkflow.g:3626:4: ( (lv_outvalue_7_0= ruleEString ) )
                    // InternalWorkflow.g:3627:5: (lv_outvalue_7_0= ruleEString )
                    {
                    // InternalWorkflow.g:3627:5: (lv_outvalue_7_0= ruleEString )
                    // InternalWorkflow.g:3628:6: lv_outvalue_7_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMapAccess().getOutvalueEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_91);
                    lv_outvalue_7_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMapRule());
                    						}
                    						set(
                    							current,
                    							"outvalue",
                    							lv_outvalue_7_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3646:3: (otherlv_8= 'mapOperation' ( (lv_mapOperation_9_0= ruleMapOperation ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==72) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalWorkflow.g:3647:4: otherlv_8= 'mapOperation' ( (lv_mapOperation_9_0= ruleMapOperation ) )
                    {
                    otherlv_8=(Token)match(input,72,FOLLOW_92); 

                    				newLeafNode(otherlv_8, grammarAccess.getMapAccess().getMapOperationKeyword_6_0());
                    			
                    // InternalWorkflow.g:3651:4: ( (lv_mapOperation_9_0= ruleMapOperation ) )
                    // InternalWorkflow.g:3652:5: (lv_mapOperation_9_0= ruleMapOperation )
                    {
                    // InternalWorkflow.g:3652:5: (lv_mapOperation_9_0= ruleMapOperation )
                    // InternalWorkflow.g:3653:6: lv_mapOperation_9_0= ruleMapOperation
                    {

                    						newCompositeNode(grammarAccess.getMapAccess().getMapOperationMapOperationEnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_mapOperation_9_0=ruleMapOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMapRule());
                    						}
                    						set(
                    							current,
                    							"mapOperation",
                    							lv_mapOperation_9_0,
                    							"xtext.Workflow.MapOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getMapAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMap"


    // $ANTLR start "entryRulePrimitive"
    // InternalWorkflow.g:3679:1: entryRulePrimitive returns [EObject current=null] : iv_rulePrimitive= rulePrimitive EOF ;
    public final EObject entryRulePrimitive() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitive = null;


        try {
            // InternalWorkflow.g:3679:50: (iv_rulePrimitive= rulePrimitive EOF )
            // InternalWorkflow.g:3680:2: iv_rulePrimitive= rulePrimitive EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitive=rulePrimitive();

            state._fsp--;

             current =iv_rulePrimitive; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitive"


    // $ANTLR start "rulePrimitive"
    // InternalWorkflow.g:3686:1: rulePrimitive returns [EObject current=null] : ( () otherlv_1= 'Primitive' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEString ) ) )? (otherlv_6= 'dataType' ( (lv_dataType_7_0= ruleDataType ) ) )? otherlv_8= '}' ) ;
    public final EObject rulePrimitive() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;

        Enumerator lv_dataType_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3692:2: ( ( () otherlv_1= 'Primitive' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEString ) ) )? (otherlv_6= 'dataType' ( (lv_dataType_7_0= ruleDataType ) ) )? otherlv_8= '}' ) )
            // InternalWorkflow.g:3693:2: ( () otherlv_1= 'Primitive' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEString ) ) )? (otherlv_6= 'dataType' ( (lv_dataType_7_0= ruleDataType ) ) )? otherlv_8= '}' )
            {
            // InternalWorkflow.g:3693:2: ( () otherlv_1= 'Primitive' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEString ) ) )? (otherlv_6= 'dataType' ( (lv_dataType_7_0= ruleDataType ) ) )? otherlv_8= '}' )
            // InternalWorkflow.g:3694:3: () otherlv_1= 'Primitive' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'value' ( (lv_value_5_0= ruleEString ) ) )? (otherlv_6= 'dataType' ( (lv_dataType_7_0= ruleDataType ) ) )? otherlv_8= '}'
            {
            // InternalWorkflow.g:3694:3: ()
            // InternalWorkflow.g:3695:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrimitiveAccess().getPrimitiveAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,73,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPrimitiveAccess().getPrimitiveKeyword_1());
            		
            // InternalWorkflow.g:3705:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:3706:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:3706:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:3707:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPrimitiveAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimitiveRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_93); 

            			newLeafNode(otherlv_3, grammarAccess.getPrimitiveAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:3728:3: (otherlv_4= 'value' ( (lv_value_5_0= ruleEString ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==40) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalWorkflow.g:3729:4: otherlv_4= 'value' ( (lv_value_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimitiveAccess().getValueKeyword_4_0());
                    			
                    // InternalWorkflow.g:3733:4: ( (lv_value_5_0= ruleEString ) )
                    // InternalWorkflow.g:3734:5: (lv_value_5_0= ruleEString )
                    {
                    // InternalWorkflow.g:3734:5: (lv_value_5_0= ruleEString )
                    // InternalWorkflow.g:3735:6: lv_value_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPrimitiveAccess().getValueEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_94);
                    lv_value_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimitiveRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3753:3: (otherlv_6= 'dataType' ( (lv_dataType_7_0= ruleDataType ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==45) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalWorkflow.g:3754:4: otherlv_6= 'dataType' ( (lv_dataType_7_0= ruleDataType ) )
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_43); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrimitiveAccess().getDataTypeKeyword_5_0());
                    			
                    // InternalWorkflow.g:3758:4: ( (lv_dataType_7_0= ruleDataType ) )
                    // InternalWorkflow.g:3759:5: (lv_dataType_7_0= ruleDataType )
                    {
                    // InternalWorkflow.g:3759:5: (lv_dataType_7_0= ruleDataType )
                    // InternalWorkflow.g:3760:6: lv_dataType_7_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getPrimitiveAccess().getDataTypeDataTypeEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_dataType_7_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimitiveRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_7_0,
                    							"xtext.Workflow.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getPrimitiveAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitive"


    // $ANTLR start "entryRuleDerivedField"
    // InternalWorkflow.g:3786:1: entryRuleDerivedField returns [EObject current=null] : iv_ruleDerivedField= ruleDerivedField EOF ;
    public final EObject entryRuleDerivedField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedField = null;


        try {
            // InternalWorkflow.g:3786:53: (iv_ruleDerivedField= ruleDerivedField EOF )
            // InternalWorkflow.g:3787:2: iv_ruleDerivedField= ruleDerivedField EOF
            {
             newCompositeNode(grammarAccess.getDerivedFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDerivedField=ruleDerivedField();

            state._fsp--;

             current =iv_ruleDerivedField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDerivedField"


    // $ANTLR start "ruleDerivedField"
    // InternalWorkflow.g:3793:1: ruleDerivedField returns [EObject current=null] : (otherlv_0= 'DerivedField' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'der_dataField' ( ( ruleEString ) ) otherlv_5= '}' ) ;
    public final EObject ruleDerivedField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3799:2: ( (otherlv_0= 'DerivedField' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'der_dataField' ( ( ruleEString ) ) otherlv_5= '}' ) )
            // InternalWorkflow.g:3800:2: (otherlv_0= 'DerivedField' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'der_dataField' ( ( ruleEString ) ) otherlv_5= '}' )
            {
            // InternalWorkflow.g:3800:2: (otherlv_0= 'DerivedField' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'der_dataField' ( ( ruleEString ) ) otherlv_5= '}' )
            // InternalWorkflow.g:3801:3: otherlv_0= 'DerivedField' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'der_dataField' ( ( ruleEString ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDerivedFieldAccess().getDerivedFieldKeyword_0());
            		
            // InternalWorkflow.g:3805:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:3806:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:3806:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:3807:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDerivedFieldAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedFieldRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_95); 

            			newLeafNode(otherlv_2, grammarAccess.getDerivedFieldAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,75,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDerivedFieldAccess().getDer_dataFieldKeyword_3());
            		
            // InternalWorkflow.g:3832:3: ( ( ruleEString ) )
            // InternalWorkflow.g:3833:4: ( ruleEString )
            {
            // InternalWorkflow.g:3833:4: ( ruleEString )
            // InternalWorkflow.g:3834:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedFieldRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDerivedFieldAccess().getDer_dataFieldDataFieldCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDerivedFieldAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDerivedField"


    // $ANTLR start "entryRuleFilterValue"
    // InternalWorkflow.g:3856:1: entryRuleFilterValue returns [EObject current=null] : iv_ruleFilterValue= ruleFilterValue EOF ;
    public final EObject entryRuleFilterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterValue = null;


        try {
            // InternalWorkflow.g:3856:52: (iv_ruleFilterValue= ruleFilterValue EOF )
            // InternalWorkflow.g:3857:2: iv_ruleFilterValue= ruleFilterValue EOF
            {
             newCompositeNode(grammarAccess.getFilterValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilterValue=ruleFilterValue();

            state._fsp--;

             current =iv_ruleFilterValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFilterValue"


    // $ANTLR start "ruleFilterValue"
    // InternalWorkflow.g:3863:1: ruleFilterValue returns [EObject current=null] : ( () otherlv_1= 'FilterValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'filterType' ( (lv_filterType_5_0= ruleFilterType ) ) )? (otherlv_6= 'primitive' otherlv_7= '{' ( (lv_primitive_8_0= rulePrimitive ) ) (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )* otherlv_11= '}' )? (otherlv_12= 'matchingvalue' otherlv_13= '{' ( (lv_matchingvalue_14_0= ruleMatchingValue ) ) (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )* otherlv_17= '}' )? otherlv_18= '}' ) ;
    public final EObject ruleFilterValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_filterType_5_0 = null;

        EObject lv_primitive_8_0 = null;

        EObject lv_primitive_10_0 = null;

        EObject lv_matchingvalue_14_0 = null;

        EObject lv_matchingvalue_16_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3869:2: ( ( () otherlv_1= 'FilterValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'filterType' ( (lv_filterType_5_0= ruleFilterType ) ) )? (otherlv_6= 'primitive' otherlv_7= '{' ( (lv_primitive_8_0= rulePrimitive ) ) (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )* otherlv_11= '}' )? (otherlv_12= 'matchingvalue' otherlv_13= '{' ( (lv_matchingvalue_14_0= ruleMatchingValue ) ) (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )* otherlv_17= '}' )? otherlv_18= '}' ) )
            // InternalWorkflow.g:3870:2: ( () otherlv_1= 'FilterValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'filterType' ( (lv_filterType_5_0= ruleFilterType ) ) )? (otherlv_6= 'primitive' otherlv_7= '{' ( (lv_primitive_8_0= rulePrimitive ) ) (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )* otherlv_11= '}' )? (otherlv_12= 'matchingvalue' otherlv_13= '{' ( (lv_matchingvalue_14_0= ruleMatchingValue ) ) (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )* otherlv_17= '}' )? otherlv_18= '}' )
            {
            // InternalWorkflow.g:3870:2: ( () otherlv_1= 'FilterValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'filterType' ( (lv_filterType_5_0= ruleFilterType ) ) )? (otherlv_6= 'primitive' otherlv_7= '{' ( (lv_primitive_8_0= rulePrimitive ) ) (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )* otherlv_11= '}' )? (otherlv_12= 'matchingvalue' otherlv_13= '{' ( (lv_matchingvalue_14_0= ruleMatchingValue ) ) (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )* otherlv_17= '}' )? otherlv_18= '}' )
            // InternalWorkflow.g:3871:3: () otherlv_1= 'FilterValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'filterType' ( (lv_filterType_5_0= ruleFilterType ) ) )? (otherlv_6= 'primitive' otherlv_7= '{' ( (lv_primitive_8_0= rulePrimitive ) ) (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )* otherlv_11= '}' )? (otherlv_12= 'matchingvalue' otherlv_13= '{' ( (lv_matchingvalue_14_0= ruleMatchingValue ) ) (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )* otherlv_17= '}' )? otherlv_18= '}'
            {
            // InternalWorkflow.g:3871:3: ()
            // InternalWorkflow.g:3872:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFilterValueAccess().getFilterValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,76,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getFilterValueAccess().getFilterValueKeyword_1());
            		
            // InternalWorkflow.g:3882:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:3883:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:3883:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:3884:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFilterValueAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterValueRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_96); 

            			newLeafNode(otherlv_3, grammarAccess.getFilterValueAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:3905:3: (otherlv_4= 'filterType' ( (lv_filterType_5_0= ruleFilterType ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==77) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalWorkflow.g:3906:4: otherlv_4= 'filterType' ( (lv_filterType_5_0= ruleFilterType ) )
                    {
                    otherlv_4=(Token)match(input,77,FOLLOW_97); 

                    				newLeafNode(otherlv_4, grammarAccess.getFilterValueAccess().getFilterTypeKeyword_4_0());
                    			
                    // InternalWorkflow.g:3910:4: ( (lv_filterType_5_0= ruleFilterType ) )
                    // InternalWorkflow.g:3911:5: (lv_filterType_5_0= ruleFilterType )
                    {
                    // InternalWorkflow.g:3911:5: (lv_filterType_5_0= ruleFilterType )
                    // InternalWorkflow.g:3912:6: lv_filterType_5_0= ruleFilterType
                    {

                    						newCompositeNode(grammarAccess.getFilterValueAccess().getFilterTypeFilterTypeEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_98);
                    lv_filterType_5_0=ruleFilterType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    						}
                    						set(
                    							current,
                    							"filterType",
                    							lv_filterType_5_0,
                    							"xtext.Workflow.FilterType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3930:3: (otherlv_6= 'primitive' otherlv_7= '{' ( (lv_primitive_8_0= rulePrimitive ) ) (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )* otherlv_11= '}' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==78) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalWorkflow.g:3931:4: otherlv_6= 'primitive' otherlv_7= '{' ( (lv_primitive_8_0= rulePrimitive ) ) (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )* otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,78,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getFilterValueAccess().getPrimitiveKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,12,FOLLOW_99); 

                    				newLeafNode(otherlv_7, grammarAccess.getFilterValueAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalWorkflow.g:3939:4: ( (lv_primitive_8_0= rulePrimitive ) )
                    // InternalWorkflow.g:3940:5: (lv_primitive_8_0= rulePrimitive )
                    {
                    // InternalWorkflow.g:3940:5: (lv_primitive_8_0= rulePrimitive )
                    // InternalWorkflow.g:3941:6: lv_primitive_8_0= rulePrimitive
                    {

                    						newCompositeNode(grammarAccess.getFilterValueAccess().getPrimitivePrimitiveParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_primitive_8_0=rulePrimitive();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    						}
                    						add(
                    							current,
                    							"primitive",
                    							lv_primitive_8_0,
                    							"xtext.Workflow.Primitive");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:3958:4: (otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==14) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalWorkflow.g:3959:5: otherlv_9= ',' ( (lv_primitive_10_0= rulePrimitive ) )
                    	    {
                    	    otherlv_9=(Token)match(input,14,FOLLOW_99); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getFilterValueAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalWorkflow.g:3963:5: ( (lv_primitive_10_0= rulePrimitive ) )
                    	    // InternalWorkflow.g:3964:6: (lv_primitive_10_0= rulePrimitive )
                    	    {
                    	    // InternalWorkflow.g:3964:6: (lv_primitive_10_0= rulePrimitive )
                    	    // InternalWorkflow.g:3965:7: lv_primitive_10_0= rulePrimitive
                    	    {

                    	    							newCompositeNode(grammarAccess.getFilterValueAccess().getPrimitivePrimitiveParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_primitive_10_0=rulePrimitive();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"primitive",
                    	    								lv_primitive_10_0,
                    	    								"xtext.Workflow.Primitive");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop103;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,15,FOLLOW_100); 

                    				newLeafNode(otherlv_11, grammarAccess.getFilterValueAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:3988:3: (otherlv_12= 'matchingvalue' otherlv_13= '{' ( (lv_matchingvalue_14_0= ruleMatchingValue ) ) (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )* otherlv_17= '}' )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==79) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalWorkflow.g:3989:4: otherlv_12= 'matchingvalue' otherlv_13= '{' ( (lv_matchingvalue_14_0= ruleMatchingValue ) ) (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )* otherlv_17= '}'
                    {
                    otherlv_12=(Token)match(input,79,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getFilterValueAccess().getMatchingvalueKeyword_6_0());
                    			
                    otherlv_13=(Token)match(input,12,FOLLOW_35); 

                    				newLeafNode(otherlv_13, grammarAccess.getFilterValueAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalWorkflow.g:3997:4: ( (lv_matchingvalue_14_0= ruleMatchingValue ) )
                    // InternalWorkflow.g:3998:5: (lv_matchingvalue_14_0= ruleMatchingValue )
                    {
                    // InternalWorkflow.g:3998:5: (lv_matchingvalue_14_0= ruleMatchingValue )
                    // InternalWorkflow.g:3999:6: lv_matchingvalue_14_0= ruleMatchingValue
                    {

                    						newCompositeNode(grammarAccess.getFilterValueAccess().getMatchingvalueMatchingValueParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_matchingvalue_14_0=ruleMatchingValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    						}
                    						add(
                    							current,
                    							"matchingvalue",
                    							lv_matchingvalue_14_0,
                    							"xtext.Workflow.MatchingValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflow.g:4016:4: (otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) ) )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==14) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // InternalWorkflow.g:4017:5: otherlv_15= ',' ( (lv_matchingvalue_16_0= ruleMatchingValue ) )
                    	    {
                    	    otherlv_15=(Token)match(input,14,FOLLOW_35); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getFilterValueAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalWorkflow.g:4021:5: ( (lv_matchingvalue_16_0= ruleMatchingValue ) )
                    	    // InternalWorkflow.g:4022:6: (lv_matchingvalue_16_0= ruleMatchingValue )
                    	    {
                    	    // InternalWorkflow.g:4022:6: (lv_matchingvalue_16_0= ruleMatchingValue )
                    	    // InternalWorkflow.g:4023:7: lv_matchingvalue_16_0= ruleMatchingValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getFilterValueAccess().getMatchingvalueMatchingValueParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_matchingvalue_16_0=ruleMatchingValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"matchingvalue",
                    	    								lv_matchingvalue_16_0,
                    	    								"xtext.Workflow.MatchingValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop105;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,15,FOLLOW_10); 

                    				newLeafNode(otherlv_17, grammarAccess.getFilterValueAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_18=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getFilterValueAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilterValue"


    // $ANTLR start "entryRuleRange"
    // InternalWorkflow.g:4054:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalWorkflow.g:4054:46: (iv_ruleRange= ruleRange EOF )
            // InternalWorkflow.g:4055:2: iv_ruleRange= ruleRange EOF
            {
             newCompositeNode(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;

             current =iv_ruleRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalWorkflow.g:4061:1: ruleRange returns [EObject current=null] : ( () ( (lv_minInfinity_1_0= 'minInfinity' ) )? ( (lv_maxInfinity_2_0= 'maxInfinity' ) )? otherlv_3= 'Range' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'min' ( (lv_min_7_0= ruleEFloat ) ) )? (otherlv_8= 'max' ( (lv_max_9_0= ruleEFloat ) ) )? (otherlv_10= 'clousure' ( (lv_clousure_11_0= ruleClosureType ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token lv_minInfinity_1_0=null;
        Token lv_maxInfinity_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_min_7_0 = null;

        AntlrDatatypeRuleToken lv_max_9_0 = null;

        Enumerator lv_clousure_11_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4067:2: ( ( () ( (lv_minInfinity_1_0= 'minInfinity' ) )? ( (lv_maxInfinity_2_0= 'maxInfinity' ) )? otherlv_3= 'Range' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'min' ( (lv_min_7_0= ruleEFloat ) ) )? (otherlv_8= 'max' ( (lv_max_9_0= ruleEFloat ) ) )? (otherlv_10= 'clousure' ( (lv_clousure_11_0= ruleClosureType ) ) )? otherlv_12= '}' ) )
            // InternalWorkflow.g:4068:2: ( () ( (lv_minInfinity_1_0= 'minInfinity' ) )? ( (lv_maxInfinity_2_0= 'maxInfinity' ) )? otherlv_3= 'Range' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'min' ( (lv_min_7_0= ruleEFloat ) ) )? (otherlv_8= 'max' ( (lv_max_9_0= ruleEFloat ) ) )? (otherlv_10= 'clousure' ( (lv_clousure_11_0= ruleClosureType ) ) )? otherlv_12= '}' )
            {
            // InternalWorkflow.g:4068:2: ( () ( (lv_minInfinity_1_0= 'minInfinity' ) )? ( (lv_maxInfinity_2_0= 'maxInfinity' ) )? otherlv_3= 'Range' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'min' ( (lv_min_7_0= ruleEFloat ) ) )? (otherlv_8= 'max' ( (lv_max_9_0= ruleEFloat ) ) )? (otherlv_10= 'clousure' ( (lv_clousure_11_0= ruleClosureType ) ) )? otherlv_12= '}' )
            // InternalWorkflow.g:4069:3: () ( (lv_minInfinity_1_0= 'minInfinity' ) )? ( (lv_maxInfinity_2_0= 'maxInfinity' ) )? otherlv_3= 'Range' ( (lv_name_4_0= ruleEString ) ) otherlv_5= '{' (otherlv_6= 'min' ( (lv_min_7_0= ruleEFloat ) ) )? (otherlv_8= 'max' ( (lv_max_9_0= ruleEFloat ) ) )? (otherlv_10= 'clousure' ( (lv_clousure_11_0= ruleClosureType ) ) )? otherlv_12= '}'
            {
            // InternalWorkflow.g:4069:3: ()
            // InternalWorkflow.g:4070:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRangeAccess().getRangeAction_0(),
            					current);
            			

            }

            // InternalWorkflow.g:4076:3: ( (lv_minInfinity_1_0= 'minInfinity' ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==80) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalWorkflow.g:4077:4: (lv_minInfinity_1_0= 'minInfinity' )
                    {
                    // InternalWorkflow.g:4077:4: (lv_minInfinity_1_0= 'minInfinity' )
                    // InternalWorkflow.g:4078:5: lv_minInfinity_1_0= 'minInfinity'
                    {
                    lv_minInfinity_1_0=(Token)match(input,80,FOLLOW_101); 

                    					newLeafNode(lv_minInfinity_1_0, grammarAccess.getRangeAccess().getMinInfinityMinInfinityKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRangeRule());
                    					}
                    					setWithLastConsumed(current, "minInfinity", lv_minInfinity_1_0 != null, "minInfinity");
                    				

                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4090:3: ( (lv_maxInfinity_2_0= 'maxInfinity' ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==81) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalWorkflow.g:4091:4: (lv_maxInfinity_2_0= 'maxInfinity' )
                    {
                    // InternalWorkflow.g:4091:4: (lv_maxInfinity_2_0= 'maxInfinity' )
                    // InternalWorkflow.g:4092:5: lv_maxInfinity_2_0= 'maxInfinity'
                    {
                    lv_maxInfinity_2_0=(Token)match(input,81,FOLLOW_102); 

                    					newLeafNode(lv_maxInfinity_2_0, grammarAccess.getRangeAccess().getMaxInfinityMaxInfinityKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRangeRule());
                    					}
                    					setWithLastConsumed(current, "maxInfinity", lv_maxInfinity_2_0 != null, "maxInfinity");
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,82,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getRangeAccess().getRangeKeyword_3());
            		
            // InternalWorkflow.g:4108:3: ( (lv_name_4_0= ruleEString ) )
            // InternalWorkflow.g:4109:4: (lv_name_4_0= ruleEString )
            {
            // InternalWorkflow.g:4109:4: (lv_name_4_0= ruleEString )
            // InternalWorkflow.g:4110:5: lv_name_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRangeAccess().getNameEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRangeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_4_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,12,FOLLOW_103); 

            			newLeafNode(otherlv_5, grammarAccess.getRangeAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalWorkflow.g:4131:3: (otherlv_6= 'min' ( (lv_min_7_0= ruleEFloat ) ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==83) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalWorkflow.g:4132:4: otherlv_6= 'min' ( (lv_min_7_0= ruleEFloat ) )
                    {
                    otherlv_6=(Token)match(input,83,FOLLOW_77); 

                    				newLeafNode(otherlv_6, grammarAccess.getRangeAccess().getMinKeyword_6_0());
                    			
                    // InternalWorkflow.g:4136:4: ( (lv_min_7_0= ruleEFloat ) )
                    // InternalWorkflow.g:4137:5: (lv_min_7_0= ruleEFloat )
                    {
                    // InternalWorkflow.g:4137:5: (lv_min_7_0= ruleEFloat )
                    // InternalWorkflow.g:4138:6: lv_min_7_0= ruleEFloat
                    {

                    						newCompositeNode(grammarAccess.getRangeAccess().getMinEFloatParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_104);
                    lv_min_7_0=ruleEFloat();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeRule());
                    						}
                    						set(
                    							current,
                    							"min",
                    							lv_min_7_0,
                    							"xtext.Workflow.EFloat");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4156:3: (otherlv_8= 'max' ( (lv_max_9_0= ruleEFloat ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==84) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalWorkflow.g:4157:4: otherlv_8= 'max' ( (lv_max_9_0= ruleEFloat ) )
                    {
                    otherlv_8=(Token)match(input,84,FOLLOW_77); 

                    				newLeafNode(otherlv_8, grammarAccess.getRangeAccess().getMaxKeyword_7_0());
                    			
                    // InternalWorkflow.g:4161:4: ( (lv_max_9_0= ruleEFloat ) )
                    // InternalWorkflow.g:4162:5: (lv_max_9_0= ruleEFloat )
                    {
                    // InternalWorkflow.g:4162:5: (lv_max_9_0= ruleEFloat )
                    // InternalWorkflow.g:4163:6: lv_max_9_0= ruleEFloat
                    {

                    						newCompositeNode(grammarAccess.getRangeAccess().getMaxEFloatParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_79);
                    lv_max_9_0=ruleEFloat();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_9_0,
                    							"xtext.Workflow.EFloat");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4181:3: (otherlv_10= 'clousure' ( (lv_clousure_11_0= ruleClosureType ) ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==60) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalWorkflow.g:4182:4: otherlv_10= 'clousure' ( (lv_clousure_11_0= ruleClosureType ) )
                    {
                    otherlv_10=(Token)match(input,60,FOLLOW_80); 

                    				newLeafNode(otherlv_10, grammarAccess.getRangeAccess().getClousureKeyword_8_0());
                    			
                    // InternalWorkflow.g:4186:4: ( (lv_clousure_11_0= ruleClosureType ) )
                    // InternalWorkflow.g:4187:5: (lv_clousure_11_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:4187:5: (lv_clousure_11_0= ruleClosureType )
                    // InternalWorkflow.g:4188:6: lv_clousure_11_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getRangeAccess().getClousureClosureTypeEnumRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_clousure_11_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_11_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getRangeAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleSpecialValues"
    // InternalWorkflow.g:4214:1: entryRuleSpecialValues returns [EObject current=null] : iv_ruleSpecialValues= ruleSpecialValues EOF ;
    public final EObject entryRuleSpecialValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecialValues = null;


        try {
            // InternalWorkflow.g:4214:54: (iv_ruleSpecialValues= ruleSpecialValues EOF )
            // InternalWorkflow.g:4215:2: iv_ruleSpecialValues= ruleSpecialValues EOF
            {
             newCompositeNode(grammarAccess.getSpecialValuesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecialValues=ruleSpecialValues();

            state._fsp--;

             current =iv_ruleSpecialValues; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecialValues"


    // $ANTLR start "ruleSpecialValues"
    // InternalWorkflow.g:4221:1: ruleSpecialValues returns [EObject current=null] : ( () otherlv_1= 'SpecialValues' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'specialType' ( (lv_specialType_5_0= ruleSpecialValue ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleSpecialValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_specialType_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4227:2: ( ( () otherlv_1= 'SpecialValues' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'specialType' ( (lv_specialType_5_0= ruleSpecialValue ) ) )? otherlv_6= '}' ) )
            // InternalWorkflow.g:4228:2: ( () otherlv_1= 'SpecialValues' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'specialType' ( (lv_specialType_5_0= ruleSpecialValue ) ) )? otherlv_6= '}' )
            {
            // InternalWorkflow.g:4228:2: ( () otherlv_1= 'SpecialValues' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'specialType' ( (lv_specialType_5_0= ruleSpecialValue ) ) )? otherlv_6= '}' )
            // InternalWorkflow.g:4229:3: () otherlv_1= 'SpecialValues' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'specialType' ( (lv_specialType_5_0= ruleSpecialValue ) ) )? otherlv_6= '}'
            {
            // InternalWorkflow.g:4229:3: ()
            // InternalWorkflow.g:4230:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpecialValuesAccess().getSpecialValuesAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,85,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecialValuesAccess().getSpecialValuesKeyword_1());
            		
            // InternalWorkflow.g:4240:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:4241:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:4241:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:4242:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSpecialValuesAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecialValuesRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_105); 

            			newLeafNode(otherlv_3, grammarAccess.getSpecialValuesAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:4263:3: (otherlv_4= 'specialType' ( (lv_specialType_5_0= ruleSpecialValue ) ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==86) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalWorkflow.g:4264:4: otherlv_4= 'specialType' ( (lv_specialType_5_0= ruleSpecialValue ) )
                    {
                    otherlv_4=(Token)match(input,86,FOLLOW_106); 

                    				newLeafNode(otherlv_4, grammarAccess.getSpecialValuesAccess().getSpecialTypeKeyword_4_0());
                    			
                    // InternalWorkflow.g:4268:4: ( (lv_specialType_5_0= ruleSpecialValue ) )
                    // InternalWorkflow.g:4269:5: (lv_specialType_5_0= ruleSpecialValue )
                    {
                    // InternalWorkflow.g:4269:5: (lv_specialType_5_0= ruleSpecialValue )
                    // InternalWorkflow.g:4270:6: lv_specialType_5_0= ruleSpecialValue
                    {

                    						newCompositeNode(grammarAccess.getSpecialValuesAccess().getSpecialTypeSpecialValueEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_specialType_5_0=ruleSpecialValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSpecialValuesRule());
                    						}
                    						set(
                    							current,
                    							"specialType",
                    							lv_specialType_5_0,
                    							"xtext.Workflow.SpecialValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSpecialValuesAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialValues"


    // $ANTLR start "entryRuleDiscretizeBin"
    // InternalWorkflow.g:4296:1: entryRuleDiscretizeBin returns [EObject current=null] : iv_ruleDiscretizeBin= ruleDiscretizeBin EOF ;
    public final EObject entryRuleDiscretizeBin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiscretizeBin = null;


        try {
            // InternalWorkflow.g:4296:54: (iv_ruleDiscretizeBin= ruleDiscretizeBin EOF )
            // InternalWorkflow.g:4297:2: iv_ruleDiscretizeBin= ruleDiscretizeBin EOF
            {
             newCompositeNode(grammarAccess.getDiscretizeBinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDiscretizeBin=ruleDiscretizeBin();

            state._fsp--;

             current =iv_ruleDiscretizeBin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDiscretizeBin"


    // $ANTLR start "ruleDiscretizeBin"
    // InternalWorkflow.g:4303:1: ruleDiscretizeBin returns [EObject current=null] : (otherlv_0= 'DiscretizeBin' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'binValue' ( (lv_binValue_4_0= ruleEString ) ) )? otherlv_5= 'interval' otherlv_6= '{' ( (lv_interval_7_0= ruleInterval ) ) (otherlv_8= ',' ( (lv_interval_9_0= ruleInterval ) ) )* otherlv_10= '}' otherlv_11= '}' ) ;
    public final EObject ruleDiscretizeBin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_binValue_4_0 = null;

        EObject lv_interval_7_0 = null;

        EObject lv_interval_9_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4309:2: ( (otherlv_0= 'DiscretizeBin' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'binValue' ( (lv_binValue_4_0= ruleEString ) ) )? otherlv_5= 'interval' otherlv_6= '{' ( (lv_interval_7_0= ruleInterval ) ) (otherlv_8= ',' ( (lv_interval_9_0= ruleInterval ) ) )* otherlv_10= '}' otherlv_11= '}' ) )
            // InternalWorkflow.g:4310:2: (otherlv_0= 'DiscretizeBin' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'binValue' ( (lv_binValue_4_0= ruleEString ) ) )? otherlv_5= 'interval' otherlv_6= '{' ( (lv_interval_7_0= ruleInterval ) ) (otherlv_8= ',' ( (lv_interval_9_0= ruleInterval ) ) )* otherlv_10= '}' otherlv_11= '}' )
            {
            // InternalWorkflow.g:4310:2: (otherlv_0= 'DiscretizeBin' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'binValue' ( (lv_binValue_4_0= ruleEString ) ) )? otherlv_5= 'interval' otherlv_6= '{' ( (lv_interval_7_0= ruleInterval ) ) (otherlv_8= ',' ( (lv_interval_9_0= ruleInterval ) ) )* otherlv_10= '}' otherlv_11= '}' )
            // InternalWorkflow.g:4311:3: otherlv_0= 'DiscretizeBin' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'binValue' ( (lv_binValue_4_0= ruleEString ) ) )? otherlv_5= 'interval' otherlv_6= '{' ( (lv_interval_7_0= ruleInterval ) ) (otherlv_8= ',' ( (lv_interval_9_0= ruleInterval ) ) )* otherlv_10= '}' otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,87,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDiscretizeBinAccess().getDiscretizeBinKeyword_0());
            		
            // InternalWorkflow.g:4315:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:4316:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:4316:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:4317:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDiscretizeBinAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDiscretizeBinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_107); 

            			newLeafNode(otherlv_2, grammarAccess.getDiscretizeBinAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:4338:3: (otherlv_3= 'binValue' ( (lv_binValue_4_0= ruleEString ) ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==88) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalWorkflow.g:4339:4: otherlv_3= 'binValue' ( (lv_binValue_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,88,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDiscretizeBinAccess().getBinValueKeyword_3_0());
                    			
                    // InternalWorkflow.g:4343:4: ( (lv_binValue_4_0= ruleEString ) )
                    // InternalWorkflow.g:4344:5: (lv_binValue_4_0= ruleEString )
                    {
                    // InternalWorkflow.g:4344:5: (lv_binValue_4_0= ruleEString )
                    // InternalWorkflow.g:4345:6: lv_binValue_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDiscretizeBinAccess().getBinValueEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_61);
                    lv_binValue_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDiscretizeBinRule());
                    						}
                    						set(
                    							current,
                    							"binValue",
                    							lv_binValue_4_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getDiscretizeBinAccess().getIntervalKeyword_4());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_62); 

            			newLeafNode(otherlv_6, grammarAccess.getDiscretizeBinAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalWorkflow.g:4371:3: ( (lv_interval_7_0= ruleInterval ) )
            // InternalWorkflow.g:4372:4: (lv_interval_7_0= ruleInterval )
            {
            // InternalWorkflow.g:4372:4: (lv_interval_7_0= ruleInterval )
            // InternalWorkflow.g:4373:5: lv_interval_7_0= ruleInterval
            {

            					newCompositeNode(grammarAccess.getDiscretizeBinAccess().getIntervalIntervalParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
            lv_interval_7_0=ruleInterval();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDiscretizeBinRule());
            					}
            					add(
            						current,
            						"interval",
            						lv_interval_7_0,
            						"xtext.Workflow.Interval");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:4390:3: (otherlv_8= ',' ( (lv_interval_9_0= ruleInterval ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==14) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalWorkflow.g:4391:4: otherlv_8= ',' ( (lv_interval_9_0= ruleInterval ) )
            	    {
            	    otherlv_8=(Token)match(input,14,FOLLOW_62); 

            	    				newLeafNode(otherlv_8, grammarAccess.getDiscretizeBinAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalWorkflow.g:4395:4: ( (lv_interval_9_0= ruleInterval ) )
            	    // InternalWorkflow.g:4396:5: (lv_interval_9_0= ruleInterval )
            	    {
            	    // InternalWorkflow.g:4396:5: (lv_interval_9_0= ruleInterval )
            	    // InternalWorkflow.g:4397:6: lv_interval_9_0= ruleInterval
            	    {

            	    						newCompositeNode(grammarAccess.getDiscretizeBinAccess().getIntervalIntervalParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_interval_9_0=ruleInterval();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDiscretizeBinRule());
            	    						}
            	    						add(
            	    							current,
            	    							"interval",
            	    							lv_interval_9_0,
            	    							"xtext.Workflow.Interval");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);

            otherlv_10=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getDiscretizeBinAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_11=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDiscretizeBinAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDiscretizeBin"


    // $ANTLR start "entryRuleCastType"
    // InternalWorkflow.g:4427:1: entryRuleCastType returns [EObject current=null] : iv_ruleCastType= ruleCastType EOF ;
    public final EObject entryRuleCastType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastType = null;


        try {
            // InternalWorkflow.g:4427:49: (iv_ruleCastType= ruleCastType EOF )
            // InternalWorkflow.g:4428:2: iv_ruleCastType= ruleCastType EOF
            {
             newCompositeNode(grammarAccess.getCastTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCastType=ruleCastType();

            state._fsp--;

             current =iv_ruleCastType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastType"


    // $ANTLR start "ruleCastType"
    // InternalWorkflow.g:4434:1: ruleCastType returns [EObject current=null] : ( () otherlv_1= 'CastType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleDataType ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleCastType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4440:2: ( ( () otherlv_1= 'CastType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleDataType ) ) )? otherlv_6= '}' ) )
            // InternalWorkflow.g:4441:2: ( () otherlv_1= 'CastType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleDataType ) ) )? otherlv_6= '}' )
            {
            // InternalWorkflow.g:4441:2: ( () otherlv_1= 'CastType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleDataType ) ) )? otherlv_6= '}' )
            // InternalWorkflow.g:4442:3: () otherlv_1= 'CastType' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleDataType ) ) )? otherlv_6= '}'
            {
            // InternalWorkflow.g:4442:3: ()
            // InternalWorkflow.g:4443:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCastTypeAccess().getCastTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,89,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCastTypeAccess().getCastTypeKeyword_1());
            		
            // InternalWorkflow.g:4453:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:4454:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:4454:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:4455:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCastTypeAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCastTypeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_108); 

            			newLeafNode(otherlv_3, grammarAccess.getCastTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:4476:3: (otherlv_4= 'type' ( (lv_type_5_0= ruleDataType ) ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==90) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalWorkflow.g:4477:4: otherlv_4= 'type' ( (lv_type_5_0= ruleDataType ) )
                    {
                    otherlv_4=(Token)match(input,90,FOLLOW_43); 

                    				newLeafNode(otherlv_4, grammarAccess.getCastTypeAccess().getTypeKeyword_4_0());
                    			
                    // InternalWorkflow.g:4481:4: ( (lv_type_5_0= ruleDataType ) )
                    // InternalWorkflow.g:4482:5: (lv_type_5_0= ruleDataType )
                    {
                    // InternalWorkflow.g:4482:5: (lv_type_5_0= ruleDataType )
                    // InternalWorkflow.g:4483:6: lv_type_5_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getCastTypeAccess().getTypeDataTypeEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_type_5_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCastTypeRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_5_0,
                    							"xtext.Workflow.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCastTypeAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastType"


    // $ANTLR start "entryRuleDerivedValue"
    // InternalWorkflow.g:4509:1: entryRuleDerivedValue returns [EObject current=null] : iv_ruleDerivedValue= ruleDerivedValue EOF ;
    public final EObject entryRuleDerivedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedValue = null;


        try {
            // InternalWorkflow.g:4509:53: (iv_ruleDerivedValue= ruleDerivedValue EOF )
            // InternalWorkflow.g:4510:2: iv_ruleDerivedValue= ruleDerivedValue EOF
            {
             newCompositeNode(grammarAccess.getDerivedValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDerivedValue=ruleDerivedValue();

            state._fsp--;

             current =iv_ruleDerivedValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDerivedValue"


    // $ANTLR start "ruleDerivedValue"
    // InternalWorkflow.g:4516:1: ruleDerivedValue returns [EObject current=null] : ( () otherlv_1= 'DerivedValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'type' ( (lv_type_7_0= ruleDerivedType ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleDerivedValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_imputeValue_5_0 = null;

        Enumerator lv_type_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4522:2: ( ( () otherlv_1= 'DerivedValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'type' ( (lv_type_7_0= ruleDerivedType ) ) )? otherlv_8= '}' ) )
            // InternalWorkflow.g:4523:2: ( () otherlv_1= 'DerivedValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'type' ( (lv_type_7_0= ruleDerivedType ) ) )? otherlv_8= '}' )
            {
            // InternalWorkflow.g:4523:2: ( () otherlv_1= 'DerivedValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'type' ( (lv_type_7_0= ruleDerivedType ) ) )? otherlv_8= '}' )
            // InternalWorkflow.g:4524:3: () otherlv_1= 'DerivedValue' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'type' ( (lv_type_7_0= ruleDerivedType ) ) )? otherlv_8= '}'
            {
            // InternalWorkflow.g:4524:3: ()
            // InternalWorkflow.g:4525:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDerivedValueAccess().getDerivedValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,91,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDerivedValueAccess().getDerivedValueKeyword_1());
            		
            // InternalWorkflow.g:4535:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:4536:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:4536:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:4537:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDerivedValueAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedValueRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_109); 

            			newLeafNode(otherlv_3, grammarAccess.getDerivedValueAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:4558:3: (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==92) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalWorkflow.g:4559:4: otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) )
                    {
                    otherlv_4=(Token)match(input,92,FOLLOW_106); 

                    				newLeafNode(otherlv_4, grammarAccess.getDerivedValueAccess().getImputeValueKeyword_4_0());
                    			
                    // InternalWorkflow.g:4563:4: ( (lv_imputeValue_5_0= ruleSpecialValue ) )
                    // InternalWorkflow.g:4564:5: (lv_imputeValue_5_0= ruleSpecialValue )
                    {
                    // InternalWorkflow.g:4564:5: (lv_imputeValue_5_0= ruleSpecialValue )
                    // InternalWorkflow.g:4565:6: lv_imputeValue_5_0= ruleSpecialValue
                    {

                    						newCompositeNode(grammarAccess.getDerivedValueAccess().getImputeValueSpecialValueEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_108);
                    lv_imputeValue_5_0=ruleSpecialValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDerivedValueRule());
                    						}
                    						set(
                    							current,
                    							"imputeValue",
                    							lv_imputeValue_5_0,
                    							"xtext.Workflow.SpecialValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4583:3: (otherlv_6= 'type' ( (lv_type_7_0= ruleDerivedType ) ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==90) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalWorkflow.g:4584:4: otherlv_6= 'type' ( (lv_type_7_0= ruleDerivedType ) )
                    {
                    otherlv_6=(Token)match(input,90,FOLLOW_110); 

                    				newLeafNode(otherlv_6, grammarAccess.getDerivedValueAccess().getTypeKeyword_5_0());
                    			
                    // InternalWorkflow.g:4588:4: ( (lv_type_7_0= ruleDerivedType ) )
                    // InternalWorkflow.g:4589:5: (lv_type_7_0= ruleDerivedType )
                    {
                    // InternalWorkflow.g:4589:5: (lv_type_7_0= ruleDerivedType )
                    // InternalWorkflow.g:4590:6: lv_type_7_0= ruleDerivedType
                    {

                    						newCompositeNode(grammarAccess.getDerivedValueAccess().getTypeDerivedTypeEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_type_7_0=ruleDerivedType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDerivedValueRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_7_0,
                    							"xtext.Workflow.DerivedType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDerivedValueAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDerivedValue"


    // $ANTLR start "entryRuleNumOp"
    // InternalWorkflow.g:4616:1: entryRuleNumOp returns [EObject current=null] : iv_ruleNumOp= ruleNumOp EOF ;
    public final EObject entryRuleNumOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumOp = null;


        try {
            // InternalWorkflow.g:4616:46: (iv_ruleNumOp= ruleNumOp EOF )
            // InternalWorkflow.g:4617:2: iv_ruleNumOp= ruleNumOp EOF
            {
             newCompositeNode(grammarAccess.getNumOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumOp=ruleNumOp();

            state._fsp--;

             current =iv_ruleNumOp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumOp"


    // $ANTLR start "ruleNumOp"
    // InternalWorkflow.g:4623:1: ruleNumOp returns [EObject current=null] : ( () otherlv_1= 'NumOp' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'operation' ( (lv_operation_7_0= ruleOperation ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleNumOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_imputeValue_5_0 = null;

        Enumerator lv_operation_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4629:2: ( ( () otherlv_1= 'NumOp' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'operation' ( (lv_operation_7_0= ruleOperation ) ) )? otherlv_8= '}' ) )
            // InternalWorkflow.g:4630:2: ( () otherlv_1= 'NumOp' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'operation' ( (lv_operation_7_0= ruleOperation ) ) )? otherlv_8= '}' )
            {
            // InternalWorkflow.g:4630:2: ( () otherlv_1= 'NumOp' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'operation' ( (lv_operation_7_0= ruleOperation ) ) )? otherlv_8= '}' )
            // InternalWorkflow.g:4631:3: () otherlv_1= 'NumOp' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )? (otherlv_6= 'operation' ( (lv_operation_7_0= ruleOperation ) ) )? otherlv_8= '}'
            {
            // InternalWorkflow.g:4631:3: ()
            // InternalWorkflow.g:4632:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumOpAccess().getNumOpAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,93,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getNumOpAccess().getNumOpKeyword_1());
            		
            // InternalWorkflow.g:4642:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:4643:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:4643:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:4644:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getNumOpAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumOpRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_111); 

            			newLeafNode(otherlv_3, grammarAccess.getNumOpAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:4665:3: (otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==92) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalWorkflow.g:4666:4: otherlv_4= 'imputeValue' ( (lv_imputeValue_5_0= ruleSpecialValue ) )
                    {
                    otherlv_4=(Token)match(input,92,FOLLOW_106); 

                    				newLeafNode(otherlv_4, grammarAccess.getNumOpAccess().getImputeValueKeyword_4_0());
                    			
                    // InternalWorkflow.g:4670:4: ( (lv_imputeValue_5_0= ruleSpecialValue ) )
                    // InternalWorkflow.g:4671:5: (lv_imputeValue_5_0= ruleSpecialValue )
                    {
                    // InternalWorkflow.g:4671:5: (lv_imputeValue_5_0= ruleSpecialValue )
                    // InternalWorkflow.g:4672:6: lv_imputeValue_5_0= ruleSpecialValue
                    {

                    						newCompositeNode(grammarAccess.getNumOpAccess().getImputeValueSpecialValueEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_112);
                    lv_imputeValue_5_0=ruleSpecialValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumOpRule());
                    						}
                    						set(
                    							current,
                    							"imputeValue",
                    							lv_imputeValue_5_0,
                    							"xtext.Workflow.SpecialValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4690:3: (otherlv_6= 'operation' ( (lv_operation_7_0= ruleOperation ) ) )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==94) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalWorkflow.g:4691:4: otherlv_6= 'operation' ( (lv_operation_7_0= ruleOperation ) )
                    {
                    otherlv_6=(Token)match(input,94,FOLLOW_113); 

                    				newLeafNode(otherlv_6, grammarAccess.getNumOpAccess().getOperationKeyword_5_0());
                    			
                    // InternalWorkflow.g:4695:4: ( (lv_operation_7_0= ruleOperation ) )
                    // InternalWorkflow.g:4696:5: (lv_operation_7_0= ruleOperation )
                    {
                    // InternalWorkflow.g:4696:5: (lv_operation_7_0= ruleOperation )
                    // InternalWorkflow.g:4697:6: lv_operation_7_0= ruleOperation
                    {

                    						newCompositeNode(grammarAccess.getNumOpAccess().getOperationOperationEnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_operation_7_0=ruleOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumOpRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_7_0,
                    							"xtext.Workflow.Operation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getNumOpAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumOp"


    // $ANTLR start "entryRuleFixValue"
    // InternalWorkflow.g:4723:1: entryRuleFixValue returns [EObject current=null] : iv_ruleFixValue= ruleFixValue EOF ;
    public final EObject entryRuleFixValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixValue = null;


        try {
            // InternalWorkflow.g:4723:49: (iv_ruleFixValue= ruleFixValue EOF )
            // InternalWorkflow.g:4724:2: iv_ruleFixValue= ruleFixValue EOF
            {
             newCompositeNode(grammarAccess.getFixValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixValue=ruleFixValue();

            state._fsp--;

             current =iv_ruleFixValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixValue"


    // $ANTLR start "ruleFixValue"
    // InternalWorkflow.g:4730:1: ruleFixValue returns [EObject current=null] : (otherlv_0= 'FixValue' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'imputeValue' ( (lv_imputeValue_4_0= ruleSpecialValue ) ) )? (otherlv_5= 'next_operand' ( ( ruleEString ) ) )? (otherlv_7= 'previous_operand' ( ( ruleEString ) ) )? otherlv_9= 'value' ( (lv_value_10_0= rulePrimitive ) ) otherlv_11= '}' ) ;
    public final EObject ruleFixValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_imputeValue_4_0 = null;

        EObject lv_value_10_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4736:2: ( (otherlv_0= 'FixValue' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'imputeValue' ( (lv_imputeValue_4_0= ruleSpecialValue ) ) )? (otherlv_5= 'next_operand' ( ( ruleEString ) ) )? (otherlv_7= 'previous_operand' ( ( ruleEString ) ) )? otherlv_9= 'value' ( (lv_value_10_0= rulePrimitive ) ) otherlv_11= '}' ) )
            // InternalWorkflow.g:4737:2: (otherlv_0= 'FixValue' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'imputeValue' ( (lv_imputeValue_4_0= ruleSpecialValue ) ) )? (otherlv_5= 'next_operand' ( ( ruleEString ) ) )? (otherlv_7= 'previous_operand' ( ( ruleEString ) ) )? otherlv_9= 'value' ( (lv_value_10_0= rulePrimitive ) ) otherlv_11= '}' )
            {
            // InternalWorkflow.g:4737:2: (otherlv_0= 'FixValue' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'imputeValue' ( (lv_imputeValue_4_0= ruleSpecialValue ) ) )? (otherlv_5= 'next_operand' ( ( ruleEString ) ) )? (otherlv_7= 'previous_operand' ( ( ruleEString ) ) )? otherlv_9= 'value' ( (lv_value_10_0= rulePrimitive ) ) otherlv_11= '}' )
            // InternalWorkflow.g:4738:3: otherlv_0= 'FixValue' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'imputeValue' ( (lv_imputeValue_4_0= ruleSpecialValue ) ) )? (otherlv_5= 'next_operand' ( ( ruleEString ) ) )? (otherlv_7= 'previous_operand' ( ( ruleEString ) ) )? otherlv_9= 'value' ( (lv_value_10_0= rulePrimitive ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFixValueAccess().getFixValueKeyword_0());
            		
            // InternalWorkflow.g:4742:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:4743:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:4743:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:4744:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFixValueAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFixValueRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_114); 

            			newLeafNode(otherlv_2, grammarAccess.getFixValueAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:4765:3: (otherlv_3= 'imputeValue' ( (lv_imputeValue_4_0= ruleSpecialValue ) ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==92) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalWorkflow.g:4766:4: otherlv_3= 'imputeValue' ( (lv_imputeValue_4_0= ruleSpecialValue ) )
                    {
                    otherlv_3=(Token)match(input,92,FOLLOW_106); 

                    				newLeafNode(otherlv_3, grammarAccess.getFixValueAccess().getImputeValueKeyword_3_0());
                    			
                    // InternalWorkflow.g:4770:4: ( (lv_imputeValue_4_0= ruleSpecialValue ) )
                    // InternalWorkflow.g:4771:5: (lv_imputeValue_4_0= ruleSpecialValue )
                    {
                    // InternalWorkflow.g:4771:5: (lv_imputeValue_4_0= ruleSpecialValue )
                    // InternalWorkflow.g:4772:6: lv_imputeValue_4_0= ruleSpecialValue
                    {

                    						newCompositeNode(grammarAccess.getFixValueAccess().getImputeValueSpecialValueEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_115);
                    lv_imputeValue_4_0=ruleSpecialValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFixValueRule());
                    						}
                    						set(
                    							current,
                    							"imputeValue",
                    							lv_imputeValue_4_0,
                    							"xtext.Workflow.SpecialValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4790:3: (otherlv_5= 'next_operand' ( ( ruleEString ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==96) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalWorkflow.g:4791:4: otherlv_5= 'next_operand' ( ( ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,96,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getFixValueAccess().getNext_operandKeyword_4_0());
                    			
                    // InternalWorkflow.g:4795:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:4796:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:4796:5: ( ruleEString )
                    // InternalWorkflow.g:4797:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFixValueRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFixValueAccess().getNext_operandOperandCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_116);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4812:3: (otherlv_7= 'previous_operand' ( ( ruleEString ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==97) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalWorkflow.g:4813:4: otherlv_7= 'previous_operand' ( ( ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,97,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getFixValueAccess().getPrevious_operandKeyword_5_0());
                    			
                    // InternalWorkflow.g:4817:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:4818:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:4818:5: ( ruleEString )
                    // InternalWorkflow.g:4819:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFixValueRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFixValueAccess().getPrevious_operandOperandCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_117);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,40,FOLLOW_99); 

            			newLeafNode(otherlv_9, grammarAccess.getFixValueAccess().getValueKeyword_6());
            		
            // InternalWorkflow.g:4838:3: ( (lv_value_10_0= rulePrimitive ) )
            // InternalWorkflow.g:4839:4: (lv_value_10_0= rulePrimitive )
            {
            // InternalWorkflow.g:4839:4: (lv_value_10_0= rulePrimitive )
            // InternalWorkflow.g:4840:5: lv_value_10_0= rulePrimitive
            {

            					newCompositeNode(grammarAccess.getFixValueAccess().getValuePrimitiveParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_10);
            lv_value_10_0=rulePrimitive();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFixValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_10_0,
            						"xtext.Workflow.Primitive");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getFixValueAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFixValue"


    // $ANTLR start "entryRuleFieldRange"
    // InternalWorkflow.g:4865:1: entryRuleFieldRange returns [EObject current=null] : iv_ruleFieldRange= ruleFieldRange EOF ;
    public final EObject entryRuleFieldRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldRange = null;


        try {
            // InternalWorkflow.g:4865:51: (iv_ruleFieldRange= ruleFieldRange EOF )
            // InternalWorkflow.g:4866:2: iv_ruleFieldRange= ruleFieldRange EOF
            {
             newCompositeNode(grammarAccess.getFieldRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldRange=ruleFieldRange();

            state._fsp--;

             current =iv_ruleFieldRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldRange"


    // $ANTLR start "ruleFieldRange"
    // InternalWorkflow.g:4872:1: ruleFieldRange returns [EObject current=null] : (otherlv_0= 'FieldRange' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleOperator ) ) )? otherlv_5= 'dataField' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' ) ;
    public final EObject ruleFieldRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_operator_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4878:2: ( (otherlv_0= 'FieldRange' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleOperator ) ) )? otherlv_5= 'dataField' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' ) )
            // InternalWorkflow.g:4879:2: (otherlv_0= 'FieldRange' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleOperator ) ) )? otherlv_5= 'dataField' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' )
            {
            // InternalWorkflow.g:4879:2: (otherlv_0= 'FieldRange' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleOperator ) ) )? otherlv_5= 'dataField' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}' )
            // InternalWorkflow.g:4880:3: otherlv_0= 'FieldRange' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleOperator ) ) )? otherlv_5= 'dataField' otherlv_6= '(' ( ( ruleEString ) ) (otherlv_8= ',' ( ( ruleEString ) ) )* otherlv_10= ')' otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldRangeAccess().getFieldRangeKeyword_0());
            		
            // InternalWorkflow.g:4884:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:4885:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:4885:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:4886:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFieldRangeAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRangeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_118); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldRangeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:4907:3: (otherlv_3= 'operator' ( (lv_operator_4_0= ruleOperator ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==99) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalWorkflow.g:4908:4: otherlv_3= 'operator' ( (lv_operator_4_0= ruleOperator ) )
                    {
                    otherlv_3=(Token)match(input,99,FOLLOW_119); 

                    				newLeafNode(otherlv_3, grammarAccess.getFieldRangeAccess().getOperatorKeyword_3_0());
                    			
                    // InternalWorkflow.g:4912:4: ( (lv_operator_4_0= ruleOperator ) )
                    // InternalWorkflow.g:4913:5: (lv_operator_4_0= ruleOperator )
                    {
                    // InternalWorkflow.g:4913:5: (lv_operator_4_0= ruleOperator )
                    // InternalWorkflow.g:4914:6: lv_operator_4_0= ruleOperator
                    {

                    						newCompositeNode(grammarAccess.getFieldRangeAccess().getOperatorOperatorEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_120);
                    lv_operator_4_0=ruleOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFieldRangeRule());
                    						}
                    						set(
                    							current,
                    							"operator",
                    							lv_operator_4_0,
                    							"xtext.Workflow.Operator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,100,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getFieldRangeAccess().getDataFieldKeyword_4());
            		
            otherlv_6=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getFieldRangeAccess().getLeftParenthesisKeyword_5());
            		
            // InternalWorkflow.g:4940:3: ( ( ruleEString ) )
            // InternalWorkflow.g:4941:4: ( ruleEString )
            {
            // InternalWorkflow.g:4941:4: ( ruleEString )
            // InternalWorkflow.g:4942:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFieldRangeAccess().getDataFieldDataFieldCrossReference_6_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:4956:3: (otherlv_8= ',' ( ( ruleEString ) ) )*
            loop124:
            do {
                int alt124=2;
                int LA124_0 = input.LA(1);

                if ( (LA124_0==14) ) {
                    alt124=1;
                }


                switch (alt124) {
            	case 1 :
            	    // InternalWorkflow.g:4957:4: otherlv_8= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_8, grammarAccess.getFieldRangeAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalWorkflow.g:4961:4: ( ( ruleEString ) )
            	    // InternalWorkflow.g:4962:5: ( ruleEString )
            	    {
            	    // InternalWorkflow.g:4962:5: ( ruleEString )
            	    // InternalWorkflow.g:4963:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getFieldRangeRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getFieldRangeAccess().getDataFieldDataFieldCrossReference_7_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop124;
                }
            } while (true);

            otherlv_10=(Token)match(input,32,FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getFieldRangeAccess().getRightParenthesisKeyword_8());
            		
            otherlv_11=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getFieldRangeAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldRange"


    // $ANTLR start "entryRuleMathOp"
    // InternalWorkflow.g:4990:1: entryRuleMathOp returns [EObject current=null] : iv_ruleMathOp= ruleMathOp EOF ;
    public final EObject entryRuleMathOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathOp = null;


        try {
            // InternalWorkflow.g:4990:47: (iv_ruleMathOp= ruleMathOp EOF )
            // InternalWorkflow.g:4991:2: iv_ruleMathOp= ruleMathOp EOF
            {
             newCompositeNode(grammarAccess.getMathOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathOp=ruleMathOp();

            state._fsp--;

             current =iv_ruleMathOp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMathOp"


    // $ANTLR start "ruleMathOp"
    // InternalWorkflow.g:4997:1: ruleMathOp returns [EObject current=null] : (otherlv_0= 'MathOp' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleMathOperator ) ) )? otherlv_5= 'operand' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) ) (otherlv_8= ',' ( (lv_operand_9_0= ruleOperand ) ) )* otherlv_10= '}' otherlv_11= '}' ) ;
    public final EObject ruleMathOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_operator_4_0 = null;

        EObject lv_operand_7_0 = null;

        EObject lv_operand_9_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5003:2: ( (otherlv_0= 'MathOp' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleMathOperator ) ) )? otherlv_5= 'operand' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) ) (otherlv_8= ',' ( (lv_operand_9_0= ruleOperand ) ) )* otherlv_10= '}' otherlv_11= '}' ) )
            // InternalWorkflow.g:5004:2: (otherlv_0= 'MathOp' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleMathOperator ) ) )? otherlv_5= 'operand' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) ) (otherlv_8= ',' ( (lv_operand_9_0= ruleOperand ) ) )* otherlv_10= '}' otherlv_11= '}' )
            {
            // InternalWorkflow.g:5004:2: (otherlv_0= 'MathOp' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleMathOperator ) ) )? otherlv_5= 'operand' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) ) (otherlv_8= ',' ( (lv_operand_9_0= ruleOperand ) ) )* otherlv_10= '}' otherlv_11= '}' )
            // InternalWorkflow.g:5005:3: otherlv_0= 'MathOp' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'operator' ( (lv_operator_4_0= ruleMathOperator ) ) )? otherlv_5= 'operand' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) ) (otherlv_8= ',' ( (lv_operand_9_0= ruleOperand ) ) )* otherlv_10= '}' otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMathOpAccess().getMathOpKeyword_0());
            		
            // InternalWorkflow.g:5009:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:5010:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:5010:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:5011:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMathOpAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathOpRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_121); 

            			newLeafNode(otherlv_2, grammarAccess.getMathOpAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:5032:3: (otherlv_3= 'operator' ( (lv_operator_4_0= ruleMathOperator ) ) )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==99) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalWorkflow.g:5033:4: otherlv_3= 'operator' ( (lv_operator_4_0= ruleMathOperator ) )
                    {
                    otherlv_3=(Token)match(input,99,FOLLOW_122); 

                    				newLeafNode(otherlv_3, grammarAccess.getMathOpAccess().getOperatorKeyword_3_0());
                    			
                    // InternalWorkflow.g:5037:4: ( (lv_operator_4_0= ruleMathOperator ) )
                    // InternalWorkflow.g:5038:5: (lv_operator_4_0= ruleMathOperator )
                    {
                    // InternalWorkflow.g:5038:5: (lv_operator_4_0= ruleMathOperator )
                    // InternalWorkflow.g:5039:6: lv_operator_4_0= ruleMathOperator
                    {

                    						newCompositeNode(grammarAccess.getMathOpAccess().getOperatorMathOperatorEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_123);
                    lv_operator_4_0=ruleMathOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathOpRule());
                    						}
                    						set(
                    							current,
                    							"operator",
                    							lv_operator_4_0,
                    							"xtext.Workflow.MathOperator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,102,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getMathOpAccess().getOperandKeyword_4());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_124); 

            			newLeafNode(otherlv_6, grammarAccess.getMathOpAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalWorkflow.g:5065:3: ( (lv_operand_7_0= ruleOperand ) )
            // InternalWorkflow.g:5066:4: (lv_operand_7_0= ruleOperand )
            {
            // InternalWorkflow.g:5066:4: (lv_operand_7_0= ruleOperand )
            // InternalWorkflow.g:5067:5: lv_operand_7_0= ruleOperand
            {

            					newCompositeNode(grammarAccess.getMathOpAccess().getOperandOperandParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
            lv_operand_7_0=ruleOperand();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathOpRule());
            					}
            					add(
            						current,
            						"operand",
            						lv_operand_7_0,
            						"xtext.Workflow.Operand");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:5084:3: (otherlv_8= ',' ( (lv_operand_9_0= ruleOperand ) ) )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==14) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // InternalWorkflow.g:5085:4: otherlv_8= ',' ( (lv_operand_9_0= ruleOperand ) )
            	    {
            	    otherlv_8=(Token)match(input,14,FOLLOW_124); 

            	    				newLeafNode(otherlv_8, grammarAccess.getMathOpAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalWorkflow.g:5089:4: ( (lv_operand_9_0= ruleOperand ) )
            	    // InternalWorkflow.g:5090:5: (lv_operand_9_0= ruleOperand )
            	    {
            	    // InternalWorkflow.g:5090:5: (lv_operand_9_0= ruleOperand )
            	    // InternalWorkflow.g:5091:6: lv_operand_9_0= ruleOperand
            	    {

            	    						newCompositeNode(grammarAccess.getMathOpAccess().getOperandOperandParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_operand_9_0=ruleOperand();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMathOpRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operand",
            	    							lv_operand_9_0,
            	    							"xtext.Workflow.Operand");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop126;
                }
            } while (true);

            otherlv_10=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getMathOpAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_11=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getMathOpAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathOp"


    // $ANTLR start "entryRuleField"
    // InternalWorkflow.g:5121:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalWorkflow.g:5121:46: (iv_ruleField= ruleField EOF )
            // InternalWorkflow.g:5122:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalWorkflow.g:5128:1: ruleField returns [EObject current=null] : (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'next_operand' ( ( ruleEString ) ) )? (otherlv_5= 'previous_operand' ( ( ruleEString ) ) )? otherlv_7= 'datafield' ( ( ruleEString ) ) otherlv_9= '}' ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5134:2: ( (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'next_operand' ( ( ruleEString ) ) )? (otherlv_5= 'previous_operand' ( ( ruleEString ) ) )? otherlv_7= 'datafield' ( ( ruleEString ) ) otherlv_9= '}' ) )
            // InternalWorkflow.g:5135:2: (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'next_operand' ( ( ruleEString ) ) )? (otherlv_5= 'previous_operand' ( ( ruleEString ) ) )? otherlv_7= 'datafield' ( ( ruleEString ) ) otherlv_9= '}' )
            {
            // InternalWorkflow.g:5135:2: (otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'next_operand' ( ( ruleEString ) ) )? (otherlv_5= 'previous_operand' ( ( ruleEString ) ) )? otherlv_7= 'datafield' ( ( ruleEString ) ) otherlv_9= '}' )
            // InternalWorkflow.g:5136:3: otherlv_0= 'Field' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'next_operand' ( ( ruleEString ) ) )? (otherlv_5= 'previous_operand' ( ( ruleEString ) ) )? otherlv_7= 'datafield' ( ( ruleEString ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldAccess().getFieldKeyword_0());
            		
            // InternalWorkflow.g:5140:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:5141:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:5141:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:5142:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_125); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:5163:3: (otherlv_3= 'next_operand' ( ( ruleEString ) ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==96) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalWorkflow.g:5164:4: otherlv_3= 'next_operand' ( ( ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,96,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getNext_operandKeyword_3_0());
                    			
                    // InternalWorkflow.g:5168:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:5169:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:5169:5: ( ruleEString )
                    // InternalWorkflow.g:5170:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFieldRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFieldAccess().getNext_operandOperandCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_126);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:5185:3: (otherlv_5= 'previous_operand' ( ( ruleEString ) ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==97) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalWorkflow.g:5186:4: otherlv_5= 'previous_operand' ( ( ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,97,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getFieldAccess().getPrevious_operandKeyword_4_0());
                    			
                    // InternalWorkflow.g:5190:4: ( ( ruleEString ) )
                    // InternalWorkflow.g:5191:5: ( ruleEString )
                    {
                    // InternalWorkflow.g:5191:5: ( ruleEString )
                    // InternalWorkflow.g:5192:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFieldRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFieldAccess().getPrevious_operandOperandCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_127);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getFieldAccess().getDatafieldKeyword_5());
            		
            // InternalWorkflow.g:5211:3: ( ( ruleEString ) )
            // InternalWorkflow.g:5212:4: ( ruleEString )
            {
            // InternalWorkflow.g:5212:4: ( ruleEString )
            // InternalWorkflow.g:5213:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFieldAccess().getDatafieldDataFieldCrossReference_6_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFieldAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleJoin"
    // InternalWorkflow.g:5235:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalWorkflow.g:5235:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalWorkflow.g:5236:2: iv_ruleJoin= ruleJoin EOF
            {
             newCompositeNode(grammarAccess.getJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoin=ruleJoin();

            state._fsp--;

             current =iv_ruleJoin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJoin"


    // $ANTLR start "ruleJoin"
    // InternalWorkflow.g:5242:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'operand' otherlv_4= '{' ( (lv_operand_5_0= ruleOperand ) ) (otherlv_6= ',' ( (lv_operand_7_0= ruleOperand ) ) )* otherlv_8= '}' otherlv_9= '}' ) ;
    public final EObject ruleJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_operand_5_0 = null;

        EObject lv_operand_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5248:2: ( (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'operand' otherlv_4= '{' ( (lv_operand_5_0= ruleOperand ) ) (otherlv_6= ',' ( (lv_operand_7_0= ruleOperand ) ) )* otherlv_8= '}' otherlv_9= '}' ) )
            // InternalWorkflow.g:5249:2: (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'operand' otherlv_4= '{' ( (lv_operand_5_0= ruleOperand ) ) (otherlv_6= ',' ( (lv_operand_7_0= ruleOperand ) ) )* otherlv_8= '}' otherlv_9= '}' )
            {
            // InternalWorkflow.g:5249:2: (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'operand' otherlv_4= '{' ( (lv_operand_5_0= ruleOperand ) ) (otherlv_6= ',' ( (lv_operand_7_0= ruleOperand ) ) )* otherlv_8= '}' otherlv_9= '}' )
            // InternalWorkflow.g:5250:3: otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'operand' otherlv_4= '{' ( (lv_operand_5_0= ruleOperand ) ) (otherlv_6= ',' ( (lv_operand_7_0= ruleOperand ) ) )* otherlv_8= '}' otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,104,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
            		
            // InternalWorkflow.g:5254:3: ( (lv_name_1_0= ruleEString ) )
            // InternalWorkflow.g:5255:4: (lv_name_1_0= ruleEString )
            {
            // InternalWorkflow.g:5255:4: (lv_name_1_0= ruleEString )
            // InternalWorkflow.g:5256:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJoinAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_123); 

            			newLeafNode(otherlv_2, grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,102,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getOperandKeyword_3());
            		
            otherlv_4=(Token)match(input,12,FOLLOW_124); 

            			newLeafNode(otherlv_4, grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflow.g:5285:3: ( (lv_operand_5_0= ruleOperand ) )
            // InternalWorkflow.g:5286:4: (lv_operand_5_0= ruleOperand )
            {
            // InternalWorkflow.g:5286:4: (lv_operand_5_0= ruleOperand )
            // InternalWorkflow.g:5287:5: lv_operand_5_0= ruleOperand
            {

            					newCompositeNode(grammarAccess.getJoinAccess().getOperandOperandParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_operand_5_0=ruleOperand();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinRule());
            					}
            					add(
            						current,
            						"operand",
            						lv_operand_5_0,
            						"xtext.Workflow.Operand");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:5304:3: (otherlv_6= ',' ( (lv_operand_7_0= ruleOperand ) ) )*
            loop129:
            do {
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==14) ) {
                    alt129=1;
                }


                switch (alt129) {
            	case 1 :
            	    // InternalWorkflow.g:5305:4: otherlv_6= ',' ( (lv_operand_7_0= ruleOperand ) )
            	    {
            	    otherlv_6=(Token)match(input,14,FOLLOW_124); 

            	    				newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalWorkflow.g:5309:4: ( (lv_operand_7_0= ruleOperand ) )
            	    // InternalWorkflow.g:5310:5: (lv_operand_7_0= ruleOperand )
            	    {
            	    // InternalWorkflow.g:5310:5: (lv_operand_7_0= ruleOperand )
            	    // InternalWorkflow.g:5311:6: lv_operand_7_0= ruleOperand
            	    {

            	    						newCompositeNode(grammarAccess.getJoinAccess().getOperandOperandParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_operand_7_0=ruleOperand();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJoinRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operand",
            	    							lv_operand_7_0,
            	    							"xtext.Workflow.Operand");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop129;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJoin"


    // $ANTLR start "entryRuleDateRange"
    // InternalWorkflow.g:5341:1: entryRuleDateRange returns [EObject current=null] : iv_ruleDateRange= ruleDateRange EOF ;
    public final EObject entryRuleDateRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateRange = null;


        try {
            // InternalWorkflow.g:5341:50: (iv_ruleDateRange= ruleDateRange EOF )
            // InternalWorkflow.g:5342:2: iv_ruleDateRange= ruleDateRange EOF
            {
             newCompositeNode(grammarAccess.getDateRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateRange=ruleDateRange();

            state._fsp--;

             current =iv_ruleDateRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateRange"


    // $ANTLR start "ruleDateRange"
    // InternalWorkflow.g:5348:1: ruleDateRange returns [EObject current=null] : ( () otherlv_1= 'DateRange' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'clousure' ( (lv_clousure_5_0= ruleClosureType ) ) )? (otherlv_6= 'max' ( (lv_max_7_0= ruleEString ) ) )? (otherlv_8= 'min' ( (lv_min_9_0= ruleEString ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleDateRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        Enumerator lv_clousure_5_0 = null;

        AntlrDatatypeRuleToken lv_max_7_0 = null;

        AntlrDatatypeRuleToken lv_min_9_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5354:2: ( ( () otherlv_1= 'DateRange' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'clousure' ( (lv_clousure_5_0= ruleClosureType ) ) )? (otherlv_6= 'max' ( (lv_max_7_0= ruleEString ) ) )? (otherlv_8= 'min' ( (lv_min_9_0= ruleEString ) ) )? otherlv_10= '}' ) )
            // InternalWorkflow.g:5355:2: ( () otherlv_1= 'DateRange' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'clousure' ( (lv_clousure_5_0= ruleClosureType ) ) )? (otherlv_6= 'max' ( (lv_max_7_0= ruleEString ) ) )? (otherlv_8= 'min' ( (lv_min_9_0= ruleEString ) ) )? otherlv_10= '}' )
            {
            // InternalWorkflow.g:5355:2: ( () otherlv_1= 'DateRange' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'clousure' ( (lv_clousure_5_0= ruleClosureType ) ) )? (otherlv_6= 'max' ( (lv_max_7_0= ruleEString ) ) )? (otherlv_8= 'min' ( (lv_min_9_0= ruleEString ) ) )? otherlv_10= '}' )
            // InternalWorkflow.g:5356:3: () otherlv_1= 'DateRange' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'clousure' ( (lv_clousure_5_0= ruleClosureType ) ) )? (otherlv_6= 'max' ( (lv_max_7_0= ruleEString ) ) )? (otherlv_8= 'min' ( (lv_min_9_0= ruleEString ) ) )? otherlv_10= '}'
            {
            // InternalWorkflow.g:5356:3: ()
            // InternalWorkflow.g:5357:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDateRangeAccess().getDateRangeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,105,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDateRangeAccess().getDateRangeKeyword_1());
            		
            // InternalWorkflow.g:5367:3: ( (lv_name_2_0= ruleEString ) )
            // InternalWorkflow.g:5368:4: (lv_name_2_0= ruleEString )
            {
            // InternalWorkflow.g:5368:4: (lv_name_2_0= ruleEString )
            // InternalWorkflow.g:5369:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDateRangeAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateRangeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"xtext.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_103); 

            			newLeafNode(otherlv_3, grammarAccess.getDateRangeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:5390:3: (otherlv_4= 'clousure' ( (lv_clousure_5_0= ruleClosureType ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==60) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalWorkflow.g:5391:4: otherlv_4= 'clousure' ( (lv_clousure_5_0= ruleClosureType ) )
                    {
                    otherlv_4=(Token)match(input,60,FOLLOW_80); 

                    				newLeafNode(otherlv_4, grammarAccess.getDateRangeAccess().getClousureKeyword_4_0());
                    			
                    // InternalWorkflow.g:5395:4: ( (lv_clousure_5_0= ruleClosureType ) )
                    // InternalWorkflow.g:5396:5: (lv_clousure_5_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:5396:5: (lv_clousure_5_0= ruleClosureType )
                    // InternalWorkflow.g:5397:6: lv_clousure_5_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getDateRangeAccess().getClousureClosureTypeEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_128);
                    lv_clousure_5_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRangeRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_5_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:5415:3: (otherlv_6= 'max' ( (lv_max_7_0= ruleEString ) ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==84) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalWorkflow.g:5416:4: otherlv_6= 'max' ( (lv_max_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,84,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getDateRangeAccess().getMaxKeyword_5_0());
                    			
                    // InternalWorkflow.g:5420:4: ( (lv_max_7_0= ruleEString ) )
                    // InternalWorkflow.g:5421:5: (lv_max_7_0= ruleEString )
                    {
                    // InternalWorkflow.g:5421:5: (lv_max_7_0= ruleEString )
                    // InternalWorkflow.g:5422:6: lv_max_7_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDateRangeAccess().getMaxEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_129);
                    lv_max_7_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRangeRule());
                    						}
                    						set(
                    							current,
                    							"max",
                    							lv_max_7_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:5440:3: (otherlv_8= 'min' ( (lv_min_9_0= ruleEString ) ) )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==83) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // InternalWorkflow.g:5441:4: otherlv_8= 'min' ( (lv_min_9_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,83,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getDateRangeAccess().getMinKeyword_6_0());
                    			
                    // InternalWorkflow.g:5445:4: ( (lv_min_9_0= ruleEString ) )
                    // InternalWorkflow.g:5446:5: (lv_min_9_0= ruleEString )
                    {
                    // InternalWorkflow.g:5446:5: (lv_min_9_0= ruleEString )
                    // InternalWorkflow.g:5447:6: lv_min_9_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDateRangeAccess().getMinEStringParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_min_9_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRangeRule());
                    						}
                    						set(
                    							current,
                    							"min",
                    							lv_min_9_0,
                    							"xtext.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getDateRangeAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateRange"


    // $ANTLR start "ruleDataType"
    // InternalWorkflow.g:5473:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5479:2: ( ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) ) )
            // InternalWorkflow.g:5480:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) )
            {
            // InternalWorkflow.g:5480:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) )
            int alt133=8;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt133=1;
                }
                break;
            case 107:
                {
                alt133=2;
                }
                break;
            case 108:
                {
                alt133=3;
                }
                break;
            case 109:
                {
                alt133=4;
                }
                break;
            case 110:
                {
                alt133=5;
                }
                break;
            case 111:
                {
                alt133=6;
                }
                break;
            case 112:
                {
                alt133=7;
                }
                break;
            case 53:
                {
                alt133=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // InternalWorkflow.g:5481:3: (enumLiteral_0= 'String' )
                    {
                    // InternalWorkflow.g:5481:3: (enumLiteral_0= 'String' )
                    // InternalWorkflow.g:5482:4: enumLiteral_0= 'String'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getStringEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getStringEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5489:3: (enumLiteral_1= 'Time' )
                    {
                    // InternalWorkflow.g:5489:3: (enumLiteral_1= 'Time' )
                    // InternalWorkflow.g:5490:4: enumLiteral_1= 'Time'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getTimeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getTimeEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5497:3: (enumLiteral_2= 'Integer' )
                    {
                    // InternalWorkflow.g:5497:3: (enumLiteral_2= 'Integer' )
                    // InternalWorkflow.g:5498:4: enumLiteral_2= 'Integer'
                    {
                    enumLiteral_2=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getIntegerEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getIntegerEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:5505:3: (enumLiteral_3= 'DateTime' )
                    {
                    // InternalWorkflow.g:5505:3: (enumLiteral_3= 'DateTime' )
                    // InternalWorkflow.g:5506:4: enumLiteral_3= 'DateTime'
                    {
                    enumLiteral_3=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDateTimeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getDateTimeEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:5513:3: (enumLiteral_4= 'Boolean' )
                    {
                    // InternalWorkflow.g:5513:3: (enumLiteral_4= 'Boolean' )
                    // InternalWorkflow.g:5514:4: enumLiteral_4= 'Boolean'
                    {
                    enumLiteral_4=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getBooleanEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getBooleanEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:5521:3: (enumLiteral_5= 'Double' )
                    {
                    // InternalWorkflow.g:5521:3: (enumLiteral_5= 'Double' )
                    // InternalWorkflow.g:5522:4: enumLiteral_5= 'Double'
                    {
                    enumLiteral_5=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDoubleEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getDoubleEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalWorkflow.g:5529:3: (enumLiteral_6= 'Float' )
                    {
                    // InternalWorkflow.g:5529:3: (enumLiteral_6= 'Float' )
                    // InternalWorkflow.g:5530:4: enumLiteral_6= 'Float'
                    {
                    enumLiteral_6=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getFloatEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getDataTypeAccess().getFloatEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalWorkflow.g:5537:3: (enumLiteral_7= 'Date' )
                    {
                    // InternalWorkflow.g:5537:3: (enumLiteral_7= 'Date' )
                    // InternalWorkflow.g:5538:4: enumLiteral_7= 'Date'
                    {
                    enumLiteral_7=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDateEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getDataTypeAccess().getDateEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleClosureType"
    // InternalWorkflow.g:5548:1: ruleClosureType returns [Enumerator current=null] : ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) ) ;
    public final Enumerator ruleClosureType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5554:2: ( ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) ) )
            // InternalWorkflow.g:5555:2: ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) )
            {
            // InternalWorkflow.g:5555:2: ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) )
            int alt134=4;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt134=1;
                }
                break;
            case 114:
                {
                alt134=2;
                }
                break;
            case 115:
                {
                alt134=3;
                }
                break;
            case 116:
                {
                alt134=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }

            switch (alt134) {
                case 1 :
                    // InternalWorkflow.g:5556:3: (enumLiteral_0= 'openOpen' )
                    {
                    // InternalWorkflow.g:5556:3: (enumLiteral_0= 'openOpen' )
                    // InternalWorkflow.g:5557:4: enumLiteral_0= 'openOpen'
                    {
                    enumLiteral_0=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getClosureTypeAccess().getOpenOpenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getClosureTypeAccess().getOpenOpenEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5564:3: (enumLiteral_1= 'openClosed' )
                    {
                    // InternalWorkflow.g:5564:3: (enumLiteral_1= 'openClosed' )
                    // InternalWorkflow.g:5565:4: enumLiteral_1= 'openClosed'
                    {
                    enumLiteral_1=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getClosureTypeAccess().getOpenClosedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getClosureTypeAccess().getOpenClosedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5572:3: (enumLiteral_2= 'closedOpen' )
                    {
                    // InternalWorkflow.g:5572:3: (enumLiteral_2= 'closedOpen' )
                    // InternalWorkflow.g:5573:4: enumLiteral_2= 'closedOpen'
                    {
                    enumLiteral_2=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getClosureTypeAccess().getClosedOpenEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getClosureTypeAccess().getClosedOpenEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:5580:3: (enumLiteral_3= 'closedClosed' )
                    {
                    // InternalWorkflow.g:5580:3: (enumLiteral_3= 'closedClosed' )
                    // InternalWorkflow.g:5581:4: enumLiteral_3= 'closedClosed'
                    {
                    enumLiteral_3=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getClosureTypeAccess().getClosedClosedEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getClosureTypeAccess().getClosedClosedEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClosureType"


    // $ANTLR start "ruleMapOperation"
    // InternalWorkflow.g:5591:1: ruleMapOperation returns [Enumerator current=null] : ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) ) ;
    public final Enumerator ruleMapOperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5597:2: ( ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) ) )
            // InternalWorkflow.g:5598:2: ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) )
            {
            // InternalWorkflow.g:5598:2: ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) )
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==117) ) {
                alt135=1;
            }
            else if ( (LA135_0==118) ) {
                alt135=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }
            switch (alt135) {
                case 1 :
                    // InternalWorkflow.g:5599:3: (enumLiteral_0= 'VALUE_MAPPING' )
                    {
                    // InternalWorkflow.g:5599:3: (enumLiteral_0= 'VALUE_MAPPING' )
                    // InternalWorkflow.g:5600:4: enumLiteral_0= 'VALUE_MAPPING'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getMapOperationAccess().getVALUE_MAPPINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMapOperationAccess().getVALUE_MAPPINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5607:3: (enumLiteral_1= 'SUBSTRING' )
                    {
                    // InternalWorkflow.g:5607:3: (enumLiteral_1= 'SUBSTRING' )
                    // InternalWorkflow.g:5608:4: enumLiteral_1= 'SUBSTRING'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getMapOperationAccess().getSUBSTRINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMapOperationAccess().getSUBSTRINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapOperation"


    // $ANTLR start "ruleFilterType"
    // InternalWorkflow.g:5618:1: ruleFilterType returns [Enumerator current=null] : ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) ) ;
    public final Enumerator ruleFilterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5624:2: ( ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) ) )
            // InternalWorkflow.g:5625:2: ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) )
            {
            // InternalWorkflow.g:5625:2: ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==119) ) {
                alt136=1;
            }
            else if ( (LA136_0==120) ) {
                alt136=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }
            switch (alt136) {
                case 1 :
                    // InternalWorkflow.g:5626:3: (enumLiteral_0= 'EXCLUDE' )
                    {
                    // InternalWorkflow.g:5626:3: (enumLiteral_0= 'EXCLUDE' )
                    // InternalWorkflow.g:5627:4: enumLiteral_0= 'EXCLUDE'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getFilterTypeAccess().getEXCLUDEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFilterTypeAccess().getEXCLUDEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5634:3: (enumLiteral_1= 'INCLUDE' )
                    {
                    // InternalWorkflow.g:5634:3: (enumLiteral_1= 'INCLUDE' )
                    // InternalWorkflow.g:5635:4: enumLiteral_1= 'INCLUDE'
                    {
                    enumLiteral_1=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getFilterTypeAccess().getINCLUDEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFilterTypeAccess().getINCLUDEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilterType"


    // $ANTLR start "ruleSpecialValue"
    // InternalWorkflow.g:5645:1: ruleSpecialValue returns [Enumerator current=null] : ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) ) ;
    public final Enumerator ruleSpecialValue() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5651:2: ( ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) ) )
            // InternalWorkflow.g:5652:2: ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) )
            {
            // InternalWorkflow.g:5652:2: ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) )
            int alt137=3;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt137=1;
                }
                break;
            case 122:
                {
                alt137=2;
                }
                break;
            case 123:
                {
                alt137=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // InternalWorkflow.g:5653:3: (enumLiteral_0= 'Missing' )
                    {
                    // InternalWorkflow.g:5653:3: (enumLiteral_0= 'Missing' )
                    // InternalWorkflow.g:5654:4: enumLiteral_0= 'Missing'
                    {
                    enumLiteral_0=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getSpecialValueAccess().getMissingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSpecialValueAccess().getMissingEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5661:3: (enumLiteral_1= 'Invalid' )
                    {
                    // InternalWorkflow.g:5661:3: (enumLiteral_1= 'Invalid' )
                    // InternalWorkflow.g:5662:4: enumLiteral_1= 'Invalid'
                    {
                    enumLiteral_1=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getSpecialValueAccess().getInvalidEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSpecialValueAccess().getInvalidEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5669:3: (enumLiteral_2= 'Outlier' )
                    {
                    // InternalWorkflow.g:5669:3: (enumLiteral_2= 'Outlier' )
                    // InternalWorkflow.g:5670:4: enumLiteral_2= 'Outlier'
                    {
                    enumLiteral_2=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getSpecialValueAccess().getOutlierEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSpecialValueAccess().getOutlierEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialValue"


    // $ANTLR start "ruleDerivedType"
    // InternalWorkflow.g:5680:1: ruleDerivedType returns [Enumerator current=null] : ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) ) ;
    public final Enumerator ruleDerivedType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5686:2: ( ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) ) )
            // InternalWorkflow.g:5687:2: ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) )
            {
            // InternalWorkflow.g:5687:2: ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) )
            int alt138=3;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt138=1;
                }
                break;
            case 125:
                {
                alt138=2;
                }
                break;
            case 126:
                {
                alt138=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }

            switch (alt138) {
                case 1 :
                    // InternalWorkflow.g:5688:3: (enumLiteral_0= 'MostFrequent' )
                    {
                    // InternalWorkflow.g:5688:3: (enumLiteral_0= 'MostFrequent' )
                    // InternalWorkflow.g:5689:4: enumLiteral_0= 'MostFrequent'
                    {
                    enumLiteral_0=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getDerivedTypeAccess().getMostFrequentEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDerivedTypeAccess().getMostFrequentEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5696:3: (enumLiteral_1= 'Previous' )
                    {
                    // InternalWorkflow.g:5696:3: (enumLiteral_1= 'Previous' )
                    // InternalWorkflow.g:5697:4: enumLiteral_1= 'Previous'
                    {
                    enumLiteral_1=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getDerivedTypeAccess().getPreviousEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDerivedTypeAccess().getPreviousEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5704:3: (enumLiteral_2= 'Next' )
                    {
                    // InternalWorkflow.g:5704:3: (enumLiteral_2= 'Next' )
                    // InternalWorkflow.g:5705:4: enumLiteral_2= 'Next'
                    {
                    enumLiteral_2=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getDerivedTypeAccess().getNextEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDerivedTypeAccess().getNextEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDerivedType"


    // $ANTLR start "ruleOperation"
    // InternalWorkflow.g:5715:1: ruleOperation returns [Enumerator current=null] : ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) ) ;
    public final Enumerator ruleOperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5721:2: ( ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) ) )
            // InternalWorkflow.g:5722:2: ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) )
            {
            // InternalWorkflow.g:5722:2: ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) )
            int alt139=4;
            switch ( input.LA(1) ) {
            case 127:
                {
                alt139=1;
                }
                break;
            case 128:
                {
                alt139=2;
                }
                break;
            case 129:
                {
                alt139=3;
                }
                break;
            case 130:
                {
                alt139=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }

            switch (alt139) {
                case 1 :
                    // InternalWorkflow.g:5723:3: (enumLiteral_0= 'Interpolation' )
                    {
                    // InternalWorkflow.g:5723:3: (enumLiteral_0= 'Interpolation' )
                    // InternalWorkflow.g:5724:4: enumLiteral_0= 'Interpolation'
                    {
                    enumLiteral_0=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getInterpolationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationAccess().getInterpolationEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5731:3: (enumLiteral_1= 'Mean' )
                    {
                    // InternalWorkflow.g:5731:3: (enumLiteral_1= 'Mean' )
                    // InternalWorkflow.g:5732:4: enumLiteral_1= 'Mean'
                    {
                    enumLiteral_1=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getMeanEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperationAccess().getMeanEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5739:3: (enumLiteral_2= 'Median' )
                    {
                    // InternalWorkflow.g:5739:3: (enumLiteral_2= 'Median' )
                    // InternalWorkflow.g:5740:4: enumLiteral_2= 'Median'
                    {
                    enumLiteral_2=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getMedianEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOperationAccess().getMedianEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:5747:3: (enumLiteral_3= 'Closest' )
                    {
                    // InternalWorkflow.g:5747:3: (enumLiteral_3= 'Closest' )
                    // InternalWorkflow.g:5748:4: enumLiteral_3= 'Closest'
                    {
                    enumLiteral_3=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getClosestEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOperationAccess().getClosestEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "ruleOperator"
    // InternalWorkflow.g:5758:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5764:2: ( ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) ) )
            // InternalWorkflow.g:5765:2: ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) )
            {
            // InternalWorkflow.g:5765:2: ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==131) ) {
                alt140=1;
            }
            else if ( (LA140_0==132) ) {
                alt140=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }
            switch (alt140) {
                case 1 :
                    // InternalWorkflow.g:5766:3: (enumLiteral_0= 'BELONG' )
                    {
                    // InternalWorkflow.g:5766:3: (enumLiteral_0= 'BELONG' )
                    // InternalWorkflow.g:5767:4: enumLiteral_0= 'BELONG'
                    {
                    enumLiteral_0=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getBELONGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getBELONGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5774:3: (enumLiteral_1= 'NOTBELONG' )
                    {
                    // InternalWorkflow.g:5774:3: (enumLiteral_1= 'NOTBELONG' )
                    // InternalWorkflow.g:5775:4: enumLiteral_1= 'NOTBELONG'
                    {
                    enumLiteral_1=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getNOTBELONGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperatorAccess().getNOTBELONGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "ruleMathOperator"
    // InternalWorkflow.g:5785:1: ruleMathOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) ) ;
    public final Enumerator ruleMathOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5791:2: ( ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) ) )
            // InternalWorkflow.g:5792:2: ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) )
            {
            // InternalWorkflow.g:5792:2: ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) )
            int alt141=4;
            switch ( input.LA(1) ) {
            case 133:
                {
                alt141=1;
                }
                break;
            case 134:
                {
                alt141=2;
                }
                break;
            case 135:
                {
                alt141=3;
                }
                break;
            case 136:
                {
                alt141=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }

            switch (alt141) {
                case 1 :
                    // InternalWorkflow.g:5793:3: (enumLiteral_0= 'SUM' )
                    {
                    // InternalWorkflow.g:5793:3: (enumLiteral_0= 'SUM' )
                    // InternalWorkflow.g:5794:4: enumLiteral_0= 'SUM'
                    {
                    enumLiteral_0=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getMathOperatorAccess().getSUMEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMathOperatorAccess().getSUMEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5801:3: (enumLiteral_1= 'SUBSTRACT' )
                    {
                    // InternalWorkflow.g:5801:3: (enumLiteral_1= 'SUBSTRACT' )
                    // InternalWorkflow.g:5802:4: enumLiteral_1= 'SUBSTRACT'
                    {
                    enumLiteral_1=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getMathOperatorAccess().getSUBSTRACTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMathOperatorAccess().getSUBSTRACTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5809:3: (enumLiteral_2= 'MULTIPLY' )
                    {
                    // InternalWorkflow.g:5809:3: (enumLiteral_2= 'MULTIPLY' )
                    // InternalWorkflow.g:5810:4: enumLiteral_2= 'MULTIPLY'
                    {
                    enumLiteral_2=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getMathOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMathOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:5817:3: (enumLiteral_3= 'DIVIDE' )
                    {
                    // InternalWorkflow.g:5817:3: (enumLiteral_3= 'DIVIDE' )
                    // InternalWorkflow.g:5818:4: enumLiteral_3= 'DIVIDE'
                    {
                    enumLiteral_3=(Token)match(input,136,FOLLOW_2); 

                    				current = grammarAccess.getMathOperatorAccess().getDIVIDEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getMathOperatorAccess().getDIVIDEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathOperator"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000001006000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001E08000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001C08000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001808000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00241C0000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000078400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000070400000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000060400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040400000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100004000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000068400000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000008000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x000003A4AAA71620L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000030000008000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000008000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000180000080000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0003E00000C08000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0020000000000000L,0x0001FC0000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0003C00000C08000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0003800000C08000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0003800000808000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0003800000008000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0003000000008000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000000008000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0004000000080000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x001BE00000C00000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x001BC00000C00000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x001B800000C00000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0013800000C00000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0013800000800000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0013800000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0013000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0012000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0020000000080000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x00C3E00000C00000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x00C3C00000C00000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x00C3800000C00000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0083800000C00000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0083800000800000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0083800000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0083000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x1C00000000008000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x2100000000000040L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x1800000000008000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x1000000000008000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x001E000000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x1400000000008000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0400000000008000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000008000L,0x000000000000001CL});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000018L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000010L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000008000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000180L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000100L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0060000000000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000210000008000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000200000008000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000008000L,0x000000000000E000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0180000000000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000008000L,0x000000000000C000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000008000L,0x0000000000008000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x1000000000008000L,0x0000000000180000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x1000000000008000L,0x0000000000100000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000008000L,0x0000000000400000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0E00000000000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0010000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000008000L,0x0000000004000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000008000L,0x0000000014000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x7000000000000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000008000L,0x0000000050000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000008000L,0x0000000040000000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000010000000000L,0x0000000310000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000010000000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000010000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000000L,0x0000004800000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000001E0L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000000L,0x0000008080000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000001000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0000000001000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000008000L,0x0000000000180000L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000008000L,0x0000000000080000L});

}