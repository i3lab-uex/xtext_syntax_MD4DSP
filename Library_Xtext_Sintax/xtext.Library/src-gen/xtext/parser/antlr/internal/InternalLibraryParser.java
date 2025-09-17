package xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xtext.services.LibraryGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLibraryParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Library'", "'{'", "'dataprocessingdefinition'", "','", "'}'", "'Job'", "'in'", "'('", "')'", "'out'", "'workflow'", "'parameterdefinition'", "'contractdefinition'", "'inputPort'", "'outputPort'", "'Transformation'", "'ContractDefinition'", "'boundTo'", "'contractDefinition'", "'DataDictionaryDefinition'", "'datafielddefinition'", "'CategoricalDef'", "'ContinuousDef'", "'DateDef'", "'MapDef'", "'required'", "'CastTypeDef'", "'PrimitiveDef'", "'DerivedFieldDef'", "'FilterValueDef'", "'matchingvaluedef'", "'primitivedef'", "'RangeDef'", "'MissingValuesDef'", "'DateRangeDef'", "'DiscretizeBinDef'", "'DerivedValueDef'", "'NumOpDef'", "'FixValueDef'", "'value'", "'FieldRangeDef'", "'MathOpDef'", "'operandDef'", "'JoinDef'", "'FieldDef'", "'true'", "'false'", "'ConditionDef'", "'ValueRangeDefinition'", "'FieldRangeDefinition'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
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
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
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


        public InternalLibraryParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLibraryParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLibraryParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLibrary.g"; }



     	private LibraryGrammarAccess grammarAccess;

        public InternalLibraryParser(TokenStream input, LibraryGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Library";
       	}

       	@Override
       	protected LibraryGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleLibrary"
    // InternalLibrary.g:64:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // InternalLibrary.g:64:48: (iv_ruleLibrary= ruleLibrary EOF )
            // InternalLibrary.g:65:2: iv_ruleLibrary= ruleLibrary EOF
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
    // InternalLibrary.g:71:1: ruleLibrary returns [EObject current=null] : (otherlv_0= 'Library' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'dataprocessingdefinition' otherlv_4= '{' ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) ) (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dataprocessingdefinition_5_0 = null;

        EObject lv_dataprocessingdefinition_7_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:77:2: ( (otherlv_0= 'Library' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'dataprocessingdefinition' otherlv_4= '{' ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) ) (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalLibrary.g:78:2: (otherlv_0= 'Library' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'dataprocessingdefinition' otherlv_4= '{' ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) ) (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalLibrary.g:78:2: (otherlv_0= 'Library' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'dataprocessingdefinition' otherlv_4= '{' ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) ) (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalLibrary.g:79:3: otherlv_0= 'Library' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'dataprocessingdefinition' otherlv_4= '{' ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) ) (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLibraryAccess().getLibraryKeyword_0());
            		
            // InternalLibrary.g:83:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:84:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:84:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:85:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLibraryAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLibraryRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:106:3: (otherlv_3= 'dataprocessingdefinition' otherlv_4= '{' ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) ) (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )* otherlv_8= '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalLibrary.g:107:4: otherlv_3= 'dataprocessingdefinition' otherlv_4= '{' ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) ) (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getLibraryAccess().getDataprocessingdefinitionKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalLibrary.g:115:4: ( (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition ) )
                    // InternalLibrary.g:116:5: (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition )
                    {
                    // InternalLibrary.g:116:5: (lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition )
                    // InternalLibrary.g:117:6: lv_dataprocessingdefinition_5_0= ruleDataProcessingDefinition
                    {

                    						newCompositeNode(grammarAccess.getLibraryAccess().getDataprocessingdefinitionDataProcessingDefinitionParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_dataprocessingdefinition_5_0=ruleDataProcessingDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLibraryRule());
                    						}
                    						add(
                    							current,
                    							"dataprocessingdefinition",
                    							lv_dataprocessingdefinition_5_0,
                    							"xtext.Library.DataProcessingDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:134:4: (otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalLibrary.g:135:5: otherlv_6= ',' ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_6); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getLibraryAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalLibrary.g:139:5: ( (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition ) )
                    	    // InternalLibrary.g:140:6: (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition )
                    	    {
                    	    // InternalLibrary.g:140:6: (lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition )
                    	    // InternalLibrary.g:141:7: lv_dataprocessingdefinition_7_0= ruleDataProcessingDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getLibraryAccess().getDataprocessingdefinitionDataProcessingDefinitionParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_dataprocessingdefinition_7_0=ruleDataProcessingDefinition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getLibraryRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataprocessingdefinition",
                    	    								lv_dataprocessingdefinition_7_0,
                    	    								"xtext.Library.DataProcessingDefinition");
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

                    				newLeafNode(otherlv_8, grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_4());
            		

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


    // $ANTLR start "entryRuleDataProcessingDefinition"
    // InternalLibrary.g:172:1: entryRuleDataProcessingDefinition returns [EObject current=null] : iv_ruleDataProcessingDefinition= ruleDataProcessingDefinition EOF ;
    public final EObject entryRuleDataProcessingDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataProcessingDefinition = null;


        try {
            // InternalLibrary.g:172:65: (iv_ruleDataProcessingDefinition= ruleDataProcessingDefinition EOF )
            // InternalLibrary.g:173:2: iv_ruleDataProcessingDefinition= ruleDataProcessingDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataProcessingDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataProcessingDefinition=ruleDataProcessingDefinition();

            state._fsp--;

             current =iv_ruleDataProcessingDefinition; 
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
    // $ANTLR end "entryRuleDataProcessingDefinition"


    // $ANTLR start "ruleDataProcessingDefinition"
    // InternalLibrary.g:179:1: ruleDataProcessingDefinition returns [EObject current=null] : (this_Job_0= ruleJob | this_Transformation_1= ruleTransformation ) ;
    public final EObject ruleDataProcessingDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_Job_0 = null;

        EObject this_Transformation_1 = null;



        	enterRule();

        try {
            // InternalLibrary.g:185:2: ( (this_Job_0= ruleJob | this_Transformation_1= ruleTransformation ) )
            // InternalLibrary.g:186:2: (this_Job_0= ruleJob | this_Transformation_1= ruleTransformation )
            {
            // InternalLibrary.g:186:2: (this_Job_0= ruleJob | this_Transformation_1= ruleTransformation )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==26) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalLibrary.g:187:3: this_Job_0= ruleJob
                    {

                    			newCompositeNode(grammarAccess.getDataProcessingDefinitionAccess().getJobParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Job_0=ruleJob();

                    state._fsp--;


                    			current = this_Job_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:196:3: this_Transformation_1= ruleTransformation
                    {

                    			newCompositeNode(grammarAccess.getDataProcessingDefinitionAccess().getTransformationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Transformation_1=ruleTransformation();

                    state._fsp--;


                    			current = this_Transformation_1;
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
    // $ANTLR end "ruleDataProcessingDefinition"


    // $ANTLR start "entryRuleJob"
    // InternalLibrary.g:208:1: entryRuleJob returns [EObject current=null] : iv_ruleJob= ruleJob EOF ;
    public final EObject entryRuleJob() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJob = null;


        try {
            // InternalLibrary.g:208:44: (iv_ruleJob= ruleJob EOF )
            // InternalLibrary.g:209:2: iv_ruleJob= ruleJob EOF
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
    // InternalLibrary.g:215:1: ruleJob returns [EObject current=null] : (otherlv_0= 'Job' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'workflow' ( (lv_workflow_16_0= ruleEString ) ) (otherlv_17= 'parameterdefinition' otherlv_18= '{' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )* otherlv_22= '}' )? (otherlv_23= 'contractdefinition' otherlv_24= '{' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )* otherlv_28= '}' )? otherlv_29= 'inputPort' otherlv_30= '{' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) (otherlv_32= ',' ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) ) )* otherlv_34= '}' otherlv_35= 'outputPort' otherlv_36= '{' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) (otherlv_38= ',' ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) ) )* otherlv_40= '}' otherlv_41= '}' ) ;
    public final EObject ruleJob() throws RecognitionException {
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
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
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

        AntlrDatatypeRuleToken lv_workflow_16_0 = null;

        EObject lv_parameterdefinition_19_0 = null;

        EObject lv_parameterdefinition_21_0 = null;

        EObject lv_contractdefinition_25_0 = null;

        EObject lv_contractdefinition_27_0 = null;

        EObject lv_inputPort_31_0 = null;

        EObject lv_inputPort_33_0 = null;

        EObject lv_outputPort_37_0 = null;

        EObject lv_outputPort_39_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:221:2: ( (otherlv_0= 'Job' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'workflow' ( (lv_workflow_16_0= ruleEString ) ) (otherlv_17= 'parameterdefinition' otherlv_18= '{' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )* otherlv_22= '}' )? (otherlv_23= 'contractdefinition' otherlv_24= '{' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )* otherlv_28= '}' )? otherlv_29= 'inputPort' otherlv_30= '{' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) (otherlv_32= ',' ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) ) )* otherlv_34= '}' otherlv_35= 'outputPort' otherlv_36= '{' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) (otherlv_38= ',' ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) ) )* otherlv_40= '}' otherlv_41= '}' ) )
            // InternalLibrary.g:222:2: (otherlv_0= 'Job' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'workflow' ( (lv_workflow_16_0= ruleEString ) ) (otherlv_17= 'parameterdefinition' otherlv_18= '{' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )* otherlv_22= '}' )? (otherlv_23= 'contractdefinition' otherlv_24= '{' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )* otherlv_28= '}' )? otherlv_29= 'inputPort' otherlv_30= '{' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) (otherlv_32= ',' ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) ) )* otherlv_34= '}' otherlv_35= 'outputPort' otherlv_36= '{' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) (otherlv_38= ',' ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) ) )* otherlv_40= '}' otherlv_41= '}' )
            {
            // InternalLibrary.g:222:2: (otherlv_0= 'Job' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'workflow' ( (lv_workflow_16_0= ruleEString ) ) (otherlv_17= 'parameterdefinition' otherlv_18= '{' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )* otherlv_22= '}' )? (otherlv_23= 'contractdefinition' otherlv_24= '{' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )* otherlv_28= '}' )? otherlv_29= 'inputPort' otherlv_30= '{' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) (otherlv_32= ',' ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) ) )* otherlv_34= '}' otherlv_35= 'outputPort' otherlv_36= '{' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) (otherlv_38= ',' ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) ) )* otherlv_40= '}' otherlv_41= '}' )
            // InternalLibrary.g:223:3: otherlv_0= 'Job' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' otherlv_15= 'workflow' ( (lv_workflow_16_0= ruleEString ) ) (otherlv_17= 'parameterdefinition' otherlv_18= '{' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )* otherlv_22= '}' )? (otherlv_23= 'contractdefinition' otherlv_24= '{' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )* otherlv_28= '}' )? otherlv_29= 'inputPort' otherlv_30= '{' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) (otherlv_32= ',' ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) ) )* otherlv_34= '}' otherlv_35= 'outputPort' otherlv_36= '{' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) (otherlv_38= ',' ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) ) )* otherlv_40= '}' otherlv_41= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJobAccess().getJobKeyword_0());
            		
            // InternalLibrary.g:227:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:228:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:228:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:229:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJobAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJobRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getJobAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getJobAccess().getInKeyword_3());
            		
            otherlv_4=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getJobAccess().getLeftParenthesisKeyword_4());
            		
            // InternalLibrary.g:258:3: ( ( ruleEString ) )
            // InternalLibrary.g:259:4: ( ruleEString )
            {
            // InternalLibrary.g:259:4: ( ruleEString )
            // InternalLibrary.g:260:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJobRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJobAccess().getInArgumentDefinitionCrossReference_5_0());
            				
            pushFollow(FOLLOW_11);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:274:3: (otherlv_6= ',' ( ( ruleEString ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalLibrary.g:275:4: otherlv_6= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_6=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_6, grammarAccess.getJobAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalLibrary.g:279:4: ( ( ruleEString ) )
            	    // InternalLibrary.g:280:5: ( ruleEString )
            	    {
            	    // InternalLibrary.g:280:5: ( ruleEString )
            	    // InternalLibrary.g:281:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getJobRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getJobAccess().getInArgumentDefinitionCrossReference_6_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_8=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_8, grammarAccess.getJobAccess().getRightParenthesisKeyword_7());
            		
            otherlv_9=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_9, grammarAccess.getJobAccess().getOutKeyword_8());
            		
            otherlv_10=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_10, grammarAccess.getJobAccess().getLeftParenthesisKeyword_9());
            		
            // InternalLibrary.g:308:3: ( ( ruleEString ) )
            // InternalLibrary.g:309:4: ( ruleEString )
            {
            // InternalLibrary.g:309:4: ( ruleEString )
            // InternalLibrary.g:310:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJobRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJobAccess().getOutArgumentDefinitionCrossReference_10_0());
            				
            pushFollow(FOLLOW_11);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:324:3: (otherlv_12= ',' ( ( ruleEString ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLibrary.g:325:4: otherlv_12= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_12=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_12, grammarAccess.getJobAccess().getCommaKeyword_11_0());
            	    			
            	    // InternalLibrary.g:329:4: ( ( ruleEString ) )
            	    // InternalLibrary.g:330:5: ( ruleEString )
            	    {
            	    // InternalLibrary.g:330:5: ( ruleEString )
            	    // InternalLibrary.g:331:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getJobRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getJobAccess().getOutArgumentDefinitionCrossReference_11_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_14=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_14, grammarAccess.getJobAccess().getRightParenthesisKeyword_12());
            		
            otherlv_15=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getJobAccess().getWorkflowKeyword_13());
            		
            // InternalLibrary.g:354:3: ( (lv_workflow_16_0= ruleEString ) )
            // InternalLibrary.g:355:4: (lv_workflow_16_0= ruleEString )
            {
            // InternalLibrary.g:355:4: (lv_workflow_16_0= ruleEString )
            // InternalLibrary.g:356:5: lv_workflow_16_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJobAccess().getWorkflowEStringParserRuleCall_14_0());
            				
            pushFollow(FOLLOW_14);
            lv_workflow_16_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJobRule());
            					}
            					set(
            						current,
            						"workflow",
            						lv_workflow_16_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:373:3: (otherlv_17= 'parameterdefinition' otherlv_18= '{' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )* otherlv_22= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalLibrary.g:374:4: otherlv_17= 'parameterdefinition' otherlv_18= '{' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )* otherlv_22= '}'
                    {
                    otherlv_17=(Token)match(input,22,FOLLOW_4); 

                    				newLeafNode(otherlv_17, grammarAccess.getJobAccess().getParameterdefinitionKeyword_15_0());
                    			
                    otherlv_18=(Token)match(input,12,FOLLOW_15); 

                    				newLeafNode(otherlv_18, grammarAccess.getJobAccess().getLeftCurlyBracketKeyword_15_1());
                    			
                    // InternalLibrary.g:382:4: ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) )
                    // InternalLibrary.g:383:5: (lv_parameterdefinition_19_0= ruleParameterDefinition )
                    {
                    // InternalLibrary.g:383:5: (lv_parameterdefinition_19_0= ruleParameterDefinition )
                    // InternalLibrary.g:384:6: lv_parameterdefinition_19_0= ruleParameterDefinition
                    {

                    						newCompositeNode(grammarAccess.getJobAccess().getParameterdefinitionParameterDefinitionParserRuleCall_15_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_parameterdefinition_19_0=ruleParameterDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJobRule());
                    						}
                    						add(
                    							current,
                    							"parameterdefinition",
                    							lv_parameterdefinition_19_0,
                    							"xtext.Library.ParameterDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:401:4: (otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalLibrary.g:402:5: otherlv_20= ',' ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) )
                    	    {
                    	    otherlv_20=(Token)match(input,14,FOLLOW_15); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getJobAccess().getCommaKeyword_15_3_0());
                    	    				
                    	    // InternalLibrary.g:406:5: ( (lv_parameterdefinition_21_0= ruleParameterDefinition ) )
                    	    // InternalLibrary.g:407:6: (lv_parameterdefinition_21_0= ruleParameterDefinition )
                    	    {
                    	    // InternalLibrary.g:407:6: (lv_parameterdefinition_21_0= ruleParameterDefinition )
                    	    // InternalLibrary.g:408:7: lv_parameterdefinition_21_0= ruleParameterDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getJobAccess().getParameterdefinitionParameterDefinitionParserRuleCall_15_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_parameterdefinition_21_0=ruleParameterDefinition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getJobRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameterdefinition",
                    	    								lv_parameterdefinition_21_0,
                    	    								"xtext.Library.ParameterDefinition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,15,FOLLOW_16); 

                    				newLeafNode(otherlv_22, grammarAccess.getJobAccess().getRightCurlyBracketKeyword_15_4());
                    			

                    }
                    break;

            }

            // InternalLibrary.g:431:3: (otherlv_23= 'contractdefinition' otherlv_24= '{' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )* otherlv_28= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalLibrary.g:432:4: otherlv_23= 'contractdefinition' otherlv_24= '{' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )* otherlv_28= '}'
                    {
                    otherlv_23=(Token)match(input,23,FOLLOW_4); 

                    				newLeafNode(otherlv_23, grammarAccess.getJobAccess().getContractdefinitionKeyword_16_0());
                    			
                    otherlv_24=(Token)match(input,12,FOLLOW_17); 

                    				newLeafNode(otherlv_24, grammarAccess.getJobAccess().getLeftCurlyBracketKeyword_16_1());
                    			
                    // InternalLibrary.g:440:4: ( (lv_contractdefinition_25_0= ruleContractDefinition ) )
                    // InternalLibrary.g:441:5: (lv_contractdefinition_25_0= ruleContractDefinition )
                    {
                    // InternalLibrary.g:441:5: (lv_contractdefinition_25_0= ruleContractDefinition )
                    // InternalLibrary.g:442:6: lv_contractdefinition_25_0= ruleContractDefinition
                    {

                    						newCompositeNode(grammarAccess.getJobAccess().getContractdefinitionContractDefinitionParserRuleCall_16_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_contractdefinition_25_0=ruleContractDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJobRule());
                    						}
                    						add(
                    							current,
                    							"contractdefinition",
                    							lv_contractdefinition_25_0,
                    							"xtext.Library.ContractDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:459:4: (otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==14) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalLibrary.g:460:5: otherlv_26= ',' ( (lv_contractdefinition_27_0= ruleContractDefinition ) )
                    	    {
                    	    otherlv_26=(Token)match(input,14,FOLLOW_17); 

                    	    					newLeafNode(otherlv_26, grammarAccess.getJobAccess().getCommaKeyword_16_3_0());
                    	    				
                    	    // InternalLibrary.g:464:5: ( (lv_contractdefinition_27_0= ruleContractDefinition ) )
                    	    // InternalLibrary.g:465:6: (lv_contractdefinition_27_0= ruleContractDefinition )
                    	    {
                    	    // InternalLibrary.g:465:6: (lv_contractdefinition_27_0= ruleContractDefinition )
                    	    // InternalLibrary.g:466:7: lv_contractdefinition_27_0= ruleContractDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getJobAccess().getContractdefinitionContractDefinitionParserRuleCall_16_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_contractdefinition_27_0=ruleContractDefinition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getJobRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"contractdefinition",
                    	    								lv_contractdefinition_27_0,
                    	    								"xtext.Library.ContractDefinition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_28=(Token)match(input,15,FOLLOW_18); 

                    				newLeafNode(otherlv_28, grammarAccess.getJobAccess().getRightCurlyBracketKeyword_16_4());
                    			

                    }
                    break;

            }

            otherlv_29=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_29, grammarAccess.getJobAccess().getInputPortKeyword_17());
            		
            otherlv_30=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_30, grammarAccess.getJobAccess().getLeftCurlyBracketKeyword_18());
            		
            // InternalLibrary.g:497:3: ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) )
            // InternalLibrary.g:498:4: (lv_inputPort_31_0= ruleDataDictionaryDefinition )
            {
            // InternalLibrary.g:498:4: (lv_inputPort_31_0= ruleDataDictionaryDefinition )
            // InternalLibrary.g:499:5: lv_inputPort_31_0= ruleDataDictionaryDefinition
            {

            					newCompositeNode(grammarAccess.getJobAccess().getInputPortDataDictionaryDefinitionParserRuleCall_19_0());
            				
            pushFollow(FOLLOW_7);
            lv_inputPort_31_0=ruleDataDictionaryDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJobRule());
            					}
            					add(
            						current,
            						"inputPort",
            						lv_inputPort_31_0,
            						"xtext.Library.DataDictionaryDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:516:3: (otherlv_32= ',' ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalLibrary.g:517:4: otherlv_32= ',' ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) )
            	    {
            	    otherlv_32=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_32, grammarAccess.getJobAccess().getCommaKeyword_20_0());
            	    			
            	    // InternalLibrary.g:521:4: ( (lv_inputPort_33_0= ruleDataDictionaryDefinition ) )
            	    // InternalLibrary.g:522:5: (lv_inputPort_33_0= ruleDataDictionaryDefinition )
            	    {
            	    // InternalLibrary.g:522:5: (lv_inputPort_33_0= ruleDataDictionaryDefinition )
            	    // InternalLibrary.g:523:6: lv_inputPort_33_0= ruleDataDictionaryDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getJobAccess().getInputPortDataDictionaryDefinitionParserRuleCall_20_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_inputPort_33_0=ruleDataDictionaryDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJobRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputPort",
            	    							lv_inputPort_33_0,
            	    							"xtext.Library.DataDictionaryDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_34=(Token)match(input,15,FOLLOW_20); 

            			newLeafNode(otherlv_34, grammarAccess.getJobAccess().getRightCurlyBracketKeyword_21());
            		
            otherlv_35=(Token)match(input,25,FOLLOW_4); 

            			newLeafNode(otherlv_35, grammarAccess.getJobAccess().getOutputPortKeyword_22());
            		
            otherlv_36=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_36, grammarAccess.getJobAccess().getLeftCurlyBracketKeyword_23());
            		
            // InternalLibrary.g:553:3: ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) )
            // InternalLibrary.g:554:4: (lv_outputPort_37_0= ruleDataDictionaryDefinition )
            {
            // InternalLibrary.g:554:4: (lv_outputPort_37_0= ruleDataDictionaryDefinition )
            // InternalLibrary.g:555:5: lv_outputPort_37_0= ruleDataDictionaryDefinition
            {

            					newCompositeNode(grammarAccess.getJobAccess().getOutputPortDataDictionaryDefinitionParserRuleCall_24_0());
            				
            pushFollow(FOLLOW_7);
            lv_outputPort_37_0=ruleDataDictionaryDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJobRule());
            					}
            					add(
            						current,
            						"outputPort",
            						lv_outputPort_37_0,
            						"xtext.Library.DataDictionaryDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:572:3: (otherlv_38= ',' ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalLibrary.g:573:4: otherlv_38= ',' ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) )
            	    {
            	    otherlv_38=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_38, grammarAccess.getJobAccess().getCommaKeyword_25_0());
            	    			
            	    // InternalLibrary.g:577:4: ( (lv_outputPort_39_0= ruleDataDictionaryDefinition ) )
            	    // InternalLibrary.g:578:5: (lv_outputPort_39_0= ruleDataDictionaryDefinition )
            	    {
            	    // InternalLibrary.g:578:5: (lv_outputPort_39_0= ruleDataDictionaryDefinition )
            	    // InternalLibrary.g:579:6: lv_outputPort_39_0= ruleDataDictionaryDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getJobAccess().getOutputPortDataDictionaryDefinitionParserRuleCall_25_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_outputPort_39_0=ruleDataDictionaryDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJobRule());
            	    						}
            	    						add(
            	    							current,
            	    							"outputPort",
            	    							lv_outputPort_39_0,
            	    							"xtext.Library.DataDictionaryDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_40=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_40, grammarAccess.getJobAccess().getRightCurlyBracketKeyword_26());
            		
            otherlv_41=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_41, grammarAccess.getJobAccess().getRightCurlyBracketKeyword_27());
            		

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
    // InternalLibrary.g:609:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;


        try {
            // InternalLibrary.g:609:55: (iv_ruleTransformation= ruleTransformation EOF )
            // InternalLibrary.g:610:2: iv_ruleTransformation= ruleTransformation EOF
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
    // InternalLibrary.g:616:1: ruleTransformation returns [EObject current=null] : (otherlv_0= 'Transformation' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' (otherlv_15= 'parameterdefinition' otherlv_16= '{' ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) ) (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )* otherlv_20= '}' )? (otherlv_21= 'contractdefinition' otherlv_22= '{' ( (lv_contractdefinition_23_0= ruleContractDefinition ) ) (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )* otherlv_26= '}' )? otherlv_27= 'inputPort' otherlv_28= '{' ( (lv_inputPort_29_0= ruleDataDictionaryDefinition ) ) (otherlv_30= ',' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) )* otherlv_32= '}' otherlv_33= 'outputPort' otherlv_34= '{' ( (lv_outputPort_35_0= ruleDataDictionaryDefinition ) ) (otherlv_36= ',' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) )* otherlv_38= '}' otherlv_39= '}' ) ;
    public final EObject ruleTransformation() throws RecognitionException {
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
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_parameterdefinition_17_0 = null;

        EObject lv_parameterdefinition_19_0 = null;

        EObject lv_contractdefinition_23_0 = null;

        EObject lv_contractdefinition_25_0 = null;

        EObject lv_inputPort_29_0 = null;

        EObject lv_inputPort_31_0 = null;

        EObject lv_outputPort_35_0 = null;

        EObject lv_outputPort_37_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:622:2: ( (otherlv_0= 'Transformation' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' (otherlv_15= 'parameterdefinition' otherlv_16= '{' ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) ) (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )* otherlv_20= '}' )? (otherlv_21= 'contractdefinition' otherlv_22= '{' ( (lv_contractdefinition_23_0= ruleContractDefinition ) ) (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )* otherlv_26= '}' )? otherlv_27= 'inputPort' otherlv_28= '{' ( (lv_inputPort_29_0= ruleDataDictionaryDefinition ) ) (otherlv_30= ',' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) )* otherlv_32= '}' otherlv_33= 'outputPort' otherlv_34= '{' ( (lv_outputPort_35_0= ruleDataDictionaryDefinition ) ) (otherlv_36= ',' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) )* otherlv_38= '}' otherlv_39= '}' ) )
            // InternalLibrary.g:623:2: (otherlv_0= 'Transformation' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' (otherlv_15= 'parameterdefinition' otherlv_16= '{' ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) ) (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )* otherlv_20= '}' )? (otherlv_21= 'contractdefinition' otherlv_22= '{' ( (lv_contractdefinition_23_0= ruleContractDefinition ) ) (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )* otherlv_26= '}' )? otherlv_27= 'inputPort' otherlv_28= '{' ( (lv_inputPort_29_0= ruleDataDictionaryDefinition ) ) (otherlv_30= ',' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) )* otherlv_32= '}' otherlv_33= 'outputPort' otherlv_34= '{' ( (lv_outputPort_35_0= ruleDataDictionaryDefinition ) ) (otherlv_36= ',' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) )* otherlv_38= '}' otherlv_39= '}' )
            {
            // InternalLibrary.g:623:2: (otherlv_0= 'Transformation' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' (otherlv_15= 'parameterdefinition' otherlv_16= '{' ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) ) (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )* otherlv_20= '}' )? (otherlv_21= 'contractdefinition' otherlv_22= '{' ( (lv_contractdefinition_23_0= ruleContractDefinition ) ) (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )* otherlv_26= '}' )? otherlv_27= 'inputPort' otherlv_28= '{' ( (lv_inputPort_29_0= ruleDataDictionaryDefinition ) ) (otherlv_30= ',' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) )* otherlv_32= '}' otherlv_33= 'outputPort' otherlv_34= '{' ( (lv_outputPort_35_0= ruleDataDictionaryDefinition ) ) (otherlv_36= ',' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) )* otherlv_38= '}' otherlv_39= '}' )
            // InternalLibrary.g:624:3: otherlv_0= 'Transformation' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'in' otherlv_4= '(' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ')' otherlv_9= 'out' otherlv_10= '(' ( ( ruleEString ) ) (otherlv_12= ',' ( ( ruleEString ) ) )* otherlv_14= ')' (otherlv_15= 'parameterdefinition' otherlv_16= '{' ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) ) (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )* otherlv_20= '}' )? (otherlv_21= 'contractdefinition' otherlv_22= '{' ( (lv_contractdefinition_23_0= ruleContractDefinition ) ) (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )* otherlv_26= '}' )? otherlv_27= 'inputPort' otherlv_28= '{' ( (lv_inputPort_29_0= ruleDataDictionaryDefinition ) ) (otherlv_30= ',' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) )* otherlv_32= '}' otherlv_33= 'outputPort' otherlv_34= '{' ( (lv_outputPort_35_0= ruleDataDictionaryDefinition ) ) (otherlv_36= ',' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) )* otherlv_38= '}' otherlv_39= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransformationAccess().getTransformationKeyword_0());
            		
            // InternalLibrary.g:628:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:629:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:629:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:630:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransformationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getInKeyword_3());
            		
            otherlv_4=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getTransformationAccess().getLeftParenthesisKeyword_4());
            		
            // InternalLibrary.g:659:3: ( ( ruleEString ) )
            // InternalLibrary.g:660:4: ( ruleEString )
            {
            // InternalLibrary.g:660:4: ( ruleEString )
            // InternalLibrary.g:661:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransformationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransformationAccess().getInArgumentDefinitionCrossReference_5_0());
            				
            pushFollow(FOLLOW_11);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:675:3: (otherlv_6= ',' ( ( ruleEString ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalLibrary.g:676:4: otherlv_6= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_6=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_6, grammarAccess.getTransformationAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalLibrary.g:680:4: ( ( ruleEString ) )
            	    // InternalLibrary.g:681:5: ( ruleEString )
            	    {
            	    // InternalLibrary.g:681:5: ( ruleEString )
            	    // InternalLibrary.g:682:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTransformationRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getTransformationAccess().getInArgumentDefinitionCrossReference_6_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_8=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getRightParenthesisKeyword_7());
            		
            otherlv_9=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_9, grammarAccess.getTransformationAccess().getOutKeyword_8());
            		
            otherlv_10=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_10, grammarAccess.getTransformationAccess().getLeftParenthesisKeyword_9());
            		
            // InternalLibrary.g:709:3: ( ( ruleEString ) )
            // InternalLibrary.g:710:4: ( ruleEString )
            {
            // InternalLibrary.g:710:4: ( ruleEString )
            // InternalLibrary.g:711:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransformationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransformationAccess().getOutArgumentDefinitionCrossReference_10_0());
            				
            pushFollow(FOLLOW_11);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:725:3: (otherlv_12= ',' ( ( ruleEString ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==14) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalLibrary.g:726:4: otherlv_12= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_12=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_12, grammarAccess.getTransformationAccess().getCommaKeyword_11_0());
            	    			
            	    // InternalLibrary.g:730:4: ( ( ruleEString ) )
            	    // InternalLibrary.g:731:5: ( ruleEString )
            	    {
            	    // InternalLibrary.g:731:5: ( ruleEString )
            	    // InternalLibrary.g:732:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTransformationRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getTransformationAccess().getOutArgumentDefinitionCrossReference_11_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_14=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_14, grammarAccess.getTransformationAccess().getRightParenthesisKeyword_12());
            		
            // InternalLibrary.g:751:3: (otherlv_15= 'parameterdefinition' otherlv_16= '{' ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) ) (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )* otherlv_20= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalLibrary.g:752:4: otherlv_15= 'parameterdefinition' otherlv_16= '{' ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) ) (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )* otherlv_20= '}'
                    {
                    otherlv_15=(Token)match(input,22,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getTransformationAccess().getParameterdefinitionKeyword_13_0());
                    			
                    otherlv_16=(Token)match(input,12,FOLLOW_15); 

                    				newLeafNode(otherlv_16, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_13_1());
                    			
                    // InternalLibrary.g:760:4: ( (lv_parameterdefinition_17_0= ruleParameterDefinition ) )
                    // InternalLibrary.g:761:5: (lv_parameterdefinition_17_0= ruleParameterDefinition )
                    {
                    // InternalLibrary.g:761:5: (lv_parameterdefinition_17_0= ruleParameterDefinition )
                    // InternalLibrary.g:762:6: lv_parameterdefinition_17_0= ruleParameterDefinition
                    {

                    						newCompositeNode(grammarAccess.getTransformationAccess().getParameterdefinitionParameterDefinitionParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_parameterdefinition_17_0=ruleParameterDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransformationRule());
                    						}
                    						add(
                    							current,
                    							"parameterdefinition",
                    							lv_parameterdefinition_17_0,
                    							"xtext.Library.ParameterDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:779:4: (otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==14) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalLibrary.g:780:5: otherlv_18= ',' ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) )
                    	    {
                    	    otherlv_18=(Token)match(input,14,FOLLOW_15); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getTransformationAccess().getCommaKeyword_13_3_0());
                    	    				
                    	    // InternalLibrary.g:784:5: ( (lv_parameterdefinition_19_0= ruleParameterDefinition ) )
                    	    // InternalLibrary.g:785:6: (lv_parameterdefinition_19_0= ruleParameterDefinition )
                    	    {
                    	    // InternalLibrary.g:785:6: (lv_parameterdefinition_19_0= ruleParameterDefinition )
                    	    // InternalLibrary.g:786:7: lv_parameterdefinition_19_0= ruleParameterDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getTransformationAccess().getParameterdefinitionParameterDefinitionParserRuleCall_13_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_parameterdefinition_19_0=ruleParameterDefinition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTransformationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameterdefinition",
                    	    								lv_parameterdefinition_19_0,
                    	    								"xtext.Library.ParameterDefinition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,15,FOLLOW_16); 

                    				newLeafNode(otherlv_20, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_13_4());
                    			

                    }
                    break;

            }

            // InternalLibrary.g:809:3: (otherlv_21= 'contractdefinition' otherlv_22= '{' ( (lv_contractdefinition_23_0= ruleContractDefinition ) ) (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )* otherlv_26= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalLibrary.g:810:4: otherlv_21= 'contractdefinition' otherlv_22= '{' ( (lv_contractdefinition_23_0= ruleContractDefinition ) ) (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )* otherlv_26= '}'
                    {
                    otherlv_21=(Token)match(input,23,FOLLOW_4); 

                    				newLeafNode(otherlv_21, grammarAccess.getTransformationAccess().getContractdefinitionKeyword_14_0());
                    			
                    otherlv_22=(Token)match(input,12,FOLLOW_17); 

                    				newLeafNode(otherlv_22, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_14_1());
                    			
                    // InternalLibrary.g:818:4: ( (lv_contractdefinition_23_0= ruleContractDefinition ) )
                    // InternalLibrary.g:819:5: (lv_contractdefinition_23_0= ruleContractDefinition )
                    {
                    // InternalLibrary.g:819:5: (lv_contractdefinition_23_0= ruleContractDefinition )
                    // InternalLibrary.g:820:6: lv_contractdefinition_23_0= ruleContractDefinition
                    {

                    						newCompositeNode(grammarAccess.getTransformationAccess().getContractdefinitionContractDefinitionParserRuleCall_14_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_contractdefinition_23_0=ruleContractDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransformationRule());
                    						}
                    						add(
                    							current,
                    							"contractdefinition",
                    							lv_contractdefinition_23_0,
                    							"xtext.Library.ContractDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:837:4: (otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==14) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalLibrary.g:838:5: otherlv_24= ',' ( (lv_contractdefinition_25_0= ruleContractDefinition ) )
                    	    {
                    	    otherlv_24=(Token)match(input,14,FOLLOW_17); 

                    	    					newLeafNode(otherlv_24, grammarAccess.getTransformationAccess().getCommaKeyword_14_3_0());
                    	    				
                    	    // InternalLibrary.g:842:5: ( (lv_contractdefinition_25_0= ruleContractDefinition ) )
                    	    // InternalLibrary.g:843:6: (lv_contractdefinition_25_0= ruleContractDefinition )
                    	    {
                    	    // InternalLibrary.g:843:6: (lv_contractdefinition_25_0= ruleContractDefinition )
                    	    // InternalLibrary.g:844:7: lv_contractdefinition_25_0= ruleContractDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getTransformationAccess().getContractdefinitionContractDefinitionParserRuleCall_14_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_contractdefinition_25_0=ruleContractDefinition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTransformationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"contractdefinition",
                    	    								lv_contractdefinition_25_0,
                    	    								"xtext.Library.ContractDefinition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,15,FOLLOW_18); 

                    				newLeafNode(otherlv_26, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_14_4());
                    			

                    }
                    break;

            }

            otherlv_27=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_27, grammarAccess.getTransformationAccess().getInputPortKeyword_15());
            		
            otherlv_28=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_28, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_16());
            		
            // InternalLibrary.g:875:3: ( (lv_inputPort_29_0= ruleDataDictionaryDefinition ) )
            // InternalLibrary.g:876:4: (lv_inputPort_29_0= ruleDataDictionaryDefinition )
            {
            // InternalLibrary.g:876:4: (lv_inputPort_29_0= ruleDataDictionaryDefinition )
            // InternalLibrary.g:877:5: lv_inputPort_29_0= ruleDataDictionaryDefinition
            {

            					newCompositeNode(grammarAccess.getTransformationAccess().getInputPortDataDictionaryDefinitionParserRuleCall_17_0());
            				
            pushFollow(FOLLOW_7);
            lv_inputPort_29_0=ruleDataDictionaryDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransformationRule());
            					}
            					add(
            						current,
            						"inputPort",
            						lv_inputPort_29_0,
            						"xtext.Library.DataDictionaryDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:894:3: (otherlv_30= ',' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==14) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalLibrary.g:895:4: otherlv_30= ',' ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) )
            	    {
            	    otherlv_30=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_30, grammarAccess.getTransformationAccess().getCommaKeyword_18_0());
            	    			
            	    // InternalLibrary.g:899:4: ( (lv_inputPort_31_0= ruleDataDictionaryDefinition ) )
            	    // InternalLibrary.g:900:5: (lv_inputPort_31_0= ruleDataDictionaryDefinition )
            	    {
            	    // InternalLibrary.g:900:5: (lv_inputPort_31_0= ruleDataDictionaryDefinition )
            	    // InternalLibrary.g:901:6: lv_inputPort_31_0= ruleDataDictionaryDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getTransformationAccess().getInputPortDataDictionaryDefinitionParserRuleCall_18_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_inputPort_31_0=ruleDataDictionaryDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTransformationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputPort",
            	    							lv_inputPort_31_0,
            	    							"xtext.Library.DataDictionaryDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_32=(Token)match(input,15,FOLLOW_20); 

            			newLeafNode(otherlv_32, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_19());
            		
            otherlv_33=(Token)match(input,25,FOLLOW_4); 

            			newLeafNode(otherlv_33, grammarAccess.getTransformationAccess().getOutputPortKeyword_20());
            		
            otherlv_34=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_34, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_21());
            		
            // InternalLibrary.g:931:3: ( (lv_outputPort_35_0= ruleDataDictionaryDefinition ) )
            // InternalLibrary.g:932:4: (lv_outputPort_35_0= ruleDataDictionaryDefinition )
            {
            // InternalLibrary.g:932:4: (lv_outputPort_35_0= ruleDataDictionaryDefinition )
            // InternalLibrary.g:933:5: lv_outputPort_35_0= ruleDataDictionaryDefinition
            {

            					newCompositeNode(grammarAccess.getTransformationAccess().getOutputPortDataDictionaryDefinitionParserRuleCall_22_0());
            				
            pushFollow(FOLLOW_7);
            lv_outputPort_35_0=ruleDataDictionaryDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransformationRule());
            					}
            					add(
            						current,
            						"outputPort",
            						lv_outputPort_35_0,
            						"xtext.Library.DataDictionaryDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:950:3: (otherlv_36= ',' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==14) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalLibrary.g:951:4: otherlv_36= ',' ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) )
            	    {
            	    otherlv_36=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_36, grammarAccess.getTransformationAccess().getCommaKeyword_23_0());
            	    			
            	    // InternalLibrary.g:955:4: ( (lv_outputPort_37_0= ruleDataDictionaryDefinition ) )
            	    // InternalLibrary.g:956:5: (lv_outputPort_37_0= ruleDataDictionaryDefinition )
            	    {
            	    // InternalLibrary.g:956:5: (lv_outputPort_37_0= ruleDataDictionaryDefinition )
            	    // InternalLibrary.g:957:6: lv_outputPort_37_0= ruleDataDictionaryDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getTransformationAccess().getOutputPortDataDictionaryDefinitionParserRuleCall_23_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_outputPort_37_0=ruleDataDictionaryDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTransformationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"outputPort",
            	    							lv_outputPort_37_0,
            	    							"xtext.Library.DataDictionaryDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_38=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_38, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_24());
            		
            otherlv_39=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_39, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_25());
            		

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


    // $ANTLR start "entryRuleParameterDefinition"
    // InternalLibrary.g:987:1: entryRuleParameterDefinition returns [EObject current=null] : iv_ruleParameterDefinition= ruleParameterDefinition EOF ;
    public final EObject entryRuleParameterDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDefinition = null;


        try {
            // InternalLibrary.g:987:60: (iv_ruleParameterDefinition= ruleParameterDefinition EOF )
            // InternalLibrary.g:988:2: iv_ruleParameterDefinition= ruleParameterDefinition EOF
            {
             newCompositeNode(grammarAccess.getParameterDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterDefinition=ruleParameterDefinition();

            state._fsp--;

             current =iv_ruleParameterDefinition; 
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
    // $ANTLR end "entryRuleParameterDefinition"


    // $ANTLR start "ruleParameterDefinition"
    // InternalLibrary.g:994:1: ruleParameterDefinition returns [EObject current=null] : (this_MapDef_0= ruleMapDef | this_CastTypeDef_1= ruleCastTypeDef | this_PrimitiveDef_2= rulePrimitiveDef | this_DerivedFieldDef_3= ruleDerivedFieldDef | this_FilterValueDef_4= ruleFilterValueDef | this_DiscretizeBinDef_5= ruleDiscretizeBinDef | this_FieldRangeDef_6= ruleFieldRangeDef | this_MathOpDef_7= ruleMathOpDef | this_JoinDef_8= ruleJoinDef | this_RangeDef_9= ruleRangeDef | this_MissingValuesDef_10= ruleMissingValuesDef | this_DateRangeDef_11= ruleDateRangeDef | this_DerivedValueDef_12= ruleDerivedValueDef | this_NumOpDef_13= ruleNumOpDef | this_FixValueDef_14= ruleFixValueDef | this_FieldDef_15= ruleFieldDef ) ;
    public final EObject ruleParameterDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_MapDef_0 = null;

        EObject this_CastTypeDef_1 = null;

        EObject this_PrimitiveDef_2 = null;

        EObject this_DerivedFieldDef_3 = null;

        EObject this_FilterValueDef_4 = null;

        EObject this_DiscretizeBinDef_5 = null;

        EObject this_FieldRangeDef_6 = null;

        EObject this_MathOpDef_7 = null;

        EObject this_JoinDef_8 = null;

        EObject this_RangeDef_9 = null;

        EObject this_MissingValuesDef_10 = null;

        EObject this_DateRangeDef_11 = null;

        EObject this_DerivedValueDef_12 = null;

        EObject this_NumOpDef_13 = null;

        EObject this_FixValueDef_14 = null;

        EObject this_FieldDef_15 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1000:2: ( (this_MapDef_0= ruleMapDef | this_CastTypeDef_1= ruleCastTypeDef | this_PrimitiveDef_2= rulePrimitiveDef | this_DerivedFieldDef_3= ruleDerivedFieldDef | this_FilterValueDef_4= ruleFilterValueDef | this_DiscretizeBinDef_5= ruleDiscretizeBinDef | this_FieldRangeDef_6= ruleFieldRangeDef | this_MathOpDef_7= ruleMathOpDef | this_JoinDef_8= ruleJoinDef | this_RangeDef_9= ruleRangeDef | this_MissingValuesDef_10= ruleMissingValuesDef | this_DateRangeDef_11= ruleDateRangeDef | this_DerivedValueDef_12= ruleDerivedValueDef | this_NumOpDef_13= ruleNumOpDef | this_FixValueDef_14= ruleFixValueDef | this_FieldDef_15= ruleFieldDef ) )
            // InternalLibrary.g:1001:2: (this_MapDef_0= ruleMapDef | this_CastTypeDef_1= ruleCastTypeDef | this_PrimitiveDef_2= rulePrimitiveDef | this_DerivedFieldDef_3= ruleDerivedFieldDef | this_FilterValueDef_4= ruleFilterValueDef | this_DiscretizeBinDef_5= ruleDiscretizeBinDef | this_FieldRangeDef_6= ruleFieldRangeDef | this_MathOpDef_7= ruleMathOpDef | this_JoinDef_8= ruleJoinDef | this_RangeDef_9= ruleRangeDef | this_MissingValuesDef_10= ruleMissingValuesDef | this_DateRangeDef_11= ruleDateRangeDef | this_DerivedValueDef_12= ruleDerivedValueDef | this_NumOpDef_13= ruleNumOpDef | this_FixValueDef_14= ruleFixValueDef | this_FieldDef_15= ruleFieldDef )
            {
            // InternalLibrary.g:1001:2: (this_MapDef_0= ruleMapDef | this_CastTypeDef_1= ruleCastTypeDef | this_PrimitiveDef_2= rulePrimitiveDef | this_DerivedFieldDef_3= ruleDerivedFieldDef | this_FilterValueDef_4= ruleFilterValueDef | this_DiscretizeBinDef_5= ruleDiscretizeBinDef | this_FieldRangeDef_6= ruleFieldRangeDef | this_MathOpDef_7= ruleMathOpDef | this_JoinDef_8= ruleJoinDef | this_RangeDef_9= ruleRangeDef | this_MissingValuesDef_10= ruleMissingValuesDef | this_DateRangeDef_11= ruleDateRangeDef | this_DerivedValueDef_12= ruleDerivedValueDef | this_NumOpDef_13= ruleNumOpDef | this_FixValueDef_14= ruleFixValueDef | this_FieldDef_15= ruleFieldDef )
            int alt20=16;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt20=1;
                }
                break;
            case 37:
                {
                alt20=2;
                }
                break;
            case 38:
                {
                alt20=3;
                }
                break;
            case 39:
                {
                alt20=4;
                }
                break;
            case 40:
                {
                alt20=5;
                }
                break;
            case 46:
                {
                alt20=6;
                }
                break;
            case 51:
                {
                alt20=7;
                }
                break;
            case 52:
                {
                alt20=8;
                }
                break;
            case 54:
                {
                alt20=9;
                }
                break;
            case 43:
                {
                alt20=10;
                }
                break;
            case 44:
                {
                alt20=11;
                }
                break;
            case 45:
                {
                alt20=12;
                }
                break;
            case 47:
                {
                alt20=13;
                }
                break;
            case 48:
                {
                alt20=14;
                }
                break;
            case 49:
                {
                alt20=15;
                }
                break;
            case 55:
                {
                alt20=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalLibrary.g:1002:3: this_MapDef_0= ruleMapDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getMapDefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MapDef_0=ruleMapDef();

                    state._fsp--;


                    			current = this_MapDef_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:1011:3: this_CastTypeDef_1= ruleCastTypeDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getCastTypeDefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CastTypeDef_1=ruleCastTypeDef();

                    state._fsp--;


                    			current = this_CastTypeDef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLibrary.g:1020:3: this_PrimitiveDef_2= rulePrimitiveDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getPrimitiveDefParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveDef_2=rulePrimitiveDef();

                    state._fsp--;


                    			current = this_PrimitiveDef_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalLibrary.g:1029:3: this_DerivedFieldDef_3= ruleDerivedFieldDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getDerivedFieldDefParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DerivedFieldDef_3=ruleDerivedFieldDef();

                    state._fsp--;


                    			current = this_DerivedFieldDef_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalLibrary.g:1038:3: this_FilterValueDef_4= ruleFilterValueDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getFilterValueDefParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FilterValueDef_4=ruleFilterValueDef();

                    state._fsp--;


                    			current = this_FilterValueDef_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalLibrary.g:1047:3: this_DiscretizeBinDef_5= ruleDiscretizeBinDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getDiscretizeBinDefParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_DiscretizeBinDef_5=ruleDiscretizeBinDef();

                    state._fsp--;


                    			current = this_DiscretizeBinDef_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalLibrary.g:1056:3: this_FieldRangeDef_6= ruleFieldRangeDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getFieldRangeDefParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldRangeDef_6=ruleFieldRangeDef();

                    state._fsp--;


                    			current = this_FieldRangeDef_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalLibrary.g:1065:3: this_MathOpDef_7= ruleMathOpDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getMathOpDefParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathOpDef_7=ruleMathOpDef();

                    state._fsp--;


                    			current = this_MathOpDef_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalLibrary.g:1074:3: this_JoinDef_8= ruleJoinDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getJoinDefParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_JoinDef_8=ruleJoinDef();

                    state._fsp--;


                    			current = this_JoinDef_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalLibrary.g:1083:3: this_RangeDef_9= ruleRangeDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getRangeDefParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_RangeDef_9=ruleRangeDef();

                    state._fsp--;


                    			current = this_RangeDef_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalLibrary.g:1092:3: this_MissingValuesDef_10= ruleMissingValuesDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getMissingValuesDefParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_MissingValuesDef_10=ruleMissingValuesDef();

                    state._fsp--;


                    			current = this_MissingValuesDef_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalLibrary.g:1101:3: this_DateRangeDef_11= ruleDateRangeDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getDateRangeDefParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateRangeDef_11=ruleDateRangeDef();

                    state._fsp--;


                    			current = this_DateRangeDef_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalLibrary.g:1110:3: this_DerivedValueDef_12= ruleDerivedValueDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getDerivedValueDefParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_DerivedValueDef_12=ruleDerivedValueDef();

                    state._fsp--;


                    			current = this_DerivedValueDef_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalLibrary.g:1119:3: this_NumOpDef_13= ruleNumOpDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getNumOpDefParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumOpDef_13=ruleNumOpDef();

                    state._fsp--;


                    			current = this_NumOpDef_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalLibrary.g:1128:3: this_FixValueDef_14= ruleFixValueDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getFixValueDefParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixValueDef_14=ruleFixValueDef();

                    state._fsp--;


                    			current = this_FixValueDef_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalLibrary.g:1137:3: this_FieldDef_15= ruleFieldDef
                    {

                    			newCompositeNode(grammarAccess.getParameterDefinitionAccess().getFieldDefParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldDef_15=ruleFieldDef();

                    state._fsp--;


                    			current = this_FieldDef_15;
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
    // $ANTLR end "ruleParameterDefinition"


    // $ANTLR start "entryRuleContractDefinition"
    // InternalLibrary.g:1149:1: entryRuleContractDefinition returns [EObject current=null] : iv_ruleContractDefinition= ruleContractDefinition EOF ;
    public final EObject entryRuleContractDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractDefinition = null;


        try {
            // InternalLibrary.g:1149:59: (iv_ruleContractDefinition= ruleContractDefinition EOF )
            // InternalLibrary.g:1150:2: iv_ruleContractDefinition= ruleContractDefinition EOF
            {
             newCompositeNode(grammarAccess.getContractDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractDefinition=ruleContractDefinition();

            state._fsp--;

             current =iv_ruleContractDefinition; 
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
    // $ANTLR end "entryRuleContractDefinition"


    // $ANTLR start "ruleContractDefinition"
    // InternalLibrary.g:1156:1: ruleContractDefinition returns [EObject current=null] : (otherlv_0= 'ContractDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= 'contractDefinition' ( (lv_contractDefinition_6_0= ruleContractDefinition0 ) ) otherlv_7= '}' ) ;
    public final EObject ruleContractDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_4_0 = null;

        EObject lv_contractDefinition_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1162:2: ( (otherlv_0= 'ContractDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= 'contractDefinition' ( (lv_contractDefinition_6_0= ruleContractDefinition0 ) ) otherlv_7= '}' ) )
            // InternalLibrary.g:1163:2: (otherlv_0= 'ContractDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= 'contractDefinition' ( (lv_contractDefinition_6_0= ruleContractDefinition0 ) ) otherlv_7= '}' )
            {
            // InternalLibrary.g:1163:2: (otherlv_0= 'ContractDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= 'contractDefinition' ( (lv_contractDefinition_6_0= ruleContractDefinition0 ) ) otherlv_7= '}' )
            // InternalLibrary.g:1164:3: otherlv_0= 'ContractDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= 'contractDefinition' ( (lv_contractDefinition_6_0= ruleContractDefinition0 ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContractDefinitionAccess().getContractDefinitionKeyword_0());
            		
            // InternalLibrary.g:1168:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1169:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1169:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1170:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getContractDefinitionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getContractDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1191:3: (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalLibrary.g:1192:4: otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getContractDefinitionAccess().getBoundToKeyword_3_0());
                    			
                    // InternalLibrary.g:1196:4: ( (lv_boundTo_4_0= ruleEString ) )
                    // InternalLibrary.g:1197:5: (lv_boundTo_4_0= ruleEString )
                    {
                    // InternalLibrary.g:1197:5: (lv_boundTo_4_0= ruleEString )
                    // InternalLibrary.g:1198:6: lv_boundTo_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getContractDefinitionAccess().getBoundToEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_boundTo_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_4_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_23); 

            			newLeafNode(otherlv_5, grammarAccess.getContractDefinitionAccess().getContractDefinitionKeyword_4());
            		
            // InternalLibrary.g:1220:3: ( (lv_contractDefinition_6_0= ruleContractDefinition0 ) )
            // InternalLibrary.g:1221:4: (lv_contractDefinition_6_0= ruleContractDefinition0 )
            {
            // InternalLibrary.g:1221:4: (lv_contractDefinition_6_0= ruleContractDefinition0 )
            // InternalLibrary.g:1222:5: lv_contractDefinition_6_0= ruleContractDefinition0
            {

            					newCompositeNode(grammarAccess.getContractDefinitionAccess().getContractDefinitionContractDefinition0ParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_8);
            lv_contractDefinition_6_0=ruleContractDefinition0();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
            					}
            					set(
            						current,
            						"contractDefinition",
            						lv_contractDefinition_6_0,
            						"xtext.Library.ContractDefinition0");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getContractDefinitionAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleContractDefinition"


    // $ANTLR start "entryRuleContractDefinition0"
    // InternalLibrary.g:1247:1: entryRuleContractDefinition0 returns [EObject current=null] : iv_ruleContractDefinition0= ruleContractDefinition0 EOF ;
    public final EObject entryRuleContractDefinition0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractDefinition0 = null;


        try {
            // InternalLibrary.g:1247:60: (iv_ruleContractDefinition0= ruleContractDefinition0 EOF )
            // InternalLibrary.g:1248:2: iv_ruleContractDefinition0= ruleContractDefinition0 EOF
            {
             newCompositeNode(grammarAccess.getContractDefinition0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractDefinition0=ruleContractDefinition0();

            state._fsp--;

             current =iv_ruleContractDefinition0; 
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
    // $ANTLR end "entryRuleContractDefinition0"


    // $ANTLR start "ruleContractDefinition0"
    // InternalLibrary.g:1254:1: ruleContractDefinition0 returns [EObject current=null] : (this_ConditionDef_0= ruleConditionDef | this_ValueRangeDefinition_1= ruleValueRangeDefinition | this_FieldRangeDefinition_2= ruleFieldRangeDefinition ) ;
    public final EObject ruleContractDefinition0() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionDef_0 = null;

        EObject this_ValueRangeDefinition_1 = null;

        EObject this_FieldRangeDefinition_2 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1260:2: ( (this_ConditionDef_0= ruleConditionDef | this_ValueRangeDefinition_1= ruleValueRangeDefinition | this_FieldRangeDefinition_2= ruleFieldRangeDefinition ) )
            // InternalLibrary.g:1261:2: (this_ConditionDef_0= ruleConditionDef | this_ValueRangeDefinition_1= ruleValueRangeDefinition | this_FieldRangeDefinition_2= ruleFieldRangeDefinition )
            {
            // InternalLibrary.g:1261:2: (this_ConditionDef_0= ruleConditionDef | this_ValueRangeDefinition_1= ruleValueRangeDefinition | this_FieldRangeDefinition_2= ruleFieldRangeDefinition )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt22=1;
                }
                break;
            case 59:
                {
                alt22=2;
                }
                break;
            case 60:
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
                    // InternalLibrary.g:1262:3: this_ConditionDef_0= ruleConditionDef
                    {

                    			newCompositeNode(grammarAccess.getContractDefinition0Access().getConditionDefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConditionDef_0=ruleConditionDef();

                    state._fsp--;


                    			current = this_ConditionDef_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:1271:3: this_ValueRangeDefinition_1= ruleValueRangeDefinition
                    {

                    			newCompositeNode(grammarAccess.getContractDefinition0Access().getValueRangeDefinitionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValueRangeDefinition_1=ruleValueRangeDefinition();

                    state._fsp--;


                    			current = this_ValueRangeDefinition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLibrary.g:1280:3: this_FieldRangeDefinition_2= ruleFieldRangeDefinition
                    {

                    			newCompositeNode(grammarAccess.getContractDefinition0Access().getFieldRangeDefinitionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldRangeDefinition_2=ruleFieldRangeDefinition();

                    state._fsp--;


                    			current = this_FieldRangeDefinition_2;
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
    // $ANTLR end "ruleContractDefinition0"


    // $ANTLR start "entryRuleDataDictionaryDefinition"
    // InternalLibrary.g:1292:1: entryRuleDataDictionaryDefinition returns [EObject current=null] : iv_ruleDataDictionaryDefinition= ruleDataDictionaryDefinition EOF ;
    public final EObject entryRuleDataDictionaryDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDictionaryDefinition = null;


        try {
            // InternalLibrary.g:1292:65: (iv_ruleDataDictionaryDefinition= ruleDataDictionaryDefinition EOF )
            // InternalLibrary.g:1293:2: iv_ruleDataDictionaryDefinition= ruleDataDictionaryDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataDictionaryDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataDictionaryDefinition=ruleDataDictionaryDefinition();

            state._fsp--;

             current =iv_ruleDataDictionaryDefinition; 
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
    // $ANTLR end "entryRuleDataDictionaryDefinition"


    // $ANTLR start "ruleDataDictionaryDefinition"
    // InternalLibrary.g:1299:1: ruleDataDictionaryDefinition returns [EObject current=null] : (otherlv_0= 'DataDictionaryDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? (otherlv_5= 'datafielddefinition' otherlv_6= '{' ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) ) (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )* otherlv_10= '}' )? otherlv_11= '}' ) ;
    public final EObject ruleDataDictionaryDefinition() throws RecognitionException {
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

        AntlrDatatypeRuleToken lv_boundTo_4_0 = null;

        EObject lv_datafielddefinition_7_0 = null;

        EObject lv_datafielddefinition_9_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1305:2: ( (otherlv_0= 'DataDictionaryDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? (otherlv_5= 'datafielddefinition' otherlv_6= '{' ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) ) (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )* otherlv_10= '}' )? otherlv_11= '}' ) )
            // InternalLibrary.g:1306:2: (otherlv_0= 'DataDictionaryDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? (otherlv_5= 'datafielddefinition' otherlv_6= '{' ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) ) (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )* otherlv_10= '}' )? otherlv_11= '}' )
            {
            // InternalLibrary.g:1306:2: (otherlv_0= 'DataDictionaryDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? (otherlv_5= 'datafielddefinition' otherlv_6= '{' ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) ) (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )* otherlv_10= '}' )? otherlv_11= '}' )
            // InternalLibrary.g:1307:3: otherlv_0= 'DataDictionaryDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? (otherlv_5= 'datafielddefinition' otherlv_6= '{' ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) ) (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )* otherlv_10= '}' )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDataDictionaryDefinitionAccess().getDataDictionaryDefinitionKeyword_0());
            		
            // InternalLibrary.g:1311:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1312:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1312:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1313:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataDictionaryDefinitionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataDictionaryDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getDataDictionaryDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1334:3: (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalLibrary.g:1335:4: otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataDictionaryDefinitionAccess().getBoundToKeyword_3_0());
                    			
                    // InternalLibrary.g:1339:4: ( (lv_boundTo_4_0= ruleEString ) )
                    // InternalLibrary.g:1340:5: (lv_boundTo_4_0= ruleEString )
                    {
                    // InternalLibrary.g:1340:5: (lv_boundTo_4_0= ruleEString )
                    // InternalLibrary.g:1341:6: lv_boundTo_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDataDictionaryDefinitionAccess().getBoundToEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_boundTo_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataDictionaryDefinitionRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_4_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:1359:3: (otherlv_5= 'datafielddefinition' otherlv_6= '{' ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) ) (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )* otherlv_10= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==31) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalLibrary.g:1360:4: otherlv_5= 'datafielddefinition' otherlv_6= '{' ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) ) (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )* otherlv_10= '}'
                    {
                    otherlv_5=(Token)match(input,31,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getDataDictionaryDefinitionAccess().getDatafielddefinitionKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,12,FOLLOW_26); 

                    				newLeafNode(otherlv_6, grammarAccess.getDataDictionaryDefinitionAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalLibrary.g:1368:4: ( (lv_datafielddefinition_7_0= ruleDataFieldDefinition ) )
                    // InternalLibrary.g:1369:5: (lv_datafielddefinition_7_0= ruleDataFieldDefinition )
                    {
                    // InternalLibrary.g:1369:5: (lv_datafielddefinition_7_0= ruleDataFieldDefinition )
                    // InternalLibrary.g:1370:6: lv_datafielddefinition_7_0= ruleDataFieldDefinition
                    {

                    						newCompositeNode(grammarAccess.getDataDictionaryDefinitionAccess().getDatafielddefinitionDataFieldDefinitionParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_datafielddefinition_7_0=ruleDataFieldDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataDictionaryDefinitionRule());
                    						}
                    						add(
                    							current,
                    							"datafielddefinition",
                    							lv_datafielddefinition_7_0,
                    							"xtext.Library.DataFieldDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:1387:4: (otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==14) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalLibrary.g:1388:5: otherlv_8= ',' ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) )
                    	    {
                    	    otherlv_8=(Token)match(input,14,FOLLOW_26); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getDataDictionaryDefinitionAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalLibrary.g:1392:5: ( (lv_datafielddefinition_9_0= ruleDataFieldDefinition ) )
                    	    // InternalLibrary.g:1393:6: (lv_datafielddefinition_9_0= ruleDataFieldDefinition )
                    	    {
                    	    // InternalLibrary.g:1393:6: (lv_datafielddefinition_9_0= ruleDataFieldDefinition )
                    	    // InternalLibrary.g:1394:7: lv_datafielddefinition_9_0= ruleDataFieldDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getDataDictionaryDefinitionAccess().getDatafielddefinitionDataFieldDefinitionParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_datafielddefinition_9_0=ruleDataFieldDefinition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDataDictionaryDefinitionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"datafielddefinition",
                    	    								lv_datafielddefinition_9_0,
                    	    								"xtext.Library.DataFieldDefinition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getDataDictionaryDefinitionAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            otherlv_11=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDataDictionaryDefinitionAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleDataDictionaryDefinition"


    // $ANTLR start "entryRuleDataFieldDefinition"
    // InternalLibrary.g:1425:1: entryRuleDataFieldDefinition returns [EObject current=null] : iv_ruleDataFieldDefinition= ruleDataFieldDefinition EOF ;
    public final EObject entryRuleDataFieldDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataFieldDefinition = null;


        try {
            // InternalLibrary.g:1425:60: (iv_ruleDataFieldDefinition= ruleDataFieldDefinition EOF )
            // InternalLibrary.g:1426:2: iv_ruleDataFieldDefinition= ruleDataFieldDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataFieldDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataFieldDefinition=ruleDataFieldDefinition();

            state._fsp--;

             current =iv_ruleDataFieldDefinition; 
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
    // $ANTLR end "entryRuleDataFieldDefinition"


    // $ANTLR start "ruleDataFieldDefinition"
    // InternalLibrary.g:1432:1: ruleDataFieldDefinition returns [EObject current=null] : (this_CategoricalDef_0= ruleCategoricalDef | this_ContinuousDef_1= ruleContinuousDef | this_DateDef_2= ruleDateDef ) ;
    public final EObject ruleDataFieldDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_CategoricalDef_0 = null;

        EObject this_ContinuousDef_1 = null;

        EObject this_DateDef_2 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1438:2: ( (this_CategoricalDef_0= ruleCategoricalDef | this_ContinuousDef_1= ruleContinuousDef | this_DateDef_2= ruleDateDef ) )
            // InternalLibrary.g:1439:2: (this_CategoricalDef_0= ruleCategoricalDef | this_ContinuousDef_1= ruleContinuousDef | this_DateDef_2= ruleDateDef )
            {
            // InternalLibrary.g:1439:2: (this_CategoricalDef_0= ruleCategoricalDef | this_ContinuousDef_1= ruleContinuousDef | this_DateDef_2= ruleDateDef )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt26=1;
                }
                break;
            case 33:
                {
                alt26=2;
                }
                break;
            case 34:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalLibrary.g:1440:3: this_CategoricalDef_0= ruleCategoricalDef
                    {

                    			newCompositeNode(grammarAccess.getDataFieldDefinitionAccess().getCategoricalDefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CategoricalDef_0=ruleCategoricalDef();

                    state._fsp--;


                    			current = this_CategoricalDef_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:1449:3: this_ContinuousDef_1= ruleContinuousDef
                    {

                    			newCompositeNode(grammarAccess.getDataFieldDefinitionAccess().getContinuousDefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContinuousDef_1=ruleContinuousDef();

                    state._fsp--;


                    			current = this_ContinuousDef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLibrary.g:1458:3: this_DateDef_2= ruleDateDef
                    {

                    			newCompositeNode(grammarAccess.getDataFieldDefinitionAccess().getDateDefParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateDef_2=ruleDateDef();

                    state._fsp--;


                    			current = this_DateDef_2;
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
    // $ANTLR end "ruleDataFieldDefinition"


    // $ANTLR start "entryRuleCategoricalDef"
    // InternalLibrary.g:1470:1: entryRuleCategoricalDef returns [EObject current=null] : iv_ruleCategoricalDef= ruleCategoricalDef EOF ;
    public final EObject entryRuleCategoricalDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoricalDef = null;


        try {
            // InternalLibrary.g:1470:55: (iv_ruleCategoricalDef= ruleCategoricalDef EOF )
            // InternalLibrary.g:1471:2: iv_ruleCategoricalDef= ruleCategoricalDef EOF
            {
             newCompositeNode(grammarAccess.getCategoricalDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategoricalDef=ruleCategoricalDef();

            state._fsp--;

             current =iv_ruleCategoricalDef; 
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
    // $ANTLR end "entryRuleCategoricalDef"


    // $ANTLR start "ruleCategoricalDef"
    // InternalLibrary.g:1477:1: ruleCategoricalDef returns [EObject current=null] : (otherlv_0= 'CategoricalDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleCategoricalDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_4_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1483:2: ( (otherlv_0= 'CategoricalDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' ) )
            // InternalLibrary.g:1484:2: (otherlv_0= 'CategoricalDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' )
            {
            // InternalLibrary.g:1484:2: (otherlv_0= 'CategoricalDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' )
            // InternalLibrary.g:1485:3: otherlv_0= 'CategoricalDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCategoricalDefAccess().getCategoricalDefKeyword_0());
            		
            // InternalLibrary.g:1489:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1490:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1490:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1491:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCategoricalDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCategoricalDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getCategoricalDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1512:3: (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==28) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalLibrary.g:1513:4: otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getCategoricalDefAccess().getBoundToKeyword_3_0());
                    			
                    // InternalLibrary.g:1517:4: ( (lv_boundTo_4_0= ruleEString ) )
                    // InternalLibrary.g:1518:5: (lv_boundTo_4_0= ruleEString )
                    {
                    // InternalLibrary.g:1518:5: (lv_boundTo_4_0= ruleEString )
                    // InternalLibrary.g:1519:6: lv_boundTo_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCategoricalDefAccess().getBoundToEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoricalDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_4_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCategoricalDefAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleCategoricalDef"


    // $ANTLR start "entryRuleContinuousDef"
    // InternalLibrary.g:1545:1: entryRuleContinuousDef returns [EObject current=null] : iv_ruleContinuousDef= ruleContinuousDef EOF ;
    public final EObject entryRuleContinuousDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuousDef = null;


        try {
            // InternalLibrary.g:1545:54: (iv_ruleContinuousDef= ruleContinuousDef EOF )
            // InternalLibrary.g:1546:2: iv_ruleContinuousDef= ruleContinuousDef EOF
            {
             newCompositeNode(grammarAccess.getContinuousDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContinuousDef=ruleContinuousDef();

            state._fsp--;

             current =iv_ruleContinuousDef; 
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
    // $ANTLR end "entryRuleContinuousDef"


    // $ANTLR start "ruleContinuousDef"
    // InternalLibrary.g:1552:1: ruleContinuousDef returns [EObject current=null] : (otherlv_0= 'ContinuousDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleContinuousDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_4_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1558:2: ( (otherlv_0= 'ContinuousDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' ) )
            // InternalLibrary.g:1559:2: (otherlv_0= 'ContinuousDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' )
            {
            // InternalLibrary.g:1559:2: (otherlv_0= 'ContinuousDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' )
            // InternalLibrary.g:1560:3: otherlv_0= 'ContinuousDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContinuousDefAccess().getContinuousDefKeyword_0());
            		
            // InternalLibrary.g:1564:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1565:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1565:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1566:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getContinuousDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContinuousDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getContinuousDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1587:3: (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==28) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalLibrary.g:1588:4: otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getContinuousDefAccess().getBoundToKeyword_3_0());
                    			
                    // InternalLibrary.g:1592:4: ( (lv_boundTo_4_0= ruleEString ) )
                    // InternalLibrary.g:1593:5: (lv_boundTo_4_0= ruleEString )
                    {
                    // InternalLibrary.g:1593:5: (lv_boundTo_4_0= ruleEString )
                    // InternalLibrary.g:1594:6: lv_boundTo_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getContinuousDefAccess().getBoundToEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContinuousDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_4_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getContinuousDefAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleContinuousDef"


    // $ANTLR start "entryRuleDateDef"
    // InternalLibrary.g:1620:1: entryRuleDateDef returns [EObject current=null] : iv_ruleDateDef= ruleDateDef EOF ;
    public final EObject entryRuleDateDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateDef = null;


        try {
            // InternalLibrary.g:1620:48: (iv_ruleDateDef= ruleDateDef EOF )
            // InternalLibrary.g:1621:2: iv_ruleDateDef= ruleDateDef EOF
            {
             newCompositeNode(grammarAccess.getDateDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateDef=ruleDateDef();

            state._fsp--;

             current =iv_ruleDateDef; 
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
    // $ANTLR end "entryRuleDateDef"


    // $ANTLR start "ruleDateDef"
    // InternalLibrary.g:1627:1: ruleDateDef returns [EObject current=null] : (otherlv_0= 'DateDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleDateDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_4_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1633:2: ( (otherlv_0= 'DateDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' ) )
            // InternalLibrary.g:1634:2: (otherlv_0= 'DateDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' )
            {
            // InternalLibrary.g:1634:2: (otherlv_0= 'DateDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}' )
            // InternalLibrary.g:1635:3: otherlv_0= 'DateDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDateDefAccess().getDateDefKeyword_0());
            		
            // InternalLibrary.g:1639:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1640:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1640:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1641:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDateDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getDateDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1662:3: (otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==28) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalLibrary.g:1663:4: otherlv_3= 'boundTo' ( (lv_boundTo_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getDateDefAccess().getBoundToKeyword_3_0());
                    			
                    // InternalLibrary.g:1667:4: ( (lv_boundTo_4_0= ruleEString ) )
                    // InternalLibrary.g:1668:5: (lv_boundTo_4_0= ruleEString )
                    {
                    // InternalLibrary.g:1668:5: (lv_boundTo_4_0= ruleEString )
                    // InternalLibrary.g:1669:6: lv_boundTo_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDateDefAccess().getBoundToEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_4_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDateDefAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleDateDef"


    // $ANTLR start "entryRuleMapDef"
    // InternalLibrary.g:1695:1: entryRuleMapDef returns [EObject current=null] : iv_ruleMapDef= ruleMapDef EOF ;
    public final EObject entryRuleMapDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapDef = null;


        try {
            // InternalLibrary.g:1695:47: (iv_ruleMapDef= ruleMapDef EOF )
            // InternalLibrary.g:1696:2: iv_ruleMapDef= ruleMapDef EOF
            {
             newCompositeNode(grammarAccess.getMapDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapDef=ruleMapDef();

            state._fsp--;

             current =iv_ruleMapDef; 
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
    // $ANTLR end "entryRuleMapDef"


    // $ANTLR start "ruleMapDef"
    // InternalLibrary.g:1702:1: ruleMapDef returns [EObject current=null] : (otherlv_0= 'MapDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleMapDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1708:2: ( (otherlv_0= 'MapDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:1709:2: (otherlv_0= 'MapDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:1709:2: (otherlv_0= 'MapDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:1710:3: otherlv_0= 'MapDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMapDefAccess().getMapDefKeyword_0());
            		
            // InternalLibrary.g:1714:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1715:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1715:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1716:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMapDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getMapDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1737:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalLibrary.g:1738:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getMapDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:1742:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:1743:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:1743:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:1744:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getMapDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMapDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:1762:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==28) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalLibrary.g:1763:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getMapDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:1767:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:1768:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:1768:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:1769:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMapDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMapDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMapDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleMapDef"


    // $ANTLR start "entryRuleCastTypeDef"
    // InternalLibrary.g:1795:1: entryRuleCastTypeDef returns [EObject current=null] : iv_ruleCastTypeDef= ruleCastTypeDef EOF ;
    public final EObject entryRuleCastTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastTypeDef = null;


        try {
            // InternalLibrary.g:1795:52: (iv_ruleCastTypeDef= ruleCastTypeDef EOF )
            // InternalLibrary.g:1796:2: iv_ruleCastTypeDef= ruleCastTypeDef EOF
            {
             newCompositeNode(grammarAccess.getCastTypeDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCastTypeDef=ruleCastTypeDef();

            state._fsp--;

             current =iv_ruleCastTypeDef; 
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
    // $ANTLR end "entryRuleCastTypeDef"


    // $ANTLR start "ruleCastTypeDef"
    // InternalLibrary.g:1802:1: ruleCastTypeDef returns [EObject current=null] : (otherlv_0= 'CastTypeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleCastTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1808:2: ( (otherlv_0= 'CastTypeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:1809:2: (otherlv_0= 'CastTypeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:1809:2: (otherlv_0= 'CastTypeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:1810:3: otherlv_0= 'CastTypeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCastTypeDefAccess().getCastTypeDefKeyword_0());
            		
            // InternalLibrary.g:1814:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1815:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1815:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1816:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCastTypeDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCastTypeDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getCastTypeDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1837:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==36) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalLibrary.g:1838:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getCastTypeDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:1842:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:1843:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:1843:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:1844:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getCastTypeDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCastTypeDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:1862:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==28) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalLibrary.g:1863:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getCastTypeDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:1867:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:1868:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:1868:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:1869:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCastTypeDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCastTypeDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getCastTypeDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleCastTypeDef"


    // $ANTLR start "entryRulePrimitiveDef"
    // InternalLibrary.g:1895:1: entryRulePrimitiveDef returns [EObject current=null] : iv_rulePrimitiveDef= rulePrimitiveDef EOF ;
    public final EObject entryRulePrimitiveDef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveDef = null;


        try {
            // InternalLibrary.g:1895:53: (iv_rulePrimitiveDef= rulePrimitiveDef EOF )
            // InternalLibrary.g:1896:2: iv_rulePrimitiveDef= rulePrimitiveDef EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveDefRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveDef=rulePrimitiveDef();

            state._fsp--;

             current =iv_rulePrimitiveDef; 
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
    // $ANTLR end "entryRulePrimitiveDef"


    // $ANTLR start "rulePrimitiveDef"
    // InternalLibrary.g:1902:1: rulePrimitiveDef returns [EObject current=null] : (otherlv_0= 'PrimitiveDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject rulePrimitiveDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:1908:2: ( (otherlv_0= 'PrimitiveDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:1909:2: (otherlv_0= 'PrimitiveDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:1909:2: (otherlv_0= 'PrimitiveDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:1910:3: otherlv_0= 'PrimitiveDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveDefAccess().getPrimitiveDefKeyword_0());
            		
            // InternalLibrary.g:1914:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:1915:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:1915:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:1916:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPrimitiveDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimitiveDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getPrimitiveDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:1937:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==36) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalLibrary.g:1938:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimitiveDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:1942:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:1943:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:1943:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:1944:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getPrimitiveDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimitiveDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:1962:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==28) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalLibrary.g:1963:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimitiveDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:1967:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:1968:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:1968:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:1969:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPrimitiveDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimitiveDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getPrimitiveDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "rulePrimitiveDef"


    // $ANTLR start "entryRuleDerivedFieldDef"
    // InternalLibrary.g:1995:1: entryRuleDerivedFieldDef returns [EObject current=null] : iv_ruleDerivedFieldDef= ruleDerivedFieldDef EOF ;
    public final EObject entryRuleDerivedFieldDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedFieldDef = null;


        try {
            // InternalLibrary.g:1995:56: (iv_ruleDerivedFieldDef= ruleDerivedFieldDef EOF )
            // InternalLibrary.g:1996:2: iv_ruleDerivedFieldDef= ruleDerivedFieldDef EOF
            {
             newCompositeNode(grammarAccess.getDerivedFieldDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDerivedFieldDef=ruleDerivedFieldDef();

            state._fsp--;

             current =iv_ruleDerivedFieldDef; 
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
    // $ANTLR end "entryRuleDerivedFieldDef"


    // $ANTLR start "ruleDerivedFieldDef"
    // InternalLibrary.g:2002:1: ruleDerivedFieldDef returns [EObject current=null] : (otherlv_0= 'DerivedFieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleDerivedFieldDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2008:2: ( (otherlv_0= 'DerivedFieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:2009:2: (otherlv_0= 'DerivedFieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:2009:2: (otherlv_0= 'DerivedFieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:2010:3: otherlv_0= 'DerivedFieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDerivedFieldDefAccess().getDerivedFieldDefKeyword_0());
            		
            // InternalLibrary.g:2014:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2015:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2015:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2016:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDerivedFieldDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedFieldDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getDerivedFieldDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2037:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==36) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalLibrary.g:2038:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getDerivedFieldDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2042:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2043:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2043:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2044:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getDerivedFieldDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDerivedFieldDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2062:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==28) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalLibrary.g:2063:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getDerivedFieldDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2067:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2068:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2068:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2069:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDerivedFieldDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDerivedFieldDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDerivedFieldDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleDerivedFieldDef"


    // $ANTLR start "entryRuleFilterValueDef"
    // InternalLibrary.g:2095:1: entryRuleFilterValueDef returns [EObject current=null] : iv_ruleFilterValueDef= ruleFilterValueDef EOF ;
    public final EObject entryRuleFilterValueDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterValueDef = null;


        try {
            // InternalLibrary.g:2095:55: (iv_ruleFilterValueDef= ruleFilterValueDef EOF )
            // InternalLibrary.g:2096:2: iv_ruleFilterValueDef= ruleFilterValueDef EOF
            {
             newCompositeNode(grammarAccess.getFilterValueDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilterValueDef=ruleFilterValueDef();

            state._fsp--;

             current =iv_ruleFilterValueDef; 
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
    // $ANTLR end "entryRuleFilterValueDef"


    // $ANTLR start "ruleFilterValueDef"
    // InternalLibrary.g:2102:1: ruleFilterValueDef returns [EObject current=null] : (otherlv_0= 'FilterValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? (otherlv_7= 'matchingvaluedef' otherlv_8= '{' ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) ) (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )* otherlv_12= '}' )? (otherlv_13= 'primitivedef' otherlv_14= '{' ( (lv_primitivedef_15_0= rulePrimitiveDef ) ) (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )* otherlv_18= '}' )? otherlv_19= '}' ) ;
    public final EObject ruleFilterValueDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;

        EObject lv_matchingvaluedef_9_0 = null;

        EObject lv_matchingvaluedef_11_0 = null;

        EObject lv_primitivedef_15_0 = null;

        EObject lv_primitivedef_17_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2108:2: ( (otherlv_0= 'FilterValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? (otherlv_7= 'matchingvaluedef' otherlv_8= '{' ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) ) (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )* otherlv_12= '}' )? (otherlv_13= 'primitivedef' otherlv_14= '{' ( (lv_primitivedef_15_0= rulePrimitiveDef ) ) (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )* otherlv_18= '}' )? otherlv_19= '}' ) )
            // InternalLibrary.g:2109:2: (otherlv_0= 'FilterValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? (otherlv_7= 'matchingvaluedef' otherlv_8= '{' ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) ) (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )* otherlv_12= '}' )? (otherlv_13= 'primitivedef' otherlv_14= '{' ( (lv_primitivedef_15_0= rulePrimitiveDef ) ) (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )* otherlv_18= '}' )? otherlv_19= '}' )
            {
            // InternalLibrary.g:2109:2: (otherlv_0= 'FilterValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? (otherlv_7= 'matchingvaluedef' otherlv_8= '{' ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) ) (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )* otherlv_12= '}' )? (otherlv_13= 'primitivedef' otherlv_14= '{' ( (lv_primitivedef_15_0= rulePrimitiveDef ) ) (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )* otherlv_18= '}' )? otherlv_19= '}' )
            // InternalLibrary.g:2110:3: otherlv_0= 'FilterValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? (otherlv_7= 'matchingvaluedef' otherlv_8= '{' ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) ) (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )* otherlv_12= '}' )? (otherlv_13= 'primitivedef' otherlv_14= '{' ( (lv_primitivedef_15_0= rulePrimitiveDef ) ) (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )* otherlv_18= '}' )? otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFilterValueDefAccess().getFilterValueDefKeyword_0());
            		
            // InternalLibrary.g:2114:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2115:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2115:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2116:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFilterValueDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterValueDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getFilterValueDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2137:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==36) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalLibrary.g:2138:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getFilterValueDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2142:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2143:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2143:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2144:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getFilterValueDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2162:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==28) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalLibrary.g:2163:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getFilterValueDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2167:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2168:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2168:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2169:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getFilterValueDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2187:3: (otherlv_7= 'matchingvaluedef' otherlv_8= '{' ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) ) (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )* otherlv_12= '}' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==41) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalLibrary.g:2188:4: otherlv_7= 'matchingvaluedef' otherlv_8= '{' ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) ) (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )* otherlv_12= '}'
                    {
                    otherlv_7=(Token)match(input,41,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getFilterValueDefAccess().getMatchingvaluedefKeyword_5_0());
                    			
                    otherlv_8=(Token)match(input,12,FOLLOW_33); 

                    				newLeafNode(otherlv_8, grammarAccess.getFilterValueDefAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalLibrary.g:2196:4: ( (lv_matchingvaluedef_9_0= ruleMatchingValueDef ) )
                    // InternalLibrary.g:2197:5: (lv_matchingvaluedef_9_0= ruleMatchingValueDef )
                    {
                    // InternalLibrary.g:2197:5: (lv_matchingvaluedef_9_0= ruleMatchingValueDef )
                    // InternalLibrary.g:2198:6: lv_matchingvaluedef_9_0= ruleMatchingValueDef
                    {

                    						newCompositeNode(grammarAccess.getFilterValueDefAccess().getMatchingvaluedefMatchingValueDefParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_matchingvaluedef_9_0=ruleMatchingValueDef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueDefRule());
                    						}
                    						add(
                    							current,
                    							"matchingvaluedef",
                    							lv_matchingvaluedef_9_0,
                    							"xtext.Library.MatchingValueDef");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:2215:4: (otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==14) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalLibrary.g:2216:5: otherlv_10= ',' ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_33); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getFilterValueDefAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalLibrary.g:2220:5: ( (lv_matchingvaluedef_11_0= ruleMatchingValueDef ) )
                    	    // InternalLibrary.g:2221:6: (lv_matchingvaluedef_11_0= ruleMatchingValueDef )
                    	    {
                    	    // InternalLibrary.g:2221:6: (lv_matchingvaluedef_11_0= ruleMatchingValueDef )
                    	    // InternalLibrary.g:2222:7: lv_matchingvaluedef_11_0= ruleMatchingValueDef
                    	    {

                    	    							newCompositeNode(grammarAccess.getFilterValueDefAccess().getMatchingvaluedefMatchingValueDefParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_matchingvaluedef_11_0=ruleMatchingValueDef();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFilterValueDefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"matchingvaluedef",
                    	    								lv_matchingvaluedef_11_0,
                    	    								"xtext.Library.MatchingValueDef");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,15,FOLLOW_34); 

                    				newLeafNode(otherlv_12, grammarAccess.getFilterValueDefAccess().getRightCurlyBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalLibrary.g:2245:3: (otherlv_13= 'primitivedef' otherlv_14= '{' ( (lv_primitivedef_15_0= rulePrimitiveDef ) ) (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )* otherlv_18= '}' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==42) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalLibrary.g:2246:4: otherlv_13= 'primitivedef' otherlv_14= '{' ( (lv_primitivedef_15_0= rulePrimitiveDef ) ) (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )* otherlv_18= '}'
                    {
                    otherlv_13=(Token)match(input,42,FOLLOW_4); 

                    				newLeafNode(otherlv_13, grammarAccess.getFilterValueDefAccess().getPrimitivedefKeyword_6_0());
                    			
                    otherlv_14=(Token)match(input,12,FOLLOW_35); 

                    				newLeafNode(otherlv_14, grammarAccess.getFilterValueDefAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalLibrary.g:2254:4: ( (lv_primitivedef_15_0= rulePrimitiveDef ) )
                    // InternalLibrary.g:2255:5: (lv_primitivedef_15_0= rulePrimitiveDef )
                    {
                    // InternalLibrary.g:2255:5: (lv_primitivedef_15_0= rulePrimitiveDef )
                    // InternalLibrary.g:2256:6: lv_primitivedef_15_0= rulePrimitiveDef
                    {

                    						newCompositeNode(grammarAccess.getFilterValueDefAccess().getPrimitivedefPrimitiveDefParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_primitivedef_15_0=rulePrimitiveDef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueDefRule());
                    						}
                    						add(
                    							current,
                    							"primitivedef",
                    							lv_primitivedef_15_0,
                    							"xtext.Library.PrimitiveDef");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLibrary.g:2273:4: (otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==14) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalLibrary.g:2274:5: otherlv_16= ',' ( (lv_primitivedef_17_0= rulePrimitiveDef ) )
                    	    {
                    	    otherlv_16=(Token)match(input,14,FOLLOW_35); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getFilterValueDefAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalLibrary.g:2278:5: ( (lv_primitivedef_17_0= rulePrimitiveDef ) )
                    	    // InternalLibrary.g:2279:6: (lv_primitivedef_17_0= rulePrimitiveDef )
                    	    {
                    	    // InternalLibrary.g:2279:6: (lv_primitivedef_17_0= rulePrimitiveDef )
                    	    // InternalLibrary.g:2280:7: lv_primitivedef_17_0= rulePrimitiveDef
                    	    {

                    	    							newCompositeNode(grammarAccess.getFilterValueDefAccess().getPrimitivedefPrimitiveDefParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_primitivedef_17_0=rulePrimitiveDef();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFilterValueDefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"primitivedef",
                    	    								lv_primitivedef_17_0,
                    	    								"xtext.Library.PrimitiveDef");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_18, grammarAccess.getFilterValueDefAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_19=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getFilterValueDefAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleFilterValueDef"


    // $ANTLR start "entryRuleMatchingValueDef"
    // InternalLibrary.g:2311:1: entryRuleMatchingValueDef returns [EObject current=null] : iv_ruleMatchingValueDef= ruleMatchingValueDef EOF ;
    public final EObject entryRuleMatchingValueDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatchingValueDef = null;


        try {
            // InternalLibrary.g:2311:57: (iv_ruleMatchingValueDef= ruleMatchingValueDef EOF )
            // InternalLibrary.g:2312:2: iv_ruleMatchingValueDef= ruleMatchingValueDef EOF
            {
             newCompositeNode(grammarAccess.getMatchingValueDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMatchingValueDef=ruleMatchingValueDef();

            state._fsp--;

             current =iv_ruleMatchingValueDef; 
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
    // $ANTLR end "entryRuleMatchingValueDef"


    // $ANTLR start "ruleMatchingValueDef"
    // InternalLibrary.g:2318:1: ruleMatchingValueDef returns [EObject current=null] : (this_RangeDef_0= ruleRangeDef | this_MissingValuesDef_1= ruleMissingValuesDef | this_DateRangeDef_2= ruleDateRangeDef ) ;
    public final EObject ruleMatchingValueDef() throws RecognitionException {
        EObject current = null;

        EObject this_RangeDef_0 = null;

        EObject this_MissingValuesDef_1 = null;

        EObject this_DateRangeDef_2 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2324:2: ( (this_RangeDef_0= ruleRangeDef | this_MissingValuesDef_1= ruleMissingValuesDef | this_DateRangeDef_2= ruleDateRangeDef ) )
            // InternalLibrary.g:2325:2: (this_RangeDef_0= ruleRangeDef | this_MissingValuesDef_1= ruleMissingValuesDef | this_DateRangeDef_2= ruleDateRangeDef )
            {
            // InternalLibrary.g:2325:2: (this_RangeDef_0= ruleRangeDef | this_MissingValuesDef_1= ruleMissingValuesDef | this_DateRangeDef_2= ruleDateRangeDef )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt44=1;
                }
                break;
            case 44:
                {
                alt44=2;
                }
                break;
            case 45:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalLibrary.g:2326:3: this_RangeDef_0= ruleRangeDef
                    {

                    			newCompositeNode(grammarAccess.getMatchingValueDefAccess().getRangeDefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RangeDef_0=ruleRangeDef();

                    state._fsp--;


                    			current = this_RangeDef_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:2335:3: this_MissingValuesDef_1= ruleMissingValuesDef
                    {

                    			newCompositeNode(grammarAccess.getMatchingValueDefAccess().getMissingValuesDefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MissingValuesDef_1=ruleMissingValuesDef();

                    state._fsp--;


                    			current = this_MissingValuesDef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLibrary.g:2344:3: this_DateRangeDef_2= ruleDateRangeDef
                    {

                    			newCompositeNode(grammarAccess.getMatchingValueDefAccess().getDateRangeDefParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateRangeDef_2=ruleDateRangeDef();

                    state._fsp--;


                    			current = this_DateRangeDef_2;
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
    // $ANTLR end "ruleMatchingValueDef"


    // $ANTLR start "entryRuleRangeDef"
    // InternalLibrary.g:2356:1: entryRuleRangeDef returns [EObject current=null] : iv_ruleRangeDef= ruleRangeDef EOF ;
    public final EObject entryRuleRangeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeDef = null;


        try {
            // InternalLibrary.g:2356:49: (iv_ruleRangeDef= ruleRangeDef EOF )
            // InternalLibrary.g:2357:2: iv_ruleRangeDef= ruleRangeDef EOF
            {
             newCompositeNode(grammarAccess.getRangeDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRangeDef=ruleRangeDef();

            state._fsp--;

             current =iv_ruleRangeDef; 
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
    // $ANTLR end "entryRuleRangeDef"


    // $ANTLR start "ruleRangeDef"
    // InternalLibrary.g:2363:1: ruleRangeDef returns [EObject current=null] : (otherlv_0= 'RangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleRangeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2369:2: ( (otherlv_0= 'RangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:2370:2: (otherlv_0= 'RangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:2370:2: (otherlv_0= 'RangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:2371:3: otherlv_0= 'RangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRangeDefAccess().getRangeDefKeyword_0());
            		
            // InternalLibrary.g:2375:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2376:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2376:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2377:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRangeDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRangeDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getRangeDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2398:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==36) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalLibrary.g:2399:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getRangeDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2403:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2404:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2404:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2405:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getRangeDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2423:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==28) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalLibrary.g:2424:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getRangeDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2428:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2429:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2429:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2430:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getRangeDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getRangeDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleRangeDef"


    // $ANTLR start "entryRuleMissingValuesDef"
    // InternalLibrary.g:2456:1: entryRuleMissingValuesDef returns [EObject current=null] : iv_ruleMissingValuesDef= ruleMissingValuesDef EOF ;
    public final EObject entryRuleMissingValuesDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMissingValuesDef = null;


        try {
            // InternalLibrary.g:2456:57: (iv_ruleMissingValuesDef= ruleMissingValuesDef EOF )
            // InternalLibrary.g:2457:2: iv_ruleMissingValuesDef= ruleMissingValuesDef EOF
            {
             newCompositeNode(grammarAccess.getMissingValuesDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMissingValuesDef=ruleMissingValuesDef();

            state._fsp--;

             current =iv_ruleMissingValuesDef; 
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
    // $ANTLR end "entryRuleMissingValuesDef"


    // $ANTLR start "ruleMissingValuesDef"
    // InternalLibrary.g:2463:1: ruleMissingValuesDef returns [EObject current=null] : (otherlv_0= 'MissingValuesDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleMissingValuesDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2469:2: ( (otherlv_0= 'MissingValuesDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:2470:2: (otherlv_0= 'MissingValuesDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:2470:2: (otherlv_0= 'MissingValuesDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:2471:3: otherlv_0= 'MissingValuesDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMissingValuesDefAccess().getMissingValuesDefKeyword_0());
            		
            // InternalLibrary.g:2475:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2476:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2476:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2477:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMissingValuesDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMissingValuesDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getMissingValuesDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2498:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==36) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalLibrary.g:2499:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getMissingValuesDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2503:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2504:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2504:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2505:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getMissingValuesDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMissingValuesDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2523:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==28) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalLibrary.g:2524:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getMissingValuesDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2528:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2529:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2529:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2530:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMissingValuesDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMissingValuesDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMissingValuesDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleMissingValuesDef"


    // $ANTLR start "entryRuleDateRangeDef"
    // InternalLibrary.g:2556:1: entryRuleDateRangeDef returns [EObject current=null] : iv_ruleDateRangeDef= ruleDateRangeDef EOF ;
    public final EObject entryRuleDateRangeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateRangeDef = null;


        try {
            // InternalLibrary.g:2556:53: (iv_ruleDateRangeDef= ruleDateRangeDef EOF )
            // InternalLibrary.g:2557:2: iv_ruleDateRangeDef= ruleDateRangeDef EOF
            {
             newCompositeNode(grammarAccess.getDateRangeDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateRangeDef=ruleDateRangeDef();

            state._fsp--;

             current =iv_ruleDateRangeDef; 
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
    // $ANTLR end "entryRuleDateRangeDef"


    // $ANTLR start "ruleDateRangeDef"
    // InternalLibrary.g:2563:1: ruleDateRangeDef returns [EObject current=null] : (otherlv_0= 'DateRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleDateRangeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2569:2: ( (otherlv_0= 'DateRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:2570:2: (otherlv_0= 'DateRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:2570:2: (otherlv_0= 'DateRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:2571:3: otherlv_0= 'DateRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDateRangeDefAccess().getDateRangeDefKeyword_0());
            		
            // InternalLibrary.g:2575:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2576:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2576:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2577:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDateRangeDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateRangeDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getDateRangeDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2598:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==36) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalLibrary.g:2599:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getDateRangeDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2603:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2604:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2604:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2605:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getDateRangeDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRangeDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2623:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==28) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalLibrary.g:2624:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getDateRangeDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2628:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2629:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2629:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2630:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDateRangeDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRangeDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDateRangeDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleDateRangeDef"


    // $ANTLR start "entryRuleDiscretizeBinDef"
    // InternalLibrary.g:2656:1: entryRuleDiscretizeBinDef returns [EObject current=null] : iv_ruleDiscretizeBinDef= ruleDiscretizeBinDef EOF ;
    public final EObject entryRuleDiscretizeBinDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiscretizeBinDef = null;


        try {
            // InternalLibrary.g:2656:57: (iv_ruleDiscretizeBinDef= ruleDiscretizeBinDef EOF )
            // InternalLibrary.g:2657:2: iv_ruleDiscretizeBinDef= ruleDiscretizeBinDef EOF
            {
             newCompositeNode(grammarAccess.getDiscretizeBinDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDiscretizeBinDef=ruleDiscretizeBinDef();

            state._fsp--;

             current =iv_ruleDiscretizeBinDef; 
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
    // $ANTLR end "entryRuleDiscretizeBinDef"


    // $ANTLR start "ruleDiscretizeBinDef"
    // InternalLibrary.g:2663:1: ruleDiscretizeBinDef returns [EObject current=null] : (otherlv_0= 'DiscretizeBinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleDiscretizeBinDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2669:2: ( (otherlv_0= 'DiscretizeBinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:2670:2: (otherlv_0= 'DiscretizeBinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:2670:2: (otherlv_0= 'DiscretizeBinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:2671:3: otherlv_0= 'DiscretizeBinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDiscretizeBinDefAccess().getDiscretizeBinDefKeyword_0());
            		
            // InternalLibrary.g:2675:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2676:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2676:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2677:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDiscretizeBinDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDiscretizeBinDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getDiscretizeBinDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2698:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==36) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalLibrary.g:2699:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getDiscretizeBinDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2703:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2704:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2704:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2705:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getDiscretizeBinDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDiscretizeBinDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2723:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==28) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalLibrary.g:2724:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getDiscretizeBinDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2728:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2729:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2729:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2730:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDiscretizeBinDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDiscretizeBinDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDiscretizeBinDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleDiscretizeBinDef"


    // $ANTLR start "entryRuleDerivedValueDef"
    // InternalLibrary.g:2756:1: entryRuleDerivedValueDef returns [EObject current=null] : iv_ruleDerivedValueDef= ruleDerivedValueDef EOF ;
    public final EObject entryRuleDerivedValueDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedValueDef = null;


        try {
            // InternalLibrary.g:2756:56: (iv_ruleDerivedValueDef= ruleDerivedValueDef EOF )
            // InternalLibrary.g:2757:2: iv_ruleDerivedValueDef= ruleDerivedValueDef EOF
            {
             newCompositeNode(grammarAccess.getDerivedValueDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDerivedValueDef=ruleDerivedValueDef();

            state._fsp--;

             current =iv_ruleDerivedValueDef; 
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
    // $ANTLR end "entryRuleDerivedValueDef"


    // $ANTLR start "ruleDerivedValueDef"
    // InternalLibrary.g:2763:1: ruleDerivedValueDef returns [EObject current=null] : (otherlv_0= 'DerivedValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleDerivedValueDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2769:2: ( (otherlv_0= 'DerivedValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:2770:2: (otherlv_0= 'DerivedValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:2770:2: (otherlv_0= 'DerivedValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:2771:3: otherlv_0= 'DerivedValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDerivedValueDefAccess().getDerivedValueDefKeyword_0());
            		
            // InternalLibrary.g:2775:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2776:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2776:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2777:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDerivedValueDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedValueDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getDerivedValueDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2798:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==36) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalLibrary.g:2799:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getDerivedValueDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2803:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2804:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2804:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2805:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getDerivedValueDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDerivedValueDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2823:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==28) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalLibrary.g:2824:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getDerivedValueDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2828:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2829:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2829:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2830:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDerivedValueDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDerivedValueDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDerivedValueDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleDerivedValueDef"


    // $ANTLR start "entryRuleNumOpDef"
    // InternalLibrary.g:2856:1: entryRuleNumOpDef returns [EObject current=null] : iv_ruleNumOpDef= ruleNumOpDef EOF ;
    public final EObject entryRuleNumOpDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumOpDef = null;


        try {
            // InternalLibrary.g:2856:49: (iv_ruleNumOpDef= ruleNumOpDef EOF )
            // InternalLibrary.g:2857:2: iv_ruleNumOpDef= ruleNumOpDef EOF
            {
             newCompositeNode(grammarAccess.getNumOpDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumOpDef=ruleNumOpDef();

            state._fsp--;

             current =iv_ruleNumOpDef; 
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
    // $ANTLR end "entryRuleNumOpDef"


    // $ANTLR start "ruleNumOpDef"
    // InternalLibrary.g:2863:1: ruleNumOpDef returns [EObject current=null] : (otherlv_0= 'NumOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleNumOpDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2869:2: ( (otherlv_0= 'NumOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:2870:2: (otherlv_0= 'NumOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:2870:2: (otherlv_0= 'NumOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:2871:3: otherlv_0= 'NumOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getNumOpDefAccess().getNumOpDefKeyword_0());
            		
            // InternalLibrary.g:2875:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2876:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2876:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2877:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getNumOpDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumOpDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getNumOpDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2898:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==36) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalLibrary.g:2899:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getNumOpDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:2903:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:2904:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:2904:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:2905:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getNumOpDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumOpDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:2923:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==28) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalLibrary.g:2924:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getNumOpDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:2928:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:2929:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:2929:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:2930:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getNumOpDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumOpDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getNumOpDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleNumOpDef"


    // $ANTLR start "entryRuleFixValueDef"
    // InternalLibrary.g:2956:1: entryRuleFixValueDef returns [EObject current=null] : iv_ruleFixValueDef= ruleFixValueDef EOF ;
    public final EObject entryRuleFixValueDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixValueDef = null;


        try {
            // InternalLibrary.g:2956:52: (iv_ruleFixValueDef= ruleFixValueDef EOF )
            // InternalLibrary.g:2957:2: iv_ruleFixValueDef= ruleFixValueDef EOF
            {
             newCompositeNode(grammarAccess.getFixValueDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixValueDef=ruleFixValueDef();

            state._fsp--;

             current =iv_ruleFixValueDef; 
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
    // $ANTLR end "entryRuleFixValueDef"


    // $ANTLR start "ruleFixValueDef"
    // InternalLibrary.g:2963:1: ruleFixValueDef returns [EObject current=null] : (otherlv_0= 'FixValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'value' ( (lv_value_8_0= rulePrimitiveDef ) ) otherlv_9= '}' ) ;
    public final EObject ruleFixValueDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:2969:2: ( (otherlv_0= 'FixValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'value' ( (lv_value_8_0= rulePrimitiveDef ) ) otherlv_9= '}' ) )
            // InternalLibrary.g:2970:2: (otherlv_0= 'FixValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'value' ( (lv_value_8_0= rulePrimitiveDef ) ) otherlv_9= '}' )
            {
            // InternalLibrary.g:2970:2: (otherlv_0= 'FixValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'value' ( (lv_value_8_0= rulePrimitiveDef ) ) otherlv_9= '}' )
            // InternalLibrary.g:2971:3: otherlv_0= 'FixValueDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'value' ( (lv_value_8_0= rulePrimitiveDef ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFixValueDefAccess().getFixValueDefKeyword_0());
            		
            // InternalLibrary.g:2975:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:2976:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:2976:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:2977:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFixValueDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFixValueDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getFixValueDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:2998:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==36) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalLibrary.g:2999:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getFixValueDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:3003:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:3004:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:3004:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:3005:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getFixValueDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFixValueDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:3023:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==28) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalLibrary.g:3024:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getFixValueDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:3028:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:3029:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:3029:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:3030:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getFixValueDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_38);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFixValueDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,50,FOLLOW_35); 

            			newLeafNode(otherlv_7, grammarAccess.getFixValueDefAccess().getValueKeyword_5());
            		
            // InternalLibrary.g:3052:3: ( (lv_value_8_0= rulePrimitiveDef ) )
            // InternalLibrary.g:3053:4: (lv_value_8_0= rulePrimitiveDef )
            {
            // InternalLibrary.g:3053:4: (lv_value_8_0= rulePrimitiveDef )
            // InternalLibrary.g:3054:5: lv_value_8_0= rulePrimitiveDef
            {

            					newCompositeNode(grammarAccess.getFixValueDefAccess().getValuePrimitiveDefParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_8);
            lv_value_8_0=rulePrimitiveDef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFixValueDefRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_8_0,
            						"xtext.Library.PrimitiveDef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFixValueDefAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleFixValueDef"


    // $ANTLR start "entryRuleFieldRangeDef"
    // InternalLibrary.g:3079:1: entryRuleFieldRangeDef returns [EObject current=null] : iv_ruleFieldRangeDef= ruleFieldRangeDef EOF ;
    public final EObject entryRuleFieldRangeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldRangeDef = null;


        try {
            // InternalLibrary.g:3079:54: (iv_ruleFieldRangeDef= ruleFieldRangeDef EOF )
            // InternalLibrary.g:3080:2: iv_ruleFieldRangeDef= ruleFieldRangeDef EOF
            {
             newCompositeNode(grammarAccess.getFieldRangeDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldRangeDef=ruleFieldRangeDef();

            state._fsp--;

             current =iv_ruleFieldRangeDef; 
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
    // $ANTLR end "entryRuleFieldRangeDef"


    // $ANTLR start "ruleFieldRangeDef"
    // InternalLibrary.g:3086:1: ruleFieldRangeDef returns [EObject current=null] : (otherlv_0= 'FieldRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleFieldRangeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3092:2: ( (otherlv_0= 'FieldRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' ) )
            // InternalLibrary.g:3093:2: (otherlv_0= 'FieldRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            {
            // InternalLibrary.g:3093:2: (otherlv_0= 'FieldRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}' )
            // InternalLibrary.g:3094:3: otherlv_0= 'FieldRangeDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldRangeDefAccess().getFieldRangeDefKeyword_0());
            		
            // InternalLibrary.g:3098:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:3099:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:3099:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:3100:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFieldRangeDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRangeDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldRangeDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:3121:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==36) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalLibrary.g:3122:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getFieldRangeDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:3126:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:3127:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:3127:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:3128:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getFieldRangeDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFieldRangeDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:3146:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==28) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalLibrary.g:3147:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getFieldRangeDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:3151:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:3152:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:3152:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:3153:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getFieldRangeDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFieldRangeDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFieldRangeDefAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleFieldRangeDef"


    // $ANTLR start "entryRuleMathOpDef"
    // InternalLibrary.g:3179:1: entryRuleMathOpDef returns [EObject current=null] : iv_ruleMathOpDef= ruleMathOpDef EOF ;
    public final EObject entryRuleMathOpDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathOpDef = null;


        try {
            // InternalLibrary.g:3179:50: (iv_ruleMathOpDef= ruleMathOpDef EOF )
            // InternalLibrary.g:3180:2: iv_ruleMathOpDef= ruleMathOpDef EOF
            {
             newCompositeNode(grammarAccess.getMathOpDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathOpDef=ruleMathOpDef();

            state._fsp--;

             current =iv_ruleMathOpDef; 
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
    // $ANTLR end "entryRuleMathOpDef"


    // $ANTLR start "ruleMathOpDef"
    // InternalLibrary.g:3186:1: ruleMathOpDef returns [EObject current=null] : (otherlv_0= 'MathOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' ) ;
    public final EObject ruleMathOpDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;

        EObject lv_operandDef_9_0 = null;

        EObject lv_operandDef_11_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3192:2: ( (otherlv_0= 'MathOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' ) )
            // InternalLibrary.g:3193:2: (otherlv_0= 'MathOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' )
            {
            // InternalLibrary.g:3193:2: (otherlv_0= 'MathOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' )
            // InternalLibrary.g:3194:3: otherlv_0= 'MathOpDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMathOpDefAccess().getMathOpDefKeyword_0());
            		
            // InternalLibrary.g:3198:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:3199:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:3199:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:3200:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMathOpDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathOpDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getMathOpDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:3221:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==36) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalLibrary.g:3222:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getMathOpDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:3226:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:3227:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:3227:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:3228:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getMathOpDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathOpDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:3246:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==28) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalLibrary.g:3247:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getMathOpDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:3251:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:3252:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:3252:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:3253:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMathOpDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathOpDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,53,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getMathOpDefAccess().getOperandDefKeyword_5());
            		
            otherlv_8=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_8, grammarAccess.getMathOpDefAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalLibrary.g:3279:3: ( (lv_operandDef_9_0= ruleOperandDef ) )
            // InternalLibrary.g:3280:4: (lv_operandDef_9_0= ruleOperandDef )
            {
            // InternalLibrary.g:3280:4: (lv_operandDef_9_0= ruleOperandDef )
            // InternalLibrary.g:3281:5: lv_operandDef_9_0= ruleOperandDef
            {

            					newCompositeNode(grammarAccess.getMathOpDefAccess().getOperandDefOperandDefParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_7);
            lv_operandDef_9_0=ruleOperandDef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathOpDefRule());
            					}
            					add(
            						current,
            						"operandDef",
            						lv_operandDef_9_0,
            						"xtext.Library.OperandDef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:3298:3: (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==14) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalLibrary.g:3299:4: otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) )
            	    {
            	    otherlv_10=(Token)match(input,14,FOLLOW_15); 

            	    				newLeafNode(otherlv_10, grammarAccess.getMathOpDefAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalLibrary.g:3303:4: ( (lv_operandDef_11_0= ruleOperandDef ) )
            	    // InternalLibrary.g:3304:5: (lv_operandDef_11_0= ruleOperandDef )
            	    {
            	    // InternalLibrary.g:3304:5: (lv_operandDef_11_0= ruleOperandDef )
            	    // InternalLibrary.g:3305:6: lv_operandDef_11_0= ruleOperandDef
            	    {

            	    						newCompositeNode(grammarAccess.getMathOpDefAccess().getOperandDefOperandDefParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_operandDef_11_0=ruleOperandDef();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMathOpDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operandDef",
            	    							lv_operandDef_11_0,
            	    							"xtext.Library.OperandDef");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            otherlv_12=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_12, grammarAccess.getMathOpDefAccess().getRightCurlyBracketKeyword_9());
            		
            otherlv_13=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getMathOpDefAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleMathOpDef"


    // $ANTLR start "entryRuleJoinDef"
    // InternalLibrary.g:3335:1: entryRuleJoinDef returns [EObject current=null] : iv_ruleJoinDef= ruleJoinDef EOF ;
    public final EObject entryRuleJoinDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinDef = null;


        try {
            // InternalLibrary.g:3335:48: (iv_ruleJoinDef= ruleJoinDef EOF )
            // InternalLibrary.g:3336:2: iv_ruleJoinDef= ruleJoinDef EOF
            {
             newCompositeNode(grammarAccess.getJoinDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoinDef=ruleJoinDef();

            state._fsp--;

             current =iv_ruleJoinDef; 
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
    // $ANTLR end "entryRuleJoinDef"


    // $ANTLR start "ruleJoinDef"
    // InternalLibrary.g:3342:1: ruleJoinDef returns [EObject current=null] : (otherlv_0= 'JoinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' ) ;
    public final EObject ruleJoinDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;

        EObject lv_operandDef_9_0 = null;

        EObject lv_operandDef_11_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3348:2: ( (otherlv_0= 'JoinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' ) )
            // InternalLibrary.g:3349:2: (otherlv_0= 'JoinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' )
            {
            // InternalLibrary.g:3349:2: (otherlv_0= 'JoinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}' )
            // InternalLibrary.g:3350:3: otherlv_0= 'JoinDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'operandDef' otherlv_8= '{' ( (lv_operandDef_9_0= ruleOperandDef ) ) (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )* otherlv_12= '}' otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinDefAccess().getJoinDefKeyword_0());
            		
            // InternalLibrary.g:3354:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:3355:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:3355:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:3356:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJoinDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getJoinDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:3377:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==36) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalLibrary.g:3378:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getJoinDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:3382:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:3383:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:3383:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:3384:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getJoinDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:3402:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==28) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalLibrary.g:3403:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getJoinDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:3407:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:3408:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:3408:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:3409:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getJoinDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,53,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getJoinDefAccess().getOperandDefKeyword_5());
            		
            otherlv_8=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_8, grammarAccess.getJoinDefAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalLibrary.g:3435:3: ( (lv_operandDef_9_0= ruleOperandDef ) )
            // InternalLibrary.g:3436:4: (lv_operandDef_9_0= ruleOperandDef )
            {
            // InternalLibrary.g:3436:4: (lv_operandDef_9_0= ruleOperandDef )
            // InternalLibrary.g:3437:5: lv_operandDef_9_0= ruleOperandDef
            {

            					newCompositeNode(grammarAccess.getJoinDefAccess().getOperandDefOperandDefParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_7);
            lv_operandDef_9_0=ruleOperandDef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinDefRule());
            					}
            					add(
            						current,
            						"operandDef",
            						lv_operandDef_9_0,
            						"xtext.Library.OperandDef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLibrary.g:3454:3: (otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==14) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalLibrary.g:3455:4: otherlv_10= ',' ( (lv_operandDef_11_0= ruleOperandDef ) )
            	    {
            	    otherlv_10=(Token)match(input,14,FOLLOW_15); 

            	    				newLeafNode(otherlv_10, grammarAccess.getJoinDefAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalLibrary.g:3459:4: ( (lv_operandDef_11_0= ruleOperandDef ) )
            	    // InternalLibrary.g:3460:5: (lv_operandDef_11_0= ruleOperandDef )
            	    {
            	    // InternalLibrary.g:3460:5: (lv_operandDef_11_0= ruleOperandDef )
            	    // InternalLibrary.g:3461:6: lv_operandDef_11_0= ruleOperandDef
            	    {

            	    						newCompositeNode(grammarAccess.getJoinDefAccess().getOperandDefOperandDefParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_operandDef_11_0=ruleOperandDef();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJoinDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operandDef",
            	    							lv_operandDef_11_0,
            	    							"xtext.Library.OperandDef");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            otherlv_12=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_12, grammarAccess.getJoinDefAccess().getRightCurlyBracketKeyword_9());
            		
            otherlv_13=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getJoinDefAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleJoinDef"


    // $ANTLR start "entryRuleOperandDef"
    // InternalLibrary.g:3491:1: entryRuleOperandDef returns [EObject current=null] : iv_ruleOperandDef= ruleOperandDef EOF ;
    public final EObject entryRuleOperandDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperandDef = null;


        try {
            // InternalLibrary.g:3491:51: (iv_ruleOperandDef= ruleOperandDef EOF )
            // InternalLibrary.g:3492:2: iv_ruleOperandDef= ruleOperandDef EOF
            {
             newCompositeNode(grammarAccess.getOperandDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperandDef=ruleOperandDef();

            state._fsp--;

             current =iv_ruleOperandDef; 
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
    // $ANTLR end "entryRuleOperandDef"


    // $ANTLR start "ruleOperandDef"
    // InternalLibrary.g:3498:1: ruleOperandDef returns [EObject current=null] : (this_FixValueDef_0= ruleFixValueDef | this_FieldDef_1= ruleFieldDef ) ;
    public final EObject ruleOperandDef() throws RecognitionException {
        EObject current = null;

        EObject this_FixValueDef_0 = null;

        EObject this_FieldDef_1 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3504:2: ( (this_FixValueDef_0= ruleFixValueDef | this_FieldDef_1= ruleFieldDef ) )
            // InternalLibrary.g:3505:2: (this_FixValueDef_0= ruleFixValueDef | this_FieldDef_1= ruleFieldDef )
            {
            // InternalLibrary.g:3505:2: (this_FixValueDef_0= ruleFixValueDef | this_FieldDef_1= ruleFieldDef )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==49) ) {
                alt67=1;
            }
            else if ( (LA67_0==55) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalLibrary.g:3506:3: this_FixValueDef_0= ruleFixValueDef
                    {

                    			newCompositeNode(grammarAccess.getOperandDefAccess().getFixValueDefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixValueDef_0=ruleFixValueDef();

                    state._fsp--;


                    			current = this_FixValueDef_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:3515:3: this_FieldDef_1= ruleFieldDef
                    {

                    			newCompositeNode(grammarAccess.getOperandDefAccess().getFieldDefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldDef_1=ruleFieldDef();

                    state._fsp--;


                    			current = this_FieldDef_1;
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
    // $ANTLR end "ruleOperandDef"


    // $ANTLR start "entryRuleFieldDef"
    // InternalLibrary.g:3527:1: entryRuleFieldDef returns [EObject current=null] : iv_ruleFieldDef= ruleFieldDef EOF ;
    public final EObject entryRuleFieldDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldDef = null;


        try {
            // InternalLibrary.g:3527:49: (iv_ruleFieldDef= ruleFieldDef EOF )
            // InternalLibrary.g:3528:2: iv_ruleFieldDef= ruleFieldDef EOF
            {
             newCompositeNode(grammarAccess.getFieldDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldDef=ruleFieldDef();

            state._fsp--;

             current =iv_ruleFieldDef; 
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
    // $ANTLR end "entryRuleFieldDef"


    // $ANTLR start "ruleFieldDef"
    // InternalLibrary.g:3534:1: ruleFieldDef returns [EObject current=null] : (otherlv_0= 'FieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'datafielddefinition' ( ( ruleEString ) ) otherlv_9= '}' ) ;
    public final EObject ruleFieldDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_required_4_0 = null;

        AntlrDatatypeRuleToken lv_boundTo_6_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3540:2: ( (otherlv_0= 'FieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'datafielddefinition' ( ( ruleEString ) ) otherlv_9= '}' ) )
            // InternalLibrary.g:3541:2: (otherlv_0= 'FieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'datafielddefinition' ( ( ruleEString ) ) otherlv_9= '}' )
            {
            // InternalLibrary.g:3541:2: (otherlv_0= 'FieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'datafielddefinition' ( ( ruleEString ) ) otherlv_9= '}' )
            // InternalLibrary.g:3542:3: otherlv_0= 'FieldDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )? (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )? otherlv_7= 'datafielddefinition' ( ( ruleEString ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldDefAccess().getFieldDefKeyword_0());
            		
            // InternalLibrary.g:3546:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:3547:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:3547:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:3548:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFieldDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldDefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLibrary.g:3569:3: (otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==36) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalLibrary.g:3570:4: otherlv_3= 'required' ( (lv_required_4_0= ruleEBoolean ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_29); 

                    				newLeafNode(otherlv_3, grammarAccess.getFieldDefAccess().getRequiredKeyword_3_0());
                    			
                    // InternalLibrary.g:3574:4: ( (lv_required_4_0= ruleEBoolean ) )
                    // InternalLibrary.g:3575:5: (lv_required_4_0= ruleEBoolean )
                    {
                    // InternalLibrary.g:3575:5: (lv_required_4_0= ruleEBoolean )
                    // InternalLibrary.g:3576:6: lv_required_4_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getFieldDefAccess().getRequiredEBooleanParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_required_4_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFieldDefRule());
                    						}
                    						set(
                    							current,
                    							"required",
                    							lv_required_4_0,
                    							"xtext.Library.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLibrary.g:3594:3: (otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==28) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalLibrary.g:3595:4: otherlv_5= 'boundTo' ( (lv_boundTo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getFieldDefAccess().getBoundToKeyword_4_0());
                    			
                    // InternalLibrary.g:3599:4: ( (lv_boundTo_6_0= ruleEString ) )
                    // InternalLibrary.g:3600:5: (lv_boundTo_6_0= ruleEString )
                    {
                    // InternalLibrary.g:3600:5: (lv_boundTo_6_0= ruleEString )
                    // InternalLibrary.g:3601:6: lv_boundTo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getFieldDefAccess().getBoundToEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_boundTo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFieldDefRule());
                    						}
                    						set(
                    							current,
                    							"boundTo",
                    							lv_boundTo_6_0,
                    							"xtext.Library.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getFieldDefAccess().getDatafielddefinitionKeyword_5());
            		
            // InternalLibrary.g:3623:3: ( ( ruleEString ) )
            // InternalLibrary.g:3624:4: ( ruleEString )
            {
            // InternalLibrary.g:3624:4: ( ruleEString )
            // InternalLibrary.g:3625:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldDefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFieldDefAccess().getDatafielddefinitionDataFieldDefinitionCrossReference_6_0());
            				
            pushFollow(FOLLOW_8);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFieldDefAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleFieldDef"


    // $ANTLR start "entryRuleEString"
    // InternalLibrary.g:3647:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalLibrary.g:3647:47: (iv_ruleEString= ruleEString EOF )
            // InternalLibrary.g:3648:2: iv_ruleEString= ruleEString EOF
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
    // InternalLibrary.g:3654:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalLibrary.g:3660:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalLibrary.g:3661:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalLibrary.g:3661:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_STRING) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_ID) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalLibrary.g:3662:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:3670:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleEBoolean"
    // InternalLibrary.g:3681:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalLibrary.g:3681:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalLibrary.g:3682:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalLibrary.g:3688:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalLibrary.g:3694:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalLibrary.g:3695:2: (kw= 'true' | kw= 'false' )
            {
            // InternalLibrary.g:3695:2: (kw= 'true' | kw= 'false' )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==56) ) {
                alt71=1;
            }
            else if ( (LA71_0==57) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalLibrary.g:3696:3: kw= 'true'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalLibrary.g:3702:3: kw= 'false'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                    		

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
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleConditionDef"
    // InternalLibrary.g:3711:1: entryRuleConditionDef returns [EObject current=null] : iv_ruleConditionDef= ruleConditionDef EOF ;
    public final EObject entryRuleConditionDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionDef = null;


        try {
            // InternalLibrary.g:3711:53: (iv_ruleConditionDef= ruleConditionDef EOF )
            // InternalLibrary.g:3712:2: iv_ruleConditionDef= ruleConditionDef EOF
            {
             newCompositeNode(grammarAccess.getConditionDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionDef=ruleConditionDef();

            state._fsp--;

             current =iv_ruleConditionDef; 
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
    // $ANTLR end "entryRuleConditionDef"


    // $ANTLR start "ruleConditionDef"
    // InternalLibrary.g:3718:1: ruleConditionDef returns [EObject current=null] : (otherlv_0= 'ConditionDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' ) ;
    public final EObject ruleConditionDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3724:2: ( (otherlv_0= 'ConditionDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' ) )
            // InternalLibrary.g:3725:2: (otherlv_0= 'ConditionDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' )
            {
            // InternalLibrary.g:3725:2: (otherlv_0= 'ConditionDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' )
            // InternalLibrary.g:3726:3: otherlv_0= 'ConditionDef' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionDefAccess().getConditionDefKeyword_0());
            		
            // InternalLibrary.g:3730:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:3731:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:3731:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:3732:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getConditionDefAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionDefAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionDefAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleConditionDef"


    // $ANTLR start "entryRuleValueRangeDefinition"
    // InternalLibrary.g:3761:1: entryRuleValueRangeDefinition returns [EObject current=null] : iv_ruleValueRangeDefinition= ruleValueRangeDefinition EOF ;
    public final EObject entryRuleValueRangeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRangeDefinition = null;


        try {
            // InternalLibrary.g:3761:61: (iv_ruleValueRangeDefinition= ruleValueRangeDefinition EOF )
            // InternalLibrary.g:3762:2: iv_ruleValueRangeDefinition= ruleValueRangeDefinition EOF
            {
             newCompositeNode(grammarAccess.getValueRangeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueRangeDefinition=ruleValueRangeDefinition();

            state._fsp--;

             current =iv_ruleValueRangeDefinition; 
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
    // $ANTLR end "entryRuleValueRangeDefinition"


    // $ANTLR start "ruleValueRangeDefinition"
    // InternalLibrary.g:3768:1: ruleValueRangeDefinition returns [EObject current=null] : (otherlv_0= 'ValueRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' ) ;
    public final EObject ruleValueRangeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3774:2: ( (otherlv_0= 'ValueRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' ) )
            // InternalLibrary.g:3775:2: (otherlv_0= 'ValueRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' )
            {
            // InternalLibrary.g:3775:2: (otherlv_0= 'ValueRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' )
            // InternalLibrary.g:3776:3: otherlv_0= 'ValueRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getValueRangeDefinitionAccess().getValueRangeDefinitionKeyword_0());
            		
            // InternalLibrary.g:3780:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:3781:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:3781:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:3782:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getValueRangeDefinitionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValueRangeDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getValueRangeDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getValueRangeDefinitionAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleValueRangeDefinition"


    // $ANTLR start "entryRuleFieldRangeDefinition"
    // InternalLibrary.g:3811:1: entryRuleFieldRangeDefinition returns [EObject current=null] : iv_ruleFieldRangeDefinition= ruleFieldRangeDefinition EOF ;
    public final EObject entryRuleFieldRangeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldRangeDefinition = null;


        try {
            // InternalLibrary.g:3811:61: (iv_ruleFieldRangeDefinition= ruleFieldRangeDefinition EOF )
            // InternalLibrary.g:3812:2: iv_ruleFieldRangeDefinition= ruleFieldRangeDefinition EOF
            {
             newCompositeNode(grammarAccess.getFieldRangeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldRangeDefinition=ruleFieldRangeDefinition();

            state._fsp--;

             current =iv_ruleFieldRangeDefinition; 
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
    // $ANTLR end "entryRuleFieldRangeDefinition"


    // $ANTLR start "ruleFieldRangeDefinition"
    // InternalLibrary.g:3818:1: ruleFieldRangeDefinition returns [EObject current=null] : (otherlv_0= 'FieldRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' ) ;
    public final EObject ruleFieldRangeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalLibrary.g:3824:2: ( (otherlv_0= 'FieldRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' ) )
            // InternalLibrary.g:3825:2: (otherlv_0= 'FieldRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' )
            {
            // InternalLibrary.g:3825:2: (otherlv_0= 'FieldRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}' )
            // InternalLibrary.g:3826:3: otherlv_0= 'FieldRangeDefinition' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldRangeDefinitionAccess().getFieldRangeDefinitionKeyword_0());
            		
            // InternalLibrary.g:3830:3: ( (lv_name_1_0= ruleEString ) )
            // InternalLibrary.g:3831:4: (lv_name_1_0= ruleEString )
            {
            // InternalLibrary.g:3831:4: (lv_name_1_0= ruleEString )
            // InternalLibrary.g:3832:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFieldRangeDefinitionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRangeDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.Library.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldRangeDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldRangeDefinitionAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleFieldRangeDefinition"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000084000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00DBF9E800000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x1C00000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000090008000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080008000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001010008000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000061010008000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000060010008000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000060000008000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000040000008000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0004001010000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0004000010000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0020001010000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0020000010000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000001090000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000090000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000080000000L});

}