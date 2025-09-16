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
import xtext.services.MM_M4DSGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMM_M4DSParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Library'", "'{'", "'jobs'", "','", "'}'", "'transformations'", "'Job'", "'input'", "'output'", "'parameters'", "'Transformation'", "'Workflow'", "'steps'", "'dataFields'", "'contracts'", "'PMMLModel'", "'filePath'", "'DataProcessing'", "'operation'", "'Contract'", "'conditions'", "'Condition'", "'field'", "'operator'", "'value'", "'Categorical'", "'dataType'", "'validValues'", "'Continuous'", "'min'", "'max'", "'Date'", "'format'", "'Parameter'", "'type'", "'true'", "'false'", "'String'", "'Integer'", "'Double'", "'Boolean'", "'filter'", "'map'", "'reduce'", "'join'", "'equals'", "'greater'", "'less'", "'contains'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_NUMBER=6;
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

    // delegates
    // delegators


        public InternalMM_M4DSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMM_M4DSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMM_M4DSParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMM_M4DS.g"; }



     	private MM_M4DSGrammarAccess grammarAccess;

        public InternalMM_M4DSParser(TokenStream input, MM_M4DSGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MM_M4DSGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMM_M4DS.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMM_M4DS.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalMM_M4DS.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMM_M4DS.g:72:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:78:2: ( ( (lv_elements_0_0= ruleElement ) )* )
            // InternalMM_M4DS.g:79:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // InternalMM_M4DS.g:79:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==23||LA1_0==31) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMM_M4DS.g:80:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // InternalMM_M4DS.g:80:3: (lv_elements_0_0= ruleElement )
            	    // InternalMM_M4DS.g:81:4: lv_elements_0_0= ruleElement
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"xtext.MM_M4DS.Element");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // InternalMM_M4DS.g:101:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalMM_M4DS.g:101:48: (iv_ruleElement= ruleElement EOF )
            // InternalMM_M4DS.g:102:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalMM_M4DS.g:108:1: ruleElement returns [EObject current=null] : (this_Library_0= ruleLibrary | this_Workflow_1= ruleWorkflow | this_Contract_2= ruleContract ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Library_0 = null;

        EObject this_Workflow_1 = null;

        EObject this_Contract_2 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:114:2: ( (this_Library_0= ruleLibrary | this_Workflow_1= ruleWorkflow | this_Contract_2= ruleContract ) )
            // InternalMM_M4DS.g:115:2: (this_Library_0= ruleLibrary | this_Workflow_1= ruleWorkflow | this_Contract_2= ruleContract )
            {
            // InternalMM_M4DS.g:115:2: (this_Library_0= ruleLibrary | this_Workflow_1= ruleWorkflow | this_Contract_2= ruleContract )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt2=1;
                }
                break;
            case 23:
                {
                alt2=2;
                }
                break;
            case 31:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalMM_M4DS.g:116:3: this_Library_0= ruleLibrary
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getLibraryParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Library_0=ruleLibrary();

                    state._fsp--;


                    			current = this_Library_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMM_M4DS.g:125:3: this_Workflow_1= ruleWorkflow
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getWorkflowParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Workflow_1=ruleWorkflow();

                    state._fsp--;


                    			current = this_Workflow_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMM_M4DS.g:134:3: this_Contract_2= ruleContract
                    {

                    			newCompositeNode(grammarAccess.getElementAccess().getContractParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Contract_2=ruleContract();

                    state._fsp--;


                    			current = this_Contract_2;
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleLibrary"
    // InternalMM_M4DS.g:146:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // InternalMM_M4DS.g:146:48: (iv_ruleLibrary= ruleLibrary EOF )
            // InternalMM_M4DS.g:147:2: iv_ruleLibrary= ruleLibrary EOF
            {
             newCompositeNode(grammarAccess.getLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLibrary=ruleLibrary();

            state._fsp--;

             current =iv_ruleLibrary; 
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
    // $ANTLR end "entryRuleLibrary"


    // $ANTLR start "ruleLibrary"
    // InternalMM_M4DS.g:153:1: ruleLibrary returns [EObject current=null] : (otherlv_0= 'Library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'jobs' otherlv_4= '{' ( (lv_jobs_5_0= ruleJob ) ) (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )* otherlv_8= '}' )? (otherlv_9= 'transformations' otherlv_10= '{' ( (lv_transformations_11_0= ruleTransformation ) ) (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )* otherlv_14= '}' )? otherlv_15= '}' ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
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
        EObject lv_jobs_5_0 = null;

        EObject lv_jobs_7_0 = null;

        EObject lv_transformations_11_0 = null;

        EObject lv_transformations_13_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:159:2: ( (otherlv_0= 'Library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'jobs' otherlv_4= '{' ( (lv_jobs_5_0= ruleJob ) ) (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )* otherlv_8= '}' )? (otherlv_9= 'transformations' otherlv_10= '{' ( (lv_transformations_11_0= ruleTransformation ) ) (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )* otherlv_14= '}' )? otherlv_15= '}' ) )
            // InternalMM_M4DS.g:160:2: (otherlv_0= 'Library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'jobs' otherlv_4= '{' ( (lv_jobs_5_0= ruleJob ) ) (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )* otherlv_8= '}' )? (otherlv_9= 'transformations' otherlv_10= '{' ( (lv_transformations_11_0= ruleTransformation ) ) (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )* otherlv_14= '}' )? otherlv_15= '}' )
            {
            // InternalMM_M4DS.g:160:2: (otherlv_0= 'Library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'jobs' otherlv_4= '{' ( (lv_jobs_5_0= ruleJob ) ) (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )* otherlv_8= '}' )? (otherlv_9= 'transformations' otherlv_10= '{' ( (lv_transformations_11_0= ruleTransformation ) ) (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )* otherlv_14= '}' )? otherlv_15= '}' )
            // InternalMM_M4DS.g:161:3: otherlv_0= 'Library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'jobs' otherlv_4= '{' ( (lv_jobs_5_0= ruleJob ) ) (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )* otherlv_8= '}' )? (otherlv_9= 'transformations' otherlv_10= '{' ( (lv_transformations_11_0= ruleTransformation ) ) (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )* otherlv_14= '}' )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getLibraryAccess().getLibraryKeyword_0());
            		
            // InternalMM_M4DS.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:166:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:167:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLibraryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLibraryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMM_M4DS.g:187:3: (otherlv_3= 'jobs' otherlv_4= '{' ( (lv_jobs_5_0= ruleJob ) ) (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )* otherlv_8= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMM_M4DS.g:188:4: otherlv_3= 'jobs' otherlv_4= '{' ( (lv_jobs_5_0= ruleJob ) ) (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getLibraryAccess().getJobsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,13,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMM_M4DS.g:196:4: ( (lv_jobs_5_0= ruleJob ) )
                    // InternalMM_M4DS.g:197:5: (lv_jobs_5_0= ruleJob )
                    {
                    // InternalMM_M4DS.g:197:5: (lv_jobs_5_0= ruleJob )
                    // InternalMM_M4DS.g:198:6: lv_jobs_5_0= ruleJob
                    {

                    						newCompositeNode(grammarAccess.getLibraryAccess().getJobsJobParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_jobs_5_0=ruleJob();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLibraryRule());
                    						}
                    						add(
                    							current,
                    							"jobs",
                    							lv_jobs_5_0,
                    							"xtext.MM_M4DS.Job");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:215:4: (otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:216:5: otherlv_6= ',' ( (lv_jobs_7_0= ruleJob ) )
                    	    {
                    	    otherlv_6=(Token)match(input,15,FOLLOW_7); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getLibraryAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:220:5: ( (lv_jobs_7_0= ruleJob ) )
                    	    // InternalMM_M4DS.g:221:6: (lv_jobs_7_0= ruleJob )
                    	    {
                    	    // InternalMM_M4DS.g:221:6: (lv_jobs_7_0= ruleJob )
                    	    // InternalMM_M4DS.g:222:7: lv_jobs_7_0= ruleJob
                    	    {

                    	    							newCompositeNode(grammarAccess.getLibraryAccess().getJobsJobParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_jobs_7_0=ruleJob();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getLibraryRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"jobs",
                    	    								lv_jobs_7_0,
                    	    								"xtext.MM_M4DS.Job");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_8, grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalMM_M4DS.g:245:3: (otherlv_9= 'transformations' otherlv_10= '{' ( (lv_transformations_11_0= ruleTransformation ) ) (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )* otherlv_14= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMM_M4DS.g:246:4: otherlv_9= 'transformations' otherlv_10= '{' ( (lv_transformations_11_0= ruleTransformation ) ) (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )* otherlv_14= '}'
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_5); 

                    				newLeafNode(otherlv_9, grammarAccess.getLibraryAccess().getTransformationsKeyword_4_0());
                    			
                    otherlv_10=(Token)match(input,13,FOLLOW_10); 

                    				newLeafNode(otherlv_10, grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMM_M4DS.g:254:4: ( (lv_transformations_11_0= ruleTransformation ) )
                    // InternalMM_M4DS.g:255:5: (lv_transformations_11_0= ruleTransformation )
                    {
                    // InternalMM_M4DS.g:255:5: (lv_transformations_11_0= ruleTransformation )
                    // InternalMM_M4DS.g:256:6: lv_transformations_11_0= ruleTransformation
                    {

                    						newCompositeNode(grammarAccess.getLibraryAccess().getTransformationsTransformationParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_transformations_11_0=ruleTransformation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLibraryRule());
                    						}
                    						add(
                    							current,
                    							"transformations",
                    							lv_transformations_11_0,
                    							"xtext.MM_M4DS.Transformation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:273:4: (otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==15) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:274:5: otherlv_12= ',' ( (lv_transformations_13_0= ruleTransformation ) )
                    	    {
                    	    otherlv_12=(Token)match(input,15,FOLLOW_10); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getLibraryAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:278:5: ( (lv_transformations_13_0= ruleTransformation ) )
                    	    // InternalMM_M4DS.g:279:6: (lv_transformations_13_0= ruleTransformation )
                    	    {
                    	    // InternalMM_M4DS.g:279:6: (lv_transformations_13_0= ruleTransformation )
                    	    // InternalMM_M4DS.g:280:7: lv_transformations_13_0= ruleTransformation
                    	    {

                    	    							newCompositeNode(grammarAccess.getLibraryAccess().getTransformationsTransformationParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_transformations_13_0=ruleTransformation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getLibraryRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"transformations",
                    	    								lv_transformations_13_0,
                    	    								"xtext.MM_M4DS.Transformation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_14, grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleLibrary"


    // $ANTLR start "entryRuleJob"
    // InternalMM_M4DS.g:311:1: entryRuleJob returns [EObject current=null] : iv_ruleJob= ruleJob EOF ;
    public final EObject entryRuleJob() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJob = null;


        try {
            // InternalMM_M4DS.g:311:44: (iv_ruleJob= ruleJob EOF )
            // InternalMM_M4DS.g:312:2: iv_ruleJob= ruleJob EOF
            {
             newCompositeNode(grammarAccess.getJobRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJob=ruleJob();

            state._fsp--;

             current =iv_ruleJob; 
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
    // $ANTLR end "entryRuleJob"


    // $ANTLR start "ruleJob"
    // InternalMM_M4DS.g:318:1: ruleJob returns [EObject current=null] : (otherlv_0= 'Job' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' ) ;
    public final EObject ruleJob() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_input_4_0 = null;

        EObject lv_output_6_0 = null;

        EObject lv_parameters_9_0 = null;

        EObject lv_parameters_11_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:324:2: ( (otherlv_0= 'Job' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' ) )
            // InternalMM_M4DS.g:325:2: (otherlv_0= 'Job' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' )
            {
            // InternalMM_M4DS.g:325:2: (otherlv_0= 'Job' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' )
            // InternalMM_M4DS.g:326:3: otherlv_0= 'Job' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getJobAccess().getJobKeyword_0());
            		
            // InternalMM_M4DS.g:330:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:331:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:331:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:332:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJobAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJobRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getJobAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getJobAccess().getInputKeyword_3());
            		
            // InternalMM_M4DS.g:356:3: ( (lv_input_4_0= ruleDataField ) )
            // InternalMM_M4DS.g:357:4: (lv_input_4_0= ruleDataField )
            {
            // InternalMM_M4DS.g:357:4: (lv_input_4_0= ruleDataField )
            // InternalMM_M4DS.g:358:5: lv_input_4_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getJobAccess().getInputDataFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_14);
            lv_input_4_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJobRule());
            					}
            					set(
            						current,
            						"input",
            						lv_input_4_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getJobAccess().getOutputKeyword_5());
            		
            // InternalMM_M4DS.g:379:3: ( (lv_output_6_0= ruleDataField ) )
            // InternalMM_M4DS.g:380:4: (lv_output_6_0= ruleDataField )
            {
            // InternalMM_M4DS.g:380:4: (lv_output_6_0= ruleDataField )
            // InternalMM_M4DS.g:381:5: lv_output_6_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getJobAccess().getOutputDataFieldParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_15);
            lv_output_6_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJobRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_6_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMM_M4DS.g:398:3: (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMM_M4DS.g:399:4: otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}'
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_5); 

                    				newLeafNode(otherlv_7, grammarAccess.getJobAccess().getParametersKeyword_7_0());
                    			
                    otherlv_8=(Token)match(input,13,FOLLOW_16); 

                    				newLeafNode(otherlv_8, grammarAccess.getJobAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalMM_M4DS.g:407:4: ( (lv_parameters_9_0= ruleParameter ) )
                    // InternalMM_M4DS.g:408:5: (lv_parameters_9_0= ruleParameter )
                    {
                    // InternalMM_M4DS.g:408:5: (lv_parameters_9_0= ruleParameter )
                    // InternalMM_M4DS.g:409:6: lv_parameters_9_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getJobAccess().getParametersParameterParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_parameters_9_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJobRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_9_0,
                    							"xtext.MM_M4DS.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:426:4: (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==15) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:427:5: otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) )
                    	    {
                    	    otherlv_10=(Token)match(input,15,FOLLOW_16); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getJobAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:431:5: ( (lv_parameters_11_0= ruleParameter ) )
                    	    // InternalMM_M4DS.g:432:6: (lv_parameters_11_0= ruleParameter )
                    	    {
                    	    // InternalMM_M4DS.g:432:6: (lv_parameters_11_0= ruleParameter )
                    	    // InternalMM_M4DS.g:433:7: lv_parameters_11_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getJobAccess().getParametersParameterParserRuleCall_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_parameters_11_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getJobRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_11_0,
                    	    								"xtext.MM_M4DS.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_12, grammarAccess.getJobAccess().getRightCurlyBracketKeyword_7_4());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getJobAccess().getRightCurlyBracketKeyword_8());
            		

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
    // $ANTLR end "ruleJob"


    // $ANTLR start "entryRuleTransformation"
    // InternalMM_M4DS.g:464:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;


        try {
            // InternalMM_M4DS.g:464:55: (iv_ruleTransformation= ruleTransformation EOF )
            // InternalMM_M4DS.g:465:2: iv_ruleTransformation= ruleTransformation EOF
            {
             newCompositeNode(grammarAccess.getTransformationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransformation=ruleTransformation();

            state._fsp--;

             current =iv_ruleTransformation; 
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
    // $ANTLR end "entryRuleTransformation"


    // $ANTLR start "ruleTransformation"
    // InternalMM_M4DS.g:471:1: ruleTransformation returns [EObject current=null] : (otherlv_0= 'Transformation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' ) ;
    public final EObject ruleTransformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_input_4_0 = null;

        EObject lv_output_6_0 = null;

        EObject lv_parameters_9_0 = null;

        EObject lv_parameters_11_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:477:2: ( (otherlv_0= 'Transformation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' ) )
            // InternalMM_M4DS.g:478:2: (otherlv_0= 'Transformation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' )
            {
            // InternalMM_M4DS.g:478:2: (otherlv_0= 'Transformation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}' )
            // InternalMM_M4DS.g:479:3: otherlv_0= 'Transformation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTransformationAccess().getTransformationKeyword_0());
            		
            // InternalMM_M4DS.g:483:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:484:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:484:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:485:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTransformationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransformationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getInputKeyword_3());
            		
            // InternalMM_M4DS.g:509:3: ( (lv_input_4_0= ruleDataField ) )
            // InternalMM_M4DS.g:510:4: (lv_input_4_0= ruleDataField )
            {
            // InternalMM_M4DS.g:510:4: (lv_input_4_0= ruleDataField )
            // InternalMM_M4DS.g:511:5: lv_input_4_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getTransformationAccess().getInputDataFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_14);
            lv_input_4_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransformationRule());
            					}
            					set(
            						current,
            						"input",
            						lv_input_4_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getTransformationAccess().getOutputKeyword_5());
            		
            // InternalMM_M4DS.g:532:3: ( (lv_output_6_0= ruleDataField ) )
            // InternalMM_M4DS.g:533:4: (lv_output_6_0= ruleDataField )
            {
            // InternalMM_M4DS.g:533:4: (lv_output_6_0= ruleDataField )
            // InternalMM_M4DS.g:534:5: lv_output_6_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getTransformationAccess().getOutputDataFieldParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_15);
            lv_output_6_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransformationRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_6_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMM_M4DS.g:551:3: (otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMM_M4DS.g:552:4: otherlv_7= 'parameters' otherlv_8= '{' ( (lv_parameters_9_0= ruleParameter ) ) (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )* otherlv_12= '}'
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_5); 

                    				newLeafNode(otherlv_7, grammarAccess.getTransformationAccess().getParametersKeyword_7_0());
                    			
                    otherlv_8=(Token)match(input,13,FOLLOW_16); 

                    				newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalMM_M4DS.g:560:4: ( (lv_parameters_9_0= ruleParameter ) )
                    // InternalMM_M4DS.g:561:5: (lv_parameters_9_0= ruleParameter )
                    {
                    // InternalMM_M4DS.g:561:5: (lv_parameters_9_0= ruleParameter )
                    // InternalMM_M4DS.g:562:6: lv_parameters_9_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_parameters_9_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransformationRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_9_0,
                    							"xtext.MM_M4DS.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:579:4: (otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==15) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:580:5: otherlv_10= ',' ( (lv_parameters_11_0= ruleParameter ) )
                    	    {
                    	    otherlv_10=(Token)match(input,15,FOLLOW_16); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getTransformationAccess().getCommaKeyword_7_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:584:5: ( (lv_parameters_11_0= ruleParameter ) )
                    	    // InternalMM_M4DS.g:585:6: (lv_parameters_11_0= ruleParameter )
                    	    {
                    	    // InternalMM_M4DS.g:585:6: (lv_parameters_11_0= ruleParameter )
                    	    // InternalMM_M4DS.g:586:7: lv_parameters_11_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_7_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_parameters_11_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTransformationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_11_0,
                    	    								"xtext.MM_M4DS.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_12, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7_4());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_8());
            		

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
    // $ANTLR end "ruleTransformation"


    // $ANTLR start "entryRuleWorkflow"
    // InternalMM_M4DS.g:617:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalMM_M4DS.g:617:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalMM_M4DS.g:618:2: iv_ruleWorkflow= ruleWorkflow EOF
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
    // InternalMM_M4DS.g:624:1: ruleWorkflow returns [EObject current=null] : (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'steps' otherlv_4= '{' ( (lv_steps_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' )? (otherlv_9= 'dataFields' otherlv_10= '{' ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= '}' )? (otherlv_15= 'contracts' otherlv_16= '{' ( (lv_contracts_17_0= ruleContract ) ) (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )* otherlv_20= '}' )? otherlv_21= '}' ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
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
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        EObject lv_steps_5_0 = null;

        EObject lv_steps_7_0 = null;

        EObject lv_dataFields_11_0 = null;

        EObject lv_dataFields_13_0 = null;

        EObject lv_contracts_17_0 = null;

        EObject lv_contracts_19_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:630:2: ( (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'steps' otherlv_4= '{' ( (lv_steps_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' )? (otherlv_9= 'dataFields' otherlv_10= '{' ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= '}' )? (otherlv_15= 'contracts' otherlv_16= '{' ( (lv_contracts_17_0= ruleContract ) ) (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )* otherlv_20= '}' )? otherlv_21= '}' ) )
            // InternalMM_M4DS.g:631:2: (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'steps' otherlv_4= '{' ( (lv_steps_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' )? (otherlv_9= 'dataFields' otherlv_10= '{' ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= '}' )? (otherlv_15= 'contracts' otherlv_16= '{' ( (lv_contracts_17_0= ruleContract ) ) (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )* otherlv_20= '}' )? otherlv_21= '}' )
            {
            // InternalMM_M4DS.g:631:2: (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'steps' otherlv_4= '{' ( (lv_steps_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' )? (otherlv_9= 'dataFields' otherlv_10= '{' ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= '}' )? (otherlv_15= 'contracts' otherlv_16= '{' ( (lv_contracts_17_0= ruleContract ) ) (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )* otherlv_20= '}' )? otherlv_21= '}' )
            // InternalMM_M4DS.g:632:3: otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'steps' otherlv_4= '{' ( (lv_steps_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' )? (otherlv_9= 'dataFields' otherlv_10= '{' ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= '}' )? (otherlv_15= 'contracts' otherlv_16= '{' ( (lv_contracts_17_0= ruleContract ) ) (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )* otherlv_20= '}' )? otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkflowAccess().getWorkflowKeyword_0());
            		
            // InternalMM_M4DS.g:636:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:637:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:637:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:638:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getWorkflowAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorkflowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMM_M4DS.g:658:3: (otherlv_3= 'steps' otherlv_4= '{' ( (lv_steps_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )* otherlv_8= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMM_M4DS.g:659:4: otherlv_3= 'steps' otherlv_4= '{' ( (lv_steps_5_0= ruleProcessingStep ) ) (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getWorkflowAccess().getStepsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,13,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMM_M4DS.g:667:4: ( (lv_steps_5_0= ruleProcessingStep ) )
                    // InternalMM_M4DS.g:668:5: (lv_steps_5_0= ruleProcessingStep )
                    {
                    // InternalMM_M4DS.g:668:5: (lv_steps_5_0= ruleProcessingStep )
                    // InternalMM_M4DS.g:669:6: lv_steps_5_0= ruleProcessingStep
                    {

                    						newCompositeNode(grammarAccess.getWorkflowAccess().getStepsProcessingStepParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_steps_5_0=ruleProcessingStep();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    						}
                    						add(
                    							current,
                    							"steps",
                    							lv_steps_5_0,
                    							"xtext.MM_M4DS.ProcessingStep");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:686:4: (otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==15) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:687:5: otherlv_6= ',' ( (lv_steps_7_0= ruleProcessingStep ) )
                    	    {
                    	    otherlv_6=(Token)match(input,15,FOLLOW_18); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getWorkflowAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:691:5: ( (lv_steps_7_0= ruleProcessingStep ) )
                    	    // InternalMM_M4DS.g:692:6: (lv_steps_7_0= ruleProcessingStep )
                    	    {
                    	    // InternalMM_M4DS.g:692:6: (lv_steps_7_0= ruleProcessingStep )
                    	    // InternalMM_M4DS.g:693:7: lv_steps_7_0= ruleProcessingStep
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorkflowAccess().getStepsProcessingStepParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_steps_7_0=ruleProcessingStep();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"steps",
                    	    								lv_steps_7_0,
                    	    								"xtext.MM_M4DS.ProcessingStep");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,16,FOLLOW_19); 

                    				newLeafNode(otherlv_8, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalMM_M4DS.g:716:3: (otherlv_9= 'dataFields' otherlv_10= '{' ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMM_M4DS.g:717:4: otherlv_9= 'dataFields' otherlv_10= '{' ( (lv_dataFields_11_0= ruleDataField ) ) (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )* otherlv_14= '}'
                    {
                    otherlv_9=(Token)match(input,25,FOLLOW_5); 

                    				newLeafNode(otherlv_9, grammarAccess.getWorkflowAccess().getDataFieldsKeyword_4_0());
                    			
                    otherlv_10=(Token)match(input,13,FOLLOW_13); 

                    				newLeafNode(otherlv_10, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMM_M4DS.g:725:4: ( (lv_dataFields_11_0= ruleDataField ) )
                    // InternalMM_M4DS.g:726:5: (lv_dataFields_11_0= ruleDataField )
                    {
                    // InternalMM_M4DS.g:726:5: (lv_dataFields_11_0= ruleDataField )
                    // InternalMM_M4DS.g:727:6: lv_dataFields_11_0= ruleDataField
                    {

                    						newCompositeNode(grammarAccess.getWorkflowAccess().getDataFieldsDataFieldParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_dataFields_11_0=ruleDataField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    						}
                    						add(
                    							current,
                    							"dataFields",
                    							lv_dataFields_11_0,
                    							"xtext.MM_M4DS.DataField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:744:4: (otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==15) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:745:5: otherlv_12= ',' ( (lv_dataFields_13_0= ruleDataField ) )
                    	    {
                    	    otherlv_12=(Token)match(input,15,FOLLOW_13); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getWorkflowAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:749:5: ( (lv_dataFields_13_0= ruleDataField ) )
                    	    // InternalMM_M4DS.g:750:6: (lv_dataFields_13_0= ruleDataField )
                    	    {
                    	    // InternalMM_M4DS.g:750:6: (lv_dataFields_13_0= ruleDataField )
                    	    // InternalMM_M4DS.g:751:7: lv_dataFields_13_0= ruleDataField
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorkflowAccess().getDataFieldsDataFieldParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_dataFields_13_0=ruleDataField();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataFields",
                    	    								lv_dataFields_13_0,
                    	    								"xtext.MM_M4DS.DataField");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,16,FOLLOW_20); 

                    				newLeafNode(otherlv_14, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalMM_M4DS.g:774:3: (otherlv_15= 'contracts' otherlv_16= '{' ( (lv_contracts_17_0= ruleContract ) ) (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )* otherlv_20= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMM_M4DS.g:775:4: otherlv_15= 'contracts' otherlv_16= '{' ( (lv_contracts_17_0= ruleContract ) ) (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,26,FOLLOW_5); 

                    				newLeafNode(otherlv_15, grammarAccess.getWorkflowAccess().getContractsKeyword_5_0());
                    			
                    otherlv_16=(Token)match(input,13,FOLLOW_21); 

                    				newLeafNode(otherlv_16, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalMM_M4DS.g:783:4: ( (lv_contracts_17_0= ruleContract ) )
                    // InternalMM_M4DS.g:784:5: (lv_contracts_17_0= ruleContract )
                    {
                    // InternalMM_M4DS.g:784:5: (lv_contracts_17_0= ruleContract )
                    // InternalMM_M4DS.g:785:6: lv_contracts_17_0= ruleContract
                    {

                    						newCompositeNode(grammarAccess.getWorkflowAccess().getContractsContractParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_contracts_17_0=ruleContract();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    						}
                    						add(
                    							current,
                    							"contracts",
                    							lv_contracts_17_0,
                    							"xtext.MM_M4DS.Contract");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:802:4: (otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==15) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:803:5: otherlv_18= ',' ( (lv_contracts_19_0= ruleContract ) )
                    	    {
                    	    otherlv_18=(Token)match(input,15,FOLLOW_21); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getWorkflowAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:807:5: ( (lv_contracts_19_0= ruleContract ) )
                    	    // InternalMM_M4DS.g:808:6: (lv_contracts_19_0= ruleContract )
                    	    {
                    	    // InternalMM_M4DS.g:808:6: (lv_contracts_19_0= ruleContract )
                    	    // InternalMM_M4DS.g:809:7: lv_contracts_19_0= ruleContract
                    	    {

                    	    							newCompositeNode(grammarAccess.getWorkflowAccess().getContractsContractParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_contracts_19_0=ruleContract();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getWorkflowRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"contracts",
                    	    								lv_contracts_19_0,
                    	    								"xtext.MM_M4DS.Contract");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_20, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_21=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalMM_M4DS.g:840:1: entryRuleProcessingStep returns [EObject current=null] : iv_ruleProcessingStep= ruleProcessingStep EOF ;
    public final EObject entryRuleProcessingStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessingStep = null;


        try {
            // InternalMM_M4DS.g:840:55: (iv_ruleProcessingStep= ruleProcessingStep EOF )
            // InternalMM_M4DS.g:841:2: iv_ruleProcessingStep= ruleProcessingStep EOF
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
    // InternalMM_M4DS.g:847:1: ruleProcessingStep returns [EObject current=null] : (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing ) ;
    public final EObject ruleProcessingStep() throws RecognitionException {
        EObject current = null;

        EObject this_PMMLModel_0 = null;

        EObject this_DataProcessing_1 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:853:2: ( (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing ) )
            // InternalMM_M4DS.g:854:2: (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing )
            {
            // InternalMM_M4DS.g:854:2: (this_PMMLModel_0= rulePMMLModel | this_DataProcessing_1= ruleDataProcessing )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            else if ( (LA17_0==29) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMM_M4DS.g:855:3: this_PMMLModel_0= rulePMMLModel
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
                    // InternalMM_M4DS.g:864:3: this_DataProcessing_1= ruleDataProcessing
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


    // $ANTLR start "entryRulePMMLModel"
    // InternalMM_M4DS.g:876:1: entryRulePMMLModel returns [EObject current=null] : iv_rulePMMLModel= rulePMMLModel EOF ;
    public final EObject entryRulePMMLModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePMMLModel = null;


        try {
            // InternalMM_M4DS.g:876:50: (iv_rulePMMLModel= rulePMMLModel EOF )
            // InternalMM_M4DS.g:877:2: iv_rulePMMLModel= rulePMMLModel EOF
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
    // InternalMM_M4DS.g:883:1: rulePMMLModel returns [EObject current=null] : (otherlv_0= 'PMMLModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'filePath' ( (lv_filePath_4_0= RULE_STRING ) ) )? otherlv_5= 'input' ( (lv_input_6_0= ruleDataField ) ) otherlv_7= 'output' ( (lv_output_8_0= ruleDataField ) ) otherlv_9= '}' ) ;
    public final EObject rulePMMLModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_filePath_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_input_6_0 = null;

        EObject lv_output_8_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:889:2: ( (otherlv_0= 'PMMLModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'filePath' ( (lv_filePath_4_0= RULE_STRING ) ) )? otherlv_5= 'input' ( (lv_input_6_0= ruleDataField ) ) otherlv_7= 'output' ( (lv_output_8_0= ruleDataField ) ) otherlv_9= '}' ) )
            // InternalMM_M4DS.g:890:2: (otherlv_0= 'PMMLModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'filePath' ( (lv_filePath_4_0= RULE_STRING ) ) )? otherlv_5= 'input' ( (lv_input_6_0= ruleDataField ) ) otherlv_7= 'output' ( (lv_output_8_0= ruleDataField ) ) otherlv_9= '}' )
            {
            // InternalMM_M4DS.g:890:2: (otherlv_0= 'PMMLModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'filePath' ( (lv_filePath_4_0= RULE_STRING ) ) )? otherlv_5= 'input' ( (lv_input_6_0= ruleDataField ) ) otherlv_7= 'output' ( (lv_output_8_0= ruleDataField ) ) otherlv_9= '}' )
            // InternalMM_M4DS.g:891:3: otherlv_0= 'PMMLModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'filePath' ( (lv_filePath_4_0= RULE_STRING ) ) )? otherlv_5= 'input' ( (lv_input_6_0= ruleDataField ) ) otherlv_7= 'output' ( (lv_output_8_0= ruleDataField ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPMMLModelAccess().getPMMLModelKeyword_0());
            		
            // InternalMM_M4DS.g:895:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:896:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:896:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:897:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPMMLModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPMMLModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMM_M4DS.g:917:3: (otherlv_3= 'filePath' ( (lv_filePath_4_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMM_M4DS.g:918:4: otherlv_3= 'filePath' ( (lv_filePath_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getPMMLModelAccess().getFilePathKeyword_3_0());
                    			
                    // InternalMM_M4DS.g:922:4: ( (lv_filePath_4_0= RULE_STRING ) )
                    // InternalMM_M4DS.g:923:5: (lv_filePath_4_0= RULE_STRING )
                    {
                    // InternalMM_M4DS.g:923:5: (lv_filePath_4_0= RULE_STRING )
                    // InternalMM_M4DS.g:924:6: lv_filePath_4_0= RULE_STRING
                    {
                    lv_filePath_4_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

                    						newLeafNode(lv_filePath_4_0, grammarAccess.getPMMLModelAccess().getFilePathSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPMMLModelRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"filePath",
                    							lv_filePath_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getPMMLModelAccess().getInputKeyword_4());
            		
            // InternalMM_M4DS.g:945:3: ( (lv_input_6_0= ruleDataField ) )
            // InternalMM_M4DS.g:946:4: (lv_input_6_0= ruleDataField )
            {
            // InternalMM_M4DS.g:946:4: (lv_input_6_0= ruleDataField )
            // InternalMM_M4DS.g:947:5: lv_input_6_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getPMMLModelAccess().getInputDataFieldParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_14);
            lv_input_6_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            					}
            					set(
            						current,
            						"input",
            						lv_input_6_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_7, grammarAccess.getPMMLModelAccess().getOutputKeyword_6());
            		
            // InternalMM_M4DS.g:968:3: ( (lv_output_8_0= ruleDataField ) )
            // InternalMM_M4DS.g:969:4: (lv_output_8_0= ruleDataField )
            {
            // InternalMM_M4DS.g:969:4: (lv_output_8_0= ruleDataField )
            // InternalMM_M4DS.g:970:5: lv_output_8_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getPMMLModelAccess().getOutputDataFieldParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_11);
            lv_output_8_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_8_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_8());
            		

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
    // InternalMM_M4DS.g:995:1: entryRuleDataProcessing returns [EObject current=null] : iv_ruleDataProcessing= ruleDataProcessing EOF ;
    public final EObject entryRuleDataProcessing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataProcessing = null;


        try {
            // InternalMM_M4DS.g:995:55: (iv_ruleDataProcessing= ruleDataProcessing EOF )
            // InternalMM_M4DS.g:996:2: iv_ruleDataProcessing= ruleDataProcessing EOF
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
    // InternalMM_M4DS.g:1002:1: ruleDataProcessing returns [EObject current=null] : (otherlv_0= 'DataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'operation' ( (lv_operation_8_0= ruleOperation ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleDataProcessing() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_input_4_0 = null;

        EObject lv_output_6_0 = null;

        Enumerator lv_operation_8_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1008:2: ( (otherlv_0= 'DataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'operation' ( (lv_operation_8_0= ruleOperation ) ) )? otherlv_9= '}' ) )
            // InternalMM_M4DS.g:1009:2: (otherlv_0= 'DataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'operation' ( (lv_operation_8_0= ruleOperation ) ) )? otherlv_9= '}' )
            {
            // InternalMM_M4DS.g:1009:2: (otherlv_0= 'DataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'operation' ( (lv_operation_8_0= ruleOperation ) ) )? otherlv_9= '}' )
            // InternalMM_M4DS.g:1010:3: otherlv_0= 'DataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'input' ( (lv_input_4_0= ruleDataField ) ) otherlv_5= 'output' ( (lv_output_6_0= ruleDataField ) ) (otherlv_7= 'operation' ( (lv_operation_8_0= ruleOperation ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDataProcessingAccess().getDataProcessingKeyword_0());
            		
            // InternalMM_M4DS.g:1014:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:1015:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:1015:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:1016:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataProcessingAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataProcessingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getDataProcessingAccess().getInputKeyword_3());
            		
            // InternalMM_M4DS.g:1040:3: ( (lv_input_4_0= ruleDataField ) )
            // InternalMM_M4DS.g:1041:4: (lv_input_4_0= ruleDataField )
            {
            // InternalMM_M4DS.g:1041:4: (lv_input_4_0= ruleDataField )
            // InternalMM_M4DS.g:1042:5: lv_input_4_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getDataProcessingAccess().getInputDataFieldParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_14);
            lv_input_4_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            					}
            					set(
            						current,
            						"input",
            						lv_input_4_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getDataProcessingAccess().getOutputKeyword_5());
            		
            // InternalMM_M4DS.g:1063:3: ( (lv_output_6_0= ruleDataField ) )
            // InternalMM_M4DS.g:1064:4: (lv_output_6_0= ruleDataField )
            {
            // InternalMM_M4DS.g:1064:4: (lv_output_6_0= ruleDataField )
            // InternalMM_M4DS.g:1065:5: lv_output_6_0= ruleDataField
            {

            					newCompositeNode(grammarAccess.getDataProcessingAccess().getOutputDataFieldParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_24);
            lv_output_6_0=ruleDataField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_6_0,
            						"xtext.MM_M4DS.DataField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMM_M4DS.g:1082:3: (otherlv_7= 'operation' ( (lv_operation_8_0= ruleOperation ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMM_M4DS.g:1083:4: otherlv_7= 'operation' ( (lv_operation_8_0= ruleOperation ) )
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_25); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataProcessingAccess().getOperationKeyword_7_0());
                    			
                    // InternalMM_M4DS.g:1087:4: ( (lv_operation_8_0= ruleOperation ) )
                    // InternalMM_M4DS.g:1088:5: (lv_operation_8_0= ruleOperation )
                    {
                    // InternalMM_M4DS.g:1088:5: (lv_operation_8_0= ruleOperation )
                    // InternalMM_M4DS.g:1089:6: lv_operation_8_0= ruleOperation
                    {

                    						newCompositeNode(grammarAccess.getDataProcessingAccess().getOperationOperationEnumRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_operation_8_0=ruleOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataProcessingRule());
                    						}
                    						set(
                    							current,
                    							"operation",
                    							lv_operation_8_0,
                    							"xtext.MM_M4DS.Operation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleContract"
    // InternalMM_M4DS.g:1115:1: entryRuleContract returns [EObject current=null] : iv_ruleContract= ruleContract EOF ;
    public final EObject entryRuleContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContract = null;


        try {
            // InternalMM_M4DS.g:1115:49: (iv_ruleContract= ruleContract EOF )
            // InternalMM_M4DS.g:1116:2: iv_ruleContract= ruleContract EOF
            {
             newCompositeNode(grammarAccess.getContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContract=ruleContract();

            state._fsp--;

             current =iv_ruleContract; 
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
    // $ANTLR end "entryRuleContract"


    // $ANTLR start "ruleContract"
    // InternalMM_M4DS.g:1122:1: ruleContract returns [EObject current=null] : (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'conditions' otherlv_4= '{' ( (lv_conditions_5_0= ruleCondition ) ) (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_conditions_5_0 = null;

        EObject lv_conditions_7_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1128:2: ( (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'conditions' otherlv_4= '{' ( (lv_conditions_5_0= ruleCondition ) ) (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMM_M4DS.g:1129:2: (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'conditions' otherlv_4= '{' ( (lv_conditions_5_0= ruleCondition ) ) (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMM_M4DS.g:1129:2: (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'conditions' otherlv_4= '{' ( (lv_conditions_5_0= ruleCondition ) ) (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMM_M4DS.g:1130:3: otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'conditions' otherlv_4= '{' ( (lv_conditions_5_0= ruleCondition ) ) (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getContractAccess().getContractKeyword_0());
            		
            // InternalMM_M4DS.g:1134:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:1135:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:1135:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:1136:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMM_M4DS.g:1156:3: (otherlv_3= 'conditions' otherlv_4= '{' ( (lv_conditions_5_0= ruleCondition ) ) (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )* otherlv_8= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMM_M4DS.g:1157:4: otherlv_3= 'conditions' otherlv_4= '{' ( (lv_conditions_5_0= ruleCondition ) ) (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getContractAccess().getConditionsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,13,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMM_M4DS.g:1165:4: ( (lv_conditions_5_0= ruleCondition ) )
                    // InternalMM_M4DS.g:1166:5: (lv_conditions_5_0= ruleCondition )
                    {
                    // InternalMM_M4DS.g:1166:5: (lv_conditions_5_0= ruleCondition )
                    // InternalMM_M4DS.g:1167:6: lv_conditions_5_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getContractAccess().getConditionsConditionParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_conditions_5_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractRule());
                    						}
                    						add(
                    							current,
                    							"conditions",
                    							lv_conditions_5_0,
                    							"xtext.MM_M4DS.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMM_M4DS.g:1184:4: (otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==15) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:1185:5: otherlv_6= ',' ( (lv_conditions_7_0= ruleCondition ) )
                    	    {
                    	    otherlv_6=(Token)match(input,15,FOLLOW_27); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getContractAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:1189:5: ( (lv_conditions_7_0= ruleCondition ) )
                    	    // InternalMM_M4DS.g:1190:6: (lv_conditions_7_0= ruleCondition )
                    	    {
                    	    // InternalMM_M4DS.g:1190:6: (lv_conditions_7_0= ruleCondition )
                    	    // InternalMM_M4DS.g:1191:7: lv_conditions_7_0= ruleCondition
                    	    {

                    	    							newCompositeNode(grammarAccess.getContractAccess().getConditionsConditionParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_conditions_7_0=ruleCondition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getContractRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"conditions",
                    	    								lv_conditions_7_0,
                    	    								"xtext.MM_M4DS.Condition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getContractAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getContractAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleContract"


    // $ANTLR start "entryRuleCondition"
    // InternalMM_M4DS.g:1222:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalMM_M4DS.g:1222:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalMM_M4DS.g:1223:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
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
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalMM_M4DS.g:1229:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'Condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'field' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleComparisonOperator ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleValue ) ) otherlv_9= '}' ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_operator_6_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1235:2: ( (otherlv_0= 'Condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'field' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleComparisonOperator ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleValue ) ) otherlv_9= '}' ) )
            // InternalMM_M4DS.g:1236:2: (otherlv_0= 'Condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'field' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleComparisonOperator ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleValue ) ) otherlv_9= '}' )
            {
            // InternalMM_M4DS.g:1236:2: (otherlv_0= 'Condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'field' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleComparisonOperator ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleValue ) ) otherlv_9= '}' )
            // InternalMM_M4DS.g:1237:3: otherlv_0= 'Condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'field' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleComparisonOperator ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleValue ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0());
            		
            // InternalMM_M4DS.g:1241:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:1242:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:1242:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:1243:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConditionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getFieldKeyword_3());
            		
            // InternalMM_M4DS.g:1267:3: ( (otherlv_4= RULE_ID ) )
            // InternalMM_M4DS.g:1268:4: (otherlv_4= RULE_ID )
            {
            // InternalMM_M4DS.g:1268:4: (otherlv_4= RULE_ID )
            // InternalMM_M4DS.g:1269:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(otherlv_4, grammarAccess.getConditionAccess().getFieldDataFieldCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,35,FOLLOW_30); 

            			newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getOperatorKeyword_5());
            		
            // InternalMM_M4DS.g:1284:3: ( (lv_operator_6_0= ruleComparisonOperator ) )
            // InternalMM_M4DS.g:1285:4: (lv_operator_6_0= ruleComparisonOperator )
            {
            // InternalMM_M4DS.g:1285:4: (lv_operator_6_0= ruleComparisonOperator )
            // InternalMM_M4DS.g:1286:5: lv_operator_6_0= ruleComparisonOperator
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getOperatorComparisonOperatorEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_31);
            lv_operator_6_0=ruleComparisonOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_6_0,
            						"xtext.MM_M4DS.ComparisonOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,36,FOLLOW_32); 

            			newLeafNode(otherlv_7, grammarAccess.getConditionAccess().getValueKeyword_7());
            		
            // InternalMM_M4DS.g:1307:3: ( (lv_value_8_0= ruleValue ) )
            // InternalMM_M4DS.g:1308:4: (lv_value_8_0= ruleValue )
            {
            // InternalMM_M4DS.g:1308:4: (lv_value_8_0= ruleValue )
            // InternalMM_M4DS.g:1309:5: lv_value_8_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getValueValueParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_11);
            lv_value_8_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_8_0,
            						"xtext.MM_M4DS.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_9());
            		

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
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleDataField"
    // InternalMM_M4DS.g:1334:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalMM_M4DS.g:1334:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalMM_M4DS.g:1335:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalMM_M4DS.g:1341:1: ruleDataField returns [EObject current=null] : (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_DateField_2= ruleDateField ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        EObject this_Categorical_0 = null;

        EObject this_Continuous_1 = null;

        EObject this_DateField_2 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1347:2: ( (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_DateField_2= ruleDateField ) )
            // InternalMM_M4DS.g:1348:2: (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_DateField_2= ruleDateField )
            {
            // InternalMM_M4DS.g:1348:2: (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_DateField_2= ruleDateField )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt22=1;
                }
                break;
            case 40:
                {
                alt22=2;
                }
                break;
            case 43:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalMM_M4DS.g:1349:3: this_Categorical_0= ruleCategorical
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
                    // InternalMM_M4DS.g:1358:3: this_Continuous_1= ruleContinuous
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
                    // InternalMM_M4DS.g:1367:3: this_DateField_2= ruleDateField
                    {

                    			newCompositeNode(grammarAccess.getDataFieldAccess().getDateFieldParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateField_2=ruleDateField();

                    state._fsp--;


                    			current = this_DateField_2;
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


    // $ANTLR start "entryRuleCategorical"
    // InternalMM_M4DS.g:1379:1: entryRuleCategorical returns [EObject current=null] : iv_ruleCategorical= ruleCategorical EOF ;
    public final EObject entryRuleCategorical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategorical = null;


        try {
            // InternalMM_M4DS.g:1379:52: (iv_ruleCategorical= ruleCategorical EOF )
            // InternalMM_M4DS.g:1380:2: iv_ruleCategorical= ruleCategorical EOF
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
    // InternalMM_M4DS.g:1386:1: ruleCategorical returns [EObject current=null] : (otherlv_0= 'Categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'validValues' otherlv_6= '{' ( (lv_validValues_7_0= RULE_STRING ) ) (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )* otherlv_10= '}' )? otherlv_11= '}' ) ;
    public final EObject ruleCategorical() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_validValues_7_0=null;
        Token otherlv_8=null;
        Token lv_validValues_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_dataType_4_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1392:2: ( (otherlv_0= 'Categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'validValues' otherlv_6= '{' ( (lv_validValues_7_0= RULE_STRING ) ) (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )* otherlv_10= '}' )? otherlv_11= '}' ) )
            // InternalMM_M4DS.g:1393:2: (otherlv_0= 'Categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'validValues' otherlv_6= '{' ( (lv_validValues_7_0= RULE_STRING ) ) (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )* otherlv_10= '}' )? otherlv_11= '}' )
            {
            // InternalMM_M4DS.g:1393:2: (otherlv_0= 'Categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'validValues' otherlv_6= '{' ( (lv_validValues_7_0= RULE_STRING ) ) (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )* otherlv_10= '}' )? otherlv_11= '}' )
            // InternalMM_M4DS.g:1394:3: otherlv_0= 'Categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'validValues' otherlv_6= '{' ( (lv_validValues_7_0= RULE_STRING ) ) (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )* otherlv_10= '}' )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getCategoricalAccess().getCategoricalKeyword_0());
            		
            // InternalMM_M4DS.g:1398:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:1399:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:1399:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:1400:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCategoricalAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCategoricalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMM_M4DS.g:1420:3: (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==38) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMM_M4DS.g:1421:4: otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) )
                    {
                    otherlv_3=(Token)match(input,38,FOLLOW_34); 

                    				newLeafNode(otherlv_3, grammarAccess.getCategoricalAccess().getDataTypeKeyword_3_0());
                    			
                    // InternalMM_M4DS.g:1425:4: ( (lv_dataType_4_0= ruleDataType ) )
                    // InternalMM_M4DS.g:1426:5: (lv_dataType_4_0= ruleDataType )
                    {
                    // InternalMM_M4DS.g:1426:5: (lv_dataType_4_0= ruleDataType )
                    // InternalMM_M4DS.g:1427:6: lv_dataType_4_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getCategoricalAccess().getDataTypeDataTypeEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_dataType_4_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_4_0,
                    							"xtext.MM_M4DS.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMM_M4DS.g:1445:3: (otherlv_5= 'validValues' otherlv_6= '{' ( (lv_validValues_7_0= RULE_STRING ) ) (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )* otherlv_10= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==39) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMM_M4DS.g:1446:4: otherlv_5= 'validValues' otherlv_6= '{' ( (lv_validValues_7_0= RULE_STRING ) ) (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )* otherlv_10= '}'
                    {
                    otherlv_5=(Token)match(input,39,FOLLOW_5); 

                    				newLeafNode(otherlv_5, grammarAccess.getCategoricalAccess().getValidValuesKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,13,FOLLOW_23); 

                    				newLeafNode(otherlv_6, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalMM_M4DS.g:1454:4: ( (lv_validValues_7_0= RULE_STRING ) )
                    // InternalMM_M4DS.g:1455:5: (lv_validValues_7_0= RULE_STRING )
                    {
                    // InternalMM_M4DS.g:1455:5: (lv_validValues_7_0= RULE_STRING )
                    // InternalMM_M4DS.g:1456:6: lv_validValues_7_0= RULE_STRING
                    {
                    lv_validValues_7_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

                    						newLeafNode(lv_validValues_7_0, grammarAccess.getCategoricalAccess().getValidValuesSTRINGTerminalRuleCall_4_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCategoricalRule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"validValues",
                    							lv_validValues_7_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalMM_M4DS.g:1472:4: (otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==15) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalMM_M4DS.g:1473:5: otherlv_8= ',' ( (lv_validValues_9_0= RULE_STRING ) )
                    	    {
                    	    otherlv_8=(Token)match(input,15,FOLLOW_23); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getCategoricalAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalMM_M4DS.g:1477:5: ( (lv_validValues_9_0= RULE_STRING ) )
                    	    // InternalMM_M4DS.g:1478:6: (lv_validValues_9_0= RULE_STRING )
                    	    {
                    	    // InternalMM_M4DS.g:1478:6: (lv_validValues_9_0= RULE_STRING )
                    	    // InternalMM_M4DS.g:1479:7: lv_validValues_9_0= RULE_STRING
                    	    {
                    	    lv_validValues_9_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

                    	    							newLeafNode(lv_validValues_9_0, grammarAccess.getCategoricalAccess().getValidValuesSTRINGTerminalRuleCall_4_3_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getCategoricalRule());
                    	    							}
                    	    							addWithLastConsumed(
                    	    								current,
                    	    								"validValues",
                    	    								lv_validValues_9_0,
                    	    								"org.eclipse.xtext.common.Terminals.STRING");
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_10, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            otherlv_11=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_5());
            		

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
    // InternalMM_M4DS.g:1509:1: entryRuleContinuous returns [EObject current=null] : iv_ruleContinuous= ruleContinuous EOF ;
    public final EObject entryRuleContinuous() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuous = null;


        try {
            // InternalMM_M4DS.g:1509:51: (iv_ruleContinuous= ruleContinuous EOF )
            // InternalMM_M4DS.g:1510:2: iv_ruleContinuous= ruleContinuous EOF
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
    // InternalMM_M4DS.g:1516:1: ruleContinuous returns [EObject current=null] : (otherlv_0= 'Continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'min' ( (lv_min_6_0= RULE_NUMBER ) ) )? (otherlv_7= 'max' ( (lv_max_8_0= RULE_NUMBER ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleContinuous() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_min_6_0=null;
        Token otherlv_7=null;
        Token lv_max_8_0=null;
        Token otherlv_9=null;
        Enumerator lv_dataType_4_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1522:2: ( (otherlv_0= 'Continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'min' ( (lv_min_6_0= RULE_NUMBER ) ) )? (otherlv_7= 'max' ( (lv_max_8_0= RULE_NUMBER ) ) )? otherlv_9= '}' ) )
            // InternalMM_M4DS.g:1523:2: (otherlv_0= 'Continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'min' ( (lv_min_6_0= RULE_NUMBER ) ) )? (otherlv_7= 'max' ( (lv_max_8_0= RULE_NUMBER ) ) )? otherlv_9= '}' )
            {
            // InternalMM_M4DS.g:1523:2: (otherlv_0= 'Continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'min' ( (lv_min_6_0= RULE_NUMBER ) ) )? (otherlv_7= 'max' ( (lv_max_8_0= RULE_NUMBER ) ) )? otherlv_9= '}' )
            // InternalMM_M4DS.g:1524:3: otherlv_0= 'Continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )? (otherlv_5= 'min' ( (lv_min_6_0= RULE_NUMBER ) ) )? (otherlv_7= 'max' ( (lv_max_8_0= RULE_NUMBER ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getContinuousAccess().getContinuousKeyword_0());
            		
            // InternalMM_M4DS.g:1528:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:1529:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:1529:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:1530:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContinuousAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContinuousRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMM_M4DS.g:1550:3: (otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMM_M4DS.g:1551:4: otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) )
                    {
                    otherlv_3=(Token)match(input,38,FOLLOW_34); 

                    				newLeafNode(otherlv_3, grammarAccess.getContinuousAccess().getDataTypeKeyword_3_0());
                    			
                    // InternalMM_M4DS.g:1555:4: ( (lv_dataType_4_0= ruleDataType ) )
                    // InternalMM_M4DS.g:1556:5: (lv_dataType_4_0= ruleDataType )
                    {
                    // InternalMM_M4DS.g:1556:5: (lv_dataType_4_0= ruleDataType )
                    // InternalMM_M4DS.g:1557:6: lv_dataType_4_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getContinuousAccess().getDataTypeDataTypeEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_dataType_4_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_4_0,
                    							"xtext.MM_M4DS.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMM_M4DS.g:1575:3: (otherlv_5= 'min' ( (lv_min_6_0= RULE_NUMBER ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==41) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMM_M4DS.g:1576:4: otherlv_5= 'min' ( (lv_min_6_0= RULE_NUMBER ) )
                    {
                    otherlv_5=(Token)match(input,41,FOLLOW_38); 

                    				newLeafNode(otherlv_5, grammarAccess.getContinuousAccess().getMinKeyword_4_0());
                    			
                    // InternalMM_M4DS.g:1580:4: ( (lv_min_6_0= RULE_NUMBER ) )
                    // InternalMM_M4DS.g:1581:5: (lv_min_6_0= RULE_NUMBER )
                    {
                    // InternalMM_M4DS.g:1581:5: (lv_min_6_0= RULE_NUMBER )
                    // InternalMM_M4DS.g:1582:6: lv_min_6_0= RULE_NUMBER
                    {
                    lv_min_6_0=(Token)match(input,RULE_NUMBER,FOLLOW_39); 

                    						newLeafNode(lv_min_6_0, grammarAccess.getContinuousAccess().getMinNUMBERTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"min",
                    							lv_min_6_0,
                    							"xtext.MM_M4DS.NUMBER");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMM_M4DS.g:1599:3: (otherlv_7= 'max' ( (lv_max_8_0= RULE_NUMBER ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==42) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMM_M4DS.g:1600:4: otherlv_7= 'max' ( (lv_max_8_0= RULE_NUMBER ) )
                    {
                    otherlv_7=(Token)match(input,42,FOLLOW_38); 

                    				newLeafNode(otherlv_7, grammarAccess.getContinuousAccess().getMaxKeyword_5_0());
                    			
                    // InternalMM_M4DS.g:1604:4: ( (lv_max_8_0= RULE_NUMBER ) )
                    // InternalMM_M4DS.g:1605:5: (lv_max_8_0= RULE_NUMBER )
                    {
                    // InternalMM_M4DS.g:1605:5: (lv_max_8_0= RULE_NUMBER )
                    // InternalMM_M4DS.g:1606:6: lv_max_8_0= RULE_NUMBER
                    {
                    lv_max_8_0=(Token)match(input,RULE_NUMBER,FOLLOW_11); 

                    						newLeafNode(lv_max_8_0, grammarAccess.getContinuousAccess().getMaxNUMBERTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"max",
                    							lv_max_8_0,
                    							"xtext.MM_M4DS.NUMBER");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_6());
            		

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


    // $ANTLR start "entryRuleDateField"
    // InternalMM_M4DS.g:1631:1: entryRuleDateField returns [EObject current=null] : iv_ruleDateField= ruleDateField EOF ;
    public final EObject entryRuleDateField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateField = null;


        try {
            // InternalMM_M4DS.g:1631:50: (iv_ruleDateField= ruleDateField EOF )
            // InternalMM_M4DS.g:1632:2: iv_ruleDateField= ruleDateField EOF
            {
             newCompositeNode(grammarAccess.getDateFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateField=ruleDateField();

            state._fsp--;

             current =iv_ruleDateField; 
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
    // $ANTLR end "entryRuleDateField"


    // $ANTLR start "ruleDateField"
    // InternalMM_M4DS.g:1638:1: ruleDateField returns [EObject current=null] : (otherlv_0= 'Date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'format' ( (lv_format_4_0= RULE_STRING ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleDateField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_format_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMM_M4DS.g:1644:2: ( (otherlv_0= 'Date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'format' ( (lv_format_4_0= RULE_STRING ) ) )? otherlv_5= '}' ) )
            // InternalMM_M4DS.g:1645:2: (otherlv_0= 'Date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'format' ( (lv_format_4_0= RULE_STRING ) ) )? otherlv_5= '}' )
            {
            // InternalMM_M4DS.g:1645:2: (otherlv_0= 'Date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'format' ( (lv_format_4_0= RULE_STRING ) ) )? otherlv_5= '}' )
            // InternalMM_M4DS.g:1646:3: otherlv_0= 'Date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'format' ( (lv_format_4_0= RULE_STRING ) ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDateFieldAccess().getDateKeyword_0());
            		
            // InternalMM_M4DS.g:1650:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:1651:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:1651:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:1652:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDateFieldAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getDateFieldAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMM_M4DS.g:1672:3: (otherlv_3= 'format' ( (lv_format_4_0= RULE_STRING ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMM_M4DS.g:1673:4: otherlv_3= 'format' ( (lv_format_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,44,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getDateFieldAccess().getFormatKeyword_3_0());
                    			
                    // InternalMM_M4DS.g:1677:4: ( (lv_format_4_0= RULE_STRING ) )
                    // InternalMM_M4DS.g:1678:5: (lv_format_4_0= RULE_STRING )
                    {
                    // InternalMM_M4DS.g:1678:5: (lv_format_4_0= RULE_STRING )
                    // InternalMM_M4DS.g:1679:6: lv_format_4_0= RULE_STRING
                    {
                    lv_format_4_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

                    						newLeafNode(lv_format_4_0, grammarAccess.getDateFieldAccess().getFormatSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDateFieldRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"format",
                    							lv_format_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDateFieldAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleDateField"


    // $ANTLR start "entryRuleParameter"
    // InternalMM_M4DS.g:1704:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMM_M4DS.g:1704:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMM_M4DS.g:1705:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalMM_M4DS.g:1711:1: ruleParameter returns [EObject current=null] : (otherlv_0= 'Parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleDataType ) ) (otherlv_5= 'value' ( (lv_value_6_0= ruleValue ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_type_4_0 = null;

        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1717:2: ( (otherlv_0= 'Parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleDataType ) ) (otherlv_5= 'value' ( (lv_value_6_0= ruleValue ) ) )? otherlv_7= '}' ) )
            // InternalMM_M4DS.g:1718:2: (otherlv_0= 'Parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleDataType ) ) (otherlv_5= 'value' ( (lv_value_6_0= ruleValue ) ) )? otherlv_7= '}' )
            {
            // InternalMM_M4DS.g:1718:2: (otherlv_0= 'Parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleDataType ) ) (otherlv_5= 'value' ( (lv_value_6_0= ruleValue ) ) )? otherlv_7= '}' )
            // InternalMM_M4DS.g:1719:3: otherlv_0= 'Parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleDataType ) ) (otherlv_5= 'value' ( (lv_value_6_0= ruleValue ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterAccess().getParameterKeyword_0());
            		
            // InternalMM_M4DS.g:1723:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMM_M4DS.g:1724:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMM_M4DS.g:1724:4: (lv_name_1_0= RULE_ID )
            // InternalMM_M4DS.g:1725:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,46,FOLLOW_34); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterAccess().getTypeKeyword_3());
            		
            // InternalMM_M4DS.g:1749:3: ( (lv_type_4_0= ruleDataType ) )
            // InternalMM_M4DS.g:1750:4: (lv_type_4_0= ruleDataType )
            {
            // InternalMM_M4DS.g:1750:4: (lv_type_4_0= ruleDataType )
            // InternalMM_M4DS.g:1751:5: lv_type_4_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeDataTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_42);
            lv_type_4_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"xtext.MM_M4DS.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMM_M4DS.g:1768:3: (otherlv_5= 'value' ( (lv_value_6_0= ruleValue ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMM_M4DS.g:1769:4: otherlv_5= 'value' ( (lv_value_6_0= ruleValue ) )
                    {
                    otherlv_5=(Token)match(input,36,FOLLOW_32); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getValueKeyword_5_0());
                    			
                    // InternalMM_M4DS.g:1773:4: ( (lv_value_6_0= ruleValue ) )
                    // InternalMM_M4DS.g:1774:5: (lv_value_6_0= ruleValue )
                    {
                    // InternalMM_M4DS.g:1774:5: (lv_value_6_0= ruleValue )
                    // InternalMM_M4DS.g:1775:6: lv_value_6_0= ruleValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getValueValueParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_value_6_0=ruleValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_6_0,
                    							"xtext.MM_M4DS.Value");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_6());
            		

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


    // $ANTLR start "entryRuleValue"
    // InternalMM_M4DS.g:1801:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalMM_M4DS.g:1801:46: (iv_ruleValue= ruleValue EOF )
            // InternalMM_M4DS.g:1802:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalMM_M4DS.g:1808:1: ruleValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_NumberValue_1= ruleNumberValue | this_BooleanValue_2= ruleBooleanValue ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringValue_0 = null;

        EObject this_NumberValue_1 = null;

        EObject this_BooleanValue_2 = null;



        	enterRule();

        try {
            // InternalMM_M4DS.g:1814:2: ( (this_StringValue_0= ruleStringValue | this_NumberValue_1= ruleNumberValue | this_BooleanValue_2= ruleBooleanValue ) )
            // InternalMM_M4DS.g:1815:2: (this_StringValue_0= ruleStringValue | this_NumberValue_1= ruleNumberValue | this_BooleanValue_2= ruleBooleanValue )
            {
            // InternalMM_M4DS.g:1815:2: (this_StringValue_0= ruleStringValue | this_NumberValue_1= ruleNumberValue | this_BooleanValue_2= ruleBooleanValue )
            int alt31=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt31=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt31=2;
                }
                break;
            case 47:
            case 48:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalMM_M4DS.g:1816:3: this_StringValue_0= ruleStringValue
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getStringValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;


                    			current = this_StringValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMM_M4DS.g:1825:3: this_NumberValue_1= ruleNumberValue
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getNumberValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberValue_1=ruleNumberValue();

                    state._fsp--;


                    			current = this_NumberValue_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMM_M4DS.g:1834:3: this_BooleanValue_2= ruleBooleanValue
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanValue_2=ruleBooleanValue();

                    state._fsp--;


                    			current = this_BooleanValue_2;
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
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleStringValue"
    // InternalMM_M4DS.g:1846:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // InternalMM_M4DS.g:1846:52: (iv_ruleStringValue= ruleStringValue EOF )
            // InternalMM_M4DS.g:1847:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
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
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // InternalMM_M4DS.g:1853:1: ruleStringValue returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMM_M4DS.g:1859:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalMM_M4DS.g:1860:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalMM_M4DS.g:1860:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalMM_M4DS.g:1861:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalMM_M4DS.g:1861:3: (lv_value_0_0= RULE_STRING )
            // InternalMM_M4DS.g:1862:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleNumberValue"
    // InternalMM_M4DS.g:1881:1: entryRuleNumberValue returns [EObject current=null] : iv_ruleNumberValue= ruleNumberValue EOF ;
    public final EObject entryRuleNumberValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberValue = null;


        try {
            // InternalMM_M4DS.g:1881:52: (iv_ruleNumberValue= ruleNumberValue EOF )
            // InternalMM_M4DS.g:1882:2: iv_ruleNumberValue= ruleNumberValue EOF
            {
             newCompositeNode(grammarAccess.getNumberValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberValue=ruleNumberValue();

            state._fsp--;

             current =iv_ruleNumberValue; 
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
    // $ANTLR end "entryRuleNumberValue"


    // $ANTLR start "ruleNumberValue"
    // InternalMM_M4DS.g:1888:1: ruleNumberValue returns [EObject current=null] : ( (lv_value_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumberValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMM_M4DS.g:1894:2: ( ( (lv_value_0_0= RULE_NUMBER ) ) )
            // InternalMM_M4DS.g:1895:2: ( (lv_value_0_0= RULE_NUMBER ) )
            {
            // InternalMM_M4DS.g:1895:2: ( (lv_value_0_0= RULE_NUMBER ) )
            // InternalMM_M4DS.g:1896:3: (lv_value_0_0= RULE_NUMBER )
            {
            // InternalMM_M4DS.g:1896:3: (lv_value_0_0= RULE_NUMBER )
            // InternalMM_M4DS.g:1897:4: lv_value_0_0= RULE_NUMBER
            {
            lv_value_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getNumberValueAccess().getValueNUMBERTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNumberValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"xtext.MM_M4DS.NUMBER");
            			

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
    // $ANTLR end "ruleNumberValue"


    // $ANTLR start "entryRuleBooleanValue"
    // InternalMM_M4DS.g:1916:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalMM_M4DS.g:1916:53: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalMM_M4DS.g:1917:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
             newCompositeNode(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanValue=ruleBooleanValue();

            state._fsp--;

             current =iv_ruleBooleanValue; 
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
    // $ANTLR end "entryRuleBooleanValue"


    // $ANTLR start "ruleBooleanValue"
    // InternalMM_M4DS.g:1923:1: ruleBooleanValue returns [EObject current=null] : ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;


        	enterRule();

        try {
            // InternalMM_M4DS.g:1929:2: ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) )
            // InternalMM_M4DS.g:1930:2: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            {
            // InternalMM_M4DS.g:1930:2: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            // InternalMM_M4DS.g:1931:3: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            {
            // InternalMM_M4DS.g:1931:3: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            // InternalMM_M4DS.g:1932:4: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            {
            // InternalMM_M4DS.g:1932:4: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==47) ) {
                alt32=1;
            }
            else if ( (LA32_0==48) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalMM_M4DS.g:1933:5: lv_value_0_1= 'true'
                    {
                    lv_value_0_1=(Token)match(input,47,FOLLOW_2); 

                    					newLeafNode(lv_value_0_1, grammarAccess.getBooleanValueAccess().getValueTrueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanValueRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalMM_M4DS.g:1944:5: lv_value_0_2= 'false'
                    {
                    lv_value_0_2=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_value_0_2, grammarAccess.getBooleanValueAccess().getValueFalseKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanValueRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_2, null);
                    				

                    }
                    break;

            }


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
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "ruleDataType"
    // InternalMM_M4DS.g:1960:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Double' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Date' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMM_M4DS.g:1966:2: ( ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Double' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Date' ) ) )
            // InternalMM_M4DS.g:1967:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Double' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Date' ) )
            {
            // InternalMM_M4DS.g:1967:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Integer' ) | (enumLiteral_2= 'Double' ) | (enumLiteral_3= 'Boolean' ) | (enumLiteral_4= 'Date' ) )
            int alt33=5;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt33=1;
                }
                break;
            case 50:
                {
                alt33=2;
                }
                break;
            case 51:
                {
                alt33=3;
                }
                break;
            case 52:
                {
                alt33=4;
                }
                break;
            case 43:
                {
                alt33=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalMM_M4DS.g:1968:3: (enumLiteral_0= 'String' )
                    {
                    // InternalMM_M4DS.g:1968:3: (enumLiteral_0= 'String' )
                    // InternalMM_M4DS.g:1969:4: enumLiteral_0= 'String'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMM_M4DS.g:1976:3: (enumLiteral_1= 'Integer' )
                    {
                    // InternalMM_M4DS.g:1976:3: (enumLiteral_1= 'Integer' )
                    // InternalMM_M4DS.g:1977:4: enumLiteral_1= 'Integer'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMM_M4DS.g:1984:3: (enumLiteral_2= 'Double' )
                    {
                    // InternalMM_M4DS.g:1984:3: (enumLiteral_2= 'Double' )
                    // InternalMM_M4DS.g:1985:4: enumLiteral_2= 'Double'
                    {
                    enumLiteral_2=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDOUBLEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getDOUBLEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMM_M4DS.g:1992:3: (enumLiteral_3= 'Boolean' )
                    {
                    // InternalMM_M4DS.g:1992:3: (enumLiteral_3= 'Boolean' )
                    // InternalMM_M4DS.g:1993:4: enumLiteral_3= 'Boolean'
                    {
                    enumLiteral_3=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMM_M4DS.g:2000:3: (enumLiteral_4= 'Date' )
                    {
                    // InternalMM_M4DS.g:2000:3: (enumLiteral_4= 'Date' )
                    // InternalMM_M4DS.g:2001:4: enumLiteral_4= 'Date'
                    {
                    enumLiteral_4=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_4());
                    			

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


    // $ANTLR start "ruleOperation"
    // InternalMM_M4DS.g:2011:1: ruleOperation returns [Enumerator current=null] : ( (enumLiteral_0= 'filter' ) | (enumLiteral_1= 'map' ) | (enumLiteral_2= 'reduce' ) | (enumLiteral_3= 'join' ) ) ;
    public final Enumerator ruleOperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMM_M4DS.g:2017:2: ( ( (enumLiteral_0= 'filter' ) | (enumLiteral_1= 'map' ) | (enumLiteral_2= 'reduce' ) | (enumLiteral_3= 'join' ) ) )
            // InternalMM_M4DS.g:2018:2: ( (enumLiteral_0= 'filter' ) | (enumLiteral_1= 'map' ) | (enumLiteral_2= 'reduce' ) | (enumLiteral_3= 'join' ) )
            {
            // InternalMM_M4DS.g:2018:2: ( (enumLiteral_0= 'filter' ) | (enumLiteral_1= 'map' ) | (enumLiteral_2= 'reduce' ) | (enumLiteral_3= 'join' ) )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt34=1;
                }
                break;
            case 54:
                {
                alt34=2;
                }
                break;
            case 55:
                {
                alt34=3;
                }
                break;
            case 56:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalMM_M4DS.g:2019:3: (enumLiteral_0= 'filter' )
                    {
                    // InternalMM_M4DS.g:2019:3: (enumLiteral_0= 'filter' )
                    // InternalMM_M4DS.g:2020:4: enumLiteral_0= 'filter'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getFILTEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationAccess().getFILTEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMM_M4DS.g:2027:3: (enumLiteral_1= 'map' )
                    {
                    // InternalMM_M4DS.g:2027:3: (enumLiteral_1= 'map' )
                    // InternalMM_M4DS.g:2028:4: enumLiteral_1= 'map'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getMAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperationAccess().getMAPEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMM_M4DS.g:2035:3: (enumLiteral_2= 'reduce' )
                    {
                    // InternalMM_M4DS.g:2035:3: (enumLiteral_2= 'reduce' )
                    // InternalMM_M4DS.g:2036:4: enumLiteral_2= 'reduce'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getREDUCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOperationAccess().getREDUCEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMM_M4DS.g:2043:3: (enumLiteral_3= 'join' )
                    {
                    // InternalMM_M4DS.g:2043:3: (enumLiteral_3= 'join' )
                    // InternalMM_M4DS.g:2044:4: enumLiteral_3= 'join'
                    {
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getJOINEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOperationAccess().getJOINEnumLiteralDeclaration_3());
                    			

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


    // $ANTLR start "ruleComparisonOperator"
    // InternalMM_M4DS.g:2054:1: ruleComparisonOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'greater' ) | (enumLiteral_2= 'less' ) | (enumLiteral_3= 'contains' ) ) ;
    public final Enumerator ruleComparisonOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMM_M4DS.g:2060:2: ( ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'greater' ) | (enumLiteral_2= 'less' ) | (enumLiteral_3= 'contains' ) ) )
            // InternalMM_M4DS.g:2061:2: ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'greater' ) | (enumLiteral_2= 'less' ) | (enumLiteral_3= 'contains' ) )
            {
            // InternalMM_M4DS.g:2061:2: ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'greater' ) | (enumLiteral_2= 'less' ) | (enumLiteral_3= 'contains' ) )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt35=1;
                }
                break;
            case 58:
                {
                alt35=2;
                }
                break;
            case 59:
                {
                alt35=3;
                }
                break;
            case 60:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalMM_M4DS.g:2062:3: (enumLiteral_0= 'equals' )
                    {
                    // InternalMM_M4DS.g:2062:3: (enumLiteral_0= 'equals' )
                    // InternalMM_M4DS.g:2063:4: enumLiteral_0= 'equals'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getEQUALSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorAccess().getEQUALSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMM_M4DS.g:2070:3: (enumLiteral_1= 'greater' )
                    {
                    // InternalMM_M4DS.g:2070:3: (enumLiteral_1= 'greater' )
                    // InternalMM_M4DS.g:2071:4: enumLiteral_1= 'greater'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorAccess().getGREATEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMM_M4DS.g:2078:3: (enumLiteral_2= 'less' )
                    {
                    // InternalMM_M4DS.g:2078:3: (enumLiteral_2= 'less' )
                    // InternalMM_M4DS.g:2079:4: enumLiteral_2= 'less'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLESSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorAccess().getLESSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMM_M4DS.g:2086:3: (enumLiteral_3= 'contains' )
                    {
                    // InternalMM_M4DS.g:2086:3: (enumLiteral_3= 'contains' )
                    // InternalMM_M4DS.g:2087:4: enumLiteral_3= 'contains'
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getCONTAINSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorAccess().getCONTAINSEnumLiteralDeclaration_3());
                    			

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
    // $ANTLR end "ruleComparisonOperator"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000080801002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000034000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000092000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000007010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000028000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000006010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004010000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080819000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010080000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x01E0000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100010000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x1E00000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0001800000000060L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000000C000010000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x001E080000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000064000010000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000060000010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000040000010000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000001000010000L});

}