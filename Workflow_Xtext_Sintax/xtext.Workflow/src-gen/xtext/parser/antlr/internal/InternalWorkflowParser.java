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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_EFLOAT", "RULE_EINT", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'workflow'", "'{'", "'environment'", "'dataprocessing'", "'}'", "'links'", "'dataProcessing'", "'definition'", "'origin'", "'inputPort'", "'outputPort'", "'in'", "'out'", "'parameters'", "'contracts'", "'initial_accumulated_processing'", "'pmmlModel'", "'filePath'", "'onlyPredictions'", "'true'", "'test'", "'path'", "'trainSize'", "'testSize'", "'link'", "'source'", "'target'", "'map'", "'mapDefinition'", "'inValue'", "'outvalue'", "'mapOperation'", "'primitive'", "'primitiveDef'", "'value'", "'dataType'", "'derivedField'", "'derivedFieldDef'", "'der_dataField'", "'filterValue'", "'filterValueDef'", "'primitives'", "'matchingValues'", "'filterType'", "'discretizeBin'", "'discretizeBinDef'", "'binValue'", "'intervals'", "'fieldRange'", "'fieldDef'", "'dataFields'", "'operator'", "'mathOp'", "'mathOpDef'", "'operands'", "'join'", "'joinDef'", "'field'", "'datafield'", "'fixValue'", "'fixValueDef'", "'range'", "'rangeDef'", "'min'", "'max'", "'clousure'", "'minInfinity'", "'maxInfinity'", "'dateRange'", "'specialValues'", "'specialValuesDef'", "'specialType'", "'derivedValue'", "'derivedValueDef'", "'type'", "'imputeValue'", "'numOp'", "'numOpDef'", "'operation'", "'castType'", "'castTypeDef'", "'dataDictionary'", "'dataDictionaryDefinition'", "'fileName'", "'datafields'", "'categorical'", "'categoricalDef'", "'id'", "'displayName'", "'ordinal'", "'validValues'", "'invalidValues'", "'missingValues'", "'continuous'", "'continuousDef'", "'numDecimals'", "'date'", "'dateDef'", "'format'", "'intervaldate'", "'interval'", "'leftMargin'", "'rightMargin'", "'intervalDate'", "'count'", "'contract'", "'contractDefinition'", "'contractElement'", "'local'", "'storage'", "'containerName'", "'developmentTool'", "'imageName'", "'imageTag'", "'azureCI'", "'acrName'", "'keyVaultName'", "'secretName'", "'blobName'", "'amazonECS'", "'secretId'", "'region'", "'key'", "'version'", "'tool'", "'database'", "'host'", "'port'", "'auth'", "'dbName'", "'tables'", "'credentials'", "'username'", "'passwd'", "'ssl'", "'path_sslcert'", "'path_sslkey'", "'path_sslrootcert'", "'oauth2'", "'clientId'", "'clientSecret'", "'tokenUrl'", "'accessToken'", "'scope'", "'aws'", "'accessKey'", "'endpointURL'", "'file'", "'csv_sep'", "'hdf5_key'", "'csv_thousandsSep'", "'csv_decimalSep'", "'table'", "'localFolder'", "'folderPath'", "'files'", "'amazonS3'", "'bucket'", "'azureBlob'", "'container'", "'String'", "'Time'", "'Integer'", "'DateTime'", "'Boolean'", "'Double'", "'Float'", "'Date'", "'openOpen'", "'openClosed'", "'closedOpen'", "'closedClosed'", "'Interpolation'", "'Mean'", "'Median'", "'Closest'", "'MostFrequent'", "'Previous'", "'Next'", "'Missing'", "'Invalid'", "'Outlier'", "'BELONG'", "'NOTBELONG'", "'EXCLUDE'", "'INCLUDE'", "'VALUE_MAPPING'", "'SUBSTRING'", "'SUM'", "'SUBSTRACT'", "'MULTIPLY'", "'DIVIDE'", "'PYTHON'", "'R'", "'KNIME'", "'MYSQL'", "'POSTGRESQL'", "'SQLSERVER'", "'ORACLE'", "'MONGODB'", "'DYNAMODB'", "'CSV'", "'EXCEL'", "'JSON'", "'PARQUET'", "'FEATHER'", "'HDF5'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=8;
    public static final int T__66=66;
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
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__168=168;
    public static final int T__167=167;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int T__164=164;
    public static final int T__163=163;
    public static final int T__160=160;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__159=159;
    public static final int T__30=30;
    public static final int T__158=158;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__155=155;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
    public static final int T__100=100;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__218=218;
    public static final int T__217=217;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__219=219;
    public static final int T__214=214;
    public static final int T__213=213;
    public static final int T__216=216;
    public static final int T__215=215;
    public static final int T__210=210;
    public static final int T__212=212;
    public static final int T__211=211;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__207=207;
    public static final int T__23=23;
    public static final int T__206=206;
    public static final int T__24=24;
    public static final int T__209=209;
    public static final int T__25=25;
    public static final int T__208=208;
    public static final int T__203=203;
    public static final int T__202=202;
    public static final int T__20=20;
    public static final int T__205=205;
    public static final int T__21=21;
    public static final int T__204=204;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__117=117;
    public static final int T__116=116;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__108=108;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int T__105=105;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__201=201;
    public static final int T__200=200;
    public static final int RULE_EFLOAT=6;
    public static final int T__91=91;
    public static final int T__188=188;
    public static final int T__92=92;
    public static final int T__187=187;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__189=189;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int T__186=186;
    public static final int T__90=90;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__177=177;
    public static final int T__176=176;
    public static final int T__179=179;
    public static final int T__178=178;
    public static final int T__173=173;
    public static final int T__172=172;
    public static final int T__175=175;
    public static final int T__174=174;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int T__169=169;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__199=199;
    public static final int T__81=81;
    public static final int T__198=198;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__195=195;
    public static final int T__194=194;
    public static final int RULE_WS=11;
    public static final int T__197=197;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_EINT=7;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

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
    // InternalWorkflow.g:72:1: ruleWorkflow returns [EObject current=null] : (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'environment' ( (lv_environment_4_0= ruleEnvironment ) ) otherlv_5= 'dataprocessing' otherlv_6= '{' ( (lv_dataprocessing_7_0= ruleProcessingStep ) )+ otherlv_8= '}' (otherlv_9= 'links' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) )* otherlv_12= '}' )? otherlv_13= '}' ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_environment_4_0 = null;

        EObject lv_dataprocessing_7_0 = null;

        EObject lv_link_11_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:78:2: ( (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'environment' ( (lv_environment_4_0= ruleEnvironment ) ) otherlv_5= 'dataprocessing' otherlv_6= '{' ( (lv_dataprocessing_7_0= ruleProcessingStep ) )+ otherlv_8= '}' (otherlv_9= 'links' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) )* otherlv_12= '}' )? otherlv_13= '}' ) )
            // InternalWorkflow.g:79:2: (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'environment' ( (lv_environment_4_0= ruleEnvironment ) ) otherlv_5= 'dataprocessing' otherlv_6= '{' ( (lv_dataprocessing_7_0= ruleProcessingStep ) )+ otherlv_8= '}' (otherlv_9= 'links' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) )* otherlv_12= '}' )? otherlv_13= '}' )
            {
            // InternalWorkflow.g:79:2: (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'environment' ( (lv_environment_4_0= ruleEnvironment ) ) otherlv_5= 'dataprocessing' otherlv_6= '{' ( (lv_dataprocessing_7_0= ruleProcessingStep ) )+ otherlv_8= '}' (otherlv_9= 'links' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) )* otherlv_12= '}' )? otherlv_13= '}' )
            // InternalWorkflow.g:80:3: otherlv_0= 'workflow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'environment' ( (lv_environment_4_0= ruleEnvironment ) ) otherlv_5= 'dataprocessing' otherlv_6= '{' ( (lv_dataprocessing_7_0= ruleProcessingStep ) )+ otherlv_8= '}' (otherlv_9= 'links' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) )* otherlv_12= '}' )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkflowAccess().getWorkflowKeyword_0());
            		
            // InternalWorkflow.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getWorkflowAccess().getEnvironmentKeyword_3());
            		
            // InternalWorkflow.g:110:3: ( (lv_environment_4_0= ruleEnvironment ) )
            // InternalWorkflow.g:111:4: (lv_environment_4_0= ruleEnvironment )
            {
            // InternalWorkflow.g:111:4: (lv_environment_4_0= ruleEnvironment )
            // InternalWorkflow.g:112:5: lv_environment_4_0= ruleEnvironment
            {

            					newCompositeNode(grammarAccess.getWorkflowAccess().getEnvironmentEnvironmentParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_environment_4_0=ruleEnvironment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            					}
            					set(
            						current,
            						"environment",
            						lv_environment_4_0,
            						"xtext.Workflow.Environment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getWorkflowAccess().getDataprocessingKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:137:3: ( (lv_dataprocessing_7_0= ruleProcessingStep ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==19||LA1_0==29) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalWorkflow.g:138:4: (lv_dataprocessing_7_0= ruleProcessingStep )
            	    {
            	    // InternalWorkflow.g:138:4: (lv_dataprocessing_7_0= ruleProcessingStep )
            	    // InternalWorkflow.g:139:5: lv_dataprocessing_7_0= ruleProcessingStep
            	    {

            	    					newCompositeNode(grammarAccess.getWorkflowAccess().getDataprocessingProcessingStepParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_8());
            		
            // InternalWorkflow.g:160:3: (otherlv_9= 'links' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) )* otherlv_12= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalWorkflow.g:161:4: otherlv_9= 'links' otherlv_10= '{' ( (lv_link_11_0= ruleLink ) )* otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getWorkflowAccess().getLinksKeyword_9_0());
                    			
                    otherlv_10=(Token)match(input,14,FOLLOW_11); 

                    				newLeafNode(otherlv_10, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_9_1());
                    			
                    // InternalWorkflow.g:169:4: ( (lv_link_11_0= ruleLink ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==37) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalWorkflow.g:170:5: (lv_link_11_0= ruleLink )
                    	    {
                    	    // InternalWorkflow.g:170:5: (lv_link_11_0= ruleLink )
                    	    // InternalWorkflow.g:171:6: lv_link_11_0= ruleLink
                    	    {

                    	    						newCompositeNode(grammarAccess.getWorkflowAccess().getLinkLinkParserRuleCall_9_2_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
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
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_12, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_9_3());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_10());
            		

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
    // InternalWorkflow.g:201:1: entryRuleProcessingStep returns [EObject current=null] : iv_ruleProcessingStep= ruleProcessingStep EOF ;
    public final EObject entryRuleProcessingStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessingStep = null;


        try {
            // InternalWorkflow.g:201:55: (iv_ruleProcessingStep= ruleProcessingStep EOF )
            // InternalWorkflow.g:202:2: iv_ruleProcessingStep= ruleProcessingStep EOF
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
    // InternalWorkflow.g:208:1: ruleProcessingStep returns [EObject current=null] : (this_DataProcessing_0= ruleDataProcessing | this_PMMLModel_1= rulePMMLModel ) ;
    public final EObject ruleProcessingStep() throws RecognitionException {
        EObject current = null;

        EObject this_DataProcessing_0 = null;

        EObject this_PMMLModel_1 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:214:2: ( (this_DataProcessing_0= ruleDataProcessing | this_PMMLModel_1= rulePMMLModel ) )
            // InternalWorkflow.g:215:2: (this_DataProcessing_0= ruleDataProcessing | this_PMMLModel_1= rulePMMLModel )
            {
            // InternalWorkflow.g:215:2: (this_DataProcessing_0= ruleDataProcessing | this_PMMLModel_1= rulePMMLModel )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            else if ( (LA4_0==29) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalWorkflow.g:216:3: this_DataProcessing_0= ruleDataProcessing
                    {

                    			newCompositeNode(grammarAccess.getProcessingStepAccess().getDataProcessingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataProcessing_0=ruleDataProcessing();

                    state._fsp--;


                    			current = this_DataProcessing_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:225:3: this_PMMLModel_1= rulePMMLModel
                    {

                    			newCompositeNode(grammarAccess.getProcessingStepAccess().getPMMLModelParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PMMLModel_1=rulePMMLModel();

                    state._fsp--;


                    			current = this_PMMLModel_1;
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


    // $ANTLR start "entryRuleDataProcessing"
    // InternalWorkflow.g:237:1: entryRuleDataProcessing returns [EObject current=null] : iv_ruleDataProcessing= ruleDataProcessing EOF ;
    public final EObject entryRuleDataProcessing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataProcessing = null;


        try {
            // InternalWorkflow.g:237:55: (iv_ruleDataProcessing= ruleDataProcessing EOF )
            // InternalWorkflow.g:238:2: iv_ruleDataProcessing= ruleDataProcessing EOF
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
    // InternalWorkflow.g:244:1: ruleDataProcessing returns [EObject current=null] : (otherlv_0= 'dataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? (otherlv_23= 'parameters' otherlv_24= '{' ( (lv_parameter_25_0= ruleParameter ) )* otherlv_26= '}' )? (otherlv_27= 'contracts' otherlv_28= '{' ( (lv_contract_29_0= ruleContract ) )* otherlv_30= '}' )? (otherlv_31= 'initial_accumulated_processing' ( (otherlv_32= RULE_ID ) ) )? otherlv_33= '}' ) ;
    public final EObject ruleDataProcessing() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_dataProcessingDefinition_4_0=null;
        Token otherlv_5=null;
        Token lv_origin_function_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        EObject lv_inputPort_9_0 = null;

        EObject lv_outputPort_13_0 = null;

        EObject lv_parameter_25_0 = null;

        EObject lv_contract_29_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:250:2: ( (otherlv_0= 'dataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? (otherlv_23= 'parameters' otherlv_24= '{' ( (lv_parameter_25_0= ruleParameter ) )* otherlv_26= '}' )? (otherlv_27= 'contracts' otherlv_28= '{' ( (lv_contract_29_0= ruleContract ) )* otherlv_30= '}' )? (otherlv_31= 'initial_accumulated_processing' ( (otherlv_32= RULE_ID ) ) )? otherlv_33= '}' ) )
            // InternalWorkflow.g:251:2: (otherlv_0= 'dataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? (otherlv_23= 'parameters' otherlv_24= '{' ( (lv_parameter_25_0= ruleParameter ) )* otherlv_26= '}' )? (otherlv_27= 'contracts' otherlv_28= '{' ( (lv_contract_29_0= ruleContract ) )* otherlv_30= '}' )? (otherlv_31= 'initial_accumulated_processing' ( (otherlv_32= RULE_ID ) ) )? otherlv_33= '}' )
            {
            // InternalWorkflow.g:251:2: (otherlv_0= 'dataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? (otherlv_23= 'parameters' otherlv_24= '{' ( (lv_parameter_25_0= ruleParameter ) )* otherlv_26= '}' )? (otherlv_27= 'contracts' otherlv_28= '{' ( (lv_contract_29_0= ruleContract ) )* otherlv_30= '}' )? (otherlv_31= 'initial_accumulated_processing' ( (otherlv_32= RULE_ID ) ) )? otherlv_33= '}' )
            // InternalWorkflow.g:252:3: otherlv_0= 'dataProcessing' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? (otherlv_23= 'parameters' otherlv_24= '{' ( (lv_parameter_25_0= ruleParameter ) )* otherlv_26= '}' )? (otherlv_27= 'contracts' otherlv_28= '{' ( (lv_contract_29_0= ruleContract ) )* otherlv_30= '}' )? (otherlv_31= 'initial_accumulated_processing' ( (otherlv_32= RULE_ID ) ) )? otherlv_33= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDataProcessingAccess().getDataProcessingKeyword_0());
            		
            // InternalWorkflow.g:256:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:257:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:257:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:258:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDataProcessingAccess().getDefinitionKeyword_3());
            		
            // InternalWorkflow.g:282:3: ( (lv_dataProcessingDefinition_4_0= RULE_ID ) )
            // InternalWorkflow.g:283:4: (lv_dataProcessingDefinition_4_0= RULE_ID )
            {
            // InternalWorkflow.g:283:4: (lv_dataProcessingDefinition_4_0= RULE_ID )
            // InternalWorkflow.g:284:5: lv_dataProcessingDefinition_4_0= RULE_ID
            {
            lv_dataProcessingDefinition_4_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_dataProcessingDefinition_4_0, grammarAccess.getDataProcessingAccess().getDataProcessingDefinitionIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataProcessingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dataProcessingDefinition",
            						lv_dataProcessingDefinition_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getDataProcessingAccess().getOriginKeyword_5());
            		
            // InternalWorkflow.g:304:3: ( (lv_origin_function_6_0= RULE_STRING ) )
            // InternalWorkflow.g:305:4: (lv_origin_function_6_0= RULE_STRING )
            {
            // InternalWorkflow.g:305:4: (lv_origin_function_6_0= RULE_STRING )
            // InternalWorkflow.g:306:5: lv_origin_function_6_0= RULE_STRING
            {
            lv_origin_function_6_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_origin_function_6_0, grammarAccess.getDataProcessingAccess().getOrigin_functionSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataProcessingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"origin_function",
            						lv_origin_function_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getDataProcessingAccess().getInputPortKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_8, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalWorkflow.g:330:3: ( (lv_inputPort_9_0= ruleDataDictionary ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==94) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalWorkflow.g:331:4: (lv_inputPort_9_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:331:4: (lv_inputPort_9_0= ruleDataDictionary )
            	    // InternalWorkflow.g:332:5: lv_inputPort_9_0= ruleDataDictionary
            	    {

            	    					newCompositeNode(grammarAccess.getDataProcessingAccess().getInputPortDataDictionaryParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_inputPort_9_0=ruleDataDictionary();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputPort",
            	    						lv_inputPort_9_0,
            	    						"xtext.Workflow.DataDictionary");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_19); 

            			newLeafNode(otherlv_10, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_10());
            		
            otherlv_11=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_11, grammarAccess.getDataProcessingAccess().getOutputPortKeyword_11());
            		
            otherlv_12=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_12, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_12());
            		
            // InternalWorkflow.g:361:3: ( (lv_outputPort_13_0= ruleDataDictionary ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==94) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalWorkflow.g:362:4: (lv_outputPort_13_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:362:4: (lv_outputPort_13_0= ruleDataDictionary )
            	    // InternalWorkflow.g:363:5: lv_outputPort_13_0= ruleDataDictionary
            	    {

            	    					newCompositeNode(grammarAccess.getDataProcessingAccess().getOutputPortDataDictionaryParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_outputPort_13_0=ruleDataDictionary();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDataProcessingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outputPort",
            	    						lv_outputPort_13_0,
            	    						"xtext.Workflow.DataDictionary");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            otherlv_14=(Token)match(input,17,FOLLOW_20); 

            			newLeafNode(otherlv_14, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_14());
            		
            // InternalWorkflow.g:384:3: (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalWorkflow.g:385:4: otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,24,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getDataProcessingAccess().getInKeyword_15_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_15_1());
                    			
                    // InternalWorkflow.g:393:4: ( (otherlv_17= RULE_ID ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalWorkflow.g:394:5: (otherlv_17= RULE_ID )
                    	    {
                    	    // InternalWorkflow.g:394:5: (otherlv_17= RULE_ID )
                    	    // InternalWorkflow.g:395:6: otherlv_17= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getDataProcessingRule());
                    	    						}
                    	    					
                    	    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_21); 

                    	    						newLeafNode(otherlv_17, grammarAccess.getDataProcessingAccess().getInArgumentCrossReference_15_2_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    otherlv_18=(Token)match(input,17,FOLLOW_22); 

                    				newLeafNode(otherlv_18, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_15_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:411:3: (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalWorkflow.g:412:4: otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getDataProcessingAccess().getOutKeyword_16_0());
                    			
                    otherlv_20=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_20, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_16_1());
                    			
                    // InternalWorkflow.g:420:4: ( (otherlv_21= RULE_ID ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalWorkflow.g:421:5: (otherlv_21= RULE_ID )
                    	    {
                    	    // InternalWorkflow.g:421:5: (otherlv_21= RULE_ID )
                    	    // InternalWorkflow.g:422:6: otherlv_21= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getDataProcessingRule());
                    	    						}
                    	    					
                    	    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_21); 

                    	    						newLeafNode(otherlv_21, grammarAccess.getDataProcessingAccess().getOutArgumentCrossReference_16_2_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_22=(Token)match(input,17,FOLLOW_23); 

                    				newLeafNode(otherlv_22, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_16_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:438:3: (otherlv_23= 'parameters' otherlv_24= '{' ( (lv_parameter_25_0= ruleParameter ) )* otherlv_26= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalWorkflow.g:439:4: otherlv_23= 'parameters' otherlv_24= '{' ( (lv_parameter_25_0= ruleParameter ) )* otherlv_26= '}'
                    {
                    otherlv_23=(Token)match(input,26,FOLLOW_4); 

                    				newLeafNode(otherlv_23, grammarAccess.getDataProcessingAccess().getParametersKeyword_17_0());
                    			
                    otherlv_24=(Token)match(input,14,FOLLOW_24); 

                    				newLeafNode(otherlv_24, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_17_1());
                    			
                    // InternalWorkflow.g:447:4: ( (lv_parameter_25_0= ruleParameter ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==40||LA11_0==45||LA11_0==49||LA11_0==52||LA11_0==57||LA11_0==61||LA11_0==65||LA11_0==68||LA11_0==72||LA11_0==85||LA11_0==89||LA11_0==92) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalWorkflow.g:448:5: (lv_parameter_25_0= ruleParameter )
                    	    {
                    	    // InternalWorkflow.g:448:5: (lv_parameter_25_0= ruleParameter )
                    	    // InternalWorkflow.g:449:6: lv_parameter_25_0= ruleParameter
                    	    {

                    	    						newCompositeNode(grammarAccess.getDataProcessingAccess().getParameterParameterParserRuleCall_17_2_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
                    	    lv_parameter_25_0=ruleParameter();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDataProcessingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"parameter",
                    	    							lv_parameter_25_0,
                    	    							"xtext.Workflow.Parameter");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,17,FOLLOW_25); 

                    				newLeafNode(otherlv_26, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_17_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:471:3: (otherlv_27= 'contracts' otherlv_28= '{' ( (lv_contract_29_0= ruleContract ) )* otherlv_30= '}' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalWorkflow.g:472:4: otherlv_27= 'contracts' otherlv_28= '{' ( (lv_contract_29_0= ruleContract ) )* otherlv_30= '}'
                    {
                    otherlv_27=(Token)match(input,27,FOLLOW_4); 

                    				newLeafNode(otherlv_27, grammarAccess.getDataProcessingAccess().getContractsKeyword_18_0());
                    			
                    otherlv_28=(Token)match(input,14,FOLLOW_26); 

                    				newLeafNode(otherlv_28, grammarAccess.getDataProcessingAccess().getLeftCurlyBracketKeyword_18_1());
                    			
                    // InternalWorkflow.g:480:4: ( (lv_contract_29_0= ruleContract ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==118) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalWorkflow.g:481:5: (lv_contract_29_0= ruleContract )
                    	    {
                    	    // InternalWorkflow.g:481:5: (lv_contract_29_0= ruleContract )
                    	    // InternalWorkflow.g:482:6: lv_contract_29_0= ruleContract
                    	    {

                    	    						newCompositeNode(grammarAccess.getDataProcessingAccess().getContractContractParserRuleCall_18_2_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_contract_29_0=ruleContract();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDataProcessingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"contract",
                    	    							lv_contract_29_0,
                    	    							"xtext.Workflow.Contract");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,17,FOLLOW_27); 

                    				newLeafNode(otherlv_30, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_18_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:504:3: (otherlv_31= 'initial_accumulated_processing' ( (otherlv_32= RULE_ID ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalWorkflow.g:505:4: otherlv_31= 'initial_accumulated_processing' ( (otherlv_32= RULE_ID ) )
                    {
                    otherlv_31=(Token)match(input,28,FOLLOW_3); 

                    				newLeafNode(otherlv_31, grammarAccess.getDataProcessingAccess().getInitial_accumulated_processingKeyword_19_0());
                    			
                    // InternalWorkflow.g:509:4: ( (otherlv_32= RULE_ID ) )
                    // InternalWorkflow.g:510:5: (otherlv_32= RULE_ID )
                    {
                    // InternalWorkflow.g:510:5: (otherlv_32= RULE_ID )
                    // InternalWorkflow.g:511:6: otherlv_32= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataProcessingRule());
                    						}
                    					
                    otherlv_32=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_32, grammarAccess.getDataProcessingAccess().getInitial_accumulated_processingDataProcessingCrossReference_19_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_33=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_33, grammarAccess.getDataProcessingAccess().getRightCurlyBracketKeyword_20());
            		

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


    // $ANTLR start "entryRulePMMLModel"
    // InternalWorkflow.g:531:1: entryRulePMMLModel returns [EObject current=null] : iv_rulePMMLModel= rulePMMLModel EOF ;
    public final EObject entryRulePMMLModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePMMLModel = null;


        try {
            // InternalWorkflow.g:531:50: (iv_rulePMMLModel= rulePMMLModel EOF )
            // InternalWorkflow.g:532:2: iv_rulePMMLModel= rulePMMLModel EOF
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
    // InternalWorkflow.g:538:1: rulePMMLModel returns [EObject current=null] : (otherlv_0= 'pmmlModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? otherlv_23= 'filePath' ( (lv_filePath_24_0= RULE_STRING ) ) (otherlv_25= 'onlyPredictions' ( (lv_onlyPredictions_26_0= 'true' ) ) )? (otherlv_27= 'test' ( (lv_test_28_0= ruleTest ) ) )? otherlv_29= '}' ) ;
    public final EObject rulePMMLModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_dataProcessingDefinition_4_0=null;
        Token otherlv_5=null;
        Token lv_origin_function_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token lv_filePath_24_0=null;
        Token otherlv_25=null;
        Token lv_onlyPredictions_26_0=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        EObject lv_inputPort_9_0 = null;

        EObject lv_outputPort_13_0 = null;

        EObject lv_test_28_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:544:2: ( (otherlv_0= 'pmmlModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? otherlv_23= 'filePath' ( (lv_filePath_24_0= RULE_STRING ) ) (otherlv_25= 'onlyPredictions' ( (lv_onlyPredictions_26_0= 'true' ) ) )? (otherlv_27= 'test' ( (lv_test_28_0= ruleTest ) ) )? otherlv_29= '}' ) )
            // InternalWorkflow.g:545:2: (otherlv_0= 'pmmlModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? otherlv_23= 'filePath' ( (lv_filePath_24_0= RULE_STRING ) ) (otherlv_25= 'onlyPredictions' ( (lv_onlyPredictions_26_0= 'true' ) ) )? (otherlv_27= 'test' ( (lv_test_28_0= ruleTest ) ) )? otherlv_29= '}' )
            {
            // InternalWorkflow.g:545:2: (otherlv_0= 'pmmlModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? otherlv_23= 'filePath' ( (lv_filePath_24_0= RULE_STRING ) ) (otherlv_25= 'onlyPredictions' ( (lv_onlyPredictions_26_0= 'true' ) ) )? (otherlv_27= 'test' ( (lv_test_28_0= ruleTest ) ) )? otherlv_29= '}' )
            // InternalWorkflow.g:546:3: otherlv_0= 'pmmlModel' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'definition' ( (lv_dataProcessingDefinition_4_0= RULE_ID ) ) otherlv_5= 'origin' ( (lv_origin_function_6_0= RULE_STRING ) ) otherlv_7= 'inputPort' otherlv_8= '{' ( (lv_inputPort_9_0= ruleDataDictionary ) )+ otherlv_10= '}' otherlv_11= 'outputPort' otherlv_12= '{' ( (lv_outputPort_13_0= ruleDataDictionary ) )+ otherlv_14= '}' (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )? (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )? otherlv_23= 'filePath' ( (lv_filePath_24_0= RULE_STRING ) ) (otherlv_25= 'onlyPredictions' ( (lv_onlyPredictions_26_0= 'true' ) ) )? (otherlv_27= 'test' ( (lv_test_28_0= ruleTest ) ) )? otherlv_29= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPMMLModelAccess().getPmmlModelKeyword_0());
            		
            // InternalWorkflow.g:550:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:551:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:551:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:552:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getPMMLModelAccess().getDefinitionKeyword_3());
            		
            // InternalWorkflow.g:576:3: ( (lv_dataProcessingDefinition_4_0= RULE_ID ) )
            // InternalWorkflow.g:577:4: (lv_dataProcessingDefinition_4_0= RULE_ID )
            {
            // InternalWorkflow.g:577:4: (lv_dataProcessingDefinition_4_0= RULE_ID )
            // InternalWorkflow.g:578:5: lv_dataProcessingDefinition_4_0= RULE_ID
            {
            lv_dataProcessingDefinition_4_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_dataProcessingDefinition_4_0, grammarAccess.getPMMLModelAccess().getDataProcessingDefinitionIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPMMLModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dataProcessingDefinition",
            						lv_dataProcessingDefinition_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getPMMLModelAccess().getOriginKeyword_5());
            		
            // InternalWorkflow.g:598:3: ( (lv_origin_function_6_0= RULE_STRING ) )
            // InternalWorkflow.g:599:4: (lv_origin_function_6_0= RULE_STRING )
            {
            // InternalWorkflow.g:599:4: (lv_origin_function_6_0= RULE_STRING )
            // InternalWorkflow.g:600:5: lv_origin_function_6_0= RULE_STRING
            {
            lv_origin_function_6_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_origin_function_6_0, grammarAccess.getPMMLModelAccess().getOrigin_functionSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPMMLModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"origin_function",
            						lv_origin_function_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getPMMLModelAccess().getInputPortKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_8, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalWorkflow.g:624:3: ( (lv_inputPort_9_0= ruleDataDictionary ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==94) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalWorkflow.g:625:4: (lv_inputPort_9_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:625:4: (lv_inputPort_9_0= ruleDataDictionary )
            	    // InternalWorkflow.g:626:5: lv_inputPort_9_0= ruleDataDictionary
            	    {

            	    					newCompositeNode(grammarAccess.getPMMLModelAccess().getInputPortDataDictionaryParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_inputPort_9_0=ruleDataDictionary();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputPort",
            	    						lv_inputPort_9_0,
            	    						"xtext.Workflow.DataDictionary");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_19); 

            			newLeafNode(otherlv_10, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_10());
            		
            otherlv_11=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_11, grammarAccess.getPMMLModelAccess().getOutputPortKeyword_11());
            		
            otherlv_12=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_12, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_12());
            		
            // InternalWorkflow.g:655:3: ( (lv_outputPort_13_0= ruleDataDictionary ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==94) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalWorkflow.g:656:4: (lv_outputPort_13_0= ruleDataDictionary )
            	    {
            	    // InternalWorkflow.g:656:4: (lv_outputPort_13_0= ruleDataDictionary )
            	    // InternalWorkflow.g:657:5: lv_outputPort_13_0= ruleDataDictionary
            	    {

            	    					newCompositeNode(grammarAccess.getPMMLModelAccess().getOutputPortDataDictionaryParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_outputPort_13_0=ruleDataDictionary();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPMMLModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outputPort",
            	    						lv_outputPort_13_0,
            	    						"xtext.Workflow.DataDictionary");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            otherlv_14=(Token)match(input,17,FOLLOW_28); 

            			newLeafNode(otherlv_14, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_14());
            		
            // InternalWorkflow.g:678:3: (otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalWorkflow.g:679:4: otherlv_15= 'in' otherlv_16= '{' ( (otherlv_17= RULE_ID ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,24,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getPMMLModelAccess().getInKeyword_15_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_15_1());
                    			
                    // InternalWorkflow.g:687:4: ( (otherlv_17= RULE_ID ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_ID) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalWorkflow.g:688:5: (otherlv_17= RULE_ID )
                    	    {
                    	    // InternalWorkflow.g:688:5: (otherlv_17= RULE_ID )
                    	    // InternalWorkflow.g:689:6: otherlv_17= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getPMMLModelRule());
                    	    						}
                    	    					
                    	    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_21); 

                    	    						newLeafNode(otherlv_17, grammarAccess.getPMMLModelAccess().getInArgumentCrossReference_15_2_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    otherlv_18=(Token)match(input,17,FOLLOW_29); 

                    				newLeafNode(otherlv_18, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_15_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:705:3: (otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalWorkflow.g:706:4: otherlv_19= 'out' otherlv_20= '{' ( (otherlv_21= RULE_ID ) )+ otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getPMMLModelAccess().getOutKeyword_16_0());
                    			
                    otherlv_20=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_20, grammarAccess.getPMMLModelAccess().getLeftCurlyBracketKeyword_16_1());
                    			
                    // InternalWorkflow.g:714:4: ( (otherlv_21= RULE_ID ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalWorkflow.g:715:5: (otherlv_21= RULE_ID )
                    	    {
                    	    // InternalWorkflow.g:715:5: (otherlv_21= RULE_ID )
                    	    // InternalWorkflow.g:716:6: otherlv_21= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getPMMLModelRule());
                    	    						}
                    	    					
                    	    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_21); 

                    	    						newLeafNode(otherlv_21, grammarAccess.getPMMLModelAccess().getOutArgumentCrossReference_16_2_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_22=(Token)match(input,17,FOLLOW_30); 

                    				newLeafNode(otherlv_22, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_16_3());
                    			

                    }
                    break;

            }

            otherlv_23=(Token)match(input,30,FOLLOW_15); 

            			newLeafNode(otherlv_23, grammarAccess.getPMMLModelAccess().getFilePathKeyword_17());
            		
            // InternalWorkflow.g:736:3: ( (lv_filePath_24_0= RULE_STRING ) )
            // InternalWorkflow.g:737:4: (lv_filePath_24_0= RULE_STRING )
            {
            // InternalWorkflow.g:737:4: (lv_filePath_24_0= RULE_STRING )
            // InternalWorkflow.g:738:5: lv_filePath_24_0= RULE_STRING
            {
            lv_filePath_24_0=(Token)match(input,RULE_STRING,FOLLOW_31); 

            					newLeafNode(lv_filePath_24_0, grammarAccess.getPMMLModelAccess().getFilePathSTRINGTerminalRuleCall_18_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPMMLModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"filePath",
            						lv_filePath_24_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalWorkflow.g:754:3: (otherlv_25= 'onlyPredictions' ( (lv_onlyPredictions_26_0= 'true' ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalWorkflow.g:755:4: otherlv_25= 'onlyPredictions' ( (lv_onlyPredictions_26_0= 'true' ) )
                    {
                    otherlv_25=(Token)match(input,31,FOLLOW_32); 

                    				newLeafNode(otherlv_25, grammarAccess.getPMMLModelAccess().getOnlyPredictionsKeyword_19_0());
                    			
                    // InternalWorkflow.g:759:4: ( (lv_onlyPredictions_26_0= 'true' ) )
                    // InternalWorkflow.g:760:5: (lv_onlyPredictions_26_0= 'true' )
                    {
                    // InternalWorkflow.g:760:5: (lv_onlyPredictions_26_0= 'true' )
                    // InternalWorkflow.g:761:6: lv_onlyPredictions_26_0= 'true'
                    {
                    lv_onlyPredictions_26_0=(Token)match(input,32,FOLLOW_33); 

                    						newLeafNode(lv_onlyPredictions_26_0, grammarAccess.getPMMLModelAccess().getOnlyPredictionsTrueKeyword_19_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPMMLModelRule());
                    						}
                    						setWithLastConsumed(current, "onlyPredictions", lv_onlyPredictions_26_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:774:3: (otherlv_27= 'test' ( (lv_test_28_0= ruleTest ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalWorkflow.g:775:4: otherlv_27= 'test' ( (lv_test_28_0= ruleTest ) )
                    {
                    otherlv_27=(Token)match(input,33,FOLLOW_34); 

                    				newLeafNode(otherlv_27, grammarAccess.getPMMLModelAccess().getTestKeyword_20_0());
                    			
                    // InternalWorkflow.g:779:4: ( (lv_test_28_0= ruleTest ) )
                    // InternalWorkflow.g:780:5: (lv_test_28_0= ruleTest )
                    {
                    // InternalWorkflow.g:780:5: (lv_test_28_0= ruleTest )
                    // InternalWorkflow.g:781:6: lv_test_28_0= ruleTest
                    {

                    						newCompositeNode(grammarAccess.getPMMLModelAccess().getTestTestParserRuleCall_20_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_test_28_0=ruleTest();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPMMLModelRule());
                    						}
                    						set(
                    							current,
                    							"test",
                    							lv_test_28_0,
                    							"xtext.Workflow.Test");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_29=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_29, grammarAccess.getPMMLModelAccess().getRightCurlyBracketKeyword_21());
            		

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


    // $ANTLR start "entryRuleTest"
    // InternalWorkflow.g:807:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalWorkflow.g:807:45: (iv_ruleTest= ruleTest EOF )
            // InternalWorkflow.g:808:2: iv_ruleTest= ruleTest EOF
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
    // InternalWorkflow.g:814:1: ruleTest returns [EObject current=null] : (otherlv_0= 'test' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= RULE_STRING ) ) (otherlv_4= 'trainSize' ( (lv_trainSize_5_0= RULE_EFLOAT ) ) )? (otherlv_6= 'testSize' ( (lv_testSize_7_0= RULE_EFLOAT ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_path_3_0=null;
        Token otherlv_4=null;
        Token lv_trainSize_5_0=null;
        Token otherlv_6=null;
        Token lv_testSize_7_0=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalWorkflow.g:820:2: ( (otherlv_0= 'test' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= RULE_STRING ) ) (otherlv_4= 'trainSize' ( (lv_trainSize_5_0= RULE_EFLOAT ) ) )? (otherlv_6= 'testSize' ( (lv_testSize_7_0= RULE_EFLOAT ) ) )? otherlv_8= '}' ) )
            // InternalWorkflow.g:821:2: (otherlv_0= 'test' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= RULE_STRING ) ) (otherlv_4= 'trainSize' ( (lv_trainSize_5_0= RULE_EFLOAT ) ) )? (otherlv_6= 'testSize' ( (lv_testSize_7_0= RULE_EFLOAT ) ) )? otherlv_8= '}' )
            {
            // InternalWorkflow.g:821:2: (otherlv_0= 'test' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= RULE_STRING ) ) (otherlv_4= 'trainSize' ( (lv_trainSize_5_0= RULE_EFLOAT ) ) )? (otherlv_6= 'testSize' ( (lv_testSize_7_0= RULE_EFLOAT ) ) )? otherlv_8= '}' )
            // InternalWorkflow.g:822:3: otherlv_0= 'test' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= RULE_STRING ) ) (otherlv_4= 'trainSize' ( (lv_trainSize_5_0= RULE_EFLOAT ) ) )? (otherlv_6= 'testSize' ( (lv_testSize_7_0= RULE_EFLOAT ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getTestAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,34,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getTestAccess().getPathKeyword_2());
            		
            // InternalWorkflow.g:834:3: ( (lv_path_3_0= RULE_STRING ) )
            // InternalWorkflow.g:835:4: (lv_path_3_0= RULE_STRING )
            {
            // InternalWorkflow.g:835:4: (lv_path_3_0= RULE_STRING )
            // InternalWorkflow.g:836:5: lv_path_3_0= RULE_STRING
            {
            lv_path_3_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

            					newLeafNode(lv_path_3_0, grammarAccess.getTestAccess().getPathSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTestRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalWorkflow.g:852:3: (otherlv_4= 'trainSize' ( (lv_trainSize_5_0= RULE_EFLOAT ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalWorkflow.g:853:4: otherlv_4= 'trainSize' ( (lv_trainSize_5_0= RULE_EFLOAT ) )
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_37); 

                    				newLeafNode(otherlv_4, grammarAccess.getTestAccess().getTrainSizeKeyword_4_0());
                    			
                    // InternalWorkflow.g:857:4: ( (lv_trainSize_5_0= RULE_EFLOAT ) )
                    // InternalWorkflow.g:858:5: (lv_trainSize_5_0= RULE_EFLOAT )
                    {
                    // InternalWorkflow.g:858:5: (lv_trainSize_5_0= RULE_EFLOAT )
                    // InternalWorkflow.g:859:6: lv_trainSize_5_0= RULE_EFLOAT
                    {
                    lv_trainSize_5_0=(Token)match(input,RULE_EFLOAT,FOLLOW_38); 

                    						newLeafNode(lv_trainSize_5_0, grammarAccess.getTestAccess().getTrainSizeEFloatTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"trainSize",
                    							lv_trainSize_5_0,
                    							"xtext.Workflow.EFloat");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:876:3: (otherlv_6= 'testSize' ( (lv_testSize_7_0= RULE_EFLOAT ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==36) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalWorkflow.g:877:4: otherlv_6= 'testSize' ( (lv_testSize_7_0= RULE_EFLOAT ) )
                    {
                    otherlv_6=(Token)match(input,36,FOLLOW_37); 

                    				newLeafNode(otherlv_6, grammarAccess.getTestAccess().getTestSizeKeyword_5_0());
                    			
                    // InternalWorkflow.g:881:4: ( (lv_testSize_7_0= RULE_EFLOAT ) )
                    // InternalWorkflow.g:882:5: (lv_testSize_7_0= RULE_EFLOAT )
                    {
                    // InternalWorkflow.g:882:5: (lv_testSize_7_0= RULE_EFLOAT )
                    // InternalWorkflow.g:883:6: lv_testSize_7_0= RULE_EFLOAT
                    {
                    lv_testSize_7_0=(Token)match(input,RULE_EFLOAT,FOLLOW_12); 

                    						newLeafNode(lv_testSize_7_0, grammarAccess.getTestAccess().getTestSizeEFloatTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTestRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"testSize",
                    							lv_testSize_7_0,
                    							"xtext.Workflow.EFloat");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTestAccess().getRightCurlyBracketKeyword_6());
            		

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


    // $ANTLR start "entryRuleLink"
    // InternalWorkflow.g:908:1: entryRuleLink returns [EObject current=null] : iv_ruleLink= ruleLink EOF ;
    public final EObject entryRuleLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLink = null;


        try {
            // InternalWorkflow.g:908:45: (iv_ruleLink= ruleLink EOF )
            // InternalWorkflow.g:909:2: iv_ruleLink= ruleLink EOF
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
    // InternalWorkflow.g:915:1: ruleLink returns [EObject current=null] : (otherlv_0= 'link' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'target' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) ;
    public final EObject ruleLink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalWorkflow.g:921:2: ( (otherlv_0= 'link' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'target' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:922:2: (otherlv_0= 'link' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'target' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:922:2: (otherlv_0= 'link' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'target' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            // InternalWorkflow.g:923:3: otherlv_0= 'link' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'target' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLinkAccess().getLinkKeyword_0());
            		
            // InternalWorkflow.g:927:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:928:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:928:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:929:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLinkAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getLinkAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getLinkAccess().getSourceKeyword_3());
            		
            // InternalWorkflow.g:953:3: ( (otherlv_4= RULE_ID ) )
            // InternalWorkflow.g:954:4: (otherlv_4= RULE_ID )
            {
            // InternalWorkflow.g:954:4: (otherlv_4= RULE_ID )
            // InternalWorkflow.g:955:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinkRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_40); 

            					newLeafNode(otherlv_4, grammarAccess.getLinkAccess().getSourceProcessingStepCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getLinkAccess().getTargetKeyword_5());
            		
            // InternalWorkflow.g:970:3: ( (otherlv_6= RULE_ID ) )
            // InternalWorkflow.g:971:4: (otherlv_6= RULE_ID )
            {
            // InternalWorkflow.g:971:4: (otherlv_6= RULE_ID )
            // InternalWorkflow.g:972:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinkRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_6, grammarAccess.getLinkAccess().getTargetProcessingStepCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

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


    // $ANTLR start "entryRuleParameter"
    // InternalWorkflow.g:991:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalWorkflow.g:991:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalWorkflow.g:992:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalWorkflow.g:998:1: ruleParameter returns [EObject current=null] : (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_DiscretizeBin_4= ruleDiscretizeBin | this_ImputeType_5= ruleImputeType | this_CastType_6= ruleCastType | this_FieldRange_7= ruleFieldRange | this_MathOp_8= ruleMathOp | this_Join_9= ruleJoin ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_Map_0 = null;

        EObject this_Primitive_1 = null;

        EObject this_DerivedField_2 = null;

        EObject this_FilterValue_3 = null;

        EObject this_DiscretizeBin_4 = null;

        EObject this_ImputeType_5 = null;

        EObject this_CastType_6 = null;

        EObject this_FieldRange_7 = null;

        EObject this_MathOp_8 = null;

        EObject this_Join_9 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1004:2: ( (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_DiscretizeBin_4= ruleDiscretizeBin | this_ImputeType_5= ruleImputeType | this_CastType_6= ruleCastType | this_FieldRange_7= ruleFieldRange | this_MathOp_8= ruleMathOp | this_Join_9= ruleJoin ) )
            // InternalWorkflow.g:1005:2: (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_DiscretizeBin_4= ruleDiscretizeBin | this_ImputeType_5= ruleImputeType | this_CastType_6= ruleCastType | this_FieldRange_7= ruleFieldRange | this_MathOp_8= ruleMathOp | this_Join_9= ruleJoin )
            {
            // InternalWorkflow.g:1005:2: (this_Map_0= ruleMap | this_Primitive_1= rulePrimitive | this_DerivedField_2= ruleDerivedField | this_FilterValue_3= ruleFilterValue | this_DiscretizeBin_4= ruleDiscretizeBin | this_ImputeType_5= ruleImputeType | this_CastType_6= ruleCastType | this_FieldRange_7= ruleFieldRange | this_MathOp_8= ruleMathOp | this_Join_9= ruleJoin )
            int alt26=10;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt26=1;
                }
                break;
            case 45:
                {
                alt26=2;
                }
                break;
            case 49:
                {
                alt26=3;
                }
                break;
            case 52:
                {
                alt26=4;
                }
                break;
            case 57:
                {
                alt26=5;
                }
                break;
            case 72:
            case 85:
            case 89:
                {
                alt26=6;
                }
                break;
            case 92:
                {
                alt26=7;
                }
                break;
            case 61:
                {
                alt26=8;
                }
                break;
            case 65:
                {
                alt26=9;
                }
                break;
            case 68:
                {
                alt26=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalWorkflow.g:1006:3: this_Map_0= ruleMap
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
                    // InternalWorkflow.g:1015:3: this_Primitive_1= rulePrimitive
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
                    // InternalWorkflow.g:1024:3: this_DerivedField_2= ruleDerivedField
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
                    // InternalWorkflow.g:1033:3: this_FilterValue_3= ruleFilterValue
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
                    // InternalWorkflow.g:1042:3: this_DiscretizeBin_4= ruleDiscretizeBin
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getDiscretizeBinParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_DiscretizeBin_4=ruleDiscretizeBin();

                    state._fsp--;


                    			current = this_DiscretizeBin_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:1051:3: this_ImputeType_5= ruleImputeType
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getImputeTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ImputeType_5=ruleImputeType();

                    state._fsp--;


                    			current = this_ImputeType_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalWorkflow.g:1060:3: this_CastType_6= ruleCastType
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getCastTypeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_CastType_6=ruleCastType();

                    state._fsp--;


                    			current = this_CastType_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalWorkflow.g:1069:3: this_FieldRange_7= ruleFieldRange
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getFieldRangeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_FieldRange_7=ruleFieldRange();

                    state._fsp--;


                    			current = this_FieldRange_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalWorkflow.g:1078:3: this_MathOp_8= ruleMathOp
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getMathOpParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathOp_8=ruleMathOp();

                    state._fsp--;


                    			current = this_MathOp_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalWorkflow.g:1087:3: this_Join_9= ruleJoin
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getJoinParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_Join_9=ruleJoin();

                    state._fsp--;


                    			current = this_Join_9;
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


    // $ANTLR start "entryRuleMap"
    // InternalWorkflow.g:1099:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalWorkflow.g:1099:44: (iv_ruleMap= ruleMap EOF )
            // InternalWorkflow.g:1100:2: iv_ruleMap= ruleMap EOF
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
    // InternalWorkflow.g:1106:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mapDefinition' ( (lv_mapDefinition_4_0= RULE_ID ) ) otherlv_5= 'inValue' ( (lv_inValue_6_0= RULE_STRING ) ) otherlv_7= 'outvalue' ( (lv_outvalue_8_0= RULE_STRING ) ) otherlv_9= 'mapOperation' ( (lv_mapOperation_10_0= ruleMapOperation ) ) otherlv_11= '}' ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_mapDefinition_4_0=null;
        Token otherlv_5=null;
        Token lv_inValue_6_0=null;
        Token otherlv_7=null;
        Token lv_outvalue_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_mapOperation_10_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1112:2: ( (otherlv_0= 'map' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mapDefinition' ( (lv_mapDefinition_4_0= RULE_ID ) ) otherlv_5= 'inValue' ( (lv_inValue_6_0= RULE_STRING ) ) otherlv_7= 'outvalue' ( (lv_outvalue_8_0= RULE_STRING ) ) otherlv_9= 'mapOperation' ( (lv_mapOperation_10_0= ruleMapOperation ) ) otherlv_11= '}' ) )
            // InternalWorkflow.g:1113:2: (otherlv_0= 'map' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mapDefinition' ( (lv_mapDefinition_4_0= RULE_ID ) ) otherlv_5= 'inValue' ( (lv_inValue_6_0= RULE_STRING ) ) otherlv_7= 'outvalue' ( (lv_outvalue_8_0= RULE_STRING ) ) otherlv_9= 'mapOperation' ( (lv_mapOperation_10_0= ruleMapOperation ) ) otherlv_11= '}' )
            {
            // InternalWorkflow.g:1113:2: (otherlv_0= 'map' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mapDefinition' ( (lv_mapDefinition_4_0= RULE_ID ) ) otherlv_5= 'inValue' ( (lv_inValue_6_0= RULE_STRING ) ) otherlv_7= 'outvalue' ( (lv_outvalue_8_0= RULE_STRING ) ) otherlv_9= 'mapOperation' ( (lv_mapOperation_10_0= ruleMapOperation ) ) otherlv_11= '}' )
            // InternalWorkflow.g:1114:3: otherlv_0= 'map' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mapDefinition' ( (lv_mapDefinition_4_0= RULE_ID ) ) otherlv_5= 'inValue' ( (lv_inValue_6_0= RULE_STRING ) ) otherlv_7= 'outvalue' ( (lv_outvalue_8_0= RULE_STRING ) ) otherlv_9= 'mapOperation' ( (lv_mapOperation_10_0= ruleMapOperation ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
            		
            // InternalWorkflow.g:1118:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:1119:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:1119:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:1120:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMapAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMapRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getMapAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getMapAccess().getMapDefinitionKeyword_3());
            		
            // InternalWorkflow.g:1144:3: ( (lv_mapDefinition_4_0= RULE_ID ) )
            // InternalWorkflow.g:1145:4: (lv_mapDefinition_4_0= RULE_ID )
            {
            // InternalWorkflow.g:1145:4: (lv_mapDefinition_4_0= RULE_ID )
            // InternalWorkflow.g:1146:5: lv_mapDefinition_4_0= RULE_ID
            {
            lv_mapDefinition_4_0=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(lv_mapDefinition_4_0, grammarAccess.getMapAccess().getMapDefinitionIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMapRule());
            					}
            					setWithLastConsumed(
            						current,
            						"mapDefinition",
            						lv_mapDefinition_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getMapAccess().getInValueKeyword_5());
            		
            // InternalWorkflow.g:1166:3: ( (lv_inValue_6_0= RULE_STRING ) )
            // InternalWorkflow.g:1167:4: (lv_inValue_6_0= RULE_STRING )
            {
            // InternalWorkflow.g:1167:4: (lv_inValue_6_0= RULE_STRING )
            // InternalWorkflow.g:1168:5: lv_inValue_6_0= RULE_STRING
            {
            lv_inValue_6_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

            					newLeafNode(lv_inValue_6_0, grammarAccess.getMapAccess().getInValueSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMapRule());
            					}
            					setWithLastConsumed(
            						current,
            						"inValue",
            						lv_inValue_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,43,FOLLOW_15); 

            			newLeafNode(otherlv_7, grammarAccess.getMapAccess().getOutvalueKeyword_7());
            		
            // InternalWorkflow.g:1188:3: ( (lv_outvalue_8_0= RULE_STRING ) )
            // InternalWorkflow.g:1189:4: (lv_outvalue_8_0= RULE_STRING )
            {
            // InternalWorkflow.g:1189:4: (lv_outvalue_8_0= RULE_STRING )
            // InternalWorkflow.g:1190:5: lv_outvalue_8_0= RULE_STRING
            {
            lv_outvalue_8_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

            					newLeafNode(lv_outvalue_8_0, grammarAccess.getMapAccess().getOutvalueSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMapRule());
            					}
            					setWithLastConsumed(
            						current,
            						"outvalue",
            						lv_outvalue_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,44,FOLLOW_45); 

            			newLeafNode(otherlv_9, grammarAccess.getMapAccess().getMapOperationKeyword_9());
            		
            // InternalWorkflow.g:1210:3: ( (lv_mapOperation_10_0= ruleMapOperation ) )
            // InternalWorkflow.g:1211:4: (lv_mapOperation_10_0= ruleMapOperation )
            {
            // InternalWorkflow.g:1211:4: (lv_mapOperation_10_0= ruleMapOperation )
            // InternalWorkflow.g:1212:5: lv_mapOperation_10_0= ruleMapOperation
            {

            					newCompositeNode(grammarAccess.getMapAccess().getMapOperationMapOperationEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_12);
            lv_mapOperation_10_0=ruleMapOperation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapRule());
            					}
            					set(
            						current,
            						"mapOperation",
            						lv_mapOperation_10_0,
            						"xtext.Workflow.MapOperation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getMapAccess().getRightCurlyBracketKeyword_11());
            		

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
    // InternalWorkflow.g:1237:1: entryRulePrimitive returns [EObject current=null] : iv_rulePrimitive= rulePrimitive EOF ;
    public final EObject entryRulePrimitive() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitive = null;


        try {
            // InternalWorkflow.g:1237:50: (iv_rulePrimitive= rulePrimitive EOF )
            // InternalWorkflow.g:1238:2: iv_rulePrimitive= rulePrimitive EOF
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
    // InternalWorkflow.g:1244:1: rulePrimitive returns [EObject current=null] : (otherlv_0= 'primitive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'primitiveDef' ( (lv_primitiveDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= RULE_STRING ) ) otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleLibDataType ) ) otherlv_9= '}' ) ;
    public final EObject rulePrimitive() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_primitiveDef_4_0=null;
        Token otherlv_5=null;
        Token lv_value_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_dataType_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1250:2: ( (otherlv_0= 'primitive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'primitiveDef' ( (lv_primitiveDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= RULE_STRING ) ) otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleLibDataType ) ) otherlv_9= '}' ) )
            // InternalWorkflow.g:1251:2: (otherlv_0= 'primitive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'primitiveDef' ( (lv_primitiveDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= RULE_STRING ) ) otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleLibDataType ) ) otherlv_9= '}' )
            {
            // InternalWorkflow.g:1251:2: (otherlv_0= 'primitive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'primitiveDef' ( (lv_primitiveDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= RULE_STRING ) ) otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleLibDataType ) ) otherlv_9= '}' )
            // InternalWorkflow.g:1252:3: otherlv_0= 'primitive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'primitiveDef' ( (lv_primitiveDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= RULE_STRING ) ) otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleLibDataType ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveAccess().getPrimitiveKeyword_0());
            		
            // InternalWorkflow.g:1256:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:1257:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:1257:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:1258:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPrimitiveAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getPrimitiveAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getPrimitiveAccess().getPrimitiveDefKeyword_3());
            		
            // InternalWorkflow.g:1282:3: ( (lv_primitiveDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:1283:4: (lv_primitiveDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:1283:4: (lv_primitiveDef_4_0= RULE_ID )
            // InternalWorkflow.g:1284:5: lv_primitiveDef_4_0= RULE_ID
            {
            lv_primitiveDef_4_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(lv_primitiveDef_4_0, grammarAccess.getPrimitiveAccess().getPrimitiveDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"primitiveDef",
            						lv_primitiveDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,47,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getPrimitiveAccess().getValueKeyword_5());
            		
            // InternalWorkflow.g:1304:3: ( (lv_value_6_0= RULE_STRING ) )
            // InternalWorkflow.g:1305:4: (lv_value_6_0= RULE_STRING )
            {
            // InternalWorkflow.g:1305:4: (lv_value_6_0= RULE_STRING )
            // InternalWorkflow.g:1306:5: lv_value_6_0= RULE_STRING
            {
            lv_value_6_0=(Token)match(input,RULE_STRING,FOLLOW_48); 

            					newLeafNode(lv_value_6_0, grammarAccess.getPrimitiveAccess().getValueSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,48,FOLLOW_49); 

            			newLeafNode(otherlv_7, grammarAccess.getPrimitiveAccess().getDataTypeKeyword_7());
            		
            // InternalWorkflow.g:1326:3: ( (lv_dataType_8_0= ruleLibDataType ) )
            // InternalWorkflow.g:1327:4: (lv_dataType_8_0= ruleLibDataType )
            {
            // InternalWorkflow.g:1327:4: (lv_dataType_8_0= ruleLibDataType )
            // InternalWorkflow.g:1328:5: lv_dataType_8_0= ruleLibDataType
            {

            					newCompositeNode(grammarAccess.getPrimitiveAccess().getDataTypeLibDataTypeEnumRuleCall_8_0());
            				
            pushFollow(FOLLOW_12);
            lv_dataType_8_0=ruleLibDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimitiveRule());
            					}
            					set(
            						current,
            						"dataType",
            						lv_dataType_8_0,
            						"xtext.Workflow.LibDataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getPrimitiveAccess().getRightCurlyBracketKeyword_9());
            		

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
    // InternalWorkflow.g:1353:1: entryRuleDerivedField returns [EObject current=null] : iv_ruleDerivedField= ruleDerivedField EOF ;
    public final EObject entryRuleDerivedField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedField = null;


        try {
            // InternalWorkflow.g:1353:53: (iv_ruleDerivedField= ruleDerivedField EOF )
            // InternalWorkflow.g:1354:2: iv_ruleDerivedField= ruleDerivedField EOF
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
    // InternalWorkflow.g:1360:1: ruleDerivedField returns [EObject current=null] : (otherlv_0= 'derivedField' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedFieldDef' ( (lv_derivedFieldDef_4_0= RULE_ID ) ) otherlv_5= 'der_dataField' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) ;
    public final EObject ruleDerivedField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_derivedFieldDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalWorkflow.g:1366:2: ( (otherlv_0= 'derivedField' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedFieldDef' ( (lv_derivedFieldDef_4_0= RULE_ID ) ) otherlv_5= 'der_dataField' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:1367:2: (otherlv_0= 'derivedField' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedFieldDef' ( (lv_derivedFieldDef_4_0= RULE_ID ) ) otherlv_5= 'der_dataField' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:1367:2: (otherlv_0= 'derivedField' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedFieldDef' ( (lv_derivedFieldDef_4_0= RULE_ID ) ) otherlv_5= 'der_dataField' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            // InternalWorkflow.g:1368:3: otherlv_0= 'derivedField' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedFieldDef' ( (lv_derivedFieldDef_4_0= RULE_ID ) ) otherlv_5= 'der_dataField' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDerivedFieldAccess().getDerivedFieldKeyword_0());
            		
            // InternalWorkflow.g:1372:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:1373:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:1373:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:1374:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDerivedFieldAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getDerivedFieldAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDerivedFieldAccess().getDerivedFieldDefKeyword_3());
            		
            // InternalWorkflow.g:1398:3: ( (lv_derivedFieldDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:1399:4: (lv_derivedFieldDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:1399:4: (lv_derivedFieldDef_4_0= RULE_ID )
            // InternalWorkflow.g:1400:5: lv_derivedFieldDef_4_0= RULE_ID
            {
            lv_derivedFieldDef_4_0=(Token)match(input,RULE_ID,FOLLOW_51); 

            					newLeafNode(lv_derivedFieldDef_4_0, grammarAccess.getDerivedFieldAccess().getDerivedFieldDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"derivedFieldDef",
            						lv_derivedFieldDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getDerivedFieldAccess().getDer_dataFieldKeyword_5());
            		
            // InternalWorkflow.g:1420:3: ( (otherlv_6= RULE_ID ) )
            // InternalWorkflow.g:1421:4: (otherlv_6= RULE_ID )
            {
            // InternalWorkflow.g:1421:4: (otherlv_6= RULE_ID )
            // InternalWorkflow.g:1422:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedFieldRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_6, grammarAccess.getDerivedFieldAccess().getDer_dataFieldDataFieldCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDerivedFieldAccess().getRightCurlyBracketKeyword_7());
            		

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
    // InternalWorkflow.g:1441:1: entryRuleFilterValue returns [EObject current=null] : iv_ruleFilterValue= ruleFilterValue EOF ;
    public final EObject entryRuleFilterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterValue = null;


        try {
            // InternalWorkflow.g:1441:52: (iv_ruleFilterValue= ruleFilterValue EOF )
            // InternalWorkflow.g:1442:2: iv_ruleFilterValue= ruleFilterValue EOF
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
    // InternalWorkflow.g:1448:1: ruleFilterValue returns [EObject current=null] : (otherlv_0= 'filterValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'filterValueDef' ( (lv_filterValueDef_4_0= RULE_ID ) ) (otherlv_5= 'primitives' otherlv_6= '{' ( (lv_primitive_7_0= rulePrimitive ) )* otherlv_8= '}' )? (otherlv_9= 'matchingValues' otherlv_10= '{' ( (lv_matchingvalue_11_0= ruleMatchingValue ) )* otherlv_12= '}' )? (otherlv_13= 'filterType' ( (lv_filterType_14_0= ruleFilterType ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleFilterValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_filterValueDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_primitive_7_0 = null;

        EObject lv_matchingvalue_11_0 = null;

        Enumerator lv_filterType_14_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1454:2: ( (otherlv_0= 'filterValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'filterValueDef' ( (lv_filterValueDef_4_0= RULE_ID ) ) (otherlv_5= 'primitives' otherlv_6= '{' ( (lv_primitive_7_0= rulePrimitive ) )* otherlv_8= '}' )? (otherlv_9= 'matchingValues' otherlv_10= '{' ( (lv_matchingvalue_11_0= ruleMatchingValue ) )* otherlv_12= '}' )? (otherlv_13= 'filterType' ( (lv_filterType_14_0= ruleFilterType ) ) )? otherlv_15= '}' ) )
            // InternalWorkflow.g:1455:2: (otherlv_0= 'filterValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'filterValueDef' ( (lv_filterValueDef_4_0= RULE_ID ) ) (otherlv_5= 'primitives' otherlv_6= '{' ( (lv_primitive_7_0= rulePrimitive ) )* otherlv_8= '}' )? (otherlv_9= 'matchingValues' otherlv_10= '{' ( (lv_matchingvalue_11_0= ruleMatchingValue ) )* otherlv_12= '}' )? (otherlv_13= 'filterType' ( (lv_filterType_14_0= ruleFilterType ) ) )? otherlv_15= '}' )
            {
            // InternalWorkflow.g:1455:2: (otherlv_0= 'filterValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'filterValueDef' ( (lv_filterValueDef_4_0= RULE_ID ) ) (otherlv_5= 'primitives' otherlv_6= '{' ( (lv_primitive_7_0= rulePrimitive ) )* otherlv_8= '}' )? (otherlv_9= 'matchingValues' otherlv_10= '{' ( (lv_matchingvalue_11_0= ruleMatchingValue ) )* otherlv_12= '}' )? (otherlv_13= 'filterType' ( (lv_filterType_14_0= ruleFilterType ) ) )? otherlv_15= '}' )
            // InternalWorkflow.g:1456:3: otherlv_0= 'filterValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'filterValueDef' ( (lv_filterValueDef_4_0= RULE_ID ) ) (otherlv_5= 'primitives' otherlv_6= '{' ( (lv_primitive_7_0= rulePrimitive ) )* otherlv_8= '}' )? (otherlv_9= 'matchingValues' otherlv_10= '{' ( (lv_matchingvalue_11_0= ruleMatchingValue ) )* otherlv_12= '}' )? (otherlv_13= 'filterType' ( (lv_filterType_14_0= ruleFilterType ) ) )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFilterValueAccess().getFilterValueKeyword_0());
            		
            // InternalWorkflow.g:1460:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:1461:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:1461:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:1462:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFilterValueAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getFilterValueAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getFilterValueAccess().getFilterValueDefKeyword_3());
            		
            // InternalWorkflow.g:1486:3: ( (lv_filterValueDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:1487:4: (lv_filterValueDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:1487:4: (lv_filterValueDef_4_0= RULE_ID )
            // InternalWorkflow.g:1488:5: lv_filterValueDef_4_0= RULE_ID
            {
            lv_filterValueDef_4_0=(Token)match(input,RULE_ID,FOLLOW_53); 

            					newLeafNode(lv_filterValueDef_4_0, grammarAccess.getFilterValueAccess().getFilterValueDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"filterValueDef",
            						lv_filterValueDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWorkflow.g:1504:3: (otherlv_5= 'primitives' otherlv_6= '{' ( (lv_primitive_7_0= rulePrimitive ) )* otherlv_8= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==54) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalWorkflow.g:1505:4: otherlv_5= 'primitives' otherlv_6= '{' ( (lv_primitive_7_0= rulePrimitive ) )* otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,54,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getFilterValueAccess().getPrimitivesKeyword_5_0());
                    			
                    otherlv_6=(Token)match(input,14,FOLLOW_54); 

                    				newLeafNode(otherlv_6, grammarAccess.getFilterValueAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalWorkflow.g:1513:4: ( (lv_primitive_7_0= rulePrimitive ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==45) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalWorkflow.g:1514:5: (lv_primitive_7_0= rulePrimitive )
                    	    {
                    	    // InternalWorkflow.g:1514:5: (lv_primitive_7_0= rulePrimitive )
                    	    // InternalWorkflow.g:1515:6: lv_primitive_7_0= rulePrimitive
                    	    {

                    	    						newCompositeNode(grammarAccess.getFilterValueAccess().getPrimitivePrimitiveParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_54);
                    	    lv_primitive_7_0=rulePrimitive();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"primitive",
                    	    							lv_primitive_7_0,
                    	    							"xtext.Workflow.Primitive");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,17,FOLLOW_55); 

                    				newLeafNode(otherlv_8, grammarAccess.getFilterValueAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:1537:3: (otherlv_9= 'matchingValues' otherlv_10= '{' ( (lv_matchingvalue_11_0= ruleMatchingValue ) )* otherlv_12= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==55) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalWorkflow.g:1538:4: otherlv_9= 'matchingValues' otherlv_10= '{' ( (lv_matchingvalue_11_0= ruleMatchingValue ) )* otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,55,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getFilterValueAccess().getMatchingValuesKeyword_6_0());
                    			
                    otherlv_10=(Token)match(input,14,FOLLOW_56); 

                    				newLeafNode(otherlv_10, grammarAccess.getFilterValueAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalWorkflow.g:1546:4: ( (lv_matchingvalue_11_0= ruleMatchingValue ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==74||(LA29_0>=81 && LA29_0<=82)) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalWorkflow.g:1547:5: (lv_matchingvalue_11_0= ruleMatchingValue )
                    	    {
                    	    // InternalWorkflow.g:1547:5: (lv_matchingvalue_11_0= ruleMatchingValue )
                    	    // InternalWorkflow.g:1548:6: lv_matchingvalue_11_0= ruleMatchingValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getFilterValueAccess().getMatchingvalueMatchingValueParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_56);
                    	    lv_matchingvalue_11_0=ruleMatchingValue();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"matchingvalue",
                    	    							lv_matchingvalue_11_0,
                    	    							"xtext.Workflow.MatchingValue");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,17,FOLLOW_57); 

                    				newLeafNode(otherlv_12, grammarAccess.getFilterValueAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:1570:3: (otherlv_13= 'filterType' ( (lv_filterType_14_0= ruleFilterType ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==56) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalWorkflow.g:1571:4: otherlv_13= 'filterType' ( (lv_filterType_14_0= ruleFilterType ) )
                    {
                    otherlv_13=(Token)match(input,56,FOLLOW_58); 

                    				newLeafNode(otherlv_13, grammarAccess.getFilterValueAccess().getFilterTypeKeyword_7_0());
                    			
                    // InternalWorkflow.g:1575:4: ( (lv_filterType_14_0= ruleFilterType ) )
                    // InternalWorkflow.g:1576:5: (lv_filterType_14_0= ruleFilterType )
                    {
                    // InternalWorkflow.g:1576:5: (lv_filterType_14_0= ruleFilterType )
                    // InternalWorkflow.g:1577:6: lv_filterType_14_0= ruleFilterType
                    {

                    						newCompositeNode(grammarAccess.getFilterValueAccess().getFilterTypeFilterTypeEnumRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_filterType_14_0=ruleFilterType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterValueRule());
                    						}
                    						set(
                    							current,
                    							"filterType",
                    							lv_filterType_14_0,
                    							"xtext.Workflow.FilterType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getFilterValueAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleDiscretizeBin"
    // InternalWorkflow.g:1603:1: entryRuleDiscretizeBin returns [EObject current=null] : iv_ruleDiscretizeBin= ruleDiscretizeBin EOF ;
    public final EObject entryRuleDiscretizeBin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiscretizeBin = null;


        try {
            // InternalWorkflow.g:1603:54: (iv_ruleDiscretizeBin= ruleDiscretizeBin EOF )
            // InternalWorkflow.g:1604:2: iv_ruleDiscretizeBin= ruleDiscretizeBin EOF
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
    // InternalWorkflow.g:1610:1: ruleDiscretizeBin returns [EObject current=null] : (otherlv_0= 'discretizeBin' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'discretizeBinDef' ( (lv_discretizeBinDef_4_0= RULE_ID ) ) otherlv_5= 'binValue' ( (lv_binValue_6_0= RULE_STRING ) ) otherlv_7= 'intervals' otherlv_8= '{' ( (lv_interval_9_0= ruleInterval ) )+ otherlv_10= '}' otherlv_11= '}' ) ;
    public final EObject ruleDiscretizeBin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_discretizeBinDef_4_0=null;
        Token otherlv_5=null;
        Token lv_binValue_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_interval_9_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1616:2: ( (otherlv_0= 'discretizeBin' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'discretizeBinDef' ( (lv_discretizeBinDef_4_0= RULE_ID ) ) otherlv_5= 'binValue' ( (lv_binValue_6_0= RULE_STRING ) ) otherlv_7= 'intervals' otherlv_8= '{' ( (lv_interval_9_0= ruleInterval ) )+ otherlv_10= '}' otherlv_11= '}' ) )
            // InternalWorkflow.g:1617:2: (otherlv_0= 'discretizeBin' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'discretizeBinDef' ( (lv_discretizeBinDef_4_0= RULE_ID ) ) otherlv_5= 'binValue' ( (lv_binValue_6_0= RULE_STRING ) ) otherlv_7= 'intervals' otherlv_8= '{' ( (lv_interval_9_0= ruleInterval ) )+ otherlv_10= '}' otherlv_11= '}' )
            {
            // InternalWorkflow.g:1617:2: (otherlv_0= 'discretizeBin' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'discretizeBinDef' ( (lv_discretizeBinDef_4_0= RULE_ID ) ) otherlv_5= 'binValue' ( (lv_binValue_6_0= RULE_STRING ) ) otherlv_7= 'intervals' otherlv_8= '{' ( (lv_interval_9_0= ruleInterval ) )+ otherlv_10= '}' otherlv_11= '}' )
            // InternalWorkflow.g:1618:3: otherlv_0= 'discretizeBin' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'discretizeBinDef' ( (lv_discretizeBinDef_4_0= RULE_ID ) ) otherlv_5= 'binValue' ( (lv_binValue_6_0= RULE_STRING ) ) otherlv_7= 'intervals' otherlv_8= '{' ( (lv_interval_9_0= ruleInterval ) )+ otherlv_10= '}' otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDiscretizeBinAccess().getDiscretizeBinKeyword_0());
            		
            // InternalWorkflow.g:1622:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:1623:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:1623:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:1624:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDiscretizeBinAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDiscretizeBinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getDiscretizeBinAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDiscretizeBinAccess().getDiscretizeBinDefKeyword_3());
            		
            // InternalWorkflow.g:1648:3: ( (lv_discretizeBinDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:1649:4: (lv_discretizeBinDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:1649:4: (lv_discretizeBinDef_4_0= RULE_ID )
            // InternalWorkflow.g:1650:5: lv_discretizeBinDef_4_0= RULE_ID
            {
            lv_discretizeBinDef_4_0=(Token)match(input,RULE_ID,FOLLOW_60); 

            					newLeafNode(lv_discretizeBinDef_4_0, grammarAccess.getDiscretizeBinAccess().getDiscretizeBinDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDiscretizeBinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"discretizeBinDef",
            						lv_discretizeBinDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,59,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getDiscretizeBinAccess().getBinValueKeyword_5());
            		
            // InternalWorkflow.g:1670:3: ( (lv_binValue_6_0= RULE_STRING ) )
            // InternalWorkflow.g:1671:4: (lv_binValue_6_0= RULE_STRING )
            {
            // InternalWorkflow.g:1671:4: (lv_binValue_6_0= RULE_STRING )
            // InternalWorkflow.g:1672:5: lv_binValue_6_0= RULE_STRING
            {
            lv_binValue_6_0=(Token)match(input,RULE_STRING,FOLLOW_61); 

            					newLeafNode(lv_binValue_6_0, grammarAccess.getDiscretizeBinAccess().getBinValueSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDiscretizeBinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"binValue",
            						lv_binValue_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,60,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getDiscretizeBinAccess().getIntervalsKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_62); 

            			newLeafNode(otherlv_8, grammarAccess.getDiscretizeBinAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalWorkflow.g:1696:3: ( (lv_interval_9_0= ruleInterval ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==113) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalWorkflow.g:1697:4: (lv_interval_9_0= ruleInterval )
            	    {
            	    // InternalWorkflow.g:1697:4: (lv_interval_9_0= ruleInterval )
            	    // InternalWorkflow.g:1698:5: lv_interval_9_0= ruleInterval
            	    {

            	    					newCompositeNode(grammarAccess.getDiscretizeBinAccess().getIntervalIntervalParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_63);
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
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_10, grammarAccess.getDiscretizeBinAccess().getRightCurlyBracketKeyword_10());
            		
            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDiscretizeBinAccess().getRightCurlyBracketKeyword_11());
            		

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


    // $ANTLR start "entryRuleFieldRange"
    // InternalWorkflow.g:1727:1: entryRuleFieldRange returns [EObject current=null] : iv_ruleFieldRange= ruleFieldRange EOF ;
    public final EObject entryRuleFieldRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldRange = null;


        try {
            // InternalWorkflow.g:1727:51: (iv_ruleFieldRange= ruleFieldRange EOF )
            // InternalWorkflow.g:1728:2: iv_ruleFieldRange= ruleFieldRange EOF
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
    // InternalWorkflow.g:1734:1: ruleFieldRange returns [EObject current=null] : (otherlv_0= 'fieldRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'dataFields' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )+ otherlv_8= '}' otherlv_9= 'operator' ( (lv_operator_10_0= ruleOperator ) ) otherlv_11= '}' ) ;
    public final EObject ruleFieldRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_fieldDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_operator_10_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1740:2: ( (otherlv_0= 'fieldRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'dataFields' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )+ otherlv_8= '}' otherlv_9= 'operator' ( (lv_operator_10_0= ruleOperator ) ) otherlv_11= '}' ) )
            // InternalWorkflow.g:1741:2: (otherlv_0= 'fieldRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'dataFields' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )+ otherlv_8= '}' otherlv_9= 'operator' ( (lv_operator_10_0= ruleOperator ) ) otherlv_11= '}' )
            {
            // InternalWorkflow.g:1741:2: (otherlv_0= 'fieldRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'dataFields' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )+ otherlv_8= '}' otherlv_9= 'operator' ( (lv_operator_10_0= ruleOperator ) ) otherlv_11= '}' )
            // InternalWorkflow.g:1742:3: otherlv_0= 'fieldRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'dataFields' otherlv_6= '{' ( (otherlv_7= RULE_ID ) )+ otherlv_8= '}' otherlv_9= 'operator' ( (lv_operator_10_0= ruleOperator ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldRangeAccess().getFieldRangeKeyword_0());
            		
            // InternalWorkflow.g:1746:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:1747:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:1747:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:1748:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFieldRangeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_64); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldRangeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,62,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldRangeAccess().getFieldDefKeyword_3());
            		
            // InternalWorkflow.g:1772:3: ( (lv_fieldDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:1773:4: (lv_fieldDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:1773:4: (lv_fieldDef_4_0= RULE_ID )
            // InternalWorkflow.g:1774:5: lv_fieldDef_4_0= RULE_ID
            {
            lv_fieldDef_4_0=(Token)match(input,RULE_ID,FOLLOW_65); 

            					newLeafNode(lv_fieldDef_4_0, grammarAccess.getFieldRangeAccess().getFieldDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"fieldDef",
            						lv_fieldDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,63,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getFieldRangeAccess().getDataFieldsKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getFieldRangeAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:1798:3: ( (otherlv_7= RULE_ID ) )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalWorkflow.g:1799:4: (otherlv_7= RULE_ID )
            	    {
            	    // InternalWorkflow.g:1799:4: (otherlv_7= RULE_ID )
            	    // InternalWorkflow.g:1800:5: otherlv_7= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getFieldRangeRule());
            	    					}
            	    				
            	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_21); 

            	    					newLeafNode(otherlv_7, grammarAccess.getFieldRangeAccess().getDataFieldDataFieldCrossReference_7_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_66); 

            			newLeafNode(otherlv_8, grammarAccess.getFieldRangeAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,64,FOLLOW_67); 

            			newLeafNode(otherlv_9, grammarAccess.getFieldRangeAccess().getOperatorKeyword_9());
            		
            // InternalWorkflow.g:1819:3: ( (lv_operator_10_0= ruleOperator ) )
            // InternalWorkflow.g:1820:4: (lv_operator_10_0= ruleOperator )
            {
            // InternalWorkflow.g:1820:4: (lv_operator_10_0= ruleOperator )
            // InternalWorkflow.g:1821:5: lv_operator_10_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getFieldRangeAccess().getOperatorOperatorEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_12);
            lv_operator_10_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRangeRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_10_0,
            						"xtext.Workflow.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getFieldRangeAccess().getRightCurlyBracketKeyword_11());
            		

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
    // InternalWorkflow.g:1846:1: entryRuleMathOp returns [EObject current=null] : iv_ruleMathOp= ruleMathOp EOF ;
    public final EObject entryRuleMathOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathOp = null;


        try {
            // InternalWorkflow.g:1846:47: (iv_ruleMathOp= ruleMathOp EOF )
            // InternalWorkflow.g:1847:2: iv_ruleMathOp= ruleMathOp EOF
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
    // InternalWorkflow.g:1853:1: ruleMathOp returns [EObject current=null] : (otherlv_0= 'mathOp' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mathOpDef' ( (lv_mathOpDef_4_0= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleMathOperator ) ) otherlv_7= 'operands' otherlv_8= '{' ( (lv_operand_9_0= ruleOperand ) ) ( (lv_operand_10_0= ruleOperand ) ) otherlv_11= '}' otherlv_12= '}' ) ;
    public final EObject ruleMathOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_mathOpDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Enumerator lv_operator_6_0 = null;

        EObject lv_operand_9_0 = null;

        EObject lv_operand_10_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1859:2: ( (otherlv_0= 'mathOp' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mathOpDef' ( (lv_mathOpDef_4_0= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleMathOperator ) ) otherlv_7= 'operands' otherlv_8= '{' ( (lv_operand_9_0= ruleOperand ) ) ( (lv_operand_10_0= ruleOperand ) ) otherlv_11= '}' otherlv_12= '}' ) )
            // InternalWorkflow.g:1860:2: (otherlv_0= 'mathOp' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mathOpDef' ( (lv_mathOpDef_4_0= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleMathOperator ) ) otherlv_7= 'operands' otherlv_8= '{' ( (lv_operand_9_0= ruleOperand ) ) ( (lv_operand_10_0= ruleOperand ) ) otherlv_11= '}' otherlv_12= '}' )
            {
            // InternalWorkflow.g:1860:2: (otherlv_0= 'mathOp' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mathOpDef' ( (lv_mathOpDef_4_0= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleMathOperator ) ) otherlv_7= 'operands' otherlv_8= '{' ( (lv_operand_9_0= ruleOperand ) ) ( (lv_operand_10_0= ruleOperand ) ) otherlv_11= '}' otherlv_12= '}' )
            // InternalWorkflow.g:1861:3: otherlv_0= 'mathOp' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'mathOpDef' ( (lv_mathOpDef_4_0= RULE_ID ) ) otherlv_5= 'operator' ( (lv_operator_6_0= ruleMathOperator ) ) otherlv_7= 'operands' otherlv_8= '{' ( (lv_operand_9_0= ruleOperand ) ) ( (lv_operand_10_0= ruleOperand ) ) otherlv_11= '}' otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMathOpAccess().getMathOpKeyword_0());
            		
            // InternalWorkflow.g:1865:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:1866:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:1866:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:1867:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMathOpAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMathOpRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_68); 

            			newLeafNode(otherlv_2, grammarAccess.getMathOpAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,66,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getMathOpAccess().getMathOpDefKeyword_3());
            		
            // InternalWorkflow.g:1891:3: ( (lv_mathOpDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:1892:4: (lv_mathOpDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:1892:4: (lv_mathOpDef_4_0= RULE_ID )
            // InternalWorkflow.g:1893:5: lv_mathOpDef_4_0= RULE_ID
            {
            lv_mathOpDef_4_0=(Token)match(input,RULE_ID,FOLLOW_66); 

            					newLeafNode(lv_mathOpDef_4_0, grammarAccess.getMathOpAccess().getMathOpDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMathOpRule());
            					}
            					setWithLastConsumed(
            						current,
            						"mathOpDef",
            						lv_mathOpDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,64,FOLLOW_69); 

            			newLeafNode(otherlv_5, grammarAccess.getMathOpAccess().getOperatorKeyword_5());
            		
            // InternalWorkflow.g:1913:3: ( (lv_operator_6_0= ruleMathOperator ) )
            // InternalWorkflow.g:1914:4: (lv_operator_6_0= ruleMathOperator )
            {
            // InternalWorkflow.g:1914:4: (lv_operator_6_0= ruleMathOperator )
            // InternalWorkflow.g:1915:5: lv_operator_6_0= ruleMathOperator
            {

            					newCompositeNode(grammarAccess.getMathOpAccess().getOperatorMathOperatorEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_70);
            lv_operator_6_0=ruleMathOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathOpRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_6_0,
            						"xtext.Workflow.MathOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,67,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getMathOpAccess().getOperandsKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_71); 

            			newLeafNode(otherlv_8, grammarAccess.getMathOpAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalWorkflow.g:1940:3: ( (lv_operand_9_0= ruleOperand ) )
            // InternalWorkflow.g:1941:4: (lv_operand_9_0= ruleOperand )
            {
            // InternalWorkflow.g:1941:4: (lv_operand_9_0= ruleOperand )
            // InternalWorkflow.g:1942:5: lv_operand_9_0= ruleOperand
            {

            					newCompositeNode(grammarAccess.getMathOpAccess().getOperandOperandParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_71);
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

            // InternalWorkflow.g:1959:3: ( (lv_operand_10_0= ruleOperand ) )
            // InternalWorkflow.g:1960:4: (lv_operand_10_0= ruleOperand )
            {
            // InternalWorkflow.g:1960:4: (lv_operand_10_0= ruleOperand )
            // InternalWorkflow.g:1961:5: lv_operand_10_0= ruleOperand
            {

            					newCompositeNode(grammarAccess.getMathOpAccess().getOperandOperandParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_12);
            lv_operand_10_0=ruleOperand();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathOpRule());
            					}
            					add(
            						current,
            						"operand",
            						lv_operand_10_0,
            						"xtext.Workflow.Operand");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_11, grammarAccess.getMathOpAccess().getRightCurlyBracketKeyword_11());
            		
            otherlv_12=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getMathOpAccess().getRightCurlyBracketKeyword_12());
            		

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


    // $ANTLR start "entryRuleJoin"
    // InternalWorkflow.g:1990:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalWorkflow.g:1990:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalWorkflow.g:1991:2: iv_ruleJoin= ruleJoin EOF
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
    // InternalWorkflow.g:1997:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'joinDef' ( (lv_joinDef_4_0= RULE_ID ) ) otherlv_5= 'operands' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) )+ otherlv_8= '}' otherlv_9= '}' ) ;
    public final EObject ruleJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_joinDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_operand_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2003:2: ( (otherlv_0= 'join' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'joinDef' ( (lv_joinDef_4_0= RULE_ID ) ) otherlv_5= 'operands' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) )+ otherlv_8= '}' otherlv_9= '}' ) )
            // InternalWorkflow.g:2004:2: (otherlv_0= 'join' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'joinDef' ( (lv_joinDef_4_0= RULE_ID ) ) otherlv_5= 'operands' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) )+ otherlv_8= '}' otherlv_9= '}' )
            {
            // InternalWorkflow.g:2004:2: (otherlv_0= 'join' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'joinDef' ( (lv_joinDef_4_0= RULE_ID ) ) otherlv_5= 'operands' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) )+ otherlv_8= '}' otherlv_9= '}' )
            // InternalWorkflow.g:2005:3: otherlv_0= 'join' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'joinDef' ( (lv_joinDef_4_0= RULE_ID ) ) otherlv_5= 'operands' otherlv_6= '{' ( (lv_operand_7_0= ruleOperand ) )+ otherlv_8= '}' otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
            		
            // InternalWorkflow.g:2009:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2010:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2010:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:2011:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJoinAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_72); 

            			newLeafNode(otherlv_2, grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,69,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getJoinDefKeyword_3());
            		
            // InternalWorkflow.g:2035:3: ( (lv_joinDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2036:4: (lv_joinDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2036:4: (lv_joinDef_4_0= RULE_ID )
            // InternalWorkflow.g:2037:5: lv_joinDef_4_0= RULE_ID
            {
            lv_joinDef_4_0=(Token)match(input,RULE_ID,FOLLOW_70); 

            					newLeafNode(lv_joinDef_4_0, grammarAccess.getJoinAccess().getJoinDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"joinDef",
            						lv_joinDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,67,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getOperandsKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_71); 

            			newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:2061:3: ( (lv_operand_7_0= ruleOperand ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==70||LA34_0==72) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalWorkflow.g:2062:4: (lv_operand_7_0= ruleOperand )
            	    {
            	    // InternalWorkflow.g:2062:4: (lv_operand_7_0= ruleOperand )
            	    // InternalWorkflow.g:2063:5: lv_operand_7_0= ruleOperand
            	    {

            	    					newCompositeNode(grammarAccess.getJoinAccess().getOperandOperandParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_73);
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
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_8, grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_9());
            		

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


    // $ANTLR start "entryRuleOperand"
    // InternalWorkflow.g:2092:1: entryRuleOperand returns [EObject current=null] : iv_ruleOperand= ruleOperand EOF ;
    public final EObject entryRuleOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperand = null;


        try {
            // InternalWorkflow.g:2092:48: (iv_ruleOperand= ruleOperand EOF )
            // InternalWorkflow.g:2093:2: iv_ruleOperand= ruleOperand EOF
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
    // InternalWorkflow.g:2099:1: ruleOperand returns [EObject current=null] : (this_FixValue_0= ruleFixValue | this_Field_1= ruleField ) ;
    public final EObject ruleOperand() throws RecognitionException {
        EObject current = null;

        EObject this_FixValue_0 = null;

        EObject this_Field_1 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2105:2: ( (this_FixValue_0= ruleFixValue | this_Field_1= ruleField ) )
            // InternalWorkflow.g:2106:2: (this_FixValue_0= ruleFixValue | this_Field_1= ruleField )
            {
            // InternalWorkflow.g:2106:2: (this_FixValue_0= ruleFixValue | this_Field_1= ruleField )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==72) ) {
                alt35=1;
            }
            else if ( (LA35_0==70) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalWorkflow.g:2107:3: this_FixValue_0= ruleFixValue
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
                    // InternalWorkflow.g:2116:3: this_Field_1= ruleField
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


    // $ANTLR start "entryRuleField"
    // InternalWorkflow.g:2128:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalWorkflow.g:2128:46: (iv_ruleField= ruleField EOF )
            // InternalWorkflow.g:2129:2: iv_ruleField= ruleField EOF
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
    // InternalWorkflow.g:2135:1: ruleField returns [EObject current=null] : (otherlv_0= 'field' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'datafield' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_fieldDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalWorkflow.g:2141:2: ( (otherlv_0= 'field' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'datafield' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:2142:2: (otherlv_0= 'field' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'datafield' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:2142:2: (otherlv_0= 'field' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'datafield' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            // InternalWorkflow.g:2143:3: otherlv_0= 'field' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fieldDef' ( (lv_fieldDef_4_0= RULE_ID ) ) otherlv_5= 'datafield' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,70,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldAccess().getFieldKeyword_0());
            		
            // InternalWorkflow.g:2147:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2148:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2148:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:2149:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_64); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,62,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getFieldDefKeyword_3());
            		
            // InternalWorkflow.g:2173:3: ( (lv_fieldDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2174:4: (lv_fieldDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2174:4: (lv_fieldDef_4_0= RULE_ID )
            // InternalWorkflow.g:2175:5: lv_fieldDef_4_0= RULE_ID
            {
            lv_fieldDef_4_0=(Token)match(input,RULE_ID,FOLLOW_74); 

            					newLeafNode(lv_fieldDef_4_0, grammarAccess.getFieldAccess().getFieldDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"fieldDef",
            						lv_fieldDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,71,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getFieldAccess().getDatafieldKeyword_5());
            		
            // InternalWorkflow.g:2195:3: ( (otherlv_6= RULE_ID ) )
            // InternalWorkflow.g:2196:4: (otherlv_6= RULE_ID )
            {
            // InternalWorkflow.g:2196:4: (otherlv_6= RULE_ID )
            // InternalWorkflow.g:2197:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_6, grammarAccess.getFieldAccess().getDatafieldDataFieldCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFieldAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleFixValue"
    // InternalWorkflow.g:2216:1: entryRuleFixValue returns [EObject current=null] : iv_ruleFixValue= ruleFixValue EOF ;
    public final EObject entryRuleFixValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixValue = null;


        try {
            // InternalWorkflow.g:2216:49: (iv_ruleFixValue= ruleFixValue EOF )
            // InternalWorkflow.g:2217:2: iv_ruleFixValue= ruleFixValue EOF
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
    // InternalWorkflow.g:2223:1: ruleFixValue returns [EObject current=null] : (otherlv_0= 'fixValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fixValueDef' ( (lv_fixValueDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= rulePrimitive ) ) otherlv_7= '}' ) ;
    public final EObject ruleFixValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_fixValueDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2229:2: ( (otherlv_0= 'fixValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fixValueDef' ( (lv_fixValueDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= rulePrimitive ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:2230:2: (otherlv_0= 'fixValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fixValueDef' ( (lv_fixValueDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= rulePrimitive ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:2230:2: (otherlv_0= 'fixValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fixValueDef' ( (lv_fixValueDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= rulePrimitive ) ) otherlv_7= '}' )
            // InternalWorkflow.g:2231:3: otherlv_0= 'fixValue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'fixValueDef' ( (lv_fixValueDef_4_0= RULE_ID ) ) otherlv_5= 'value' ( (lv_value_6_0= rulePrimitive ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFixValueAccess().getFixValueKeyword_0());
            		
            // InternalWorkflow.g:2235:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2236:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2236:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:2237:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFixValueAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFixValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_75); 

            			newLeafNode(otherlv_2, grammarAccess.getFixValueAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,73,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getFixValueAccess().getFixValueDefKeyword_3());
            		
            // InternalWorkflow.g:2261:3: ( (lv_fixValueDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2262:4: (lv_fixValueDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2262:4: (lv_fixValueDef_4_0= RULE_ID )
            // InternalWorkflow.g:2263:5: lv_fixValueDef_4_0= RULE_ID
            {
            lv_fixValueDef_4_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(lv_fixValueDef_4_0, grammarAccess.getFixValueAccess().getFixValueDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFixValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"fixValueDef",
            						lv_fixValueDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,47,FOLLOW_76); 

            			newLeafNode(otherlv_5, grammarAccess.getFixValueAccess().getValueKeyword_5());
            		
            // InternalWorkflow.g:2283:3: ( (lv_value_6_0= rulePrimitive ) )
            // InternalWorkflow.g:2284:4: (lv_value_6_0= rulePrimitive )
            {
            // InternalWorkflow.g:2284:4: (lv_value_6_0= rulePrimitive )
            // InternalWorkflow.g:2285:5: lv_value_6_0= rulePrimitive
            {

            					newCompositeNode(grammarAccess.getFixValueAccess().getValuePrimitiveParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_12);
            lv_value_6_0=rulePrimitive();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFixValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_6_0,
            						"xtext.Workflow.Primitive");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFixValueAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleMatchingValue"
    // InternalWorkflow.g:2310:1: entryRuleMatchingValue returns [EObject current=null] : iv_ruleMatchingValue= ruleMatchingValue EOF ;
    public final EObject entryRuleMatchingValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatchingValue = null;


        try {
            // InternalWorkflow.g:2310:54: (iv_ruleMatchingValue= ruleMatchingValue EOF )
            // InternalWorkflow.g:2311:2: iv_ruleMatchingValue= ruleMatchingValue EOF
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
    // InternalWorkflow.g:2317:1: ruleMatchingValue returns [EObject current=null] : (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange ) ;
    public final EObject ruleMatchingValue() throws RecognitionException {
        EObject current = null;

        EObject this_Range_0 = null;

        EObject this_SpecialValues_1 = null;

        EObject this_DateRange_2 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2323:2: ( (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange ) )
            // InternalWorkflow.g:2324:2: (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange )
            {
            // InternalWorkflow.g:2324:2: (this_Range_0= ruleRange | this_SpecialValues_1= ruleSpecialValues | this_DateRange_2= ruleDateRange )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt36=1;
                }
                break;
            case 82:
                {
                alt36=2;
                }
                break;
            case 81:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalWorkflow.g:2325:3: this_Range_0= ruleRange
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
                    // InternalWorkflow.g:2334:3: this_SpecialValues_1= ruleSpecialValues
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
                    // InternalWorkflow.g:2343:3: this_DateRange_2= ruleDateRange
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


    // $ANTLR start "entryRuleRange"
    // InternalWorkflow.g:2355:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalWorkflow.g:2355:46: (iv_ruleRange= ruleRange EOF )
            // InternalWorkflow.g:2356:2: iv_ruleRange= ruleRange EOF
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
    // InternalWorkflow.g:2362:1: ruleRange returns [EObject current=null] : (otherlv_0= 'range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_EFLOAT ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_EFLOAT ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? (otherlv_11= 'minInfinity' ( (lv_minInfinity_12_0= 'true' ) ) )? (otherlv_13= 'maxInfinity' ( (lv_maxInfinity_14_0= 'true' ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_rangeDef_4_0=null;
        Token otherlv_5=null;
        Token lv_min_6_0=null;
        Token otherlv_7=null;
        Token lv_max_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_minInfinity_12_0=null;
        Token otherlv_13=null;
        Token lv_maxInfinity_14_0=null;
        Token otherlv_15=null;
        Enumerator lv_clousure_10_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2368:2: ( (otherlv_0= 'range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_EFLOAT ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_EFLOAT ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? (otherlv_11= 'minInfinity' ( (lv_minInfinity_12_0= 'true' ) ) )? (otherlv_13= 'maxInfinity' ( (lv_maxInfinity_14_0= 'true' ) ) )? otherlv_15= '}' ) )
            // InternalWorkflow.g:2369:2: (otherlv_0= 'range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_EFLOAT ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_EFLOAT ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? (otherlv_11= 'minInfinity' ( (lv_minInfinity_12_0= 'true' ) ) )? (otherlv_13= 'maxInfinity' ( (lv_maxInfinity_14_0= 'true' ) ) )? otherlv_15= '}' )
            {
            // InternalWorkflow.g:2369:2: (otherlv_0= 'range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_EFLOAT ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_EFLOAT ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? (otherlv_11= 'minInfinity' ( (lv_minInfinity_12_0= 'true' ) ) )? (otherlv_13= 'maxInfinity' ( (lv_maxInfinity_14_0= 'true' ) ) )? otherlv_15= '}' )
            // InternalWorkflow.g:2370:3: otherlv_0= 'range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_EFLOAT ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_EFLOAT ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? (otherlv_11= 'minInfinity' ( (lv_minInfinity_12_0= 'true' ) ) )? (otherlv_13= 'maxInfinity' ( (lv_maxInfinity_14_0= 'true' ) ) )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getRangeKeyword_0());
            		
            // InternalWorkflow.g:2374:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2375:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2375:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:2376:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRangeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_77); 

            			newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,75,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getRangeAccess().getRangeDefKeyword_3());
            		
            // InternalWorkflow.g:2400:3: ( (lv_rangeDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2401:4: (lv_rangeDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2401:4: (lv_rangeDef_4_0= RULE_ID )
            // InternalWorkflow.g:2402:5: lv_rangeDef_4_0= RULE_ID
            {
            lv_rangeDef_4_0=(Token)match(input,RULE_ID,FOLLOW_78); 

            					newLeafNode(lv_rangeDef_4_0, grammarAccess.getRangeAccess().getRangeDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rangeDef",
            						lv_rangeDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,76,FOLLOW_37); 

            			newLeafNode(otherlv_5, grammarAccess.getRangeAccess().getMinKeyword_5());
            		
            // InternalWorkflow.g:2422:3: ( (lv_min_6_0= RULE_EFLOAT ) )
            // InternalWorkflow.g:2423:4: (lv_min_6_0= RULE_EFLOAT )
            {
            // InternalWorkflow.g:2423:4: (lv_min_6_0= RULE_EFLOAT )
            // InternalWorkflow.g:2424:5: lv_min_6_0= RULE_EFLOAT
            {
            lv_min_6_0=(Token)match(input,RULE_EFLOAT,FOLLOW_79); 

            					newLeafNode(lv_min_6_0, grammarAccess.getRangeAccess().getMinEFloatTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"min",
            						lv_min_6_0,
            						"xtext.Workflow.EFloat");
            				

            }


            }

            otherlv_7=(Token)match(input,77,FOLLOW_37); 

            			newLeafNode(otherlv_7, grammarAccess.getRangeAccess().getMaxKeyword_7());
            		
            // InternalWorkflow.g:2444:3: ( (lv_max_8_0= RULE_EFLOAT ) )
            // InternalWorkflow.g:2445:4: (lv_max_8_0= RULE_EFLOAT )
            {
            // InternalWorkflow.g:2445:4: (lv_max_8_0= RULE_EFLOAT )
            // InternalWorkflow.g:2446:5: lv_max_8_0= RULE_EFLOAT
            {
            lv_max_8_0=(Token)match(input,RULE_EFLOAT,FOLLOW_80); 

            					newLeafNode(lv_max_8_0, grammarAccess.getRangeAccess().getMaxEFloatTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"max",
            						lv_max_8_0,
            						"xtext.Workflow.EFloat");
            				

            }


            }

            // InternalWorkflow.g:2462:3: (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==78) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalWorkflow.g:2463:4: otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) )
                    {
                    otherlv_9=(Token)match(input,78,FOLLOW_81); 

                    				newLeafNode(otherlv_9, grammarAccess.getRangeAccess().getClousureKeyword_9_0());
                    			
                    // InternalWorkflow.g:2467:4: ( (lv_clousure_10_0= ruleClosureType ) )
                    // InternalWorkflow.g:2468:5: (lv_clousure_10_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:2468:5: (lv_clousure_10_0= ruleClosureType )
                    // InternalWorkflow.g:2469:6: lv_clousure_10_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getRangeAccess().getClousureClosureTypeEnumRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_82);
                    lv_clousure_10_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_10_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2487:3: (otherlv_11= 'minInfinity' ( (lv_minInfinity_12_0= 'true' ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==79) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalWorkflow.g:2488:4: otherlv_11= 'minInfinity' ( (lv_minInfinity_12_0= 'true' ) )
                    {
                    otherlv_11=(Token)match(input,79,FOLLOW_32); 

                    				newLeafNode(otherlv_11, grammarAccess.getRangeAccess().getMinInfinityKeyword_10_0());
                    			
                    // InternalWorkflow.g:2492:4: ( (lv_minInfinity_12_0= 'true' ) )
                    // InternalWorkflow.g:2493:5: (lv_minInfinity_12_0= 'true' )
                    {
                    // InternalWorkflow.g:2493:5: (lv_minInfinity_12_0= 'true' )
                    // InternalWorkflow.g:2494:6: lv_minInfinity_12_0= 'true'
                    {
                    lv_minInfinity_12_0=(Token)match(input,32,FOLLOW_83); 

                    						newLeafNode(lv_minInfinity_12_0, grammarAccess.getRangeAccess().getMinInfinityTrueKeyword_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRangeRule());
                    						}
                    						setWithLastConsumed(current, "minInfinity", lv_minInfinity_12_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:2507:3: (otherlv_13= 'maxInfinity' ( (lv_maxInfinity_14_0= 'true' ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==80) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalWorkflow.g:2508:4: otherlv_13= 'maxInfinity' ( (lv_maxInfinity_14_0= 'true' ) )
                    {
                    otherlv_13=(Token)match(input,80,FOLLOW_32); 

                    				newLeafNode(otherlv_13, grammarAccess.getRangeAccess().getMaxInfinityKeyword_11_0());
                    			
                    // InternalWorkflow.g:2512:4: ( (lv_maxInfinity_14_0= 'true' ) )
                    // InternalWorkflow.g:2513:5: (lv_maxInfinity_14_0= 'true' )
                    {
                    // InternalWorkflow.g:2513:5: (lv_maxInfinity_14_0= 'true' )
                    // InternalWorkflow.g:2514:6: lv_maxInfinity_14_0= 'true'
                    {
                    lv_maxInfinity_14_0=(Token)match(input,32,FOLLOW_12); 

                    						newLeafNode(lv_maxInfinity_14_0, grammarAccess.getRangeAccess().getMaxInfinityTrueKeyword_11_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRangeRule());
                    						}
                    						setWithLastConsumed(current, "maxInfinity", lv_maxInfinity_14_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getRangeAccess().getRightCurlyBracketKeyword_12());
            		

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


    // $ANTLR start "entryRuleDateRange"
    // InternalWorkflow.g:2535:1: entryRuleDateRange returns [EObject current=null] : iv_ruleDateRange= ruleDateRange EOF ;
    public final EObject entryRuleDateRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateRange = null;


        try {
            // InternalWorkflow.g:2535:50: (iv_ruleDateRange= ruleDateRange EOF )
            // InternalWorkflow.g:2536:2: iv_ruleDateRange= ruleDateRange EOF
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
    // InternalWorkflow.g:2542:1: ruleDateRange returns [EObject current=null] : (otherlv_0= 'dateRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_STRING ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_STRING ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? otherlv_11= '}' ) ;
    public final EObject ruleDateRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_rangeDef_4_0=null;
        Token otherlv_5=null;
        Token lv_min_6_0=null;
        Token otherlv_7=null;
        Token lv_max_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_clousure_10_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2548:2: ( (otherlv_0= 'dateRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_STRING ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_STRING ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? otherlv_11= '}' ) )
            // InternalWorkflow.g:2549:2: (otherlv_0= 'dateRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_STRING ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_STRING ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? otherlv_11= '}' )
            {
            // InternalWorkflow.g:2549:2: (otherlv_0= 'dateRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_STRING ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_STRING ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? otherlv_11= '}' )
            // InternalWorkflow.g:2550:3: otherlv_0= 'dateRange' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'rangeDef' ( (lv_rangeDef_4_0= RULE_ID ) ) otherlv_5= 'min' ( (lv_min_6_0= RULE_STRING ) ) otherlv_7= 'max' ( (lv_max_8_0= RULE_STRING ) ) (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDateRangeAccess().getDateRangeKeyword_0());
            		
            // InternalWorkflow.g:2554:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2555:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2555:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:2556:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDateRangeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_77); 

            			newLeafNode(otherlv_2, grammarAccess.getDateRangeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,75,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDateRangeAccess().getRangeDefKeyword_3());
            		
            // InternalWorkflow.g:2580:3: ( (lv_rangeDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2581:4: (lv_rangeDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2581:4: (lv_rangeDef_4_0= RULE_ID )
            // InternalWorkflow.g:2582:5: lv_rangeDef_4_0= RULE_ID
            {
            lv_rangeDef_4_0=(Token)match(input,RULE_ID,FOLLOW_78); 

            					newLeafNode(lv_rangeDef_4_0, grammarAccess.getDateRangeAccess().getRangeDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rangeDef",
            						lv_rangeDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,76,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getDateRangeAccess().getMinKeyword_5());
            		
            // InternalWorkflow.g:2602:3: ( (lv_min_6_0= RULE_STRING ) )
            // InternalWorkflow.g:2603:4: (lv_min_6_0= RULE_STRING )
            {
            // InternalWorkflow.g:2603:4: (lv_min_6_0= RULE_STRING )
            // InternalWorkflow.g:2604:5: lv_min_6_0= RULE_STRING
            {
            lv_min_6_0=(Token)match(input,RULE_STRING,FOLLOW_79); 

            					newLeafNode(lv_min_6_0, grammarAccess.getDateRangeAccess().getMinSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"min",
            						lv_min_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,77,FOLLOW_15); 

            			newLeafNode(otherlv_7, grammarAccess.getDateRangeAccess().getMaxKeyword_7());
            		
            // InternalWorkflow.g:2624:3: ( (lv_max_8_0= RULE_STRING ) )
            // InternalWorkflow.g:2625:4: (lv_max_8_0= RULE_STRING )
            {
            // InternalWorkflow.g:2625:4: (lv_max_8_0= RULE_STRING )
            // InternalWorkflow.g:2626:5: lv_max_8_0= RULE_STRING
            {
            lv_max_8_0=(Token)match(input,RULE_STRING,FOLLOW_84); 

            					newLeafNode(lv_max_8_0, grammarAccess.getDateRangeAccess().getMaxSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateRangeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"max",
            						lv_max_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalWorkflow.g:2642:3: (otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==78) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalWorkflow.g:2643:4: otherlv_9= 'clousure' ( (lv_clousure_10_0= ruleClosureType ) )
                    {
                    otherlv_9=(Token)match(input,78,FOLLOW_81); 

                    				newLeafNode(otherlv_9, grammarAccess.getDateRangeAccess().getClousureKeyword_9_0());
                    			
                    // InternalWorkflow.g:2647:4: ( (lv_clousure_10_0= ruleClosureType ) )
                    // InternalWorkflow.g:2648:5: (lv_clousure_10_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:2648:5: (lv_clousure_10_0= ruleClosureType )
                    // InternalWorkflow.g:2649:6: lv_clousure_10_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getDateRangeAccess().getClousureClosureTypeEnumRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_clousure_10_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDateRangeRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_10_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDateRangeAccess().getRightCurlyBracketKeyword_10());
            		

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


    // $ANTLR start "entryRuleSpecialValues"
    // InternalWorkflow.g:2675:1: entryRuleSpecialValues returns [EObject current=null] : iv_ruleSpecialValues= ruleSpecialValues EOF ;
    public final EObject entryRuleSpecialValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecialValues = null;


        try {
            // InternalWorkflow.g:2675:54: (iv_ruleSpecialValues= ruleSpecialValues EOF )
            // InternalWorkflow.g:2676:2: iv_ruleSpecialValues= ruleSpecialValues EOF
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
    // InternalWorkflow.g:2682:1: ruleSpecialValues returns [EObject current=null] : (otherlv_0= 'specialValues' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'specialValuesDef' ( (lv_specialValuesDef_4_0= RULE_ID ) ) otherlv_5= 'specialType' ( (lv_specialType_6_0= ruleSpecialValue ) ) otherlv_7= '}' ) ;
    public final EObject ruleSpecialValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_specialValuesDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_specialType_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2688:2: ( (otherlv_0= 'specialValues' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'specialValuesDef' ( (lv_specialValuesDef_4_0= RULE_ID ) ) otherlv_5= 'specialType' ( (lv_specialType_6_0= ruleSpecialValue ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:2689:2: (otherlv_0= 'specialValues' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'specialValuesDef' ( (lv_specialValuesDef_4_0= RULE_ID ) ) otherlv_5= 'specialType' ( (lv_specialType_6_0= ruleSpecialValue ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:2689:2: (otherlv_0= 'specialValues' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'specialValuesDef' ( (lv_specialValuesDef_4_0= RULE_ID ) ) otherlv_5= 'specialType' ( (lv_specialType_6_0= ruleSpecialValue ) ) otherlv_7= '}' )
            // InternalWorkflow.g:2690:3: otherlv_0= 'specialValues' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'specialValuesDef' ( (lv_specialValuesDef_4_0= RULE_ID ) ) otherlv_5= 'specialType' ( (lv_specialType_6_0= ruleSpecialValue ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSpecialValuesAccess().getSpecialValuesKeyword_0());
            		
            // InternalWorkflow.g:2694:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2695:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2695:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:2696:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSpecialValuesAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecialValuesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_85); 

            			newLeafNode(otherlv_2, grammarAccess.getSpecialValuesAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,83,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getSpecialValuesAccess().getSpecialValuesDefKeyword_3());
            		
            // InternalWorkflow.g:2720:3: ( (lv_specialValuesDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2721:4: (lv_specialValuesDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2721:4: (lv_specialValuesDef_4_0= RULE_ID )
            // InternalWorkflow.g:2722:5: lv_specialValuesDef_4_0= RULE_ID
            {
            lv_specialValuesDef_4_0=(Token)match(input,RULE_ID,FOLLOW_86); 

            					newLeafNode(lv_specialValuesDef_4_0, grammarAccess.getSpecialValuesAccess().getSpecialValuesDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecialValuesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"specialValuesDef",
            						lv_specialValuesDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,84,FOLLOW_87); 

            			newLeafNode(otherlv_5, grammarAccess.getSpecialValuesAccess().getSpecialTypeKeyword_5());
            		
            // InternalWorkflow.g:2742:3: ( (lv_specialType_6_0= ruleSpecialValue ) )
            // InternalWorkflow.g:2743:4: (lv_specialType_6_0= ruleSpecialValue )
            {
            // InternalWorkflow.g:2743:4: (lv_specialType_6_0= ruleSpecialValue )
            // InternalWorkflow.g:2744:5: lv_specialType_6_0= ruleSpecialValue
            {

            					newCompositeNode(grammarAccess.getSpecialValuesAccess().getSpecialTypeSpecialValueEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_12);
            lv_specialType_6_0=ruleSpecialValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecialValuesRule());
            					}
            					set(
            						current,
            						"specialType",
            						lv_specialType_6_0,
            						"xtext.Workflow.SpecialValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getSpecialValuesAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleImputeType"
    // InternalWorkflow.g:2769:1: entryRuleImputeType returns [EObject current=null] : iv_ruleImputeType= ruleImputeType EOF ;
    public final EObject entryRuleImputeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImputeType = null;


        try {
            // InternalWorkflow.g:2769:51: (iv_ruleImputeType= ruleImputeType EOF )
            // InternalWorkflow.g:2770:2: iv_ruleImputeType= ruleImputeType EOF
            {
             newCompositeNode(grammarAccess.getImputeTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImputeType=ruleImputeType();

            state._fsp--;

             current =iv_ruleImputeType; 
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
    // $ANTLR end "entryRuleImputeType"


    // $ANTLR start "ruleImputeType"
    // InternalWorkflow.g:2776:1: ruleImputeType returns [EObject current=null] : (this_DerivedValue_0= ruleDerivedValue | this_NumOp_1= ruleNumOp | this_FixValue_2= ruleFixValue ) ;
    public final EObject ruleImputeType() throws RecognitionException {
        EObject current = null;

        EObject this_DerivedValue_0 = null;

        EObject this_NumOp_1 = null;

        EObject this_FixValue_2 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2782:2: ( (this_DerivedValue_0= ruleDerivedValue | this_NumOp_1= ruleNumOp | this_FixValue_2= ruleFixValue ) )
            // InternalWorkflow.g:2783:2: (this_DerivedValue_0= ruleDerivedValue | this_NumOp_1= ruleNumOp | this_FixValue_2= ruleFixValue )
            {
            // InternalWorkflow.g:2783:2: (this_DerivedValue_0= ruleDerivedValue | this_NumOp_1= ruleNumOp | this_FixValue_2= ruleFixValue )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt41=1;
                }
                break;
            case 89:
                {
                alt41=2;
                }
                break;
            case 72:
                {
                alt41=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalWorkflow.g:2784:3: this_DerivedValue_0= ruleDerivedValue
                    {

                    			newCompositeNode(grammarAccess.getImputeTypeAccess().getDerivedValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DerivedValue_0=ruleDerivedValue();

                    state._fsp--;


                    			current = this_DerivedValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:2793:3: this_NumOp_1= ruleNumOp
                    {

                    			newCompositeNode(grammarAccess.getImputeTypeAccess().getNumOpParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumOp_1=ruleNumOp();

                    state._fsp--;


                    			current = this_NumOp_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:2802:3: this_FixValue_2= ruleFixValue
                    {

                    			newCompositeNode(grammarAccess.getImputeTypeAccess().getFixValueParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixValue_2=ruleFixValue();

                    state._fsp--;


                    			current = this_FixValue_2;
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
    // $ANTLR end "ruleImputeType"


    // $ANTLR start "entryRuleDerivedValue"
    // InternalWorkflow.g:2814:1: entryRuleDerivedValue returns [EObject current=null] : iv_ruleDerivedValue= ruleDerivedValue EOF ;
    public final EObject entryRuleDerivedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedValue = null;


        try {
            // InternalWorkflow.g:2814:53: (iv_ruleDerivedValue= ruleDerivedValue EOF )
            // InternalWorkflow.g:2815:2: iv_ruleDerivedValue= ruleDerivedValue EOF
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
    // InternalWorkflow.g:2821:1: ruleDerivedValue returns [EObject current=null] : (otherlv_0= 'derivedValue' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedValueDef' ( (lv_derivedValueDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDerivedType ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleDerivedValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_imp_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_derivedValueDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_type_6_0 = null;

        Enumerator lv_imputeValue_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2827:2: ( (otherlv_0= 'derivedValue' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedValueDef' ( (lv_derivedValueDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDerivedType ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' ) )
            // InternalWorkflow.g:2828:2: (otherlv_0= 'derivedValue' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedValueDef' ( (lv_derivedValueDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDerivedType ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' )
            {
            // InternalWorkflow.g:2828:2: (otherlv_0= 'derivedValue' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedValueDef' ( (lv_derivedValueDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDerivedType ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' )
            // InternalWorkflow.g:2829:3: otherlv_0= 'derivedValue' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'derivedValueDef' ( (lv_derivedValueDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDerivedType ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDerivedValueAccess().getDerivedValueKeyword_0());
            		
            // InternalWorkflow.g:2833:3: ( (lv_imp_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2834:4: (lv_imp_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2834:4: (lv_imp_name_1_0= RULE_ID )
            // InternalWorkflow.g:2835:5: lv_imp_name_1_0= RULE_ID
            {
            lv_imp_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_imp_name_1_0, grammarAccess.getDerivedValueAccess().getImp_nameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imp_name",
            						lv_imp_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_88); 

            			newLeafNode(otherlv_2, grammarAccess.getDerivedValueAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,86,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDerivedValueAccess().getDerivedValueDefKeyword_3());
            		
            // InternalWorkflow.g:2859:3: ( (lv_derivedValueDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2860:4: (lv_derivedValueDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2860:4: (lv_derivedValueDef_4_0= RULE_ID )
            // InternalWorkflow.g:2861:5: lv_derivedValueDef_4_0= RULE_ID
            {
            lv_derivedValueDef_4_0=(Token)match(input,RULE_ID,FOLLOW_89); 

            					newLeafNode(lv_derivedValueDef_4_0, grammarAccess.getDerivedValueAccess().getDerivedValueDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"derivedValueDef",
            						lv_derivedValueDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,87,FOLLOW_90); 

            			newLeafNode(otherlv_5, grammarAccess.getDerivedValueAccess().getTypeKeyword_5());
            		
            // InternalWorkflow.g:2881:3: ( (lv_type_6_0= ruleDerivedType ) )
            // InternalWorkflow.g:2882:4: (lv_type_6_0= ruleDerivedType )
            {
            // InternalWorkflow.g:2882:4: (lv_type_6_0= ruleDerivedType )
            // InternalWorkflow.g:2883:5: lv_type_6_0= ruleDerivedType
            {

            					newCompositeNode(grammarAccess.getDerivedValueAccess().getTypeDerivedTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_91);
            lv_type_6_0=ruleDerivedType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedValueRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"xtext.Workflow.DerivedType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:2900:3: (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==88) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalWorkflow.g:2901:4: otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) )
                    {
                    otherlv_7=(Token)match(input,88,FOLLOW_87); 

                    				newLeafNode(otherlv_7, grammarAccess.getDerivedValueAccess().getImputeValueKeyword_7_0());
                    			
                    // InternalWorkflow.g:2905:4: ( (lv_imputeValue_8_0= ruleSpecialValue ) )
                    // InternalWorkflow.g:2906:5: (lv_imputeValue_8_0= ruleSpecialValue )
                    {
                    // InternalWorkflow.g:2906:5: (lv_imputeValue_8_0= ruleSpecialValue )
                    // InternalWorkflow.g:2907:6: lv_imputeValue_8_0= ruleSpecialValue
                    {

                    						newCompositeNode(grammarAccess.getDerivedValueAccess().getImputeValueSpecialValueEnumRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_imputeValue_8_0=ruleSpecialValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDerivedValueRule());
                    						}
                    						set(
                    							current,
                    							"imputeValue",
                    							lv_imputeValue_8_0,
                    							"xtext.Workflow.SpecialValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getDerivedValueAccess().getRightCurlyBracketKeyword_8());
            		

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
    // InternalWorkflow.g:2933:1: entryRuleNumOp returns [EObject current=null] : iv_ruleNumOp= ruleNumOp EOF ;
    public final EObject entryRuleNumOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumOp = null;


        try {
            // InternalWorkflow.g:2933:46: (iv_ruleNumOp= ruleNumOp EOF )
            // InternalWorkflow.g:2934:2: iv_ruleNumOp= ruleNumOp EOF
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
    // InternalWorkflow.g:2940:1: ruleNumOp returns [EObject current=null] : (otherlv_0= 'numOp' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'numOpDef' ( (lv_numOpDef_4_0= RULE_ID ) ) otherlv_5= 'operation' ( (lv_operation_6_0= ruleOperation ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleNumOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_imp_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_numOpDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_operation_6_0 = null;

        Enumerator lv_imputeValue_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2946:2: ( (otherlv_0= 'numOp' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'numOpDef' ( (lv_numOpDef_4_0= RULE_ID ) ) otherlv_5= 'operation' ( (lv_operation_6_0= ruleOperation ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' ) )
            // InternalWorkflow.g:2947:2: (otherlv_0= 'numOp' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'numOpDef' ( (lv_numOpDef_4_0= RULE_ID ) ) otherlv_5= 'operation' ( (lv_operation_6_0= ruleOperation ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' )
            {
            // InternalWorkflow.g:2947:2: (otherlv_0= 'numOp' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'numOpDef' ( (lv_numOpDef_4_0= RULE_ID ) ) otherlv_5= 'operation' ( (lv_operation_6_0= ruleOperation ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}' )
            // InternalWorkflow.g:2948:3: otherlv_0= 'numOp' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'numOpDef' ( (lv_numOpDef_4_0= RULE_ID ) ) otherlv_5= 'operation' ( (lv_operation_6_0= ruleOperation ) ) (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getNumOpAccess().getNumOpKeyword_0());
            		
            // InternalWorkflow.g:2952:3: ( (lv_imp_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:2953:4: (lv_imp_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:2953:4: (lv_imp_name_1_0= RULE_ID )
            // InternalWorkflow.g:2954:5: lv_imp_name_1_0= RULE_ID
            {
            lv_imp_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_imp_name_1_0, grammarAccess.getNumOpAccess().getImp_nameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumOpRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imp_name",
            						lv_imp_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_92); 

            			newLeafNode(otherlv_2, grammarAccess.getNumOpAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,90,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getNumOpAccess().getNumOpDefKeyword_3());
            		
            // InternalWorkflow.g:2978:3: ( (lv_numOpDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:2979:4: (lv_numOpDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:2979:4: (lv_numOpDef_4_0= RULE_ID )
            // InternalWorkflow.g:2980:5: lv_numOpDef_4_0= RULE_ID
            {
            lv_numOpDef_4_0=(Token)match(input,RULE_ID,FOLLOW_93); 

            					newLeafNode(lv_numOpDef_4_0, grammarAccess.getNumOpAccess().getNumOpDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumOpRule());
            					}
            					setWithLastConsumed(
            						current,
            						"numOpDef",
            						lv_numOpDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,91,FOLLOW_94); 

            			newLeafNode(otherlv_5, grammarAccess.getNumOpAccess().getOperationKeyword_5());
            		
            // InternalWorkflow.g:3000:3: ( (lv_operation_6_0= ruleOperation ) )
            // InternalWorkflow.g:3001:4: (lv_operation_6_0= ruleOperation )
            {
            // InternalWorkflow.g:3001:4: (lv_operation_6_0= ruleOperation )
            // InternalWorkflow.g:3002:5: lv_operation_6_0= ruleOperation
            {

            					newCompositeNode(grammarAccess.getNumOpAccess().getOperationOperationEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_91);
            lv_operation_6_0=ruleOperation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumOpRule());
            					}
            					set(
            						current,
            						"operation",
            						lv_operation_6_0,
            						"xtext.Workflow.Operation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:3019:3: (otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==88) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalWorkflow.g:3020:4: otherlv_7= 'imputeValue' ( (lv_imputeValue_8_0= ruleSpecialValue ) )
                    {
                    otherlv_7=(Token)match(input,88,FOLLOW_87); 

                    				newLeafNode(otherlv_7, grammarAccess.getNumOpAccess().getImputeValueKeyword_7_0());
                    			
                    // InternalWorkflow.g:3024:4: ( (lv_imputeValue_8_0= ruleSpecialValue ) )
                    // InternalWorkflow.g:3025:5: (lv_imputeValue_8_0= ruleSpecialValue )
                    {
                    // InternalWorkflow.g:3025:5: (lv_imputeValue_8_0= ruleSpecialValue )
                    // InternalWorkflow.g:3026:6: lv_imputeValue_8_0= ruleSpecialValue
                    {

                    						newCompositeNode(grammarAccess.getNumOpAccess().getImputeValueSpecialValueEnumRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_imputeValue_8_0=ruleSpecialValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumOpRule());
                    						}
                    						set(
                    							current,
                    							"imputeValue",
                    							lv_imputeValue_8_0,
                    							"xtext.Workflow.SpecialValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getNumOpAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleCastType"
    // InternalWorkflow.g:3052:1: entryRuleCastType returns [EObject current=null] : iv_ruleCastType= ruleCastType EOF ;
    public final EObject entryRuleCastType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastType = null;


        try {
            // InternalWorkflow.g:3052:49: (iv_ruleCastType= ruleCastType EOF )
            // InternalWorkflow.g:3053:2: iv_ruleCastType= ruleCastType EOF
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
    // InternalWorkflow.g:3059:1: ruleCastType returns [EObject current=null] : (otherlv_0= 'castType' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'castTypeDef' ( (lv_castTypeDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= '}' ) ;
    public final EObject ruleCastType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_imp_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_castTypeDef_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_type_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3065:2: ( (otherlv_0= 'castType' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'castTypeDef' ( (lv_castTypeDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:3066:2: (otherlv_0= 'castType' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'castTypeDef' ( (lv_castTypeDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:3066:2: (otherlv_0= 'castType' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'castTypeDef' ( (lv_castTypeDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= '}' )
            // InternalWorkflow.g:3067:3: otherlv_0= 'castType' ( (lv_imp_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'castTypeDef' ( (lv_castTypeDef_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCastTypeAccess().getCastTypeKeyword_0());
            		
            // InternalWorkflow.g:3071:3: ( (lv_imp_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:3072:4: (lv_imp_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:3072:4: (lv_imp_name_1_0= RULE_ID )
            // InternalWorkflow.g:3073:5: lv_imp_name_1_0= RULE_ID
            {
            lv_imp_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_imp_name_1_0, grammarAccess.getCastTypeAccess().getImp_nameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCastTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imp_name",
            						lv_imp_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_95); 

            			newLeafNode(otherlv_2, grammarAccess.getCastTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,93,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getCastTypeAccess().getCastTypeDefKeyword_3());
            		
            // InternalWorkflow.g:3097:3: ( (lv_castTypeDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:3098:4: (lv_castTypeDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:3098:4: (lv_castTypeDef_4_0= RULE_ID )
            // InternalWorkflow.g:3099:5: lv_castTypeDef_4_0= RULE_ID
            {
            lv_castTypeDef_4_0=(Token)match(input,RULE_ID,FOLLOW_89); 

            					newLeafNode(lv_castTypeDef_4_0, grammarAccess.getCastTypeAccess().getCastTypeDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCastTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"castTypeDef",
            						lv_castTypeDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,87,FOLLOW_49); 

            			newLeafNode(otherlv_5, grammarAccess.getCastTypeAccess().getTypeKeyword_5());
            		
            // InternalWorkflow.g:3119:3: ( (lv_type_6_0= ruleDataType ) )
            // InternalWorkflow.g:3120:4: (lv_type_6_0= ruleDataType )
            {
            // InternalWorkflow.g:3120:4: (lv_type_6_0= ruleDataType )
            // InternalWorkflow.g:3121:5: lv_type_6_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getCastTypeAccess().getTypeDataTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_12);
            lv_type_6_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCastTypeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"xtext.Workflow.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getCastTypeAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleDataDictionary"
    // InternalWorkflow.g:3146:1: entryRuleDataDictionary returns [EObject current=null] : iv_ruleDataDictionary= ruleDataDictionary EOF ;
    public final EObject entryRuleDataDictionary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDictionary = null;


        try {
            // InternalWorkflow.g:3146:55: (iv_ruleDataDictionary= ruleDataDictionary EOF )
            // InternalWorkflow.g:3147:2: iv_ruleDataDictionary= ruleDataDictionary EOF
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
    // InternalWorkflow.g:3153:1: ruleDataDictionary returns [EObject current=null] : (otherlv_0= 'dataDictionary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dataDictionaryDefinition' ( (lv_dataDictionaryDefinition_4_0= RULE_ID ) ) (otherlv_5= 'fileName' ( (lv_fileName_6_0= RULE_STRING ) ) )? (otherlv_7= 'datafields' otherlv_8= '{' ( (lv_datafield_9_0= ruleDataField ) )* otherlv_10= '}' )? otherlv_11= '}' ) ;
    public final EObject ruleDataDictionary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_dataDictionaryDefinition_4_0=null;
        Token otherlv_5=null;
        Token lv_fileName_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_datafield_9_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3159:2: ( (otherlv_0= 'dataDictionary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dataDictionaryDefinition' ( (lv_dataDictionaryDefinition_4_0= RULE_ID ) ) (otherlv_5= 'fileName' ( (lv_fileName_6_0= RULE_STRING ) ) )? (otherlv_7= 'datafields' otherlv_8= '{' ( (lv_datafield_9_0= ruleDataField ) )* otherlv_10= '}' )? otherlv_11= '}' ) )
            // InternalWorkflow.g:3160:2: (otherlv_0= 'dataDictionary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dataDictionaryDefinition' ( (lv_dataDictionaryDefinition_4_0= RULE_ID ) ) (otherlv_5= 'fileName' ( (lv_fileName_6_0= RULE_STRING ) ) )? (otherlv_7= 'datafields' otherlv_8= '{' ( (lv_datafield_9_0= ruleDataField ) )* otherlv_10= '}' )? otherlv_11= '}' )
            {
            // InternalWorkflow.g:3160:2: (otherlv_0= 'dataDictionary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dataDictionaryDefinition' ( (lv_dataDictionaryDefinition_4_0= RULE_ID ) ) (otherlv_5= 'fileName' ( (lv_fileName_6_0= RULE_STRING ) ) )? (otherlv_7= 'datafields' otherlv_8= '{' ( (lv_datafield_9_0= ruleDataField ) )* otherlv_10= '}' )? otherlv_11= '}' )
            // InternalWorkflow.g:3161:3: otherlv_0= 'dataDictionary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dataDictionaryDefinition' ( (lv_dataDictionaryDefinition_4_0= RULE_ID ) ) (otherlv_5= 'fileName' ( (lv_fileName_6_0= RULE_STRING ) ) )? (otherlv_7= 'datafields' otherlv_8= '{' ( (lv_datafield_9_0= ruleDataField ) )* otherlv_10= '}' )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDataDictionaryAccess().getDataDictionaryKeyword_0());
            		
            // InternalWorkflow.g:3165:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:3166:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:3166:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:3167:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataDictionaryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataDictionaryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getDataDictionaryAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,95,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDataDictionaryAccess().getDataDictionaryDefinitionKeyword_3());
            		
            // InternalWorkflow.g:3191:3: ( (lv_dataDictionaryDefinition_4_0= RULE_ID ) )
            // InternalWorkflow.g:3192:4: (lv_dataDictionaryDefinition_4_0= RULE_ID )
            {
            // InternalWorkflow.g:3192:4: (lv_dataDictionaryDefinition_4_0= RULE_ID )
            // InternalWorkflow.g:3193:5: lv_dataDictionaryDefinition_4_0= RULE_ID
            {
            lv_dataDictionaryDefinition_4_0=(Token)match(input,RULE_ID,FOLLOW_97); 

            					newLeafNode(lv_dataDictionaryDefinition_4_0, grammarAccess.getDataDictionaryAccess().getDataDictionaryDefinitionIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataDictionaryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dataDictionaryDefinition",
            						lv_dataDictionaryDefinition_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWorkflow.g:3209:3: (otherlv_5= 'fileName' ( (lv_fileName_6_0= RULE_STRING ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==96) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalWorkflow.g:3210:4: otherlv_5= 'fileName' ( (lv_fileName_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,96,FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getDataDictionaryAccess().getFileNameKeyword_5_0());
                    			
                    // InternalWorkflow.g:3214:4: ( (lv_fileName_6_0= RULE_STRING ) )
                    // InternalWorkflow.g:3215:5: (lv_fileName_6_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:3215:5: (lv_fileName_6_0= RULE_STRING )
                    // InternalWorkflow.g:3216:6: lv_fileName_6_0= RULE_STRING
                    {
                    lv_fileName_6_0=(Token)match(input,RULE_STRING,FOLLOW_98); 

                    						newLeafNode(lv_fileName_6_0, grammarAccess.getDataDictionaryAccess().getFileNameSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataDictionaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"fileName",
                    							lv_fileName_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3233:3: (otherlv_7= 'datafields' otherlv_8= '{' ( (lv_datafield_9_0= ruleDataField ) )* otherlv_10= '}' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==97) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalWorkflow.g:3234:4: otherlv_7= 'datafields' otherlv_8= '{' ( (lv_datafield_9_0= ruleDataField ) )* otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,97,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getDataDictionaryAccess().getDatafieldsKeyword_6_0());
                    			
                    otherlv_8=(Token)match(input,14,FOLLOW_99); 

                    				newLeafNode(otherlv_8, grammarAccess.getDataDictionaryAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalWorkflow.g:3242:4: ( (lv_datafield_9_0= ruleDataField ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==98||LA45_0==106||LA45_0==109) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalWorkflow.g:3243:5: (lv_datafield_9_0= ruleDataField )
                    	    {
                    	    // InternalWorkflow.g:3243:5: (lv_datafield_9_0= ruleDataField )
                    	    // InternalWorkflow.g:3244:6: lv_datafield_9_0= ruleDataField
                    	    {

                    	    						newCompositeNode(grammarAccess.getDataDictionaryAccess().getDatafieldDataFieldParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_99);
                    	    lv_datafield_9_0=ruleDataField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDataDictionaryRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"datafield",
                    	    							lv_datafield_9_0,
                    	    							"xtext.Workflow.DataField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_10, grammarAccess.getDataDictionaryAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDataDictionaryAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleDataField"
    // InternalWorkflow.g:3274:1: entryRuleDataField returns [EObject current=null] : iv_ruleDataField= ruleDataField EOF ;
    public final EObject entryRuleDataField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataField = null;


        try {
            // InternalWorkflow.g:3274:50: (iv_ruleDataField= ruleDataField EOF )
            // InternalWorkflow.g:3275:2: iv_ruleDataField= ruleDataField EOF
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
    // InternalWorkflow.g:3281:1: ruleDataField returns [EObject current=null] : (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate ) ;
    public final EObject ruleDataField() throws RecognitionException {
        EObject current = null;

        EObject this_Categorical_0 = null;

        EObject this_Continuous_1 = null;

        EObject this_Date_2 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3287:2: ( (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate ) )
            // InternalWorkflow.g:3288:2: (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate )
            {
            // InternalWorkflow.g:3288:2: (this_Categorical_0= ruleCategorical | this_Continuous_1= ruleContinuous | this_Date_2= ruleDate )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt47=1;
                }
                break;
            case 106:
                {
                alt47=2;
                }
                break;
            case 109:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalWorkflow.g:3289:3: this_Categorical_0= ruleCategorical
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
                    // InternalWorkflow.g:3298:3: this_Continuous_1= ruleContinuous
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
                    // InternalWorkflow.g:3307:3: this_Date_2= ruleDate
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


    // $ANTLR start "entryRuleCategorical"
    // InternalWorkflow.g:3319:1: entryRuleCategorical returns [EObject current=null] : iv_ruleCategorical= ruleCategorical EOF ;
    public final EObject entryRuleCategorical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategorical = null;


        try {
            // InternalWorkflow.g:3319:52: (iv_ruleCategorical= ruleCategorical EOF )
            // InternalWorkflow.g:3320:2: iv_ruleCategorical= ruleCategorical EOF
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
    // InternalWorkflow.g:3326:1: ruleCategorical returns [EObject current=null] : (otherlv_0= 'categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'categoricalDef' ( (lv_categoricalDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'ordinal' ( (lv_ordinal_14_0= 'true' ) ) )? (otherlv_15= 'validValues' otherlv_16= '{' ( (lv_validValues_17_0= ruleValueField ) )* otherlv_18= '}' )? (otherlv_19= 'invalidValues' otherlv_20= '{' ( (lv_invalidValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'missingValues' otherlv_24= '{' ( (lv_missingValues_25_0= ruleValueField ) )* otherlv_26= '}' )? otherlv_27= '}' ) ;
    public final EObject ruleCategorical() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_categoricalDef_4_0=null;
        Token otherlv_5=null;
        Token lv_id_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_target_10_0=null;
        Token otherlv_11=null;
        Token lv_displayName_12_0=null;
        Token otherlv_13=null;
        Token lv_ordinal_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Enumerator lv_dataType_8_0 = null;

        EObject lv_validValues_17_0 = null;

        EObject lv_invalidValues_21_0 = null;

        EObject lv_missingValues_25_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3332:2: ( (otherlv_0= 'categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'categoricalDef' ( (lv_categoricalDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'ordinal' ( (lv_ordinal_14_0= 'true' ) ) )? (otherlv_15= 'validValues' otherlv_16= '{' ( (lv_validValues_17_0= ruleValueField ) )* otherlv_18= '}' )? (otherlv_19= 'invalidValues' otherlv_20= '{' ( (lv_invalidValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'missingValues' otherlv_24= '{' ( (lv_missingValues_25_0= ruleValueField ) )* otherlv_26= '}' )? otherlv_27= '}' ) )
            // InternalWorkflow.g:3333:2: (otherlv_0= 'categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'categoricalDef' ( (lv_categoricalDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'ordinal' ( (lv_ordinal_14_0= 'true' ) ) )? (otherlv_15= 'validValues' otherlv_16= '{' ( (lv_validValues_17_0= ruleValueField ) )* otherlv_18= '}' )? (otherlv_19= 'invalidValues' otherlv_20= '{' ( (lv_invalidValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'missingValues' otherlv_24= '{' ( (lv_missingValues_25_0= ruleValueField ) )* otherlv_26= '}' )? otherlv_27= '}' )
            {
            // InternalWorkflow.g:3333:2: (otherlv_0= 'categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'categoricalDef' ( (lv_categoricalDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'ordinal' ( (lv_ordinal_14_0= 'true' ) ) )? (otherlv_15= 'validValues' otherlv_16= '{' ( (lv_validValues_17_0= ruleValueField ) )* otherlv_18= '}' )? (otherlv_19= 'invalidValues' otherlv_20= '{' ( (lv_invalidValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'missingValues' otherlv_24= '{' ( (lv_missingValues_25_0= ruleValueField ) )* otherlv_26= '}' )? otherlv_27= '}' )
            // InternalWorkflow.g:3334:3: otherlv_0= 'categorical' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'categoricalDef' ( (lv_categoricalDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'ordinal' ( (lv_ordinal_14_0= 'true' ) ) )? (otherlv_15= 'validValues' otherlv_16= '{' ( (lv_validValues_17_0= ruleValueField ) )* otherlv_18= '}' )? (otherlv_19= 'invalidValues' otherlv_20= '{' ( (lv_invalidValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'missingValues' otherlv_24= '{' ( (lv_missingValues_25_0= ruleValueField ) )* otherlv_26= '}' )? otherlv_27= '}'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCategoricalAccess().getCategoricalKeyword_0());
            		
            // InternalWorkflow.g:3338:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:3339:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:3339:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:3340:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_100); 

            			newLeafNode(otherlv_2, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,99,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getCategoricalAccess().getCategoricalDefKeyword_3());
            		
            // InternalWorkflow.g:3364:3: ( (lv_categoricalDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:3365:4: (lv_categoricalDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:3365:4: (lv_categoricalDef_4_0= RULE_ID )
            // InternalWorkflow.g:3366:5: lv_categoricalDef_4_0= RULE_ID
            {
            lv_categoricalDef_4_0=(Token)match(input,RULE_ID,FOLLOW_101); 

            					newLeafNode(lv_categoricalDef_4_0, grammarAccess.getCategoricalAccess().getCategoricalDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCategoricalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"categoricalDef",
            						lv_categoricalDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWorkflow.g:3382:3: (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==100) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalWorkflow.g:3383:4: otherlv_5= 'id' ( (lv_id_6_0= 'true' ) )
                    {
                    otherlv_5=(Token)match(input,100,FOLLOW_32); 

                    				newLeafNode(otherlv_5, grammarAccess.getCategoricalAccess().getIdKeyword_5_0());
                    			
                    // InternalWorkflow.g:3387:4: ( (lv_id_6_0= 'true' ) )
                    // InternalWorkflow.g:3388:5: (lv_id_6_0= 'true' )
                    {
                    // InternalWorkflow.g:3388:5: (lv_id_6_0= 'true' )
                    // InternalWorkflow.g:3389:6: lv_id_6_0= 'true'
                    {
                    lv_id_6_0=(Token)match(input,32,FOLLOW_48); 

                    						newLeafNode(lv_id_6_0, grammarAccess.getCategoricalAccess().getIdTrueKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCategoricalRule());
                    						}
                    						setWithLastConsumed(current, "id", lv_id_6_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,48,FOLLOW_49); 

            			newLeafNode(otherlv_7, grammarAccess.getCategoricalAccess().getDataTypeKeyword_6());
            		
            // InternalWorkflow.g:3406:3: ( (lv_dataType_8_0= ruleDataType ) )
            // InternalWorkflow.g:3407:4: (lv_dataType_8_0= ruleDataType )
            {
            // InternalWorkflow.g:3407:4: (lv_dataType_8_0= ruleDataType )
            // InternalWorkflow.g:3408:5: lv_dataType_8_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getCategoricalAccess().getDataTypeDataTypeEnumRuleCall_7_0());
            				
            pushFollow(FOLLOW_102);
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

            // InternalWorkflow.g:3425:3: (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==39) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalWorkflow.g:3426:4: otherlv_9= 'target' ( (lv_target_10_0= 'true' ) )
                    {
                    otherlv_9=(Token)match(input,39,FOLLOW_32); 

                    				newLeafNode(otherlv_9, grammarAccess.getCategoricalAccess().getTargetKeyword_8_0());
                    			
                    // InternalWorkflow.g:3430:4: ( (lv_target_10_0= 'true' ) )
                    // InternalWorkflow.g:3431:5: (lv_target_10_0= 'true' )
                    {
                    // InternalWorkflow.g:3431:5: (lv_target_10_0= 'true' )
                    // InternalWorkflow.g:3432:6: lv_target_10_0= 'true'
                    {
                    lv_target_10_0=(Token)match(input,32,FOLLOW_103); 

                    						newLeafNode(lv_target_10_0, grammarAccess.getCategoricalAccess().getTargetTrueKeyword_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCategoricalRule());
                    						}
                    						setWithLastConsumed(current, "target", lv_target_10_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3445:3: (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==101) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalWorkflow.g:3446:4: otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,101,FOLLOW_15); 

                    				newLeafNode(otherlv_11, grammarAccess.getCategoricalAccess().getDisplayNameKeyword_9_0());
                    			
                    // InternalWorkflow.g:3450:4: ( (lv_displayName_12_0= RULE_STRING ) )
                    // InternalWorkflow.g:3451:5: (lv_displayName_12_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:3451:5: (lv_displayName_12_0= RULE_STRING )
                    // InternalWorkflow.g:3452:6: lv_displayName_12_0= RULE_STRING
                    {
                    lv_displayName_12_0=(Token)match(input,RULE_STRING,FOLLOW_104); 

                    						newLeafNode(lv_displayName_12_0, grammarAccess.getCategoricalAccess().getDisplayNameSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCategoricalRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"displayName",
                    							lv_displayName_12_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3469:3: (otherlv_13= 'ordinal' ( (lv_ordinal_14_0= 'true' ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==102) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalWorkflow.g:3470:4: otherlv_13= 'ordinal' ( (lv_ordinal_14_0= 'true' ) )
                    {
                    otherlv_13=(Token)match(input,102,FOLLOW_32); 

                    				newLeafNode(otherlv_13, grammarAccess.getCategoricalAccess().getOrdinalKeyword_10_0());
                    			
                    // InternalWorkflow.g:3474:4: ( (lv_ordinal_14_0= 'true' ) )
                    // InternalWorkflow.g:3475:5: (lv_ordinal_14_0= 'true' )
                    {
                    // InternalWorkflow.g:3475:5: (lv_ordinal_14_0= 'true' )
                    // InternalWorkflow.g:3476:6: lv_ordinal_14_0= 'true'
                    {
                    lv_ordinal_14_0=(Token)match(input,32,FOLLOW_105); 

                    						newLeafNode(lv_ordinal_14_0, grammarAccess.getCategoricalAccess().getOrdinalTrueKeyword_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCategoricalRule());
                    						}
                    						setWithLastConsumed(current, "ordinal", lv_ordinal_14_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3489:3: (otherlv_15= 'validValues' otherlv_16= '{' ( (lv_validValues_17_0= ruleValueField ) )* otherlv_18= '}' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==103) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalWorkflow.g:3490:4: otherlv_15= 'validValues' otherlv_16= '{' ( (lv_validValues_17_0= ruleValueField ) )* otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,103,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getCategoricalAccess().getValidValuesKeyword_11_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_16, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_11_1());
                    			
                    // InternalWorkflow.g:3498:4: ( (lv_validValues_17_0= ruleValueField ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==47) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalWorkflow.g:3499:5: (lv_validValues_17_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:3499:5: (lv_validValues_17_0= ruleValueField )
                    	    // InternalWorkflow.g:3500:6: lv_validValues_17_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getCategoricalAccess().getValidValuesValueFieldParserRuleCall_11_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
                    	    lv_validValues_17_0=ruleValueField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"validValues",
                    	    							lv_validValues_17_0,
                    	    							"xtext.Workflow.ValueField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,17,FOLLOW_107); 

                    				newLeafNode(otherlv_18, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_11_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:3522:3: (otherlv_19= 'invalidValues' otherlv_20= '{' ( (lv_invalidValues_21_0= ruleValueField ) )* otherlv_22= '}' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==104) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalWorkflow.g:3523:4: otherlv_19= 'invalidValues' otherlv_20= '{' ( (lv_invalidValues_21_0= ruleValueField ) )* otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,104,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getCategoricalAccess().getInvalidValuesKeyword_12_0());
                    			
                    otherlv_20=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_20, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_12_1());
                    			
                    // InternalWorkflow.g:3531:4: ( (lv_invalidValues_21_0= ruleValueField ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==47) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalWorkflow.g:3532:5: (lv_invalidValues_21_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:3532:5: (lv_invalidValues_21_0= ruleValueField )
                    	    // InternalWorkflow.g:3533:6: lv_invalidValues_21_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getCategoricalAccess().getInvalidValuesValueFieldParserRuleCall_12_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
                    	    lv_invalidValues_21_0=ruleValueField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"invalidValues",
                    	    							lv_invalidValues_21_0,
                    	    							"xtext.Workflow.ValueField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,17,FOLLOW_108); 

                    				newLeafNode(otherlv_22, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_12_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:3555:3: (otherlv_23= 'missingValues' otherlv_24= '{' ( (lv_missingValues_25_0= ruleValueField ) )* otherlv_26= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==105) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalWorkflow.g:3556:4: otherlv_23= 'missingValues' otherlv_24= '{' ( (lv_missingValues_25_0= ruleValueField ) )* otherlv_26= '}'
                    {
                    otherlv_23=(Token)match(input,105,FOLLOW_4); 

                    				newLeafNode(otherlv_23, grammarAccess.getCategoricalAccess().getMissingValuesKeyword_13_0());
                    			
                    otherlv_24=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_24, grammarAccess.getCategoricalAccess().getLeftCurlyBracketKeyword_13_1());
                    			
                    // InternalWorkflow.g:3564:4: ( (lv_missingValues_25_0= ruleValueField ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==47) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalWorkflow.g:3565:5: (lv_missingValues_25_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:3565:5: (lv_missingValues_25_0= ruleValueField )
                    	    // InternalWorkflow.g:3566:6: lv_missingValues_25_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getCategoricalAccess().getMissingValuesValueFieldParserRuleCall_13_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
                    	    lv_missingValues_25_0=ruleValueField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCategoricalRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"missingValues",
                    	    							lv_missingValues_25_0,
                    	    							"xtext.Workflow.ValueField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_26, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_13_3());
                    			

                    }
                    break;

            }

            otherlv_27=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_27, grammarAccess.getCategoricalAccess().getRightCurlyBracketKeyword_14());
            		

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
    // InternalWorkflow.g:3596:1: entryRuleContinuous returns [EObject current=null] : iv_ruleContinuous= ruleContinuous EOF ;
    public final EObject entryRuleContinuous() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinuous = null;


        try {
            // InternalWorkflow.g:3596:51: (iv_ruleContinuous= ruleContinuous EOF )
            // InternalWorkflow.g:3597:2: iv_ruleContinuous= ruleContinuous EOF
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
    // InternalWorkflow.g:3603:1: ruleContinuous returns [EObject current=null] : (otherlv_0= 'continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'continuousDef' ( (lv_continuousDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'numDecimals' ( (lv_numDecimals_14_0= RULE_EINT ) ) )? otherlv_15= 'intervals' otherlv_16= '{' ( (lv_interval_17_0= ruleInterval ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' ) ;
    public final EObject ruleContinuous() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_continuousDef_4_0=null;
        Token otherlv_5=null;
        Token lv_id_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_target_10_0=null;
        Token otherlv_11=null;
        Token lv_displayName_12_0=null;
        Token otherlv_13=null;
        Token lv_numDecimals_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Enumerator lv_dataType_8_0 = null;

        EObject lv_interval_17_0 = null;

        EObject lv_validValues_21_0 = null;

        EObject lv_invalidValues_25_0 = null;

        EObject lv_missingValues_29_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3609:2: ( (otherlv_0= 'continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'continuousDef' ( (lv_continuousDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'numDecimals' ( (lv_numDecimals_14_0= RULE_EINT ) ) )? otherlv_15= 'intervals' otherlv_16= '{' ( (lv_interval_17_0= ruleInterval ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' ) )
            // InternalWorkflow.g:3610:2: (otherlv_0= 'continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'continuousDef' ( (lv_continuousDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'numDecimals' ( (lv_numDecimals_14_0= RULE_EINT ) ) )? otherlv_15= 'intervals' otherlv_16= '{' ( (lv_interval_17_0= ruleInterval ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' )
            {
            // InternalWorkflow.g:3610:2: (otherlv_0= 'continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'continuousDef' ( (lv_continuousDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'numDecimals' ( (lv_numDecimals_14_0= RULE_EINT ) ) )? otherlv_15= 'intervals' otherlv_16= '{' ( (lv_interval_17_0= ruleInterval ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' )
            // InternalWorkflow.g:3611:3: otherlv_0= 'continuous' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'continuousDef' ( (lv_continuousDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'numDecimals' ( (lv_numDecimals_14_0= RULE_EINT ) ) )? otherlv_15= 'intervals' otherlv_16= '{' ( (lv_interval_17_0= ruleInterval ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}'
            {
            otherlv_0=(Token)match(input,106,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContinuousAccess().getContinuousKeyword_0());
            		
            // InternalWorkflow.g:3615:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:3616:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:3616:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:3617:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_109); 

            			newLeafNode(otherlv_2, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,107,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getContinuousAccess().getContinuousDefKeyword_3());
            		
            // InternalWorkflow.g:3641:3: ( (lv_continuousDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:3642:4: (lv_continuousDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:3642:4: (lv_continuousDef_4_0= RULE_ID )
            // InternalWorkflow.g:3643:5: lv_continuousDef_4_0= RULE_ID
            {
            lv_continuousDef_4_0=(Token)match(input,RULE_ID,FOLLOW_101); 

            					newLeafNode(lv_continuousDef_4_0, grammarAccess.getContinuousAccess().getContinuousDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContinuousRule());
            					}
            					setWithLastConsumed(
            						current,
            						"continuousDef",
            						lv_continuousDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWorkflow.g:3659:3: (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==100) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalWorkflow.g:3660:4: otherlv_5= 'id' ( (lv_id_6_0= 'true' ) )
                    {
                    otherlv_5=(Token)match(input,100,FOLLOW_32); 

                    				newLeafNode(otherlv_5, grammarAccess.getContinuousAccess().getIdKeyword_5_0());
                    			
                    // InternalWorkflow.g:3664:4: ( (lv_id_6_0= 'true' ) )
                    // InternalWorkflow.g:3665:5: (lv_id_6_0= 'true' )
                    {
                    // InternalWorkflow.g:3665:5: (lv_id_6_0= 'true' )
                    // InternalWorkflow.g:3666:6: lv_id_6_0= 'true'
                    {
                    lv_id_6_0=(Token)match(input,32,FOLLOW_48); 

                    						newLeafNode(lv_id_6_0, grammarAccess.getContinuousAccess().getIdTrueKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    						setWithLastConsumed(current, "id", lv_id_6_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,48,FOLLOW_49); 

            			newLeafNode(otherlv_7, grammarAccess.getContinuousAccess().getDataTypeKeyword_6());
            		
            // InternalWorkflow.g:3683:3: ( (lv_dataType_8_0= ruleDataType ) )
            // InternalWorkflow.g:3684:4: (lv_dataType_8_0= ruleDataType )
            {
            // InternalWorkflow.g:3684:4: (lv_dataType_8_0= ruleDataType )
            // InternalWorkflow.g:3685:5: lv_dataType_8_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getContinuousAccess().getDataTypeDataTypeEnumRuleCall_7_0());
            				
            pushFollow(FOLLOW_110);
            lv_dataType_8_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContinuousRule());
            					}
            					set(
            						current,
            						"dataType",
            						lv_dataType_8_0,
            						"xtext.Workflow.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:3702:3: (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==39) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalWorkflow.g:3703:4: otherlv_9= 'target' ( (lv_target_10_0= 'true' ) )
                    {
                    otherlv_9=(Token)match(input,39,FOLLOW_32); 

                    				newLeafNode(otherlv_9, grammarAccess.getContinuousAccess().getTargetKeyword_8_0());
                    			
                    // InternalWorkflow.g:3707:4: ( (lv_target_10_0= 'true' ) )
                    // InternalWorkflow.g:3708:5: (lv_target_10_0= 'true' )
                    {
                    // InternalWorkflow.g:3708:5: (lv_target_10_0= 'true' )
                    // InternalWorkflow.g:3709:6: lv_target_10_0= 'true'
                    {
                    lv_target_10_0=(Token)match(input,32,FOLLOW_111); 

                    						newLeafNode(lv_target_10_0, grammarAccess.getContinuousAccess().getTargetTrueKeyword_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    						setWithLastConsumed(current, "target", lv_target_10_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3722:3: (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==101) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalWorkflow.g:3723:4: otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,101,FOLLOW_15); 

                    				newLeafNode(otherlv_11, grammarAccess.getContinuousAccess().getDisplayNameKeyword_9_0());
                    			
                    // InternalWorkflow.g:3727:4: ( (lv_displayName_12_0= RULE_STRING ) )
                    // InternalWorkflow.g:3728:5: (lv_displayName_12_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:3728:5: (lv_displayName_12_0= RULE_STRING )
                    // InternalWorkflow.g:3729:6: lv_displayName_12_0= RULE_STRING
                    {
                    lv_displayName_12_0=(Token)match(input,RULE_STRING,FOLLOW_112); 

                    						newLeafNode(lv_displayName_12_0, grammarAccess.getContinuousAccess().getDisplayNameSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"displayName",
                    							lv_displayName_12_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:3746:3: (otherlv_13= 'numDecimals' ( (lv_numDecimals_14_0= RULE_EINT ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==108) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalWorkflow.g:3747:4: otherlv_13= 'numDecimals' ( (lv_numDecimals_14_0= RULE_EINT ) )
                    {
                    otherlv_13=(Token)match(input,108,FOLLOW_113); 

                    				newLeafNode(otherlv_13, grammarAccess.getContinuousAccess().getNumDecimalsKeyword_10_0());
                    			
                    // InternalWorkflow.g:3751:4: ( (lv_numDecimals_14_0= RULE_EINT ) )
                    // InternalWorkflow.g:3752:5: (lv_numDecimals_14_0= RULE_EINT )
                    {
                    // InternalWorkflow.g:3752:5: (lv_numDecimals_14_0= RULE_EINT )
                    // InternalWorkflow.g:3753:6: lv_numDecimals_14_0= RULE_EINT
                    {
                    lv_numDecimals_14_0=(Token)match(input,RULE_EINT,FOLLOW_61); 

                    						newLeafNode(lv_numDecimals_14_0, grammarAccess.getContinuousAccess().getNumDecimalsEIntTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContinuousRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"numDecimals",
                    							lv_numDecimals_14_0,
                    							"xtext.Workflow.EInt");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,60,FOLLOW_4); 

            			newLeafNode(otherlv_15, grammarAccess.getContinuousAccess().getIntervalsKeyword_11());
            		
            otherlv_16=(Token)match(input,14,FOLLOW_62); 

            			newLeafNode(otherlv_16, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_12());
            		
            // InternalWorkflow.g:3778:3: ( (lv_interval_17_0= ruleInterval ) )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==113) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalWorkflow.g:3779:4: (lv_interval_17_0= ruleInterval )
            	    {
            	    // InternalWorkflow.g:3779:4: (lv_interval_17_0= ruleInterval )
            	    // InternalWorkflow.g:3780:5: lv_interval_17_0= ruleInterval
            	    {

            	    					newCompositeNode(grammarAccess.getContinuousAccess().getIntervalIntervalParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_63);
            	    lv_interval_17_0=ruleInterval();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContinuousRule());
            	    					}
            	    					add(
            	    						current,
            	    						"interval",
            	    						lv_interval_17_0,
            	    						"xtext.Workflow.Interval");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            otherlv_18=(Token)match(input,17,FOLLOW_105); 

            			newLeafNode(otherlv_18, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_14());
            		
            // InternalWorkflow.g:3801:3: (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==103) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalWorkflow.g:3802:4: otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,103,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getContinuousAccess().getValidValuesKeyword_15_0());
                    			
                    otherlv_20=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_20, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_15_1());
                    			
                    // InternalWorkflow.g:3810:4: ( (lv_validValues_21_0= ruleValueField ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==47) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalWorkflow.g:3811:5: (lv_validValues_21_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:3811:5: (lv_validValues_21_0= ruleValueField )
                    	    // InternalWorkflow.g:3812:6: lv_validValues_21_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getContinuousAccess().getValidValuesValueFieldParserRuleCall_15_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
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
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,17,FOLLOW_107); 

                    				newLeafNode(otherlv_22, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_15_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:3834:3: (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==104) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalWorkflow.g:3835:4: otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}'
                    {
                    otherlv_23=(Token)match(input,104,FOLLOW_4); 

                    				newLeafNode(otherlv_23, grammarAccess.getContinuousAccess().getInvalidValuesKeyword_16_0());
                    			
                    otherlv_24=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_24, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_16_1());
                    			
                    // InternalWorkflow.g:3843:4: ( (lv_invalidValues_25_0= ruleValueField ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==47) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalWorkflow.g:3844:5: (lv_invalidValues_25_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:3844:5: (lv_invalidValues_25_0= ruleValueField )
                    	    // InternalWorkflow.g:3845:6: lv_invalidValues_25_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getContinuousAccess().getInvalidValuesValueFieldParserRuleCall_16_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
                    	    lv_invalidValues_25_0=ruleValueField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"invalidValues",
                    	    							lv_invalidValues_25_0,
                    	    							"xtext.Workflow.ValueField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,17,FOLLOW_108); 

                    				newLeafNode(otherlv_26, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_16_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:3867:3: (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==105) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalWorkflow.g:3868:4: otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}'
                    {
                    otherlv_27=(Token)match(input,105,FOLLOW_4); 

                    				newLeafNode(otherlv_27, grammarAccess.getContinuousAccess().getMissingValuesKeyword_17_0());
                    			
                    otherlv_28=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_28, grammarAccess.getContinuousAccess().getLeftCurlyBracketKeyword_17_1());
                    			
                    // InternalWorkflow.g:3876:4: ( (lv_missingValues_29_0= ruleValueField ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==47) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalWorkflow.g:3877:5: (lv_missingValues_29_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:3877:5: (lv_missingValues_29_0= ruleValueField )
                    	    // InternalWorkflow.g:3878:6: lv_missingValues_29_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getContinuousAccess().getMissingValuesValueFieldParserRuleCall_17_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
                    	    lv_missingValues_29_0=ruleValueField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getContinuousRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"missingValues",
                    	    							lv_missingValues_29_0,
                    	    							"xtext.Workflow.ValueField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_30, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_17_3());
                    			

                    }
                    break;

            }

            otherlv_31=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_31, grammarAccess.getContinuousAccess().getRightCurlyBracketKeyword_18());
            		

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
    // InternalWorkflow.g:3908:1: entryRuleDate returns [EObject current=null] : iv_ruleDate= ruleDate EOF ;
    public final EObject entryRuleDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDate = null;


        try {
            // InternalWorkflow.g:3908:45: (iv_ruleDate= ruleDate EOF )
            // InternalWorkflow.g:3909:2: iv_ruleDate= ruleDate EOF
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
    // InternalWorkflow.g:3915:1: ruleDate returns [EObject current=null] : (otherlv_0= 'date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dateDef' ( (lv_dateDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'format' ( (lv_format_14_0= RULE_STRING ) ) )? otherlv_15= 'intervaldate' otherlv_16= '{' ( (lv_intervaldate_17_0= ruleIntervalDate ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' ) ;
    public final EObject ruleDate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_dateDef_4_0=null;
        Token otherlv_5=null;
        Token lv_id_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_target_10_0=null;
        Token otherlv_11=null;
        Token lv_displayName_12_0=null;
        Token otherlv_13=null;
        Token lv_format_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Enumerator lv_dataType_8_0 = null;

        EObject lv_intervaldate_17_0 = null;

        EObject lv_validValues_21_0 = null;

        EObject lv_invalidValues_25_0 = null;

        EObject lv_missingValues_29_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:3921:2: ( (otherlv_0= 'date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dateDef' ( (lv_dateDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'format' ( (lv_format_14_0= RULE_STRING ) ) )? otherlv_15= 'intervaldate' otherlv_16= '{' ( (lv_intervaldate_17_0= ruleIntervalDate ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' ) )
            // InternalWorkflow.g:3922:2: (otherlv_0= 'date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dateDef' ( (lv_dateDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'format' ( (lv_format_14_0= RULE_STRING ) ) )? otherlv_15= 'intervaldate' otherlv_16= '{' ( (lv_intervaldate_17_0= ruleIntervalDate ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' )
            {
            // InternalWorkflow.g:3922:2: (otherlv_0= 'date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dateDef' ( (lv_dateDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'format' ( (lv_format_14_0= RULE_STRING ) ) )? otherlv_15= 'intervaldate' otherlv_16= '{' ( (lv_intervaldate_17_0= ruleIntervalDate ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}' )
            // InternalWorkflow.g:3923:3: otherlv_0= 'date' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'dateDef' ( (lv_dateDef_4_0= RULE_ID ) ) (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )? otherlv_7= 'dataType' ( (lv_dataType_8_0= ruleDataType ) ) (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )? (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )? (otherlv_13= 'format' ( (lv_format_14_0= RULE_STRING ) ) )? otherlv_15= 'intervaldate' otherlv_16= '{' ( (lv_intervaldate_17_0= ruleIntervalDate ) )+ otherlv_18= '}' (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )? (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )? (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )? otherlv_31= '}'
            {
            otherlv_0=(Token)match(input,109,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDateAccess().getDateKeyword_0());
            		
            // InternalWorkflow.g:3927:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:3928:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:3928:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:3929:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDateAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_114); 

            			newLeafNode(otherlv_2, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,110,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDateAccess().getDateDefKeyword_3());
            		
            // InternalWorkflow.g:3953:3: ( (lv_dateDef_4_0= RULE_ID ) )
            // InternalWorkflow.g:3954:4: (lv_dateDef_4_0= RULE_ID )
            {
            // InternalWorkflow.g:3954:4: (lv_dateDef_4_0= RULE_ID )
            // InternalWorkflow.g:3955:5: lv_dateDef_4_0= RULE_ID
            {
            lv_dateDef_4_0=(Token)match(input,RULE_ID,FOLLOW_101); 

            					newLeafNode(lv_dateDef_4_0, grammarAccess.getDateAccess().getDateDefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dateDef",
            						lv_dateDef_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalWorkflow.g:3971:3: (otherlv_5= 'id' ( (lv_id_6_0= 'true' ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==100) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalWorkflow.g:3972:4: otherlv_5= 'id' ( (lv_id_6_0= 'true' ) )
                    {
                    otherlv_5=(Token)match(input,100,FOLLOW_32); 

                    				newLeafNode(otherlv_5, grammarAccess.getDateAccess().getIdKeyword_5_0());
                    			
                    // InternalWorkflow.g:3976:4: ( (lv_id_6_0= 'true' ) )
                    // InternalWorkflow.g:3977:5: (lv_id_6_0= 'true' )
                    {
                    // InternalWorkflow.g:3977:5: (lv_id_6_0= 'true' )
                    // InternalWorkflow.g:3978:6: lv_id_6_0= 'true'
                    {
                    lv_id_6_0=(Token)match(input,32,FOLLOW_48); 

                    						newLeafNode(lv_id_6_0, grammarAccess.getDateAccess().getIdTrueKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDateRule());
                    						}
                    						setWithLastConsumed(current, "id", lv_id_6_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,48,FOLLOW_49); 

            			newLeafNode(otherlv_7, grammarAccess.getDateAccess().getDataTypeKeyword_6());
            		
            // InternalWorkflow.g:3995:3: ( (lv_dataType_8_0= ruleDataType ) )
            // InternalWorkflow.g:3996:4: (lv_dataType_8_0= ruleDataType )
            {
            // InternalWorkflow.g:3996:4: (lv_dataType_8_0= ruleDataType )
            // InternalWorkflow.g:3997:5: lv_dataType_8_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getDateAccess().getDataTypeDataTypeEnumRuleCall_7_0());
            				
            pushFollow(FOLLOW_115);
            lv_dataType_8_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateRule());
            					}
            					set(
            						current,
            						"dataType",
            						lv_dataType_8_0,
            						"xtext.Workflow.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:4014:3: (otherlv_9= 'target' ( (lv_target_10_0= 'true' ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==39) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalWorkflow.g:4015:4: otherlv_9= 'target' ( (lv_target_10_0= 'true' ) )
                    {
                    otherlv_9=(Token)match(input,39,FOLLOW_32); 

                    				newLeafNode(otherlv_9, grammarAccess.getDateAccess().getTargetKeyword_8_0());
                    			
                    // InternalWorkflow.g:4019:4: ( (lv_target_10_0= 'true' ) )
                    // InternalWorkflow.g:4020:5: (lv_target_10_0= 'true' )
                    {
                    // InternalWorkflow.g:4020:5: (lv_target_10_0= 'true' )
                    // InternalWorkflow.g:4021:6: lv_target_10_0= 'true'
                    {
                    lv_target_10_0=(Token)match(input,32,FOLLOW_116); 

                    						newLeafNode(lv_target_10_0, grammarAccess.getDateAccess().getTargetTrueKeyword_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDateRule());
                    						}
                    						setWithLastConsumed(current, "target", lv_target_10_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4034:3: (otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==101) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalWorkflow.g:4035:4: otherlv_11= 'displayName' ( (lv_displayName_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,101,FOLLOW_15); 

                    				newLeafNode(otherlv_11, grammarAccess.getDateAccess().getDisplayNameKeyword_9_0());
                    			
                    // InternalWorkflow.g:4039:4: ( (lv_displayName_12_0= RULE_STRING ) )
                    // InternalWorkflow.g:4040:5: (lv_displayName_12_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:4040:5: (lv_displayName_12_0= RULE_STRING )
                    // InternalWorkflow.g:4041:6: lv_displayName_12_0= RULE_STRING
                    {
                    lv_displayName_12_0=(Token)match(input,RULE_STRING,FOLLOW_117); 

                    						newLeafNode(lv_displayName_12_0, grammarAccess.getDateAccess().getDisplayNameSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"displayName",
                    							lv_displayName_12_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:4058:3: (otherlv_13= 'format' ( (lv_format_14_0= RULE_STRING ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==111) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalWorkflow.g:4059:4: otherlv_13= 'format' ( (lv_format_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,111,FOLLOW_15); 

                    				newLeafNode(otherlv_13, grammarAccess.getDateAccess().getFormatKeyword_10_0());
                    			
                    // InternalWorkflow.g:4063:4: ( (lv_format_14_0= RULE_STRING ) )
                    // InternalWorkflow.g:4064:5: (lv_format_14_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:4064:5: (lv_format_14_0= RULE_STRING )
                    // InternalWorkflow.g:4065:6: lv_format_14_0= RULE_STRING
                    {
                    lv_format_14_0=(Token)match(input,RULE_STRING,FOLLOW_118); 

                    						newLeafNode(lv_format_14_0, grammarAccess.getDateAccess().getFormatSTRINGTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"format",
                    							lv_format_14_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,112,FOLLOW_4); 

            			newLeafNode(otherlv_15, grammarAccess.getDateAccess().getIntervaldateKeyword_11());
            		
            otherlv_16=(Token)match(input,14,FOLLOW_119); 

            			newLeafNode(otherlv_16, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_12());
            		
            // InternalWorkflow.g:4090:3: ( (lv_intervaldate_17_0= ruleIntervalDate ) )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==116) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalWorkflow.g:4091:4: (lv_intervaldate_17_0= ruleIntervalDate )
            	    {
            	    // InternalWorkflow.g:4091:4: (lv_intervaldate_17_0= ruleIntervalDate )
            	    // InternalWorkflow.g:4092:5: lv_intervaldate_17_0= ruleIntervalDate
            	    {

            	    					newCompositeNode(grammarAccess.getDateAccess().getIntervaldateIntervalDateParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_120);
            	    lv_intervaldate_17_0=ruleIntervalDate();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"intervaldate",
            	    						lv_intervaldate_17_0,
            	    						"xtext.Workflow.IntervalDate");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt73 >= 1 ) break loop73;
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
            } while (true);

            otherlv_18=(Token)match(input,17,FOLLOW_105); 

            			newLeafNode(otherlv_18, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_14());
            		
            // InternalWorkflow.g:4113:3: (otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==103) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalWorkflow.g:4114:4: otherlv_19= 'validValues' otherlv_20= '{' ( (lv_validValues_21_0= ruleValueField ) )* otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,103,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getDateAccess().getValidValuesKeyword_15_0());
                    			
                    otherlv_20=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_20, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_15_1());
                    			
                    // InternalWorkflow.g:4122:4: ( (lv_validValues_21_0= ruleValueField ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==47) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalWorkflow.g:4123:5: (lv_validValues_21_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:4123:5: (lv_validValues_21_0= ruleValueField )
                    	    // InternalWorkflow.g:4124:6: lv_validValues_21_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getDateAccess().getValidValuesValueFieldParserRuleCall_15_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
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
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,17,FOLLOW_107); 

                    				newLeafNode(otherlv_22, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_15_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:4146:3: (otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==104) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalWorkflow.g:4147:4: otherlv_23= 'invalidValues' otherlv_24= '{' ( (lv_invalidValues_25_0= ruleValueField ) )* otherlv_26= '}'
                    {
                    otherlv_23=(Token)match(input,104,FOLLOW_4); 

                    				newLeafNode(otherlv_23, grammarAccess.getDateAccess().getInvalidValuesKeyword_16_0());
                    			
                    otherlv_24=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_24, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_16_1());
                    			
                    // InternalWorkflow.g:4155:4: ( (lv_invalidValues_25_0= ruleValueField ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==47) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalWorkflow.g:4156:5: (lv_invalidValues_25_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:4156:5: (lv_invalidValues_25_0= ruleValueField )
                    	    // InternalWorkflow.g:4157:6: lv_invalidValues_25_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getDateAccess().getInvalidValuesValueFieldParserRuleCall_16_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
                    	    lv_invalidValues_25_0=ruleValueField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"invalidValues",
                    	    							lv_invalidValues_25_0,
                    	    							"xtext.Workflow.ValueField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,17,FOLLOW_108); 

                    				newLeafNode(otherlv_26, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_16_3());
                    			

                    }
                    break;

            }

            // InternalWorkflow.g:4179:3: (otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==105) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalWorkflow.g:4180:4: otherlv_27= 'missingValues' otherlv_28= '{' ( (lv_missingValues_29_0= ruleValueField ) )* otherlv_30= '}'
                    {
                    otherlv_27=(Token)match(input,105,FOLLOW_4); 

                    				newLeafNode(otherlv_27, grammarAccess.getDateAccess().getMissingValuesKeyword_17_0());
                    			
                    otherlv_28=(Token)match(input,14,FOLLOW_106); 

                    				newLeafNode(otherlv_28, grammarAccess.getDateAccess().getLeftCurlyBracketKeyword_17_1());
                    			
                    // InternalWorkflow.g:4188:4: ( (lv_missingValues_29_0= ruleValueField ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==47) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalWorkflow.g:4189:5: (lv_missingValues_29_0= ruleValueField )
                    	    {
                    	    // InternalWorkflow.g:4189:5: (lv_missingValues_29_0= ruleValueField )
                    	    // InternalWorkflow.g:4190:6: lv_missingValues_29_0= ruleValueField
                    	    {

                    	    						newCompositeNode(grammarAccess.getDateAccess().getMissingValuesValueFieldParserRuleCall_17_2_0());
                    	    					
                    	    pushFollow(FOLLOW_106);
                    	    lv_missingValues_29_0=ruleValueField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDateRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"missingValues",
                    	    							lv_missingValues_29_0,
                    	    							"xtext.Workflow.ValueField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_30, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_17_3());
                    			

                    }
                    break;

            }

            otherlv_31=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_31, grammarAccess.getDateAccess().getRightCurlyBracketKeyword_18());
            		

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


    // $ANTLR start "entryRuleInterval"
    // InternalWorkflow.g:4220:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalWorkflow.g:4220:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalWorkflow.g:4221:2: iv_ruleInterval= ruleInterval EOF
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
    // InternalWorkflow.g:4227:1: ruleInterval returns [EObject current=null] : (otherlv_0= 'interval' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_EFLOAT ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_EFLOAT ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_leftMargin_3_0=null;
        Token otherlv_4=null;
        Token lv_rightMargin_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_clousure_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4233:2: ( (otherlv_0= 'interval' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_EFLOAT ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_EFLOAT ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' ) )
            // InternalWorkflow.g:4234:2: (otherlv_0= 'interval' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_EFLOAT ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_EFLOAT ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' )
            {
            // InternalWorkflow.g:4234:2: (otherlv_0= 'interval' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_EFLOAT ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_EFLOAT ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' )
            // InternalWorkflow.g:4235:3: otherlv_0= 'interval' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_EFLOAT ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_EFLOAT ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,113,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getIntervalAccess().getIntervalKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_121); 

            			newLeafNode(otherlv_1, grammarAccess.getIntervalAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,114,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getIntervalAccess().getLeftMarginKeyword_2());
            		
            // InternalWorkflow.g:4247:3: ( (lv_leftMargin_3_0= RULE_EFLOAT ) )
            // InternalWorkflow.g:4248:4: (lv_leftMargin_3_0= RULE_EFLOAT )
            {
            // InternalWorkflow.g:4248:4: (lv_leftMargin_3_0= RULE_EFLOAT )
            // InternalWorkflow.g:4249:5: lv_leftMargin_3_0= RULE_EFLOAT
            {
            lv_leftMargin_3_0=(Token)match(input,RULE_EFLOAT,FOLLOW_122); 

            					newLeafNode(lv_leftMargin_3_0, grammarAccess.getIntervalAccess().getLeftMarginEFloatTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntervalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"leftMargin",
            						lv_leftMargin_3_0,
            						"xtext.Workflow.EFloat");
            				

            }


            }

            otherlv_4=(Token)match(input,115,FOLLOW_37); 

            			newLeafNode(otherlv_4, grammarAccess.getIntervalAccess().getRightMarginKeyword_4());
            		
            // InternalWorkflow.g:4269:3: ( (lv_rightMargin_5_0= RULE_EFLOAT ) )
            // InternalWorkflow.g:4270:4: (lv_rightMargin_5_0= RULE_EFLOAT )
            {
            // InternalWorkflow.g:4270:4: (lv_rightMargin_5_0= RULE_EFLOAT )
            // InternalWorkflow.g:4271:5: lv_rightMargin_5_0= RULE_EFLOAT
            {
            lv_rightMargin_5_0=(Token)match(input,RULE_EFLOAT,FOLLOW_84); 

            					newLeafNode(lv_rightMargin_5_0, grammarAccess.getIntervalAccess().getRightMarginEFloatTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntervalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rightMargin",
            						lv_rightMargin_5_0,
            						"xtext.Workflow.EFloat");
            				

            }


            }

            // InternalWorkflow.g:4287:3: (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==78) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalWorkflow.g:4288:4: otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) )
                    {
                    otherlv_6=(Token)match(input,78,FOLLOW_81); 

                    				newLeafNode(otherlv_6, grammarAccess.getIntervalAccess().getClousureKeyword_6_0());
                    			
                    // InternalWorkflow.g:4292:4: ( (lv_clousure_7_0= ruleClosureType ) )
                    // InternalWorkflow.g:4293:5: (lv_clousure_7_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:4293:5: (lv_clousure_7_0= ruleClosureType )
                    // InternalWorkflow.g:4294:6: lv_clousure_7_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getClousureClosureTypeEnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_clousure_7_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_7_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getIntervalAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleIntervalDate"
    // InternalWorkflow.g:4320:1: entryRuleIntervalDate returns [EObject current=null] : iv_ruleIntervalDate= ruleIntervalDate EOF ;
    public final EObject entryRuleIntervalDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntervalDate = null;


        try {
            // InternalWorkflow.g:4320:53: (iv_ruleIntervalDate= ruleIntervalDate EOF )
            // InternalWorkflow.g:4321:2: iv_ruleIntervalDate= ruleIntervalDate EOF
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
    // InternalWorkflow.g:4327:1: ruleIntervalDate returns [EObject current=null] : (otherlv_0= 'intervalDate' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_STRING ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_STRING ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleIntervalDate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_leftMargin_3_0=null;
        Token otherlv_4=null;
        Token lv_rightMargin_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_clousure_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4333:2: ( (otherlv_0= 'intervalDate' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_STRING ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_STRING ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' ) )
            // InternalWorkflow.g:4334:2: (otherlv_0= 'intervalDate' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_STRING ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_STRING ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' )
            {
            // InternalWorkflow.g:4334:2: (otherlv_0= 'intervalDate' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_STRING ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_STRING ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}' )
            // InternalWorkflow.g:4335:3: otherlv_0= 'intervalDate' otherlv_1= '{' otherlv_2= 'leftMargin' ( (lv_leftMargin_3_0= RULE_STRING ) ) otherlv_4= 'rightMargin' ( (lv_rightMargin_5_0= RULE_STRING ) ) (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,116,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getIntervalDateAccess().getIntervalDateKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_121); 

            			newLeafNode(otherlv_1, grammarAccess.getIntervalDateAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,114,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getIntervalDateAccess().getLeftMarginKeyword_2());
            		
            // InternalWorkflow.g:4347:3: ( (lv_leftMargin_3_0= RULE_STRING ) )
            // InternalWorkflow.g:4348:4: (lv_leftMargin_3_0= RULE_STRING )
            {
            // InternalWorkflow.g:4348:4: (lv_leftMargin_3_0= RULE_STRING )
            // InternalWorkflow.g:4349:5: lv_leftMargin_3_0= RULE_STRING
            {
            lv_leftMargin_3_0=(Token)match(input,RULE_STRING,FOLLOW_122); 

            					newLeafNode(lv_leftMargin_3_0, grammarAccess.getIntervalDateAccess().getLeftMarginSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntervalDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"leftMargin",
            						lv_leftMargin_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,115,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getIntervalDateAccess().getRightMarginKeyword_4());
            		
            // InternalWorkflow.g:4369:3: ( (lv_rightMargin_5_0= RULE_STRING ) )
            // InternalWorkflow.g:4370:4: (lv_rightMargin_5_0= RULE_STRING )
            {
            // InternalWorkflow.g:4370:4: (lv_rightMargin_5_0= RULE_STRING )
            // InternalWorkflow.g:4371:5: lv_rightMargin_5_0= RULE_STRING
            {
            lv_rightMargin_5_0=(Token)match(input,RULE_STRING,FOLLOW_84); 

            					newLeafNode(lv_rightMargin_5_0, grammarAccess.getIntervalDateAccess().getRightMarginSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntervalDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rightMargin",
            						lv_rightMargin_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalWorkflow.g:4387:3: (otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==78) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalWorkflow.g:4388:4: otherlv_6= 'clousure' ( (lv_clousure_7_0= ruleClosureType ) )
                    {
                    otherlv_6=(Token)match(input,78,FOLLOW_81); 

                    				newLeafNode(otherlv_6, grammarAccess.getIntervalDateAccess().getClousureKeyword_6_0());
                    			
                    // InternalWorkflow.g:4392:4: ( (lv_clousure_7_0= ruleClosureType ) )
                    // InternalWorkflow.g:4393:5: (lv_clousure_7_0= ruleClosureType )
                    {
                    // InternalWorkflow.g:4393:5: (lv_clousure_7_0= ruleClosureType )
                    // InternalWorkflow.g:4394:6: lv_clousure_7_0= ruleClosureType
                    {

                    						newCompositeNode(grammarAccess.getIntervalDateAccess().getClousureClosureTypeEnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_clousure_7_0=ruleClosureType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalDateRule());
                    						}
                    						set(
                    							current,
                    							"clousure",
                    							lv_clousure_7_0,
                    							"xtext.Workflow.ClosureType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getIntervalDateAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleValueField"
    // InternalWorkflow.g:4420:1: entryRuleValueField returns [EObject current=null] : iv_ruleValueField= ruleValueField EOF ;
    public final EObject entryRuleValueField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueField = null;


        try {
            // InternalWorkflow.g:4420:51: (iv_ruleValueField= ruleValueField EOF )
            // InternalWorkflow.g:4421:2: iv_ruleValueField= ruleValueField EOF
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
    // InternalWorkflow.g:4427:1: ruleValueField returns [EObject current=null] : (otherlv_0= 'value' ( (lv_value_1_0= RULE_STRING ) ) (otherlv_2= 'count' ( (lv_count_3_0= RULE_EINT ) ) )? ) ;
    public final EObject ruleValueField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_count_3_0=null;


        	enterRule();

        try {
            // InternalWorkflow.g:4433:2: ( (otherlv_0= 'value' ( (lv_value_1_0= RULE_STRING ) ) (otherlv_2= 'count' ( (lv_count_3_0= RULE_EINT ) ) )? ) )
            // InternalWorkflow.g:4434:2: (otherlv_0= 'value' ( (lv_value_1_0= RULE_STRING ) ) (otherlv_2= 'count' ( (lv_count_3_0= RULE_EINT ) ) )? )
            {
            // InternalWorkflow.g:4434:2: (otherlv_0= 'value' ( (lv_value_1_0= RULE_STRING ) ) (otherlv_2= 'count' ( (lv_count_3_0= RULE_EINT ) ) )? )
            // InternalWorkflow.g:4435:3: otherlv_0= 'value' ( (lv_value_1_0= RULE_STRING ) ) (otherlv_2= 'count' ( (lv_count_3_0= RULE_EINT ) ) )?
            {
            otherlv_0=(Token)match(input,47,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getValueFieldAccess().getValueKeyword_0());
            		
            // InternalWorkflow.g:4439:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalWorkflow.g:4440:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalWorkflow.g:4440:4: (lv_value_1_0= RULE_STRING )
            // InternalWorkflow.g:4441:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_123); 

            					newLeafNode(lv_value_1_0, grammarAccess.getValueFieldAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getValueFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalWorkflow.g:4457:3: (otherlv_2= 'count' ( (lv_count_3_0= RULE_EINT ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==117) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalWorkflow.g:4458:4: otherlv_2= 'count' ( (lv_count_3_0= RULE_EINT ) )
                    {
                    otherlv_2=(Token)match(input,117,FOLLOW_113); 

                    				newLeafNode(otherlv_2, grammarAccess.getValueFieldAccess().getCountKeyword_2_0());
                    			
                    // InternalWorkflow.g:4462:4: ( (lv_count_3_0= RULE_EINT ) )
                    // InternalWorkflow.g:4463:5: (lv_count_3_0= RULE_EINT )
                    {
                    // InternalWorkflow.g:4463:5: (lv_count_3_0= RULE_EINT )
                    // InternalWorkflow.g:4464:6: lv_count_3_0= RULE_EINT
                    {
                    lv_count_3_0=(Token)match(input,RULE_EINT,FOLLOW_2); 

                    						newLeafNode(lv_count_3_0, grammarAccess.getValueFieldAccess().getCountEIntTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValueFieldRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"count",
                    							lv_count_3_0,
                    							"xtext.Workflow.EInt");
                    					

                    }


                    }


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
    // $ANTLR end "ruleValueField"


    // $ANTLR start "entryRuleContract"
    // InternalWorkflow.g:4485:1: entryRuleContract returns [EObject current=null] : iv_ruleContract= ruleContract EOF ;
    public final EObject entryRuleContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContract = null;


        try {
            // InternalWorkflow.g:4485:49: (iv_ruleContract= ruleContract EOF )
            // InternalWorkflow.g:4486:2: iv_ruleContract= ruleContract EOF
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
    // InternalWorkflow.g:4492:1: ruleContract returns [EObject current=null] : (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'contractDefinition' ( (lv_contractDefinition_4_0= RULE_ID ) ) otherlv_5= 'contract' ( (lv_contract_6_0= ruleContractElement ) ) otherlv_7= '}' ) ;
    public final EObject ruleContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_contractDefinition_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_contract_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4498:2: ( (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'contractDefinition' ( (lv_contractDefinition_4_0= RULE_ID ) ) otherlv_5= 'contract' ( (lv_contract_6_0= ruleContractElement ) ) otherlv_7= '}' ) )
            // InternalWorkflow.g:4499:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'contractDefinition' ( (lv_contractDefinition_4_0= RULE_ID ) ) otherlv_5= 'contract' ( (lv_contract_6_0= ruleContractElement ) ) otherlv_7= '}' )
            {
            // InternalWorkflow.g:4499:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'contractDefinition' ( (lv_contractDefinition_4_0= RULE_ID ) ) otherlv_5= 'contract' ( (lv_contract_6_0= ruleContractElement ) ) otherlv_7= '}' )
            // InternalWorkflow.g:4500:3: otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'contractDefinition' ( (lv_contractDefinition_4_0= RULE_ID ) ) otherlv_5= 'contract' ( (lv_contract_6_0= ruleContractElement ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,118,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContractAccess().getContractKeyword_0());
            		
            // InternalWorkflow.g:4504:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:4505:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:4505:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:4506:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,14,FOLLOW_124); 

            			newLeafNode(otherlv_2, grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,119,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getContractAccess().getContractDefinitionKeyword_3());
            		
            // InternalWorkflow.g:4530:3: ( (lv_contractDefinition_4_0= RULE_ID ) )
            // InternalWorkflow.g:4531:4: (lv_contractDefinition_4_0= RULE_ID )
            {
            // InternalWorkflow.g:4531:4: (lv_contractDefinition_4_0= RULE_ID )
            // InternalWorkflow.g:4532:5: lv_contractDefinition_4_0= RULE_ID
            {
            lv_contractDefinition_4_0=(Token)match(input,RULE_ID,FOLLOW_125); 

            					newLeafNode(lv_contractDefinition_4_0, grammarAccess.getContractAccess().getContractDefinitionIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractDefinition",
            						lv_contractDefinition_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,118,FOLLOW_126); 

            			newLeafNode(otherlv_5, grammarAccess.getContractAccess().getContractKeyword_5());
            		
            // InternalWorkflow.g:4552:3: ( (lv_contract_6_0= ruleContractElement ) )
            // InternalWorkflow.g:4553:4: (lv_contract_6_0= ruleContractElement )
            {
            // InternalWorkflow.g:4553:4: (lv_contract_6_0= ruleContractElement )
            // InternalWorkflow.g:4554:5: lv_contract_6_0= ruleContractElement
            {

            					newCompositeNode(grammarAccess.getContractAccess().getContractContractElementParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_12);
            lv_contract_6_0=ruleContractElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractRule());
            					}
            					set(
            						current,
            						"contract",
            						lv_contract_6_0,
            						"xtext.Workflow.ContractElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getContractAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleContractElement"
    // InternalWorkflow.g:4579:1: entryRuleContractElement returns [String current=null] : iv_ruleContractElement= ruleContractElement EOF ;
    public final String entryRuleContractElement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractElement = null;


        try {
            // InternalWorkflow.g:4579:55: (iv_ruleContractElement= ruleContractElement EOF )
            // InternalWorkflow.g:4580:2: iv_ruleContractElement= ruleContractElement EOF
            {
             newCompositeNode(grammarAccess.getContractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractElement=ruleContractElement();

            state._fsp--;

             current =iv_ruleContractElement.getText(); 
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
    // $ANTLR end "entryRuleContractElement"


    // $ANTLR start "ruleContractElement"
    // InternalWorkflow.g:4586:1: ruleContractElement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'contractElement' kw= '{' kw= '}' ) ;
    public final AntlrDatatypeRuleToken ruleContractElement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflow.g:4592:2: ( (kw= 'contractElement' kw= '{' kw= '}' ) )
            // InternalWorkflow.g:4593:2: (kw= 'contractElement' kw= '{' kw= '}' )
            {
            // InternalWorkflow.g:4593:2: (kw= 'contractElement' kw= '{' kw= '}' )
            // InternalWorkflow.g:4594:3: kw= 'contractElement' kw= '{' kw= '}'
            {
            kw=(Token)match(input,120,FOLLOW_4); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getContractElementAccess().getContractElementKeyword_0());
            		
            kw=(Token)match(input,14,FOLLOW_12); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getContractElementAccess().getLeftCurlyBracketKeyword_1());
            		
            kw=(Token)match(input,17,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getContractElementAccess().getRightCurlyBracketKeyword_2());
            		

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
    // $ANTLR end "ruleContractElement"


    // $ANTLR start "entryRuleEnvironment"
    // InternalWorkflow.g:4613:1: entryRuleEnvironment returns [EObject current=null] : iv_ruleEnvironment= ruleEnvironment EOF ;
    public final EObject entryRuleEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvironment = null;


        try {
            // InternalWorkflow.g:4613:52: (iv_ruleEnvironment= ruleEnvironment EOF )
            // InternalWorkflow.g:4614:2: iv_ruleEnvironment= ruleEnvironment EOF
            {
             newCompositeNode(grammarAccess.getEnvironmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnvironment=ruleEnvironment();

            state._fsp--;

             current =iv_ruleEnvironment; 
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
    // $ANTLR end "entryRuleEnvironment"


    // $ANTLR start "ruleEnvironment"
    // InternalWorkflow.g:4620:1: ruleEnvironment returns [EObject current=null] : (this_Local_0= ruleLocal | this_AzureCI_1= ruleAzureCI | this_AmazonECS_2= ruleAmazonECS ) ;
    public final EObject ruleEnvironment() throws RecognitionException {
        EObject current = null;

        EObject this_Local_0 = null;

        EObject this_AzureCI_1 = null;

        EObject this_AmazonECS_2 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4626:2: ( (this_Local_0= ruleLocal | this_AzureCI_1= ruleAzureCI | this_AmazonECS_2= ruleAmazonECS ) )
            // InternalWorkflow.g:4627:2: (this_Local_0= ruleLocal | this_AzureCI_1= ruleAzureCI | this_AmazonECS_2= ruleAmazonECS )
            {
            // InternalWorkflow.g:4627:2: (this_Local_0= ruleLocal | this_AzureCI_1= ruleAzureCI | this_AmazonECS_2= ruleAmazonECS )
            int alt83=3;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt83=1;
                }
                break;
            case 127:
                {
                alt83=2;
                }
                break;
            case 132:
                {
                alt83=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalWorkflow.g:4628:3: this_Local_0= ruleLocal
                    {

                    			newCompositeNode(grammarAccess.getEnvironmentAccess().getLocalParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Local_0=ruleLocal();

                    state._fsp--;


                    			current = this_Local_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:4637:3: this_AzureCI_1= ruleAzureCI
                    {

                    			newCompositeNode(grammarAccess.getEnvironmentAccess().getAzureCIParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AzureCI_1=ruleAzureCI();

                    state._fsp--;


                    			current = this_AzureCI_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:4646:3: this_AmazonECS_2= ruleAmazonECS
                    {

                    			newCompositeNode(grammarAccess.getEnvironmentAccess().getAmazonECSParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_AmazonECS_2=ruleAmazonECS();

                    state._fsp--;


                    			current = this_AmazonECS_2;
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
    // $ANTLR end "ruleEnvironment"


    // $ANTLR start "entryRuleLocal"
    // InternalWorkflow.g:4658:1: entryRuleLocal returns [EObject current=null] : iv_ruleLocal= ruleLocal EOF ;
    public final EObject entryRuleLocal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocal = null;


        try {
            // InternalWorkflow.g:4658:46: (iv_ruleLocal= ruleLocal EOF )
            // InternalWorkflow.g:4659:2: iv_ruleLocal= ruleLocal EOF
            {
             newCompositeNode(grammarAccess.getLocalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocal=ruleLocal();

            state._fsp--;

             current =iv_ruleLocal; 
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
    // $ANTLR end "entryRuleLocal"


    // $ANTLR start "ruleLocal"
    // InternalWorkflow.g:4665:1: ruleLocal returns [EObject current=null] : (otherlv_0= 'local' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= '}' ) ;
    public final EObject ruleLocal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_containerName_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_imageName_14_0=null;
        Token otherlv_15=null;
        Token lv_imageTag_16_0=null;
        Token otherlv_17=null;
        EObject lv_storage_7_0 = null;

        EObject lv_developmentTool_12_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4671:2: ( (otherlv_0= 'local' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= '}' ) )
            // InternalWorkflow.g:4672:2: (otherlv_0= 'local' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= '}' )
            {
            // InternalWorkflow.g:4672:2: (otherlv_0= 'local' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= '}' )
            // InternalWorkflow.g:4673:3: otherlv_0= 'local' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,121,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLocalAccess().getLocalKeyword_0());
            		
            // InternalWorkflow.g:4677:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:4678:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:4678:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:4679:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLocalAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getLocalAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getLocalAccess().getPathKeyword_3());
            		
            // InternalWorkflow.g:4703:3: ( (lv_path_4_0= RULE_STRING ) )
            // InternalWorkflow.g:4704:4: (lv_path_4_0= RULE_STRING )
            {
            // InternalWorkflow.g:4704:4: (lv_path_4_0= RULE_STRING )
            // InternalWorkflow.g:4705:5: lv_path_4_0= RULE_STRING
            {
            lv_path_4_0=(Token)match(input,RULE_STRING,FOLLOW_127); 

            					newLeafNode(lv_path_4_0, grammarAccess.getLocalAccess().getPathSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,122,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getLocalAccess().getStorageKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_128); 

            			newLeafNode(otherlv_6, grammarAccess.getLocalAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:4729:3: ( (lv_storage_7_0= ruleStorage ) )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==138||LA84_0==166||LA84_0==169||LA84_0==171) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalWorkflow.g:4730:4: (lv_storage_7_0= ruleStorage )
            	    {
            	    // InternalWorkflow.g:4730:4: (lv_storage_7_0= ruleStorage )
            	    // InternalWorkflow.g:4731:5: lv_storage_7_0= ruleStorage
            	    {

            	    					newCompositeNode(grammarAccess.getLocalAccess().getStorageStorageParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_129);
            	    lv_storage_7_0=ruleStorage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLocalRule());
            	    					}
            	    					add(
            	    						current,
            	    						"storage",
            	    						lv_storage_7_0,
            	    						"xtext.Workflow.Storage");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt84 >= 1 ) break loop84;
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_130); 

            			newLeafNode(otherlv_8, grammarAccess.getLocalAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,123,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getLocalAccess().getContainerNameKeyword_9());
            		
            // InternalWorkflow.g:4756:3: ( (lv_containerName_10_0= RULE_STRING ) )
            // InternalWorkflow.g:4757:4: (lv_containerName_10_0= RULE_STRING )
            {
            // InternalWorkflow.g:4757:4: (lv_containerName_10_0= RULE_STRING )
            // InternalWorkflow.g:4758:5: lv_containerName_10_0= RULE_STRING
            {
            lv_containerName_10_0=(Token)match(input,RULE_STRING,FOLLOW_131); 

            					newLeafNode(lv_containerName_10_0, grammarAccess.getLocalAccess().getContainerNameSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"containerName",
            						lv_containerName_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,124,FOLLOW_131); 

            			newLeafNode(otherlv_11, grammarAccess.getLocalAccess().getDevelopmentToolKeyword_11());
            		
            // InternalWorkflow.g:4778:3: ( (lv_developmentTool_12_0= ruleDevelopmentTool ) )
            // InternalWorkflow.g:4779:4: (lv_developmentTool_12_0= ruleDevelopmentTool )
            {
            // InternalWorkflow.g:4779:4: (lv_developmentTool_12_0= ruleDevelopmentTool )
            // InternalWorkflow.g:4780:5: lv_developmentTool_12_0= ruleDevelopmentTool
            {

            					newCompositeNode(grammarAccess.getLocalAccess().getDevelopmentToolDevelopmentToolParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_132);
            lv_developmentTool_12_0=ruleDevelopmentTool();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocalRule());
            					}
            					set(
            						current,
            						"developmentTool",
            						lv_developmentTool_12_0,
            						"xtext.Workflow.DevelopmentTool");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,125,FOLLOW_15); 

            			newLeafNode(otherlv_13, grammarAccess.getLocalAccess().getImageNameKeyword_13());
            		
            // InternalWorkflow.g:4801:3: ( (lv_imageName_14_0= RULE_STRING ) )
            // InternalWorkflow.g:4802:4: (lv_imageName_14_0= RULE_STRING )
            {
            // InternalWorkflow.g:4802:4: (lv_imageName_14_0= RULE_STRING )
            // InternalWorkflow.g:4803:5: lv_imageName_14_0= RULE_STRING
            {
            lv_imageName_14_0=(Token)match(input,RULE_STRING,FOLLOW_133); 

            					newLeafNode(lv_imageName_14_0, grammarAccess.getLocalAccess().getImageNameSTRINGTerminalRuleCall_14_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imageName",
            						lv_imageName_14_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_15=(Token)match(input,126,FOLLOW_15); 

            			newLeafNode(otherlv_15, grammarAccess.getLocalAccess().getImageTagKeyword_15());
            		
            // InternalWorkflow.g:4823:3: ( (lv_imageTag_16_0= RULE_STRING ) )
            // InternalWorkflow.g:4824:4: (lv_imageTag_16_0= RULE_STRING )
            {
            // InternalWorkflow.g:4824:4: (lv_imageTag_16_0= RULE_STRING )
            // InternalWorkflow.g:4825:5: lv_imageTag_16_0= RULE_STRING
            {
            lv_imageTag_16_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_imageTag_16_0, grammarAccess.getLocalAccess().getImageTagSTRINGTerminalRuleCall_16_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imageTag",
            						lv_imageTag_16_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_17=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getLocalAccess().getRightCurlyBracketKeyword_17());
            		

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
    // $ANTLR end "ruleLocal"


    // $ANTLR start "entryRuleAzureCI"
    // InternalWorkflow.g:4849:1: entryRuleAzureCI returns [EObject current=null] : iv_ruleAzureCI= ruleAzureCI EOF ;
    public final EObject entryRuleAzureCI() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAzureCI = null;


        try {
            // InternalWorkflow.g:4849:48: (iv_ruleAzureCI= ruleAzureCI EOF )
            // InternalWorkflow.g:4850:2: iv_ruleAzureCI= ruleAzureCI EOF
            {
             newCompositeNode(grammarAccess.getAzureCIRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAzureCI=ruleAzureCI();

            state._fsp--;

             current =iv_ruleAzureCI; 
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
    // $ANTLR end "entryRuleAzureCI"


    // $ANTLR start "ruleAzureCI"
    // InternalWorkflow.g:4856:1: ruleAzureCI returns [EObject current=null] : (otherlv_0= 'azureCI' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'acrName' ( (lv_acrName_18_0= RULE_STRING ) ) otherlv_19= 'keyVaultName' ( (lv_keyVaultName_20_0= RULE_STRING ) ) otherlv_21= 'secretName' ( (lv_secretName_22_0= RULE_STRING ) ) otherlv_23= 'blobName' ( (lv_blobName_24_0= RULE_STRING ) ) otherlv_25= '}' ) ;
    public final EObject ruleAzureCI() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_containerName_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_imageName_14_0=null;
        Token otherlv_15=null;
        Token lv_imageTag_16_0=null;
        Token otherlv_17=null;
        Token lv_acrName_18_0=null;
        Token otherlv_19=null;
        Token lv_keyVaultName_20_0=null;
        Token otherlv_21=null;
        Token lv_secretName_22_0=null;
        Token otherlv_23=null;
        Token lv_blobName_24_0=null;
        Token otherlv_25=null;
        EObject lv_storage_7_0 = null;

        EObject lv_developmentTool_12_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:4862:2: ( (otherlv_0= 'azureCI' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'acrName' ( (lv_acrName_18_0= RULE_STRING ) ) otherlv_19= 'keyVaultName' ( (lv_keyVaultName_20_0= RULE_STRING ) ) otherlv_21= 'secretName' ( (lv_secretName_22_0= RULE_STRING ) ) otherlv_23= 'blobName' ( (lv_blobName_24_0= RULE_STRING ) ) otherlv_25= '}' ) )
            // InternalWorkflow.g:4863:2: (otherlv_0= 'azureCI' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'acrName' ( (lv_acrName_18_0= RULE_STRING ) ) otherlv_19= 'keyVaultName' ( (lv_keyVaultName_20_0= RULE_STRING ) ) otherlv_21= 'secretName' ( (lv_secretName_22_0= RULE_STRING ) ) otherlv_23= 'blobName' ( (lv_blobName_24_0= RULE_STRING ) ) otherlv_25= '}' )
            {
            // InternalWorkflow.g:4863:2: (otherlv_0= 'azureCI' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'acrName' ( (lv_acrName_18_0= RULE_STRING ) ) otherlv_19= 'keyVaultName' ( (lv_keyVaultName_20_0= RULE_STRING ) ) otherlv_21= 'secretName' ( (lv_secretName_22_0= RULE_STRING ) ) otherlv_23= 'blobName' ( (lv_blobName_24_0= RULE_STRING ) ) otherlv_25= '}' )
            // InternalWorkflow.g:4864:3: otherlv_0= 'azureCI' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'acrName' ( (lv_acrName_18_0= RULE_STRING ) ) otherlv_19= 'keyVaultName' ( (lv_keyVaultName_20_0= RULE_STRING ) ) otherlv_21= 'secretName' ( (lv_secretName_22_0= RULE_STRING ) ) otherlv_23= 'blobName' ( (lv_blobName_24_0= RULE_STRING ) ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,127,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAzureCIAccess().getAzureCIKeyword_0());
            		
            // InternalWorkflow.g:4868:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:4869:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:4869:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:4870:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAzureCIAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getAzureCIAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getAzureCIAccess().getPathKeyword_3());
            		
            // InternalWorkflow.g:4894:3: ( (lv_path_4_0= RULE_STRING ) )
            // InternalWorkflow.g:4895:4: (lv_path_4_0= RULE_STRING )
            {
            // InternalWorkflow.g:4895:4: (lv_path_4_0= RULE_STRING )
            // InternalWorkflow.g:4896:5: lv_path_4_0= RULE_STRING
            {
            lv_path_4_0=(Token)match(input,RULE_STRING,FOLLOW_127); 

            					newLeafNode(lv_path_4_0, grammarAccess.getAzureCIAccess().getPathSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,122,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getAzureCIAccess().getStorageKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_128); 

            			newLeafNode(otherlv_6, grammarAccess.getAzureCIAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:4920:3: ( (lv_storage_7_0= ruleStorage ) )+
            int cnt85=0;
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==138||LA85_0==166||LA85_0==169||LA85_0==171) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalWorkflow.g:4921:4: (lv_storage_7_0= ruleStorage )
            	    {
            	    // InternalWorkflow.g:4921:4: (lv_storage_7_0= ruleStorage )
            	    // InternalWorkflow.g:4922:5: lv_storage_7_0= ruleStorage
            	    {

            	    					newCompositeNode(grammarAccess.getAzureCIAccess().getStorageStorageParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_129);
            	    lv_storage_7_0=ruleStorage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAzureCIRule());
            	    					}
            	    					add(
            	    						current,
            	    						"storage",
            	    						lv_storage_7_0,
            	    						"xtext.Workflow.Storage");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt85 >= 1 ) break loop85;
                        EarlyExitException eee =
                            new EarlyExitException(85, input);
                        throw eee;
                }
                cnt85++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_130); 

            			newLeafNode(otherlv_8, grammarAccess.getAzureCIAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,123,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getAzureCIAccess().getContainerNameKeyword_9());
            		
            // InternalWorkflow.g:4947:3: ( (lv_containerName_10_0= RULE_STRING ) )
            // InternalWorkflow.g:4948:4: (lv_containerName_10_0= RULE_STRING )
            {
            // InternalWorkflow.g:4948:4: (lv_containerName_10_0= RULE_STRING )
            // InternalWorkflow.g:4949:5: lv_containerName_10_0= RULE_STRING
            {
            lv_containerName_10_0=(Token)match(input,RULE_STRING,FOLLOW_131); 

            					newLeafNode(lv_containerName_10_0, grammarAccess.getAzureCIAccess().getContainerNameSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"containerName",
            						lv_containerName_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,124,FOLLOW_131); 

            			newLeafNode(otherlv_11, grammarAccess.getAzureCIAccess().getDevelopmentToolKeyword_11());
            		
            // InternalWorkflow.g:4969:3: ( (lv_developmentTool_12_0= ruleDevelopmentTool ) )
            // InternalWorkflow.g:4970:4: (lv_developmentTool_12_0= ruleDevelopmentTool )
            {
            // InternalWorkflow.g:4970:4: (lv_developmentTool_12_0= ruleDevelopmentTool )
            // InternalWorkflow.g:4971:5: lv_developmentTool_12_0= ruleDevelopmentTool
            {

            					newCompositeNode(grammarAccess.getAzureCIAccess().getDevelopmentToolDevelopmentToolParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_132);
            lv_developmentTool_12_0=ruleDevelopmentTool();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAzureCIRule());
            					}
            					set(
            						current,
            						"developmentTool",
            						lv_developmentTool_12_0,
            						"xtext.Workflow.DevelopmentTool");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,125,FOLLOW_15); 

            			newLeafNode(otherlv_13, grammarAccess.getAzureCIAccess().getImageNameKeyword_13());
            		
            // InternalWorkflow.g:4992:3: ( (lv_imageName_14_0= RULE_STRING ) )
            // InternalWorkflow.g:4993:4: (lv_imageName_14_0= RULE_STRING )
            {
            // InternalWorkflow.g:4993:4: (lv_imageName_14_0= RULE_STRING )
            // InternalWorkflow.g:4994:5: lv_imageName_14_0= RULE_STRING
            {
            lv_imageName_14_0=(Token)match(input,RULE_STRING,FOLLOW_133); 

            					newLeafNode(lv_imageName_14_0, grammarAccess.getAzureCIAccess().getImageNameSTRINGTerminalRuleCall_14_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imageName",
            						lv_imageName_14_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_15=(Token)match(input,126,FOLLOW_15); 

            			newLeafNode(otherlv_15, grammarAccess.getAzureCIAccess().getImageTagKeyword_15());
            		
            // InternalWorkflow.g:5014:3: ( (lv_imageTag_16_0= RULE_STRING ) )
            // InternalWorkflow.g:5015:4: (lv_imageTag_16_0= RULE_STRING )
            {
            // InternalWorkflow.g:5015:4: (lv_imageTag_16_0= RULE_STRING )
            // InternalWorkflow.g:5016:5: lv_imageTag_16_0= RULE_STRING
            {
            lv_imageTag_16_0=(Token)match(input,RULE_STRING,FOLLOW_134); 

            					newLeafNode(lv_imageTag_16_0, grammarAccess.getAzureCIAccess().getImageTagSTRINGTerminalRuleCall_16_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imageTag",
            						lv_imageTag_16_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_17=(Token)match(input,128,FOLLOW_15); 

            			newLeafNode(otherlv_17, grammarAccess.getAzureCIAccess().getAcrNameKeyword_17());
            		
            // InternalWorkflow.g:5036:3: ( (lv_acrName_18_0= RULE_STRING ) )
            // InternalWorkflow.g:5037:4: (lv_acrName_18_0= RULE_STRING )
            {
            // InternalWorkflow.g:5037:4: (lv_acrName_18_0= RULE_STRING )
            // InternalWorkflow.g:5038:5: lv_acrName_18_0= RULE_STRING
            {
            lv_acrName_18_0=(Token)match(input,RULE_STRING,FOLLOW_135); 

            					newLeafNode(lv_acrName_18_0, grammarAccess.getAzureCIAccess().getAcrNameSTRINGTerminalRuleCall_18_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"acrName",
            						lv_acrName_18_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_19=(Token)match(input,129,FOLLOW_15); 

            			newLeafNode(otherlv_19, grammarAccess.getAzureCIAccess().getKeyVaultNameKeyword_19());
            		
            // InternalWorkflow.g:5058:3: ( (lv_keyVaultName_20_0= RULE_STRING ) )
            // InternalWorkflow.g:5059:4: (lv_keyVaultName_20_0= RULE_STRING )
            {
            // InternalWorkflow.g:5059:4: (lv_keyVaultName_20_0= RULE_STRING )
            // InternalWorkflow.g:5060:5: lv_keyVaultName_20_0= RULE_STRING
            {
            lv_keyVaultName_20_0=(Token)match(input,RULE_STRING,FOLLOW_136); 

            					newLeafNode(lv_keyVaultName_20_0, grammarAccess.getAzureCIAccess().getKeyVaultNameSTRINGTerminalRuleCall_20_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"keyVaultName",
            						lv_keyVaultName_20_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_21=(Token)match(input,130,FOLLOW_15); 

            			newLeafNode(otherlv_21, grammarAccess.getAzureCIAccess().getSecretNameKeyword_21());
            		
            // InternalWorkflow.g:5080:3: ( (lv_secretName_22_0= RULE_STRING ) )
            // InternalWorkflow.g:5081:4: (lv_secretName_22_0= RULE_STRING )
            {
            // InternalWorkflow.g:5081:4: (lv_secretName_22_0= RULE_STRING )
            // InternalWorkflow.g:5082:5: lv_secretName_22_0= RULE_STRING
            {
            lv_secretName_22_0=(Token)match(input,RULE_STRING,FOLLOW_137); 

            					newLeafNode(lv_secretName_22_0, grammarAccess.getAzureCIAccess().getSecretNameSTRINGTerminalRuleCall_22_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"secretName",
            						lv_secretName_22_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_23=(Token)match(input,131,FOLLOW_15); 

            			newLeafNode(otherlv_23, grammarAccess.getAzureCIAccess().getBlobNameKeyword_23());
            		
            // InternalWorkflow.g:5102:3: ( (lv_blobName_24_0= RULE_STRING ) )
            // InternalWorkflow.g:5103:4: (lv_blobName_24_0= RULE_STRING )
            {
            // InternalWorkflow.g:5103:4: (lv_blobName_24_0= RULE_STRING )
            // InternalWorkflow.g:5104:5: lv_blobName_24_0= RULE_STRING
            {
            lv_blobName_24_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_blobName_24_0, grammarAccess.getAzureCIAccess().getBlobNameSTRINGTerminalRuleCall_24_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureCIRule());
            					}
            					setWithLastConsumed(
            						current,
            						"blobName",
            						lv_blobName_24_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_25=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_25, grammarAccess.getAzureCIAccess().getRightCurlyBracketKeyword_25());
            		

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
    // $ANTLR end "ruleAzureCI"


    // $ANTLR start "entryRuleAmazonECS"
    // InternalWorkflow.g:5128:1: entryRuleAmazonECS returns [EObject current=null] : iv_ruleAmazonECS= ruleAmazonECS EOF ;
    public final EObject entryRuleAmazonECS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAmazonECS = null;


        try {
            // InternalWorkflow.g:5128:50: (iv_ruleAmazonECS= ruleAmazonECS EOF )
            // InternalWorkflow.g:5129:2: iv_ruleAmazonECS= ruleAmazonECS EOF
            {
             newCompositeNode(grammarAccess.getAmazonECSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAmazonECS=ruleAmazonECS();

            state._fsp--;

             current =iv_ruleAmazonECS; 
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
    // $ANTLR end "entryRuleAmazonECS"


    // $ANTLR start "ruleAmazonECS"
    // InternalWorkflow.g:5135:1: ruleAmazonECS returns [EObject current=null] : (otherlv_0= 'amazonECS' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'secretId' ( (lv_secretId_18_0= RULE_STRING ) ) otherlv_19= 'region' ( (lv_region_20_0= RULE_STRING ) ) otherlv_21= 'key' ( (lv_key_22_0= RULE_STRING ) ) otherlv_23= '}' ) ;
    public final EObject ruleAmazonECS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_containerName_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_imageName_14_0=null;
        Token otherlv_15=null;
        Token lv_imageTag_16_0=null;
        Token otherlv_17=null;
        Token lv_secretId_18_0=null;
        Token otherlv_19=null;
        Token lv_region_20_0=null;
        Token otherlv_21=null;
        Token lv_key_22_0=null;
        Token otherlv_23=null;
        EObject lv_storage_7_0 = null;

        EObject lv_developmentTool_12_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5141:2: ( (otherlv_0= 'amazonECS' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'secretId' ( (lv_secretId_18_0= RULE_STRING ) ) otherlv_19= 'region' ( (lv_region_20_0= RULE_STRING ) ) otherlv_21= 'key' ( (lv_key_22_0= RULE_STRING ) ) otherlv_23= '}' ) )
            // InternalWorkflow.g:5142:2: (otherlv_0= 'amazonECS' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'secretId' ( (lv_secretId_18_0= RULE_STRING ) ) otherlv_19= 'region' ( (lv_region_20_0= RULE_STRING ) ) otherlv_21= 'key' ( (lv_key_22_0= RULE_STRING ) ) otherlv_23= '}' )
            {
            // InternalWorkflow.g:5142:2: (otherlv_0= 'amazonECS' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'secretId' ( (lv_secretId_18_0= RULE_STRING ) ) otherlv_19= 'region' ( (lv_region_20_0= RULE_STRING ) ) otherlv_21= 'key' ( (lv_key_22_0= RULE_STRING ) ) otherlv_23= '}' )
            // InternalWorkflow.g:5143:3: otherlv_0= 'amazonECS' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= 'storage' otherlv_6= '{' ( (lv_storage_7_0= ruleStorage ) )+ otherlv_8= '}' otherlv_9= 'containerName' ( (lv_containerName_10_0= RULE_STRING ) ) otherlv_11= 'developmentTool' ( (lv_developmentTool_12_0= ruleDevelopmentTool ) ) otherlv_13= 'imageName' ( (lv_imageName_14_0= RULE_STRING ) ) otherlv_15= 'imageTag' ( (lv_imageTag_16_0= RULE_STRING ) ) otherlv_17= 'secretId' ( (lv_secretId_18_0= RULE_STRING ) ) otherlv_19= 'region' ( (lv_region_20_0= RULE_STRING ) ) otherlv_21= 'key' ( (lv_key_22_0= RULE_STRING ) ) otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,132,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAmazonECSAccess().getAmazonECSKeyword_0());
            		
            // InternalWorkflow.g:5147:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:5148:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:5148:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:5149:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAmazonECSAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getAmazonECSAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getAmazonECSAccess().getPathKeyword_3());
            		
            // InternalWorkflow.g:5173:3: ( (lv_path_4_0= RULE_STRING ) )
            // InternalWorkflow.g:5174:4: (lv_path_4_0= RULE_STRING )
            {
            // InternalWorkflow.g:5174:4: (lv_path_4_0= RULE_STRING )
            // InternalWorkflow.g:5175:5: lv_path_4_0= RULE_STRING
            {
            lv_path_4_0=(Token)match(input,RULE_STRING,FOLLOW_127); 

            					newLeafNode(lv_path_4_0, grammarAccess.getAmazonECSAccess().getPathSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,122,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getAmazonECSAccess().getStorageKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_128); 

            			newLeafNode(otherlv_6, grammarAccess.getAmazonECSAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:5199:3: ( (lv_storage_7_0= ruleStorage ) )+
            int cnt86=0;
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==138||LA86_0==166||LA86_0==169||LA86_0==171) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalWorkflow.g:5200:4: (lv_storage_7_0= ruleStorage )
            	    {
            	    // InternalWorkflow.g:5200:4: (lv_storage_7_0= ruleStorage )
            	    // InternalWorkflow.g:5201:5: lv_storage_7_0= ruleStorage
            	    {

            	    					newCompositeNode(grammarAccess.getAmazonECSAccess().getStorageStorageParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_129);
            	    lv_storage_7_0=ruleStorage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAmazonECSRule());
            	    					}
            	    					add(
            	    						current,
            	    						"storage",
            	    						lv_storage_7_0,
            	    						"xtext.Workflow.Storage");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt86 >= 1 ) break loop86;
                        EarlyExitException eee =
                            new EarlyExitException(86, input);
                        throw eee;
                }
                cnt86++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_130); 

            			newLeafNode(otherlv_8, grammarAccess.getAmazonECSAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,123,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getAmazonECSAccess().getContainerNameKeyword_9());
            		
            // InternalWorkflow.g:5226:3: ( (lv_containerName_10_0= RULE_STRING ) )
            // InternalWorkflow.g:5227:4: (lv_containerName_10_0= RULE_STRING )
            {
            // InternalWorkflow.g:5227:4: (lv_containerName_10_0= RULE_STRING )
            // InternalWorkflow.g:5228:5: lv_containerName_10_0= RULE_STRING
            {
            lv_containerName_10_0=(Token)match(input,RULE_STRING,FOLLOW_131); 

            					newLeafNode(lv_containerName_10_0, grammarAccess.getAmazonECSAccess().getContainerNameSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"containerName",
            						lv_containerName_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,124,FOLLOW_131); 

            			newLeafNode(otherlv_11, grammarAccess.getAmazonECSAccess().getDevelopmentToolKeyword_11());
            		
            // InternalWorkflow.g:5248:3: ( (lv_developmentTool_12_0= ruleDevelopmentTool ) )
            // InternalWorkflow.g:5249:4: (lv_developmentTool_12_0= ruleDevelopmentTool )
            {
            // InternalWorkflow.g:5249:4: (lv_developmentTool_12_0= ruleDevelopmentTool )
            // InternalWorkflow.g:5250:5: lv_developmentTool_12_0= ruleDevelopmentTool
            {

            					newCompositeNode(grammarAccess.getAmazonECSAccess().getDevelopmentToolDevelopmentToolParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_132);
            lv_developmentTool_12_0=ruleDevelopmentTool();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAmazonECSRule());
            					}
            					set(
            						current,
            						"developmentTool",
            						lv_developmentTool_12_0,
            						"xtext.Workflow.DevelopmentTool");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,125,FOLLOW_15); 

            			newLeafNode(otherlv_13, grammarAccess.getAmazonECSAccess().getImageNameKeyword_13());
            		
            // InternalWorkflow.g:5271:3: ( (lv_imageName_14_0= RULE_STRING ) )
            // InternalWorkflow.g:5272:4: (lv_imageName_14_0= RULE_STRING )
            {
            // InternalWorkflow.g:5272:4: (lv_imageName_14_0= RULE_STRING )
            // InternalWorkflow.g:5273:5: lv_imageName_14_0= RULE_STRING
            {
            lv_imageName_14_0=(Token)match(input,RULE_STRING,FOLLOW_133); 

            					newLeafNode(lv_imageName_14_0, grammarAccess.getAmazonECSAccess().getImageNameSTRINGTerminalRuleCall_14_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imageName",
            						lv_imageName_14_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_15=(Token)match(input,126,FOLLOW_15); 

            			newLeafNode(otherlv_15, grammarAccess.getAmazonECSAccess().getImageTagKeyword_15());
            		
            // InternalWorkflow.g:5293:3: ( (lv_imageTag_16_0= RULE_STRING ) )
            // InternalWorkflow.g:5294:4: (lv_imageTag_16_0= RULE_STRING )
            {
            // InternalWorkflow.g:5294:4: (lv_imageTag_16_0= RULE_STRING )
            // InternalWorkflow.g:5295:5: lv_imageTag_16_0= RULE_STRING
            {
            lv_imageTag_16_0=(Token)match(input,RULE_STRING,FOLLOW_138); 

            					newLeafNode(lv_imageTag_16_0, grammarAccess.getAmazonECSAccess().getImageTagSTRINGTerminalRuleCall_16_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"imageTag",
            						lv_imageTag_16_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_17=(Token)match(input,133,FOLLOW_15); 

            			newLeafNode(otherlv_17, grammarAccess.getAmazonECSAccess().getSecretIdKeyword_17());
            		
            // InternalWorkflow.g:5315:3: ( (lv_secretId_18_0= RULE_STRING ) )
            // InternalWorkflow.g:5316:4: (lv_secretId_18_0= RULE_STRING )
            {
            // InternalWorkflow.g:5316:4: (lv_secretId_18_0= RULE_STRING )
            // InternalWorkflow.g:5317:5: lv_secretId_18_0= RULE_STRING
            {
            lv_secretId_18_0=(Token)match(input,RULE_STRING,FOLLOW_139); 

            					newLeafNode(lv_secretId_18_0, grammarAccess.getAmazonECSAccess().getSecretIdSTRINGTerminalRuleCall_18_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"secretId",
            						lv_secretId_18_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_19=(Token)match(input,134,FOLLOW_15); 

            			newLeafNode(otherlv_19, grammarAccess.getAmazonECSAccess().getRegionKeyword_19());
            		
            // InternalWorkflow.g:5337:3: ( (lv_region_20_0= RULE_STRING ) )
            // InternalWorkflow.g:5338:4: (lv_region_20_0= RULE_STRING )
            {
            // InternalWorkflow.g:5338:4: (lv_region_20_0= RULE_STRING )
            // InternalWorkflow.g:5339:5: lv_region_20_0= RULE_STRING
            {
            lv_region_20_0=(Token)match(input,RULE_STRING,FOLLOW_140); 

            					newLeafNode(lv_region_20_0, grammarAccess.getAmazonECSAccess().getRegionSTRINGTerminalRuleCall_20_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"region",
            						lv_region_20_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_21=(Token)match(input,135,FOLLOW_15); 

            			newLeafNode(otherlv_21, grammarAccess.getAmazonECSAccess().getKeyKeyword_21());
            		
            // InternalWorkflow.g:5359:3: ( (lv_key_22_0= RULE_STRING ) )
            // InternalWorkflow.g:5360:4: (lv_key_22_0= RULE_STRING )
            {
            // InternalWorkflow.g:5360:4: (lv_key_22_0= RULE_STRING )
            // InternalWorkflow.g:5361:5: lv_key_22_0= RULE_STRING
            {
            lv_key_22_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_key_22_0, grammarAccess.getAmazonECSAccess().getKeySTRINGTerminalRuleCall_22_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonECSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"key",
            						lv_key_22_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_23=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_23, grammarAccess.getAmazonECSAccess().getRightCurlyBracketKeyword_23());
            		

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
    // $ANTLR end "ruleAmazonECS"


    // $ANTLR start "entryRuleDevelopmentTool"
    // InternalWorkflow.g:5385:1: entryRuleDevelopmentTool returns [EObject current=null] : iv_ruleDevelopmentTool= ruleDevelopmentTool EOF ;
    public final EObject entryRuleDevelopmentTool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevelopmentTool = null;


        try {
            // InternalWorkflow.g:5385:56: (iv_ruleDevelopmentTool= ruleDevelopmentTool EOF )
            // InternalWorkflow.g:5386:2: iv_ruleDevelopmentTool= ruleDevelopmentTool EOF
            {
             newCompositeNode(grammarAccess.getDevelopmentToolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDevelopmentTool=ruleDevelopmentTool();

            state._fsp--;

             current =iv_ruleDevelopmentTool; 
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
    // $ANTLR end "entryRuleDevelopmentTool"


    // $ANTLR start "ruleDevelopmentTool"
    // InternalWorkflow.g:5392:1: ruleDevelopmentTool returns [EObject current=null] : (otherlv_0= 'developmentTool' otherlv_1= '{' otherlv_2= 'version' ( (lv_version_3_0= RULE_STRING ) ) otherlv_4= 'tool' ( (lv_tool_5_0= ruleTOOL ) ) otherlv_6= '}' ) ;
    public final EObject ruleDevelopmentTool() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_version_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_tool_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5398:2: ( (otherlv_0= 'developmentTool' otherlv_1= '{' otherlv_2= 'version' ( (lv_version_3_0= RULE_STRING ) ) otherlv_4= 'tool' ( (lv_tool_5_0= ruleTOOL ) ) otherlv_6= '}' ) )
            // InternalWorkflow.g:5399:2: (otherlv_0= 'developmentTool' otherlv_1= '{' otherlv_2= 'version' ( (lv_version_3_0= RULE_STRING ) ) otherlv_4= 'tool' ( (lv_tool_5_0= ruleTOOL ) ) otherlv_6= '}' )
            {
            // InternalWorkflow.g:5399:2: (otherlv_0= 'developmentTool' otherlv_1= '{' otherlv_2= 'version' ( (lv_version_3_0= RULE_STRING ) ) otherlv_4= 'tool' ( (lv_tool_5_0= ruleTOOL ) ) otherlv_6= '}' )
            // InternalWorkflow.g:5400:3: otherlv_0= 'developmentTool' otherlv_1= '{' otherlv_2= 'version' ( (lv_version_3_0= RULE_STRING ) ) otherlv_4= 'tool' ( (lv_tool_5_0= ruleTOOL ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,124,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDevelopmentToolAccess().getDevelopmentToolKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_141); 

            			newLeafNode(otherlv_1, grammarAccess.getDevelopmentToolAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,136,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getDevelopmentToolAccess().getVersionKeyword_2());
            		
            // InternalWorkflow.g:5412:3: ( (lv_version_3_0= RULE_STRING ) )
            // InternalWorkflow.g:5413:4: (lv_version_3_0= RULE_STRING )
            {
            // InternalWorkflow.g:5413:4: (lv_version_3_0= RULE_STRING )
            // InternalWorkflow.g:5414:5: lv_version_3_0= RULE_STRING
            {
            lv_version_3_0=(Token)match(input,RULE_STRING,FOLLOW_142); 

            					newLeafNode(lv_version_3_0, grammarAccess.getDevelopmentToolAccess().getVersionSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDevelopmentToolRule());
            					}
            					setWithLastConsumed(
            						current,
            						"version",
            						lv_version_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,137,FOLLOW_143); 

            			newLeafNode(otherlv_4, grammarAccess.getDevelopmentToolAccess().getToolKeyword_4());
            		
            // InternalWorkflow.g:5434:3: ( (lv_tool_5_0= ruleTOOL ) )
            // InternalWorkflow.g:5435:4: (lv_tool_5_0= ruleTOOL )
            {
            // InternalWorkflow.g:5435:4: (lv_tool_5_0= ruleTOOL )
            // InternalWorkflow.g:5436:5: lv_tool_5_0= ruleTOOL
            {

            					newCompositeNode(grammarAccess.getDevelopmentToolAccess().getToolTOOLEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_12);
            lv_tool_5_0=ruleTOOL();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDevelopmentToolRule());
            					}
            					set(
            						current,
            						"tool",
            						lv_tool_5_0,
            						"xtext.Workflow.TOOL");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getDevelopmentToolAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleDevelopmentTool"


    // $ANTLR start "entryRuleStorage"
    // InternalWorkflow.g:5461:1: entryRuleStorage returns [EObject current=null] : iv_ruleStorage= ruleStorage EOF ;
    public final EObject entryRuleStorage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorage = null;


        try {
            // InternalWorkflow.g:5461:48: (iv_ruleStorage= ruleStorage EOF )
            // InternalWorkflow.g:5462:2: iv_ruleStorage= ruleStorage EOF
            {
             newCompositeNode(grammarAccess.getStorageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorage=ruleStorage();

            state._fsp--;

             current =iv_ruleStorage; 
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
    // $ANTLR end "entryRuleStorage"


    // $ANTLR start "ruleStorage"
    // InternalWorkflow.g:5468:1: ruleStorage returns [EObject current=null] : (this_Database_0= ruleDatabase | this_LocalFolder_1= ruleLocalFolder | this_AmazonS3_2= ruleAmazonS3 | this_AzureBlob_3= ruleAzureBlob ) ;
    public final EObject ruleStorage() throws RecognitionException {
        EObject current = null;

        EObject this_Database_0 = null;

        EObject this_LocalFolder_1 = null;

        EObject this_AmazonS3_2 = null;

        EObject this_AzureBlob_3 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5474:2: ( (this_Database_0= ruleDatabase | this_LocalFolder_1= ruleLocalFolder | this_AmazonS3_2= ruleAmazonS3 | this_AzureBlob_3= ruleAzureBlob ) )
            // InternalWorkflow.g:5475:2: (this_Database_0= ruleDatabase | this_LocalFolder_1= ruleLocalFolder | this_AmazonS3_2= ruleAmazonS3 | this_AzureBlob_3= ruleAzureBlob )
            {
            // InternalWorkflow.g:5475:2: (this_Database_0= ruleDatabase | this_LocalFolder_1= ruleLocalFolder | this_AmazonS3_2= ruleAmazonS3 | this_AzureBlob_3= ruleAzureBlob )
            int alt87=4;
            switch ( input.LA(1) ) {
            case 138:
                {
                alt87=1;
                }
                break;
            case 166:
                {
                alt87=2;
                }
                break;
            case 169:
                {
                alt87=3;
                }
                break;
            case 171:
                {
                alt87=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalWorkflow.g:5476:3: this_Database_0= ruleDatabase
                    {

                    			newCompositeNode(grammarAccess.getStorageAccess().getDatabaseParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Database_0=ruleDatabase();

                    state._fsp--;


                    			current = this_Database_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5485:3: this_LocalFolder_1= ruleLocalFolder
                    {

                    			newCompositeNode(grammarAccess.getStorageAccess().getLocalFolderParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LocalFolder_1=ruleLocalFolder();

                    state._fsp--;


                    			current = this_LocalFolder_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5494:3: this_AmazonS3_2= ruleAmazonS3
                    {

                    			newCompositeNode(grammarAccess.getStorageAccess().getAmazonS3ParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_AmazonS3_2=ruleAmazonS3();

                    state._fsp--;


                    			current = this_AmazonS3_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:5503:3: this_AzureBlob_3= ruleAzureBlob
                    {

                    			newCompositeNode(grammarAccess.getStorageAccess().getAzureBlobParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AzureBlob_3=ruleAzureBlob();

                    state._fsp--;


                    			current = this_AzureBlob_3;
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
    // $ANTLR end "ruleStorage"


    // $ANTLR start "entryRuleDatabase"
    // InternalWorkflow.g:5515:1: entryRuleDatabase returns [EObject current=null] : iv_ruleDatabase= ruleDatabase EOF ;
    public final EObject entryRuleDatabase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatabase = null;


        try {
            // InternalWorkflow.g:5515:49: (iv_ruleDatabase= ruleDatabase EOF )
            // InternalWorkflow.g:5516:2: iv_ruleDatabase= ruleDatabase EOF
            {
             newCompositeNode(grammarAccess.getDatabaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDatabase=ruleDatabase();

            state._fsp--;

             current =iv_ruleDatabase; 
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
    // $ANTLR end "entryRuleDatabase"


    // $ANTLR start "ruleDatabase"
    // InternalWorkflow.g:5522:1: ruleDatabase returns [EObject current=null] : (otherlv_0= 'database' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'host' ( (lv_host_4_0= RULE_STRING ) ) otherlv_5= 'port' ( (lv_port_6_0= RULE_STRING ) ) otherlv_7= 'type' ( (lv_type_8_0= ruleDBTYPE ) ) otherlv_9= 'auth' ( (lv_auth_10_0= ruleAuthentication ) ) otherlv_11= 'dbName' ( (lv_dbName_12_0= RULE_STRING ) ) otherlv_13= 'tables' otherlv_14= '{' ( (lv_table_15_0= ruleTable ) )+ otherlv_16= '}' otherlv_17= '}' ) ;
    public final EObject ruleDatabase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_storageName_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_host_4_0=null;
        Token otherlv_5=null;
        Token lv_port_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_dbName_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Enumerator lv_type_8_0 = null;

        EObject lv_auth_10_0 = null;

        EObject lv_table_15_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5528:2: ( (otherlv_0= 'database' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'host' ( (lv_host_4_0= RULE_STRING ) ) otherlv_5= 'port' ( (lv_port_6_0= RULE_STRING ) ) otherlv_7= 'type' ( (lv_type_8_0= ruleDBTYPE ) ) otherlv_9= 'auth' ( (lv_auth_10_0= ruleAuthentication ) ) otherlv_11= 'dbName' ( (lv_dbName_12_0= RULE_STRING ) ) otherlv_13= 'tables' otherlv_14= '{' ( (lv_table_15_0= ruleTable ) )+ otherlv_16= '}' otherlv_17= '}' ) )
            // InternalWorkflow.g:5529:2: (otherlv_0= 'database' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'host' ( (lv_host_4_0= RULE_STRING ) ) otherlv_5= 'port' ( (lv_port_6_0= RULE_STRING ) ) otherlv_7= 'type' ( (lv_type_8_0= ruleDBTYPE ) ) otherlv_9= 'auth' ( (lv_auth_10_0= ruleAuthentication ) ) otherlv_11= 'dbName' ( (lv_dbName_12_0= RULE_STRING ) ) otherlv_13= 'tables' otherlv_14= '{' ( (lv_table_15_0= ruleTable ) )+ otherlv_16= '}' otherlv_17= '}' )
            {
            // InternalWorkflow.g:5529:2: (otherlv_0= 'database' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'host' ( (lv_host_4_0= RULE_STRING ) ) otherlv_5= 'port' ( (lv_port_6_0= RULE_STRING ) ) otherlv_7= 'type' ( (lv_type_8_0= ruleDBTYPE ) ) otherlv_9= 'auth' ( (lv_auth_10_0= ruleAuthentication ) ) otherlv_11= 'dbName' ( (lv_dbName_12_0= RULE_STRING ) ) otherlv_13= 'tables' otherlv_14= '{' ( (lv_table_15_0= ruleTable ) )+ otherlv_16= '}' otherlv_17= '}' )
            // InternalWorkflow.g:5530:3: otherlv_0= 'database' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'host' ( (lv_host_4_0= RULE_STRING ) ) otherlv_5= 'port' ( (lv_port_6_0= RULE_STRING ) ) otherlv_7= 'type' ( (lv_type_8_0= ruleDBTYPE ) ) otherlv_9= 'auth' ( (lv_auth_10_0= ruleAuthentication ) ) otherlv_11= 'dbName' ( (lv_dbName_12_0= RULE_STRING ) ) otherlv_13= 'tables' otherlv_14= '{' ( (lv_table_15_0= ruleTable ) )+ otherlv_16= '}' otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,138,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDatabaseAccess().getDatabaseKeyword_0());
            		
            // InternalWorkflow.g:5534:3: ( (lv_storageName_1_0= RULE_ID ) )
            // InternalWorkflow.g:5535:4: (lv_storageName_1_0= RULE_ID )
            {
            // InternalWorkflow.g:5535:4: (lv_storageName_1_0= RULE_ID )
            // InternalWorkflow.g:5536:5: lv_storageName_1_0= RULE_ID
            {
            lv_storageName_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_storageName_1_0, grammarAccess.getDatabaseAccess().getStorageNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDatabaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"storageName",
            						lv_storageName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_144); 

            			newLeafNode(otherlv_2, grammarAccess.getDatabaseAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,139,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getDatabaseAccess().getHostKeyword_3());
            		
            // InternalWorkflow.g:5560:3: ( (lv_host_4_0= RULE_STRING ) )
            // InternalWorkflow.g:5561:4: (lv_host_4_0= RULE_STRING )
            {
            // InternalWorkflow.g:5561:4: (lv_host_4_0= RULE_STRING )
            // InternalWorkflow.g:5562:5: lv_host_4_0= RULE_STRING
            {
            lv_host_4_0=(Token)match(input,RULE_STRING,FOLLOW_145); 

            					newLeafNode(lv_host_4_0, grammarAccess.getDatabaseAccess().getHostSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDatabaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"host",
            						lv_host_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,140,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getDatabaseAccess().getPortKeyword_5());
            		
            // InternalWorkflow.g:5582:3: ( (lv_port_6_0= RULE_STRING ) )
            // InternalWorkflow.g:5583:4: (lv_port_6_0= RULE_STRING )
            {
            // InternalWorkflow.g:5583:4: (lv_port_6_0= RULE_STRING )
            // InternalWorkflow.g:5584:5: lv_port_6_0= RULE_STRING
            {
            lv_port_6_0=(Token)match(input,RULE_STRING,FOLLOW_89); 

            					newLeafNode(lv_port_6_0, grammarAccess.getDatabaseAccess().getPortSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDatabaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"port",
            						lv_port_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,87,FOLLOW_146); 

            			newLeafNode(otherlv_7, grammarAccess.getDatabaseAccess().getTypeKeyword_7());
            		
            // InternalWorkflow.g:5604:3: ( (lv_type_8_0= ruleDBTYPE ) )
            // InternalWorkflow.g:5605:4: (lv_type_8_0= ruleDBTYPE )
            {
            // InternalWorkflow.g:5605:4: (lv_type_8_0= ruleDBTYPE )
            // InternalWorkflow.g:5606:5: lv_type_8_0= ruleDBTYPE
            {

            					newCompositeNode(grammarAccess.getDatabaseAccess().getTypeDBTYPEEnumRuleCall_8_0());
            				
            pushFollow(FOLLOW_147);
            lv_type_8_0=ruleDBTYPE();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDatabaseRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_8_0,
            						"xtext.Workflow.DBTYPE");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,141,FOLLOW_148); 

            			newLeafNode(otherlv_9, grammarAccess.getDatabaseAccess().getAuthKeyword_9());
            		
            // InternalWorkflow.g:5627:3: ( (lv_auth_10_0= ruleAuthentication ) )
            // InternalWorkflow.g:5628:4: (lv_auth_10_0= ruleAuthentication )
            {
            // InternalWorkflow.g:5628:4: (lv_auth_10_0= ruleAuthentication )
            // InternalWorkflow.g:5629:5: lv_auth_10_0= ruleAuthentication
            {

            					newCompositeNode(grammarAccess.getDatabaseAccess().getAuthAuthenticationParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_149);
            lv_auth_10_0=ruleAuthentication();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDatabaseRule());
            					}
            					set(
            						current,
            						"auth",
            						lv_auth_10_0,
            						"xtext.Workflow.Authentication");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,142,FOLLOW_15); 

            			newLeafNode(otherlv_11, grammarAccess.getDatabaseAccess().getDbNameKeyword_11());
            		
            // InternalWorkflow.g:5650:3: ( (lv_dbName_12_0= RULE_STRING ) )
            // InternalWorkflow.g:5651:4: (lv_dbName_12_0= RULE_STRING )
            {
            // InternalWorkflow.g:5651:4: (lv_dbName_12_0= RULE_STRING )
            // InternalWorkflow.g:5652:5: lv_dbName_12_0= RULE_STRING
            {
            lv_dbName_12_0=(Token)match(input,RULE_STRING,FOLLOW_150); 

            					newLeafNode(lv_dbName_12_0, grammarAccess.getDatabaseAccess().getDbNameSTRINGTerminalRuleCall_12_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDatabaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dbName",
            						lv_dbName_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_13=(Token)match(input,143,FOLLOW_4); 

            			newLeafNode(otherlv_13, grammarAccess.getDatabaseAccess().getTablesKeyword_13());
            		
            otherlv_14=(Token)match(input,14,FOLLOW_151); 

            			newLeafNode(otherlv_14, grammarAccess.getDatabaseAccess().getLeftCurlyBracketKeyword_14());
            		
            // InternalWorkflow.g:5676:3: ( (lv_table_15_0= ruleTable ) )+
            int cnt88=0;
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==165) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalWorkflow.g:5677:4: (lv_table_15_0= ruleTable )
            	    {
            	    // InternalWorkflow.g:5677:4: (lv_table_15_0= ruleTable )
            	    // InternalWorkflow.g:5678:5: lv_table_15_0= ruleTable
            	    {

            	    					newCompositeNode(grammarAccess.getDatabaseAccess().getTableTableParserRuleCall_15_0());
            	    				
            	    pushFollow(FOLLOW_152);
            	    lv_table_15_0=ruleTable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDatabaseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"table",
            	    						lv_table_15_0,
            	    						"xtext.Workflow.Table");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt88 >= 1 ) break loop88;
                        EarlyExitException eee =
                            new EarlyExitException(88, input);
                        throw eee;
                }
                cnt88++;
            } while (true);

            otherlv_16=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_16, grammarAccess.getDatabaseAccess().getRightCurlyBracketKeyword_16());
            		
            otherlv_17=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getDatabaseAccess().getRightCurlyBracketKeyword_17());
            		

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
    // $ANTLR end "ruleDatabase"


    // $ANTLR start "entryRuleAuthentication"
    // InternalWorkflow.g:5707:1: entryRuleAuthentication returns [EObject current=null] : iv_ruleAuthentication= ruleAuthentication EOF ;
    public final EObject entryRuleAuthentication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthentication = null;


        try {
            // InternalWorkflow.g:5707:55: (iv_ruleAuthentication= ruleAuthentication EOF )
            // InternalWorkflow.g:5708:2: iv_ruleAuthentication= ruleAuthentication EOF
            {
             newCompositeNode(grammarAccess.getAuthenticationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAuthentication=ruleAuthentication();

            state._fsp--;

             current =iv_ruleAuthentication; 
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
    // $ANTLR end "entryRuleAuthentication"


    // $ANTLR start "ruleAuthentication"
    // InternalWorkflow.g:5714:1: ruleAuthentication returns [EObject current=null] : (this_Credentials_0= ruleCredentials | this_SSL_1= ruleSSL | this_OAuth2_2= ruleOAuth2 | this_AWS_3= ruleAWS ) ;
    public final EObject ruleAuthentication() throws RecognitionException {
        EObject current = null;

        EObject this_Credentials_0 = null;

        EObject this_SSL_1 = null;

        EObject this_OAuth2_2 = null;

        EObject this_AWS_3 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:5720:2: ( (this_Credentials_0= ruleCredentials | this_SSL_1= ruleSSL | this_OAuth2_2= ruleOAuth2 | this_AWS_3= ruleAWS ) )
            // InternalWorkflow.g:5721:2: (this_Credentials_0= ruleCredentials | this_SSL_1= ruleSSL | this_OAuth2_2= ruleOAuth2 | this_AWS_3= ruleAWS )
            {
            // InternalWorkflow.g:5721:2: (this_Credentials_0= ruleCredentials | this_SSL_1= ruleSSL | this_OAuth2_2= ruleOAuth2 | this_AWS_3= ruleAWS )
            int alt89=4;
            switch ( input.LA(1) ) {
            case 144:
                {
                alt89=1;
                }
                break;
            case 147:
                {
                alt89=2;
                }
                break;
            case 151:
                {
                alt89=3;
                }
                break;
            case 157:
                {
                alt89=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalWorkflow.g:5722:3: this_Credentials_0= ruleCredentials
                    {

                    			newCompositeNode(grammarAccess.getAuthenticationAccess().getCredentialsParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Credentials_0=ruleCredentials();

                    state._fsp--;


                    			current = this_Credentials_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:5731:3: this_SSL_1= ruleSSL
                    {

                    			newCompositeNode(grammarAccess.getAuthenticationAccess().getSSLParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SSL_1=ruleSSL();

                    state._fsp--;


                    			current = this_SSL_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:5740:3: this_OAuth2_2= ruleOAuth2
                    {

                    			newCompositeNode(grammarAccess.getAuthenticationAccess().getOAuth2ParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OAuth2_2=ruleOAuth2();

                    state._fsp--;


                    			current = this_OAuth2_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:5749:3: this_AWS_3= ruleAWS
                    {

                    			newCompositeNode(grammarAccess.getAuthenticationAccess().getAWSParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AWS_3=ruleAWS();

                    state._fsp--;


                    			current = this_AWS_3;
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
    // $ANTLR end "ruleAuthentication"


    // $ANTLR start "entryRuleCredentials"
    // InternalWorkflow.g:5761:1: entryRuleCredentials returns [EObject current=null] : iv_ruleCredentials= ruleCredentials EOF ;
    public final EObject entryRuleCredentials() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCredentials = null;


        try {
            // InternalWorkflow.g:5761:52: (iv_ruleCredentials= ruleCredentials EOF )
            // InternalWorkflow.g:5762:2: iv_ruleCredentials= ruleCredentials EOF
            {
             newCompositeNode(grammarAccess.getCredentialsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCredentials=ruleCredentials();

            state._fsp--;

             current =iv_ruleCredentials; 
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
    // $ANTLR end "entryRuleCredentials"


    // $ANTLR start "ruleCredentials"
    // InternalWorkflow.g:5768:1: ruleCredentials returns [EObject current=null] : (otherlv_0= 'credentials' otherlv_1= '{' otherlv_2= 'username' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'passwd' ( (lv_passwd_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleCredentials() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_username_3_0=null;
        Token otherlv_4=null;
        Token lv_passwd_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5774:2: ( (otherlv_0= 'credentials' otherlv_1= '{' otherlv_2= 'username' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'passwd' ( (lv_passwd_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // InternalWorkflow.g:5775:2: (otherlv_0= 'credentials' otherlv_1= '{' otherlv_2= 'username' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'passwd' ( (lv_passwd_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // InternalWorkflow.g:5775:2: (otherlv_0= 'credentials' otherlv_1= '{' otherlv_2= 'username' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'passwd' ( (lv_passwd_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // InternalWorkflow.g:5776:3: otherlv_0= 'credentials' otherlv_1= '{' otherlv_2= 'username' ( (lv_username_3_0= RULE_STRING ) ) otherlv_4= 'passwd' ( (lv_passwd_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,144,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getCredentialsAccess().getCredentialsKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_153); 

            			newLeafNode(otherlv_1, grammarAccess.getCredentialsAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,145,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getCredentialsAccess().getUsernameKeyword_2());
            		
            // InternalWorkflow.g:5788:3: ( (lv_username_3_0= RULE_STRING ) )
            // InternalWorkflow.g:5789:4: (lv_username_3_0= RULE_STRING )
            {
            // InternalWorkflow.g:5789:4: (lv_username_3_0= RULE_STRING )
            // InternalWorkflow.g:5790:5: lv_username_3_0= RULE_STRING
            {
            lv_username_3_0=(Token)match(input,RULE_STRING,FOLLOW_154); 

            					newLeafNode(lv_username_3_0, grammarAccess.getCredentialsAccess().getUsernameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCredentialsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"username",
            						lv_username_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,146,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getCredentialsAccess().getPasswdKeyword_4());
            		
            // InternalWorkflow.g:5810:3: ( (lv_passwd_5_0= RULE_STRING ) )
            // InternalWorkflow.g:5811:4: (lv_passwd_5_0= RULE_STRING )
            {
            // InternalWorkflow.g:5811:4: (lv_passwd_5_0= RULE_STRING )
            // InternalWorkflow.g:5812:5: lv_passwd_5_0= RULE_STRING
            {
            lv_passwd_5_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_passwd_5_0, grammarAccess.getCredentialsAccess().getPasswdSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCredentialsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"passwd",
            						lv_passwd_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCredentialsAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleCredentials"


    // $ANTLR start "entryRuleSSL"
    // InternalWorkflow.g:5836:1: entryRuleSSL returns [EObject current=null] : iv_ruleSSL= ruleSSL EOF ;
    public final EObject entryRuleSSL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSSL = null;


        try {
            // InternalWorkflow.g:5836:44: (iv_ruleSSL= ruleSSL EOF )
            // InternalWorkflow.g:5837:2: iv_ruleSSL= ruleSSL EOF
            {
             newCompositeNode(grammarAccess.getSSLRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSSL=ruleSSL();

            state._fsp--;

             current =iv_ruleSSL; 
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
    // $ANTLR end "entryRuleSSL"


    // $ANTLR start "ruleSSL"
    // InternalWorkflow.g:5843:1: ruleSSL returns [EObject current=null] : (otherlv_0= 'ssl' otherlv_1= '{' otherlv_2= 'path_sslcert' ( (lv_path_sslcert_3_0= RULE_STRING ) ) otherlv_4= 'path_sslkey' ( (lv_path_sslkey_5_0= RULE_STRING ) ) otherlv_6= 'path_sslrootcert' ( (lv_path_sslrootcert_7_0= RULE_STRING ) ) otherlv_8= '}' ) ;
    public final EObject ruleSSL() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_path_sslcert_3_0=null;
        Token otherlv_4=null;
        Token lv_path_sslkey_5_0=null;
        Token otherlv_6=null;
        Token lv_path_sslrootcert_7_0=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5849:2: ( (otherlv_0= 'ssl' otherlv_1= '{' otherlv_2= 'path_sslcert' ( (lv_path_sslcert_3_0= RULE_STRING ) ) otherlv_4= 'path_sslkey' ( (lv_path_sslkey_5_0= RULE_STRING ) ) otherlv_6= 'path_sslrootcert' ( (lv_path_sslrootcert_7_0= RULE_STRING ) ) otherlv_8= '}' ) )
            // InternalWorkflow.g:5850:2: (otherlv_0= 'ssl' otherlv_1= '{' otherlv_2= 'path_sslcert' ( (lv_path_sslcert_3_0= RULE_STRING ) ) otherlv_4= 'path_sslkey' ( (lv_path_sslkey_5_0= RULE_STRING ) ) otherlv_6= 'path_sslrootcert' ( (lv_path_sslrootcert_7_0= RULE_STRING ) ) otherlv_8= '}' )
            {
            // InternalWorkflow.g:5850:2: (otherlv_0= 'ssl' otherlv_1= '{' otherlv_2= 'path_sslcert' ( (lv_path_sslcert_3_0= RULE_STRING ) ) otherlv_4= 'path_sslkey' ( (lv_path_sslkey_5_0= RULE_STRING ) ) otherlv_6= 'path_sslrootcert' ( (lv_path_sslrootcert_7_0= RULE_STRING ) ) otherlv_8= '}' )
            // InternalWorkflow.g:5851:3: otherlv_0= 'ssl' otherlv_1= '{' otherlv_2= 'path_sslcert' ( (lv_path_sslcert_3_0= RULE_STRING ) ) otherlv_4= 'path_sslkey' ( (lv_path_sslkey_5_0= RULE_STRING ) ) otherlv_6= 'path_sslrootcert' ( (lv_path_sslrootcert_7_0= RULE_STRING ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,147,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSSLAccess().getSslKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_155); 

            			newLeafNode(otherlv_1, grammarAccess.getSSLAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,148,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getSSLAccess().getPath_sslcertKeyword_2());
            		
            // InternalWorkflow.g:5863:3: ( (lv_path_sslcert_3_0= RULE_STRING ) )
            // InternalWorkflow.g:5864:4: (lv_path_sslcert_3_0= RULE_STRING )
            {
            // InternalWorkflow.g:5864:4: (lv_path_sslcert_3_0= RULE_STRING )
            // InternalWorkflow.g:5865:5: lv_path_sslcert_3_0= RULE_STRING
            {
            lv_path_sslcert_3_0=(Token)match(input,RULE_STRING,FOLLOW_156); 

            					newLeafNode(lv_path_sslcert_3_0, grammarAccess.getSSLAccess().getPath_sslcertSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSSLRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path_sslcert",
            						lv_path_sslcert_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,149,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getSSLAccess().getPath_sslkeyKeyword_4());
            		
            // InternalWorkflow.g:5885:3: ( (lv_path_sslkey_5_0= RULE_STRING ) )
            // InternalWorkflow.g:5886:4: (lv_path_sslkey_5_0= RULE_STRING )
            {
            // InternalWorkflow.g:5886:4: (lv_path_sslkey_5_0= RULE_STRING )
            // InternalWorkflow.g:5887:5: lv_path_sslkey_5_0= RULE_STRING
            {
            lv_path_sslkey_5_0=(Token)match(input,RULE_STRING,FOLLOW_157); 

            					newLeafNode(lv_path_sslkey_5_0, grammarAccess.getSSLAccess().getPath_sslkeySTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSSLRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path_sslkey",
            						lv_path_sslkey_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,150,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getSSLAccess().getPath_sslrootcertKeyword_6());
            		
            // InternalWorkflow.g:5907:3: ( (lv_path_sslrootcert_7_0= RULE_STRING ) )
            // InternalWorkflow.g:5908:4: (lv_path_sslrootcert_7_0= RULE_STRING )
            {
            // InternalWorkflow.g:5908:4: (lv_path_sslrootcert_7_0= RULE_STRING )
            // InternalWorkflow.g:5909:5: lv_path_sslrootcert_7_0= RULE_STRING
            {
            lv_path_sslrootcert_7_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_path_sslrootcert_7_0, grammarAccess.getSSLAccess().getPath_sslrootcertSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSSLRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path_sslrootcert",
            						lv_path_sslrootcert_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_8=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSSLAccess().getRightCurlyBracketKeyword_8());
            		

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
    // $ANTLR end "ruleSSL"


    // $ANTLR start "entryRuleOAuth2"
    // InternalWorkflow.g:5933:1: entryRuleOAuth2 returns [EObject current=null] : iv_ruleOAuth2= ruleOAuth2 EOF ;
    public final EObject entryRuleOAuth2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOAuth2 = null;


        try {
            // InternalWorkflow.g:5933:47: (iv_ruleOAuth2= ruleOAuth2 EOF )
            // InternalWorkflow.g:5934:2: iv_ruleOAuth2= ruleOAuth2 EOF
            {
             newCompositeNode(grammarAccess.getOAuth2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOAuth2=ruleOAuth2();

            state._fsp--;

             current =iv_ruleOAuth2; 
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
    // $ANTLR end "entryRuleOAuth2"


    // $ANTLR start "ruleOAuth2"
    // InternalWorkflow.g:5940:1: ruleOAuth2 returns [EObject current=null] : (otherlv_0= 'oauth2' otherlv_1= '{' otherlv_2= 'clientId' ( (lv_clientId_3_0= RULE_STRING ) ) otherlv_4= 'clientSecret' ( (lv_clientSecret_5_0= RULE_STRING ) ) otherlv_6= 'tokenUrl' ( (lv_tokenUrl_7_0= RULE_STRING ) ) otherlv_8= 'accessToken' ( (lv_accessToken_9_0= RULE_STRING ) ) otherlv_10= 'scope' ( (lv_scope_11_0= RULE_STRING ) ) otherlv_12= '}' ) ;
    public final EObject ruleOAuth2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_clientId_3_0=null;
        Token otherlv_4=null;
        Token lv_clientSecret_5_0=null;
        Token otherlv_6=null;
        Token lv_tokenUrl_7_0=null;
        Token otherlv_8=null;
        Token lv_accessToken_9_0=null;
        Token otherlv_10=null;
        Token lv_scope_11_0=null;
        Token otherlv_12=null;


        	enterRule();

        try {
            // InternalWorkflow.g:5946:2: ( (otherlv_0= 'oauth2' otherlv_1= '{' otherlv_2= 'clientId' ( (lv_clientId_3_0= RULE_STRING ) ) otherlv_4= 'clientSecret' ( (lv_clientSecret_5_0= RULE_STRING ) ) otherlv_6= 'tokenUrl' ( (lv_tokenUrl_7_0= RULE_STRING ) ) otherlv_8= 'accessToken' ( (lv_accessToken_9_0= RULE_STRING ) ) otherlv_10= 'scope' ( (lv_scope_11_0= RULE_STRING ) ) otherlv_12= '}' ) )
            // InternalWorkflow.g:5947:2: (otherlv_0= 'oauth2' otherlv_1= '{' otherlv_2= 'clientId' ( (lv_clientId_3_0= RULE_STRING ) ) otherlv_4= 'clientSecret' ( (lv_clientSecret_5_0= RULE_STRING ) ) otherlv_6= 'tokenUrl' ( (lv_tokenUrl_7_0= RULE_STRING ) ) otherlv_8= 'accessToken' ( (lv_accessToken_9_0= RULE_STRING ) ) otherlv_10= 'scope' ( (lv_scope_11_0= RULE_STRING ) ) otherlv_12= '}' )
            {
            // InternalWorkflow.g:5947:2: (otherlv_0= 'oauth2' otherlv_1= '{' otherlv_2= 'clientId' ( (lv_clientId_3_0= RULE_STRING ) ) otherlv_4= 'clientSecret' ( (lv_clientSecret_5_0= RULE_STRING ) ) otherlv_6= 'tokenUrl' ( (lv_tokenUrl_7_0= RULE_STRING ) ) otherlv_8= 'accessToken' ( (lv_accessToken_9_0= RULE_STRING ) ) otherlv_10= 'scope' ( (lv_scope_11_0= RULE_STRING ) ) otherlv_12= '}' )
            // InternalWorkflow.g:5948:3: otherlv_0= 'oauth2' otherlv_1= '{' otherlv_2= 'clientId' ( (lv_clientId_3_0= RULE_STRING ) ) otherlv_4= 'clientSecret' ( (lv_clientSecret_5_0= RULE_STRING ) ) otherlv_6= 'tokenUrl' ( (lv_tokenUrl_7_0= RULE_STRING ) ) otherlv_8= 'accessToken' ( (lv_accessToken_9_0= RULE_STRING ) ) otherlv_10= 'scope' ( (lv_scope_11_0= RULE_STRING ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,151,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getOAuth2Access().getOauth2Keyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_158); 

            			newLeafNode(otherlv_1, grammarAccess.getOAuth2Access().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,152,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getOAuth2Access().getClientIdKeyword_2());
            		
            // InternalWorkflow.g:5960:3: ( (lv_clientId_3_0= RULE_STRING ) )
            // InternalWorkflow.g:5961:4: (lv_clientId_3_0= RULE_STRING )
            {
            // InternalWorkflow.g:5961:4: (lv_clientId_3_0= RULE_STRING )
            // InternalWorkflow.g:5962:5: lv_clientId_3_0= RULE_STRING
            {
            lv_clientId_3_0=(Token)match(input,RULE_STRING,FOLLOW_159); 

            					newLeafNode(lv_clientId_3_0, grammarAccess.getOAuth2Access().getClientIdSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOAuth2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"clientId",
            						lv_clientId_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,153,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getOAuth2Access().getClientSecretKeyword_4());
            		
            // InternalWorkflow.g:5982:3: ( (lv_clientSecret_5_0= RULE_STRING ) )
            // InternalWorkflow.g:5983:4: (lv_clientSecret_5_0= RULE_STRING )
            {
            // InternalWorkflow.g:5983:4: (lv_clientSecret_5_0= RULE_STRING )
            // InternalWorkflow.g:5984:5: lv_clientSecret_5_0= RULE_STRING
            {
            lv_clientSecret_5_0=(Token)match(input,RULE_STRING,FOLLOW_160); 

            					newLeafNode(lv_clientSecret_5_0, grammarAccess.getOAuth2Access().getClientSecretSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOAuth2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"clientSecret",
            						lv_clientSecret_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,154,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getOAuth2Access().getTokenUrlKeyword_6());
            		
            // InternalWorkflow.g:6004:3: ( (lv_tokenUrl_7_0= RULE_STRING ) )
            // InternalWorkflow.g:6005:4: (lv_tokenUrl_7_0= RULE_STRING )
            {
            // InternalWorkflow.g:6005:4: (lv_tokenUrl_7_0= RULE_STRING )
            // InternalWorkflow.g:6006:5: lv_tokenUrl_7_0= RULE_STRING
            {
            lv_tokenUrl_7_0=(Token)match(input,RULE_STRING,FOLLOW_161); 

            					newLeafNode(lv_tokenUrl_7_0, grammarAccess.getOAuth2Access().getTokenUrlSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOAuth2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"tokenUrl",
            						lv_tokenUrl_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_8=(Token)match(input,155,FOLLOW_15); 

            			newLeafNode(otherlv_8, grammarAccess.getOAuth2Access().getAccessTokenKeyword_8());
            		
            // InternalWorkflow.g:6026:3: ( (lv_accessToken_9_0= RULE_STRING ) )
            // InternalWorkflow.g:6027:4: (lv_accessToken_9_0= RULE_STRING )
            {
            // InternalWorkflow.g:6027:4: (lv_accessToken_9_0= RULE_STRING )
            // InternalWorkflow.g:6028:5: lv_accessToken_9_0= RULE_STRING
            {
            lv_accessToken_9_0=(Token)match(input,RULE_STRING,FOLLOW_162); 

            					newLeafNode(lv_accessToken_9_0, grammarAccess.getOAuth2Access().getAccessTokenSTRINGTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOAuth2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"accessToken",
            						lv_accessToken_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_10=(Token)match(input,156,FOLLOW_15); 

            			newLeafNode(otherlv_10, grammarAccess.getOAuth2Access().getScopeKeyword_10());
            		
            // InternalWorkflow.g:6048:3: ( (lv_scope_11_0= RULE_STRING ) )
            // InternalWorkflow.g:6049:4: (lv_scope_11_0= RULE_STRING )
            {
            // InternalWorkflow.g:6049:4: (lv_scope_11_0= RULE_STRING )
            // InternalWorkflow.g:6050:5: lv_scope_11_0= RULE_STRING
            {
            lv_scope_11_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_scope_11_0, grammarAccess.getOAuth2Access().getScopeSTRINGTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOAuth2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"scope",
            						lv_scope_11_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_12=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getOAuth2Access().getRightCurlyBracketKeyword_12());
            		

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
    // $ANTLR end "ruleOAuth2"


    // $ANTLR start "entryRuleAWS"
    // InternalWorkflow.g:6074:1: entryRuleAWS returns [EObject current=null] : iv_ruleAWS= ruleAWS EOF ;
    public final EObject entryRuleAWS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAWS = null;


        try {
            // InternalWorkflow.g:6074:44: (iv_ruleAWS= ruleAWS EOF )
            // InternalWorkflow.g:6075:2: iv_ruleAWS= ruleAWS EOF
            {
             newCompositeNode(grammarAccess.getAWSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAWS=ruleAWS();

            state._fsp--;

             current =iv_ruleAWS; 
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
    // $ANTLR end "entryRuleAWS"


    // $ANTLR start "ruleAWS"
    // InternalWorkflow.g:6081:1: ruleAWS returns [EObject current=null] : (otherlv_0= 'aws' otherlv_1= '{' otherlv_2= 'region' ( (lv_region_3_0= RULE_STRING ) ) otherlv_4= 'accessKey' ( (lv_accessKey_5_0= RULE_STRING ) ) otherlv_6= 'endpointURL' ( (lv_endpointURL_7_0= RULE_STRING ) ) otherlv_8= 'secretId' ( (lv_secretId_9_0= RULE_STRING ) ) otherlv_10= '}' ) ;
    public final EObject ruleAWS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_region_3_0=null;
        Token otherlv_4=null;
        Token lv_accessKey_5_0=null;
        Token otherlv_6=null;
        Token lv_endpointURL_7_0=null;
        Token otherlv_8=null;
        Token lv_secretId_9_0=null;
        Token otherlv_10=null;


        	enterRule();

        try {
            // InternalWorkflow.g:6087:2: ( (otherlv_0= 'aws' otherlv_1= '{' otherlv_2= 'region' ( (lv_region_3_0= RULE_STRING ) ) otherlv_4= 'accessKey' ( (lv_accessKey_5_0= RULE_STRING ) ) otherlv_6= 'endpointURL' ( (lv_endpointURL_7_0= RULE_STRING ) ) otherlv_8= 'secretId' ( (lv_secretId_9_0= RULE_STRING ) ) otherlv_10= '}' ) )
            // InternalWorkflow.g:6088:2: (otherlv_0= 'aws' otherlv_1= '{' otherlv_2= 'region' ( (lv_region_3_0= RULE_STRING ) ) otherlv_4= 'accessKey' ( (lv_accessKey_5_0= RULE_STRING ) ) otherlv_6= 'endpointURL' ( (lv_endpointURL_7_0= RULE_STRING ) ) otherlv_8= 'secretId' ( (lv_secretId_9_0= RULE_STRING ) ) otherlv_10= '}' )
            {
            // InternalWorkflow.g:6088:2: (otherlv_0= 'aws' otherlv_1= '{' otherlv_2= 'region' ( (lv_region_3_0= RULE_STRING ) ) otherlv_4= 'accessKey' ( (lv_accessKey_5_0= RULE_STRING ) ) otherlv_6= 'endpointURL' ( (lv_endpointURL_7_0= RULE_STRING ) ) otherlv_8= 'secretId' ( (lv_secretId_9_0= RULE_STRING ) ) otherlv_10= '}' )
            // InternalWorkflow.g:6089:3: otherlv_0= 'aws' otherlv_1= '{' otherlv_2= 'region' ( (lv_region_3_0= RULE_STRING ) ) otherlv_4= 'accessKey' ( (lv_accessKey_5_0= RULE_STRING ) ) otherlv_6= 'endpointURL' ( (lv_endpointURL_7_0= RULE_STRING ) ) otherlv_8= 'secretId' ( (lv_secretId_9_0= RULE_STRING ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,157,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAWSAccess().getAwsKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_139); 

            			newLeafNode(otherlv_1, grammarAccess.getAWSAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,134,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getAWSAccess().getRegionKeyword_2());
            		
            // InternalWorkflow.g:6101:3: ( (lv_region_3_0= RULE_STRING ) )
            // InternalWorkflow.g:6102:4: (lv_region_3_0= RULE_STRING )
            {
            // InternalWorkflow.g:6102:4: (lv_region_3_0= RULE_STRING )
            // InternalWorkflow.g:6103:5: lv_region_3_0= RULE_STRING
            {
            lv_region_3_0=(Token)match(input,RULE_STRING,FOLLOW_163); 

            					newLeafNode(lv_region_3_0, grammarAccess.getAWSAccess().getRegionSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAWSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"region",
            						lv_region_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,158,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getAWSAccess().getAccessKeyKeyword_4());
            		
            // InternalWorkflow.g:6123:3: ( (lv_accessKey_5_0= RULE_STRING ) )
            // InternalWorkflow.g:6124:4: (lv_accessKey_5_0= RULE_STRING )
            {
            // InternalWorkflow.g:6124:4: (lv_accessKey_5_0= RULE_STRING )
            // InternalWorkflow.g:6125:5: lv_accessKey_5_0= RULE_STRING
            {
            lv_accessKey_5_0=(Token)match(input,RULE_STRING,FOLLOW_164); 

            					newLeafNode(lv_accessKey_5_0, grammarAccess.getAWSAccess().getAccessKeySTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAWSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"accessKey",
            						lv_accessKey_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,159,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getAWSAccess().getEndpointURLKeyword_6());
            		
            // InternalWorkflow.g:6145:3: ( (lv_endpointURL_7_0= RULE_STRING ) )
            // InternalWorkflow.g:6146:4: (lv_endpointURL_7_0= RULE_STRING )
            {
            // InternalWorkflow.g:6146:4: (lv_endpointURL_7_0= RULE_STRING )
            // InternalWorkflow.g:6147:5: lv_endpointURL_7_0= RULE_STRING
            {
            lv_endpointURL_7_0=(Token)match(input,RULE_STRING,FOLLOW_138); 

            					newLeafNode(lv_endpointURL_7_0, grammarAccess.getAWSAccess().getEndpointURLSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAWSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"endpointURL",
            						lv_endpointURL_7_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_8=(Token)match(input,133,FOLLOW_15); 

            			newLeafNode(otherlv_8, grammarAccess.getAWSAccess().getSecretIdKeyword_8());
            		
            // InternalWorkflow.g:6167:3: ( (lv_secretId_9_0= RULE_STRING ) )
            // InternalWorkflow.g:6168:4: (lv_secretId_9_0= RULE_STRING )
            {
            // InternalWorkflow.g:6168:4: (lv_secretId_9_0= RULE_STRING )
            // InternalWorkflow.g:6169:5: lv_secretId_9_0= RULE_STRING
            {
            lv_secretId_9_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_secretId_9_0, grammarAccess.getAWSAccess().getSecretIdSTRINGTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAWSRule());
            					}
            					setWithLastConsumed(
            						current,
            						"secretId",
            						lv_secretId_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_10=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getAWSAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleAWS"


    // $ANTLR start "entryRuleFile"
    // InternalWorkflow.g:6193:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // InternalWorkflow.g:6193:45: (iv_ruleFile= ruleFile EOF )
            // InternalWorkflow.g:6194:2: iv_ruleFile= ruleFile EOF
            {
             newCompositeNode(grammarAccess.getFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
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
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalWorkflow.g:6200:1: ruleFile returns [EObject current=null] : (otherlv_0= 'file' otherlv_1= '{' otherlv_2= 'type' ( (lv_type_3_0= ruleFileType ) ) otherlv_4= 'dataDictionary' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'csv_sep' ( (lv_csv_sep_7_0= RULE_STRING ) ) )? (otherlv_8= 'hdf5_key' ( (lv_hdf5_key_9_0= RULE_STRING ) ) )? (otherlv_10= 'csv_thousandsSep' ( (lv_csv_thousandsSep_11_0= RULE_STRING ) ) )? (otherlv_12= 'csv_decimalSep' ( (lv_csv_decimalSep_13_0= RULE_STRING ) ) )? otherlv_14= '}' ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_csv_sep_7_0=null;
        Token otherlv_8=null;
        Token lv_hdf5_key_9_0=null;
        Token otherlv_10=null;
        Token lv_csv_thousandsSep_11_0=null;
        Token otherlv_12=null;
        Token lv_csv_decimalSep_13_0=null;
        Token otherlv_14=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:6206:2: ( (otherlv_0= 'file' otherlv_1= '{' otherlv_2= 'type' ( (lv_type_3_0= ruleFileType ) ) otherlv_4= 'dataDictionary' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'csv_sep' ( (lv_csv_sep_7_0= RULE_STRING ) ) )? (otherlv_8= 'hdf5_key' ( (lv_hdf5_key_9_0= RULE_STRING ) ) )? (otherlv_10= 'csv_thousandsSep' ( (lv_csv_thousandsSep_11_0= RULE_STRING ) ) )? (otherlv_12= 'csv_decimalSep' ( (lv_csv_decimalSep_13_0= RULE_STRING ) ) )? otherlv_14= '}' ) )
            // InternalWorkflow.g:6207:2: (otherlv_0= 'file' otherlv_1= '{' otherlv_2= 'type' ( (lv_type_3_0= ruleFileType ) ) otherlv_4= 'dataDictionary' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'csv_sep' ( (lv_csv_sep_7_0= RULE_STRING ) ) )? (otherlv_8= 'hdf5_key' ( (lv_hdf5_key_9_0= RULE_STRING ) ) )? (otherlv_10= 'csv_thousandsSep' ( (lv_csv_thousandsSep_11_0= RULE_STRING ) ) )? (otherlv_12= 'csv_decimalSep' ( (lv_csv_decimalSep_13_0= RULE_STRING ) ) )? otherlv_14= '}' )
            {
            // InternalWorkflow.g:6207:2: (otherlv_0= 'file' otherlv_1= '{' otherlv_2= 'type' ( (lv_type_3_0= ruleFileType ) ) otherlv_4= 'dataDictionary' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'csv_sep' ( (lv_csv_sep_7_0= RULE_STRING ) ) )? (otherlv_8= 'hdf5_key' ( (lv_hdf5_key_9_0= RULE_STRING ) ) )? (otherlv_10= 'csv_thousandsSep' ( (lv_csv_thousandsSep_11_0= RULE_STRING ) ) )? (otherlv_12= 'csv_decimalSep' ( (lv_csv_decimalSep_13_0= RULE_STRING ) ) )? otherlv_14= '}' )
            // InternalWorkflow.g:6208:3: otherlv_0= 'file' otherlv_1= '{' otherlv_2= 'type' ( (lv_type_3_0= ruleFileType ) ) otherlv_4= 'dataDictionary' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'csv_sep' ( (lv_csv_sep_7_0= RULE_STRING ) ) )? (otherlv_8= 'hdf5_key' ( (lv_hdf5_key_9_0= RULE_STRING ) ) )? (otherlv_10= 'csv_thousandsSep' ( (lv_csv_thousandsSep_11_0= RULE_STRING ) ) )? (otherlv_12= 'csv_decimalSep' ( (lv_csv_decimalSep_13_0= RULE_STRING ) ) )? otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,160,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFileAccess().getFileKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_89); 

            			newLeafNode(otherlv_1, grammarAccess.getFileAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,87,FOLLOW_165); 

            			newLeafNode(otherlv_2, grammarAccess.getFileAccess().getTypeKeyword_2());
            		
            // InternalWorkflow.g:6220:3: ( (lv_type_3_0= ruleFileType ) )
            // InternalWorkflow.g:6221:4: (lv_type_3_0= ruleFileType )
            {
            // InternalWorkflow.g:6221:4: (lv_type_3_0= ruleFileType )
            // InternalWorkflow.g:6222:5: lv_type_3_0= ruleFileType
            {

            					newCompositeNode(grammarAccess.getFileAccess().getTypeFileTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_17);
            lv_type_3_0=ruleFileType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFileRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"xtext.Workflow.FileType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,94,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getFileAccess().getDataDictionaryKeyword_4());
            		
            // InternalWorkflow.g:6243:3: ( (otherlv_5= RULE_ID ) )
            // InternalWorkflow.g:6244:4: (otherlv_5= RULE_ID )
            {
            // InternalWorkflow.g:6244:4: (otherlv_5= RULE_ID )
            // InternalWorkflow.g:6245:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFileRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_166); 

            					newLeafNode(otherlv_5, grammarAccess.getFileAccess().getDataDictionaryDataDictionaryCrossReference_5_0());
            				

            }


            }

            // InternalWorkflow.g:6256:3: (otherlv_6= 'csv_sep' ( (lv_csv_sep_7_0= RULE_STRING ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==161) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalWorkflow.g:6257:4: otherlv_6= 'csv_sep' ( (lv_csv_sep_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,161,FOLLOW_15); 

                    				newLeafNode(otherlv_6, grammarAccess.getFileAccess().getCsv_sepKeyword_6_0());
                    			
                    // InternalWorkflow.g:6261:4: ( (lv_csv_sep_7_0= RULE_STRING ) )
                    // InternalWorkflow.g:6262:5: (lv_csv_sep_7_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:6262:5: (lv_csv_sep_7_0= RULE_STRING )
                    // InternalWorkflow.g:6263:6: lv_csv_sep_7_0= RULE_STRING
                    {
                    lv_csv_sep_7_0=(Token)match(input,RULE_STRING,FOLLOW_167); 

                    						newLeafNode(lv_csv_sep_7_0, grammarAccess.getFileAccess().getCsv_sepSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFileRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"csv_sep",
                    							lv_csv_sep_7_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:6280:3: (otherlv_8= 'hdf5_key' ( (lv_hdf5_key_9_0= RULE_STRING ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==162) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalWorkflow.g:6281:4: otherlv_8= 'hdf5_key' ( (lv_hdf5_key_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,162,FOLLOW_15); 

                    				newLeafNode(otherlv_8, grammarAccess.getFileAccess().getHdf5_keyKeyword_7_0());
                    			
                    // InternalWorkflow.g:6285:4: ( (lv_hdf5_key_9_0= RULE_STRING ) )
                    // InternalWorkflow.g:6286:5: (lv_hdf5_key_9_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:6286:5: (lv_hdf5_key_9_0= RULE_STRING )
                    // InternalWorkflow.g:6287:6: lv_hdf5_key_9_0= RULE_STRING
                    {
                    lv_hdf5_key_9_0=(Token)match(input,RULE_STRING,FOLLOW_168); 

                    						newLeafNode(lv_hdf5_key_9_0, grammarAccess.getFileAccess().getHdf5_keySTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFileRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"hdf5_key",
                    							lv_hdf5_key_9_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:6304:3: (otherlv_10= 'csv_thousandsSep' ( (lv_csv_thousandsSep_11_0= RULE_STRING ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==163) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalWorkflow.g:6305:4: otherlv_10= 'csv_thousandsSep' ( (lv_csv_thousandsSep_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,163,FOLLOW_15); 

                    				newLeafNode(otherlv_10, grammarAccess.getFileAccess().getCsv_thousandsSepKeyword_8_0());
                    			
                    // InternalWorkflow.g:6309:4: ( (lv_csv_thousandsSep_11_0= RULE_STRING ) )
                    // InternalWorkflow.g:6310:5: (lv_csv_thousandsSep_11_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:6310:5: (lv_csv_thousandsSep_11_0= RULE_STRING )
                    // InternalWorkflow.g:6311:6: lv_csv_thousandsSep_11_0= RULE_STRING
                    {
                    lv_csv_thousandsSep_11_0=(Token)match(input,RULE_STRING,FOLLOW_169); 

                    						newLeafNode(lv_csv_thousandsSep_11_0, grammarAccess.getFileAccess().getCsv_thousandsSepSTRINGTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFileRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"csv_thousandsSep",
                    							lv_csv_thousandsSep_11_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:6328:3: (otherlv_12= 'csv_decimalSep' ( (lv_csv_decimalSep_13_0= RULE_STRING ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==164) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalWorkflow.g:6329:4: otherlv_12= 'csv_decimalSep' ( (lv_csv_decimalSep_13_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,164,FOLLOW_15); 

                    				newLeafNode(otherlv_12, grammarAccess.getFileAccess().getCsv_decimalSepKeyword_9_0());
                    			
                    // InternalWorkflow.g:6333:4: ( (lv_csv_decimalSep_13_0= RULE_STRING ) )
                    // InternalWorkflow.g:6334:5: (lv_csv_decimalSep_13_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:6334:5: (lv_csv_decimalSep_13_0= RULE_STRING )
                    // InternalWorkflow.g:6335:6: lv_csv_decimalSep_13_0= RULE_STRING
                    {
                    lv_csv_decimalSep_13_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

                    						newLeafNode(lv_csv_decimalSep_13_0, grammarAccess.getFileAccess().getCsv_decimalSepSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFileRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"csv_decimalSep",
                    							lv_csv_decimalSep_13_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getFileAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleTable"
    // InternalWorkflow.g:6360:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // InternalWorkflow.g:6360:46: (iv_ruleTable= ruleTable EOF )
            // InternalWorkflow.g:6361:2: iv_ruleTable= ruleTable EOF
            {
             newCompositeNode(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTable=ruleTable();

            state._fsp--;

             current =iv_ruleTable; 
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
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // InternalWorkflow.g:6367:1: ruleTable returns [EObject current=null] : (otherlv_0= 'table' otherlv_1= '{' otherlv_2= 'dataDictionary' ( (otherlv_3= RULE_ID ) ) otherlv_4= '}' ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalWorkflow.g:6373:2: ( (otherlv_0= 'table' otherlv_1= '{' otherlv_2= 'dataDictionary' ( (otherlv_3= RULE_ID ) ) otherlv_4= '}' ) )
            // InternalWorkflow.g:6374:2: (otherlv_0= 'table' otherlv_1= '{' otherlv_2= 'dataDictionary' ( (otherlv_3= RULE_ID ) ) otherlv_4= '}' )
            {
            // InternalWorkflow.g:6374:2: (otherlv_0= 'table' otherlv_1= '{' otherlv_2= 'dataDictionary' ( (otherlv_3= RULE_ID ) ) otherlv_4= '}' )
            // InternalWorkflow.g:6375:3: otherlv_0= 'table' otherlv_1= '{' otherlv_2= 'dataDictionary' ( (otherlv_3= RULE_ID ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,165,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTableAccess().getTableKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,94,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getTableAccess().getDataDictionaryKeyword_2());
            		
            // InternalWorkflow.g:6387:3: ( (otherlv_3= RULE_ID ) )
            // InternalWorkflow.g:6388:4: (otherlv_3= RULE_ID )
            {
            // InternalWorkflow.g:6388:4: (otherlv_3= RULE_ID )
            // InternalWorkflow.g:6389:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_3, grammarAccess.getTableAccess().getDataDictionaryDataDictionaryCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTableAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleLocalFolder"
    // InternalWorkflow.g:6408:1: entryRuleLocalFolder returns [EObject current=null] : iv_ruleLocalFolder= ruleLocalFolder EOF ;
    public final EObject entryRuleLocalFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalFolder = null;


        try {
            // InternalWorkflow.g:6408:52: (iv_ruleLocalFolder= ruleLocalFolder EOF )
            // InternalWorkflow.g:6409:2: iv_ruleLocalFolder= ruleLocalFolder EOF
            {
             newCompositeNode(grammarAccess.getLocalFolderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalFolder=ruleLocalFolder();

            state._fsp--;

             current =iv_ruleLocalFolder; 
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
    // $ANTLR end "entryRuleLocalFolder"


    // $ANTLR start "ruleLocalFolder"
    // InternalWorkflow.g:6415:1: ruleLocalFolder returns [EObject current=null] : (otherlv_0= 'localFolder' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= '}' ) ;
    public final EObject ruleLocalFolder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_storageName_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_folderPath_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_file_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:6421:2: ( (otherlv_0= 'localFolder' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= '}' ) )
            // InternalWorkflow.g:6422:2: (otherlv_0= 'localFolder' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= '}' )
            {
            // InternalWorkflow.g:6422:2: (otherlv_0= 'localFolder' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= '}' )
            // InternalWorkflow.g:6423:3: otherlv_0= 'localFolder' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,166,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLocalFolderAccess().getLocalFolderKeyword_0());
            		
            // InternalWorkflow.g:6427:3: ( (lv_storageName_1_0= RULE_ID ) )
            // InternalWorkflow.g:6428:4: (lv_storageName_1_0= RULE_ID )
            {
            // InternalWorkflow.g:6428:4: (lv_storageName_1_0= RULE_ID )
            // InternalWorkflow.g:6429:5: lv_storageName_1_0= RULE_ID
            {
            lv_storageName_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_storageName_1_0, grammarAccess.getLocalFolderAccess().getStorageNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalFolderRule());
            					}
            					setWithLastConsumed(
            						current,
            						"storageName",
            						lv_storageName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_170); 

            			newLeafNode(otherlv_2, grammarAccess.getLocalFolderAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,167,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getLocalFolderAccess().getFolderPathKeyword_3());
            		
            // InternalWorkflow.g:6453:3: ( (lv_folderPath_4_0= RULE_STRING ) )
            // InternalWorkflow.g:6454:4: (lv_folderPath_4_0= RULE_STRING )
            {
            // InternalWorkflow.g:6454:4: (lv_folderPath_4_0= RULE_STRING )
            // InternalWorkflow.g:6455:5: lv_folderPath_4_0= RULE_STRING
            {
            lv_folderPath_4_0=(Token)match(input,RULE_STRING,FOLLOW_171); 

            					newLeafNode(lv_folderPath_4_0, grammarAccess.getLocalFolderAccess().getFolderPathSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalFolderRule());
            					}
            					setWithLastConsumed(
            						current,
            						"folderPath",
            						lv_folderPath_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,168,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getLocalFolderAccess().getFilesKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_172); 

            			newLeafNode(otherlv_6, grammarAccess.getLocalFolderAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:6479:3: ( (lv_file_7_0= ruleFile ) )+
            int cnt94=0;
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==160) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalWorkflow.g:6480:4: (lv_file_7_0= ruleFile )
            	    {
            	    // InternalWorkflow.g:6480:4: (lv_file_7_0= ruleFile )
            	    // InternalWorkflow.g:6481:5: lv_file_7_0= ruleFile
            	    {

            	    					newCompositeNode(grammarAccess.getLocalFolderAccess().getFileFileParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_173);
            	    lv_file_7_0=ruleFile();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLocalFolderRule());
            	    					}
            	    					add(
            	    						current,
            	    						"file",
            	    						lv_file_7_0,
            	    						"xtext.Workflow.File");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt94 >= 1 ) break loop94;
                        EarlyExitException eee =
                            new EarlyExitException(94, input);
                        throw eee;
                }
                cnt94++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_8, grammarAccess.getLocalFolderAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getLocalFolderAccess().getRightCurlyBracketKeyword_9());
            		

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
    // $ANTLR end "ruleLocalFolder"


    // $ANTLR start "entryRuleAmazonS3"
    // InternalWorkflow.g:6510:1: entryRuleAmazonS3 returns [EObject current=null] : iv_ruleAmazonS3= ruleAmazonS3 EOF ;
    public final EObject entryRuleAmazonS3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAmazonS3 = null;


        try {
            // InternalWorkflow.g:6510:49: (iv_ruleAmazonS3= ruleAmazonS3 EOF )
            // InternalWorkflow.g:6511:2: iv_ruleAmazonS3= ruleAmazonS3 EOF
            {
             newCompositeNode(grammarAccess.getAmazonS3Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAmazonS3=ruleAmazonS3();

            state._fsp--;

             current =iv_ruleAmazonS3; 
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
    // $ANTLR end "entryRuleAmazonS3"


    // $ANTLR start "ruleAmazonS3"
    // InternalWorkflow.g:6517:1: ruleAmazonS3 returns [EObject current=null] : (otherlv_0= 'amazonS3' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'bucket' ( (lv_bucket_10_0= RULE_STRING ) ) otherlv_11= 'region' ( (lv_region_12_0= RULE_STRING ) ) otherlv_13= 'secretId' ( (lv_secretId_14_0= RULE_STRING ) ) otherlv_15= '}' ) ;
    public final EObject ruleAmazonS3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_storageName_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_folderPath_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_bucket_10_0=null;
        Token otherlv_11=null;
        Token lv_region_12_0=null;
        Token otherlv_13=null;
        Token lv_secretId_14_0=null;
        Token otherlv_15=null;
        EObject lv_file_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:6523:2: ( (otherlv_0= 'amazonS3' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'bucket' ( (lv_bucket_10_0= RULE_STRING ) ) otherlv_11= 'region' ( (lv_region_12_0= RULE_STRING ) ) otherlv_13= 'secretId' ( (lv_secretId_14_0= RULE_STRING ) ) otherlv_15= '}' ) )
            // InternalWorkflow.g:6524:2: (otherlv_0= 'amazonS3' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'bucket' ( (lv_bucket_10_0= RULE_STRING ) ) otherlv_11= 'region' ( (lv_region_12_0= RULE_STRING ) ) otherlv_13= 'secretId' ( (lv_secretId_14_0= RULE_STRING ) ) otherlv_15= '}' )
            {
            // InternalWorkflow.g:6524:2: (otherlv_0= 'amazonS3' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'bucket' ( (lv_bucket_10_0= RULE_STRING ) ) otherlv_11= 'region' ( (lv_region_12_0= RULE_STRING ) ) otherlv_13= 'secretId' ( (lv_secretId_14_0= RULE_STRING ) ) otherlv_15= '}' )
            // InternalWorkflow.g:6525:3: otherlv_0= 'amazonS3' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'bucket' ( (lv_bucket_10_0= RULE_STRING ) ) otherlv_11= 'region' ( (lv_region_12_0= RULE_STRING ) ) otherlv_13= 'secretId' ( (lv_secretId_14_0= RULE_STRING ) ) otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,169,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAmazonS3Access().getAmazonS3Keyword_0());
            		
            // InternalWorkflow.g:6529:3: ( (lv_storageName_1_0= RULE_ID ) )
            // InternalWorkflow.g:6530:4: (lv_storageName_1_0= RULE_ID )
            {
            // InternalWorkflow.g:6530:4: (lv_storageName_1_0= RULE_ID )
            // InternalWorkflow.g:6531:5: lv_storageName_1_0= RULE_ID
            {
            lv_storageName_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_storageName_1_0, grammarAccess.getAmazonS3Access().getStorageNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonS3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"storageName",
            						lv_storageName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_170); 

            			newLeafNode(otherlv_2, grammarAccess.getAmazonS3Access().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,167,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getAmazonS3Access().getFolderPathKeyword_3());
            		
            // InternalWorkflow.g:6555:3: ( (lv_folderPath_4_0= RULE_STRING ) )
            // InternalWorkflow.g:6556:4: (lv_folderPath_4_0= RULE_STRING )
            {
            // InternalWorkflow.g:6556:4: (lv_folderPath_4_0= RULE_STRING )
            // InternalWorkflow.g:6557:5: lv_folderPath_4_0= RULE_STRING
            {
            lv_folderPath_4_0=(Token)match(input,RULE_STRING,FOLLOW_171); 

            					newLeafNode(lv_folderPath_4_0, grammarAccess.getAmazonS3Access().getFolderPathSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonS3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"folderPath",
            						lv_folderPath_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,168,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getAmazonS3Access().getFilesKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_172); 

            			newLeafNode(otherlv_6, grammarAccess.getAmazonS3Access().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:6581:3: ( (lv_file_7_0= ruleFile ) )+
            int cnt95=0;
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==160) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalWorkflow.g:6582:4: (lv_file_7_0= ruleFile )
            	    {
            	    // InternalWorkflow.g:6582:4: (lv_file_7_0= ruleFile )
            	    // InternalWorkflow.g:6583:5: lv_file_7_0= ruleFile
            	    {

            	    					newCompositeNode(grammarAccess.getAmazonS3Access().getFileFileParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_173);
            	    lv_file_7_0=ruleFile();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAmazonS3Rule());
            	    					}
            	    					add(
            	    						current,
            	    						"file",
            	    						lv_file_7_0,
            	    						"xtext.Workflow.File");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt95 >= 1 ) break loop95;
                        EarlyExitException eee =
                            new EarlyExitException(95, input);
                        throw eee;
                }
                cnt95++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_174); 

            			newLeafNode(otherlv_8, grammarAccess.getAmazonS3Access().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,170,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getAmazonS3Access().getBucketKeyword_9());
            		
            // InternalWorkflow.g:6608:3: ( (lv_bucket_10_0= RULE_STRING ) )
            // InternalWorkflow.g:6609:4: (lv_bucket_10_0= RULE_STRING )
            {
            // InternalWorkflow.g:6609:4: (lv_bucket_10_0= RULE_STRING )
            // InternalWorkflow.g:6610:5: lv_bucket_10_0= RULE_STRING
            {
            lv_bucket_10_0=(Token)match(input,RULE_STRING,FOLLOW_139); 

            					newLeafNode(lv_bucket_10_0, grammarAccess.getAmazonS3Access().getBucketSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonS3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"bucket",
            						lv_bucket_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,134,FOLLOW_15); 

            			newLeafNode(otherlv_11, grammarAccess.getAmazonS3Access().getRegionKeyword_11());
            		
            // InternalWorkflow.g:6630:3: ( (lv_region_12_0= RULE_STRING ) )
            // InternalWorkflow.g:6631:4: (lv_region_12_0= RULE_STRING )
            {
            // InternalWorkflow.g:6631:4: (lv_region_12_0= RULE_STRING )
            // InternalWorkflow.g:6632:5: lv_region_12_0= RULE_STRING
            {
            lv_region_12_0=(Token)match(input,RULE_STRING,FOLLOW_138); 

            					newLeafNode(lv_region_12_0, grammarAccess.getAmazonS3Access().getRegionSTRINGTerminalRuleCall_12_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonS3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"region",
            						lv_region_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_13=(Token)match(input,133,FOLLOW_15); 

            			newLeafNode(otherlv_13, grammarAccess.getAmazonS3Access().getSecretIdKeyword_13());
            		
            // InternalWorkflow.g:6652:3: ( (lv_secretId_14_0= RULE_STRING ) )
            // InternalWorkflow.g:6653:4: (lv_secretId_14_0= RULE_STRING )
            {
            // InternalWorkflow.g:6653:4: (lv_secretId_14_0= RULE_STRING )
            // InternalWorkflow.g:6654:5: lv_secretId_14_0= RULE_STRING
            {
            lv_secretId_14_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_secretId_14_0, grammarAccess.getAmazonS3Access().getSecretIdSTRINGTerminalRuleCall_14_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAmazonS3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"secretId",
            						lv_secretId_14_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_15=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getAmazonS3Access().getRightCurlyBracketKeyword_15());
            		

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
    // $ANTLR end "ruleAmazonS3"


    // $ANTLR start "entryRuleAzureBlob"
    // InternalWorkflow.g:6678:1: entryRuleAzureBlob returns [EObject current=null] : iv_ruleAzureBlob= ruleAzureBlob EOF ;
    public final EObject entryRuleAzureBlob() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAzureBlob = null;


        try {
            // InternalWorkflow.g:6678:50: (iv_ruleAzureBlob= ruleAzureBlob EOF )
            // InternalWorkflow.g:6679:2: iv_ruleAzureBlob= ruleAzureBlob EOF
            {
             newCompositeNode(grammarAccess.getAzureBlobRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAzureBlob=ruleAzureBlob();

            state._fsp--;

             current =iv_ruleAzureBlob; 
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
    // $ANTLR end "entryRuleAzureBlob"


    // $ANTLR start "ruleAzureBlob"
    // InternalWorkflow.g:6685:1: ruleAzureBlob returns [EObject current=null] : (otherlv_0= 'azureBlob' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'container' ( (lv_container_10_0= RULE_STRING ) ) otherlv_11= 'keyVaultName' ( (lv_keyVaultName_12_0= RULE_STRING ) ) otherlv_13= 'secretName' ( (lv_secretName_14_0= RULE_STRING ) ) otherlv_15= '}' ) ;
    public final EObject ruleAzureBlob() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_storageName_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_folderPath_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_container_10_0=null;
        Token otherlv_11=null;
        Token lv_keyVaultName_12_0=null;
        Token otherlv_13=null;
        Token lv_secretName_14_0=null;
        Token otherlv_15=null;
        EObject lv_file_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:6691:2: ( (otherlv_0= 'azureBlob' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'container' ( (lv_container_10_0= RULE_STRING ) ) otherlv_11= 'keyVaultName' ( (lv_keyVaultName_12_0= RULE_STRING ) ) otherlv_13= 'secretName' ( (lv_secretName_14_0= RULE_STRING ) ) otherlv_15= '}' ) )
            // InternalWorkflow.g:6692:2: (otherlv_0= 'azureBlob' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'container' ( (lv_container_10_0= RULE_STRING ) ) otherlv_11= 'keyVaultName' ( (lv_keyVaultName_12_0= RULE_STRING ) ) otherlv_13= 'secretName' ( (lv_secretName_14_0= RULE_STRING ) ) otherlv_15= '}' )
            {
            // InternalWorkflow.g:6692:2: (otherlv_0= 'azureBlob' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'container' ( (lv_container_10_0= RULE_STRING ) ) otherlv_11= 'keyVaultName' ( (lv_keyVaultName_12_0= RULE_STRING ) ) otherlv_13= 'secretName' ( (lv_secretName_14_0= RULE_STRING ) ) otherlv_15= '}' )
            // InternalWorkflow.g:6693:3: otherlv_0= 'azureBlob' ( (lv_storageName_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'folderPath' ( (lv_folderPath_4_0= RULE_STRING ) ) otherlv_5= 'files' otherlv_6= '{' ( (lv_file_7_0= ruleFile ) )+ otherlv_8= '}' otherlv_9= 'container' ( (lv_container_10_0= RULE_STRING ) ) otherlv_11= 'keyVaultName' ( (lv_keyVaultName_12_0= RULE_STRING ) ) otherlv_13= 'secretName' ( (lv_secretName_14_0= RULE_STRING ) ) otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,171,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAzureBlobAccess().getAzureBlobKeyword_0());
            		
            // InternalWorkflow.g:6697:3: ( (lv_storageName_1_0= RULE_ID ) )
            // InternalWorkflow.g:6698:4: (lv_storageName_1_0= RULE_ID )
            {
            // InternalWorkflow.g:6698:4: (lv_storageName_1_0= RULE_ID )
            // InternalWorkflow.g:6699:5: lv_storageName_1_0= RULE_ID
            {
            lv_storageName_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_storageName_1_0, grammarAccess.getAzureBlobAccess().getStorageNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureBlobRule());
            					}
            					setWithLastConsumed(
            						current,
            						"storageName",
            						lv_storageName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_170); 

            			newLeafNode(otherlv_2, grammarAccess.getAzureBlobAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,167,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getAzureBlobAccess().getFolderPathKeyword_3());
            		
            // InternalWorkflow.g:6723:3: ( (lv_folderPath_4_0= RULE_STRING ) )
            // InternalWorkflow.g:6724:4: (lv_folderPath_4_0= RULE_STRING )
            {
            // InternalWorkflow.g:6724:4: (lv_folderPath_4_0= RULE_STRING )
            // InternalWorkflow.g:6725:5: lv_folderPath_4_0= RULE_STRING
            {
            lv_folderPath_4_0=(Token)match(input,RULE_STRING,FOLLOW_171); 

            					newLeafNode(lv_folderPath_4_0, grammarAccess.getAzureBlobAccess().getFolderPathSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureBlobRule());
            					}
            					setWithLastConsumed(
            						current,
            						"folderPath",
            						lv_folderPath_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,168,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getAzureBlobAccess().getFilesKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_172); 

            			newLeafNode(otherlv_6, grammarAccess.getAzureBlobAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflow.g:6749:3: ( (lv_file_7_0= ruleFile ) )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==160) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalWorkflow.g:6750:4: (lv_file_7_0= ruleFile )
            	    {
            	    // InternalWorkflow.g:6750:4: (lv_file_7_0= ruleFile )
            	    // InternalWorkflow.g:6751:5: lv_file_7_0= ruleFile
            	    {

            	    					newCompositeNode(grammarAccess.getAzureBlobAccess().getFileFileParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_173);
            	    lv_file_7_0=ruleFile();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAzureBlobRule());
            	    					}
            	    					add(
            	    						current,
            	    						"file",
            	    						lv_file_7_0,
            	    						"xtext.Workflow.File");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt96 >= 1 ) break loop96;
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_175); 

            			newLeafNode(otherlv_8, grammarAccess.getAzureBlobAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,172,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getAzureBlobAccess().getContainerKeyword_9());
            		
            // InternalWorkflow.g:6776:3: ( (lv_container_10_0= RULE_STRING ) )
            // InternalWorkflow.g:6777:4: (lv_container_10_0= RULE_STRING )
            {
            // InternalWorkflow.g:6777:4: (lv_container_10_0= RULE_STRING )
            // InternalWorkflow.g:6778:5: lv_container_10_0= RULE_STRING
            {
            lv_container_10_0=(Token)match(input,RULE_STRING,FOLLOW_135); 

            					newLeafNode(lv_container_10_0, grammarAccess.getAzureBlobAccess().getContainerSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureBlobRule());
            					}
            					setWithLastConsumed(
            						current,
            						"container",
            						lv_container_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,129,FOLLOW_15); 

            			newLeafNode(otherlv_11, grammarAccess.getAzureBlobAccess().getKeyVaultNameKeyword_11());
            		
            // InternalWorkflow.g:6798:3: ( (lv_keyVaultName_12_0= RULE_STRING ) )
            // InternalWorkflow.g:6799:4: (lv_keyVaultName_12_0= RULE_STRING )
            {
            // InternalWorkflow.g:6799:4: (lv_keyVaultName_12_0= RULE_STRING )
            // InternalWorkflow.g:6800:5: lv_keyVaultName_12_0= RULE_STRING
            {
            lv_keyVaultName_12_0=(Token)match(input,RULE_STRING,FOLLOW_136); 

            					newLeafNode(lv_keyVaultName_12_0, grammarAccess.getAzureBlobAccess().getKeyVaultNameSTRINGTerminalRuleCall_12_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureBlobRule());
            					}
            					setWithLastConsumed(
            						current,
            						"keyVaultName",
            						lv_keyVaultName_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_13=(Token)match(input,130,FOLLOW_15); 

            			newLeafNode(otherlv_13, grammarAccess.getAzureBlobAccess().getSecretNameKeyword_13());
            		
            // InternalWorkflow.g:6820:3: ( (lv_secretName_14_0= RULE_STRING ) )
            // InternalWorkflow.g:6821:4: (lv_secretName_14_0= RULE_STRING )
            {
            // InternalWorkflow.g:6821:4: (lv_secretName_14_0= RULE_STRING )
            // InternalWorkflow.g:6822:5: lv_secretName_14_0= RULE_STRING
            {
            lv_secretName_14_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_secretName_14_0, grammarAccess.getAzureBlobAccess().getSecretNameSTRINGTerminalRuleCall_14_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAzureBlobRule());
            					}
            					setWithLastConsumed(
            						current,
            						"secretName",
            						lv_secretName_14_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_15=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getAzureBlobAccess().getRightCurlyBracketKeyword_15());
            		

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
    // $ANTLR end "ruleAzureBlob"


    // $ANTLR start "ruleLibDataType"
    // InternalWorkflow.g:6846:1: ruleLibDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) ) ;
    public final Enumerator ruleLibDataType() throws RecognitionException {
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
            // InternalWorkflow.g:6852:2: ( ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) ) )
            // InternalWorkflow.g:6853:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) )
            {
            // InternalWorkflow.g:6853:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) )
            int alt97=8;
            switch ( input.LA(1) ) {
            case 173:
                {
                alt97=1;
                }
                break;
            case 174:
                {
                alt97=2;
                }
                break;
            case 175:
                {
                alt97=3;
                }
                break;
            case 176:
                {
                alt97=4;
                }
                break;
            case 177:
                {
                alt97=5;
                }
                break;
            case 178:
                {
                alt97=6;
                }
                break;
            case 179:
                {
                alt97=7;
                }
                break;
            case 180:
                {
                alt97=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // InternalWorkflow.g:6854:3: (enumLiteral_0= 'String' )
                    {
                    // InternalWorkflow.g:6854:3: (enumLiteral_0= 'String' )
                    // InternalWorkflow.g:6855:4: enumLiteral_0= 'String'
                    {
                    enumLiteral_0=(Token)match(input,173,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getStringEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLibDataTypeAccess().getStringEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:6862:3: (enumLiteral_1= 'Time' )
                    {
                    // InternalWorkflow.g:6862:3: (enumLiteral_1= 'Time' )
                    // InternalWorkflow.g:6863:4: enumLiteral_1= 'Time'
                    {
                    enumLiteral_1=(Token)match(input,174,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getTimeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLibDataTypeAccess().getTimeEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:6870:3: (enumLiteral_2= 'Integer' )
                    {
                    // InternalWorkflow.g:6870:3: (enumLiteral_2= 'Integer' )
                    // InternalWorkflow.g:6871:4: enumLiteral_2= 'Integer'
                    {
                    enumLiteral_2=(Token)match(input,175,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getIntegerEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLibDataTypeAccess().getIntegerEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:6878:3: (enumLiteral_3= 'DateTime' )
                    {
                    // InternalWorkflow.g:6878:3: (enumLiteral_3= 'DateTime' )
                    // InternalWorkflow.g:6879:4: enumLiteral_3= 'DateTime'
                    {
                    enumLiteral_3=(Token)match(input,176,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getDateTimeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLibDataTypeAccess().getDateTimeEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:6886:3: (enumLiteral_4= 'Boolean' )
                    {
                    // InternalWorkflow.g:6886:3: (enumLiteral_4= 'Boolean' )
                    // InternalWorkflow.g:6887:4: enumLiteral_4= 'Boolean'
                    {
                    enumLiteral_4=(Token)match(input,177,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getBooleanEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLibDataTypeAccess().getBooleanEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:6894:3: (enumLiteral_5= 'Double' )
                    {
                    // InternalWorkflow.g:6894:3: (enumLiteral_5= 'Double' )
                    // InternalWorkflow.g:6895:4: enumLiteral_5= 'Double'
                    {
                    enumLiteral_5=(Token)match(input,178,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getDoubleEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLibDataTypeAccess().getDoubleEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalWorkflow.g:6902:3: (enumLiteral_6= 'Float' )
                    {
                    // InternalWorkflow.g:6902:3: (enumLiteral_6= 'Float' )
                    // InternalWorkflow.g:6903:4: enumLiteral_6= 'Float'
                    {
                    enumLiteral_6=(Token)match(input,179,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getFloatEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLibDataTypeAccess().getFloatEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalWorkflow.g:6910:3: (enumLiteral_7= 'Date' )
                    {
                    // InternalWorkflow.g:6910:3: (enumLiteral_7= 'Date' )
                    // InternalWorkflow.g:6911:4: enumLiteral_7= 'Date'
                    {
                    enumLiteral_7=(Token)match(input,180,FOLLOW_2); 

                    				current = grammarAccess.getLibDataTypeAccess().getDateEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLibDataTypeAccess().getDateEnumLiteralDeclaration_7());
                    			

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
    // $ANTLR end "ruleLibDataType"


    // $ANTLR start "ruleDataType"
    // InternalWorkflow.g:6921:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) ) ;
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
            // InternalWorkflow.g:6927:2: ( ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) ) )
            // InternalWorkflow.g:6928:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) )
            {
            // InternalWorkflow.g:6928:2: ( (enumLiteral_0= 'String' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'DateTime' ) | (enumLiteral_4= 'Boolean' ) | (enumLiteral_5= 'Double' ) | (enumLiteral_6= 'Float' ) | (enumLiteral_7= 'Date' ) )
            int alt98=8;
            switch ( input.LA(1) ) {
            case 173:
                {
                alt98=1;
                }
                break;
            case 174:
                {
                alt98=2;
                }
                break;
            case 175:
                {
                alt98=3;
                }
                break;
            case 176:
                {
                alt98=4;
                }
                break;
            case 177:
                {
                alt98=5;
                }
                break;
            case 178:
                {
                alt98=6;
                }
                break;
            case 179:
                {
                alt98=7;
                }
                break;
            case 180:
                {
                alt98=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // InternalWorkflow.g:6929:3: (enumLiteral_0= 'String' )
                    {
                    // InternalWorkflow.g:6929:3: (enumLiteral_0= 'String' )
                    // InternalWorkflow.g:6930:4: enumLiteral_0= 'String'
                    {
                    enumLiteral_0=(Token)match(input,173,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getStringEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getStringEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:6937:3: (enumLiteral_1= 'Time' )
                    {
                    // InternalWorkflow.g:6937:3: (enumLiteral_1= 'Time' )
                    // InternalWorkflow.g:6938:4: enumLiteral_1= 'Time'
                    {
                    enumLiteral_1=(Token)match(input,174,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getTimeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getTimeEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:6945:3: (enumLiteral_2= 'Integer' )
                    {
                    // InternalWorkflow.g:6945:3: (enumLiteral_2= 'Integer' )
                    // InternalWorkflow.g:6946:4: enumLiteral_2= 'Integer'
                    {
                    enumLiteral_2=(Token)match(input,175,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getIntegerEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getIntegerEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:6953:3: (enumLiteral_3= 'DateTime' )
                    {
                    // InternalWorkflow.g:6953:3: (enumLiteral_3= 'DateTime' )
                    // InternalWorkflow.g:6954:4: enumLiteral_3= 'DateTime'
                    {
                    enumLiteral_3=(Token)match(input,176,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDateTimeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getDateTimeEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:6961:3: (enumLiteral_4= 'Boolean' )
                    {
                    // InternalWorkflow.g:6961:3: (enumLiteral_4= 'Boolean' )
                    // InternalWorkflow.g:6962:4: enumLiteral_4= 'Boolean'
                    {
                    enumLiteral_4=(Token)match(input,177,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getBooleanEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getBooleanEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:6969:3: (enumLiteral_5= 'Double' )
                    {
                    // InternalWorkflow.g:6969:3: (enumLiteral_5= 'Double' )
                    // InternalWorkflow.g:6970:4: enumLiteral_5= 'Double'
                    {
                    enumLiteral_5=(Token)match(input,178,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDoubleEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getDoubleEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalWorkflow.g:6977:3: (enumLiteral_6= 'Float' )
                    {
                    // InternalWorkflow.g:6977:3: (enumLiteral_6= 'Float' )
                    // InternalWorkflow.g:6978:4: enumLiteral_6= 'Float'
                    {
                    enumLiteral_6=(Token)match(input,179,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getFloatEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getDataTypeAccess().getFloatEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalWorkflow.g:6985:3: (enumLiteral_7= 'Date' )
                    {
                    // InternalWorkflow.g:6985:3: (enumLiteral_7= 'Date' )
                    // InternalWorkflow.g:6986:4: enumLiteral_7= 'Date'
                    {
                    enumLiteral_7=(Token)match(input,180,FOLLOW_2); 

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
    // InternalWorkflow.g:6996:1: ruleClosureType returns [Enumerator current=null] : ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) ) ;
    public final Enumerator ruleClosureType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7002:2: ( ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) ) )
            // InternalWorkflow.g:7003:2: ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) )
            {
            // InternalWorkflow.g:7003:2: ( (enumLiteral_0= 'openOpen' ) | (enumLiteral_1= 'openClosed' ) | (enumLiteral_2= 'closedOpen' ) | (enumLiteral_3= 'closedClosed' ) )
            int alt99=4;
            switch ( input.LA(1) ) {
            case 181:
                {
                alt99=1;
                }
                break;
            case 182:
                {
                alt99=2;
                }
                break;
            case 183:
                {
                alt99=3;
                }
                break;
            case 184:
                {
                alt99=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // InternalWorkflow.g:7004:3: (enumLiteral_0= 'openOpen' )
                    {
                    // InternalWorkflow.g:7004:3: (enumLiteral_0= 'openOpen' )
                    // InternalWorkflow.g:7005:4: enumLiteral_0= 'openOpen'
                    {
                    enumLiteral_0=(Token)match(input,181,FOLLOW_2); 

                    				current = grammarAccess.getClosureTypeAccess().getOpenOpenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getClosureTypeAccess().getOpenOpenEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7012:3: (enumLiteral_1= 'openClosed' )
                    {
                    // InternalWorkflow.g:7012:3: (enumLiteral_1= 'openClosed' )
                    // InternalWorkflow.g:7013:4: enumLiteral_1= 'openClosed'
                    {
                    enumLiteral_1=(Token)match(input,182,FOLLOW_2); 

                    				current = grammarAccess.getClosureTypeAccess().getOpenClosedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getClosureTypeAccess().getOpenClosedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7020:3: (enumLiteral_2= 'closedOpen' )
                    {
                    // InternalWorkflow.g:7020:3: (enumLiteral_2= 'closedOpen' )
                    // InternalWorkflow.g:7021:4: enumLiteral_2= 'closedOpen'
                    {
                    enumLiteral_2=(Token)match(input,183,FOLLOW_2); 

                    				current = grammarAccess.getClosureTypeAccess().getClosedOpenEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getClosureTypeAccess().getClosedOpenEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:7028:3: (enumLiteral_3= 'closedClosed' )
                    {
                    // InternalWorkflow.g:7028:3: (enumLiteral_3= 'closedClosed' )
                    // InternalWorkflow.g:7029:4: enumLiteral_3= 'closedClosed'
                    {
                    enumLiteral_3=(Token)match(input,184,FOLLOW_2); 

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


    // $ANTLR start "ruleOperation"
    // InternalWorkflow.g:7039:1: ruleOperation returns [Enumerator current=null] : ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) ) ;
    public final Enumerator ruleOperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7045:2: ( ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) ) )
            // InternalWorkflow.g:7046:2: ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) )
            {
            // InternalWorkflow.g:7046:2: ( (enumLiteral_0= 'Interpolation' ) | (enumLiteral_1= 'Mean' ) | (enumLiteral_2= 'Median' ) | (enumLiteral_3= 'Closest' ) )
            int alt100=4;
            switch ( input.LA(1) ) {
            case 185:
                {
                alt100=1;
                }
                break;
            case 186:
                {
                alt100=2;
                }
                break;
            case 187:
                {
                alt100=3;
                }
                break;
            case 188:
                {
                alt100=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // InternalWorkflow.g:7047:3: (enumLiteral_0= 'Interpolation' )
                    {
                    // InternalWorkflow.g:7047:3: (enumLiteral_0= 'Interpolation' )
                    // InternalWorkflow.g:7048:4: enumLiteral_0= 'Interpolation'
                    {
                    enumLiteral_0=(Token)match(input,185,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getInterpolationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationAccess().getInterpolationEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7055:3: (enumLiteral_1= 'Mean' )
                    {
                    // InternalWorkflow.g:7055:3: (enumLiteral_1= 'Mean' )
                    // InternalWorkflow.g:7056:4: enumLiteral_1= 'Mean'
                    {
                    enumLiteral_1=(Token)match(input,186,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getMeanEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperationAccess().getMeanEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7063:3: (enumLiteral_2= 'Median' )
                    {
                    // InternalWorkflow.g:7063:3: (enumLiteral_2= 'Median' )
                    // InternalWorkflow.g:7064:4: enumLiteral_2= 'Median'
                    {
                    enumLiteral_2=(Token)match(input,187,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getMedianEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOperationAccess().getMedianEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:7071:3: (enumLiteral_3= 'Closest' )
                    {
                    // InternalWorkflow.g:7071:3: (enumLiteral_3= 'Closest' )
                    // InternalWorkflow.g:7072:4: enumLiteral_3= 'Closest'
                    {
                    enumLiteral_3=(Token)match(input,188,FOLLOW_2); 

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


    // $ANTLR start "ruleDerivedType"
    // InternalWorkflow.g:7082:1: ruleDerivedType returns [Enumerator current=null] : ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) ) ;
    public final Enumerator ruleDerivedType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7088:2: ( ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) ) )
            // InternalWorkflow.g:7089:2: ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) )
            {
            // InternalWorkflow.g:7089:2: ( (enumLiteral_0= 'MostFrequent' ) | (enumLiteral_1= 'Previous' ) | (enumLiteral_2= 'Next' ) )
            int alt101=3;
            switch ( input.LA(1) ) {
            case 189:
                {
                alt101=1;
                }
                break;
            case 190:
                {
                alt101=2;
                }
                break;
            case 191:
                {
                alt101=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // InternalWorkflow.g:7090:3: (enumLiteral_0= 'MostFrequent' )
                    {
                    // InternalWorkflow.g:7090:3: (enumLiteral_0= 'MostFrequent' )
                    // InternalWorkflow.g:7091:4: enumLiteral_0= 'MostFrequent'
                    {
                    enumLiteral_0=(Token)match(input,189,FOLLOW_2); 

                    				current = grammarAccess.getDerivedTypeAccess().getMostFrequentEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDerivedTypeAccess().getMostFrequentEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7098:3: (enumLiteral_1= 'Previous' )
                    {
                    // InternalWorkflow.g:7098:3: (enumLiteral_1= 'Previous' )
                    // InternalWorkflow.g:7099:4: enumLiteral_1= 'Previous'
                    {
                    enumLiteral_1=(Token)match(input,190,FOLLOW_2); 

                    				current = grammarAccess.getDerivedTypeAccess().getPreviousEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDerivedTypeAccess().getPreviousEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7106:3: (enumLiteral_2= 'Next' )
                    {
                    // InternalWorkflow.g:7106:3: (enumLiteral_2= 'Next' )
                    // InternalWorkflow.g:7107:4: enumLiteral_2= 'Next'
                    {
                    enumLiteral_2=(Token)match(input,191,FOLLOW_2); 

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


    // $ANTLR start "ruleSpecialValue"
    // InternalWorkflow.g:7117:1: ruleSpecialValue returns [Enumerator current=null] : ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) ) ;
    public final Enumerator ruleSpecialValue() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7123:2: ( ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) ) )
            // InternalWorkflow.g:7124:2: ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) )
            {
            // InternalWorkflow.g:7124:2: ( (enumLiteral_0= 'Missing' ) | (enumLiteral_1= 'Invalid' ) | (enumLiteral_2= 'Outlier' ) )
            int alt102=3;
            switch ( input.LA(1) ) {
            case 192:
                {
                alt102=1;
                }
                break;
            case 193:
                {
                alt102=2;
                }
                break;
            case 194:
                {
                alt102=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // InternalWorkflow.g:7125:3: (enumLiteral_0= 'Missing' )
                    {
                    // InternalWorkflow.g:7125:3: (enumLiteral_0= 'Missing' )
                    // InternalWorkflow.g:7126:4: enumLiteral_0= 'Missing'
                    {
                    enumLiteral_0=(Token)match(input,192,FOLLOW_2); 

                    				current = grammarAccess.getSpecialValueAccess().getMissingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSpecialValueAccess().getMissingEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7133:3: (enumLiteral_1= 'Invalid' )
                    {
                    // InternalWorkflow.g:7133:3: (enumLiteral_1= 'Invalid' )
                    // InternalWorkflow.g:7134:4: enumLiteral_1= 'Invalid'
                    {
                    enumLiteral_1=(Token)match(input,193,FOLLOW_2); 

                    				current = grammarAccess.getSpecialValueAccess().getInvalidEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSpecialValueAccess().getInvalidEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7141:3: (enumLiteral_2= 'Outlier' )
                    {
                    // InternalWorkflow.g:7141:3: (enumLiteral_2= 'Outlier' )
                    // InternalWorkflow.g:7142:4: enumLiteral_2= 'Outlier'
                    {
                    enumLiteral_2=(Token)match(input,194,FOLLOW_2); 

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


    // $ANTLR start "ruleOperator"
    // InternalWorkflow.g:7152:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7158:2: ( ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) ) )
            // InternalWorkflow.g:7159:2: ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) )
            {
            // InternalWorkflow.g:7159:2: ( (enumLiteral_0= 'BELONG' ) | (enumLiteral_1= 'NOTBELONG' ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==195) ) {
                alt103=1;
            }
            else if ( (LA103_0==196) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalWorkflow.g:7160:3: (enumLiteral_0= 'BELONG' )
                    {
                    // InternalWorkflow.g:7160:3: (enumLiteral_0= 'BELONG' )
                    // InternalWorkflow.g:7161:4: enumLiteral_0= 'BELONG'
                    {
                    enumLiteral_0=(Token)match(input,195,FOLLOW_2); 

                    				current = grammarAccess.getOperatorAccess().getBELONGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getBELONGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7168:3: (enumLiteral_1= 'NOTBELONG' )
                    {
                    // InternalWorkflow.g:7168:3: (enumLiteral_1= 'NOTBELONG' )
                    // InternalWorkflow.g:7169:4: enumLiteral_1= 'NOTBELONG'
                    {
                    enumLiteral_1=(Token)match(input,196,FOLLOW_2); 

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


    // $ANTLR start "ruleFilterType"
    // InternalWorkflow.g:7179:1: ruleFilterType returns [Enumerator current=null] : ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) ) ;
    public final Enumerator ruleFilterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7185:2: ( ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) ) )
            // InternalWorkflow.g:7186:2: ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) )
            {
            // InternalWorkflow.g:7186:2: ( (enumLiteral_0= 'EXCLUDE' ) | (enumLiteral_1= 'INCLUDE' ) )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==197) ) {
                alt104=1;
            }
            else if ( (LA104_0==198) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // InternalWorkflow.g:7187:3: (enumLiteral_0= 'EXCLUDE' )
                    {
                    // InternalWorkflow.g:7187:3: (enumLiteral_0= 'EXCLUDE' )
                    // InternalWorkflow.g:7188:4: enumLiteral_0= 'EXCLUDE'
                    {
                    enumLiteral_0=(Token)match(input,197,FOLLOW_2); 

                    				current = grammarAccess.getFilterTypeAccess().getEXCLUDEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFilterTypeAccess().getEXCLUDEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7195:3: (enumLiteral_1= 'INCLUDE' )
                    {
                    // InternalWorkflow.g:7195:3: (enumLiteral_1= 'INCLUDE' )
                    // InternalWorkflow.g:7196:4: enumLiteral_1= 'INCLUDE'
                    {
                    enumLiteral_1=(Token)match(input,198,FOLLOW_2); 

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


    // $ANTLR start "ruleMapOperation"
    // InternalWorkflow.g:7206:1: ruleMapOperation returns [Enumerator current=null] : ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) ) ;
    public final Enumerator ruleMapOperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7212:2: ( ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) ) )
            // InternalWorkflow.g:7213:2: ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) )
            {
            // InternalWorkflow.g:7213:2: ( (enumLiteral_0= 'VALUE_MAPPING' ) | (enumLiteral_1= 'SUBSTRING' ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==199) ) {
                alt105=1;
            }
            else if ( (LA105_0==200) ) {
                alt105=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalWorkflow.g:7214:3: (enumLiteral_0= 'VALUE_MAPPING' )
                    {
                    // InternalWorkflow.g:7214:3: (enumLiteral_0= 'VALUE_MAPPING' )
                    // InternalWorkflow.g:7215:4: enumLiteral_0= 'VALUE_MAPPING'
                    {
                    enumLiteral_0=(Token)match(input,199,FOLLOW_2); 

                    				current = grammarAccess.getMapOperationAccess().getVALUE_MAPPINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMapOperationAccess().getVALUE_MAPPINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7222:3: (enumLiteral_1= 'SUBSTRING' )
                    {
                    // InternalWorkflow.g:7222:3: (enumLiteral_1= 'SUBSTRING' )
                    // InternalWorkflow.g:7223:4: enumLiteral_1= 'SUBSTRING'
                    {
                    enumLiteral_1=(Token)match(input,200,FOLLOW_2); 

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


    // $ANTLR start "ruleMathOperator"
    // InternalWorkflow.g:7233:1: ruleMathOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) ) ;
    public final Enumerator ruleMathOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7239:2: ( ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) ) )
            // InternalWorkflow.g:7240:2: ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) )
            {
            // InternalWorkflow.g:7240:2: ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'SUBSTRACT' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) )
            int alt106=4;
            switch ( input.LA(1) ) {
            case 201:
                {
                alt106=1;
                }
                break;
            case 202:
                {
                alt106=2;
                }
                break;
            case 203:
                {
                alt106=3;
                }
                break;
            case 204:
                {
                alt106=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // InternalWorkflow.g:7241:3: (enumLiteral_0= 'SUM' )
                    {
                    // InternalWorkflow.g:7241:3: (enumLiteral_0= 'SUM' )
                    // InternalWorkflow.g:7242:4: enumLiteral_0= 'SUM'
                    {
                    enumLiteral_0=(Token)match(input,201,FOLLOW_2); 

                    				current = grammarAccess.getMathOperatorAccess().getSUMEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMathOperatorAccess().getSUMEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7249:3: (enumLiteral_1= 'SUBSTRACT' )
                    {
                    // InternalWorkflow.g:7249:3: (enumLiteral_1= 'SUBSTRACT' )
                    // InternalWorkflow.g:7250:4: enumLiteral_1= 'SUBSTRACT'
                    {
                    enumLiteral_1=(Token)match(input,202,FOLLOW_2); 

                    				current = grammarAccess.getMathOperatorAccess().getSUBSTRACTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMathOperatorAccess().getSUBSTRACTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7257:3: (enumLiteral_2= 'MULTIPLY' )
                    {
                    // InternalWorkflow.g:7257:3: (enumLiteral_2= 'MULTIPLY' )
                    // InternalWorkflow.g:7258:4: enumLiteral_2= 'MULTIPLY'
                    {
                    enumLiteral_2=(Token)match(input,203,FOLLOW_2); 

                    				current = grammarAccess.getMathOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMathOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:7265:3: (enumLiteral_3= 'DIVIDE' )
                    {
                    // InternalWorkflow.g:7265:3: (enumLiteral_3= 'DIVIDE' )
                    // InternalWorkflow.g:7266:4: enumLiteral_3= 'DIVIDE'
                    {
                    enumLiteral_3=(Token)match(input,204,FOLLOW_2); 

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


    // $ANTLR start "ruleTOOL"
    // InternalWorkflow.g:7276:1: ruleTOOL returns [Enumerator current=null] : ( (enumLiteral_0= 'PYTHON' ) | (enumLiteral_1= 'R' ) | (enumLiteral_2= 'KNIME' ) ) ;
    public final Enumerator ruleTOOL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7282:2: ( ( (enumLiteral_0= 'PYTHON' ) | (enumLiteral_1= 'R' ) | (enumLiteral_2= 'KNIME' ) ) )
            // InternalWorkflow.g:7283:2: ( (enumLiteral_0= 'PYTHON' ) | (enumLiteral_1= 'R' ) | (enumLiteral_2= 'KNIME' ) )
            {
            // InternalWorkflow.g:7283:2: ( (enumLiteral_0= 'PYTHON' ) | (enumLiteral_1= 'R' ) | (enumLiteral_2= 'KNIME' ) )
            int alt107=3;
            switch ( input.LA(1) ) {
            case 205:
                {
                alt107=1;
                }
                break;
            case 206:
                {
                alt107=2;
                }
                break;
            case 207:
                {
                alt107=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // InternalWorkflow.g:7284:3: (enumLiteral_0= 'PYTHON' )
                    {
                    // InternalWorkflow.g:7284:3: (enumLiteral_0= 'PYTHON' )
                    // InternalWorkflow.g:7285:4: enumLiteral_0= 'PYTHON'
                    {
                    enumLiteral_0=(Token)match(input,205,FOLLOW_2); 

                    				current = grammarAccess.getTOOLAccess().getPYTHONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTOOLAccess().getPYTHONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7292:3: (enumLiteral_1= 'R' )
                    {
                    // InternalWorkflow.g:7292:3: (enumLiteral_1= 'R' )
                    // InternalWorkflow.g:7293:4: enumLiteral_1= 'R'
                    {
                    enumLiteral_1=(Token)match(input,206,FOLLOW_2); 

                    				current = grammarAccess.getTOOLAccess().getREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTOOLAccess().getREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7300:3: (enumLiteral_2= 'KNIME' )
                    {
                    // InternalWorkflow.g:7300:3: (enumLiteral_2= 'KNIME' )
                    // InternalWorkflow.g:7301:4: enumLiteral_2= 'KNIME'
                    {
                    enumLiteral_2=(Token)match(input,207,FOLLOW_2); 

                    				current = grammarAccess.getTOOLAccess().getKNIMEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTOOLAccess().getKNIMEEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleTOOL"


    // $ANTLR start "ruleDBTYPE"
    // InternalWorkflow.g:7311:1: ruleDBTYPE returns [Enumerator current=null] : ( (enumLiteral_0= 'MYSQL' ) | (enumLiteral_1= 'POSTGRESQL' ) | (enumLiteral_2= 'SQLSERVER' ) | (enumLiteral_3= 'ORACLE' ) | (enumLiteral_4= 'MONGODB' ) | (enumLiteral_5= 'DYNAMODB' ) ) ;
    public final Enumerator ruleDBTYPE() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7317:2: ( ( (enumLiteral_0= 'MYSQL' ) | (enumLiteral_1= 'POSTGRESQL' ) | (enumLiteral_2= 'SQLSERVER' ) | (enumLiteral_3= 'ORACLE' ) | (enumLiteral_4= 'MONGODB' ) | (enumLiteral_5= 'DYNAMODB' ) ) )
            // InternalWorkflow.g:7318:2: ( (enumLiteral_0= 'MYSQL' ) | (enumLiteral_1= 'POSTGRESQL' ) | (enumLiteral_2= 'SQLSERVER' ) | (enumLiteral_3= 'ORACLE' ) | (enumLiteral_4= 'MONGODB' ) | (enumLiteral_5= 'DYNAMODB' ) )
            {
            // InternalWorkflow.g:7318:2: ( (enumLiteral_0= 'MYSQL' ) | (enumLiteral_1= 'POSTGRESQL' ) | (enumLiteral_2= 'SQLSERVER' ) | (enumLiteral_3= 'ORACLE' ) | (enumLiteral_4= 'MONGODB' ) | (enumLiteral_5= 'DYNAMODB' ) )
            int alt108=6;
            switch ( input.LA(1) ) {
            case 208:
                {
                alt108=1;
                }
                break;
            case 209:
                {
                alt108=2;
                }
                break;
            case 210:
                {
                alt108=3;
                }
                break;
            case 211:
                {
                alt108=4;
                }
                break;
            case 212:
                {
                alt108=5;
                }
                break;
            case 213:
                {
                alt108=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalWorkflow.g:7319:3: (enumLiteral_0= 'MYSQL' )
                    {
                    // InternalWorkflow.g:7319:3: (enumLiteral_0= 'MYSQL' )
                    // InternalWorkflow.g:7320:4: enumLiteral_0= 'MYSQL'
                    {
                    enumLiteral_0=(Token)match(input,208,FOLLOW_2); 

                    				current = grammarAccess.getDBTYPEAccess().getMYSQLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDBTYPEAccess().getMYSQLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7327:3: (enumLiteral_1= 'POSTGRESQL' )
                    {
                    // InternalWorkflow.g:7327:3: (enumLiteral_1= 'POSTGRESQL' )
                    // InternalWorkflow.g:7328:4: enumLiteral_1= 'POSTGRESQL'
                    {
                    enumLiteral_1=(Token)match(input,209,FOLLOW_2); 

                    				current = grammarAccess.getDBTYPEAccess().getPOSTGRESQLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDBTYPEAccess().getPOSTGRESQLEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7335:3: (enumLiteral_2= 'SQLSERVER' )
                    {
                    // InternalWorkflow.g:7335:3: (enumLiteral_2= 'SQLSERVER' )
                    // InternalWorkflow.g:7336:4: enumLiteral_2= 'SQLSERVER'
                    {
                    enumLiteral_2=(Token)match(input,210,FOLLOW_2); 

                    				current = grammarAccess.getDBTYPEAccess().getSQLSERVEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDBTYPEAccess().getSQLSERVEREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:7343:3: (enumLiteral_3= 'ORACLE' )
                    {
                    // InternalWorkflow.g:7343:3: (enumLiteral_3= 'ORACLE' )
                    // InternalWorkflow.g:7344:4: enumLiteral_3= 'ORACLE'
                    {
                    enumLiteral_3=(Token)match(input,211,FOLLOW_2); 

                    				current = grammarAccess.getDBTYPEAccess().getORACLEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDBTYPEAccess().getORACLEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:7351:3: (enumLiteral_4= 'MONGODB' )
                    {
                    // InternalWorkflow.g:7351:3: (enumLiteral_4= 'MONGODB' )
                    // InternalWorkflow.g:7352:4: enumLiteral_4= 'MONGODB'
                    {
                    enumLiteral_4=(Token)match(input,212,FOLLOW_2); 

                    				current = grammarAccess.getDBTYPEAccess().getMONGODBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDBTYPEAccess().getMONGODBEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:7359:3: (enumLiteral_5= 'DYNAMODB' )
                    {
                    // InternalWorkflow.g:7359:3: (enumLiteral_5= 'DYNAMODB' )
                    // InternalWorkflow.g:7360:4: enumLiteral_5= 'DYNAMODB'
                    {
                    enumLiteral_5=(Token)match(input,213,FOLLOW_2); 

                    				current = grammarAccess.getDBTYPEAccess().getDYNAMODBEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDBTYPEAccess().getDYNAMODBEnumLiteralDeclaration_5());
                    			

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
    // $ANTLR end "ruleDBTYPE"


    // $ANTLR start "ruleFileType"
    // InternalWorkflow.g:7370:1: ruleFileType returns [Enumerator current=null] : ( (enumLiteral_0= 'CSV' ) | (enumLiteral_1= 'EXCEL' ) | (enumLiteral_2= 'JSON' ) | (enumLiteral_3= 'PARQUET' ) | (enumLiteral_4= 'FEATHER' ) | (enumLiteral_5= 'HDF5' ) ) ;
    public final Enumerator ruleFileType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalWorkflow.g:7376:2: ( ( (enumLiteral_0= 'CSV' ) | (enumLiteral_1= 'EXCEL' ) | (enumLiteral_2= 'JSON' ) | (enumLiteral_3= 'PARQUET' ) | (enumLiteral_4= 'FEATHER' ) | (enumLiteral_5= 'HDF5' ) ) )
            // InternalWorkflow.g:7377:2: ( (enumLiteral_0= 'CSV' ) | (enumLiteral_1= 'EXCEL' ) | (enumLiteral_2= 'JSON' ) | (enumLiteral_3= 'PARQUET' ) | (enumLiteral_4= 'FEATHER' ) | (enumLiteral_5= 'HDF5' ) )
            {
            // InternalWorkflow.g:7377:2: ( (enumLiteral_0= 'CSV' ) | (enumLiteral_1= 'EXCEL' ) | (enumLiteral_2= 'JSON' ) | (enumLiteral_3= 'PARQUET' ) | (enumLiteral_4= 'FEATHER' ) | (enumLiteral_5= 'HDF5' ) )
            int alt109=6;
            switch ( input.LA(1) ) {
            case 214:
                {
                alt109=1;
                }
                break;
            case 215:
                {
                alt109=2;
                }
                break;
            case 216:
                {
                alt109=3;
                }
                break;
            case 217:
                {
                alt109=4;
                }
                break;
            case 218:
                {
                alt109=5;
                }
                break;
            case 219:
                {
                alt109=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalWorkflow.g:7378:3: (enumLiteral_0= 'CSV' )
                    {
                    // InternalWorkflow.g:7378:3: (enumLiteral_0= 'CSV' )
                    // InternalWorkflow.g:7379:4: enumLiteral_0= 'CSV'
                    {
                    enumLiteral_0=(Token)match(input,214,FOLLOW_2); 

                    				current = grammarAccess.getFileTypeAccess().getCSVEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFileTypeAccess().getCSVEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:7386:3: (enumLiteral_1= 'EXCEL' )
                    {
                    // InternalWorkflow.g:7386:3: (enumLiteral_1= 'EXCEL' )
                    // InternalWorkflow.g:7387:4: enumLiteral_1= 'EXCEL'
                    {
                    enumLiteral_1=(Token)match(input,215,FOLLOW_2); 

                    				current = grammarAccess.getFileTypeAccess().getEXCELEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFileTypeAccess().getEXCELEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:7394:3: (enumLiteral_2= 'JSON' )
                    {
                    // InternalWorkflow.g:7394:3: (enumLiteral_2= 'JSON' )
                    // InternalWorkflow.g:7395:4: enumLiteral_2= 'JSON'
                    {
                    enumLiteral_2=(Token)match(input,216,FOLLOW_2); 

                    				current = grammarAccess.getFileTypeAccess().getJSONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFileTypeAccess().getJSONEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:7402:3: (enumLiteral_3= 'PARQUET' )
                    {
                    // InternalWorkflow.g:7402:3: (enumLiteral_3= 'PARQUET' )
                    // InternalWorkflow.g:7403:4: enumLiteral_3= 'PARQUET'
                    {
                    enumLiteral_3=(Token)match(input,217,FOLLOW_2); 

                    				current = grammarAccess.getFileTypeAccess().getPARQUETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFileTypeAccess().getPARQUETEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:7410:3: (enumLiteral_4= 'FEATHER' )
                    {
                    // InternalWorkflow.g:7410:3: (enumLiteral_4= 'FEATHER' )
                    // InternalWorkflow.g:7411:4: enumLiteral_4= 'FEATHER'
                    {
                    enumLiteral_4=(Token)match(input,218,FOLLOW_2); 

                    				current = grammarAccess.getFileTypeAccess().getFEATHEREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFileTypeAccess().getFEATHEREnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:7418:3: (enumLiteral_5= 'HDF5' )
                    {
                    // InternalWorkflow.g:7418:3: (enumLiteral_5= 'HDF5' )
                    // InternalWorkflow.g:7419:4: enumLiteral_5= 'HDF5'
                    {
                    enumLiteral_5=(Token)match(input,219,FOLLOW_2); 

                    				current = grammarAccess.getFileTypeAccess().getHDF5EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFileTypeAccess().getHDF5EnumLiteralDeclaration_5());
                    			

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
    // $ANTLR end "ruleFileType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x8200000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000020080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000200A0000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020000L,0x0000000040000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000001F020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000001E020000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000001C020000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x2212210000020000L,0x0000000012200112L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000018020000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000020000L,0x0040000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000043000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000280020000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001800020000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000001000020000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x001FE00000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x01C0000000020000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000200000020000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0180000000020000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000020000L,0x0000000000060400L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0100000000020000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000020000L,0x0002000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001E00L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000002200140L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000020000L,0x0000000002200140L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000020000L,0x000000000001C000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x01E0000000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000020000L,0x0000000000018000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000020000L,0x0000000000010000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000020000L,0x0000000000004000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0xE000000000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000020000L,0x0000000001000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1E00000000000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000020000L,0x0000000300000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000020000L,0x0000000200000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000020000L,0x0000240400000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0001000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000008000020000L,0x000003E000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000020000L,0x000003E000000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000020000L,0x000003C000000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000020000L,0x0000038000000000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000800000020000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000020000L,0x0000030000000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000020000L,0x0000020000000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x1000008000000000L,0x0000102000000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x1000000000000000L,0x0000102000000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x1000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000008000000000L,0x0001802000000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000000000L,0x0001802000000000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000020000L,0x0010000000000000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_126 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_127 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000A4000000400L});
    public static final BitSet FOLLOW_129 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x00000A4000000400L});
    public static final BitSet FOLLOW_130 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_131 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_132 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_133 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_143 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_144 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_146 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000003F0000L});
    public static final BitSet FOLLOW_147 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020890000L});
    public static final BitSet FOLLOW_149 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_152 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_154 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_155 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_161 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_162 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_164 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_166 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000001E00000000L});
    public static final BitSet FOLLOW_167 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000001C00000000L});
    public static final BitSet FOLLOW_168 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_169 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_170 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_173 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});

}