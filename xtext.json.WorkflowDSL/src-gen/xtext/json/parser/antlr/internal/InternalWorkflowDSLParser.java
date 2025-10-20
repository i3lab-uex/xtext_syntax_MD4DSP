package xtext.json.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xtext.json.services.WorkflowDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWorkflowDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_COMMENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'workflow'", "'{'", "'}'", "'source'", "'='", "'read_csv'", "'('", "','", "')'", "'read_file'", "';'", "'\\t'", "'|'", "'|>'", "'contracts'", "'precondition'", "'postcondition'", "'invariant'", "'value_range'", "'input'", "'.'", "'output'", "'castable_to'", "'in_range'", "'matches'", "'Integer'", "'Double'", "'String'", "'Boolean'", "'condition'", "'if'", "'then'", "'belongs_to'", "'not_belongs_to'", "'special_values'", "'type'", "'value'", "'no_special_values'", "'has_special_values'", "'is_type'", "'filter_rows'", "'missing'", "'range'", "'['", "']'", "'*'", "'inf'", "'-inf'", "'like'", "'include'", "'exclude'", "'select_columns'", "'drop_columns'", "'keep'", "'remove'", "'map'", "'->'", "'=>'", "'replace'", "'as'", "'math'", "'abs'", "'sqrt'", "'pow'", "'log'", "'exp'", "'sin'", "'cos'", "'tan'", "'round'", "'ceil'", "'floor'", "'+'", "'-'", "'/'", "'%'", "'^'", "'bin'", "':'", "'-Infinity'", "'Infinity'", "'to_numeric'", "'to_string'", "'to_categorical'", "'to_boolean'", "'to_date'", "'separator'", "'format'", "'impute'", "'fixed'", "'null'", "'mean'", "'median'", "'mode'", "'most_frequent'", "'max'", "'min'", "'forward_fill'", "'backward_fill'", "'previous_value'", "'next_value'", "'interpolation'", "'moving_average'", "'window'", "'linear'", "'polynomial'", "'degree'", "'spline'", "'outliers'", "'replace_closest'", "'replace_missing'", "'replace_by_closest'", "'replace_with'", "'cap'", "'iqr'", "'scalar'", "'estimation'", "'R_4'", "'R_7'", "'R_8'", "'zscore'", "'threshold'", "'percentile'", "'lower'", "'upper'", "'scope'", "'all'", "'all_outliers'", "'lower_only'", "'upper_only'", "'join'", "'on'", "'inner'", "'left'", "'right'", "'full'", "'cross'", "'and'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'suffix'"
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
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
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
    public static final int T__155=155;
    public static final int T__154=154;
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
    public static final int RULE_SL_COMMENT=9;
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
    public static final int RULE_WS=10;
    public static final int RULE_COMMENT=7;
    public static final int RULE_ANY_OTHER=11;
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


        public InternalWorkflowDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWorkflowDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWorkflowDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalWorkflowDSL.g"; }



     	private WorkflowDSLGrammarAccess grammarAccess;

        public InternalWorkflowDSLParser(TokenStream input, WorkflowDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Workflow";
       	}

       	@Override
       	protected WorkflowDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleWorkflow"
    // InternalWorkflowDSL.g:64:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalWorkflowDSL.g:64:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalWorkflowDSL.g:65:2: iv_ruleWorkflow= ruleWorkflow EOF
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
    // InternalWorkflowDSL.g:71:1: ruleWorkflow returns [EObject current=null] : (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_source_3_0= ruleDataSource ) ) ( (lv_body_4_0= ruleWorkflowBody ) ) otherlv_5= '}' ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_source_3_0 = null;

        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:77:2: ( (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_source_3_0= ruleDataSource ) ) ( (lv_body_4_0= ruleWorkflowBody ) ) otherlv_5= '}' ) )
            // InternalWorkflowDSL.g:78:2: (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_source_3_0= ruleDataSource ) ) ( (lv_body_4_0= ruleWorkflowBody ) ) otherlv_5= '}' )
            {
            // InternalWorkflowDSL.g:78:2: (otherlv_0= 'workflow' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_source_3_0= ruleDataSource ) ) ( (lv_body_4_0= ruleWorkflowBody ) ) otherlv_5= '}' )
            // InternalWorkflowDSL.g:79:3: otherlv_0= 'workflow' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_source_3_0= ruleDataSource ) ) ( (lv_body_4_0= ruleWorkflowBody ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkflowAccess().getWorkflowKeyword_0());
            		
            // InternalWorkflowDSL.g:83:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:84:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:84:4: (lv_name_1_0= RULE_STRING )
            // InternalWorkflowDSL.g:85:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getWorkflowAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWorkflowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflowDSL.g:105:3: ( (lv_source_3_0= ruleDataSource ) )
            // InternalWorkflowDSL.g:106:4: (lv_source_3_0= ruleDataSource )
            {
            // InternalWorkflowDSL.g:106:4: (lv_source_3_0= ruleDataSource )
            // InternalWorkflowDSL.g:107:5: lv_source_3_0= ruleDataSource
            {

            					newCompositeNode(grammarAccess.getWorkflowAccess().getSourceDataSourceParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_source_3_0=ruleDataSource();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_3_0,
            						"xtext.json.WorkflowDSL.DataSource");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:124:3: ( (lv_body_4_0= ruleWorkflowBody ) )
            // InternalWorkflowDSL.g:125:4: (lv_body_4_0= ruleWorkflowBody )
            {
            // InternalWorkflowDSL.g:125:4: (lv_body_4_0= ruleWorkflowBody )
            // InternalWorkflowDSL.g:126:5: lv_body_4_0= ruleWorkflowBody
            {

            					newCompositeNode(grammarAccess.getWorkflowAccess().getBodyWorkflowBodyParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_body_4_0=ruleWorkflowBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_4_0,
            						"xtext.json.WorkflowDSL.WorkflowBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_5());
            		

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


    // $ANTLR start "entryRuleDataSource"
    // InternalWorkflowDSL.g:151:1: entryRuleDataSource returns [EObject current=null] : iv_ruleDataSource= ruleDataSource EOF ;
    public final EObject entryRuleDataSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataSource = null;


        try {
            // InternalWorkflowDSL.g:151:51: (iv_ruleDataSource= ruleDataSource EOF )
            // InternalWorkflowDSL.g:152:2: iv_ruleDataSource= ruleDataSource EOF
            {
             newCompositeNode(grammarAccess.getDataSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataSource=ruleDataSource();

            state._fsp--;

             current =iv_ruleDataSource; 
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
    // $ANTLR end "entryRuleDataSource"


    // $ANTLR start "ruleDataSource"
    // InternalWorkflowDSL.g:158:1: ruleDataSource returns [EObject current=null] : (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_reader_3_0= ruleDataReader ) ) ) ;
    public final EObject ruleDataSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_reader_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:164:2: ( (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_reader_3_0= ruleDataReader ) ) ) )
            // InternalWorkflowDSL.g:165:2: (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_reader_3_0= ruleDataReader ) ) )
            {
            // InternalWorkflowDSL.g:165:2: (otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_reader_3_0= ruleDataReader ) ) )
            // InternalWorkflowDSL.g:166:3: otherlv_0= 'source' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_reader_3_0= ruleDataReader ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDataSourceAccess().getSourceKeyword_0());
            		
            // InternalWorkflowDSL.g:170:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflowDSL.g:171:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflowDSL.g:171:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflowDSL.g:172:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataSourceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataSourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getDataSourceAccess().getEqualsSignKeyword_2());
            		
            // InternalWorkflowDSL.g:192:3: ( (lv_reader_3_0= ruleDataReader ) )
            // InternalWorkflowDSL.g:193:4: (lv_reader_3_0= ruleDataReader )
            {
            // InternalWorkflowDSL.g:193:4: (lv_reader_3_0= ruleDataReader )
            // InternalWorkflowDSL.g:194:5: lv_reader_3_0= ruleDataReader
            {

            					newCompositeNode(grammarAccess.getDataSourceAccess().getReaderDataReaderParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_reader_3_0=ruleDataReader();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataSourceRule());
            					}
            					set(
            						current,
            						"reader",
            						lv_reader_3_0,
            						"xtext.json.WorkflowDSL.DataReader");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleDataSource"


    // $ANTLR start "entryRuleDataReader"
    // InternalWorkflowDSL.g:215:1: entryRuleDataReader returns [EObject current=null] : iv_ruleDataReader= ruleDataReader EOF ;
    public final EObject entryRuleDataReader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataReader = null;


        try {
            // InternalWorkflowDSL.g:215:51: (iv_ruleDataReader= ruleDataReader EOF )
            // InternalWorkflowDSL.g:216:2: iv_ruleDataReader= ruleDataReader EOF
            {
             newCompositeNode(grammarAccess.getDataReaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataReader=ruleDataReader();

            state._fsp--;

             current =iv_ruleDataReader; 
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
    // $ANTLR end "entryRuleDataReader"


    // $ANTLR start "ruleDataReader"
    // InternalWorkflowDSL.g:222:1: ruleDataReader returns [EObject current=null] : (this_CSVReader_0= ruleCSVReader | this_FileReader_1= ruleFileReader ) ;
    public final EObject ruleDataReader() throws RecognitionException {
        EObject current = null;

        EObject this_CSVReader_0 = null;

        EObject this_FileReader_1 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:228:2: ( (this_CSVReader_0= ruleCSVReader | this_FileReader_1= ruleFileReader ) )
            // InternalWorkflowDSL.g:229:2: (this_CSVReader_0= ruleCSVReader | this_FileReader_1= ruleFileReader )
            {
            // InternalWorkflowDSL.g:229:2: (this_CSVReader_0= ruleCSVReader | this_FileReader_1= ruleFileReader )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==17) ) {
                alt1=1;
            }
            else if ( (LA1_0==21) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalWorkflowDSL.g:230:3: this_CSVReader_0= ruleCSVReader
                    {

                    			newCompositeNode(grammarAccess.getDataReaderAccess().getCSVReaderParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CSVReader_0=ruleCSVReader();

                    state._fsp--;


                    			current = this_CSVReader_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:239:3: this_FileReader_1= ruleFileReader
                    {

                    			newCompositeNode(grammarAccess.getDataReaderAccess().getFileReaderParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FileReader_1=ruleFileReader();

                    state._fsp--;


                    			current = this_FileReader_1;
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
    // $ANTLR end "ruleDataReader"


    // $ANTLR start "entryRuleCSVReader"
    // InternalWorkflowDSL.g:251:1: entryRuleCSVReader returns [EObject current=null] : iv_ruleCSVReader= ruleCSVReader EOF ;
    public final EObject entryRuleCSVReader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCSVReader = null;


        try {
            // InternalWorkflowDSL.g:251:50: (iv_ruleCSVReader= ruleCSVReader EOF )
            // InternalWorkflowDSL.g:252:2: iv_ruleCSVReader= ruleCSVReader EOF
            {
             newCompositeNode(grammarAccess.getCSVReaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCSVReader=ruleCSVReader();

            state._fsp--;

             current =iv_ruleCSVReader; 
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
    // $ANTLR end "entryRuleCSVReader"


    // $ANTLR start "ruleCSVReader"
    // InternalWorkflowDSL.g:258:1: ruleCSVReader returns [EObject current=null] : (otherlv_0= 'read_csv' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) (otherlv_3= ',' ( (lv_delimiter_4_0= ruleDelimiter ) ) )? otherlv_5= ')' ) ;
    public final EObject ruleCSVReader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_filePath_2_0 = null;

        EObject lv_delimiter_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:264:2: ( (otherlv_0= 'read_csv' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) (otherlv_3= ',' ( (lv_delimiter_4_0= ruleDelimiter ) ) )? otherlv_5= ')' ) )
            // InternalWorkflowDSL.g:265:2: (otherlv_0= 'read_csv' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) (otherlv_3= ',' ( (lv_delimiter_4_0= ruleDelimiter ) ) )? otherlv_5= ')' )
            {
            // InternalWorkflowDSL.g:265:2: (otherlv_0= 'read_csv' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) (otherlv_3= ',' ( (lv_delimiter_4_0= ruleDelimiter ) ) )? otherlv_5= ')' )
            // InternalWorkflowDSL.g:266:3: otherlv_0= 'read_csv' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) (otherlv_3= ',' ( (lv_delimiter_4_0= ruleDelimiter ) ) )? otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getCSVReaderAccess().getRead_csvKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCSVReaderAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:274:3: ( (lv_filePath_2_0= ruleFilePath ) )
            // InternalWorkflowDSL.g:275:4: (lv_filePath_2_0= ruleFilePath )
            {
            // InternalWorkflowDSL.g:275:4: (lv_filePath_2_0= ruleFilePath )
            // InternalWorkflowDSL.g:276:5: lv_filePath_2_0= ruleFilePath
            {

            					newCompositeNode(grammarAccess.getCSVReaderAccess().getFilePathFilePathParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_filePath_2_0=ruleFilePath();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCSVReaderRule());
            					}
            					set(
            						current,
            						"filePath",
            						lv_filePath_2_0,
            						"xtext.json.WorkflowDSL.FilePath");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:293:3: (otherlv_3= ',' ( (lv_delimiter_4_0= ruleDelimiter ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalWorkflowDSL.g:294:4: otherlv_3= ',' ( (lv_delimiter_4_0= ruleDelimiter ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getCSVReaderAccess().getCommaKeyword_3_0());
                    			
                    // InternalWorkflowDSL.g:298:4: ( (lv_delimiter_4_0= ruleDelimiter ) )
                    // InternalWorkflowDSL.g:299:5: (lv_delimiter_4_0= ruleDelimiter )
                    {
                    // InternalWorkflowDSL.g:299:5: (lv_delimiter_4_0= ruleDelimiter )
                    // InternalWorkflowDSL.g:300:6: lv_delimiter_4_0= ruleDelimiter
                    {

                    						newCompositeNode(grammarAccess.getCSVReaderAccess().getDelimiterDelimiterParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_delimiter_4_0=ruleDelimiter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCSVReaderRule());
                    						}
                    						set(
                    							current,
                    							"delimiter",
                    							lv_delimiter_4_0,
                    							"xtext.json.WorkflowDSL.Delimiter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCSVReaderAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleCSVReader"


    // $ANTLR start "entryRuleFileReader"
    // InternalWorkflowDSL.g:326:1: entryRuleFileReader returns [EObject current=null] : iv_ruleFileReader= ruleFileReader EOF ;
    public final EObject entryRuleFileReader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFileReader = null;


        try {
            // InternalWorkflowDSL.g:326:51: (iv_ruleFileReader= ruleFileReader EOF )
            // InternalWorkflowDSL.g:327:2: iv_ruleFileReader= ruleFileReader EOF
            {
             newCompositeNode(grammarAccess.getFileReaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFileReader=ruleFileReader();

            state._fsp--;

             current =iv_ruleFileReader; 
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
    // $ANTLR end "entryRuleFileReader"


    // $ANTLR start "ruleFileReader"
    // InternalWorkflowDSL.g:333:1: ruleFileReader returns [EObject current=null] : (otherlv_0= 'read_file' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) otherlv_3= ')' ) ;
    public final EObject ruleFileReader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_filePath_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:339:2: ( (otherlv_0= 'read_file' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) otherlv_3= ')' ) )
            // InternalWorkflowDSL.g:340:2: (otherlv_0= 'read_file' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) otherlv_3= ')' )
            {
            // InternalWorkflowDSL.g:340:2: (otherlv_0= 'read_file' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) otherlv_3= ')' )
            // InternalWorkflowDSL.g:341:3: otherlv_0= 'read_file' otherlv_1= '(' ( (lv_filePath_2_0= ruleFilePath ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getFileReaderAccess().getRead_fileKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getFileReaderAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:349:3: ( (lv_filePath_2_0= ruleFilePath ) )
            // InternalWorkflowDSL.g:350:4: (lv_filePath_2_0= ruleFilePath )
            {
            // InternalWorkflowDSL.g:350:4: (lv_filePath_2_0= ruleFilePath )
            // InternalWorkflowDSL.g:351:5: lv_filePath_2_0= ruleFilePath
            {

            					newCompositeNode(grammarAccess.getFileReaderAccess().getFilePathFilePathParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_filePath_2_0=ruleFilePath();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFileReaderRule());
            					}
            					set(
            						current,
            						"filePath",
            						lv_filePath_2_0,
            						"xtext.json.WorkflowDSL.FilePath");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFileReaderAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleFileReader"


    // $ANTLR start "entryRuleFilePath"
    // InternalWorkflowDSL.g:376:1: entryRuleFilePath returns [EObject current=null] : iv_ruleFilePath= ruleFilePath EOF ;
    public final EObject entryRuleFilePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilePath = null;


        try {
            // InternalWorkflowDSL.g:376:49: (iv_ruleFilePath= ruleFilePath EOF )
            // InternalWorkflowDSL.g:377:2: iv_ruleFilePath= ruleFilePath EOF
            {
             newCompositeNode(grammarAccess.getFilePathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilePath=ruleFilePath();

            state._fsp--;

             current =iv_ruleFilePath; 
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
    // $ANTLR end "entryRuleFilePath"


    // $ANTLR start "ruleFilePath"
    // InternalWorkflowDSL.g:383:1: ruleFilePath returns [EObject current=null] : ( (lv_path_0_0= RULE_STRING ) ) ;
    public final EObject ruleFilePath() throws RecognitionException {
        EObject current = null;

        Token lv_path_0_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:389:2: ( ( (lv_path_0_0= RULE_STRING ) ) )
            // InternalWorkflowDSL.g:390:2: ( (lv_path_0_0= RULE_STRING ) )
            {
            // InternalWorkflowDSL.g:390:2: ( (lv_path_0_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:391:3: (lv_path_0_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:391:3: (lv_path_0_0= RULE_STRING )
            // InternalWorkflowDSL.g:392:4: lv_path_0_0= RULE_STRING
            {
            lv_path_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_path_0_0, grammarAccess.getFilePathAccess().getPathSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFilePathRule());
            				}
            				setWithLastConsumed(
            					current,
            					"path",
            					lv_path_0_0,
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
    // $ANTLR end "ruleFilePath"


    // $ANTLR start "entryRuleDelimiter"
    // InternalWorkflowDSL.g:411:1: entryRuleDelimiter returns [EObject current=null] : iv_ruleDelimiter= ruleDelimiter EOF ;
    public final EObject entryRuleDelimiter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelimiter = null;


        try {
            // InternalWorkflowDSL.g:411:50: (iv_ruleDelimiter= ruleDelimiter EOF )
            // InternalWorkflowDSL.g:412:2: iv_ruleDelimiter= ruleDelimiter EOF
            {
             newCompositeNode(grammarAccess.getDelimiterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDelimiter=ruleDelimiter();

            state._fsp--;

             current =iv_ruleDelimiter; 
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
    // $ANTLR end "entryRuleDelimiter"


    // $ANTLR start "ruleDelimiter"
    // InternalWorkflowDSL.g:418:1: ruleDelimiter returns [EObject current=null] : (otherlv_0= ',' | otherlv_1= ';' | otherlv_2= '\\t' | otherlv_3= '|' | ( (lv_value_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleDelimiter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_value_4_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:424:2: ( (otherlv_0= ',' | otherlv_1= ';' | otherlv_2= '\\t' | otherlv_3= '|' | ( (lv_value_4_0= RULE_STRING ) ) ) )
            // InternalWorkflowDSL.g:425:2: (otherlv_0= ',' | otherlv_1= ';' | otherlv_2= '\\t' | otherlv_3= '|' | ( (lv_value_4_0= RULE_STRING ) ) )
            {
            // InternalWorkflowDSL.g:425:2: (otherlv_0= ',' | otherlv_1= ';' | otherlv_2= '\\t' | otherlv_3= '|' | ( (lv_value_4_0= RULE_STRING ) ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            case 24:
                {
                alt3=4;
                }
                break;
            case RULE_STRING:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalWorkflowDSL.g:426:3: otherlv_0= ','
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_2); 

                    			newLeafNode(otherlv_0, grammarAccess.getDelimiterAccess().getCommaKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:431:3: otherlv_1= ';'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_2); 

                    			newLeafNode(otherlv_1, grammarAccess.getDelimiterAccess().getSemicolonKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:436:3: otherlv_2= '\\t'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_2); 

                    			newLeafNode(otherlv_2, grammarAccess.getDelimiterAccess().getTabKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:441:3: otherlv_3= '|'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_2); 

                    			newLeafNode(otherlv_3, grammarAccess.getDelimiterAccess().getVerticalLineKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:446:3: ( (lv_value_4_0= RULE_STRING ) )
                    {
                    // InternalWorkflowDSL.g:446:3: ( (lv_value_4_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:447:4: (lv_value_4_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:447:4: (lv_value_4_0= RULE_STRING )
                    // InternalWorkflowDSL.g:448:5: lv_value_4_0= RULE_STRING
                    {
                    lv_value_4_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_value_4_0, grammarAccess.getDelimiterAccess().getValueSTRINGTerminalRuleCall_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDelimiterRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_4_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


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
    // $ANTLR end "ruleDelimiter"


    // $ANTLR start "entryRuleWorkflowBody"
    // InternalWorkflowDSL.g:468:1: entryRuleWorkflowBody returns [EObject current=null] : iv_ruleWorkflowBody= ruleWorkflowBody EOF ;
    public final EObject entryRuleWorkflowBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflowBody = null;


        try {
            // InternalWorkflowDSL.g:468:53: (iv_ruleWorkflowBody= ruleWorkflowBody EOF )
            // InternalWorkflowDSL.g:469:2: iv_ruleWorkflowBody= ruleWorkflowBody EOF
            {
             newCompositeNode(grammarAccess.getWorkflowBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkflowBody=ruleWorkflowBody();

            state._fsp--;

             current =iv_ruleWorkflowBody; 
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
    // $ANTLR end "entryRuleWorkflowBody"


    // $ANTLR start "ruleWorkflowBody"
    // InternalWorkflowDSL.g:475:1: ruleWorkflowBody returns [EObject current=null] : ( (lv_steps_0_0= ruleStep ) )* ;
    public final EObject ruleWorkflowBody() throws RecognitionException {
        EObject current = null;

        EObject lv_steps_0_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:481:2: ( ( (lv_steps_0_0= ruleStep ) )* )
            // InternalWorkflowDSL.g:482:2: ( (lv_steps_0_0= ruleStep ) )*
            {
            // InternalWorkflowDSL.g:482:2: ( (lv_steps_0_0= ruleStep ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalWorkflowDSL.g:483:3: (lv_steps_0_0= ruleStep )
            	    {
            	    // InternalWorkflowDSL.g:483:3: (lv_steps_0_0= ruleStep )
            	    // InternalWorkflowDSL.g:484:4: lv_steps_0_0= ruleStep
            	    {

            	    				newCompositeNode(grammarAccess.getWorkflowBodyAccess().getStepsStepParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_15);
            	    lv_steps_0_0=ruleStep();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getWorkflowBodyRule());
            	    				}
            	    				add(
            	    					current,
            	    					"steps",
            	    					lv_steps_0_0,
            	    					"xtext.json.WorkflowDSL.Step");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleWorkflowBody"


    // $ANTLR start "entryRuleStep"
    // InternalWorkflowDSL.g:504:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalWorkflowDSL.g:504:45: (iv_ruleStep= ruleStep EOF )
            // InternalWorkflowDSL.g:505:2: iv_ruleStep= ruleStep EOF
            {
             newCompositeNode(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;

             current =iv_ruleStep; 
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
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalWorkflowDSL.g:511:1: ruleStep returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_transformation_2_0= ruleTransformation ) ) (otherlv_3= '|>' ( (lv_target_4_0= RULE_ID ) ) )? ( (lv_contracts_5_0= ruleContractBlock ) )? ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_target_4_0=null;
        EObject lv_transformation_2_0 = null;

        EObject lv_contracts_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:517:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_transformation_2_0= ruleTransformation ) ) (otherlv_3= '|>' ( (lv_target_4_0= RULE_ID ) ) )? ( (lv_contracts_5_0= ruleContractBlock ) )? ) )
            // InternalWorkflowDSL.g:518:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_transformation_2_0= ruleTransformation ) ) (otherlv_3= '|>' ( (lv_target_4_0= RULE_ID ) ) )? ( (lv_contracts_5_0= ruleContractBlock ) )? )
            {
            // InternalWorkflowDSL.g:518:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_transformation_2_0= ruleTransformation ) ) (otherlv_3= '|>' ( (lv_target_4_0= RULE_ID ) ) )? ( (lv_contracts_5_0= ruleContractBlock ) )? )
            // InternalWorkflowDSL.g:519:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_transformation_2_0= ruleTransformation ) ) (otherlv_3= '|>' ( (lv_target_4_0= RULE_ID ) ) )? ( (lv_contracts_5_0= ruleContractBlock ) )?
            {
            // InternalWorkflowDSL.g:519:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalWorkflowDSL.g:520:4: (lv_name_0_0= RULE_ID )
            {
            // InternalWorkflowDSL.g:520:4: (lv_name_0_0= RULE_ID )
            // InternalWorkflowDSL.g:521:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_0_0, grammarAccess.getStepAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStepRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getStepAccess().getEqualsSignKeyword_1());
            		
            // InternalWorkflowDSL.g:541:3: ( (lv_transformation_2_0= ruleTransformation ) )
            // InternalWorkflowDSL.g:542:4: (lv_transformation_2_0= ruleTransformation )
            {
            // InternalWorkflowDSL.g:542:4: (lv_transformation_2_0= ruleTransformation )
            // InternalWorkflowDSL.g:543:5: lv_transformation_2_0= ruleTransformation
            {

            					newCompositeNode(grammarAccess.getStepAccess().getTransformationTransformationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_transformation_2_0=ruleTransformation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepRule());
            					}
            					set(
            						current,
            						"transformation",
            						lv_transformation_2_0,
            						"xtext.json.WorkflowDSL.Transformation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:560:3: (otherlv_3= '|>' ( (lv_target_4_0= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==25) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalWorkflowDSL.g:561:4: otherlv_3= '|>' ( (lv_target_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getStepAccess().getVerticalLineGreaterThanSignKeyword_3_0());
                    			
                    // InternalWorkflowDSL.g:565:4: ( (lv_target_4_0= RULE_ID ) )
                    // InternalWorkflowDSL.g:566:5: (lv_target_4_0= RULE_ID )
                    {
                    // InternalWorkflowDSL.g:566:5: (lv_target_4_0= RULE_ID )
                    // InternalWorkflowDSL.g:567:6: lv_target_4_0= RULE_ID
                    {
                    lv_target_4_0=(Token)match(input,RULE_ID,FOLLOW_18); 

                    						newLeafNode(lv_target_4_0, grammarAccess.getStepAccess().getTargetIDTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStepRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"target",
                    							lv_target_4_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflowDSL.g:584:3: ( (lv_contracts_5_0= ruleContractBlock ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalWorkflowDSL.g:585:4: (lv_contracts_5_0= ruleContractBlock )
                    {
                    // InternalWorkflowDSL.g:585:4: (lv_contracts_5_0= ruleContractBlock )
                    // InternalWorkflowDSL.g:586:5: lv_contracts_5_0= ruleContractBlock
                    {

                    					newCompositeNode(grammarAccess.getStepAccess().getContractsContractBlockParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_contracts_5_0=ruleContractBlock();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStepRule());
                    					}
                    					set(
                    						current,
                    						"contracts",
                    						lv_contracts_5_0,
                    						"xtext.json.WorkflowDSL.ContractBlock");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleContractBlock"
    // InternalWorkflowDSL.g:607:1: entryRuleContractBlock returns [EObject current=null] : iv_ruleContractBlock= ruleContractBlock EOF ;
    public final EObject entryRuleContractBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractBlock = null;


        try {
            // InternalWorkflowDSL.g:607:54: (iv_ruleContractBlock= ruleContractBlock EOF )
            // InternalWorkflowDSL.g:608:2: iv_ruleContractBlock= ruleContractBlock EOF
            {
             newCompositeNode(grammarAccess.getContractBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractBlock=ruleContractBlock();

            state._fsp--;

             current =iv_ruleContractBlock; 
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
    // $ANTLR end "entryRuleContractBlock"


    // $ANTLR start "ruleContractBlock"
    // InternalWorkflowDSL.g:614:1: ruleContractBlock returns [EObject current=null] : (otherlv_0= 'contracts' otherlv_1= '{' ( (lv_contracts_2_0= ruleContract ) )* otherlv_3= '}' ) ;
    public final EObject ruleContractBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_contracts_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:620:2: ( (otherlv_0= 'contracts' otherlv_1= '{' ( (lv_contracts_2_0= ruleContract ) )* otherlv_3= '}' ) )
            // InternalWorkflowDSL.g:621:2: (otherlv_0= 'contracts' otherlv_1= '{' ( (lv_contracts_2_0= ruleContract ) )* otherlv_3= '}' )
            {
            // InternalWorkflowDSL.g:621:2: (otherlv_0= 'contracts' otherlv_1= '{' ( (lv_contracts_2_0= ruleContract ) )* otherlv_3= '}' )
            // InternalWorkflowDSL.g:622:3: otherlv_0= 'contracts' otherlv_1= '{' ( (lv_contracts_2_0= ruleContract ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getContractBlockAccess().getContractsKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getContractBlockAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalWorkflowDSL.g:630:3: ( (lv_contracts_2_0= ruleContract ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=27 && LA7_0<=29)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalWorkflowDSL.g:631:4: (lv_contracts_2_0= ruleContract )
            	    {
            	    // InternalWorkflowDSL.g:631:4: (lv_contracts_2_0= ruleContract )
            	    // InternalWorkflowDSL.g:632:5: lv_contracts_2_0= ruleContract
            	    {

            	    					newCompositeNode(grammarAccess.getContractBlockAccess().getContractsContractParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_contracts_2_0=ruleContract();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContractBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contracts",
            	    						lv_contracts_2_0,
            	    						"xtext.json.WorkflowDSL.Contract");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getContractBlockAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleContractBlock"


    // $ANTLR start "entryRuleContract"
    // InternalWorkflowDSL.g:657:1: entryRuleContract returns [EObject current=null] : iv_ruleContract= ruleContract EOF ;
    public final EObject entryRuleContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContract = null;


        try {
            // InternalWorkflowDSL.g:657:49: (iv_ruleContract= ruleContract EOF )
            // InternalWorkflowDSL.g:658:2: iv_ruleContract= ruleContract EOF
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
    // InternalWorkflowDSL.g:664:1: ruleContract returns [EObject current=null] : (this_Precondition_0= rulePrecondition | this_Postcondition_1= rulePostcondition | this_Invariant_2= ruleInvariant ) ;
    public final EObject ruleContract() throws RecognitionException {
        EObject current = null;

        EObject this_Precondition_0 = null;

        EObject this_Postcondition_1 = null;

        EObject this_Invariant_2 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:670:2: ( (this_Precondition_0= rulePrecondition | this_Postcondition_1= rulePostcondition | this_Invariant_2= ruleInvariant ) )
            // InternalWorkflowDSL.g:671:2: (this_Precondition_0= rulePrecondition | this_Postcondition_1= rulePostcondition | this_Invariant_2= ruleInvariant )
            {
            // InternalWorkflowDSL.g:671:2: (this_Precondition_0= rulePrecondition | this_Postcondition_1= rulePostcondition | this_Invariant_2= ruleInvariant )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt8=1;
                }
                break;
            case 28:
                {
                alt8=2;
                }
                break;
            case 29:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalWorkflowDSL.g:672:3: this_Precondition_0= rulePrecondition
                    {

                    			newCompositeNode(grammarAccess.getContractAccess().getPreconditionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Precondition_0=rulePrecondition();

                    state._fsp--;


                    			current = this_Precondition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:681:3: this_Postcondition_1= rulePostcondition
                    {

                    			newCompositeNode(grammarAccess.getContractAccess().getPostconditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Postcondition_1=rulePostcondition();

                    state._fsp--;


                    			current = this_Postcondition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:690:3: this_Invariant_2= ruleInvariant
                    {

                    			newCompositeNode(grammarAccess.getContractAccess().getInvariantParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Invariant_2=ruleInvariant();

                    state._fsp--;


                    			current = this_Invariant_2;
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
    // $ANTLR end "ruleContract"


    // $ANTLR start "entryRulePrecondition"
    // InternalWorkflowDSL.g:702:1: entryRulePrecondition returns [EObject current=null] : iv_rulePrecondition= rulePrecondition EOF ;
    public final EObject entryRulePrecondition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrecondition = null;


        try {
            // InternalWorkflowDSL.g:702:53: (iv_rulePrecondition= rulePrecondition EOF )
            // InternalWorkflowDSL.g:703:2: iv_rulePrecondition= rulePrecondition EOF
            {
             newCompositeNode(grammarAccess.getPreconditionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrecondition=rulePrecondition();

            state._fsp--;

             current =iv_rulePrecondition; 
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
    // $ANTLR end "entryRulePrecondition"


    // $ANTLR start "rulePrecondition"
    // InternalWorkflowDSL.g:709:1: rulePrecondition returns [EObject current=null] : (otherlv_0= 'precondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' ) ;
    public final EObject rulePrecondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:715:2: ( (otherlv_0= 'precondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' ) )
            // InternalWorkflowDSL.g:716:2: (otherlv_0= 'precondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' )
            {
            // InternalWorkflowDSL.g:716:2: (otherlv_0= 'precondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' )
            // InternalWorkflowDSL.g:717:3: otherlv_0= 'precondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getPreconditionAccess().getPreconditionKeyword_0());
            		
            // InternalWorkflowDSL.g:721:3: ( (lv_name_1_0= ruleContractName ) )
            // InternalWorkflowDSL.g:722:4: (lv_name_1_0= ruleContractName )
            {
            // InternalWorkflowDSL.g:722:4: (lv_name_1_0= ruleContractName )
            // InternalWorkflowDSL.g:723:5: lv_name_1_0= ruleContractName
            {

            					newCompositeNode(grammarAccess.getPreconditionAccess().getNameContractNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleContractName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPreconditionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.json.WorkflowDSL.ContractName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getPreconditionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflowDSL.g:744:3: ( (lv_body_3_0= ruleContractBody ) )
            // InternalWorkflowDSL.g:745:4: (lv_body_3_0= ruleContractBody )
            {
            // InternalWorkflowDSL.g:745:4: (lv_body_3_0= ruleContractBody )
            // InternalWorkflowDSL.g:746:5: lv_body_3_0= ruleContractBody
            {

            					newCompositeNode(grammarAccess.getPreconditionAccess().getBodyContractBodyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_body_3_0=ruleContractBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPreconditionRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_3_0,
            						"xtext.json.WorkflowDSL.ContractBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPreconditionAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "rulePrecondition"


    // $ANTLR start "entryRulePostcondition"
    // InternalWorkflowDSL.g:771:1: entryRulePostcondition returns [EObject current=null] : iv_rulePostcondition= rulePostcondition EOF ;
    public final EObject entryRulePostcondition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostcondition = null;


        try {
            // InternalWorkflowDSL.g:771:54: (iv_rulePostcondition= rulePostcondition EOF )
            // InternalWorkflowDSL.g:772:2: iv_rulePostcondition= rulePostcondition EOF
            {
             newCompositeNode(grammarAccess.getPostconditionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePostcondition=rulePostcondition();

            state._fsp--;

             current =iv_rulePostcondition; 
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
    // $ANTLR end "entryRulePostcondition"


    // $ANTLR start "rulePostcondition"
    // InternalWorkflowDSL.g:778:1: rulePostcondition returns [EObject current=null] : (otherlv_0= 'postcondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' ) ;
    public final EObject rulePostcondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:784:2: ( (otherlv_0= 'postcondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' ) )
            // InternalWorkflowDSL.g:785:2: (otherlv_0= 'postcondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' )
            {
            // InternalWorkflowDSL.g:785:2: (otherlv_0= 'postcondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' )
            // InternalWorkflowDSL.g:786:3: otherlv_0= 'postcondition' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getPostconditionAccess().getPostconditionKeyword_0());
            		
            // InternalWorkflowDSL.g:790:3: ( (lv_name_1_0= ruleContractName ) )
            // InternalWorkflowDSL.g:791:4: (lv_name_1_0= ruleContractName )
            {
            // InternalWorkflowDSL.g:791:4: (lv_name_1_0= ruleContractName )
            // InternalWorkflowDSL.g:792:5: lv_name_1_0= ruleContractName
            {

            					newCompositeNode(grammarAccess.getPostconditionAccess().getNameContractNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleContractName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPostconditionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.json.WorkflowDSL.ContractName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getPostconditionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflowDSL.g:813:3: ( (lv_body_3_0= ruleContractBody ) )
            // InternalWorkflowDSL.g:814:4: (lv_body_3_0= ruleContractBody )
            {
            // InternalWorkflowDSL.g:814:4: (lv_body_3_0= ruleContractBody )
            // InternalWorkflowDSL.g:815:5: lv_body_3_0= ruleContractBody
            {

            					newCompositeNode(grammarAccess.getPostconditionAccess().getBodyContractBodyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_body_3_0=ruleContractBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPostconditionRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_3_0,
            						"xtext.json.WorkflowDSL.ContractBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPostconditionAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "rulePostcondition"


    // $ANTLR start "entryRuleInvariant"
    // InternalWorkflowDSL.g:840:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // InternalWorkflowDSL.g:840:50: (iv_ruleInvariant= ruleInvariant EOF )
            // InternalWorkflowDSL.g:841:2: iv_ruleInvariant= ruleInvariant EOF
            {
             newCompositeNode(grammarAccess.getInvariantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvariant=ruleInvariant();

            state._fsp--;

             current =iv_ruleInvariant; 
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
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // InternalWorkflowDSL.g:847:1: ruleInvariant returns [EObject current=null] : (otherlv_0= 'invariant' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:853:2: ( (otherlv_0= 'invariant' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' ) )
            // InternalWorkflowDSL.g:854:2: (otherlv_0= 'invariant' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' )
            {
            // InternalWorkflowDSL.g:854:2: (otherlv_0= 'invariant' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}' )
            // InternalWorkflowDSL.g:855:3: otherlv_0= 'invariant' ( (lv_name_1_0= ruleContractName ) ) otherlv_2= '{' ( (lv_body_3_0= ruleContractBody ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getInvariantAccess().getInvariantKeyword_0());
            		
            // InternalWorkflowDSL.g:859:3: ( (lv_name_1_0= ruleContractName ) )
            // InternalWorkflowDSL.g:860:4: (lv_name_1_0= ruleContractName )
            {
            // InternalWorkflowDSL.g:860:4: (lv_name_1_0= ruleContractName )
            // InternalWorkflowDSL.g:861:5: lv_name_1_0= ruleContractName
            {

            					newCompositeNode(grammarAccess.getInvariantAccess().getNameContractNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleContractName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInvariantRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"xtext.json.WorkflowDSL.ContractName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getInvariantAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflowDSL.g:882:3: ( (lv_body_3_0= ruleContractBody ) )
            // InternalWorkflowDSL.g:883:4: (lv_body_3_0= ruleContractBody )
            {
            // InternalWorkflowDSL.g:883:4: (lv_body_3_0= ruleContractBody )
            // InternalWorkflowDSL.g:884:5: lv_body_3_0= ruleContractBody
            {

            					newCompositeNode(grammarAccess.getInvariantAccess().getBodyContractBodyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_body_3_0=ruleContractBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInvariantRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_3_0,
            						"xtext.json.WorkflowDSL.ContractBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getInvariantAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "entryRuleContractName"
    // InternalWorkflowDSL.g:909:1: entryRuleContractName returns [EObject current=null] : iv_ruleContractName= ruleContractName EOF ;
    public final EObject entryRuleContractName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractName = null;


        try {
            // InternalWorkflowDSL.g:909:53: (iv_ruleContractName= ruleContractName EOF )
            // InternalWorkflowDSL.g:910:2: iv_ruleContractName= ruleContractName EOF
            {
             newCompositeNode(grammarAccess.getContractNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractName=ruleContractName();

            state._fsp--;

             current =iv_ruleContractName; 
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
    // $ANTLR end "entryRuleContractName"


    // $ANTLR start "ruleContractName"
    // InternalWorkflowDSL.g:916:1: ruleContractName returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContractName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:922:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalWorkflowDSL.g:923:2: ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalWorkflowDSL.g:923:2: ( ( (lv_name_0_0= RULE_STRING ) ) | ( (lv_name_1_0= RULE_ID ) ) )
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
                    // InternalWorkflowDSL.g:924:3: ( (lv_name_0_0= RULE_STRING ) )
                    {
                    // InternalWorkflowDSL.g:924:3: ( (lv_name_0_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:925:4: (lv_name_0_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:925:4: (lv_name_0_0= RULE_STRING )
                    // InternalWorkflowDSL.g:926:5: lv_name_0_0= RULE_STRING
                    {
                    lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_name_0_0, grammarAccess.getContractNameAccess().getNameSTRINGTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContractNameRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_0_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:943:3: ( (lv_name_1_0= RULE_ID ) )
                    {
                    // InternalWorkflowDSL.g:943:3: ( (lv_name_1_0= RULE_ID ) )
                    // InternalWorkflowDSL.g:944:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalWorkflowDSL.g:944:4: (lv_name_1_0= RULE_ID )
                    // InternalWorkflowDSL.g:945:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getContractNameAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContractNameRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


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
    // $ANTLR end "ruleContractName"


    // $ANTLR start "entryRuleContractBody"
    // InternalWorkflowDSL.g:965:1: entryRuleContractBody returns [EObject current=null] : iv_ruleContractBody= ruleContractBody EOF ;
    public final EObject entryRuleContractBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractBody = null;


        try {
            // InternalWorkflowDSL.g:965:53: (iv_ruleContractBody= ruleContractBody EOF )
            // InternalWorkflowDSL.g:966:2: iv_ruleContractBody= ruleContractBody EOF
            {
             newCompositeNode(grammarAccess.getContractBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractBody=ruleContractBody();

            state._fsp--;

             current =iv_ruleContractBody; 
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
    // $ANTLR end "entryRuleContractBody"


    // $ANTLR start "ruleContractBody"
    // InternalWorkflowDSL.g:972:1: ruleContractBody returns [EObject current=null] : ( (lv_type_0_0= ruleContractType ) ) ;
    public final EObject ruleContractBody() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:978:2: ( ( (lv_type_0_0= ruleContractType ) ) )
            // InternalWorkflowDSL.g:979:2: ( (lv_type_0_0= ruleContractType ) )
            {
            // InternalWorkflowDSL.g:979:2: ( (lv_type_0_0= ruleContractType ) )
            // InternalWorkflowDSL.g:980:3: (lv_type_0_0= ruleContractType )
            {
            // InternalWorkflowDSL.g:980:3: (lv_type_0_0= ruleContractType )
            // InternalWorkflowDSL.g:981:4: lv_type_0_0= ruleContractType
            {

            				newCompositeNode(grammarAccess.getContractBodyAccess().getTypeContractTypeParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleContractType();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getContractBodyRule());
            				}
            				set(
            					current,
            					"type",
            					lv_type_0_0,
            					"xtext.json.WorkflowDSL.ContractType");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleContractBody"


    // $ANTLR start "entryRuleContractType"
    // InternalWorkflowDSL.g:1001:1: entryRuleContractType returns [EObject current=null] : iv_ruleContractType= ruleContractType EOF ;
    public final EObject entryRuleContractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractType = null;


        try {
            // InternalWorkflowDSL.g:1001:53: (iv_ruleContractType= ruleContractType EOF )
            // InternalWorkflowDSL.g:1002:2: iv_ruleContractType= ruleContractType EOF
            {
             newCompositeNode(grammarAccess.getContractTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractType=ruleContractType();

            state._fsp--;

             current =iv_ruleContractType; 
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
    // $ANTLR end "entryRuleContractType"


    // $ANTLR start "ruleContractType"
    // InternalWorkflowDSL.g:1008:1: ruleContractType returns [EObject current=null] : (this_ValueRangeContract_0= ruleValueRangeContract | this_ConditionContract_1= ruleConditionContract | this_SpecialValueContract_2= ruleSpecialValueContract | this_CastTypeContract_3= ruleCastTypeContract ) ;
    public final EObject ruleContractType() throws RecognitionException {
        EObject current = null;

        EObject this_ValueRangeContract_0 = null;

        EObject this_ConditionContract_1 = null;

        EObject this_SpecialValueContract_2 = null;

        EObject this_CastTypeContract_3 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1014:2: ( (this_ValueRangeContract_0= ruleValueRangeContract | this_ConditionContract_1= ruleConditionContract | this_SpecialValueContract_2= ruleSpecialValueContract | this_CastTypeContract_3= ruleCastTypeContract ) )
            // InternalWorkflowDSL.g:1015:2: (this_ValueRangeContract_0= ruleValueRangeContract | this_ConditionContract_1= ruleConditionContract | this_SpecialValueContract_2= ruleSpecialValueContract | this_CastTypeContract_3= ruleCastTypeContract )
            {
            // InternalWorkflowDSL.g:1015:2: (this_ValueRangeContract_0= ruleValueRangeContract | this_ConditionContract_1= ruleConditionContract | this_SpecialValueContract_2= ruleSpecialValueContract | this_CastTypeContract_3= ruleCastTypeContract )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt10=1;
                }
                break;
            case 41:
                {
                alt10=2;
                }
                break;
            case 49:
            case 50:
                {
                alt10=3;
                }
                break;
            case 34:
            case 51:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalWorkflowDSL.g:1016:3: this_ValueRangeContract_0= ruleValueRangeContract
                    {

                    			newCompositeNode(grammarAccess.getContractTypeAccess().getValueRangeContractParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValueRangeContract_0=ruleValueRangeContract();

                    state._fsp--;


                    			current = this_ValueRangeContract_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1025:3: this_ConditionContract_1= ruleConditionContract
                    {

                    			newCompositeNode(grammarAccess.getContractTypeAccess().getConditionContractParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConditionContract_1=ruleConditionContract();

                    state._fsp--;


                    			current = this_ConditionContract_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:1034:3: this_SpecialValueContract_2= ruleSpecialValueContract
                    {

                    			newCompositeNode(grammarAccess.getContractTypeAccess().getSpecialValueContractParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecialValueContract_2=ruleSpecialValueContract();

                    state._fsp--;


                    			current = this_SpecialValueContract_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:1043:3: this_CastTypeContract_3= ruleCastTypeContract
                    {

                    			newCompositeNode(grammarAccess.getContractTypeAccess().getCastTypeContractParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_CastTypeContract_3=ruleCastTypeContract();

                    state._fsp--;


                    			current = this_CastTypeContract_3;
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
    // $ANTLR end "ruleContractType"


    // $ANTLR start "entryRuleValueRangeContract"
    // InternalWorkflowDSL.g:1055:1: entryRuleValueRangeContract returns [EObject current=null] : iv_ruleValueRangeContract= ruleValueRangeContract EOF ;
    public final EObject entryRuleValueRangeContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRangeContract = null;


        try {
            // InternalWorkflowDSL.g:1055:59: (iv_ruleValueRangeContract= ruleValueRangeContract EOF )
            // InternalWorkflowDSL.g:1056:2: iv_ruleValueRangeContract= ruleValueRangeContract EOF
            {
             newCompositeNode(grammarAccess.getValueRangeContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueRangeContract=ruleValueRangeContract();

            state._fsp--;

             current =iv_ruleValueRangeContract; 
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
    // $ANTLR end "entryRuleValueRangeContract"


    // $ANTLR start "ruleValueRangeContract"
    // InternalWorkflowDSL.g:1062:1: ruleValueRangeContract returns [EObject current=null] : (otherlv_0= 'value_range' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ',' ( (lv_value_4_0= ruleContractValue ) ) otherlv_5= ')' ) ;
    public final EObject ruleValueRangeContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_field_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1068:2: ( (otherlv_0= 'value_range' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ',' ( (lv_value_4_0= ruleContractValue ) ) otherlv_5= ')' ) )
            // InternalWorkflowDSL.g:1069:2: (otherlv_0= 'value_range' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ',' ( (lv_value_4_0= ruleContractValue ) ) otherlv_5= ')' )
            {
            // InternalWorkflowDSL.g:1069:2: (otherlv_0= 'value_range' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ',' ( (lv_value_4_0= ruleContractValue ) ) otherlv_5= ')' )
            // InternalWorkflowDSL.g:1070:3: otherlv_0= 'value_range' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ',' ( (lv_value_4_0= ruleContractValue ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getValueRangeContractAccess().getValue_rangeKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getValueRangeContractAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:1078:3: ( (lv_field_2_0= ruleContractField ) )
            // InternalWorkflowDSL.g:1079:4: (lv_field_2_0= ruleContractField )
            {
            // InternalWorkflowDSL.g:1079:4: (lv_field_2_0= ruleContractField )
            // InternalWorkflowDSL.g:1080:5: lv_field_2_0= ruleContractField
            {

            					newCompositeNode(grammarAccess.getValueRangeContractAccess().getFieldContractFieldParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_field_2_0=ruleContractField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValueRangeContractRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_2_0,
            						"xtext.json.WorkflowDSL.ContractField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_24); 

            			newLeafNode(otherlv_3, grammarAccess.getValueRangeContractAccess().getCommaKeyword_3());
            		
            // InternalWorkflowDSL.g:1101:3: ( (lv_value_4_0= ruleContractValue ) )
            // InternalWorkflowDSL.g:1102:4: (lv_value_4_0= ruleContractValue )
            {
            // InternalWorkflowDSL.g:1102:4: (lv_value_4_0= ruleContractValue )
            // InternalWorkflowDSL.g:1103:5: lv_value_4_0= ruleContractValue
            {

            					newCompositeNode(grammarAccess.getValueRangeContractAccess().getValueContractValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_14);
            lv_value_4_0=ruleContractValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValueRangeContractRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"xtext.json.WorkflowDSL.ContractValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getValueRangeContractAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleValueRangeContract"


    // $ANTLR start "entryRuleContractField"
    // InternalWorkflowDSL.g:1128:1: entryRuleContractField returns [EObject current=null] : iv_ruleContractField= ruleContractField EOF ;
    public final EObject entryRuleContractField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractField = null;


        try {
            // InternalWorkflowDSL.g:1128:54: (iv_ruleContractField= ruleContractField EOF )
            // InternalWorkflowDSL.g:1129:2: iv_ruleContractField= ruleContractField EOF
            {
             newCompositeNode(grammarAccess.getContractFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractField=ruleContractField();

            state._fsp--;

             current =iv_ruleContractField; 
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
    // $ANTLR end "entryRuleContractField"


    // $ANTLR start "ruleContractField"
    // InternalWorkflowDSL.g:1135:1: ruleContractField returns [EObject current=null] : ( (otherlv_0= 'input' otherlv_1= '.' ( (lv_column_2_0= ruleColumn ) ) ) | (otherlv_3= 'output' otherlv_4= '.' ( (lv_column_5_0= ruleColumn ) ) ) ) ;
    public final EObject ruleContractField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_column_2_0 = null;

        EObject lv_column_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1141:2: ( ( (otherlv_0= 'input' otherlv_1= '.' ( (lv_column_2_0= ruleColumn ) ) ) | (otherlv_3= 'output' otherlv_4= '.' ( (lv_column_5_0= ruleColumn ) ) ) ) )
            // InternalWorkflowDSL.g:1142:2: ( (otherlv_0= 'input' otherlv_1= '.' ( (lv_column_2_0= ruleColumn ) ) ) | (otherlv_3= 'output' otherlv_4= '.' ( (lv_column_5_0= ruleColumn ) ) ) )
            {
            // InternalWorkflowDSL.g:1142:2: ( (otherlv_0= 'input' otherlv_1= '.' ( (lv_column_2_0= ruleColumn ) ) ) | (otherlv_3= 'output' otherlv_4= '.' ( (lv_column_5_0= ruleColumn ) ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            else if ( (LA11_0==33) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalWorkflowDSL.g:1143:3: (otherlv_0= 'input' otherlv_1= '.' ( (lv_column_2_0= ruleColumn ) ) )
                    {
                    // InternalWorkflowDSL.g:1143:3: (otherlv_0= 'input' otherlv_1= '.' ( (lv_column_2_0= ruleColumn ) ) )
                    // InternalWorkflowDSL.g:1144:4: otherlv_0= 'input' otherlv_1= '.' ( (lv_column_2_0= ruleColumn ) )
                    {
                    otherlv_0=(Token)match(input,31,FOLLOW_25); 

                    				newLeafNode(otherlv_0, grammarAccess.getContractFieldAccess().getInputKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,32,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getContractFieldAccess().getFullStopKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:1152:4: ( (lv_column_2_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:1153:5: (lv_column_2_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:1153:5: (lv_column_2_0= ruleColumn )
                    // InternalWorkflowDSL.g:1154:6: lv_column_2_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getContractFieldAccess().getColumnColumnParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_column_2_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractFieldRule());
                    						}
                    						set(
                    							current,
                    							"column",
                    							lv_column_2_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1173:3: (otherlv_3= 'output' otherlv_4= '.' ( (lv_column_5_0= ruleColumn ) ) )
                    {
                    // InternalWorkflowDSL.g:1173:3: (otherlv_3= 'output' otherlv_4= '.' ( (lv_column_5_0= ruleColumn ) ) )
                    // InternalWorkflowDSL.g:1174:4: otherlv_3= 'output' otherlv_4= '.' ( (lv_column_5_0= ruleColumn ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_25); 

                    				newLeafNode(otherlv_3, grammarAccess.getContractFieldAccess().getOutputKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,32,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getContractFieldAccess().getFullStopKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:1182:4: ( (lv_column_5_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:1183:5: (lv_column_5_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:1183:5: (lv_column_5_0= ruleColumn )
                    // InternalWorkflowDSL.g:1184:6: lv_column_5_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getContractFieldAccess().getColumnColumnParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_column_5_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractFieldRule());
                    						}
                    						set(
                    							current,
                    							"column",
                    							lv_column_5_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleContractField"


    // $ANTLR start "entryRuleContractValue"
    // InternalWorkflowDSL.g:1206:1: entryRuleContractValue returns [EObject current=null] : iv_ruleContractValue= ruleContractValue EOF ;
    public final EObject entryRuleContractValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractValue = null;


        try {
            // InternalWorkflowDSL.g:1206:54: (iv_ruleContractValue= ruleContractValue EOF )
            // InternalWorkflowDSL.g:1207:2: iv_ruleContractValue= ruleContractValue EOF
            {
             newCompositeNode(grammarAccess.getContractValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractValue=ruleContractValue();

            state._fsp--;

             current =iv_ruleContractValue; 
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
    // $ANTLR end "entryRuleContractValue"


    // $ANTLR start "ruleContractValue"
    // InternalWorkflowDSL.g:1213:1: ruleContractValue returns [EObject current=null] : ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) ) | (otherlv_2= 'in_range' ( (lv_bounds_3_0= ruleRangeBounds ) ) ) | (otherlv_4= 'matches' ( (lv_value_5_0= ruleValue ) ) ) ) ;
    public final EObject ruleContractValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_bounds_3_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1219:2: ( ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) ) | (otherlv_2= 'in_range' ( (lv_bounds_3_0= ruleRangeBounds ) ) ) | (otherlv_4= 'matches' ( (lv_value_5_0= ruleValue ) ) ) ) )
            // InternalWorkflowDSL.g:1220:2: ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) ) | (otherlv_2= 'in_range' ( (lv_bounds_3_0= ruleRangeBounds ) ) ) | (otherlv_4= 'matches' ( (lv_value_5_0= ruleValue ) ) ) )
            {
            // InternalWorkflowDSL.g:1220:2: ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) ) | (otherlv_2= 'in_range' ( (lv_bounds_3_0= ruleRangeBounds ) ) ) | (otherlv_4= 'matches' ( (lv_value_5_0= ruleValue ) ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt12=1;
                }
                break;
            case 35:
                {
                alt12=2;
                }
                break;
            case 36:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalWorkflowDSL.g:1221:3: (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) )
                    {
                    // InternalWorkflowDSL.g:1221:3: (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) )
                    // InternalWorkflowDSL.g:1222:4: otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) )
                    {
                    otherlv_0=(Token)match(input,34,FOLLOW_26); 

                    				newLeafNode(otherlv_0, grammarAccess.getContractValueAccess().getCastable_toKeyword_0_0());
                    			
                    // InternalWorkflowDSL.g:1226:4: ( (lv_type_1_0= ruleType ) )
                    // InternalWorkflowDSL.g:1227:5: (lv_type_1_0= ruleType )
                    {
                    // InternalWorkflowDSL.g:1227:5: (lv_type_1_0= ruleType )
                    // InternalWorkflowDSL.g:1228:6: lv_type_1_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getContractValueAccess().getTypeTypeParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_type_1_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractValueRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_1_0,
                    							"xtext.json.WorkflowDSL.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1247:3: (otherlv_2= 'in_range' ( (lv_bounds_3_0= ruleRangeBounds ) ) )
                    {
                    // InternalWorkflowDSL.g:1247:3: (otherlv_2= 'in_range' ( (lv_bounds_3_0= ruleRangeBounds ) ) )
                    // InternalWorkflowDSL.g:1248:4: otherlv_2= 'in_range' ( (lv_bounds_3_0= ruleRangeBounds ) )
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_27); 

                    				newLeafNode(otherlv_2, grammarAccess.getContractValueAccess().getIn_rangeKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:1252:4: ( (lv_bounds_3_0= ruleRangeBounds ) )
                    // InternalWorkflowDSL.g:1253:5: (lv_bounds_3_0= ruleRangeBounds )
                    {
                    // InternalWorkflowDSL.g:1253:5: (lv_bounds_3_0= ruleRangeBounds )
                    // InternalWorkflowDSL.g:1254:6: lv_bounds_3_0= ruleRangeBounds
                    {

                    						newCompositeNode(grammarAccess.getContractValueAccess().getBoundsRangeBoundsParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_bounds_3_0=ruleRangeBounds();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractValueRule());
                    						}
                    						set(
                    							current,
                    							"bounds",
                    							lv_bounds_3_0,
                    							"xtext.json.WorkflowDSL.RangeBounds");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:1273:3: (otherlv_4= 'matches' ( (lv_value_5_0= ruleValue ) ) )
                    {
                    // InternalWorkflowDSL.g:1273:3: (otherlv_4= 'matches' ( (lv_value_5_0= ruleValue ) ) )
                    // InternalWorkflowDSL.g:1274:4: otherlv_4= 'matches' ( (lv_value_5_0= ruleValue ) )
                    {
                    otherlv_4=(Token)match(input,36,FOLLOW_28); 

                    				newLeafNode(otherlv_4, grammarAccess.getContractValueAccess().getMatchesKeyword_2_0());
                    			
                    // InternalWorkflowDSL.g:1278:4: ( (lv_value_5_0= ruleValue ) )
                    // InternalWorkflowDSL.g:1279:5: (lv_value_5_0= ruleValue )
                    {
                    // InternalWorkflowDSL.g:1279:5: (lv_value_5_0= ruleValue )
                    // InternalWorkflowDSL.g:1280:6: lv_value_5_0= ruleValue
                    {

                    						newCompositeNode(grammarAccess.getContractValueAccess().getValueValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContractValueRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"xtext.json.WorkflowDSL.Value");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleContractValue"


    // $ANTLR start "entryRuleType"
    // InternalWorkflowDSL.g:1302:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalWorkflowDSL.g:1302:44: (iv_ruleType= ruleType EOF )
            // InternalWorkflowDSL.g:1303:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType.getText(); 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalWorkflowDSL.g:1309:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Integer' | kw= 'Double' | kw= 'String' | kw= 'Boolean' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:1315:2: ( (kw= 'Integer' | kw= 'Double' | kw= 'String' | kw= 'Boolean' ) )
            // InternalWorkflowDSL.g:1316:2: (kw= 'Integer' | kw= 'Double' | kw= 'String' | kw= 'Boolean' )
            {
            // InternalWorkflowDSL.g:1316:2: (kw= 'Integer' | kw= 'Double' | kw= 'String' | kw= 'Boolean' )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt13=1;
                }
                break;
            case 38:
                {
                alt13=2;
                }
                break;
            case 39:
                {
                alt13=3;
                }
                break;
            case 40:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalWorkflowDSL.g:1317:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1323:3: kw= 'Double'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDoubleKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:1329:3: kw= 'String'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:1335:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBooleanKeyword_3());
                    		

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleConditionContract"
    // InternalWorkflowDSL.g:1344:1: entryRuleConditionContract returns [EObject current=null] : iv_ruleConditionContract= ruleConditionContract EOF ;
    public final EObject entryRuleConditionContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionContract = null;


        try {
            // InternalWorkflowDSL.g:1344:58: (iv_ruleConditionContract= ruleConditionContract EOF )
            // InternalWorkflowDSL.g:1345:2: iv_ruleConditionContract= ruleConditionContract EOF
            {
             newCompositeNode(grammarAccess.getConditionContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionContract=ruleConditionContract();

            state._fsp--;

             current =iv_ruleConditionContract; 
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
    // $ANTLR end "entryRuleConditionContract"


    // $ANTLR start "ruleConditionContract"
    // InternalWorkflowDSL.g:1351:1: ruleConditionContract returns [EObject current=null] : (otherlv_0= 'condition' otherlv_1= '{' ( (lv_ifClause_2_0= ruleIfClause ) ) ( (lv_thenClause_3_0= ruleThenClause ) ) otherlv_4= '}' ) ;
    public final EObject ruleConditionContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_ifClause_2_0 = null;

        EObject lv_thenClause_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1357:2: ( (otherlv_0= 'condition' otherlv_1= '{' ( (lv_ifClause_2_0= ruleIfClause ) ) ( (lv_thenClause_3_0= ruleThenClause ) ) otherlv_4= '}' ) )
            // InternalWorkflowDSL.g:1358:2: (otherlv_0= 'condition' otherlv_1= '{' ( (lv_ifClause_2_0= ruleIfClause ) ) ( (lv_thenClause_3_0= ruleThenClause ) ) otherlv_4= '}' )
            {
            // InternalWorkflowDSL.g:1358:2: (otherlv_0= 'condition' otherlv_1= '{' ( (lv_ifClause_2_0= ruleIfClause ) ) ( (lv_thenClause_3_0= ruleThenClause ) ) otherlv_4= '}' )
            // InternalWorkflowDSL.g:1359:3: otherlv_0= 'condition' otherlv_1= '{' ( (lv_ifClause_2_0= ruleIfClause ) ) ( (lv_thenClause_3_0= ruleThenClause ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionContractAccess().getConditionKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionContractAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalWorkflowDSL.g:1367:3: ( (lv_ifClause_2_0= ruleIfClause ) )
            // InternalWorkflowDSL.g:1368:4: (lv_ifClause_2_0= ruleIfClause )
            {
            // InternalWorkflowDSL.g:1368:4: (lv_ifClause_2_0= ruleIfClause )
            // InternalWorkflowDSL.g:1369:5: lv_ifClause_2_0= ruleIfClause
            {

            					newCompositeNode(grammarAccess.getConditionContractAccess().getIfClauseIfClauseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
            lv_ifClause_2_0=ruleIfClause();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionContractRule());
            					}
            					set(
            						current,
            						"ifClause",
            						lv_ifClause_2_0,
            						"xtext.json.WorkflowDSL.IfClause");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:1386:3: ( (lv_thenClause_3_0= ruleThenClause ) )
            // InternalWorkflowDSL.g:1387:4: (lv_thenClause_3_0= ruleThenClause )
            {
            // InternalWorkflowDSL.g:1387:4: (lv_thenClause_3_0= ruleThenClause )
            // InternalWorkflowDSL.g:1388:5: lv_thenClause_3_0= ruleThenClause
            {

            					newCompositeNode(grammarAccess.getConditionContractAccess().getThenClauseThenClauseParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_thenClause_3_0=ruleThenClause();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionContractRule());
            					}
            					set(
            						current,
            						"thenClause",
            						lv_thenClause_3_0,
            						"xtext.json.WorkflowDSL.ThenClause");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getConditionContractAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleConditionContract"


    // $ANTLR start "entryRuleIfClause"
    // InternalWorkflowDSL.g:1413:1: entryRuleIfClause returns [EObject current=null] : iv_ruleIfClause= ruleIfClause EOF ;
    public final EObject entryRuleIfClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfClause = null;


        try {
            // InternalWorkflowDSL.g:1413:49: (iv_ruleIfClause= ruleIfClause EOF )
            // InternalWorkflowDSL.g:1414:2: iv_ruleIfClause= ruleIfClause EOF
            {
             newCompositeNode(grammarAccess.getIfClauseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfClause=ruleIfClause();

            state._fsp--;

             current =iv_ruleIfClause; 
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
    // $ANTLR end "entryRuleIfClause"


    // $ANTLR start "ruleIfClause"
    // InternalWorkflowDSL.g:1420:1: ruleIfClause returns [EObject current=null] : (otherlv_0= 'if' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_condition_3_0= ruleDataCondition ) ) ) ;
    public final EObject ruleIfClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_field_1_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1426:2: ( (otherlv_0= 'if' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_condition_3_0= ruleDataCondition ) ) ) )
            // InternalWorkflowDSL.g:1427:2: (otherlv_0= 'if' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_condition_3_0= ruleDataCondition ) ) )
            {
            // InternalWorkflowDSL.g:1427:2: (otherlv_0= 'if' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_condition_3_0= ruleDataCondition ) ) )
            // InternalWorkflowDSL.g:1428:3: otherlv_0= 'if' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_condition_3_0= ruleDataCondition ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getIfClauseAccess().getIfKeyword_0());
            		
            // InternalWorkflowDSL.g:1432:3: ( (lv_field_1_0= ruleContractField ) )
            // InternalWorkflowDSL.g:1433:4: (lv_field_1_0= ruleContractField )
            {
            // InternalWorkflowDSL.g:1433:4: (lv_field_1_0= ruleContractField )
            // InternalWorkflowDSL.g:1434:5: lv_field_1_0= ruleContractField
            {

            					newCompositeNode(grammarAccess.getIfClauseAccess().getFieldContractFieldParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_31);
            lv_field_1_0=ruleContractField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfClauseRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_1_0,
            						"xtext.json.WorkflowDSL.ContractField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:1451:3: ( (lv_op_2_0= ruleBelongOp ) )
            // InternalWorkflowDSL.g:1452:4: (lv_op_2_0= ruleBelongOp )
            {
            // InternalWorkflowDSL.g:1452:4: (lv_op_2_0= ruleBelongOp )
            // InternalWorkflowDSL.g:1453:5: lv_op_2_0= ruleBelongOp
            {

            					newCompositeNode(grammarAccess.getIfClauseAccess().getOpBelongOpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_32);
            lv_op_2_0=ruleBelongOp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfClauseRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_2_0,
            						"xtext.json.WorkflowDSL.BelongOp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:1470:3: ( (lv_condition_3_0= ruleDataCondition ) )
            // InternalWorkflowDSL.g:1471:4: (lv_condition_3_0= ruleDataCondition )
            {
            // InternalWorkflowDSL.g:1471:4: (lv_condition_3_0= ruleDataCondition )
            // InternalWorkflowDSL.g:1472:5: lv_condition_3_0= ruleDataCondition
            {

            					newCompositeNode(grammarAccess.getIfClauseAccess().getConditionDataConditionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_condition_3_0=ruleDataCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfClauseRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_3_0,
            						"xtext.json.WorkflowDSL.DataCondition");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleIfClause"


    // $ANTLR start "entryRuleThenClause"
    // InternalWorkflowDSL.g:1493:1: entryRuleThenClause returns [EObject current=null] : iv_ruleThenClause= ruleThenClause EOF ;
    public final EObject entryRuleThenClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThenClause = null;


        try {
            // InternalWorkflowDSL.g:1493:51: (iv_ruleThenClause= ruleThenClause EOF )
            // InternalWorkflowDSL.g:1494:2: iv_ruleThenClause= ruleThenClause EOF
            {
             newCompositeNode(grammarAccess.getThenClauseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThenClause=ruleThenClause();

            state._fsp--;

             current =iv_ruleThenClause; 
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
    // $ANTLR end "entryRuleThenClause"


    // $ANTLR start "ruleThenClause"
    // InternalWorkflowDSL.g:1500:1: ruleThenClause returns [EObject current=null] : (otherlv_0= 'then' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_result_3_0= ruleDataResult ) ) ) ;
    public final EObject ruleThenClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_field_1_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_result_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1506:2: ( (otherlv_0= 'then' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_result_3_0= ruleDataResult ) ) ) )
            // InternalWorkflowDSL.g:1507:2: (otherlv_0= 'then' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_result_3_0= ruleDataResult ) ) )
            {
            // InternalWorkflowDSL.g:1507:2: (otherlv_0= 'then' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_result_3_0= ruleDataResult ) ) )
            // InternalWorkflowDSL.g:1508:3: otherlv_0= 'then' ( (lv_field_1_0= ruleContractField ) ) ( (lv_op_2_0= ruleBelongOp ) ) ( (lv_result_3_0= ruleDataResult ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getThenClauseAccess().getThenKeyword_0());
            		
            // InternalWorkflowDSL.g:1512:3: ( (lv_field_1_0= ruleContractField ) )
            // InternalWorkflowDSL.g:1513:4: (lv_field_1_0= ruleContractField )
            {
            // InternalWorkflowDSL.g:1513:4: (lv_field_1_0= ruleContractField )
            // InternalWorkflowDSL.g:1514:5: lv_field_1_0= ruleContractField
            {

            					newCompositeNode(grammarAccess.getThenClauseAccess().getFieldContractFieldParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_31);
            lv_field_1_0=ruleContractField();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getThenClauseRule());
            					}
            					set(
            						current,
            						"field",
            						lv_field_1_0,
            						"xtext.json.WorkflowDSL.ContractField");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:1531:3: ( (lv_op_2_0= ruleBelongOp ) )
            // InternalWorkflowDSL.g:1532:4: (lv_op_2_0= ruleBelongOp )
            {
            // InternalWorkflowDSL.g:1532:4: (lv_op_2_0= ruleBelongOp )
            // InternalWorkflowDSL.g:1533:5: lv_op_2_0= ruleBelongOp
            {

            					newCompositeNode(grammarAccess.getThenClauseAccess().getOpBelongOpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_32);
            lv_op_2_0=ruleBelongOp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getThenClauseRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_2_0,
            						"xtext.json.WorkflowDSL.BelongOp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:1550:3: ( (lv_result_3_0= ruleDataResult ) )
            // InternalWorkflowDSL.g:1551:4: (lv_result_3_0= ruleDataResult )
            {
            // InternalWorkflowDSL.g:1551:4: (lv_result_3_0= ruleDataResult )
            // InternalWorkflowDSL.g:1552:5: lv_result_3_0= ruleDataResult
            {

            					newCompositeNode(grammarAccess.getThenClauseAccess().getResultDataResultParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_result_3_0=ruleDataResult();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getThenClauseRule());
            					}
            					set(
            						current,
            						"result",
            						lv_result_3_0,
            						"xtext.json.WorkflowDSL.DataResult");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleThenClause"


    // $ANTLR start "entryRuleBelongOp"
    // InternalWorkflowDSL.g:1573:1: entryRuleBelongOp returns [String current=null] : iv_ruleBelongOp= ruleBelongOp EOF ;
    public final String entryRuleBelongOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBelongOp = null;


        try {
            // InternalWorkflowDSL.g:1573:48: (iv_ruleBelongOp= ruleBelongOp EOF )
            // InternalWorkflowDSL.g:1574:2: iv_ruleBelongOp= ruleBelongOp EOF
            {
             newCompositeNode(grammarAccess.getBelongOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBelongOp=ruleBelongOp();

            state._fsp--;

             current =iv_ruleBelongOp.getText(); 
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
    // $ANTLR end "entryRuleBelongOp"


    // $ANTLR start "ruleBelongOp"
    // InternalWorkflowDSL.g:1580:1: ruleBelongOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'belongs_to' | kw= 'not_belongs_to' ) ;
    public final AntlrDatatypeRuleToken ruleBelongOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:1586:2: ( (kw= 'belongs_to' | kw= 'not_belongs_to' ) )
            // InternalWorkflowDSL.g:1587:2: (kw= 'belongs_to' | kw= 'not_belongs_to' )
            {
            // InternalWorkflowDSL.g:1587:2: (kw= 'belongs_to' | kw= 'not_belongs_to' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==44) ) {
                alt14=1;
            }
            else if ( (LA14_0==45) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalWorkflowDSL.g:1588:3: kw= 'belongs_to'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBelongOpAccess().getBelongs_toKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1594:3: kw= 'not_belongs_to'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBelongOpAccess().getNot_belongs_toKeyword_1());
                    		

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
    // $ANTLR end "ruleBelongOp"


    // $ANTLR start "entryRuleDataCondition"
    // InternalWorkflowDSL.g:1603:1: entryRuleDataCondition returns [EObject current=null] : iv_ruleDataCondition= ruleDataCondition EOF ;
    public final EObject entryRuleDataCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataCondition = null;


        try {
            // InternalWorkflowDSL.g:1603:54: (iv_ruleDataCondition= ruleDataCondition EOF )
            // InternalWorkflowDSL.g:1604:2: iv_ruleDataCondition= ruleDataCondition EOF
            {
             newCompositeNode(grammarAccess.getDataConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataCondition=ruleDataCondition();

            state._fsp--;

             current =iv_ruleDataCondition; 
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
    // $ANTLR end "entryRuleDataCondition"


    // $ANTLR start "ruleDataCondition"
    // InternalWorkflowDSL.g:1610:1: ruleDataCondition returns [EObject current=null] : ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck ) ;
    public final EObject ruleDataCondition() throws RecognitionException {
        EObject current = null;

        EObject this_CastTypeCheck_1 = null;

        EObject this_ValueCheck_2 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1616:2: ( ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck ) )
            // InternalWorkflowDSL.g:1617:2: ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck )
            {
            // InternalWorkflowDSL.g:1617:2: ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt15=1;
                }
                break;
            case 47:
                {
                alt15=2;
                }
                break;
            case 48:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalWorkflowDSL.g:1618:3: ruleSpecialValueCheck
                    {

                    			newCompositeNode(grammarAccess.getDataConditionAccess().getSpecialValueCheckParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    ruleSpecialValueCheck();

                    state._fsp--;


                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1626:3: this_CastTypeCheck_1= ruleCastTypeCheck
                    {

                    			newCompositeNode(grammarAccess.getDataConditionAccess().getCastTypeCheckParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CastTypeCheck_1=ruleCastTypeCheck();

                    state._fsp--;


                    			current = this_CastTypeCheck_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:1635:3: this_ValueCheck_2= ruleValueCheck
                    {

                    			newCompositeNode(grammarAccess.getDataConditionAccess().getValueCheckParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValueCheck_2=ruleValueCheck();

                    state._fsp--;


                    			current = this_ValueCheck_2;
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
    // $ANTLR end "ruleDataCondition"


    // $ANTLR start "entryRuleSpecialValueCheck"
    // InternalWorkflowDSL.g:1647:1: entryRuleSpecialValueCheck returns [String current=null] : iv_ruleSpecialValueCheck= ruleSpecialValueCheck EOF ;
    public final String entryRuleSpecialValueCheck() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialValueCheck = null;


        try {
            // InternalWorkflowDSL.g:1647:57: (iv_ruleSpecialValueCheck= ruleSpecialValueCheck EOF )
            // InternalWorkflowDSL.g:1648:2: iv_ruleSpecialValueCheck= ruleSpecialValueCheck EOF
            {
             newCompositeNode(grammarAccess.getSpecialValueCheckRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecialValueCheck=ruleSpecialValueCheck();

            state._fsp--;

             current =iv_ruleSpecialValueCheck.getText(); 
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
    // $ANTLR end "entryRuleSpecialValueCheck"


    // $ANTLR start "ruleSpecialValueCheck"
    // InternalWorkflowDSL.g:1654:1: ruleSpecialValueCheck returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'special_values' ;
    public final AntlrDatatypeRuleToken ruleSpecialValueCheck() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:1660:2: (kw= 'special_values' )
            // InternalWorkflowDSL.g:1661:2: kw= 'special_values'
            {
            kw=(Token)match(input,46,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getSpecialValueCheckAccess().getSpecial_valuesKeyword());
            	

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
    // $ANTLR end "ruleSpecialValueCheck"


    // $ANTLR start "entryRuleCastTypeCheck"
    // InternalWorkflowDSL.g:1669:1: entryRuleCastTypeCheck returns [EObject current=null] : iv_ruleCastTypeCheck= ruleCastTypeCheck EOF ;
    public final EObject entryRuleCastTypeCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastTypeCheck = null;


        try {
            // InternalWorkflowDSL.g:1669:54: (iv_ruleCastTypeCheck= ruleCastTypeCheck EOF )
            // InternalWorkflowDSL.g:1670:2: iv_ruleCastTypeCheck= ruleCastTypeCheck EOF
            {
             newCompositeNode(grammarAccess.getCastTypeCheckRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCastTypeCheck=ruleCastTypeCheck();

            state._fsp--;

             current =iv_ruleCastTypeCheck; 
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
    // $ANTLR end "entryRuleCastTypeCheck"


    // $ANTLR start "ruleCastTypeCheck"
    // InternalWorkflowDSL.g:1676:1: ruleCastTypeCheck returns [EObject current=null] : (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) ) ;
    public final EObject ruleCastTypeCheck() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1682:2: ( (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) ) )
            // InternalWorkflowDSL.g:1683:2: (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) )
            {
            // InternalWorkflowDSL.g:1683:2: (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) )
            // InternalWorkflowDSL.g:1684:3: otherlv_0= 'type' ( (lv_type_1_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getCastTypeCheckAccess().getTypeKeyword_0());
            		
            // InternalWorkflowDSL.g:1688:3: ( (lv_type_1_0= ruleType ) )
            // InternalWorkflowDSL.g:1689:4: (lv_type_1_0= ruleType )
            {
            // InternalWorkflowDSL.g:1689:4: (lv_type_1_0= ruleType )
            // InternalWorkflowDSL.g:1690:5: lv_type_1_0= ruleType
            {

            					newCompositeNode(grammarAccess.getCastTypeCheckAccess().getTypeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCastTypeCheckRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"xtext.json.WorkflowDSL.Type");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleCastTypeCheck"


    // $ANTLR start "entryRuleValueCheck"
    // InternalWorkflowDSL.g:1711:1: entryRuleValueCheck returns [EObject current=null] : iv_ruleValueCheck= ruleValueCheck EOF ;
    public final EObject entryRuleValueCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueCheck = null;


        try {
            // InternalWorkflowDSL.g:1711:51: (iv_ruleValueCheck= ruleValueCheck EOF )
            // InternalWorkflowDSL.g:1712:2: iv_ruleValueCheck= ruleValueCheck EOF
            {
             newCompositeNode(grammarAccess.getValueCheckRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueCheck=ruleValueCheck();

            state._fsp--;

             current =iv_ruleValueCheck; 
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
    // $ANTLR end "entryRuleValueCheck"


    // $ANTLR start "ruleValueCheck"
    // InternalWorkflowDSL.g:1718:1: ruleValueCheck returns [EObject current=null] : (otherlv_0= 'value' ( (lv_value_1_0= ruleValue ) ) ) ;
    public final EObject ruleValueCheck() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1724:2: ( (otherlv_0= 'value' ( (lv_value_1_0= ruleValue ) ) ) )
            // InternalWorkflowDSL.g:1725:2: (otherlv_0= 'value' ( (lv_value_1_0= ruleValue ) ) )
            {
            // InternalWorkflowDSL.g:1725:2: (otherlv_0= 'value' ( (lv_value_1_0= ruleValue ) ) )
            // InternalWorkflowDSL.g:1726:3: otherlv_0= 'value' ( (lv_value_1_0= ruleValue ) )
            {
            otherlv_0=(Token)match(input,48,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getValueCheckAccess().getValueKeyword_0());
            		
            // InternalWorkflowDSL.g:1730:3: ( (lv_value_1_0= ruleValue ) )
            // InternalWorkflowDSL.g:1731:4: (lv_value_1_0= ruleValue )
            {
            // InternalWorkflowDSL.g:1731:4: (lv_value_1_0= ruleValue )
            // InternalWorkflowDSL.g:1732:5: lv_value_1_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getValueCheckAccess().getValueValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValueCheckRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"xtext.json.WorkflowDSL.Value");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleValueCheck"


    // $ANTLR start "entryRuleDataResult"
    // InternalWorkflowDSL.g:1753:1: entryRuleDataResult returns [EObject current=null] : iv_ruleDataResult= ruleDataResult EOF ;
    public final EObject entryRuleDataResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataResult = null;


        try {
            // InternalWorkflowDSL.g:1753:51: (iv_ruleDataResult= ruleDataResult EOF )
            // InternalWorkflowDSL.g:1754:2: iv_ruleDataResult= ruleDataResult EOF
            {
             newCompositeNode(grammarAccess.getDataResultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataResult=ruleDataResult();

            state._fsp--;

             current =iv_ruleDataResult; 
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
    // $ANTLR end "entryRuleDataResult"


    // $ANTLR start "ruleDataResult"
    // InternalWorkflowDSL.g:1760:1: ruleDataResult returns [EObject current=null] : ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck ) ;
    public final EObject ruleDataResult() throws RecognitionException {
        EObject current = null;

        EObject this_CastTypeCheck_1 = null;

        EObject this_ValueCheck_2 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1766:2: ( ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck ) )
            // InternalWorkflowDSL.g:1767:2: ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck )
            {
            // InternalWorkflowDSL.g:1767:2: ( ruleSpecialValueCheck | this_CastTypeCheck_1= ruleCastTypeCheck | this_ValueCheck_2= ruleValueCheck )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt16=1;
                }
                break;
            case 47:
                {
                alt16=2;
                }
                break;
            case 48:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalWorkflowDSL.g:1768:3: ruleSpecialValueCheck
                    {

                    			newCompositeNode(grammarAccess.getDataResultAccess().getSpecialValueCheckParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    ruleSpecialValueCheck();

                    state._fsp--;


                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1776:3: this_CastTypeCheck_1= ruleCastTypeCheck
                    {

                    			newCompositeNode(grammarAccess.getDataResultAccess().getCastTypeCheckParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CastTypeCheck_1=ruleCastTypeCheck();

                    state._fsp--;


                    			current = this_CastTypeCheck_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:1785:3: this_ValueCheck_2= ruleValueCheck
                    {

                    			newCompositeNode(grammarAccess.getDataResultAccess().getValueCheckParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValueCheck_2=ruleValueCheck();

                    state._fsp--;


                    			current = this_ValueCheck_2;
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
    // $ANTLR end "ruleDataResult"


    // $ANTLR start "entryRuleSpecialValueContract"
    // InternalWorkflowDSL.g:1797:1: entryRuleSpecialValueContract returns [EObject current=null] : iv_ruleSpecialValueContract= ruleSpecialValueContract EOF ;
    public final EObject entryRuleSpecialValueContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecialValueContract = null;


        try {
            // InternalWorkflowDSL.g:1797:61: (iv_ruleSpecialValueContract= ruleSpecialValueContract EOF )
            // InternalWorkflowDSL.g:1798:2: iv_ruleSpecialValueContract= ruleSpecialValueContract EOF
            {
             newCompositeNode(grammarAccess.getSpecialValueContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecialValueContract=ruleSpecialValueContract();

            state._fsp--;

             current =iv_ruleSpecialValueContract; 
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
    // $ANTLR end "entryRuleSpecialValueContract"


    // $ANTLR start "ruleSpecialValueContract"
    // InternalWorkflowDSL.g:1804:1: ruleSpecialValueContract returns [EObject current=null] : ( (otherlv_0= 'no_special_values' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ')' ) | (otherlv_4= 'has_special_values' otherlv_5= '(' ( (lv_field_6_0= ruleContractField ) ) otherlv_7= ')' ) ) ;
    public final EObject ruleSpecialValueContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_field_2_0 = null;

        EObject lv_field_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1810:2: ( ( (otherlv_0= 'no_special_values' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ')' ) | (otherlv_4= 'has_special_values' otherlv_5= '(' ( (lv_field_6_0= ruleContractField ) ) otherlv_7= ')' ) ) )
            // InternalWorkflowDSL.g:1811:2: ( (otherlv_0= 'no_special_values' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ')' ) | (otherlv_4= 'has_special_values' otherlv_5= '(' ( (lv_field_6_0= ruleContractField ) ) otherlv_7= ')' ) )
            {
            // InternalWorkflowDSL.g:1811:2: ( (otherlv_0= 'no_special_values' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ')' ) | (otherlv_4= 'has_special_values' otherlv_5= '(' ( (lv_field_6_0= ruleContractField ) ) otherlv_7= ')' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==49) ) {
                alt17=1;
            }
            else if ( (LA17_0==50) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalWorkflowDSL.g:1812:3: (otherlv_0= 'no_special_values' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ')' )
                    {
                    // InternalWorkflowDSL.g:1812:3: (otherlv_0= 'no_special_values' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ')' )
                    // InternalWorkflowDSL.g:1813:4: otherlv_0= 'no_special_values' otherlv_1= '(' ( (lv_field_2_0= ruleContractField ) ) otherlv_3= ')'
                    {
                    otherlv_0=(Token)match(input,49,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getSpecialValueContractAccess().getNo_special_valuesKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,18,FOLLOW_22); 

                    				newLeafNode(otherlv_1, grammarAccess.getSpecialValueContractAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:1821:4: ( (lv_field_2_0= ruleContractField ) )
                    // InternalWorkflowDSL.g:1822:5: (lv_field_2_0= ruleContractField )
                    {
                    // InternalWorkflowDSL.g:1822:5: (lv_field_2_0= ruleContractField )
                    // InternalWorkflowDSL.g:1823:6: lv_field_2_0= ruleContractField
                    {

                    						newCompositeNode(grammarAccess.getSpecialValueContractAccess().getFieldContractFieldParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_field_2_0=ruleContractField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSpecialValueContractRule());
                    						}
                    						set(
                    							current,
                    							"field",
                    							lv_field_2_0,
                    							"xtext.json.WorkflowDSL.ContractField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getSpecialValueContractAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1846:3: (otherlv_4= 'has_special_values' otherlv_5= '(' ( (lv_field_6_0= ruleContractField ) ) otherlv_7= ')' )
                    {
                    // InternalWorkflowDSL.g:1846:3: (otherlv_4= 'has_special_values' otherlv_5= '(' ( (lv_field_6_0= ruleContractField ) ) otherlv_7= ')' )
                    // InternalWorkflowDSL.g:1847:4: otherlv_4= 'has_special_values' otherlv_5= '(' ( (lv_field_6_0= ruleContractField ) ) otherlv_7= ')'
                    {
                    otherlv_4=(Token)match(input,50,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getSpecialValueContractAccess().getHas_special_valuesKeyword_1_0());
                    			
                    otherlv_5=(Token)match(input,18,FOLLOW_22); 

                    				newLeafNode(otherlv_5, grammarAccess.getSpecialValueContractAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:1855:4: ( (lv_field_6_0= ruleContractField ) )
                    // InternalWorkflowDSL.g:1856:5: (lv_field_6_0= ruleContractField )
                    {
                    // InternalWorkflowDSL.g:1856:5: (lv_field_6_0= ruleContractField )
                    // InternalWorkflowDSL.g:1857:6: lv_field_6_0= ruleContractField
                    {

                    						newCompositeNode(grammarAccess.getSpecialValueContractAccess().getFieldContractFieldParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_field_6_0=ruleContractField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSpecialValueContractRule());
                    						}
                    						set(
                    							current,
                    							"field",
                    							lv_field_6_0,
                    							"xtext.json.WorkflowDSL.ContractField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getSpecialValueContractAccess().getRightParenthesisKeyword_1_3());
                    			

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
    // $ANTLR end "ruleSpecialValueContract"


    // $ANTLR start "entryRuleCastTypeContract"
    // InternalWorkflowDSL.g:1883:1: entryRuleCastTypeContract returns [EObject current=null] : iv_ruleCastTypeContract= ruleCastTypeContract EOF ;
    public final EObject entryRuleCastTypeContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastTypeContract = null;


        try {
            // InternalWorkflowDSL.g:1883:57: (iv_ruleCastTypeContract= ruleCastTypeContract EOF )
            // InternalWorkflowDSL.g:1884:2: iv_ruleCastTypeContract= ruleCastTypeContract EOF
            {
             newCompositeNode(grammarAccess.getCastTypeContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCastTypeContract=ruleCastTypeContract();

            state._fsp--;

             current =iv_ruleCastTypeContract; 
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
    // $ANTLR end "entryRuleCastTypeContract"


    // $ANTLR start "ruleCastTypeContract"
    // InternalWorkflowDSL.g:1890:1: ruleCastTypeContract returns [EObject current=null] : ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_field_3_0= ruleContractField ) ) otherlv_4= ')' ) | (otherlv_5= 'is_type' ( (lv_type_6_0= ruleType ) ) otherlv_7= '(' ( (lv_field_8_0= ruleContractField ) ) otherlv_9= ')' ) ) ;
    public final EObject ruleCastTypeContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_field_3_0 = null;

        AntlrDatatypeRuleToken lv_type_6_0 = null;

        EObject lv_field_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:1896:2: ( ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_field_3_0= ruleContractField ) ) otherlv_4= ')' ) | (otherlv_5= 'is_type' ( (lv_type_6_0= ruleType ) ) otherlv_7= '(' ( (lv_field_8_0= ruleContractField ) ) otherlv_9= ')' ) ) )
            // InternalWorkflowDSL.g:1897:2: ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_field_3_0= ruleContractField ) ) otherlv_4= ')' ) | (otherlv_5= 'is_type' ( (lv_type_6_0= ruleType ) ) otherlv_7= '(' ( (lv_field_8_0= ruleContractField ) ) otherlv_9= ')' ) )
            {
            // InternalWorkflowDSL.g:1897:2: ( (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_field_3_0= ruleContractField ) ) otherlv_4= ')' ) | (otherlv_5= 'is_type' ( (lv_type_6_0= ruleType ) ) otherlv_7= '(' ( (lv_field_8_0= ruleContractField ) ) otherlv_9= ')' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            else if ( (LA18_0==51) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalWorkflowDSL.g:1898:3: (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_field_3_0= ruleContractField ) ) otherlv_4= ')' )
                    {
                    // InternalWorkflowDSL.g:1898:3: (otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_field_3_0= ruleContractField ) ) otherlv_4= ')' )
                    // InternalWorkflowDSL.g:1899:4: otherlv_0= 'castable_to' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_field_3_0= ruleContractField ) ) otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,34,FOLLOW_26); 

                    				newLeafNode(otherlv_0, grammarAccess.getCastTypeContractAccess().getCastable_toKeyword_0_0());
                    			
                    // InternalWorkflowDSL.g:1903:4: ( (lv_type_1_0= ruleType ) )
                    // InternalWorkflowDSL.g:1904:5: (lv_type_1_0= ruleType )
                    {
                    // InternalWorkflowDSL.g:1904:5: (lv_type_1_0= ruleType )
                    // InternalWorkflowDSL.g:1905:6: lv_type_1_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getCastTypeContractAccess().getTypeTypeParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_type_1_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCastTypeContractRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_1_0,
                    							"xtext.json.WorkflowDSL.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,18,FOLLOW_22); 

                    				newLeafNode(otherlv_2, grammarAccess.getCastTypeContractAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalWorkflowDSL.g:1926:4: ( (lv_field_3_0= ruleContractField ) )
                    // InternalWorkflowDSL.g:1927:5: (lv_field_3_0= ruleContractField )
                    {
                    // InternalWorkflowDSL.g:1927:5: (lv_field_3_0= ruleContractField )
                    // InternalWorkflowDSL.g:1928:6: lv_field_3_0= ruleContractField
                    {

                    						newCompositeNode(grammarAccess.getCastTypeContractAccess().getFieldContractFieldParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_field_3_0=ruleContractField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCastTypeContractRule());
                    						}
                    						set(
                    							current,
                    							"field",
                    							lv_field_3_0,
                    							"xtext.json.WorkflowDSL.ContractField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getCastTypeContractAccess().getRightParenthesisKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:1951:3: (otherlv_5= 'is_type' ( (lv_type_6_0= ruleType ) ) otherlv_7= '(' ( (lv_field_8_0= ruleContractField ) ) otherlv_9= ')' )
                    {
                    // InternalWorkflowDSL.g:1951:3: (otherlv_5= 'is_type' ( (lv_type_6_0= ruleType ) ) otherlv_7= '(' ( (lv_field_8_0= ruleContractField ) ) otherlv_9= ')' )
                    // InternalWorkflowDSL.g:1952:4: otherlv_5= 'is_type' ( (lv_type_6_0= ruleType ) ) otherlv_7= '(' ( (lv_field_8_0= ruleContractField ) ) otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,51,FOLLOW_26); 

                    				newLeafNode(otherlv_5, grammarAccess.getCastTypeContractAccess().getIs_typeKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:1956:4: ( (lv_type_6_0= ruleType ) )
                    // InternalWorkflowDSL.g:1957:5: (lv_type_6_0= ruleType )
                    {
                    // InternalWorkflowDSL.g:1957:5: (lv_type_6_0= ruleType )
                    // InternalWorkflowDSL.g:1958:6: lv_type_6_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getCastTypeContractAccess().getTypeTypeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_type_6_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCastTypeContractRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_6_0,
                    							"xtext.json.WorkflowDSL.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,18,FOLLOW_22); 

                    				newLeafNode(otherlv_7, grammarAccess.getCastTypeContractAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalWorkflowDSL.g:1979:4: ( (lv_field_8_0= ruleContractField ) )
                    // InternalWorkflowDSL.g:1980:5: (lv_field_8_0= ruleContractField )
                    {
                    // InternalWorkflowDSL.g:1980:5: (lv_field_8_0= ruleContractField )
                    // InternalWorkflowDSL.g:1981:6: lv_field_8_0= ruleContractField
                    {

                    						newCompositeNode(grammarAccess.getCastTypeContractAccess().getFieldContractFieldParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_field_8_0=ruleContractField();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCastTypeContractRule());
                    						}
                    						set(
                    							current,
                    							"field",
                    							lv_field_8_0,
                    							"xtext.json.WorkflowDSL.ContractField");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getCastTypeContractAccess().getRightParenthesisKeyword_1_4());
                    			

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
    // $ANTLR end "ruleCastTypeContract"


    // $ANTLR start "entryRuleTransformation"
    // InternalWorkflowDSL.g:2007:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;


        try {
            // InternalWorkflowDSL.g:2007:55: (iv_ruleTransformation= ruleTransformation EOF )
            // InternalWorkflowDSL.g:2008:2: iv_ruleTransformation= ruleTransformation EOF
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
    // InternalWorkflowDSL.g:2014:1: ruleTransformation returns [EObject current=null] : (this_RowFilter_0= ruleRowFilter | this_ColumnFilter_1= ruleColumnFilter | this_Mapping_2= ruleMapping | this_MathOp_3= ruleMathOp | this_Binner_4= ruleBinner | this_TypeConversion_5= ruleTypeConversion | this_Imputation_6= ruleImputation | this_OutlierTreatment_7= ruleOutlierTreatment | this_Join_8= ruleJoin ) ;
    public final EObject ruleTransformation() throws RecognitionException {
        EObject current = null;

        EObject this_RowFilter_0 = null;

        EObject this_ColumnFilter_1 = null;

        EObject this_Mapping_2 = null;

        EObject this_MathOp_3 = null;

        EObject this_Binner_4 = null;

        EObject this_TypeConversion_5 = null;

        EObject this_Imputation_6 = null;

        EObject this_OutlierTreatment_7 = null;

        EObject this_Join_8 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2020:2: ( (this_RowFilter_0= ruleRowFilter | this_ColumnFilter_1= ruleColumnFilter | this_Mapping_2= ruleMapping | this_MathOp_3= ruleMathOp | this_Binner_4= ruleBinner | this_TypeConversion_5= ruleTypeConversion | this_Imputation_6= ruleImputation | this_OutlierTreatment_7= ruleOutlierTreatment | this_Join_8= ruleJoin ) )
            // InternalWorkflowDSL.g:2021:2: (this_RowFilter_0= ruleRowFilter | this_ColumnFilter_1= ruleColumnFilter | this_Mapping_2= ruleMapping | this_MathOp_3= ruleMathOp | this_Binner_4= ruleBinner | this_TypeConversion_5= ruleTypeConversion | this_Imputation_6= ruleImputation | this_OutlierTreatment_7= ruleOutlierTreatment | this_Join_8= ruleJoin )
            {
            // InternalWorkflowDSL.g:2021:2: (this_RowFilter_0= ruleRowFilter | this_ColumnFilter_1= ruleColumnFilter | this_Mapping_2= ruleMapping | this_MathOp_3= ruleMathOp | this_Binner_4= ruleBinner | this_TypeConversion_5= ruleTypeConversion | this_Imputation_6= ruleImputation | this_OutlierTreatment_7= ruleOutlierTreatment | this_Join_8= ruleJoin )
            int alt19=9;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt19=1;
                }
                break;
            case 63:
            case 64:
            case 65:
            case 66:
                {
                alt19=2;
                }
                break;
            case 67:
            case 70:
                {
                alt19=3;
                }
                break;
            case 72:
                {
                alt19=4;
                }
                break;
            case 89:
                {
                alt19=5;
                }
                break;
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
                {
                alt19=6;
                }
                break;
            case 100:
                {
                alt19=7;
                }
                break;
            case 120:
                {
                alt19=8;
                }
                break;
            case 142:
                {
                alt19=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalWorkflowDSL.g:2022:3: this_RowFilter_0= ruleRowFilter
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getRowFilterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RowFilter_0=ruleRowFilter();

                    state._fsp--;


                    			current = this_RowFilter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2031:3: this_ColumnFilter_1= ruleColumnFilter
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getColumnFilterParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ColumnFilter_1=ruleColumnFilter();

                    state._fsp--;


                    			current = this_ColumnFilter_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:2040:3: this_Mapping_2= ruleMapping
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getMappingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Mapping_2=ruleMapping();

                    state._fsp--;


                    			current = this_Mapping_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:2049:3: this_MathOp_3= ruleMathOp
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getMathOpParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathOp_3=ruleMathOp();

                    state._fsp--;


                    			current = this_MathOp_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:2058:3: this_Binner_4= ruleBinner
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getBinnerParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Binner_4=ruleBinner();

                    state._fsp--;


                    			current = this_Binner_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflowDSL.g:2067:3: this_TypeConversion_5= ruleTypeConversion
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getTypeConversionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_TypeConversion_5=ruleTypeConversion();

                    state._fsp--;


                    			current = this_TypeConversion_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalWorkflowDSL.g:2076:3: this_Imputation_6= ruleImputation
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getImputationParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Imputation_6=ruleImputation();

                    state._fsp--;


                    			current = this_Imputation_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalWorkflowDSL.g:2085:3: this_OutlierTreatment_7= ruleOutlierTreatment
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getOutlierTreatmentParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_OutlierTreatment_7=ruleOutlierTreatment();

                    state._fsp--;


                    			current = this_OutlierTreatment_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalWorkflowDSL.g:2094:3: this_Join_8= ruleJoin
                    {

                    			newCompositeNode(grammarAccess.getTransformationAccess().getJoinParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Join_8=ruleJoin();

                    state._fsp--;


                    			current = this_Join_8;
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
    // $ANTLR end "ruleTransformation"


    // $ANTLR start "entryRuleRowFilter"
    // InternalWorkflowDSL.g:2106:1: entryRuleRowFilter returns [EObject current=null] : iv_ruleRowFilter= ruleRowFilter EOF ;
    public final EObject entryRuleRowFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRowFilter = null;


        try {
            // InternalWorkflowDSL.g:2106:50: (iv_ruleRowFilter= ruleRowFilter EOF )
            // InternalWorkflowDSL.g:2107:2: iv_ruleRowFilter= ruleRowFilter EOF
            {
             newCompositeNode(grammarAccess.getRowFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRowFilter=ruleRowFilter();

            state._fsp--;

             current =iv_ruleRowFilter; 
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
    // $ANTLR end "entryRuleRowFilter"


    // $ANTLR start "ruleRowFilter"
    // InternalWorkflowDSL.g:2113:1: ruleRowFilter returns [EObject current=null] : (otherlv_0= 'filter_rows' otherlv_1= '{' ( (lv_condition_2_0= ruleFilterCondition ) ) otherlv_3= '}' ) ;
    public final EObject ruleRowFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2119:2: ( (otherlv_0= 'filter_rows' otherlv_1= '{' ( (lv_condition_2_0= ruleFilterCondition ) ) otherlv_3= '}' ) )
            // InternalWorkflowDSL.g:2120:2: (otherlv_0= 'filter_rows' otherlv_1= '{' ( (lv_condition_2_0= ruleFilterCondition ) ) otherlv_3= '}' )
            {
            // InternalWorkflowDSL.g:2120:2: (otherlv_0= 'filter_rows' otherlv_1= '{' ( (lv_condition_2_0= ruleFilterCondition ) ) otherlv_3= '}' )
            // InternalWorkflowDSL.g:2121:3: otherlv_0= 'filter_rows' otherlv_1= '{' ( (lv_condition_2_0= ruleFilterCondition ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getRowFilterAccess().getFilter_rowsKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getRowFilterAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalWorkflowDSL.g:2129:3: ( (lv_condition_2_0= ruleFilterCondition ) )
            // InternalWorkflowDSL.g:2130:4: (lv_condition_2_0= ruleFilterCondition )
            {
            // InternalWorkflowDSL.g:2130:4: (lv_condition_2_0= ruleFilterCondition )
            // InternalWorkflowDSL.g:2131:5: lv_condition_2_0= ruleFilterCondition
            {

            					newCompositeNode(grammarAccess.getRowFilterAccess().getConditionFilterConditionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_condition_2_0=ruleFilterCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRowFilterRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_2_0,
            						"xtext.json.WorkflowDSL.FilterCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getRowFilterAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleRowFilter"


    // $ANTLR start "entryRuleFilterCondition"
    // InternalWorkflowDSL.g:2156:1: entryRuleFilterCondition returns [EObject current=null] : iv_ruleFilterCondition= ruleFilterCondition EOF ;
    public final EObject entryRuleFilterCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterCondition = null;


        try {
            // InternalWorkflowDSL.g:2156:56: (iv_ruleFilterCondition= ruleFilterCondition EOF )
            // InternalWorkflowDSL.g:2157:2: iv_ruleFilterCondition= ruleFilterCondition EOF
            {
             newCompositeNode(grammarAccess.getFilterConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilterCondition=ruleFilterCondition();

            state._fsp--;

             current =iv_ruleFilterCondition; 
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
    // $ANTLR end "entryRuleFilterCondition"


    // $ANTLR start "ruleFilterCondition"
    // InternalWorkflowDSL.g:2163:1: ruleFilterCondition returns [EObject current=null] : (this_MissingFilter_0= ruleMissingFilter | this_RangeFilter_1= ruleRangeFilter | this_StringFilter_2= ruleStringFilter ) ;
    public final EObject ruleFilterCondition() throws RecognitionException {
        EObject current = null;

        EObject this_MissingFilter_0 = null;

        EObject this_RangeFilter_1 = null;

        EObject this_StringFilter_2 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2169:2: ( (this_MissingFilter_0= ruleMissingFilter | this_RangeFilter_1= ruleRangeFilter | this_StringFilter_2= ruleStringFilter ) )
            // InternalWorkflowDSL.g:2170:2: (this_MissingFilter_0= ruleMissingFilter | this_RangeFilter_1= ruleRangeFilter | this_StringFilter_2= ruleStringFilter )
            {
            // InternalWorkflowDSL.g:2170:2: (this_MissingFilter_0= ruleMissingFilter | this_RangeFilter_1= ruleRangeFilter | this_StringFilter_2= ruleStringFilter )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt20=1;
                }
                break;
            case 54:
                {
                alt20=2;
                }
                break;
            case 36:
            case 60:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalWorkflowDSL.g:2171:3: this_MissingFilter_0= ruleMissingFilter
                    {

                    			newCompositeNode(grammarAccess.getFilterConditionAccess().getMissingFilterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MissingFilter_0=ruleMissingFilter();

                    state._fsp--;


                    			current = this_MissingFilter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2180:3: this_RangeFilter_1= ruleRangeFilter
                    {

                    			newCompositeNode(grammarAccess.getFilterConditionAccess().getRangeFilterParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RangeFilter_1=ruleRangeFilter();

                    state._fsp--;


                    			current = this_RangeFilter_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:2189:3: this_StringFilter_2= ruleStringFilter
                    {

                    			newCompositeNode(grammarAccess.getFilterConditionAccess().getStringFilterParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringFilter_2=ruleStringFilter();

                    state._fsp--;


                    			current = this_StringFilter_2;
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
    // $ANTLR end "ruleFilterCondition"


    // $ANTLR start "entryRuleMissingFilter"
    // InternalWorkflowDSL.g:2201:1: entryRuleMissingFilter returns [EObject current=null] : iv_ruleMissingFilter= ruleMissingFilter EOF ;
    public final EObject entryRuleMissingFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMissingFilter = null;


        try {
            // InternalWorkflowDSL.g:2201:54: (iv_ruleMissingFilter= ruleMissingFilter EOF )
            // InternalWorkflowDSL.g:2202:2: iv_ruleMissingFilter= ruleMissingFilter EOF
            {
             newCompositeNode(grammarAccess.getMissingFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMissingFilter=ruleMissingFilter();

            state._fsp--;

             current =iv_ruleMissingFilter; 
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
    // $ANTLR end "entryRuleMissingFilter"


    // $ANTLR start "ruleMissingFilter"
    // InternalWorkflowDSL.g:2208:1: ruleMissingFilter returns [EObject current=null] : (otherlv_0= 'missing' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ',' ( (lv_includeExclude_4_0= ruleIncludeExclude ) ) otherlv_5= ')' ) ;
    public final EObject ruleMissingFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_columns_2_0 = null;

        AntlrDatatypeRuleToken lv_includeExclude_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2214:2: ( (otherlv_0= 'missing' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ',' ( (lv_includeExclude_4_0= ruleIncludeExclude ) ) otherlv_5= ')' ) )
            // InternalWorkflowDSL.g:2215:2: (otherlv_0= 'missing' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ',' ( (lv_includeExclude_4_0= ruleIncludeExclude ) ) otherlv_5= ')' )
            {
            // InternalWorkflowDSL.g:2215:2: (otherlv_0= 'missing' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ',' ( (lv_includeExclude_4_0= ruleIncludeExclude ) ) otherlv_5= ')' )
            // InternalWorkflowDSL.g:2216:3: otherlv_0= 'missing' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ',' ( (lv_includeExclude_4_0= ruleIncludeExclude ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getMissingFilterAccess().getMissingKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getMissingFilterAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:2224:3: ( (lv_columns_2_0= ruleColumnList ) )
            // InternalWorkflowDSL.g:2225:4: (lv_columns_2_0= ruleColumnList )
            {
            // InternalWorkflowDSL.g:2225:4: (lv_columns_2_0= ruleColumnList )
            // InternalWorkflowDSL.g:2226:5: lv_columns_2_0= ruleColumnList
            {

            					newCompositeNode(grammarAccess.getMissingFilterAccess().getColumnsColumnListParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_columns_2_0=ruleColumnList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMissingFilterRule());
            					}
            					set(
            						current,
            						"columns",
            						lv_columns_2_0,
            						"xtext.json.WorkflowDSL.ColumnList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_35); 

            			newLeafNode(otherlv_3, grammarAccess.getMissingFilterAccess().getCommaKeyword_3());
            		
            // InternalWorkflowDSL.g:2247:3: ( (lv_includeExclude_4_0= ruleIncludeExclude ) )
            // InternalWorkflowDSL.g:2248:4: (lv_includeExclude_4_0= ruleIncludeExclude )
            {
            // InternalWorkflowDSL.g:2248:4: (lv_includeExclude_4_0= ruleIncludeExclude )
            // InternalWorkflowDSL.g:2249:5: lv_includeExclude_4_0= ruleIncludeExclude
            {

            					newCompositeNode(grammarAccess.getMissingFilterAccess().getIncludeExcludeIncludeExcludeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_14);
            lv_includeExclude_4_0=ruleIncludeExclude();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMissingFilterRule());
            					}
            					set(
            						current,
            						"includeExclude",
            						lv_includeExclude_4_0,
            						"xtext.json.WorkflowDSL.IncludeExclude");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getMissingFilterAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleMissingFilter"


    // $ANTLR start "entryRuleRangeFilter"
    // InternalWorkflowDSL.g:2274:1: entryRuleRangeFilter returns [EObject current=null] : iv_ruleRangeFilter= ruleRangeFilter EOF ;
    public final EObject entryRuleRangeFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeFilter = null;


        try {
            // InternalWorkflowDSL.g:2274:52: (iv_ruleRangeFilter= ruleRangeFilter EOF )
            // InternalWorkflowDSL.g:2275:2: iv_ruleRangeFilter= ruleRangeFilter EOF
            {
             newCompositeNode(grammarAccess.getRangeFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRangeFilter=ruleRangeFilter();

            state._fsp--;

             current =iv_ruleRangeFilter; 
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
    // $ANTLR end "entryRuleRangeFilter"


    // $ANTLR start "ruleRangeFilter"
    // InternalWorkflowDSL.g:2281:1: ruleRangeFilter returns [EObject current=null] : (otherlv_0= 'range' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_bounds_4_0= ruleRangeBounds ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' ) ;
    public final EObject ruleRangeFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_column_2_0 = null;

        EObject lv_bounds_4_0 = null;

        AntlrDatatypeRuleToken lv_includeExclude_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2287:2: ( (otherlv_0= 'range' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_bounds_4_0= ruleRangeBounds ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' ) )
            // InternalWorkflowDSL.g:2288:2: (otherlv_0= 'range' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_bounds_4_0= ruleRangeBounds ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' )
            {
            // InternalWorkflowDSL.g:2288:2: (otherlv_0= 'range' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_bounds_4_0= ruleRangeBounds ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' )
            // InternalWorkflowDSL.g:2289:3: otherlv_0= 'range' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_bounds_4_0= ruleRangeBounds ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getRangeFilterAccess().getRangeKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getRangeFilterAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:2297:3: ( (lv_column_2_0= ruleColumn ) )
            // InternalWorkflowDSL.g:2298:4: (lv_column_2_0= ruleColumn )
            {
            // InternalWorkflowDSL.g:2298:4: (lv_column_2_0= ruleColumn )
            // InternalWorkflowDSL.g:2299:5: lv_column_2_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getRangeFilterAccess().getColumnColumnParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_column_2_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRangeFilterRule());
            					}
            					set(
            						current,
            						"column",
            						lv_column_2_0,
            						"xtext.json.WorkflowDSL.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getRangeFilterAccess().getCommaKeyword_3());
            		
            // InternalWorkflowDSL.g:2320:3: ( (lv_bounds_4_0= ruleRangeBounds ) )
            // InternalWorkflowDSL.g:2321:4: (lv_bounds_4_0= ruleRangeBounds )
            {
            // InternalWorkflowDSL.g:2321:4: (lv_bounds_4_0= ruleRangeBounds )
            // InternalWorkflowDSL.g:2322:5: lv_bounds_4_0= ruleRangeBounds
            {

            					newCompositeNode(grammarAccess.getRangeFilterAccess().getBoundsRangeBoundsParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_23);
            lv_bounds_4_0=ruleRangeBounds();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRangeFilterRule());
            					}
            					set(
            						current,
            						"bounds",
            						lv_bounds_4_0,
            						"xtext.json.WorkflowDSL.RangeBounds");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_35); 

            			newLeafNode(otherlv_5, grammarAccess.getRangeFilterAccess().getCommaKeyword_5());
            		
            // InternalWorkflowDSL.g:2343:3: ( (lv_includeExclude_6_0= ruleIncludeExclude ) )
            // InternalWorkflowDSL.g:2344:4: (lv_includeExclude_6_0= ruleIncludeExclude )
            {
            // InternalWorkflowDSL.g:2344:4: (lv_includeExclude_6_0= ruleIncludeExclude )
            // InternalWorkflowDSL.g:2345:5: lv_includeExclude_6_0= ruleIncludeExclude
            {

            					newCompositeNode(grammarAccess.getRangeFilterAccess().getIncludeExcludeIncludeExcludeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_14);
            lv_includeExclude_6_0=ruleIncludeExclude();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRangeFilterRule());
            					}
            					set(
            						current,
            						"includeExclude",
            						lv_includeExclude_6_0,
            						"xtext.json.WorkflowDSL.IncludeExclude");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getRangeFilterAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleRangeFilter"


    // $ANTLR start "entryRuleRangeBounds"
    // InternalWorkflowDSL.g:2370:1: entryRuleRangeBounds returns [EObject current=null] : iv_ruleRangeBounds= ruleRangeBounds EOF ;
    public final EObject entryRuleRangeBounds() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeBounds = null;


        try {
            // InternalWorkflowDSL.g:2370:52: (iv_ruleRangeBounds= ruleRangeBounds EOF )
            // InternalWorkflowDSL.g:2371:2: iv_ruleRangeBounds= ruleRangeBounds EOF
            {
             newCompositeNode(grammarAccess.getRangeBoundsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRangeBounds=ruleRangeBounds();

            state._fsp--;

             current =iv_ruleRangeBounds; 
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
    // $ANTLR end "entryRuleRangeBounds"


    // $ANTLR start "ruleRangeBounds"
    // InternalWorkflowDSL.g:2377:1: ruleRangeBounds returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')' ) ) ;
    public final EObject ruleRangeBounds() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_lower_1_0 = null;

        EObject lv_upper_3_0 = null;

        EObject lv_lower_6_0 = null;

        EObject lv_upper_8_0 = null;

        EObject lv_lower_11_0 = null;

        EObject lv_upper_13_0 = null;

        EObject lv_lower_16_0 = null;

        EObject lv_upper_18_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2383:2: ( ( (otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')' ) ) )
            // InternalWorkflowDSL.g:2384:2: ( (otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')' ) )
            {
            // InternalWorkflowDSL.g:2384:2: ( (otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')' ) )
            int alt21=4;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalWorkflowDSL.g:2385:3: (otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']' )
                    {
                    // InternalWorkflowDSL.g:2385:3: (otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']' )
                    // InternalWorkflowDSL.g:2386:4: otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']'
                    {
                    otherlv_0=(Token)match(input,55,FOLLOW_36); 

                    				newLeafNode(otherlv_0, grammarAccess.getRangeBoundsAccess().getLeftSquareBracketKeyword_0_0());
                    			
                    // InternalWorkflowDSL.g:2390:4: ( (lv_lower_1_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2391:5: (lv_lower_1_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2391:5: (lv_lower_1_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2392:6: lv_lower_1_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getLowerBoundValueParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_1_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_1_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,19,FOLLOW_36); 

                    				newLeafNode(otherlv_2, grammarAccess.getRangeBoundsAccess().getCommaKeyword_0_2());
                    			
                    // InternalWorkflowDSL.g:2413:4: ( (lv_upper_3_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2414:5: (lv_upper_3_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2414:5: (lv_upper_3_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2415:6: lv_upper_3_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getUpperBoundValueParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_upper_3_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_3_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,56,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getRangeBoundsAccess().getRightSquareBracketKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2438:3: (otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')' )
                    {
                    // InternalWorkflowDSL.g:2438:3: (otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')' )
                    // InternalWorkflowDSL.g:2439:4: otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,55,FOLLOW_36); 

                    				newLeafNode(otherlv_5, grammarAccess.getRangeBoundsAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:2443:4: ( (lv_lower_6_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2444:5: (lv_lower_6_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2444:5: (lv_lower_6_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2445:6: lv_lower_6_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getLowerBoundValueParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_6_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_6_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,19,FOLLOW_36); 

                    				newLeafNode(otherlv_7, grammarAccess.getRangeBoundsAccess().getCommaKeyword_1_2());
                    			
                    // InternalWorkflowDSL.g:2466:4: ( (lv_upper_8_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2467:5: (lv_upper_8_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2467:5: (lv_upper_8_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2468:6: lv_upper_8_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getUpperBoundValueParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_upper_8_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_8_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getRangeBoundsAccess().getRightParenthesisKeyword_1_4());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:2491:3: (otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']' )
                    {
                    // InternalWorkflowDSL.g:2491:3: (otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']' )
                    // InternalWorkflowDSL.g:2492:4: otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']'
                    {
                    otherlv_10=(Token)match(input,18,FOLLOW_36); 

                    				newLeafNode(otherlv_10, grammarAccess.getRangeBoundsAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalWorkflowDSL.g:2496:4: ( (lv_lower_11_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2497:5: (lv_lower_11_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2497:5: (lv_lower_11_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2498:6: lv_lower_11_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getLowerBoundValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_11_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_11_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,19,FOLLOW_36); 

                    				newLeafNode(otherlv_12, grammarAccess.getRangeBoundsAccess().getCommaKeyword_2_2());
                    			
                    // InternalWorkflowDSL.g:2519:4: ( (lv_upper_13_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2520:5: (lv_upper_13_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2520:5: (lv_upper_13_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2521:6: lv_upper_13_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getUpperBoundValueParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_upper_13_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_13_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,56,FOLLOW_2); 

                    				newLeafNode(otherlv_14, grammarAccess.getRangeBoundsAccess().getRightSquareBracketKeyword_2_4());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:2544:3: (otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')' )
                    {
                    // InternalWorkflowDSL.g:2544:3: (otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')' )
                    // InternalWorkflowDSL.g:2545:4: otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')'
                    {
                    otherlv_15=(Token)match(input,18,FOLLOW_36); 

                    				newLeafNode(otherlv_15, grammarAccess.getRangeBoundsAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalWorkflowDSL.g:2549:4: ( (lv_lower_16_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2550:5: (lv_lower_16_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2550:5: (lv_lower_16_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2551:6: lv_lower_16_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getLowerBoundValueParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_16_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_16_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,19,FOLLOW_36); 

                    				newLeafNode(otherlv_17, grammarAccess.getRangeBoundsAccess().getCommaKeyword_3_2());
                    			
                    // InternalWorkflowDSL.g:2572:4: ( (lv_upper_18_0= ruleBoundValue ) )
                    // InternalWorkflowDSL.g:2573:5: (lv_upper_18_0= ruleBoundValue )
                    {
                    // InternalWorkflowDSL.g:2573:5: (lv_upper_18_0= ruleBoundValue )
                    // InternalWorkflowDSL.g:2574:6: lv_upper_18_0= ruleBoundValue
                    {

                    						newCompositeNode(grammarAccess.getRangeBoundsAccess().getUpperBoundValueParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_upper_18_0=ruleBoundValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRangeBoundsRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_18_0,
                    							"xtext.json.WorkflowDSL.BoundValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_19=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getRangeBoundsAccess().getRightParenthesisKeyword_3_4());
                    			

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
    // $ANTLR end "ruleRangeBounds"


    // $ANTLR start "entryRuleBoundValue"
    // InternalWorkflowDSL.g:2600:1: entryRuleBoundValue returns [EObject current=null] : iv_ruleBoundValue= ruleBoundValue EOF ;
    public final EObject entryRuleBoundValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundValue = null;


        try {
            // InternalWorkflowDSL.g:2600:51: (iv_ruleBoundValue= ruleBoundValue EOF )
            // InternalWorkflowDSL.g:2601:2: iv_ruleBoundValue= ruleBoundValue EOF
            {
             newCompositeNode(grammarAccess.getBoundValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoundValue=ruleBoundValue();

            state._fsp--;

             current =iv_ruleBoundValue; 
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
    // $ANTLR end "entryRuleBoundValue"


    // $ANTLR start "ruleBoundValue"
    // InternalWorkflowDSL.g:2607:1: ruleBoundValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '*' | otherlv_2= 'inf' | otherlv_3= '-inf' ) ;
    public final EObject ruleBoundValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2613:2: ( ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '*' | otherlv_2= 'inf' | otherlv_3= '-inf' ) )
            // InternalWorkflowDSL.g:2614:2: ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '*' | otherlv_2= 'inf' | otherlv_3= '-inf' )
            {
            // InternalWorkflowDSL.g:2614:2: ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '*' | otherlv_2= 'inf' | otherlv_3= '-inf' )
            int alt22=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 32:
                {
                alt22=1;
                }
                break;
            case 57:
                {
                alt22=2;
                }
                break;
            case 58:
                {
                alt22=3;
                }
                break;
            case 59:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalWorkflowDSL.g:2615:3: ( (lv_value_0_0= ruleNumber ) )
                    {
                    // InternalWorkflowDSL.g:2615:3: ( (lv_value_0_0= ruleNumber ) )
                    // InternalWorkflowDSL.g:2616:4: (lv_value_0_0= ruleNumber )
                    {
                    // InternalWorkflowDSL.g:2616:4: (lv_value_0_0= ruleNumber )
                    // InternalWorkflowDSL.g:2617:5: lv_value_0_0= ruleNumber
                    {

                    					newCompositeNode(grammarAccess.getBoundValueAccess().getValueNumberParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleNumber();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoundValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_0_0,
                    						"xtext.json.WorkflowDSL.Number");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2635:3: otherlv_1= '*'
                    {
                    otherlv_1=(Token)match(input,57,FOLLOW_2); 

                    			newLeafNode(otherlv_1, grammarAccess.getBoundValueAccess().getAsteriskKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:2640:3: otherlv_2= 'inf'
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_2); 

                    			newLeafNode(otherlv_2, grammarAccess.getBoundValueAccess().getInfKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:2645:3: otherlv_3= '-inf'
                    {
                    otherlv_3=(Token)match(input,59,FOLLOW_2); 

                    			newLeafNode(otherlv_3, grammarAccess.getBoundValueAccess().getInfKeyword_3());
                    		

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
    // $ANTLR end "ruleBoundValue"


    // $ANTLR start "entryRuleStringFilter"
    // InternalWorkflowDSL.g:2653:1: entryRuleStringFilter returns [EObject current=null] : iv_ruleStringFilter= ruleStringFilter EOF ;
    public final EObject entryRuleStringFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringFilter = null;


        try {
            // InternalWorkflowDSL.g:2653:53: (iv_ruleStringFilter= ruleStringFilter EOF )
            // InternalWorkflowDSL.g:2654:2: iv_ruleStringFilter= ruleStringFilter EOF
            {
             newCompositeNode(grammarAccess.getStringFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringFilter=ruleStringFilter();

            state._fsp--;

             current =iv_ruleStringFilter; 
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
    // $ANTLR end "entryRuleStringFilter"


    // $ANTLR start "ruleStringFilter"
    // InternalWorkflowDSL.g:2660:1: ruleStringFilter returns [EObject current=null] : ( (otherlv_0= 'matches' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_pattern_4_0= rulePattern ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' ) | (otherlv_8= 'like' otherlv_9= '(' ( (lv_column_10_0= ruleColumn ) ) otherlv_11= ',' ( (lv_pattern_12_0= rulePattern ) ) otherlv_13= ',' ( (lv_includeExclude_14_0= ruleIncludeExclude ) ) otherlv_15= ')' ) ) ;
    public final EObject ruleStringFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_column_2_0 = null;

        EObject lv_pattern_4_0 = null;

        AntlrDatatypeRuleToken lv_includeExclude_6_0 = null;

        EObject lv_column_10_0 = null;

        EObject lv_pattern_12_0 = null;

        AntlrDatatypeRuleToken lv_includeExclude_14_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2666:2: ( ( (otherlv_0= 'matches' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_pattern_4_0= rulePattern ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' ) | (otherlv_8= 'like' otherlv_9= '(' ( (lv_column_10_0= ruleColumn ) ) otherlv_11= ',' ( (lv_pattern_12_0= rulePattern ) ) otherlv_13= ',' ( (lv_includeExclude_14_0= ruleIncludeExclude ) ) otherlv_15= ')' ) ) )
            // InternalWorkflowDSL.g:2667:2: ( (otherlv_0= 'matches' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_pattern_4_0= rulePattern ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' ) | (otherlv_8= 'like' otherlv_9= '(' ( (lv_column_10_0= ruleColumn ) ) otherlv_11= ',' ( (lv_pattern_12_0= rulePattern ) ) otherlv_13= ',' ( (lv_includeExclude_14_0= ruleIncludeExclude ) ) otherlv_15= ')' ) )
            {
            // InternalWorkflowDSL.g:2667:2: ( (otherlv_0= 'matches' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_pattern_4_0= rulePattern ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' ) | (otherlv_8= 'like' otherlv_9= '(' ( (lv_column_10_0= ruleColumn ) ) otherlv_11= ',' ( (lv_pattern_12_0= rulePattern ) ) otherlv_13= ',' ( (lv_includeExclude_14_0= ruleIncludeExclude ) ) otherlv_15= ')' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            else if ( (LA23_0==60) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalWorkflowDSL.g:2668:3: (otherlv_0= 'matches' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_pattern_4_0= rulePattern ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' )
                    {
                    // InternalWorkflowDSL.g:2668:3: (otherlv_0= 'matches' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_pattern_4_0= rulePattern ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')' )
                    // InternalWorkflowDSL.g:2669:4: otherlv_0= 'matches' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_pattern_4_0= rulePattern ) ) otherlv_5= ',' ( (lv_includeExclude_6_0= ruleIncludeExclude ) ) otherlv_7= ')'
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getStringFilterAccess().getMatchesKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getStringFilterAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:2677:4: ( (lv_column_2_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:2678:5: (lv_column_2_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:2678:5: (lv_column_2_0= ruleColumn )
                    // InternalWorkflowDSL.g:2679:6: lv_column_2_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getStringFilterAccess().getColumnColumnParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_column_2_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFilterRule());
                    						}
                    						set(
                    							current,
                    							"column",
                    							lv_column_2_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_38); 

                    				newLeafNode(otherlv_3, grammarAccess.getStringFilterAccess().getCommaKeyword_0_3());
                    			
                    // InternalWorkflowDSL.g:2700:4: ( (lv_pattern_4_0= rulePattern ) )
                    // InternalWorkflowDSL.g:2701:5: (lv_pattern_4_0= rulePattern )
                    {
                    // InternalWorkflowDSL.g:2701:5: (lv_pattern_4_0= rulePattern )
                    // InternalWorkflowDSL.g:2702:6: lv_pattern_4_0= rulePattern
                    {

                    						newCompositeNode(grammarAccess.getStringFilterAccess().getPatternPatternParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_pattern_4_0=rulePattern();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFilterRule());
                    						}
                    						set(
                    							current,
                    							"pattern",
                    							lv_pattern_4_0,
                    							"xtext.json.WorkflowDSL.Pattern");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_35); 

                    				newLeafNode(otherlv_5, grammarAccess.getStringFilterAccess().getCommaKeyword_0_5());
                    			
                    // InternalWorkflowDSL.g:2723:4: ( (lv_includeExclude_6_0= ruleIncludeExclude ) )
                    // InternalWorkflowDSL.g:2724:5: (lv_includeExclude_6_0= ruleIncludeExclude )
                    {
                    // InternalWorkflowDSL.g:2724:5: (lv_includeExclude_6_0= ruleIncludeExclude )
                    // InternalWorkflowDSL.g:2725:6: lv_includeExclude_6_0= ruleIncludeExclude
                    {

                    						newCompositeNode(grammarAccess.getStringFilterAccess().getIncludeExcludeIncludeExcludeParserRuleCall_0_6_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_includeExclude_6_0=ruleIncludeExclude();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFilterRule());
                    						}
                    						set(
                    							current,
                    							"includeExclude",
                    							lv_includeExclude_6_0,
                    							"xtext.json.WorkflowDSL.IncludeExclude");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getStringFilterAccess().getRightParenthesisKeyword_0_7());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2748:3: (otherlv_8= 'like' otherlv_9= '(' ( (lv_column_10_0= ruleColumn ) ) otherlv_11= ',' ( (lv_pattern_12_0= rulePattern ) ) otherlv_13= ',' ( (lv_includeExclude_14_0= ruleIncludeExclude ) ) otherlv_15= ')' )
                    {
                    // InternalWorkflowDSL.g:2748:3: (otherlv_8= 'like' otherlv_9= '(' ( (lv_column_10_0= ruleColumn ) ) otherlv_11= ',' ( (lv_pattern_12_0= rulePattern ) ) otherlv_13= ',' ( (lv_includeExclude_14_0= ruleIncludeExclude ) ) otherlv_15= ')' )
                    // InternalWorkflowDSL.g:2749:4: otherlv_8= 'like' otherlv_9= '(' ( (lv_column_10_0= ruleColumn ) ) otherlv_11= ',' ( (lv_pattern_12_0= rulePattern ) ) otherlv_13= ',' ( (lv_includeExclude_14_0= ruleIncludeExclude ) ) otherlv_15= ')'
                    {
                    otherlv_8=(Token)match(input,60,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getStringFilterAccess().getLikeKeyword_1_0());
                    			
                    otherlv_9=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getStringFilterAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:2757:4: ( (lv_column_10_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:2758:5: (lv_column_10_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:2758:5: (lv_column_10_0= ruleColumn )
                    // InternalWorkflowDSL.g:2759:6: lv_column_10_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getStringFilterAccess().getColumnColumnParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_column_10_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFilterRule());
                    						}
                    						set(
                    							current,
                    							"column",
                    							lv_column_10_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,19,FOLLOW_38); 

                    				newLeafNode(otherlv_11, grammarAccess.getStringFilterAccess().getCommaKeyword_1_3());
                    			
                    // InternalWorkflowDSL.g:2780:4: ( (lv_pattern_12_0= rulePattern ) )
                    // InternalWorkflowDSL.g:2781:5: (lv_pattern_12_0= rulePattern )
                    {
                    // InternalWorkflowDSL.g:2781:5: (lv_pattern_12_0= rulePattern )
                    // InternalWorkflowDSL.g:2782:6: lv_pattern_12_0= rulePattern
                    {

                    						newCompositeNode(grammarAccess.getStringFilterAccess().getPatternPatternParserRuleCall_1_4_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_pattern_12_0=rulePattern();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFilterRule());
                    						}
                    						set(
                    							current,
                    							"pattern",
                    							lv_pattern_12_0,
                    							"xtext.json.WorkflowDSL.Pattern");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,19,FOLLOW_35); 

                    				newLeafNode(otherlv_13, grammarAccess.getStringFilterAccess().getCommaKeyword_1_5());
                    			
                    // InternalWorkflowDSL.g:2803:4: ( (lv_includeExclude_14_0= ruleIncludeExclude ) )
                    // InternalWorkflowDSL.g:2804:5: (lv_includeExclude_14_0= ruleIncludeExclude )
                    {
                    // InternalWorkflowDSL.g:2804:5: (lv_includeExclude_14_0= ruleIncludeExclude )
                    // InternalWorkflowDSL.g:2805:6: lv_includeExclude_14_0= ruleIncludeExclude
                    {

                    						newCompositeNode(grammarAccess.getStringFilterAccess().getIncludeExcludeIncludeExcludeParserRuleCall_1_6_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_includeExclude_14_0=ruleIncludeExclude();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFilterRule());
                    						}
                    						set(
                    							current,
                    							"includeExclude",
                    							lv_includeExclude_14_0,
                    							"xtext.json.WorkflowDSL.IncludeExclude");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getStringFilterAccess().getRightParenthesisKeyword_1_7());
                    			

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
    // $ANTLR end "ruleStringFilter"


    // $ANTLR start "entryRulePattern"
    // InternalWorkflowDSL.g:2831:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalWorkflowDSL.g:2831:48: (iv_rulePattern= rulePattern EOF )
            // InternalWorkflowDSL.g:2832:2: iv_rulePattern= rulePattern EOF
            {
             newCompositeNode(grammarAccess.getPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;

             current =iv_rulePattern; 
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
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalWorkflowDSL.g:2838:1: rulePattern returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_regex_1_0= ruleRegex ) ) ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_regex_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2844:2: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_regex_1_0= ruleRegex ) ) ) )
            // InternalWorkflowDSL.g:2845:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_regex_1_0= ruleRegex ) ) )
            {
            // InternalWorkflowDSL.g:2845:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( (lv_regex_1_0= ruleRegex ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_STRING) ) {
                alt24=1;
            }
            else if ( (LA24_0==86) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalWorkflowDSL.g:2846:3: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // InternalWorkflowDSL.g:2846:3: ( (lv_value_0_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:2847:4: (lv_value_0_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:2847:4: (lv_value_0_0= RULE_STRING )
                    // InternalWorkflowDSL.g:2848:5: lv_value_0_0= RULE_STRING
                    {
                    lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_value_0_0, grammarAccess.getPatternAccess().getValueSTRINGTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPatternRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_0_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2865:3: ( (lv_regex_1_0= ruleRegex ) )
                    {
                    // InternalWorkflowDSL.g:2865:3: ( (lv_regex_1_0= ruleRegex ) )
                    // InternalWorkflowDSL.g:2866:4: (lv_regex_1_0= ruleRegex )
                    {
                    // InternalWorkflowDSL.g:2866:4: (lv_regex_1_0= ruleRegex )
                    // InternalWorkflowDSL.g:2867:5: lv_regex_1_0= ruleRegex
                    {

                    					newCompositeNode(grammarAccess.getPatternAccess().getRegexRegexParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_regex_1_0=ruleRegex();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPatternRule());
                    					}
                    					set(
                    						current,
                    						"regex",
                    						lv_regex_1_0,
                    						"xtext.json.WorkflowDSL.Regex");
                    					afterParserOrEnumRuleCall();
                    				

                    }


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
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleIncludeExclude"
    // InternalWorkflowDSL.g:2888:1: entryRuleIncludeExclude returns [String current=null] : iv_ruleIncludeExclude= ruleIncludeExclude EOF ;
    public final String entryRuleIncludeExclude() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncludeExclude = null;


        try {
            // InternalWorkflowDSL.g:2888:54: (iv_ruleIncludeExclude= ruleIncludeExclude EOF )
            // InternalWorkflowDSL.g:2889:2: iv_ruleIncludeExclude= ruleIncludeExclude EOF
            {
             newCompositeNode(grammarAccess.getIncludeExcludeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncludeExclude=ruleIncludeExclude();

            state._fsp--;

             current =iv_ruleIncludeExclude.getText(); 
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
    // $ANTLR end "entryRuleIncludeExclude"


    // $ANTLR start "ruleIncludeExclude"
    // InternalWorkflowDSL.g:2895:1: ruleIncludeExclude returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'include' | kw= 'exclude' ) ;
    public final AntlrDatatypeRuleToken ruleIncludeExclude() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:2901:2: ( (kw= 'include' | kw= 'exclude' ) )
            // InternalWorkflowDSL.g:2902:2: (kw= 'include' | kw= 'exclude' )
            {
            // InternalWorkflowDSL.g:2902:2: (kw= 'include' | kw= 'exclude' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==61) ) {
                alt25=1;
            }
            else if ( (LA25_0==62) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalWorkflowDSL.g:2903:3: kw= 'include'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIncludeExcludeAccess().getIncludeKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2909:3: kw= 'exclude'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIncludeExcludeAccess().getExcludeKeyword_1());
                    		

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
    // $ANTLR end "ruleIncludeExclude"


    // $ANTLR start "entryRuleColumnFilter"
    // InternalWorkflowDSL.g:2918:1: entryRuleColumnFilter returns [EObject current=null] : iv_ruleColumnFilter= ruleColumnFilter EOF ;
    public final EObject entryRuleColumnFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumnFilter = null;


        try {
            // InternalWorkflowDSL.g:2918:53: (iv_ruleColumnFilter= ruleColumnFilter EOF )
            // InternalWorkflowDSL.g:2919:2: iv_ruleColumnFilter= ruleColumnFilter EOF
            {
             newCompositeNode(grammarAccess.getColumnFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumnFilter=ruleColumnFilter();

            state._fsp--;

             current =iv_ruleColumnFilter; 
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
    // $ANTLR end "entryRuleColumnFilter"


    // $ANTLR start "ruleColumnFilter"
    // InternalWorkflowDSL.g:2925:1: ruleColumnFilter returns [EObject current=null] : ( (otherlv_0= 'select_columns' otherlv_1= '{' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= '}' ) | (otherlv_4= 'drop_columns' otherlv_5= '{' ( (lv_columns_6_0= ruleColumnList ) ) otherlv_7= '}' ) | (otherlv_8= 'keep' otherlv_9= '{' ( (lv_columns_10_0= ruleColumnList ) ) otherlv_11= '}' ) | (otherlv_12= 'remove' otherlv_13= '{' ( (lv_columns_14_0= ruleColumnList ) ) otherlv_15= '}' ) ) ;
    public final EObject ruleColumnFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_columns_2_0 = null;

        EObject lv_columns_6_0 = null;

        EObject lv_columns_10_0 = null;

        EObject lv_columns_14_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:2931:2: ( ( (otherlv_0= 'select_columns' otherlv_1= '{' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= '}' ) | (otherlv_4= 'drop_columns' otherlv_5= '{' ( (lv_columns_6_0= ruleColumnList ) ) otherlv_7= '}' ) | (otherlv_8= 'keep' otherlv_9= '{' ( (lv_columns_10_0= ruleColumnList ) ) otherlv_11= '}' ) | (otherlv_12= 'remove' otherlv_13= '{' ( (lv_columns_14_0= ruleColumnList ) ) otherlv_15= '}' ) ) )
            // InternalWorkflowDSL.g:2932:2: ( (otherlv_0= 'select_columns' otherlv_1= '{' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= '}' ) | (otherlv_4= 'drop_columns' otherlv_5= '{' ( (lv_columns_6_0= ruleColumnList ) ) otherlv_7= '}' ) | (otherlv_8= 'keep' otherlv_9= '{' ( (lv_columns_10_0= ruleColumnList ) ) otherlv_11= '}' ) | (otherlv_12= 'remove' otherlv_13= '{' ( (lv_columns_14_0= ruleColumnList ) ) otherlv_15= '}' ) )
            {
            // InternalWorkflowDSL.g:2932:2: ( (otherlv_0= 'select_columns' otherlv_1= '{' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= '}' ) | (otherlv_4= 'drop_columns' otherlv_5= '{' ( (lv_columns_6_0= ruleColumnList ) ) otherlv_7= '}' ) | (otherlv_8= 'keep' otherlv_9= '{' ( (lv_columns_10_0= ruleColumnList ) ) otherlv_11= '}' ) | (otherlv_12= 'remove' otherlv_13= '{' ( (lv_columns_14_0= ruleColumnList ) ) otherlv_15= '}' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt26=1;
                }
                break;
            case 64:
                {
                alt26=2;
                }
                break;
            case 65:
                {
                alt26=3;
                }
                break;
            case 66:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalWorkflowDSL.g:2933:3: (otherlv_0= 'select_columns' otherlv_1= '{' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= '}' )
                    {
                    // InternalWorkflowDSL.g:2933:3: (otherlv_0= 'select_columns' otherlv_1= '{' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= '}' )
                    // InternalWorkflowDSL.g:2934:4: otherlv_0= 'select_columns' otherlv_1= '{' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= '}'
                    {
                    otherlv_0=(Token)match(input,63,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getColumnFilterAccess().getSelect_columnsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,13,FOLLOW_34); 

                    				newLeafNode(otherlv_1, grammarAccess.getColumnFilterAccess().getLeftCurlyBracketKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:2942:4: ( (lv_columns_2_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:2943:5: (lv_columns_2_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:2943:5: (lv_columns_2_0= ruleColumnList )
                    // InternalWorkflowDSL.g:2944:6: lv_columns_2_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getColumnFilterAccess().getColumnsColumnListParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_columns_2_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColumnFilterRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_2_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getColumnFilterAccess().getRightCurlyBracketKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:2967:3: (otherlv_4= 'drop_columns' otherlv_5= '{' ( (lv_columns_6_0= ruleColumnList ) ) otherlv_7= '}' )
                    {
                    // InternalWorkflowDSL.g:2967:3: (otherlv_4= 'drop_columns' otherlv_5= '{' ( (lv_columns_6_0= ruleColumnList ) ) otherlv_7= '}' )
                    // InternalWorkflowDSL.g:2968:4: otherlv_4= 'drop_columns' otherlv_5= '{' ( (lv_columns_6_0= ruleColumnList ) ) otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,64,FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getColumnFilterAccess().getDrop_columnsKeyword_1_0());
                    			
                    otherlv_5=(Token)match(input,13,FOLLOW_34); 

                    				newLeafNode(otherlv_5, grammarAccess.getColumnFilterAccess().getLeftCurlyBracketKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:2976:4: ( (lv_columns_6_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:2977:5: (lv_columns_6_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:2977:5: (lv_columns_6_0= ruleColumnList )
                    // InternalWorkflowDSL.g:2978:6: lv_columns_6_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getColumnFilterAccess().getColumnsColumnListParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_columns_6_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColumnFilterRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_6_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getColumnFilterAccess().getRightCurlyBracketKeyword_1_3());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:3001:3: (otherlv_8= 'keep' otherlv_9= '{' ( (lv_columns_10_0= ruleColumnList ) ) otherlv_11= '}' )
                    {
                    // InternalWorkflowDSL.g:3001:3: (otherlv_8= 'keep' otherlv_9= '{' ( (lv_columns_10_0= ruleColumnList ) ) otherlv_11= '}' )
                    // InternalWorkflowDSL.g:3002:4: otherlv_8= 'keep' otherlv_9= '{' ( (lv_columns_10_0= ruleColumnList ) ) otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,65,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getColumnFilterAccess().getKeepKeyword_2_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_34); 

                    				newLeafNode(otherlv_9, grammarAccess.getColumnFilterAccess().getLeftCurlyBracketKeyword_2_1());
                    			
                    // InternalWorkflowDSL.g:3010:4: ( (lv_columns_10_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:3011:5: (lv_columns_10_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:3011:5: (lv_columns_10_0= ruleColumnList )
                    // InternalWorkflowDSL.g:3012:6: lv_columns_10_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getColumnFilterAccess().getColumnsColumnListParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_columns_10_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColumnFilterRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_10_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getColumnFilterAccess().getRightCurlyBracketKeyword_2_3());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:3035:3: (otherlv_12= 'remove' otherlv_13= '{' ( (lv_columns_14_0= ruleColumnList ) ) otherlv_15= '}' )
                    {
                    // InternalWorkflowDSL.g:3035:3: (otherlv_12= 'remove' otherlv_13= '{' ( (lv_columns_14_0= ruleColumnList ) ) otherlv_15= '}' )
                    // InternalWorkflowDSL.g:3036:4: otherlv_12= 'remove' otherlv_13= '{' ( (lv_columns_14_0= ruleColumnList ) ) otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,66,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getColumnFilterAccess().getRemoveKeyword_3_0());
                    			
                    otherlv_13=(Token)match(input,13,FOLLOW_34); 

                    				newLeafNode(otherlv_13, grammarAccess.getColumnFilterAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalWorkflowDSL.g:3044:4: ( (lv_columns_14_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:3045:5: (lv_columns_14_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:3045:5: (lv_columns_14_0= ruleColumnList )
                    // InternalWorkflowDSL.g:3046:6: lv_columns_14_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getColumnFilterAccess().getColumnsColumnListParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_columns_14_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColumnFilterRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_14_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getColumnFilterAccess().getRightCurlyBracketKeyword_3_3());
                    			

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
    // $ANTLR end "ruleColumnFilter"


    // $ANTLR start "entryRuleMapping"
    // InternalWorkflowDSL.g:3072:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // InternalWorkflowDSL.g:3072:48: (iv_ruleMapping= ruleMapping EOF )
            // InternalWorkflowDSL.g:3073:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
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
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // InternalWorkflowDSL.g:3079:1: ruleMapping returns [EObject current=null] : (this_ValueMapping_0= ruleValueMapping | this_SubstringMapping_1= ruleSubstringMapping ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        EObject this_ValueMapping_0 = null;

        EObject this_SubstringMapping_1 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3085:2: ( (this_ValueMapping_0= ruleValueMapping | this_SubstringMapping_1= ruleSubstringMapping ) )
            // InternalWorkflowDSL.g:3086:2: (this_ValueMapping_0= ruleValueMapping | this_SubstringMapping_1= ruleSubstringMapping )
            {
            // InternalWorkflowDSL.g:3086:2: (this_ValueMapping_0= ruleValueMapping | this_SubstringMapping_1= ruleSubstringMapping )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==67) ) {
                alt27=1;
            }
            else if ( (LA27_0==70) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalWorkflowDSL.g:3087:3: this_ValueMapping_0= ruleValueMapping
                    {

                    			newCompositeNode(grammarAccess.getMappingAccess().getValueMappingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValueMapping_0=ruleValueMapping();

                    state._fsp--;


                    			current = this_ValueMapping_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:3096:3: this_SubstringMapping_1= ruleSubstringMapping
                    {

                    			newCompositeNode(grammarAccess.getMappingAccess().getSubstringMappingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubstringMapping_1=ruleSubstringMapping();

                    state._fsp--;


                    			current = this_SubstringMapping_1;
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
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleValueMapping"
    // InternalWorkflowDSL.g:3108:1: entryRuleValueMapping returns [EObject current=null] : iv_ruleValueMapping= ruleValueMapping EOF ;
    public final EObject entryRuleValueMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueMapping = null;


        try {
            // InternalWorkflowDSL.g:3108:53: (iv_ruleValueMapping= ruleValueMapping EOF )
            // InternalWorkflowDSL.g:3109:2: iv_ruleValueMapping= ruleValueMapping EOF
            {
             newCompositeNode(grammarAccess.getValueMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueMapping=ruleValueMapping();

            state._fsp--;

             current =iv_ruleValueMapping; 
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
    // $ANTLR end "entryRuleValueMapping"


    // $ANTLR start "ruleValueMapping"
    // InternalWorkflowDSL.g:3115:1: ruleValueMapping returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_rules_5_0= ruleMappingRules ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleMappingMode ) ) ) ;
    public final EObject ruleValueMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_column_2_0 = null;

        EObject lv_rules_5_0 = null;

        EObject lv_mode_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3121:2: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_rules_5_0= ruleMappingRules ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleMappingMode ) ) ) )
            // InternalWorkflowDSL.g:3122:2: (otherlv_0= 'map' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_rules_5_0= ruleMappingRules ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleMappingMode ) ) )
            {
            // InternalWorkflowDSL.g:3122:2: (otherlv_0= 'map' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_rules_5_0= ruleMappingRules ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleMappingMode ) ) )
            // InternalWorkflowDSL.g:3123:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_rules_5_0= ruleMappingRules ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleMappingMode ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getValueMappingAccess().getMapKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getValueMappingAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:3131:3: ( (lv_column_2_0= ruleColumn ) )
            // InternalWorkflowDSL.g:3132:4: (lv_column_2_0= ruleColumn )
            {
            // InternalWorkflowDSL.g:3132:4: (lv_column_2_0= ruleColumn )
            // InternalWorkflowDSL.g:3133:5: lv_column_2_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getValueMappingAccess().getColumnColumnParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_column_2_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValueMappingRule());
            					}
            					set(
            						current,
            						"column",
            						lv_column_2_0,
            						"xtext.json.WorkflowDSL.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getValueMappingAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_39); 

            			newLeafNode(otherlv_4, grammarAccess.getValueMappingAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflowDSL.g:3158:3: ( (lv_rules_5_0= ruleMappingRules ) )
            // InternalWorkflowDSL.g:3159:4: (lv_rules_5_0= ruleMappingRules )
            {
            // InternalWorkflowDSL.g:3159:4: (lv_rules_5_0= ruleMappingRules )
            // InternalWorkflowDSL.g:3160:5: lv_rules_5_0= ruleMappingRules
            {

            					newCompositeNode(grammarAccess.getValueMappingAccess().getRulesMappingRulesParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_rules_5_0=ruleMappingRules();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValueMappingRule());
            					}
            					set(
            						current,
            						"rules",
            						lv_rules_5_0,
            						"xtext.json.WorkflowDSL.MappingRules");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_40); 

            			newLeafNode(otherlv_6, grammarAccess.getValueMappingAccess().getRightCurlyBracketKeyword_6());
            		
            // InternalWorkflowDSL.g:3181:3: ( (lv_mode_7_0= ruleMappingMode ) )
            // InternalWorkflowDSL.g:3182:4: (lv_mode_7_0= ruleMappingMode )
            {
            // InternalWorkflowDSL.g:3182:4: (lv_mode_7_0= ruleMappingMode )
            // InternalWorkflowDSL.g:3183:5: lv_mode_7_0= ruleMappingMode
            {

            					newCompositeNode(grammarAccess.getValueMappingAccess().getModeMappingModeParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_mode_7_0=ruleMappingMode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getValueMappingRule());
            					}
            					set(
            						current,
            						"mode",
            						lv_mode_7_0,
            						"xtext.json.WorkflowDSL.MappingMode");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleValueMapping"


    // $ANTLR start "entryRuleMappingRules"
    // InternalWorkflowDSL.g:3204:1: entryRuleMappingRules returns [EObject current=null] : iv_ruleMappingRules= ruleMappingRules EOF ;
    public final EObject entryRuleMappingRules() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingRules = null;


        try {
            // InternalWorkflowDSL.g:3204:53: (iv_ruleMappingRules= ruleMappingRules EOF )
            // InternalWorkflowDSL.g:3205:2: iv_ruleMappingRules= ruleMappingRules EOF
            {
             newCompositeNode(grammarAccess.getMappingRulesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingRules=ruleMappingRules();

            state._fsp--;

             current =iv_ruleMappingRules; 
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
    // $ANTLR end "entryRuleMappingRules"


    // $ANTLR start "ruleMappingRules"
    // InternalWorkflowDSL.g:3211:1: ruleMappingRules returns [EObject current=null] : ( ( (lv_rules_0_0= ruleMappingRule ) ) (otherlv_1= ',' ( (lv_rules_2_0= ruleMappingRule ) ) )* )? ;
    public final EObject ruleMappingRules() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_rules_0_0 = null;

        EObject lv_rules_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3217:2: ( ( ( (lv_rules_0_0= ruleMappingRule ) ) (otherlv_1= ',' ( (lv_rules_2_0= ruleMappingRule ) ) )* )? )
            // InternalWorkflowDSL.g:3218:2: ( ( (lv_rules_0_0= ruleMappingRule ) ) (otherlv_1= ',' ( (lv_rules_2_0= ruleMappingRule ) ) )* )?
            {
            // InternalWorkflowDSL.g:3218:2: ( ( (lv_rules_0_0= ruleMappingRule ) ) (otherlv_1= ',' ( (lv_rules_2_0= ruleMappingRule ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_STRING||LA29_0==86) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalWorkflowDSL.g:3219:3: ( (lv_rules_0_0= ruleMappingRule ) ) (otherlv_1= ',' ( (lv_rules_2_0= ruleMappingRule ) ) )*
                    {
                    // InternalWorkflowDSL.g:3219:3: ( (lv_rules_0_0= ruleMappingRule ) )
                    // InternalWorkflowDSL.g:3220:4: (lv_rules_0_0= ruleMappingRule )
                    {
                    // InternalWorkflowDSL.g:3220:4: (lv_rules_0_0= ruleMappingRule )
                    // InternalWorkflowDSL.g:3221:5: lv_rules_0_0= ruleMappingRule
                    {

                    					newCompositeNode(grammarAccess.getMappingRulesAccess().getRulesMappingRuleParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_41);
                    lv_rules_0_0=ruleMappingRule();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMappingRulesRule());
                    					}
                    					add(
                    						current,
                    						"rules",
                    						lv_rules_0_0,
                    						"xtext.json.WorkflowDSL.MappingRule");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }

                    // InternalWorkflowDSL.g:3238:3: (otherlv_1= ',' ( (lv_rules_2_0= ruleMappingRule ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==19) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalWorkflowDSL.g:3239:4: otherlv_1= ',' ( (lv_rules_2_0= ruleMappingRule ) )
                    	    {
                    	    otherlv_1=(Token)match(input,19,FOLLOW_38); 

                    	    				newLeafNode(otherlv_1, grammarAccess.getMappingRulesAccess().getCommaKeyword_1_0());
                    	    			
                    	    // InternalWorkflowDSL.g:3243:4: ( (lv_rules_2_0= ruleMappingRule ) )
                    	    // InternalWorkflowDSL.g:3244:5: (lv_rules_2_0= ruleMappingRule )
                    	    {
                    	    // InternalWorkflowDSL.g:3244:5: (lv_rules_2_0= ruleMappingRule )
                    	    // InternalWorkflowDSL.g:3245:6: lv_rules_2_0= ruleMappingRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getMappingRulesAccess().getRulesMappingRuleParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_41);
                    	    lv_rules_2_0=ruleMappingRule();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMappingRulesRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"rules",
                    	    							lv_rules_2_0,
                    	    							"xtext.json.WorkflowDSL.MappingRule");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


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
    // $ANTLR end "ruleMappingRules"


    // $ANTLR start "entryRuleMappingRule"
    // InternalWorkflowDSL.g:3267:1: entryRuleMappingRule returns [EObject current=null] : iv_ruleMappingRule= ruleMappingRule EOF ;
    public final EObject entryRuleMappingRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingRule = null;


        try {
            // InternalWorkflowDSL.g:3267:52: (iv_ruleMappingRule= ruleMappingRule EOF )
            // InternalWorkflowDSL.g:3268:2: iv_ruleMappingRule= ruleMappingRule EOF
            {
             newCompositeNode(grammarAccess.getMappingRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingRule=ruleMappingRule();

            state._fsp--;

             current =iv_ruleMappingRule; 
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
    // $ANTLR end "entryRuleMappingRule"


    // $ANTLR start "ruleMappingRule"
    // InternalWorkflowDSL.g:3274:1: ruleMappingRule returns [EObject current=null] : ( ( ( (lv_from_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_to_2_0= RULE_STRING ) ) ) | ( ( (lv_pattern_3_0= rulePattern ) ) otherlv_4= '=>' ( (lv_to_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleMappingRule() throws RecognitionException {
        EObject current = null;

        Token lv_from_0_0=null;
        Token otherlv_1=null;
        Token lv_to_2_0=null;
        Token otherlv_4=null;
        Token lv_to_5_0=null;
        EObject lv_pattern_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3280:2: ( ( ( ( (lv_from_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_to_2_0= RULE_STRING ) ) ) | ( ( (lv_pattern_3_0= rulePattern ) ) otherlv_4= '=>' ( (lv_to_5_0= RULE_STRING ) ) ) ) )
            // InternalWorkflowDSL.g:3281:2: ( ( ( (lv_from_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_to_2_0= RULE_STRING ) ) ) | ( ( (lv_pattern_3_0= rulePattern ) ) otherlv_4= '=>' ( (lv_to_5_0= RULE_STRING ) ) ) )
            {
            // InternalWorkflowDSL.g:3281:2: ( ( ( (lv_from_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_to_2_0= RULE_STRING ) ) ) | ( ( (lv_pattern_3_0= rulePattern ) ) otherlv_4= '=>' ( (lv_to_5_0= RULE_STRING ) ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_STRING) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==68) ) {
                    alt30=1;
                }
                else if ( (LA30_1==69) ) {
                    alt30=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA30_0==86) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalWorkflowDSL.g:3282:3: ( ( (lv_from_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_to_2_0= RULE_STRING ) ) )
                    {
                    // InternalWorkflowDSL.g:3282:3: ( ( (lv_from_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_to_2_0= RULE_STRING ) ) )
                    // InternalWorkflowDSL.g:3283:4: ( (lv_from_0_0= RULE_STRING ) ) otherlv_1= '->' ( (lv_to_2_0= RULE_STRING ) )
                    {
                    // InternalWorkflowDSL.g:3283:4: ( (lv_from_0_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:3284:5: (lv_from_0_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:3284:5: (lv_from_0_0= RULE_STRING )
                    // InternalWorkflowDSL.g:3285:6: lv_from_0_0= RULE_STRING
                    {
                    lv_from_0_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

                    						newLeafNode(lv_from_0_0, grammarAccess.getMappingRuleAccess().getFromSTRINGTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMappingRuleRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"from",
                    							lv_from_0_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,68,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getMappingRuleAccess().getHyphenMinusGreaterThanSignKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:3305:4: ( (lv_to_2_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:3306:5: (lv_to_2_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:3306:5: (lv_to_2_0= RULE_STRING )
                    // InternalWorkflowDSL.g:3307:6: lv_to_2_0= RULE_STRING
                    {
                    lv_to_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_to_2_0, grammarAccess.getMappingRuleAccess().getToSTRINGTerminalRuleCall_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMappingRuleRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"to",
                    							lv_to_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:3325:3: ( ( (lv_pattern_3_0= rulePattern ) ) otherlv_4= '=>' ( (lv_to_5_0= RULE_STRING ) ) )
                    {
                    // InternalWorkflowDSL.g:3325:3: ( ( (lv_pattern_3_0= rulePattern ) ) otherlv_4= '=>' ( (lv_to_5_0= RULE_STRING ) ) )
                    // InternalWorkflowDSL.g:3326:4: ( (lv_pattern_3_0= rulePattern ) ) otherlv_4= '=>' ( (lv_to_5_0= RULE_STRING ) )
                    {
                    // InternalWorkflowDSL.g:3326:4: ( (lv_pattern_3_0= rulePattern ) )
                    // InternalWorkflowDSL.g:3327:5: (lv_pattern_3_0= rulePattern )
                    {
                    // InternalWorkflowDSL.g:3327:5: (lv_pattern_3_0= rulePattern )
                    // InternalWorkflowDSL.g:3328:6: lv_pattern_3_0= rulePattern
                    {

                    						newCompositeNode(grammarAccess.getMappingRuleAccess().getPatternPatternParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_pattern_3_0=rulePattern();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMappingRuleRule());
                    						}
                    						set(
                    							current,
                    							"pattern",
                    							lv_pattern_3_0,
                    							"xtext.json.WorkflowDSL.Pattern");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,69,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getMappingRuleAccess().getEqualsSignGreaterThanSignKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:3349:4: ( (lv_to_5_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:3350:5: (lv_to_5_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:3350:5: (lv_to_5_0= RULE_STRING )
                    // InternalWorkflowDSL.g:3351:6: lv_to_5_0= RULE_STRING
                    {
                    lv_to_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_to_5_0, grammarAccess.getMappingRuleAccess().getToSTRINGTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMappingRuleRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"to",
                    							lv_to_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


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
    // $ANTLR end "ruleMappingRule"


    // $ANTLR start "entryRuleSubstringMapping"
    // InternalWorkflowDSL.g:3372:1: entryRuleSubstringMapping returns [EObject current=null] : iv_ruleSubstringMapping= ruleSubstringMapping EOF ;
    public final EObject entryRuleSubstringMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstringMapping = null;


        try {
            // InternalWorkflowDSL.g:3372:57: (iv_ruleSubstringMapping= ruleSubstringMapping EOF )
            // InternalWorkflowDSL.g:3373:2: iv_ruleSubstringMapping= ruleSubstringMapping EOF
            {
             newCompositeNode(grammarAccess.getSubstringMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubstringMapping=ruleSubstringMapping();

            state._fsp--;

             current =iv_ruleSubstringMapping; 
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
    // $ANTLR end "entryRuleSubstringMapping"


    // $ANTLR start "ruleSubstringMapping"
    // InternalWorkflowDSL.g:3379:1: ruleSubstringMapping returns [EObject current=null] : (otherlv_0= 'replace' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_from_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_to_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_mode_8_0= ruleMappingMode ) ) ) ;
    public final EObject ruleSubstringMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_from_4_0=null;
        Token otherlv_5=null;
        Token lv_to_6_0=null;
        Token otherlv_7=null;
        EObject lv_column_2_0 = null;

        EObject lv_mode_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3385:2: ( (otherlv_0= 'replace' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_from_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_to_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_mode_8_0= ruleMappingMode ) ) ) )
            // InternalWorkflowDSL.g:3386:2: (otherlv_0= 'replace' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_from_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_to_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_mode_8_0= ruleMappingMode ) ) )
            {
            // InternalWorkflowDSL.g:3386:2: (otherlv_0= 'replace' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_from_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_to_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_mode_8_0= ruleMappingMode ) ) )
            // InternalWorkflowDSL.g:3387:3: otherlv_0= 'replace' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ',' ( (lv_from_4_0= RULE_STRING ) ) otherlv_5= ',' ( (lv_to_6_0= RULE_STRING ) ) otherlv_7= ')' ( (lv_mode_8_0= ruleMappingMode ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getSubstringMappingAccess().getReplaceKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getSubstringMappingAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:3395:3: ( (lv_column_2_0= ruleColumn ) )
            // InternalWorkflowDSL.g:3396:4: (lv_column_2_0= ruleColumn )
            {
            // InternalWorkflowDSL.g:3396:4: (lv_column_2_0= ruleColumn )
            // InternalWorkflowDSL.g:3397:5: lv_column_2_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getSubstringMappingAccess().getColumnColumnParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_column_2_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubstringMappingRule());
            					}
            					set(
            						current,
            						"column",
            						lv_column_2_0,
            						"xtext.json.WorkflowDSL.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getSubstringMappingAccess().getCommaKeyword_3());
            		
            // InternalWorkflowDSL.g:3418:3: ( (lv_from_4_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:3419:4: (lv_from_4_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:3419:4: (lv_from_4_0= RULE_STRING )
            // InternalWorkflowDSL.g:3420:5: lv_from_4_0= RULE_STRING
            {
            lv_from_4_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

            					newLeafNode(lv_from_4_0, grammarAccess.getSubstringMappingAccess().getFromSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubstringMappingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"from",
            						lv_from_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getSubstringMappingAccess().getCommaKeyword_5());
            		
            // InternalWorkflowDSL.g:3440:3: ( (lv_to_6_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:3441:4: (lv_to_6_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:3441:4: (lv_to_6_0= RULE_STRING )
            // InternalWorkflowDSL.g:3442:5: lv_to_6_0= RULE_STRING
            {
            lv_to_6_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_to_6_0, grammarAccess.getSubstringMappingAccess().getToSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubstringMappingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"to",
            						lv_to_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_40); 

            			newLeafNode(otherlv_7, grammarAccess.getSubstringMappingAccess().getRightParenthesisKeyword_7());
            		
            // InternalWorkflowDSL.g:3462:3: ( (lv_mode_8_0= ruleMappingMode ) )
            // InternalWorkflowDSL.g:3463:4: (lv_mode_8_0= ruleMappingMode )
            {
            // InternalWorkflowDSL.g:3463:4: (lv_mode_8_0= ruleMappingMode )
            // InternalWorkflowDSL.g:3464:5: lv_mode_8_0= ruleMappingMode
            {

            					newCompositeNode(grammarAccess.getSubstringMappingAccess().getModeMappingModeParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_2);
            lv_mode_8_0=ruleMappingMode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubstringMappingRule());
            					}
            					set(
            						current,
            						"mode",
            						lv_mode_8_0,
            						"xtext.json.WorkflowDSL.MappingMode");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleSubstringMapping"


    // $ANTLR start "entryRuleMappingMode"
    // InternalWorkflowDSL.g:3485:1: entryRuleMappingMode returns [EObject current=null] : iv_ruleMappingMode= ruleMappingMode EOF ;
    public final EObject entryRuleMappingMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingMode = null;


        try {
            // InternalWorkflowDSL.g:3485:52: (iv_ruleMappingMode= ruleMappingMode EOF )
            // InternalWorkflowDSL.g:3486:2: iv_ruleMappingMode= ruleMappingMode EOF
            {
             newCompositeNode(grammarAccess.getMappingModeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingMode=ruleMappingMode();

            state._fsp--;

             current =iv_ruleMappingMode; 
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
    // $ANTLR end "entryRuleMappingMode"


    // $ANTLR start "ruleMappingMode"
    // InternalWorkflowDSL.g:3492:1: ruleMappingMode returns [EObject current=null] : (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) ) ;
    public final EObject ruleMappingMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_newName_2_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:3498:2: ( (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) ) )
            // InternalWorkflowDSL.g:3499:2: (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) )
            {
            // InternalWorkflowDSL.g:3499:2: (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==70) ) {
                alt31=1;
            }
            else if ( (LA31_0==71) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalWorkflowDSL.g:3500:3: otherlv_0= 'replace'
                    {
                    otherlv_0=(Token)match(input,70,FOLLOW_2); 

                    			newLeafNode(otherlv_0, grammarAccess.getMappingModeAccess().getReplaceKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:3505:3: (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) )
                    {
                    // InternalWorkflowDSL.g:3505:3: (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) )
                    // InternalWorkflowDSL.g:3506:4: otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,71,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getMappingModeAccess().getAsKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:3510:4: ( (lv_newName_2_0= RULE_ID ) )
                    // InternalWorkflowDSL.g:3511:5: (lv_newName_2_0= RULE_ID )
                    {
                    // InternalWorkflowDSL.g:3511:5: (lv_newName_2_0= RULE_ID )
                    // InternalWorkflowDSL.g:3512:6: lv_newName_2_0= RULE_ID
                    {
                    lv_newName_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(lv_newName_2_0, grammarAccess.getMappingModeAccess().getNewNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMappingModeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"newName",
                    							lv_newName_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


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
    // $ANTLR end "ruleMappingMode"


    // $ANTLR start "entryRuleMathOp"
    // InternalWorkflowDSL.g:3533:1: entryRuleMathOp returns [EObject current=null] : iv_ruleMathOp= ruleMathOp EOF ;
    public final EObject entryRuleMathOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathOp = null;


        try {
            // InternalWorkflowDSL.g:3533:47: (iv_ruleMathOp= ruleMathOp EOF )
            // InternalWorkflowDSL.g:3534:2: iv_ruleMathOp= ruleMathOp EOF
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
    // InternalWorkflowDSL.g:3540:1: ruleMathOp returns [EObject current=null] : (otherlv_0= 'math' otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' otherlv_4= 'as' ( (lv_newName_5_0= RULE_ID ) ) ) ;
    public final EObject ruleMathOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_newName_5_0=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3546:2: ( (otherlv_0= 'math' otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' otherlv_4= 'as' ( (lv_newName_5_0= RULE_ID ) ) ) )
            // InternalWorkflowDSL.g:3547:2: (otherlv_0= 'math' otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' otherlv_4= 'as' ( (lv_newName_5_0= RULE_ID ) ) )
            {
            // InternalWorkflowDSL.g:3547:2: (otherlv_0= 'math' otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' otherlv_4= 'as' ( (lv_newName_5_0= RULE_ID ) ) )
            // InternalWorkflowDSL.g:3548:3: otherlv_0= 'math' otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' otherlv_4= 'as' ( (lv_newName_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getMathOpAccess().getMathKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getMathOpAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:3556:3: ( (lv_expression_2_0= ruleMathExpression ) )
            // InternalWorkflowDSL.g:3557:4: (lv_expression_2_0= ruleMathExpression )
            {
            // InternalWorkflowDSL.g:3557:4: (lv_expression_2_0= ruleMathExpression )
            // InternalWorkflowDSL.g:3558:5: lv_expression_2_0= ruleMathExpression
            {

            					newCompositeNode(grammarAccess.getMathOpAccess().getExpressionMathExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_expression_2_0=ruleMathExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathOpRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"xtext.json.WorkflowDSL.MathExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_45); 

            			newLeafNode(otherlv_3, grammarAccess.getMathOpAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,71,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getMathOpAccess().getAsKeyword_4());
            		
            // InternalWorkflowDSL.g:3583:3: ( (lv_newName_5_0= RULE_ID ) )
            // InternalWorkflowDSL.g:3584:4: (lv_newName_5_0= RULE_ID )
            {
            // InternalWorkflowDSL.g:3584:4: (lv_newName_5_0= RULE_ID )
            // InternalWorkflowDSL.g:3585:5: lv_newName_5_0= RULE_ID
            {
            lv_newName_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_newName_5_0, grammarAccess.getMathOpAccess().getNewNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMathOpRule());
            					}
            					setWithLastConsumed(
            						current,
            						"newName",
            						lv_newName_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleMathOp"


    // $ANTLR start "entryRuleMathExpression"
    // InternalWorkflowDSL.g:3605:1: entryRuleMathExpression returns [EObject current=null] : iv_ruleMathExpression= ruleMathExpression EOF ;
    public final EObject entryRuleMathExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathExpression = null;


        try {
            // InternalWorkflowDSL.g:3605:55: (iv_ruleMathExpression= ruleMathExpression EOF )
            // InternalWorkflowDSL.g:3606:2: iv_ruleMathExpression= ruleMathExpression EOF
            {
             newCompositeNode(grammarAccess.getMathExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathExpression=ruleMathExpression();

            state._fsp--;

             current =iv_ruleMathExpression; 
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
    // $ANTLR end "entryRuleMathExpression"


    // $ANTLR start "ruleMathExpression"
    // InternalWorkflowDSL.g:3612:1: ruleMathExpression returns [EObject current=null] : (this_Primary_0= rulePrimary ( ( (lv_operator_1_0= ruleOperator ) ) ( (lv_right_2_0= rulePrimary ) ) )* ) ;
    public final EObject ruleMathExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Primary_0 = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3618:2: ( (this_Primary_0= rulePrimary ( ( (lv_operator_1_0= ruleOperator ) ) ( (lv_right_2_0= rulePrimary ) ) )* ) )
            // InternalWorkflowDSL.g:3619:2: (this_Primary_0= rulePrimary ( ( (lv_operator_1_0= ruleOperator ) ) ( (lv_right_2_0= rulePrimary ) ) )* )
            {
            // InternalWorkflowDSL.g:3619:2: (this_Primary_0= rulePrimary ( ( (lv_operator_1_0= ruleOperator ) ) ( (lv_right_2_0= rulePrimary ) ) )* )
            // InternalWorkflowDSL.g:3620:3: this_Primary_0= rulePrimary ( ( (lv_operator_1_0= ruleOperator ) ) ( (lv_right_2_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getMathExpressionAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_46);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalWorkflowDSL.g:3628:3: ( ( (lv_operator_1_0= ruleOperator ) ) ( (lv_right_2_0= rulePrimary ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==57||(LA32_0>=84 && LA32_0<=88)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalWorkflowDSL.g:3629:4: ( (lv_operator_1_0= ruleOperator ) ) ( (lv_right_2_0= rulePrimary ) )
            	    {
            	    // InternalWorkflowDSL.g:3629:4: ( (lv_operator_1_0= ruleOperator ) )
            	    // InternalWorkflowDSL.g:3630:5: (lv_operator_1_0= ruleOperator )
            	    {
            	    // InternalWorkflowDSL.g:3630:5: (lv_operator_1_0= ruleOperator )
            	    // InternalWorkflowDSL.g:3631:6: lv_operator_1_0= ruleOperator
            	    {

            	    						newCompositeNode(grammarAccess.getMathExpressionAccess().getOperatorOperatorParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_44);
            	    lv_operator_1_0=ruleOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMathExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"operator",
            	    							lv_operator_1_0,
            	    							"xtext.json.WorkflowDSL.Operator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalWorkflowDSL.g:3648:4: ( (lv_right_2_0= rulePrimary ) )
            	    // InternalWorkflowDSL.g:3649:5: (lv_right_2_0= rulePrimary )
            	    {
            	    // InternalWorkflowDSL.g:3649:5: (lv_right_2_0= rulePrimary )
            	    // InternalWorkflowDSL.g:3650:6: lv_right_2_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getMathExpressionAccess().getRightPrimaryParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
            	    lv_right_2_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMathExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_2_0,
            	    							"xtext.json.WorkflowDSL.Primary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


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
    // $ANTLR end "ruleMathExpression"


    // $ANTLR start "entryRulePrimary"
    // InternalWorkflowDSL.g:3672:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalWorkflowDSL.g:3672:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalWorkflowDSL.g:3673:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalWorkflowDSL.g:3679:1: rulePrimary returns [EObject current=null] : ( ( (lv_operand_0_0= ruleOperand ) ) | (otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' ) | ( (lv_call_4_0= ruleFunctionCall ) ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_operand_0_0 = null;

        EObject lv_expression_2_0 = null;

        EObject lv_call_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3685:2: ( ( ( (lv_operand_0_0= ruleOperand ) ) | (otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' ) | ( (lv_call_4_0= ruleFunctionCall ) ) ) )
            // InternalWorkflowDSL.g:3686:2: ( ( (lv_operand_0_0= ruleOperand ) ) | (otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' ) | ( (lv_call_4_0= ruleFunctionCall ) ) )
            {
            // InternalWorkflowDSL.g:3686:2: ( ( (lv_operand_0_0= ruleOperand ) ) | (otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' ) | ( (lv_call_4_0= ruleFunctionCall ) ) )
            int alt33=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 32:
                {
                alt33=1;
                }
                break;
            case 18:
                {
                alt33=2;
                }
                break;
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
                {
                alt33=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalWorkflowDSL.g:3687:3: ( (lv_operand_0_0= ruleOperand ) )
                    {
                    // InternalWorkflowDSL.g:3687:3: ( (lv_operand_0_0= ruleOperand ) )
                    // InternalWorkflowDSL.g:3688:4: (lv_operand_0_0= ruleOperand )
                    {
                    // InternalWorkflowDSL.g:3688:4: (lv_operand_0_0= ruleOperand )
                    // InternalWorkflowDSL.g:3689:5: lv_operand_0_0= ruleOperand
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getOperandOperandParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_operand_0_0=ruleOperand();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    					}
                    					set(
                    						current,
                    						"operand",
                    						lv_operand_0_0,
                    						"xtext.json.WorkflowDSL.Operand");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:3707:3: (otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' )
                    {
                    // InternalWorkflowDSL.g:3707:3: (otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')' )
                    // InternalWorkflowDSL.g:3708:4: otherlv_1= '(' ( (lv_expression_2_0= ruleMathExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_44); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:3712:4: ( (lv_expression_2_0= ruleMathExpression ) )
                    // InternalWorkflowDSL.g:3713:5: (lv_expression_2_0= ruleMathExpression )
                    {
                    // InternalWorkflowDSL.g:3713:5: (lv_expression_2_0= ruleMathExpression )
                    // InternalWorkflowDSL.g:3714:6: lv_expression_2_0= ruleMathExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionMathExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_expression_2_0=ruleMathExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_2_0,
                    							"xtext.json.WorkflowDSL.MathExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_1_2());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:3737:3: ( (lv_call_4_0= ruleFunctionCall ) )
                    {
                    // InternalWorkflowDSL.g:3737:3: ( (lv_call_4_0= ruleFunctionCall ) )
                    // InternalWorkflowDSL.g:3738:4: (lv_call_4_0= ruleFunctionCall )
                    {
                    // InternalWorkflowDSL.g:3738:4: (lv_call_4_0= ruleFunctionCall )
                    // InternalWorkflowDSL.g:3739:5: lv_call_4_0= ruleFunctionCall
                    {

                    					newCompositeNode(grammarAccess.getPrimaryAccess().getCallFunctionCallParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_call_4_0=ruleFunctionCall();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    					}
                    					set(
                    						current,
                    						"call",
                    						lv_call_4_0,
                    						"xtext.json.WorkflowDSL.FunctionCall");
                    					afterParserOrEnumRuleCall();
                    				

                    }


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
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalWorkflowDSL.g:3760:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalWorkflowDSL.g:3760:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalWorkflowDSL.g:3761:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
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
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalWorkflowDSL.g:3767:1: ruleFunctionCall returns [EObject current=null] : ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '(' ( ( (lv_operands_2_0= ruleOperand ) ) (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_function_0_0 = null;

        EObject lv_operands_2_0 = null;

        EObject lv_operands_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3773:2: ( ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '(' ( ( (lv_operands_2_0= ruleOperand ) ) (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )* )? otherlv_5= ')' ) )
            // InternalWorkflowDSL.g:3774:2: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '(' ( ( (lv_operands_2_0= ruleOperand ) ) (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )* )? otherlv_5= ')' )
            {
            // InternalWorkflowDSL.g:3774:2: ( ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '(' ( ( (lv_operands_2_0= ruleOperand ) ) (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )* )? otherlv_5= ')' )
            // InternalWorkflowDSL.g:3775:3: ( (lv_function_0_0= ruleFunction ) ) otherlv_1= '(' ( ( (lv_operands_2_0= ruleOperand ) ) (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )* )? otherlv_5= ')'
            {
            // InternalWorkflowDSL.g:3775:3: ( (lv_function_0_0= ruleFunction ) )
            // InternalWorkflowDSL.g:3776:4: (lv_function_0_0= ruleFunction )
            {
            // InternalWorkflowDSL.g:3776:4: (lv_function_0_0= ruleFunction )
            // InternalWorkflowDSL.g:3777:5: lv_function_0_0= ruleFunction
            {

            					newCompositeNode(grammarAccess.getFunctionCallAccess().getFunctionFunctionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_function_0_0=ruleFunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionCallRule());
            					}
            					set(
            						current,
            						"function",
            						lv_function_0_0,
            						"xtext.json.WorkflowDSL.Function");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:3798:3: ( ( (lv_operands_2_0= ruleOperand ) ) (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_INT)||LA35_0==32) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalWorkflowDSL.g:3799:4: ( (lv_operands_2_0= ruleOperand ) ) (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )*
                    {
                    // InternalWorkflowDSL.g:3799:4: ( (lv_operands_2_0= ruleOperand ) )
                    // InternalWorkflowDSL.g:3800:5: (lv_operands_2_0= ruleOperand )
                    {
                    // InternalWorkflowDSL.g:3800:5: (lv_operands_2_0= ruleOperand )
                    // InternalWorkflowDSL.g:3801:6: lv_operands_2_0= ruleOperand
                    {

                    						newCompositeNode(grammarAccess.getFunctionCallAccess().getOperandsOperandParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_operands_2_0=ruleOperand();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    						}
                    						add(
                    							current,
                    							"operands",
                    							lv_operands_2_0,
                    							"xtext.json.WorkflowDSL.Operand");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflowDSL.g:3818:4: (otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==19) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalWorkflowDSL.g:3819:5: otherlv_3= ',' ( (lv_operands_4_0= ruleOperand ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_48); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalWorkflowDSL.g:3823:5: ( (lv_operands_4_0= ruleOperand ) )
                    	    // InternalWorkflowDSL.g:3824:6: (lv_operands_4_0= ruleOperand )
                    	    {
                    	    // InternalWorkflowDSL.g:3824:6: (lv_operands_4_0= ruleOperand )
                    	    // InternalWorkflowDSL.g:3825:7: lv_operands_4_0= ruleOperand
                    	    {

                    	    							newCompositeNode(grammarAccess.getFunctionCallAccess().getOperandsOperandParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_operands_4_0=ruleOperand();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"operands",
                    	    								lv_operands_4_0,
                    	    								"xtext.json.WorkflowDSL.Operand");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleFunction"
    // InternalWorkflowDSL.g:3852:1: entryRuleFunction returns [String current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final String entryRuleFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFunction = null;


        try {
            // InternalWorkflowDSL.g:3852:48: (iv_ruleFunction= ruleFunction EOF )
            // InternalWorkflowDSL.g:3853:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction.getText(); 
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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalWorkflowDSL.g:3859:1: ruleFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abs' | kw= 'sqrt' | kw= 'pow' | kw= 'log' | kw= 'exp' | kw= 'sin' | kw= 'cos' | kw= 'tan' | kw= 'round' | kw= 'ceil' | kw= 'floor' ) ;
    public final AntlrDatatypeRuleToken ruleFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:3865:2: ( (kw= 'abs' | kw= 'sqrt' | kw= 'pow' | kw= 'log' | kw= 'exp' | kw= 'sin' | kw= 'cos' | kw= 'tan' | kw= 'round' | kw= 'ceil' | kw= 'floor' ) )
            // InternalWorkflowDSL.g:3866:2: (kw= 'abs' | kw= 'sqrt' | kw= 'pow' | kw= 'log' | kw= 'exp' | kw= 'sin' | kw= 'cos' | kw= 'tan' | kw= 'round' | kw= 'ceil' | kw= 'floor' )
            {
            // InternalWorkflowDSL.g:3866:2: (kw= 'abs' | kw= 'sqrt' | kw= 'pow' | kw= 'log' | kw= 'exp' | kw= 'sin' | kw= 'cos' | kw= 'tan' | kw= 'round' | kw= 'ceil' | kw= 'floor' )
            int alt36=11;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt36=1;
                }
                break;
            case 74:
                {
                alt36=2;
                }
                break;
            case 75:
                {
                alt36=3;
                }
                break;
            case 76:
                {
                alt36=4;
                }
                break;
            case 77:
                {
                alt36=5;
                }
                break;
            case 78:
                {
                alt36=6;
                }
                break;
            case 79:
                {
                alt36=7;
                }
                break;
            case 80:
                {
                alt36=8;
                }
                break;
            case 81:
                {
                alt36=9;
                }
                break;
            case 82:
                {
                alt36=10;
                }
                break;
            case 83:
                {
                alt36=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalWorkflowDSL.g:3867:3: kw= 'abs'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getAbsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:3873:3: kw= 'sqrt'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getSqrtKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:3879:3: kw= 'pow'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getPowKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:3885:3: kw= 'log'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getLogKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:3891:3: kw= 'exp'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getExpKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflowDSL.g:3897:3: kw= 'sin'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getSinKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalWorkflowDSL.g:3903:3: kw= 'cos'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getCosKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalWorkflowDSL.g:3909:3: kw= 'tan'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getTanKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalWorkflowDSL.g:3915:3: kw= 'round'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getRoundKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalWorkflowDSL.g:3921:3: kw= 'ceil'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getCeilKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalWorkflowDSL.g:3927:3: kw= 'floor'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionAccess().getFloorKeyword_10());
                    		

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
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleOperand"
    // InternalWorkflowDSL.g:3936:1: entryRuleOperand returns [EObject current=null] : iv_ruleOperand= ruleOperand EOF ;
    public final EObject entryRuleOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperand = null;


        try {
            // InternalWorkflowDSL.g:3936:48: (iv_ruleOperand= ruleOperand EOF )
            // InternalWorkflowDSL.g:3937:2: iv_ruleOperand= ruleOperand EOF
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
    // InternalWorkflowDSL.g:3943:1: ruleOperand returns [EObject current=null] : ( ( (lv_column_0_0= ruleColumn ) ) | ( (lv_number_1_0= ruleNumber ) ) | ( (lv_string_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleOperand() throws RecognitionException {
        EObject current = null;

        Token lv_string_2_0=null;
        EObject lv_column_0_0 = null;

        AntlrDatatypeRuleToken lv_number_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:3949:2: ( ( ( (lv_column_0_0= ruleColumn ) ) | ( (lv_number_1_0= ruleNumber ) ) | ( (lv_string_2_0= RULE_STRING ) ) ) )
            // InternalWorkflowDSL.g:3950:2: ( ( (lv_column_0_0= ruleColumn ) ) | ( (lv_number_1_0= ruleNumber ) ) | ( (lv_string_2_0= RULE_STRING ) ) )
            {
            // InternalWorkflowDSL.g:3950:2: ( ( (lv_column_0_0= ruleColumn ) ) | ( (lv_number_1_0= ruleNumber ) ) | ( (lv_string_2_0= RULE_STRING ) ) )
            int alt37=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt37=1;
                }
                break;
            case RULE_INT:
            case 32:
                {
                alt37=2;
                }
                break;
            case RULE_STRING:
                {
                alt37=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalWorkflowDSL.g:3951:3: ( (lv_column_0_0= ruleColumn ) )
                    {
                    // InternalWorkflowDSL.g:3951:3: ( (lv_column_0_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:3952:4: (lv_column_0_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:3952:4: (lv_column_0_0= ruleColumn )
                    // InternalWorkflowDSL.g:3953:5: lv_column_0_0= ruleColumn
                    {

                    					newCompositeNode(grammarAccess.getOperandAccess().getColumnColumnParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_column_0_0=ruleColumn();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperandRule());
                    					}
                    					set(
                    						current,
                    						"column",
                    						lv_column_0_0,
                    						"xtext.json.WorkflowDSL.Column");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:3971:3: ( (lv_number_1_0= ruleNumber ) )
                    {
                    // InternalWorkflowDSL.g:3971:3: ( (lv_number_1_0= ruleNumber ) )
                    // InternalWorkflowDSL.g:3972:4: (lv_number_1_0= ruleNumber )
                    {
                    // InternalWorkflowDSL.g:3972:4: (lv_number_1_0= ruleNumber )
                    // InternalWorkflowDSL.g:3973:5: lv_number_1_0= ruleNumber
                    {

                    					newCompositeNode(grammarAccess.getOperandAccess().getNumberNumberParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_number_1_0=ruleNumber();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOperandRule());
                    					}
                    					set(
                    						current,
                    						"number",
                    						lv_number_1_0,
                    						"xtext.json.WorkflowDSL.Number");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:3991:3: ( (lv_string_2_0= RULE_STRING ) )
                    {
                    // InternalWorkflowDSL.g:3991:3: ( (lv_string_2_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:3992:4: (lv_string_2_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:3992:4: (lv_string_2_0= RULE_STRING )
                    // InternalWorkflowDSL.g:3993:5: lv_string_2_0= RULE_STRING
                    {
                    lv_string_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_string_2_0, grammarAccess.getOperandAccess().getStringSTRINGTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOperandRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"string",
                    						lv_string_2_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


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
    // $ANTLR end "ruleOperand"


    // $ANTLR start "entryRuleOperator"
    // InternalWorkflowDSL.g:4013:1: entryRuleOperator returns [String current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final String entryRuleOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOperator = null;


        try {
            // InternalWorkflowDSL.g:4013:48: (iv_ruleOperator= ruleOperator EOF )
            // InternalWorkflowDSL.g:4014:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator.getText(); 
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
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalWorkflowDSL.g:4020:1: ruleOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '%' | kw= '^' ) ;
    public final AntlrDatatypeRuleToken ruleOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:4026:2: ( (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '%' | kw= '^' ) )
            // InternalWorkflowDSL.g:4027:2: (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '%' | kw= '^' )
            {
            // InternalWorkflowDSL.g:4027:2: (kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '%' | kw= '^' )
            int alt38=6;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt38=1;
                }
                break;
            case 85:
                {
                alt38=2;
                }
                break;
            case 57:
                {
                alt38=3;
                }
                break;
            case 86:
                {
                alt38=4;
                }
                break;
            case 87:
                {
                alt38=5;
                }
                break;
            case 88:
                {
                alt38=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalWorkflowDSL.g:4028:3: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getPlusSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:4034:3: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getHyphenMinusKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:4040:3: kw= '*'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getAsteriskKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:4046:3: kw= '/'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:4052:3: kw= '%'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getPercentSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflowDSL.g:4058:3: kw= '^'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getCircumflexAccentKeyword_5());
                    		

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


    // $ANTLR start "entryRuleBinner"
    // InternalWorkflowDSL.g:4067:1: entryRuleBinner returns [EObject current=null] : iv_ruleBinner= ruleBinner EOF ;
    public final EObject entryRuleBinner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinner = null;


        try {
            // InternalWorkflowDSL.g:4067:47: (iv_ruleBinner= ruleBinner EOF )
            // InternalWorkflowDSL.g:4068:2: iv_ruleBinner= ruleBinner EOF
            {
             newCompositeNode(grammarAccess.getBinnerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinner=ruleBinner();

            state._fsp--;

             current =iv_ruleBinner; 
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
    // $ANTLR end "entryRuleBinner"


    // $ANTLR start "ruleBinner"
    // InternalWorkflowDSL.g:4074:1: ruleBinner returns [EObject current=null] : (otherlv_0= 'bin' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_definitions_5_0= ruleBinDefinitions ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleBinMode ) ) ) ;
    public final EObject ruleBinner() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_column_2_0 = null;

        EObject lv_definitions_5_0 = null;

        EObject lv_mode_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:4080:2: ( (otherlv_0= 'bin' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_definitions_5_0= ruleBinDefinitions ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleBinMode ) ) ) )
            // InternalWorkflowDSL.g:4081:2: (otherlv_0= 'bin' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_definitions_5_0= ruleBinDefinitions ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleBinMode ) ) )
            {
            // InternalWorkflowDSL.g:4081:2: (otherlv_0= 'bin' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_definitions_5_0= ruleBinDefinitions ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleBinMode ) ) )
            // InternalWorkflowDSL.g:4082:3: otherlv_0= 'bin' otherlv_1= '(' ( (lv_column_2_0= ruleColumn ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_definitions_5_0= ruleBinDefinitions ) ) otherlv_6= '}' ( (lv_mode_7_0= ruleBinMode ) )
            {
            otherlv_0=(Token)match(input,89,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getBinnerAccess().getBinKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getBinnerAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:4090:3: ( (lv_column_2_0= ruleColumn ) )
            // InternalWorkflowDSL.g:4091:4: (lv_column_2_0= ruleColumn )
            {
            // InternalWorkflowDSL.g:4091:4: (lv_column_2_0= ruleColumn )
            // InternalWorkflowDSL.g:4092:5: lv_column_2_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getBinnerAccess().getColumnColumnParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_column_2_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinnerRule());
            					}
            					set(
            						current,
            						"column",
            						lv_column_2_0,
            						"xtext.json.WorkflowDSL.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getBinnerAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_49); 

            			newLeafNode(otherlv_4, grammarAccess.getBinnerAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflowDSL.g:4117:3: ( (lv_definitions_5_0= ruleBinDefinitions ) )
            // InternalWorkflowDSL.g:4118:4: (lv_definitions_5_0= ruleBinDefinitions )
            {
            // InternalWorkflowDSL.g:4118:4: (lv_definitions_5_0= ruleBinDefinitions )
            // InternalWorkflowDSL.g:4119:5: lv_definitions_5_0= ruleBinDefinitions
            {

            					newCompositeNode(grammarAccess.getBinnerAccess().getDefinitionsBinDefinitionsParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_definitions_5_0=ruleBinDefinitions();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinnerRule());
            					}
            					set(
            						current,
            						"definitions",
            						lv_definitions_5_0,
            						"xtext.json.WorkflowDSL.BinDefinitions");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_40); 

            			newLeafNode(otherlv_6, grammarAccess.getBinnerAccess().getRightCurlyBracketKeyword_6());
            		
            // InternalWorkflowDSL.g:4140:3: ( (lv_mode_7_0= ruleBinMode ) )
            // InternalWorkflowDSL.g:4141:4: (lv_mode_7_0= ruleBinMode )
            {
            // InternalWorkflowDSL.g:4141:4: (lv_mode_7_0= ruleBinMode )
            // InternalWorkflowDSL.g:4142:5: lv_mode_7_0= ruleBinMode
            {

            					newCompositeNode(grammarAccess.getBinnerAccess().getModeBinModeParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_mode_7_0=ruleBinMode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinnerRule());
            					}
            					set(
            						current,
            						"mode",
            						lv_mode_7_0,
            						"xtext.json.WorkflowDSL.BinMode");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleBinner"


    // $ANTLR start "entryRuleBinDefinitions"
    // InternalWorkflowDSL.g:4163:1: entryRuleBinDefinitions returns [EObject current=null] : iv_ruleBinDefinitions= ruleBinDefinitions EOF ;
    public final EObject entryRuleBinDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinDefinitions = null;


        try {
            // InternalWorkflowDSL.g:4163:55: (iv_ruleBinDefinitions= ruleBinDefinitions EOF )
            // InternalWorkflowDSL.g:4164:2: iv_ruleBinDefinitions= ruleBinDefinitions EOF
            {
             newCompositeNode(grammarAccess.getBinDefinitionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinDefinitions=ruleBinDefinitions();

            state._fsp--;

             current =iv_ruleBinDefinitions; 
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
    // $ANTLR end "entryRuleBinDefinitions"


    // $ANTLR start "ruleBinDefinitions"
    // InternalWorkflowDSL.g:4170:1: ruleBinDefinitions returns [EObject current=null] : ( ( (lv_definitions_0_0= ruleBinDef ) ) (otherlv_1= ',' ( (lv_definitions_2_0= ruleBinDef ) ) )* )? ;
    public final EObject ruleBinDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_definitions_0_0 = null;

        EObject lv_definitions_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:4176:2: ( ( ( (lv_definitions_0_0= ruleBinDef ) ) (otherlv_1= ',' ( (lv_definitions_2_0= ruleBinDef ) ) )* )? )
            // InternalWorkflowDSL.g:4177:2: ( ( (lv_definitions_0_0= ruleBinDef ) ) (otherlv_1= ',' ( (lv_definitions_2_0= ruleBinDef ) ) )* )?
            {
            // InternalWorkflowDSL.g:4177:2: ( ( (lv_definitions_0_0= ruleBinDef ) ) (otherlv_1= ',' ( (lv_definitions_2_0= ruleBinDef ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_STRING) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalWorkflowDSL.g:4178:3: ( (lv_definitions_0_0= ruleBinDef ) ) (otherlv_1= ',' ( (lv_definitions_2_0= ruleBinDef ) ) )*
                    {
                    // InternalWorkflowDSL.g:4178:3: ( (lv_definitions_0_0= ruleBinDef ) )
                    // InternalWorkflowDSL.g:4179:4: (lv_definitions_0_0= ruleBinDef )
                    {
                    // InternalWorkflowDSL.g:4179:4: (lv_definitions_0_0= ruleBinDef )
                    // InternalWorkflowDSL.g:4180:5: lv_definitions_0_0= ruleBinDef
                    {

                    					newCompositeNode(grammarAccess.getBinDefinitionsAccess().getDefinitionsBinDefParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_41);
                    lv_definitions_0_0=ruleBinDef();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBinDefinitionsRule());
                    					}
                    					add(
                    						current,
                    						"definitions",
                    						lv_definitions_0_0,
                    						"xtext.json.WorkflowDSL.BinDef");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }

                    // InternalWorkflowDSL.g:4197:3: (otherlv_1= ',' ( (lv_definitions_2_0= ruleBinDef ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==19) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalWorkflowDSL.g:4198:4: otherlv_1= ',' ( (lv_definitions_2_0= ruleBinDef ) )
                    	    {
                    	    otherlv_1=(Token)match(input,19,FOLLOW_3); 

                    	    				newLeafNode(otherlv_1, grammarAccess.getBinDefinitionsAccess().getCommaKeyword_1_0());
                    	    			
                    	    // InternalWorkflowDSL.g:4202:4: ( (lv_definitions_2_0= ruleBinDef ) )
                    	    // InternalWorkflowDSL.g:4203:5: (lv_definitions_2_0= ruleBinDef )
                    	    {
                    	    // InternalWorkflowDSL.g:4203:5: (lv_definitions_2_0= ruleBinDef )
                    	    // InternalWorkflowDSL.g:4204:6: lv_definitions_2_0= ruleBinDef
                    	    {

                    	    						newCompositeNode(grammarAccess.getBinDefinitionsAccess().getDefinitionsBinDefParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_41);
                    	    lv_definitions_2_0=ruleBinDef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBinDefinitionsRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"definitions",
                    	    							lv_definitions_2_0,
                    	    							"xtext.json.WorkflowDSL.BinDef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


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
    // $ANTLR end "ruleBinDefinitions"


    // $ANTLR start "entryRuleBinDef"
    // InternalWorkflowDSL.g:4226:1: entryRuleBinDef returns [EObject current=null] : iv_ruleBinDef= ruleBinDef EOF ;
    public final EObject entryRuleBinDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinDef = null;


        try {
            // InternalWorkflowDSL.g:4226:47: (iv_ruleBinDef= ruleBinDef EOF )
            // InternalWorkflowDSL.g:4227:2: iv_ruleBinDef= ruleBinDef EOF
            {
             newCompositeNode(grammarAccess.getBinDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinDef=ruleBinDef();

            state._fsp--;

             current =iv_ruleBinDef; 
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
    // $ANTLR end "entryRuleBinDef"


    // $ANTLR start "ruleBinDef"
    // InternalWorkflowDSL.g:4233:1: ruleBinDef returns [EObject current=null] : ( ( (lv_name_0_0= ruleBinName ) ) otherlv_1= ':' ( (lv_interval_2_0= ruleInterval ) ) ) ;
    public final EObject ruleBinDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_interval_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:4239:2: ( ( ( (lv_name_0_0= ruleBinName ) ) otherlv_1= ':' ( (lv_interval_2_0= ruleInterval ) ) ) )
            // InternalWorkflowDSL.g:4240:2: ( ( (lv_name_0_0= ruleBinName ) ) otherlv_1= ':' ( (lv_interval_2_0= ruleInterval ) ) )
            {
            // InternalWorkflowDSL.g:4240:2: ( ( (lv_name_0_0= ruleBinName ) ) otherlv_1= ':' ( (lv_interval_2_0= ruleInterval ) ) )
            // InternalWorkflowDSL.g:4241:3: ( (lv_name_0_0= ruleBinName ) ) otherlv_1= ':' ( (lv_interval_2_0= ruleInterval ) )
            {
            // InternalWorkflowDSL.g:4241:3: ( (lv_name_0_0= ruleBinName ) )
            // InternalWorkflowDSL.g:4242:4: (lv_name_0_0= ruleBinName )
            {
            // InternalWorkflowDSL.g:4242:4: (lv_name_0_0= ruleBinName )
            // InternalWorkflowDSL.g:4243:5: lv_name_0_0= ruleBinName
            {

            					newCompositeNode(grammarAccess.getBinDefAccess().getNameBinNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_50);
            lv_name_0_0=ruleBinName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"xtext.json.WorkflowDSL.BinName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,90,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getBinDefAccess().getColonKeyword_1());
            		
            // InternalWorkflowDSL.g:4264:3: ( (lv_interval_2_0= ruleInterval ) )
            // InternalWorkflowDSL.g:4265:4: (lv_interval_2_0= ruleInterval )
            {
            // InternalWorkflowDSL.g:4265:4: (lv_interval_2_0= ruleInterval )
            // InternalWorkflowDSL.g:4266:5: lv_interval_2_0= ruleInterval
            {

            					newCompositeNode(grammarAccess.getBinDefAccess().getIntervalIntervalParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_interval_2_0=ruleInterval();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinDefRule());
            					}
            					set(
            						current,
            						"interval",
            						lv_interval_2_0,
            						"xtext.json.WorkflowDSL.Interval");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleBinDef"


    // $ANTLR start "entryRuleBinName"
    // InternalWorkflowDSL.g:4287:1: entryRuleBinName returns [EObject current=null] : iv_ruleBinName= ruleBinName EOF ;
    public final EObject entryRuleBinName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinName = null;


        try {
            // InternalWorkflowDSL.g:4287:48: (iv_ruleBinName= ruleBinName EOF )
            // InternalWorkflowDSL.g:4288:2: iv_ruleBinName= ruleBinName EOF
            {
             newCompositeNode(grammarAccess.getBinNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinName=ruleBinName();

            state._fsp--;

             current =iv_ruleBinName; 
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
    // $ANTLR end "entryRuleBinName"


    // $ANTLR start "ruleBinName"
    // InternalWorkflowDSL.g:4294:1: ruleBinName returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleBinName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:4300:2: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // InternalWorkflowDSL.g:4301:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // InternalWorkflowDSL.g:4301:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:4302:3: (lv_name_0_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:4302:3: (lv_name_0_0= RULE_STRING )
            // InternalWorkflowDSL.g:4303:4: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getBinNameAccess().getNameSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBinNameRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
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
    // $ANTLR end "ruleBinName"


    // $ANTLR start "entryRuleInterval"
    // InternalWorkflowDSL.g:4322:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalWorkflowDSL.g:4322:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalWorkflowDSL.g:4323:2: iv_ruleInterval= ruleInterval EOF
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
    // InternalWorkflowDSL.g:4329:1: ruleInterval returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_lower_1_0 = null;

        EObject lv_upper_3_0 = null;

        EObject lv_lower_6_0 = null;

        EObject lv_upper_8_0 = null;

        EObject lv_lower_11_0 = null;

        EObject lv_upper_13_0 = null;

        EObject lv_lower_16_0 = null;

        EObject lv_upper_18_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:4335:2: ( ( (otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')' ) ) )
            // InternalWorkflowDSL.g:4336:2: ( (otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')' ) )
            {
            // InternalWorkflowDSL.g:4336:2: ( (otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')' ) )
            int alt41=4;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // InternalWorkflowDSL.g:4337:3: (otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']' )
                    {
                    // InternalWorkflowDSL.g:4337:3: (otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']' )
                    // InternalWorkflowDSL.g:4338:4: otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']'
                    {
                    otherlv_0=(Token)match(input,55,FOLLOW_51); 

                    				newLeafNode(otherlv_0, grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_0_0());
                    			
                    // InternalWorkflowDSL.g:4342:4: ( (lv_lower_1_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4343:5: (lv_lower_1_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4343:5: (lv_lower_1_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4344:6: lv_lower_1_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getLowerIntervalBoundParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_1_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_1_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,19,FOLLOW_51); 

                    				newLeafNode(otherlv_2, grammarAccess.getIntervalAccess().getCommaKeyword_0_2());
                    			
                    // InternalWorkflowDSL.g:4365:4: ( (lv_upper_3_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4366:5: (lv_upper_3_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4366:5: (lv_upper_3_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4367:6: lv_upper_3_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getUpperIntervalBoundParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_upper_3_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_3_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,56,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:4390:3: (otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')' )
                    {
                    // InternalWorkflowDSL.g:4390:3: (otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')' )
                    // InternalWorkflowDSL.g:4391:4: otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,55,FOLLOW_51); 

                    				newLeafNode(otherlv_5, grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:4395:4: ( (lv_lower_6_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4396:5: (lv_lower_6_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4396:5: (lv_lower_6_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4397:6: lv_lower_6_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getLowerIntervalBoundParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_6_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_6_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,19,FOLLOW_51); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntervalAccess().getCommaKeyword_1_2());
                    			
                    // InternalWorkflowDSL.g:4418:4: ( (lv_upper_8_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4419:5: (lv_upper_8_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4419:5: (lv_upper_8_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4420:6: lv_upper_8_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getUpperIntervalBoundParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_upper_8_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_8_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getIntervalAccess().getRightParenthesisKeyword_1_4());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:4443:3: (otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']' )
                    {
                    // InternalWorkflowDSL.g:4443:3: (otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']' )
                    // InternalWorkflowDSL.g:4444:4: otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']'
                    {
                    otherlv_10=(Token)match(input,18,FOLLOW_51); 

                    				newLeafNode(otherlv_10, grammarAccess.getIntervalAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalWorkflowDSL.g:4448:4: ( (lv_lower_11_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4449:5: (lv_lower_11_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4449:5: (lv_lower_11_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4450:6: lv_lower_11_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getLowerIntervalBoundParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_11_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_11_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,19,FOLLOW_51); 

                    				newLeafNode(otherlv_12, grammarAccess.getIntervalAccess().getCommaKeyword_2_2());
                    			
                    // InternalWorkflowDSL.g:4471:4: ( (lv_upper_13_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4472:5: (lv_upper_13_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4472:5: (lv_upper_13_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4473:6: lv_upper_13_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getUpperIntervalBoundParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_37);
                    lv_upper_13_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_13_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,56,FOLLOW_2); 

                    				newLeafNode(otherlv_14, grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_2_4());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:4496:3: (otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')' )
                    {
                    // InternalWorkflowDSL.g:4496:3: (otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')' )
                    // InternalWorkflowDSL.g:4497:4: otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')'
                    {
                    otherlv_15=(Token)match(input,18,FOLLOW_51); 

                    				newLeafNode(otherlv_15, grammarAccess.getIntervalAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalWorkflowDSL.g:4501:4: ( (lv_lower_16_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4502:5: (lv_lower_16_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4502:5: (lv_lower_16_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4503:6: lv_lower_16_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getLowerIntervalBoundParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lower_16_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"lower",
                    							lv_lower_16_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,19,FOLLOW_51); 

                    				newLeafNode(otherlv_17, grammarAccess.getIntervalAccess().getCommaKeyword_3_2());
                    			
                    // InternalWorkflowDSL.g:4524:4: ( (lv_upper_18_0= ruleIntervalBound ) )
                    // InternalWorkflowDSL.g:4525:5: (lv_upper_18_0= ruleIntervalBound )
                    {
                    // InternalWorkflowDSL.g:4525:5: (lv_upper_18_0= ruleIntervalBound )
                    // InternalWorkflowDSL.g:4526:6: lv_upper_18_0= ruleIntervalBound
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getUpperIntervalBoundParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_upper_18_0=ruleIntervalBound();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"upper",
                    							lv_upper_18_0,
                    							"xtext.json.WorkflowDSL.IntervalBound");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_19=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getIntervalAccess().getRightParenthesisKeyword_3_4());
                    			

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
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleIntervalBound"
    // InternalWorkflowDSL.g:4552:1: entryRuleIntervalBound returns [EObject current=null] : iv_ruleIntervalBound= ruleIntervalBound EOF ;
    public final EObject entryRuleIntervalBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntervalBound = null;


        try {
            // InternalWorkflowDSL.g:4552:54: (iv_ruleIntervalBound= ruleIntervalBound EOF )
            // InternalWorkflowDSL.g:4553:2: iv_ruleIntervalBound= ruleIntervalBound EOF
            {
             newCompositeNode(grammarAccess.getIntervalBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntervalBound=ruleIntervalBound();

            state._fsp--;

             current =iv_ruleIntervalBound; 
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
    // $ANTLR end "entryRuleIntervalBound"


    // $ANTLR start "ruleIntervalBound"
    // InternalWorkflowDSL.g:4559:1: ruleIntervalBound returns [EObject current=null] : ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '-inf' | otherlv_2= 'inf' | otherlv_3= '-Infinity' | otherlv_4= 'Infinity' ) ;
    public final EObject ruleIntervalBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:4565:2: ( ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '-inf' | otherlv_2= 'inf' | otherlv_3= '-Infinity' | otherlv_4= 'Infinity' ) )
            // InternalWorkflowDSL.g:4566:2: ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '-inf' | otherlv_2= 'inf' | otherlv_3= '-Infinity' | otherlv_4= 'Infinity' )
            {
            // InternalWorkflowDSL.g:4566:2: ( ( (lv_value_0_0= ruleNumber ) ) | otherlv_1= '-inf' | otherlv_2= 'inf' | otherlv_3= '-Infinity' | otherlv_4= 'Infinity' )
            int alt42=5;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 32:
                {
                alt42=1;
                }
                break;
            case 59:
                {
                alt42=2;
                }
                break;
            case 58:
                {
                alt42=3;
                }
                break;
            case 91:
                {
                alt42=4;
                }
                break;
            case 92:
                {
                alt42=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalWorkflowDSL.g:4567:3: ( (lv_value_0_0= ruleNumber ) )
                    {
                    // InternalWorkflowDSL.g:4567:3: ( (lv_value_0_0= ruleNumber ) )
                    // InternalWorkflowDSL.g:4568:4: (lv_value_0_0= ruleNumber )
                    {
                    // InternalWorkflowDSL.g:4568:4: (lv_value_0_0= ruleNumber )
                    // InternalWorkflowDSL.g:4569:5: lv_value_0_0= ruleNumber
                    {

                    					newCompositeNode(grammarAccess.getIntervalBoundAccess().getValueNumberParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleNumber();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIntervalBoundRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_0_0,
                    						"xtext.json.WorkflowDSL.Number");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:4587:3: otherlv_1= '-inf'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_2); 

                    			newLeafNode(otherlv_1, grammarAccess.getIntervalBoundAccess().getInfKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:4592:3: otherlv_2= 'inf'
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_2); 

                    			newLeafNode(otherlv_2, grammarAccess.getIntervalBoundAccess().getInfKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:4597:3: otherlv_3= '-Infinity'
                    {
                    otherlv_3=(Token)match(input,91,FOLLOW_2); 

                    			newLeafNode(otherlv_3, grammarAccess.getIntervalBoundAccess().getInfinityKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:4602:3: otherlv_4= 'Infinity'
                    {
                    otherlv_4=(Token)match(input,92,FOLLOW_2); 

                    			newLeafNode(otherlv_4, grammarAccess.getIntervalBoundAccess().getInfinityKeyword_4());
                    		

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
    // $ANTLR end "ruleIntervalBound"


    // $ANTLR start "entryRuleBinMode"
    // InternalWorkflowDSL.g:4610:1: entryRuleBinMode returns [EObject current=null] : iv_ruleBinMode= ruleBinMode EOF ;
    public final EObject entryRuleBinMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinMode = null;


        try {
            // InternalWorkflowDSL.g:4610:48: (iv_ruleBinMode= ruleBinMode EOF )
            // InternalWorkflowDSL.g:4611:2: iv_ruleBinMode= ruleBinMode EOF
            {
             newCompositeNode(grammarAccess.getBinModeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinMode=ruleBinMode();

            state._fsp--;

             current =iv_ruleBinMode; 
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
    // $ANTLR end "entryRuleBinMode"


    // $ANTLR start "ruleBinMode"
    // InternalWorkflowDSL.g:4617:1: ruleBinMode returns [EObject current=null] : (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) ) ;
    public final EObject ruleBinMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_newName_2_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:4623:2: ( (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) ) )
            // InternalWorkflowDSL.g:4624:2: (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) )
            {
            // InternalWorkflowDSL.g:4624:2: (otherlv_0= 'replace' | (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==70) ) {
                alt43=1;
            }
            else if ( (LA43_0==71) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalWorkflowDSL.g:4625:3: otherlv_0= 'replace'
                    {
                    otherlv_0=(Token)match(input,70,FOLLOW_2); 

                    			newLeafNode(otherlv_0, grammarAccess.getBinModeAccess().getReplaceKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:4630:3: (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) )
                    {
                    // InternalWorkflowDSL.g:4630:3: (otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) ) )
                    // InternalWorkflowDSL.g:4631:4: otherlv_1= 'as' ( (lv_newName_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,71,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getBinModeAccess().getAsKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:4635:4: ( (lv_newName_2_0= RULE_ID ) )
                    // InternalWorkflowDSL.g:4636:5: (lv_newName_2_0= RULE_ID )
                    {
                    // InternalWorkflowDSL.g:4636:5: (lv_newName_2_0= RULE_ID )
                    // InternalWorkflowDSL.g:4637:6: lv_newName_2_0= RULE_ID
                    {
                    lv_newName_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(lv_newName_2_0, grammarAccess.getBinModeAccess().getNewNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinModeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"newName",
                    							lv_newName_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


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
    // $ANTLR end "ruleBinMode"


    // $ANTLR start "entryRuleTypeConversion"
    // InternalWorkflowDSL.g:4658:1: entryRuleTypeConversion returns [EObject current=null] : iv_ruleTypeConversion= ruleTypeConversion EOF ;
    public final EObject entryRuleTypeConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConversion = null;


        try {
            // InternalWorkflowDSL.g:4658:55: (iv_ruleTypeConversion= ruleTypeConversion EOF )
            // InternalWorkflowDSL.g:4659:2: iv_ruleTypeConversion= ruleTypeConversion EOF
            {
             newCompositeNode(grammarAccess.getTypeConversionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeConversion=ruleTypeConversion();

            state._fsp--;

             current =iv_ruleTypeConversion; 
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
    // $ANTLR end "entryRuleTypeConversion"


    // $ANTLR start "ruleTypeConversion"
    // InternalWorkflowDSL.g:4665:1: ruleTypeConversion returns [EObject current=null] : ( (otherlv_0= 'to_numeric' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' ( (lv_separator_4_0= ruleDecimalSeparator ) )? ) | (otherlv_5= 'to_string' otherlv_6= '(' ( (lv_columns_7_0= ruleColumnList ) ) otherlv_8= ')' ) | (otherlv_9= 'to_categorical' otherlv_10= '(' ( (lv_columns_11_0= ruleColumnList ) ) otherlv_12= ')' ) | (otherlv_13= 'to_boolean' otherlv_14= '(' ( (lv_columns_15_0= ruleColumnList ) ) otherlv_16= ')' ) | (otherlv_17= 'to_date' otherlv_18= '(' ( (lv_columns_19_0= ruleColumnList ) ) otherlv_20= ',' ( (lv_format_21_0= ruleDateFormat ) )? otherlv_22= ')' ) ) ;
    public final EObject ruleTypeConversion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject lv_columns_2_0 = null;

        AntlrDatatypeRuleToken lv_separator_4_0 = null;

        EObject lv_columns_7_0 = null;

        EObject lv_columns_11_0 = null;

        EObject lv_columns_15_0 = null;

        EObject lv_columns_19_0 = null;

        EObject lv_format_21_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:4671:2: ( ( (otherlv_0= 'to_numeric' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' ( (lv_separator_4_0= ruleDecimalSeparator ) )? ) | (otherlv_5= 'to_string' otherlv_6= '(' ( (lv_columns_7_0= ruleColumnList ) ) otherlv_8= ')' ) | (otherlv_9= 'to_categorical' otherlv_10= '(' ( (lv_columns_11_0= ruleColumnList ) ) otherlv_12= ')' ) | (otherlv_13= 'to_boolean' otherlv_14= '(' ( (lv_columns_15_0= ruleColumnList ) ) otherlv_16= ')' ) | (otherlv_17= 'to_date' otherlv_18= '(' ( (lv_columns_19_0= ruleColumnList ) ) otherlv_20= ',' ( (lv_format_21_0= ruleDateFormat ) )? otherlv_22= ')' ) ) )
            // InternalWorkflowDSL.g:4672:2: ( (otherlv_0= 'to_numeric' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' ( (lv_separator_4_0= ruleDecimalSeparator ) )? ) | (otherlv_5= 'to_string' otherlv_6= '(' ( (lv_columns_7_0= ruleColumnList ) ) otherlv_8= ')' ) | (otherlv_9= 'to_categorical' otherlv_10= '(' ( (lv_columns_11_0= ruleColumnList ) ) otherlv_12= ')' ) | (otherlv_13= 'to_boolean' otherlv_14= '(' ( (lv_columns_15_0= ruleColumnList ) ) otherlv_16= ')' ) | (otherlv_17= 'to_date' otherlv_18= '(' ( (lv_columns_19_0= ruleColumnList ) ) otherlv_20= ',' ( (lv_format_21_0= ruleDateFormat ) )? otherlv_22= ')' ) )
            {
            // InternalWorkflowDSL.g:4672:2: ( (otherlv_0= 'to_numeric' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' ( (lv_separator_4_0= ruleDecimalSeparator ) )? ) | (otherlv_5= 'to_string' otherlv_6= '(' ( (lv_columns_7_0= ruleColumnList ) ) otherlv_8= ')' ) | (otherlv_9= 'to_categorical' otherlv_10= '(' ( (lv_columns_11_0= ruleColumnList ) ) otherlv_12= ')' ) | (otherlv_13= 'to_boolean' otherlv_14= '(' ( (lv_columns_15_0= ruleColumnList ) ) otherlv_16= ')' ) | (otherlv_17= 'to_date' otherlv_18= '(' ( (lv_columns_19_0= ruleColumnList ) ) otherlv_20= ',' ( (lv_format_21_0= ruleDateFormat ) )? otherlv_22= ')' ) )
            int alt46=5;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt46=1;
                }
                break;
            case 94:
                {
                alt46=2;
                }
                break;
            case 95:
                {
                alt46=3;
                }
                break;
            case 96:
                {
                alt46=4;
                }
                break;
            case 97:
                {
                alt46=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalWorkflowDSL.g:4673:3: (otherlv_0= 'to_numeric' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' ( (lv_separator_4_0= ruleDecimalSeparator ) )? )
                    {
                    // InternalWorkflowDSL.g:4673:3: (otherlv_0= 'to_numeric' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' ( (lv_separator_4_0= ruleDecimalSeparator ) )? )
                    // InternalWorkflowDSL.g:4674:4: otherlv_0= 'to_numeric' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' ( (lv_separator_4_0= ruleDecimalSeparator ) )?
                    {
                    otherlv_0=(Token)match(input,93,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getTypeConversionAccess().getTo_numericKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_1, grammarAccess.getTypeConversionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:4682:4: ( (lv_columns_2_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:4683:5: (lv_columns_2_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:4683:5: (lv_columns_2_0= ruleColumnList )
                    // InternalWorkflowDSL.g:4684:6: lv_columns_2_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getTypeConversionAccess().getColumnsColumnListParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_columns_2_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeConversionRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_2_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_52); 

                    				newLeafNode(otherlv_3, grammarAccess.getTypeConversionAccess().getRightParenthesisKeyword_0_3());
                    			
                    // InternalWorkflowDSL.g:4705:4: ( (lv_separator_4_0= ruleDecimalSeparator ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==98) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalWorkflowDSL.g:4706:5: (lv_separator_4_0= ruleDecimalSeparator )
                            {
                            // InternalWorkflowDSL.g:4706:5: (lv_separator_4_0= ruleDecimalSeparator )
                            // InternalWorkflowDSL.g:4707:6: lv_separator_4_0= ruleDecimalSeparator
                            {

                            						newCompositeNode(grammarAccess.getTypeConversionAccess().getSeparatorDecimalSeparatorParserRuleCall_0_4_0());
                            					
                            pushFollow(FOLLOW_2);
                            lv_separator_4_0=ruleDecimalSeparator();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getTypeConversionRule());
                            						}
                            						set(
                            							current,
                            							"separator",
                            							lv_separator_4_0,
                            							"xtext.json.WorkflowDSL.DecimalSeparator");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:4726:3: (otherlv_5= 'to_string' otherlv_6= '(' ( (lv_columns_7_0= ruleColumnList ) ) otherlv_8= ')' )
                    {
                    // InternalWorkflowDSL.g:4726:3: (otherlv_5= 'to_string' otherlv_6= '(' ( (lv_columns_7_0= ruleColumnList ) ) otherlv_8= ')' )
                    // InternalWorkflowDSL.g:4727:4: otherlv_5= 'to_string' otherlv_6= '(' ( (lv_columns_7_0= ruleColumnList ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,94,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getTypeConversionAccess().getTo_stringKeyword_1_0());
                    			
                    otherlv_6=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_6, grammarAccess.getTypeConversionAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:4735:4: ( (lv_columns_7_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:4736:5: (lv_columns_7_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:4736:5: (lv_columns_7_0= ruleColumnList )
                    // InternalWorkflowDSL.g:4737:6: lv_columns_7_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getTypeConversionAccess().getColumnsColumnListParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_columns_7_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeConversionRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_7_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getTypeConversionAccess().getRightParenthesisKeyword_1_3());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:4760:3: (otherlv_9= 'to_categorical' otherlv_10= '(' ( (lv_columns_11_0= ruleColumnList ) ) otherlv_12= ')' )
                    {
                    // InternalWorkflowDSL.g:4760:3: (otherlv_9= 'to_categorical' otherlv_10= '(' ( (lv_columns_11_0= ruleColumnList ) ) otherlv_12= ')' )
                    // InternalWorkflowDSL.g:4761:4: otherlv_9= 'to_categorical' otherlv_10= '(' ( (lv_columns_11_0= ruleColumnList ) ) otherlv_12= ')'
                    {
                    otherlv_9=(Token)match(input,95,FOLLOW_11); 

                    				newLeafNode(otherlv_9, grammarAccess.getTypeConversionAccess().getTo_categoricalKeyword_2_0());
                    			
                    otherlv_10=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_10, grammarAccess.getTypeConversionAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalWorkflowDSL.g:4769:4: ( (lv_columns_11_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:4770:5: (lv_columns_11_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:4770:5: (lv_columns_11_0= ruleColumnList )
                    // InternalWorkflowDSL.g:4771:6: lv_columns_11_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getTypeConversionAccess().getColumnsColumnListParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_columns_11_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeConversionRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_11_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getTypeConversionAccess().getRightParenthesisKeyword_2_3());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:4794:3: (otherlv_13= 'to_boolean' otherlv_14= '(' ( (lv_columns_15_0= ruleColumnList ) ) otherlv_16= ')' )
                    {
                    // InternalWorkflowDSL.g:4794:3: (otherlv_13= 'to_boolean' otherlv_14= '(' ( (lv_columns_15_0= ruleColumnList ) ) otherlv_16= ')' )
                    // InternalWorkflowDSL.g:4795:4: otherlv_13= 'to_boolean' otherlv_14= '(' ( (lv_columns_15_0= ruleColumnList ) ) otherlv_16= ')'
                    {
                    otherlv_13=(Token)match(input,96,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getTypeConversionAccess().getTo_booleanKeyword_3_0());
                    			
                    otherlv_14=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_14, grammarAccess.getTypeConversionAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalWorkflowDSL.g:4803:4: ( (lv_columns_15_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:4804:5: (lv_columns_15_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:4804:5: (lv_columns_15_0= ruleColumnList )
                    // InternalWorkflowDSL.g:4805:6: lv_columns_15_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getTypeConversionAccess().getColumnsColumnListParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_columns_15_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeConversionRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_15_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_16, grammarAccess.getTypeConversionAccess().getRightParenthesisKeyword_3_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:4828:3: (otherlv_17= 'to_date' otherlv_18= '(' ( (lv_columns_19_0= ruleColumnList ) ) otherlv_20= ',' ( (lv_format_21_0= ruleDateFormat ) )? otherlv_22= ')' )
                    {
                    // InternalWorkflowDSL.g:4828:3: (otherlv_17= 'to_date' otherlv_18= '(' ( (lv_columns_19_0= ruleColumnList ) ) otherlv_20= ',' ( (lv_format_21_0= ruleDateFormat ) )? otherlv_22= ')' )
                    // InternalWorkflowDSL.g:4829:4: otherlv_17= 'to_date' otherlv_18= '(' ( (lv_columns_19_0= ruleColumnList ) ) otherlv_20= ',' ( (lv_format_21_0= ruleDateFormat ) )? otherlv_22= ')'
                    {
                    otherlv_17=(Token)match(input,97,FOLLOW_11); 

                    				newLeafNode(otherlv_17, grammarAccess.getTypeConversionAccess().getTo_dateKeyword_4_0());
                    			
                    otherlv_18=(Token)match(input,18,FOLLOW_34); 

                    				newLeafNode(otherlv_18, grammarAccess.getTypeConversionAccess().getLeftParenthesisKeyword_4_1());
                    			
                    // InternalWorkflowDSL.g:4837:4: ( (lv_columns_19_0= ruleColumnList ) )
                    // InternalWorkflowDSL.g:4838:5: (lv_columns_19_0= ruleColumnList )
                    {
                    // InternalWorkflowDSL.g:4838:5: (lv_columns_19_0= ruleColumnList )
                    // InternalWorkflowDSL.g:4839:6: lv_columns_19_0= ruleColumnList
                    {

                    						newCompositeNode(grammarAccess.getTypeConversionAccess().getColumnsColumnListParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_columns_19_0=ruleColumnList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeConversionRule());
                    						}
                    						set(
                    							current,
                    							"columns",
                    							lv_columns_19_0,
                    							"xtext.json.WorkflowDSL.ColumnList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,19,FOLLOW_53); 

                    				newLeafNode(otherlv_20, grammarAccess.getTypeConversionAccess().getCommaKeyword_4_3());
                    			
                    // InternalWorkflowDSL.g:4860:4: ( (lv_format_21_0= ruleDateFormat ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==99) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalWorkflowDSL.g:4861:5: (lv_format_21_0= ruleDateFormat )
                            {
                            // InternalWorkflowDSL.g:4861:5: (lv_format_21_0= ruleDateFormat )
                            // InternalWorkflowDSL.g:4862:6: lv_format_21_0= ruleDateFormat
                            {

                            						newCompositeNode(grammarAccess.getTypeConversionAccess().getFormatDateFormatParserRuleCall_4_4_0());
                            					
                            pushFollow(FOLLOW_14);
                            lv_format_21_0=ruleDateFormat();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getTypeConversionRule());
                            						}
                            						set(
                            							current,
                            							"format",
                            							lv_format_21_0,
                            							"xtext.json.WorkflowDSL.DateFormat");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_22=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_22, grammarAccess.getTypeConversionAccess().getRightParenthesisKeyword_4_5());
                    			

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
    // $ANTLR end "ruleTypeConversion"


    // $ANTLR start "entryRuleDecimalSeparator"
    // InternalWorkflowDSL.g:4888:1: entryRuleDecimalSeparator returns [String current=null] : iv_ruleDecimalSeparator= ruleDecimalSeparator EOF ;
    public final String entryRuleDecimalSeparator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimalSeparator = null;


        try {
            // InternalWorkflowDSL.g:4888:56: (iv_ruleDecimalSeparator= ruleDecimalSeparator EOF )
            // InternalWorkflowDSL.g:4889:2: iv_ruleDecimalSeparator= ruleDecimalSeparator EOF
            {
             newCompositeNode(grammarAccess.getDecimalSeparatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimalSeparator=ruleDecimalSeparator();

            state._fsp--;

             current =iv_ruleDecimalSeparator.getText(); 
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
    // $ANTLR end "entryRuleDecimalSeparator"


    // $ANTLR start "ruleDecimalSeparator"
    // InternalWorkflowDSL.g:4895:1: ruleDecimalSeparator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'separator' kw= '=' (kw= '.' | kw= ',' ) ) ;
    public final AntlrDatatypeRuleToken ruleDecimalSeparator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:4901:2: ( (kw= 'separator' kw= '=' (kw= '.' | kw= ',' ) ) )
            // InternalWorkflowDSL.g:4902:2: (kw= 'separator' kw= '=' (kw= '.' | kw= ',' ) )
            {
            // InternalWorkflowDSL.g:4902:2: (kw= 'separator' kw= '=' (kw= '.' | kw= ',' ) )
            // InternalWorkflowDSL.g:4903:3: kw= 'separator' kw= '=' (kw= '.' | kw= ',' )
            {
            kw=(Token)match(input,98,FOLLOW_9); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDecimalSeparatorAccess().getSeparatorKeyword_0());
            		
            kw=(Token)match(input,16,FOLLOW_54); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDecimalSeparatorAccess().getEqualsSignKeyword_1());
            		
            // InternalWorkflowDSL.g:4913:3: (kw= '.' | kw= ',' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==32) ) {
                alt47=1;
            }
            else if ( (LA47_0==19) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalWorkflowDSL.g:4914:4: kw= '.'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalSeparatorAccess().getFullStopKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:4920:4: kw= ','
                    {
                    kw=(Token)match(input,19,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalSeparatorAccess().getCommaKeyword_2_1());
                    			

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
    // $ANTLR end "ruleDecimalSeparator"


    // $ANTLR start "entryRuleDateFormat"
    // InternalWorkflowDSL.g:4930:1: entryRuleDateFormat returns [EObject current=null] : iv_ruleDateFormat= ruleDateFormat EOF ;
    public final EObject entryRuleDateFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateFormat = null;


        try {
            // InternalWorkflowDSL.g:4930:51: (iv_ruleDateFormat= ruleDateFormat EOF )
            // InternalWorkflowDSL.g:4931:2: iv_ruleDateFormat= ruleDateFormat EOF
            {
             newCompositeNode(grammarAccess.getDateFormatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateFormat=ruleDateFormat();

            state._fsp--;

             current =iv_ruleDateFormat; 
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
    // $ANTLR end "entryRuleDateFormat"


    // $ANTLR start "ruleDateFormat"
    // InternalWorkflowDSL.g:4937:1: ruleDateFormat returns [EObject current=null] : (otherlv_0= 'format' otherlv_1= '=' ( (lv_format_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleDateFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_format_2_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:4943:2: ( (otherlv_0= 'format' otherlv_1= '=' ( (lv_format_2_0= RULE_STRING ) ) ) )
            // InternalWorkflowDSL.g:4944:2: (otherlv_0= 'format' otherlv_1= '=' ( (lv_format_2_0= RULE_STRING ) ) )
            {
            // InternalWorkflowDSL.g:4944:2: (otherlv_0= 'format' otherlv_1= '=' ( (lv_format_2_0= RULE_STRING ) ) )
            // InternalWorkflowDSL.g:4945:3: otherlv_0= 'format' otherlv_1= '=' ( (lv_format_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,99,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getDateFormatAccess().getFormatKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDateFormatAccess().getEqualsSignKeyword_1());
            		
            // InternalWorkflowDSL.g:4953:3: ( (lv_format_2_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:4954:4: (lv_format_2_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:4954:4: (lv_format_2_0= RULE_STRING )
            // InternalWorkflowDSL.g:4955:5: lv_format_2_0= RULE_STRING
            {
            lv_format_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_format_2_0, grammarAccess.getDateFormatAccess().getFormatSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateFormatRule());
            					}
            					setWithLastConsumed(
            						current,
            						"format",
            						lv_format_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // $ANTLR end "ruleDateFormat"


    // $ANTLR start "entryRuleImputation"
    // InternalWorkflowDSL.g:4975:1: entryRuleImputation returns [EObject current=null] : iv_ruleImputation= ruleImputation EOF ;
    public final EObject entryRuleImputation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImputation = null;


        try {
            // InternalWorkflowDSL.g:4975:51: (iv_ruleImputation= ruleImputation EOF )
            // InternalWorkflowDSL.g:4976:2: iv_ruleImputation= ruleImputation EOF
            {
             newCompositeNode(grammarAccess.getImputationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImputation=ruleImputation();

            state._fsp--;

             current =iv_ruleImputation; 
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
    // $ANTLR end "entryRuleImputation"


    // $ANTLR start "ruleImputation"
    // InternalWorkflowDSL.g:4982:1: ruleImputation returns [EObject current=null] : (otherlv_0= 'impute' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_method_5_0= ruleImputeMethod ) ) otherlv_6= '}' ) ;
    public final EObject ruleImputation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_columns_2_0 = null;

        EObject lv_method_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:4988:2: ( (otherlv_0= 'impute' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_method_5_0= ruleImputeMethod ) ) otherlv_6= '}' ) )
            // InternalWorkflowDSL.g:4989:2: (otherlv_0= 'impute' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_method_5_0= ruleImputeMethod ) ) otherlv_6= '}' )
            {
            // InternalWorkflowDSL.g:4989:2: (otherlv_0= 'impute' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_method_5_0= ruleImputeMethod ) ) otherlv_6= '}' )
            // InternalWorkflowDSL.g:4990:3: otherlv_0= 'impute' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_method_5_0= ruleImputeMethod ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getImputationAccess().getImputeKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getImputationAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:4998:3: ( (lv_columns_2_0= ruleColumnList ) )
            // InternalWorkflowDSL.g:4999:4: (lv_columns_2_0= ruleColumnList )
            {
            // InternalWorkflowDSL.g:4999:4: (lv_columns_2_0= ruleColumnList )
            // InternalWorkflowDSL.g:5000:5: lv_columns_2_0= ruleColumnList
            {

            					newCompositeNode(grammarAccess.getImputationAccess().getColumnsColumnListParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_columns_2_0=ruleColumnList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImputationRule());
            					}
            					set(
            						current,
            						"columns",
            						lv_columns_2_0,
            						"xtext.json.WorkflowDSL.ColumnList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getImputationAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_55); 

            			newLeafNode(otherlv_4, grammarAccess.getImputationAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflowDSL.g:5025:3: ( (lv_method_5_0= ruleImputeMethod ) )
            // InternalWorkflowDSL.g:5026:4: (lv_method_5_0= ruleImputeMethod )
            {
            // InternalWorkflowDSL.g:5026:4: (lv_method_5_0= ruleImputeMethod )
            // InternalWorkflowDSL.g:5027:5: lv_method_5_0= ruleImputeMethod
            {

            					newCompositeNode(grammarAccess.getImputationAccess().getMethodImputeMethodParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_method_5_0=ruleImputeMethod();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImputationRule());
            					}
            					set(
            						current,
            						"method",
            						lv_method_5_0,
            						"xtext.json.WorkflowDSL.ImputeMethod");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getImputationAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleImputation"


    // $ANTLR start "entryRuleImputeMethod"
    // InternalWorkflowDSL.g:5052:1: entryRuleImputeMethod returns [EObject current=null] : iv_ruleImputeMethod= ruleImputeMethod EOF ;
    public final EObject entryRuleImputeMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImputeMethod = null;


        try {
            // InternalWorkflowDSL.g:5052:53: (iv_ruleImputeMethod= ruleImputeMethod EOF )
            // InternalWorkflowDSL.g:5053:2: iv_ruleImputeMethod= ruleImputeMethod EOF
            {
             newCompositeNode(grammarAccess.getImputeMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImputeMethod=ruleImputeMethod();

            state._fsp--;

             current =iv_ruleImputeMethod; 
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
    // $ANTLR end "entryRuleImputeMethod"


    // $ANTLR start "ruleImputeMethod"
    // InternalWorkflowDSL.g:5059:1: ruleImputeMethod returns [EObject current=null] : (this_FixedImpute_0= ruleFixedImpute | ruleStatisticalImpute | ruleSequentialImpute | this_AdvancedImpute_3= ruleAdvancedImpute ) ;
    public final EObject ruleImputeMethod() throws RecognitionException {
        EObject current = null;

        EObject this_FixedImpute_0 = null;

        EObject this_AdvancedImpute_3 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5065:2: ( (this_FixedImpute_0= ruleFixedImpute | ruleStatisticalImpute | ruleSequentialImpute | this_AdvancedImpute_3= ruleAdvancedImpute ) )
            // InternalWorkflowDSL.g:5066:2: (this_FixedImpute_0= ruleFixedImpute | ruleStatisticalImpute | ruleSequentialImpute | this_AdvancedImpute_3= ruleAdvancedImpute )
            {
            // InternalWorkflowDSL.g:5066:2: (this_FixedImpute_0= ruleFixedImpute | ruleStatisticalImpute | ruleSequentialImpute | this_AdvancedImpute_3= ruleAdvancedImpute )
            int alt48=4;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt48=1;
                }
                break;
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                {
                alt48=2;
                }
                break;
            case 109:
            case 110:
            case 111:
            case 112:
                {
                alt48=3;
                }
                break;
            case 113:
            case 114:
            case 116:
            case 117:
            case 119:
                {
                alt48=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalWorkflowDSL.g:5067:3: this_FixedImpute_0= ruleFixedImpute
                    {

                    			newCompositeNode(grammarAccess.getImputeMethodAccess().getFixedImputeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixedImpute_0=ruleFixedImpute();

                    state._fsp--;


                    			current = this_FixedImpute_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5076:3: ruleStatisticalImpute
                    {

                    			newCompositeNode(grammarAccess.getImputeMethodAccess().getStatisticalImputeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    ruleStatisticalImpute();

                    state._fsp--;


                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5084:3: ruleSequentialImpute
                    {

                    			newCompositeNode(grammarAccess.getImputeMethodAccess().getSequentialImputeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    ruleSequentialImpute();

                    state._fsp--;


                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:5092:3: this_AdvancedImpute_3= ruleAdvancedImpute
                    {

                    			newCompositeNode(grammarAccess.getImputeMethodAccess().getAdvancedImputeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AdvancedImpute_3=ruleAdvancedImpute();

                    state._fsp--;


                    			current = this_AdvancedImpute_3;
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
    // $ANTLR end "ruleImputeMethod"


    // $ANTLR start "entryRuleFixedImpute"
    // InternalWorkflowDSL.g:5104:1: entryRuleFixedImpute returns [EObject current=null] : iv_ruleFixedImpute= ruleFixedImpute EOF ;
    public final EObject entryRuleFixedImpute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedImpute = null;


        try {
            // InternalWorkflowDSL.g:5104:52: (iv_ruleFixedImpute= ruleFixedImpute EOF )
            // InternalWorkflowDSL.g:5105:2: iv_ruleFixedImpute= ruleFixedImpute EOF
            {
             newCompositeNode(grammarAccess.getFixedImputeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixedImpute=ruleFixedImpute();

            state._fsp--;

             current =iv_ruleFixedImpute; 
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
    // $ANTLR end "entryRuleFixedImpute"


    // $ANTLR start "ruleFixedImpute"
    // InternalWorkflowDSL.g:5111:1: ruleFixedImpute returns [EObject current=null] : (otherlv_0= 'fixed' otherlv_1= '=' ( (lv_values_2_0= ruleValueList ) ) ) ;
    public final EObject ruleFixedImpute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5117:2: ( (otherlv_0= 'fixed' otherlv_1= '=' ( (lv_values_2_0= ruleValueList ) ) ) )
            // InternalWorkflowDSL.g:5118:2: (otherlv_0= 'fixed' otherlv_1= '=' ( (lv_values_2_0= ruleValueList ) ) )
            {
            // InternalWorkflowDSL.g:5118:2: (otherlv_0= 'fixed' otherlv_1= '=' ( (lv_values_2_0= ruleValueList ) ) )
            // InternalWorkflowDSL.g:5119:3: otherlv_0= 'fixed' otherlv_1= '=' ( (lv_values_2_0= ruleValueList ) )
            {
            otherlv_0=(Token)match(input,101,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getFixedImputeAccess().getFixedKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getFixedImputeAccess().getEqualsSignKeyword_1());
            		
            // InternalWorkflowDSL.g:5127:3: ( (lv_values_2_0= ruleValueList ) )
            // InternalWorkflowDSL.g:5128:4: (lv_values_2_0= ruleValueList )
            {
            // InternalWorkflowDSL.g:5128:4: (lv_values_2_0= ruleValueList )
            // InternalWorkflowDSL.g:5129:5: lv_values_2_0= ruleValueList
            {

            					newCompositeNode(grammarAccess.getFixedImputeAccess().getValuesValueListParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_values_2_0=ruleValueList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFixedImputeRule());
            					}
            					set(
            						current,
            						"values",
            						lv_values_2_0,
            						"xtext.json.WorkflowDSL.ValueList");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleFixedImpute"


    // $ANTLR start "entryRuleValueList"
    // InternalWorkflowDSL.g:5150:1: entryRuleValueList returns [EObject current=null] : iv_ruleValueList= ruleValueList EOF ;
    public final EObject entryRuleValueList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueList = null;


        try {
            // InternalWorkflowDSL.g:5150:50: (iv_ruleValueList= ruleValueList EOF )
            // InternalWorkflowDSL.g:5151:2: iv_ruleValueList= ruleValueList EOF
            {
             newCompositeNode(grammarAccess.getValueListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueList=ruleValueList();

            state._fsp--;

             current =iv_ruleValueList; 
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
    // $ANTLR end "entryRuleValueList"


    // $ANTLR start "ruleValueList"
    // InternalWorkflowDSL.g:5157:1: ruleValueList returns [EObject current=null] : ( ( (lv_value_0_0= ruleValue ) ) | (otherlv_1= '[' ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )? otherlv_5= ']' ) ) ;
    public final EObject ruleValueList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_0_0 = null;

        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5163:2: ( ( ( (lv_value_0_0= ruleValue ) ) | (otherlv_1= '[' ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )? otherlv_5= ']' ) ) )
            // InternalWorkflowDSL.g:5164:2: ( ( (lv_value_0_0= ruleValue ) ) | (otherlv_1= '[' ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )? otherlv_5= ']' ) )
            {
            // InternalWorkflowDSL.g:5164:2: ( ( (lv_value_0_0= ruleValue ) ) | (otherlv_1= '[' ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )? otherlv_5= ']' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_STRING||LA51_0==RULE_INT||LA51_0==32||LA51_0==102) ) {
                alt51=1;
            }
            else if ( (LA51_0==55) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalWorkflowDSL.g:5165:3: ( (lv_value_0_0= ruleValue ) )
                    {
                    // InternalWorkflowDSL.g:5165:3: ( (lv_value_0_0= ruleValue ) )
                    // InternalWorkflowDSL.g:5166:4: (lv_value_0_0= ruleValue )
                    {
                    // InternalWorkflowDSL.g:5166:4: (lv_value_0_0= ruleValue )
                    // InternalWorkflowDSL.g:5167:5: lv_value_0_0= ruleValue
                    {

                    					newCompositeNode(grammarAccess.getValueListAccess().getValueValueParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getValueListRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_0_0,
                    						"xtext.json.WorkflowDSL.Value");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5185:3: (otherlv_1= '[' ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )? otherlv_5= ']' )
                    {
                    // InternalWorkflowDSL.g:5185:3: (otherlv_1= '[' ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )? otherlv_5= ']' )
                    // InternalWorkflowDSL.g:5186:4: otherlv_1= '[' ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )? otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,55,FOLLOW_57); 

                    				newLeafNode(otherlv_1, grammarAccess.getValueListAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:5190:4: ( ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )* )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==RULE_STRING||LA50_0==RULE_INT||LA50_0==32||LA50_0==102) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalWorkflowDSL.g:5191:5: ( (lv_values_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )*
                            {
                            // InternalWorkflowDSL.g:5191:5: ( (lv_values_2_0= ruleValue ) )
                            // InternalWorkflowDSL.g:5192:6: (lv_values_2_0= ruleValue )
                            {
                            // InternalWorkflowDSL.g:5192:6: (lv_values_2_0= ruleValue )
                            // InternalWorkflowDSL.g:5193:7: lv_values_2_0= ruleValue
                            {

                            							newCompositeNode(grammarAccess.getValueListAccess().getValuesValueParserRuleCall_1_1_0_0());
                            						
                            pushFollow(FOLLOW_58);
                            lv_values_2_0=ruleValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getValueListRule());
                            							}
                            							add(
                            								current,
                            								"values",
                            								lv_values_2_0,
                            								"xtext.json.WorkflowDSL.Value");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalWorkflowDSL.g:5210:5: (otherlv_3= ',' ( (lv_values_4_0= ruleValue ) ) )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==19) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // InternalWorkflowDSL.g:5211:6: otherlv_3= ',' ( (lv_values_4_0= ruleValue ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FOLLOW_28); 

                            	    						newLeafNode(otherlv_3, grammarAccess.getValueListAccess().getCommaKeyword_1_1_1_0());
                            	    					
                            	    // InternalWorkflowDSL.g:5215:6: ( (lv_values_4_0= ruleValue ) )
                            	    // InternalWorkflowDSL.g:5216:7: (lv_values_4_0= ruleValue )
                            	    {
                            	    // InternalWorkflowDSL.g:5216:7: (lv_values_4_0= ruleValue )
                            	    // InternalWorkflowDSL.g:5217:8: lv_values_4_0= ruleValue
                            	    {

                            	    								newCompositeNode(grammarAccess.getValueListAccess().getValuesValueParserRuleCall_1_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_58);
                            	    lv_values_4_0=ruleValue();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getValueListRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"values",
                            	    									lv_values_4_0,
                            	    									"xtext.json.WorkflowDSL.Value");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop49;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,56,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getValueListAccess().getRightSquareBracketKeyword_1_2());
                    			

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
    // $ANTLR end "ruleValueList"


    // $ANTLR start "entryRuleValue"
    // InternalWorkflowDSL.g:5245:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalWorkflowDSL.g:5245:46: (iv_ruleValue= ruleValue EOF )
            // InternalWorkflowDSL.g:5246:2: iv_ruleValue= ruleValue EOF
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
    // InternalWorkflowDSL.g:5252:1: ruleValue returns [EObject current=null] : ( ( (lv_number_0_0= ruleNumber ) ) | ( (lv_string_1_0= RULE_STRING ) ) | otherlv_2= 'null' ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_number_0_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5258:2: ( ( ( (lv_number_0_0= ruleNumber ) ) | ( (lv_string_1_0= RULE_STRING ) ) | otherlv_2= 'null' ) )
            // InternalWorkflowDSL.g:5259:2: ( ( (lv_number_0_0= ruleNumber ) ) | ( (lv_string_1_0= RULE_STRING ) ) | otherlv_2= 'null' )
            {
            // InternalWorkflowDSL.g:5259:2: ( ( (lv_number_0_0= ruleNumber ) ) | ( (lv_string_1_0= RULE_STRING ) ) | otherlv_2= 'null' )
            int alt52=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case 32:
                {
                alt52=1;
                }
                break;
            case RULE_STRING:
                {
                alt52=2;
                }
                break;
            case 102:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalWorkflowDSL.g:5260:3: ( (lv_number_0_0= ruleNumber ) )
                    {
                    // InternalWorkflowDSL.g:5260:3: ( (lv_number_0_0= ruleNumber ) )
                    // InternalWorkflowDSL.g:5261:4: (lv_number_0_0= ruleNumber )
                    {
                    // InternalWorkflowDSL.g:5261:4: (lv_number_0_0= ruleNumber )
                    // InternalWorkflowDSL.g:5262:5: lv_number_0_0= ruleNumber
                    {

                    					newCompositeNode(grammarAccess.getValueAccess().getNumberNumberParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_number_0_0=ruleNumber();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getValueRule());
                    					}
                    					set(
                    						current,
                    						"number",
                    						lv_number_0_0,
                    						"xtext.json.WorkflowDSL.Number");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5280:3: ( (lv_string_1_0= RULE_STRING ) )
                    {
                    // InternalWorkflowDSL.g:5280:3: ( (lv_string_1_0= RULE_STRING ) )
                    // InternalWorkflowDSL.g:5281:4: (lv_string_1_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:5281:4: (lv_string_1_0= RULE_STRING )
                    // InternalWorkflowDSL.g:5282:5: lv_string_1_0= RULE_STRING
                    {
                    lv_string_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_string_1_0, grammarAccess.getValueAccess().getStringSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"string",
                    						lv_string_1_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5299:3: otherlv_2= 'null'
                    {
                    otherlv_2=(Token)match(input,102,FOLLOW_2); 

                    			newLeafNode(otherlv_2, grammarAccess.getValueAccess().getNullKeyword_2());
                    		

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


    // $ANTLR start "entryRuleStatisticalImpute"
    // InternalWorkflowDSL.g:5307:1: entryRuleStatisticalImpute returns [String current=null] : iv_ruleStatisticalImpute= ruleStatisticalImpute EOF ;
    public final String entryRuleStatisticalImpute() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStatisticalImpute = null;


        try {
            // InternalWorkflowDSL.g:5307:57: (iv_ruleStatisticalImpute= ruleStatisticalImpute EOF )
            // InternalWorkflowDSL.g:5308:2: iv_ruleStatisticalImpute= ruleStatisticalImpute EOF
            {
             newCompositeNode(grammarAccess.getStatisticalImputeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatisticalImpute=ruleStatisticalImpute();

            state._fsp--;

             current =iv_ruleStatisticalImpute.getText(); 
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
    // $ANTLR end "entryRuleStatisticalImpute"


    // $ANTLR start "ruleStatisticalImpute"
    // InternalWorkflowDSL.g:5314:1: ruleStatisticalImpute returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'mean' | kw= 'median' | kw= 'mode' | kw= 'most_frequent' | kw= 'max' | kw= 'min' ) ;
    public final AntlrDatatypeRuleToken ruleStatisticalImpute() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:5320:2: ( (kw= 'mean' | kw= 'median' | kw= 'mode' | kw= 'most_frequent' | kw= 'max' | kw= 'min' ) )
            // InternalWorkflowDSL.g:5321:2: (kw= 'mean' | kw= 'median' | kw= 'mode' | kw= 'most_frequent' | kw= 'max' | kw= 'min' )
            {
            // InternalWorkflowDSL.g:5321:2: (kw= 'mean' | kw= 'median' | kw= 'mode' | kw= 'most_frequent' | kw= 'max' | kw= 'min' )
            int alt53=6;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt53=1;
                }
                break;
            case 104:
                {
                alt53=2;
                }
                break;
            case 105:
                {
                alt53=3;
                }
                break;
            case 106:
                {
                alt53=4;
                }
                break;
            case 107:
                {
                alt53=5;
                }
                break;
            case 108:
                {
                alt53=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalWorkflowDSL.g:5322:3: kw= 'mean'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStatisticalImputeAccess().getMeanKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5328:3: kw= 'median'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStatisticalImputeAccess().getMedianKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5334:3: kw= 'mode'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStatisticalImputeAccess().getModeKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:5340:3: kw= 'most_frequent'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStatisticalImputeAccess().getMost_frequentKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:5346:3: kw= 'max'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStatisticalImputeAccess().getMaxKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflowDSL.g:5352:3: kw= 'min'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStatisticalImputeAccess().getMinKeyword_5());
                    		

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
    // $ANTLR end "ruleStatisticalImpute"


    // $ANTLR start "entryRuleSequentialImpute"
    // InternalWorkflowDSL.g:5361:1: entryRuleSequentialImpute returns [String current=null] : iv_ruleSequentialImpute= ruleSequentialImpute EOF ;
    public final String entryRuleSequentialImpute() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSequentialImpute = null;


        try {
            // InternalWorkflowDSL.g:5361:56: (iv_ruleSequentialImpute= ruleSequentialImpute EOF )
            // InternalWorkflowDSL.g:5362:2: iv_ruleSequentialImpute= ruleSequentialImpute EOF
            {
             newCompositeNode(grammarAccess.getSequentialImputeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequentialImpute=ruleSequentialImpute();

            state._fsp--;

             current =iv_ruleSequentialImpute.getText(); 
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
    // $ANTLR end "entryRuleSequentialImpute"


    // $ANTLR start "ruleSequentialImpute"
    // InternalWorkflowDSL.g:5368:1: ruleSequentialImpute returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'forward_fill' | kw= 'backward_fill' | kw= 'previous_value' | kw= 'next_value' ) ;
    public final AntlrDatatypeRuleToken ruleSequentialImpute() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:5374:2: ( (kw= 'forward_fill' | kw= 'backward_fill' | kw= 'previous_value' | kw= 'next_value' ) )
            // InternalWorkflowDSL.g:5375:2: (kw= 'forward_fill' | kw= 'backward_fill' | kw= 'previous_value' | kw= 'next_value' )
            {
            // InternalWorkflowDSL.g:5375:2: (kw= 'forward_fill' | kw= 'backward_fill' | kw= 'previous_value' | kw= 'next_value' )
            int alt54=4;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt54=1;
                }
                break;
            case 110:
                {
                alt54=2;
                }
                break;
            case 111:
                {
                alt54=3;
                }
                break;
            case 112:
                {
                alt54=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalWorkflowDSL.g:5376:3: kw= 'forward_fill'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSequentialImputeAccess().getForward_fillKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5382:3: kw= 'backward_fill'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSequentialImputeAccess().getBackward_fillKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5388:3: kw= 'previous_value'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSequentialImputeAccess().getPrevious_valueKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:5394:3: kw= 'next_value'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSequentialImputeAccess().getNext_valueKeyword_3());
                    		

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
    // $ANTLR end "ruleSequentialImpute"


    // $ANTLR start "entryRuleAdvancedImpute"
    // InternalWorkflowDSL.g:5403:1: entryRuleAdvancedImpute returns [EObject current=null] : iv_ruleAdvancedImpute= ruleAdvancedImpute EOF ;
    public final EObject entryRuleAdvancedImpute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvancedImpute = null;


        try {
            // InternalWorkflowDSL.g:5403:55: (iv_ruleAdvancedImpute= ruleAdvancedImpute EOF )
            // InternalWorkflowDSL.g:5404:2: iv_ruleAdvancedImpute= ruleAdvancedImpute EOF
            {
             newCompositeNode(grammarAccess.getAdvancedImputeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdvancedImpute=ruleAdvancedImpute();

            state._fsp--;

             current =iv_ruleAdvancedImpute; 
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
    // $ANTLR end "entryRuleAdvancedImpute"


    // $ANTLR start "ruleAdvancedImpute"
    // InternalWorkflowDSL.g:5410:1: ruleAdvancedImpute returns [EObject current=null] : ( (otherlv_0= 'interpolation' ( (lv_type_1_0= ruleInterpolationType ) )? ) | (otherlv_2= 'moving_average' (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )? ) | otherlv_6= 'linear' | (otherlv_7= 'polynomial' (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )? ) | otherlv_11= 'spline' ) ;
    public final EObject ruleAdvancedImpute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_windowSize_5_0 = null;

        AntlrDatatypeRuleToken lv_degree_10_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5416:2: ( ( (otherlv_0= 'interpolation' ( (lv_type_1_0= ruleInterpolationType ) )? ) | (otherlv_2= 'moving_average' (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )? ) | otherlv_6= 'linear' | (otherlv_7= 'polynomial' (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )? ) | otherlv_11= 'spline' ) )
            // InternalWorkflowDSL.g:5417:2: ( (otherlv_0= 'interpolation' ( (lv_type_1_0= ruleInterpolationType ) )? ) | (otherlv_2= 'moving_average' (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )? ) | otherlv_6= 'linear' | (otherlv_7= 'polynomial' (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )? ) | otherlv_11= 'spline' )
            {
            // InternalWorkflowDSL.g:5417:2: ( (otherlv_0= 'interpolation' ( (lv_type_1_0= ruleInterpolationType ) )? ) | (otherlv_2= 'moving_average' (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )? ) | otherlv_6= 'linear' | (otherlv_7= 'polynomial' (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )? ) | otherlv_11= 'spline' )
            int alt58=5;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt58=1;
                }
                break;
            case 114:
                {
                alt58=2;
                }
                break;
            case 116:
                {
                alt58=3;
                }
                break;
            case 117:
                {
                alt58=4;
                }
                break;
            case 119:
                {
                alt58=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalWorkflowDSL.g:5418:3: (otherlv_0= 'interpolation' ( (lv_type_1_0= ruleInterpolationType ) )? )
                    {
                    // InternalWorkflowDSL.g:5418:3: (otherlv_0= 'interpolation' ( (lv_type_1_0= ruleInterpolationType ) )? )
                    // InternalWorkflowDSL.g:5419:4: otherlv_0= 'interpolation' ( (lv_type_1_0= ruleInterpolationType ) )?
                    {
                    otherlv_0=(Token)match(input,113,FOLLOW_59); 

                    				newLeafNode(otherlv_0, grammarAccess.getAdvancedImputeAccess().getInterpolationKeyword_0_0());
                    			
                    // InternalWorkflowDSL.g:5423:4: ( (lv_type_1_0= ruleInterpolationType ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=116 && LA55_0<=117)||LA55_0==119) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalWorkflowDSL.g:5424:5: (lv_type_1_0= ruleInterpolationType )
                            {
                            // InternalWorkflowDSL.g:5424:5: (lv_type_1_0= ruleInterpolationType )
                            // InternalWorkflowDSL.g:5425:6: lv_type_1_0= ruleInterpolationType
                            {

                            						newCompositeNode(grammarAccess.getAdvancedImputeAccess().getTypeInterpolationTypeParserRuleCall_0_1_0());
                            					
                            pushFollow(FOLLOW_2);
                            lv_type_1_0=ruleInterpolationType();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getAdvancedImputeRule());
                            						}
                            						set(
                            							current,
                            							"type",
                            							lv_type_1_0,
                            							"xtext.json.WorkflowDSL.InterpolationType");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5444:3: (otherlv_2= 'moving_average' (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )? )
                    {
                    // InternalWorkflowDSL.g:5444:3: (otherlv_2= 'moving_average' (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )? )
                    // InternalWorkflowDSL.g:5445:4: otherlv_2= 'moving_average' (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )?
                    {
                    otherlv_2=(Token)match(input,114,FOLLOW_60); 

                    				newLeafNode(otherlv_2, grammarAccess.getAdvancedImputeAccess().getMoving_averageKeyword_1_0());
                    			
                    // InternalWorkflowDSL.g:5449:4: (otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==115) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalWorkflowDSL.g:5450:5: otherlv_3= 'window' otherlv_4= '=' ( (lv_windowSize_5_0= ruleNumber ) )
                            {
                            otherlv_3=(Token)match(input,115,FOLLOW_9); 

                            					newLeafNode(otherlv_3, grammarAccess.getAdvancedImputeAccess().getWindowKeyword_1_1_0());
                            				
                            otherlv_4=(Token)match(input,16,FOLLOW_61); 

                            					newLeafNode(otherlv_4, grammarAccess.getAdvancedImputeAccess().getEqualsSignKeyword_1_1_1());
                            				
                            // InternalWorkflowDSL.g:5458:5: ( (lv_windowSize_5_0= ruleNumber ) )
                            // InternalWorkflowDSL.g:5459:6: (lv_windowSize_5_0= ruleNumber )
                            {
                            // InternalWorkflowDSL.g:5459:6: (lv_windowSize_5_0= ruleNumber )
                            // InternalWorkflowDSL.g:5460:7: lv_windowSize_5_0= ruleNumber
                            {

                            							newCompositeNode(grammarAccess.getAdvancedImputeAccess().getWindowSizeNumberParserRuleCall_1_1_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_windowSize_5_0=ruleNumber();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAdvancedImputeRule());
                            							}
                            							set(
                            								current,
                            								"windowSize",
                            								lv_windowSize_5_0,
                            								"xtext.json.WorkflowDSL.Number");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5480:3: otherlv_6= 'linear'
                    {
                    otherlv_6=(Token)match(input,116,FOLLOW_2); 

                    			newLeafNode(otherlv_6, grammarAccess.getAdvancedImputeAccess().getLinearKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:5485:3: (otherlv_7= 'polynomial' (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )? )
                    {
                    // InternalWorkflowDSL.g:5485:3: (otherlv_7= 'polynomial' (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )? )
                    // InternalWorkflowDSL.g:5486:4: otherlv_7= 'polynomial' (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )?
                    {
                    otherlv_7=(Token)match(input,117,FOLLOW_62); 

                    				newLeafNode(otherlv_7, grammarAccess.getAdvancedImputeAccess().getPolynomialKeyword_3_0());
                    			
                    // InternalWorkflowDSL.g:5490:4: (otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==118) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalWorkflowDSL.g:5491:5: otherlv_8= 'degree' otherlv_9= '=' ( (lv_degree_10_0= ruleNumber ) )
                            {
                            otherlv_8=(Token)match(input,118,FOLLOW_9); 

                            					newLeafNode(otherlv_8, grammarAccess.getAdvancedImputeAccess().getDegreeKeyword_3_1_0());
                            				
                            otherlv_9=(Token)match(input,16,FOLLOW_61); 

                            					newLeafNode(otherlv_9, grammarAccess.getAdvancedImputeAccess().getEqualsSignKeyword_3_1_1());
                            				
                            // InternalWorkflowDSL.g:5499:5: ( (lv_degree_10_0= ruleNumber ) )
                            // InternalWorkflowDSL.g:5500:6: (lv_degree_10_0= ruleNumber )
                            {
                            // InternalWorkflowDSL.g:5500:6: (lv_degree_10_0= ruleNumber )
                            // InternalWorkflowDSL.g:5501:7: lv_degree_10_0= ruleNumber
                            {

                            							newCompositeNode(grammarAccess.getAdvancedImputeAccess().getDegreeNumberParserRuleCall_3_1_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_degree_10_0=ruleNumber();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAdvancedImputeRule());
                            							}
                            							set(
                            								current,
                            								"degree",
                            								lv_degree_10_0,
                            								"xtext.json.WorkflowDSL.Number");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:5521:3: otherlv_11= 'spline'
                    {
                    otherlv_11=(Token)match(input,119,FOLLOW_2); 

                    			newLeafNode(otherlv_11, grammarAccess.getAdvancedImputeAccess().getSplineKeyword_4());
                    		

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
    // $ANTLR end "ruleAdvancedImpute"


    // $ANTLR start "entryRuleInterpolationType"
    // InternalWorkflowDSL.g:5529:1: entryRuleInterpolationType returns [String current=null] : iv_ruleInterpolationType= ruleInterpolationType EOF ;
    public final String entryRuleInterpolationType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInterpolationType = null;


        try {
            // InternalWorkflowDSL.g:5529:57: (iv_ruleInterpolationType= ruleInterpolationType EOF )
            // InternalWorkflowDSL.g:5530:2: iv_ruleInterpolationType= ruleInterpolationType EOF
            {
             newCompositeNode(grammarAccess.getInterpolationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterpolationType=ruleInterpolationType();

            state._fsp--;

             current =iv_ruleInterpolationType.getText(); 
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
    // $ANTLR end "entryRuleInterpolationType"


    // $ANTLR start "ruleInterpolationType"
    // InternalWorkflowDSL.g:5536:1: ruleInterpolationType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'linear' | kw= 'polynomial' | kw= 'spline' ) ;
    public final AntlrDatatypeRuleToken ruleInterpolationType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:5542:2: ( (kw= 'linear' | kw= 'polynomial' | kw= 'spline' ) )
            // InternalWorkflowDSL.g:5543:2: (kw= 'linear' | kw= 'polynomial' | kw= 'spline' )
            {
            // InternalWorkflowDSL.g:5543:2: (kw= 'linear' | kw= 'polynomial' | kw= 'spline' )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt59=1;
                }
                break;
            case 117:
                {
                alt59=2;
                }
                break;
            case 119:
                {
                alt59=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalWorkflowDSL.g:5544:3: kw= 'linear'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getInterpolationTypeAccess().getLinearKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5550:3: kw= 'polynomial'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getInterpolationTypeAccess().getPolynomialKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5556:3: kw= 'spline'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getInterpolationTypeAccess().getSplineKeyword_2());
                    		

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
    // $ANTLR end "ruleInterpolationType"


    // $ANTLR start "entryRuleOutlierTreatment"
    // InternalWorkflowDSL.g:5565:1: entryRuleOutlierTreatment returns [EObject current=null] : iv_ruleOutlierTreatment= ruleOutlierTreatment EOF ;
    public final EObject entryRuleOutlierTreatment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutlierTreatment = null;


        try {
            // InternalWorkflowDSL.g:5565:57: (iv_ruleOutlierTreatment= ruleOutlierTreatment EOF )
            // InternalWorkflowDSL.g:5566:2: iv_ruleOutlierTreatment= ruleOutlierTreatment EOF
            {
             newCompositeNode(grammarAccess.getOutlierTreatmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutlierTreatment=ruleOutlierTreatment();

            state._fsp--;

             current =iv_ruleOutlierTreatment; 
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
    // $ANTLR end "entryRuleOutlierTreatment"


    // $ANTLR start "ruleOutlierTreatment"
    // InternalWorkflowDSL.g:5572:1: ruleOutlierTreatment returns [EObject current=null] : (otherlv_0= 'outliers' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_strategy_5_0= ruleOutlierStrategy ) ) otherlv_6= '}' ) ;
    public final EObject ruleOutlierTreatment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_columns_2_0 = null;

        EObject lv_strategy_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5578:2: ( (otherlv_0= 'outliers' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_strategy_5_0= ruleOutlierStrategy ) ) otherlv_6= '}' ) )
            // InternalWorkflowDSL.g:5579:2: (otherlv_0= 'outliers' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_strategy_5_0= ruleOutlierStrategy ) ) otherlv_6= '}' )
            {
            // InternalWorkflowDSL.g:5579:2: (otherlv_0= 'outliers' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_strategy_5_0= ruleOutlierStrategy ) ) otherlv_6= '}' )
            // InternalWorkflowDSL.g:5580:3: otherlv_0= 'outliers' otherlv_1= '(' ( (lv_columns_2_0= ruleColumnList ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_strategy_5_0= ruleOutlierStrategy ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,120,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getOutlierTreatmentAccess().getOutliersKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getOutlierTreatmentAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:5588:3: ( (lv_columns_2_0= ruleColumnList ) )
            // InternalWorkflowDSL.g:5589:4: (lv_columns_2_0= ruleColumnList )
            {
            // InternalWorkflowDSL.g:5589:4: (lv_columns_2_0= ruleColumnList )
            // InternalWorkflowDSL.g:5590:5: lv_columns_2_0= ruleColumnList
            {

            					newCompositeNode(grammarAccess.getOutlierTreatmentAccess().getColumnsColumnListParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_columns_2_0=ruleColumnList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutlierTreatmentRule());
            					}
            					set(
            						current,
            						"columns",
            						lv_columns_2_0,
            						"xtext.json.WorkflowDSL.ColumnList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getOutlierTreatmentAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_63); 

            			newLeafNode(otherlv_4, grammarAccess.getOutlierTreatmentAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalWorkflowDSL.g:5615:3: ( (lv_strategy_5_0= ruleOutlierStrategy ) )
            // InternalWorkflowDSL.g:5616:4: (lv_strategy_5_0= ruleOutlierStrategy )
            {
            // InternalWorkflowDSL.g:5616:4: (lv_strategy_5_0= ruleOutlierStrategy )
            // InternalWorkflowDSL.g:5617:5: lv_strategy_5_0= ruleOutlierStrategy
            {

            					newCompositeNode(grammarAccess.getOutlierTreatmentAccess().getStrategyOutlierStrategyParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_strategy_5_0=ruleOutlierStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutlierTreatmentRule());
            					}
            					set(
            						current,
            						"strategy",
            						lv_strategy_5_0,
            						"xtext.json.WorkflowDSL.OutlierStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getOutlierTreatmentAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleOutlierTreatment"


    // $ANTLR start "entryRuleOutlierStrategy"
    // InternalWorkflowDSL.g:5642:1: entryRuleOutlierStrategy returns [EObject current=null] : iv_ruleOutlierStrategy= ruleOutlierStrategy EOF ;
    public final EObject entryRuleOutlierStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutlierStrategy = null;


        try {
            // InternalWorkflowDSL.g:5642:56: (iv_ruleOutlierStrategy= ruleOutlierStrategy EOF )
            // InternalWorkflowDSL.g:5643:2: iv_ruleOutlierStrategy= ruleOutlierStrategy EOF
            {
             newCompositeNode(grammarAccess.getOutlierStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutlierStrategy=ruleOutlierStrategy();

            state._fsp--;

             current =iv_ruleOutlierStrategy; 
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
    // $ANTLR end "entryRuleOutlierStrategy"


    // $ANTLR start "ruleOutlierStrategy"
    // InternalWorkflowDSL.g:5649:1: ruleOutlierStrategy returns [EObject current=null] : ( ( (lv_replacement_0_0= ruleReplacementStrategy ) ) ( (lv_method_1_0= ruleDetectionMethod ) ) ( (lv_options_2_0= ruleOutlierOptions ) )? ) ;
    public final EObject ruleOutlierStrategy() throws RecognitionException {
        EObject current = null;

        EObject lv_replacement_0_0 = null;

        EObject lv_method_1_0 = null;

        EObject lv_options_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5655:2: ( ( ( (lv_replacement_0_0= ruleReplacementStrategy ) ) ( (lv_method_1_0= ruleDetectionMethod ) ) ( (lv_options_2_0= ruleOutlierOptions ) )? ) )
            // InternalWorkflowDSL.g:5656:2: ( ( (lv_replacement_0_0= ruleReplacementStrategy ) ) ( (lv_method_1_0= ruleDetectionMethod ) ) ( (lv_options_2_0= ruleOutlierOptions ) )? )
            {
            // InternalWorkflowDSL.g:5656:2: ( ( (lv_replacement_0_0= ruleReplacementStrategy ) ) ( (lv_method_1_0= ruleDetectionMethod ) ) ( (lv_options_2_0= ruleOutlierOptions ) )? )
            // InternalWorkflowDSL.g:5657:3: ( (lv_replacement_0_0= ruleReplacementStrategy ) ) ( (lv_method_1_0= ruleDetectionMethod ) ) ( (lv_options_2_0= ruleOutlierOptions ) )?
            {
            // InternalWorkflowDSL.g:5657:3: ( (lv_replacement_0_0= ruleReplacementStrategy ) )
            // InternalWorkflowDSL.g:5658:4: (lv_replacement_0_0= ruleReplacementStrategy )
            {
            // InternalWorkflowDSL.g:5658:4: (lv_replacement_0_0= ruleReplacementStrategy )
            // InternalWorkflowDSL.g:5659:5: lv_replacement_0_0= ruleReplacementStrategy
            {

            					newCompositeNode(grammarAccess.getOutlierStrategyAccess().getReplacementReplacementStrategyParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_64);
            lv_replacement_0_0=ruleReplacementStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutlierStrategyRule());
            					}
            					set(
            						current,
            						"replacement",
            						lv_replacement_0_0,
            						"xtext.json.WorkflowDSL.ReplacementStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:5676:3: ( (lv_method_1_0= ruleDetectionMethod ) )
            // InternalWorkflowDSL.g:5677:4: (lv_method_1_0= ruleDetectionMethod )
            {
            // InternalWorkflowDSL.g:5677:4: (lv_method_1_0= ruleDetectionMethod )
            // InternalWorkflowDSL.g:5678:5: lv_method_1_0= ruleDetectionMethod
            {

            					newCompositeNode(grammarAccess.getOutlierStrategyAccess().getMethodDetectionMethodParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_65);
            lv_method_1_0=ruleDetectionMethod();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutlierStrategyRule());
            					}
            					set(
            						current,
            						"method",
            						lv_method_1_0,
            						"xtext.json.WorkflowDSL.DetectionMethod");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:5695:3: ( (lv_options_2_0= ruleOutlierOptions ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==137) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalWorkflowDSL.g:5696:4: (lv_options_2_0= ruleOutlierOptions )
                    {
                    // InternalWorkflowDSL.g:5696:4: (lv_options_2_0= ruleOutlierOptions )
                    // InternalWorkflowDSL.g:5697:5: lv_options_2_0= ruleOutlierOptions
                    {

                    					newCompositeNode(grammarAccess.getOutlierStrategyAccess().getOptionsOutlierOptionsParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_options_2_0=ruleOutlierOptions();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOutlierStrategyRule());
                    					}
                    					set(
                    						current,
                    						"options",
                    						lv_options_2_0,
                    						"xtext.json.WorkflowDSL.OutlierOptions");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleOutlierStrategy"


    // $ANTLR start "entryRuleReplacementStrategy"
    // InternalWorkflowDSL.g:5718:1: entryRuleReplacementStrategy returns [EObject current=null] : iv_ruleReplacementStrategy= ruleReplacementStrategy EOF ;
    public final EObject entryRuleReplacementStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacementStrategy = null;


        try {
            // InternalWorkflowDSL.g:5718:60: (iv_ruleReplacementStrategy= ruleReplacementStrategy EOF )
            // InternalWorkflowDSL.g:5719:2: iv_ruleReplacementStrategy= ruleReplacementStrategy EOF
            {
             newCompositeNode(grammarAccess.getReplacementStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReplacementStrategy=ruleReplacementStrategy();

            state._fsp--;

             current =iv_ruleReplacementStrategy; 
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
    // $ANTLR end "entryRuleReplacementStrategy"


    // $ANTLR start "ruleReplacementStrategy"
    // InternalWorkflowDSL.g:5725:1: ruleReplacementStrategy returns [EObject current=null] : (otherlv_0= 'replace_closest' | otherlv_1= 'replace_missing' | otherlv_2= 'replace_by_closest' | (otherlv_3= 'replace_with' otherlv_4= '=' ( (lv_value_5_0= ruleNumber ) ) ) | otherlv_6= 'remove' | otherlv_7= 'cap' ) ;
    public final EObject ruleReplacementStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5731:2: ( (otherlv_0= 'replace_closest' | otherlv_1= 'replace_missing' | otherlv_2= 'replace_by_closest' | (otherlv_3= 'replace_with' otherlv_4= '=' ( (lv_value_5_0= ruleNumber ) ) ) | otherlv_6= 'remove' | otherlv_7= 'cap' ) )
            // InternalWorkflowDSL.g:5732:2: (otherlv_0= 'replace_closest' | otherlv_1= 'replace_missing' | otherlv_2= 'replace_by_closest' | (otherlv_3= 'replace_with' otherlv_4= '=' ( (lv_value_5_0= ruleNumber ) ) ) | otherlv_6= 'remove' | otherlv_7= 'cap' )
            {
            // InternalWorkflowDSL.g:5732:2: (otherlv_0= 'replace_closest' | otherlv_1= 'replace_missing' | otherlv_2= 'replace_by_closest' | (otherlv_3= 'replace_with' otherlv_4= '=' ( (lv_value_5_0= ruleNumber ) ) ) | otherlv_6= 'remove' | otherlv_7= 'cap' )
            int alt61=6;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt61=1;
                }
                break;
            case 122:
                {
                alt61=2;
                }
                break;
            case 123:
                {
                alt61=3;
                }
                break;
            case 124:
                {
                alt61=4;
                }
                break;
            case 66:
                {
                alt61=5;
                }
                break;
            case 125:
                {
                alt61=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalWorkflowDSL.g:5733:3: otherlv_0= 'replace_closest'
                    {
                    otherlv_0=(Token)match(input,121,FOLLOW_2); 

                    			newLeafNode(otherlv_0, grammarAccess.getReplacementStrategyAccess().getReplace_closestKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5738:3: otherlv_1= 'replace_missing'
                    {
                    otherlv_1=(Token)match(input,122,FOLLOW_2); 

                    			newLeafNode(otherlv_1, grammarAccess.getReplacementStrategyAccess().getReplace_missingKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5743:3: otherlv_2= 'replace_by_closest'
                    {
                    otherlv_2=(Token)match(input,123,FOLLOW_2); 

                    			newLeafNode(otherlv_2, grammarAccess.getReplacementStrategyAccess().getReplace_by_closestKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:5748:3: (otherlv_3= 'replace_with' otherlv_4= '=' ( (lv_value_5_0= ruleNumber ) ) )
                    {
                    // InternalWorkflowDSL.g:5748:3: (otherlv_3= 'replace_with' otherlv_4= '=' ( (lv_value_5_0= ruleNumber ) ) )
                    // InternalWorkflowDSL.g:5749:4: otherlv_3= 'replace_with' otherlv_4= '=' ( (lv_value_5_0= ruleNumber ) )
                    {
                    otherlv_3=(Token)match(input,124,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getReplacementStrategyAccess().getReplace_withKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_61); 

                    				newLeafNode(otherlv_4, grammarAccess.getReplacementStrategyAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalWorkflowDSL.g:5757:4: ( (lv_value_5_0= ruleNumber ) )
                    // InternalWorkflowDSL.g:5758:5: (lv_value_5_0= ruleNumber )
                    {
                    // InternalWorkflowDSL.g:5758:5: (lv_value_5_0= ruleNumber )
                    // InternalWorkflowDSL.g:5759:6: lv_value_5_0= ruleNumber
                    {

                    						newCompositeNode(grammarAccess.getReplacementStrategyAccess().getValueNumberParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleNumber();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReplacementStrategyRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"xtext.json.WorkflowDSL.Number");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:5778:3: otherlv_6= 'remove'
                    {
                    otherlv_6=(Token)match(input,66,FOLLOW_2); 

                    			newLeafNode(otherlv_6, grammarAccess.getReplacementStrategyAccess().getRemoveKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflowDSL.g:5783:3: otherlv_7= 'cap'
                    {
                    otherlv_7=(Token)match(input,125,FOLLOW_2); 

                    			newLeafNode(otherlv_7, grammarAccess.getReplacementStrategyAccess().getCapKeyword_5());
                    		

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
    // $ANTLR end "ruleReplacementStrategy"


    // $ANTLR start "entryRuleDetectionMethod"
    // InternalWorkflowDSL.g:5791:1: entryRuleDetectionMethod returns [EObject current=null] : iv_ruleDetectionMethod= ruleDetectionMethod EOF ;
    public final EObject entryRuleDetectionMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetectionMethod = null;


        try {
            // InternalWorkflowDSL.g:5791:56: (iv_ruleDetectionMethod= ruleDetectionMethod EOF )
            // InternalWorkflowDSL.g:5792:2: iv_ruleDetectionMethod= ruleDetectionMethod EOF
            {
             newCompositeNode(grammarAccess.getDetectionMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDetectionMethod=ruleDetectionMethod();

            state._fsp--;

             current =iv_ruleDetectionMethod; 
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
    // $ANTLR end "entryRuleDetectionMethod"


    // $ANTLR start "ruleDetectionMethod"
    // InternalWorkflowDSL.g:5798:1: ruleDetectionMethod returns [EObject current=null] : (this_IQRMethod_0= ruleIQRMethod | this_ZScoreMethod_1= ruleZScoreMethod | this_PercentileMethod_2= rulePercentileMethod ) ;
    public final EObject ruleDetectionMethod() throws RecognitionException {
        EObject current = null;

        EObject this_IQRMethod_0 = null;

        EObject this_ZScoreMethod_1 = null;

        EObject this_PercentileMethod_2 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5804:2: ( (this_IQRMethod_0= ruleIQRMethod | this_ZScoreMethod_1= ruleZScoreMethod | this_PercentileMethod_2= rulePercentileMethod ) )
            // InternalWorkflowDSL.g:5805:2: (this_IQRMethod_0= ruleIQRMethod | this_ZScoreMethod_1= ruleZScoreMethod | this_PercentileMethod_2= rulePercentileMethod )
            {
            // InternalWorkflowDSL.g:5805:2: (this_IQRMethod_0= ruleIQRMethod | this_ZScoreMethod_1= ruleZScoreMethod | this_PercentileMethod_2= rulePercentileMethod )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 126:
                {
                alt62=1;
                }
                break;
            case 132:
                {
                alt62=2;
                }
                break;
            case 134:
                {
                alt62=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalWorkflowDSL.g:5806:3: this_IQRMethod_0= ruleIQRMethod
                    {

                    			newCompositeNode(grammarAccess.getDetectionMethodAccess().getIQRMethodParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IQRMethod_0=ruleIQRMethod();

                    state._fsp--;


                    			current = this_IQRMethod_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5815:3: this_ZScoreMethod_1= ruleZScoreMethod
                    {

                    			newCompositeNode(grammarAccess.getDetectionMethodAccess().getZScoreMethodParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ZScoreMethod_1=ruleZScoreMethod();

                    state._fsp--;


                    			current = this_ZScoreMethod_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5824:3: this_PercentileMethod_2= rulePercentileMethod
                    {

                    			newCompositeNode(grammarAccess.getDetectionMethodAccess().getPercentileMethodParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PercentileMethod_2=rulePercentileMethod();

                    state._fsp--;


                    			current = this_PercentileMethod_2;
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
    // $ANTLR end "ruleDetectionMethod"


    // $ANTLR start "entryRuleIQRMethod"
    // InternalWorkflowDSL.g:5836:1: entryRuleIQRMethod returns [EObject current=null] : iv_ruleIQRMethod= ruleIQRMethod EOF ;
    public final EObject entryRuleIQRMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIQRMethod = null;


        try {
            // InternalWorkflowDSL.g:5836:50: (iv_ruleIQRMethod= ruleIQRMethod EOF )
            // InternalWorkflowDSL.g:5837:2: iv_ruleIQRMethod= ruleIQRMethod EOF
            {
             newCompositeNode(grammarAccess.getIQRMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIQRMethod=ruleIQRMethod();

            state._fsp--;

             current =iv_ruleIQRMethod; 
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
    // $ANTLR end "entryRuleIQRMethod"


    // $ANTLR start "ruleIQRMethod"
    // InternalWorkflowDSL.g:5843:1: ruleIQRMethod returns [EObject current=null] : (otherlv_0= 'iqr' ( (lv_params_1_0= ruleIQRParams ) )? ) ;
    public final EObject ruleIQRMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_params_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5849:2: ( (otherlv_0= 'iqr' ( (lv_params_1_0= ruleIQRParams ) )? ) )
            // InternalWorkflowDSL.g:5850:2: (otherlv_0= 'iqr' ( (lv_params_1_0= ruleIQRParams ) )? )
            {
            // InternalWorkflowDSL.g:5850:2: (otherlv_0= 'iqr' ( (lv_params_1_0= ruleIQRParams ) )? )
            // InternalWorkflowDSL.g:5851:3: otherlv_0= 'iqr' ( (lv_params_1_0= ruleIQRParams ) )?
            {
            otherlv_0=(Token)match(input,126,FOLLOW_66); 

            			newLeafNode(otherlv_0, grammarAccess.getIQRMethodAccess().getIqrKeyword_0());
            		
            // InternalWorkflowDSL.g:5855:3: ( (lv_params_1_0= ruleIQRParams ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=127 && LA63_0<=128)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalWorkflowDSL.g:5856:4: (lv_params_1_0= ruleIQRParams )
                    {
                    // InternalWorkflowDSL.g:5856:4: (lv_params_1_0= ruleIQRParams )
                    // InternalWorkflowDSL.g:5857:5: lv_params_1_0= ruleIQRParams
                    {

                    					newCompositeNode(grammarAccess.getIQRMethodAccess().getParamsIQRParamsParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_params_1_0=ruleIQRParams();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIQRMethodRule());
                    					}
                    					set(
                    						current,
                    						"params",
                    						lv_params_1_0,
                    						"xtext.json.WorkflowDSL.IQRParams");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleIQRMethod"


    // $ANTLR start "entryRuleIQRParams"
    // InternalWorkflowDSL.g:5878:1: entryRuleIQRParams returns [EObject current=null] : iv_ruleIQRParams= ruleIQRParams EOF ;
    public final EObject entryRuleIQRParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIQRParams = null;


        try {
            // InternalWorkflowDSL.g:5878:50: (iv_ruleIQRParams= ruleIQRParams EOF )
            // InternalWorkflowDSL.g:5879:2: iv_ruleIQRParams= ruleIQRParams EOF
            {
             newCompositeNode(grammarAccess.getIQRParamsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIQRParams=ruleIQRParams();

            state._fsp--;

             current =iv_ruleIQRParams; 
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
    // $ANTLR end "entryRuleIQRParams"


    // $ANTLR start "ruleIQRParams"
    // InternalWorkflowDSL.g:5885:1: ruleIQRParams returns [EObject current=null] : ( (otherlv_0= 'scalar' otherlv_1= '=' ( (lv_scalar_2_0= ruleNumber ) ) ) | (otherlv_3= 'estimation' otherlv_4= '=' ( (lv_estimation_5_0= ruleEstimationType ) ) ) ) ;
    public final EObject ruleIQRParams() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_scalar_2_0 = null;

        AntlrDatatypeRuleToken lv_estimation_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:5891:2: ( ( (otherlv_0= 'scalar' otherlv_1= '=' ( (lv_scalar_2_0= ruleNumber ) ) ) | (otherlv_3= 'estimation' otherlv_4= '=' ( (lv_estimation_5_0= ruleEstimationType ) ) ) ) )
            // InternalWorkflowDSL.g:5892:2: ( (otherlv_0= 'scalar' otherlv_1= '=' ( (lv_scalar_2_0= ruleNumber ) ) ) | (otherlv_3= 'estimation' otherlv_4= '=' ( (lv_estimation_5_0= ruleEstimationType ) ) ) )
            {
            // InternalWorkflowDSL.g:5892:2: ( (otherlv_0= 'scalar' otherlv_1= '=' ( (lv_scalar_2_0= ruleNumber ) ) ) | (otherlv_3= 'estimation' otherlv_4= '=' ( (lv_estimation_5_0= ruleEstimationType ) ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==127) ) {
                alt64=1;
            }
            else if ( (LA64_0==128) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalWorkflowDSL.g:5893:3: (otherlv_0= 'scalar' otherlv_1= '=' ( (lv_scalar_2_0= ruleNumber ) ) )
                    {
                    // InternalWorkflowDSL.g:5893:3: (otherlv_0= 'scalar' otherlv_1= '=' ( (lv_scalar_2_0= ruleNumber ) ) )
                    // InternalWorkflowDSL.g:5894:4: otherlv_0= 'scalar' otherlv_1= '=' ( (lv_scalar_2_0= ruleNumber ) )
                    {
                    otherlv_0=(Token)match(input,127,FOLLOW_9); 

                    				newLeafNode(otherlv_0, grammarAccess.getIQRParamsAccess().getScalarKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_61); 

                    				newLeafNode(otherlv_1, grammarAccess.getIQRParamsAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:5902:4: ( (lv_scalar_2_0= ruleNumber ) )
                    // InternalWorkflowDSL.g:5903:5: (lv_scalar_2_0= ruleNumber )
                    {
                    // InternalWorkflowDSL.g:5903:5: (lv_scalar_2_0= ruleNumber )
                    // InternalWorkflowDSL.g:5904:6: lv_scalar_2_0= ruleNumber
                    {

                    						newCompositeNode(grammarAccess.getIQRParamsAccess().getScalarNumberParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_scalar_2_0=ruleNumber();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIQRParamsRule());
                    						}
                    						set(
                    							current,
                    							"scalar",
                    							lv_scalar_2_0,
                    							"xtext.json.WorkflowDSL.Number");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5923:3: (otherlv_3= 'estimation' otherlv_4= '=' ( (lv_estimation_5_0= ruleEstimationType ) ) )
                    {
                    // InternalWorkflowDSL.g:5923:3: (otherlv_3= 'estimation' otherlv_4= '=' ( (lv_estimation_5_0= ruleEstimationType ) ) )
                    // InternalWorkflowDSL.g:5924:4: otherlv_3= 'estimation' otherlv_4= '=' ( (lv_estimation_5_0= ruleEstimationType ) )
                    {
                    otherlv_3=(Token)match(input,128,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getIQRParamsAccess().getEstimationKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_67); 

                    				newLeafNode(otherlv_4, grammarAccess.getIQRParamsAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:5932:4: ( (lv_estimation_5_0= ruleEstimationType ) )
                    // InternalWorkflowDSL.g:5933:5: (lv_estimation_5_0= ruleEstimationType )
                    {
                    // InternalWorkflowDSL.g:5933:5: (lv_estimation_5_0= ruleEstimationType )
                    // InternalWorkflowDSL.g:5934:6: lv_estimation_5_0= ruleEstimationType
                    {

                    						newCompositeNode(grammarAccess.getIQRParamsAccess().getEstimationEstimationTypeParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_estimation_5_0=ruleEstimationType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIQRParamsRule());
                    						}
                    						set(
                    							current,
                    							"estimation",
                    							lv_estimation_5_0,
                    							"xtext.json.WorkflowDSL.EstimationType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleIQRParams"


    // $ANTLR start "entryRuleEstimationType"
    // InternalWorkflowDSL.g:5956:1: entryRuleEstimationType returns [String current=null] : iv_ruleEstimationType= ruleEstimationType EOF ;
    public final String entryRuleEstimationType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEstimationType = null;


        try {
            // InternalWorkflowDSL.g:5956:54: (iv_ruleEstimationType= ruleEstimationType EOF )
            // InternalWorkflowDSL.g:5957:2: iv_ruleEstimationType= ruleEstimationType EOF
            {
             newCompositeNode(grammarAccess.getEstimationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEstimationType=ruleEstimationType();

            state._fsp--;

             current =iv_ruleEstimationType.getText(); 
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
    // $ANTLR end "entryRuleEstimationType"


    // $ANTLR start "ruleEstimationType"
    // InternalWorkflowDSL.g:5963:1: ruleEstimationType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'R_4' | kw= 'R_7' | kw= 'R_8' ) ;
    public final AntlrDatatypeRuleToken ruleEstimationType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:5969:2: ( (kw= 'R_4' | kw= 'R_7' | kw= 'R_8' ) )
            // InternalWorkflowDSL.g:5970:2: (kw= 'R_4' | kw= 'R_7' | kw= 'R_8' )
            {
            // InternalWorkflowDSL.g:5970:2: (kw= 'R_4' | kw= 'R_7' | kw= 'R_8' )
            int alt65=3;
            switch ( input.LA(1) ) {
            case 129:
                {
                alt65=1;
                }
                break;
            case 130:
                {
                alt65=2;
                }
                break;
            case 131:
                {
                alt65=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalWorkflowDSL.g:5971:3: kw= 'R_4'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEstimationTypeAccess().getR_4Keyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:5977:3: kw= 'R_7'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEstimationTypeAccess().getR_7Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:5983:3: kw= 'R_8'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEstimationTypeAccess().getR_8Keyword_2());
                    		

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
    // $ANTLR end "ruleEstimationType"


    // $ANTLR start "entryRuleZScoreMethod"
    // InternalWorkflowDSL.g:5992:1: entryRuleZScoreMethod returns [EObject current=null] : iv_ruleZScoreMethod= ruleZScoreMethod EOF ;
    public final EObject entryRuleZScoreMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleZScoreMethod = null;


        try {
            // InternalWorkflowDSL.g:5992:53: (iv_ruleZScoreMethod= ruleZScoreMethod EOF )
            // InternalWorkflowDSL.g:5993:2: iv_ruleZScoreMethod= ruleZScoreMethod EOF
            {
             newCompositeNode(grammarAccess.getZScoreMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleZScoreMethod=ruleZScoreMethod();

            state._fsp--;

             current =iv_ruleZScoreMethod; 
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
    // $ANTLR end "entryRuleZScoreMethod"


    // $ANTLR start "ruleZScoreMethod"
    // InternalWorkflowDSL.g:5999:1: ruleZScoreMethod returns [EObject current=null] : (otherlv_0= 'zscore' (otherlv_1= 'threshold' otherlv_2= '=' ( (lv_threshold_3_0= ruleNumber ) ) )? ) ;
    public final EObject ruleZScoreMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_threshold_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6005:2: ( (otherlv_0= 'zscore' (otherlv_1= 'threshold' otherlv_2= '=' ( (lv_threshold_3_0= ruleNumber ) ) )? ) )
            // InternalWorkflowDSL.g:6006:2: (otherlv_0= 'zscore' (otherlv_1= 'threshold' otherlv_2= '=' ( (lv_threshold_3_0= ruleNumber ) ) )? )
            {
            // InternalWorkflowDSL.g:6006:2: (otherlv_0= 'zscore' (otherlv_1= 'threshold' otherlv_2= '=' ( (lv_threshold_3_0= ruleNumber ) ) )? )
            // InternalWorkflowDSL.g:6007:3: otherlv_0= 'zscore' (otherlv_1= 'threshold' otherlv_2= '=' ( (lv_threshold_3_0= ruleNumber ) ) )?
            {
            otherlv_0=(Token)match(input,132,FOLLOW_68); 

            			newLeafNode(otherlv_0, grammarAccess.getZScoreMethodAccess().getZscoreKeyword_0());
            		
            // InternalWorkflowDSL.g:6011:3: (otherlv_1= 'threshold' otherlv_2= '=' ( (lv_threshold_3_0= ruleNumber ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==133) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalWorkflowDSL.g:6012:4: otherlv_1= 'threshold' otherlv_2= '=' ( (lv_threshold_3_0= ruleNumber ) )
                    {
                    otherlv_1=(Token)match(input,133,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getZScoreMethodAccess().getThresholdKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,16,FOLLOW_61); 

                    				newLeafNode(otherlv_2, grammarAccess.getZScoreMethodAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:6020:4: ( (lv_threshold_3_0= ruleNumber ) )
                    // InternalWorkflowDSL.g:6021:5: (lv_threshold_3_0= ruleNumber )
                    {
                    // InternalWorkflowDSL.g:6021:5: (lv_threshold_3_0= ruleNumber )
                    // InternalWorkflowDSL.g:6022:6: lv_threshold_3_0= ruleNumber
                    {

                    						newCompositeNode(grammarAccess.getZScoreMethodAccess().getThresholdNumberParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_threshold_3_0=ruleNumber();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getZScoreMethodRule());
                    						}
                    						set(
                    							current,
                    							"threshold",
                    							lv_threshold_3_0,
                    							"xtext.json.WorkflowDSL.Number");
                    						afterParserOrEnumRuleCall();
                    					

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
    // $ANTLR end "ruleZScoreMethod"


    // $ANTLR start "entryRulePercentileMethod"
    // InternalWorkflowDSL.g:6044:1: entryRulePercentileMethod returns [EObject current=null] : iv_rulePercentileMethod= rulePercentileMethod EOF ;
    public final EObject entryRulePercentileMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercentileMethod = null;


        try {
            // InternalWorkflowDSL.g:6044:57: (iv_rulePercentileMethod= rulePercentileMethod EOF )
            // InternalWorkflowDSL.g:6045:2: iv_rulePercentileMethod= rulePercentileMethod EOF
            {
             newCompositeNode(grammarAccess.getPercentileMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePercentileMethod=rulePercentileMethod();

            state._fsp--;

             current =iv_rulePercentileMethod; 
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
    // $ANTLR end "entryRulePercentileMethod"


    // $ANTLR start "rulePercentileMethod"
    // InternalWorkflowDSL.g:6051:1: rulePercentileMethod returns [EObject current=null] : (otherlv_0= 'percentile' otherlv_1= 'lower' otherlv_2= '=' ( (lv_lower_3_0= ruleNumber ) ) otherlv_4= 'upper' otherlv_5= '=' ( (lv_upper_6_0= ruleNumber ) ) ) ;
    public final EObject rulePercentileMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lower_3_0 = null;

        AntlrDatatypeRuleToken lv_upper_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6057:2: ( (otherlv_0= 'percentile' otherlv_1= 'lower' otherlv_2= '=' ( (lv_lower_3_0= ruleNumber ) ) otherlv_4= 'upper' otherlv_5= '=' ( (lv_upper_6_0= ruleNumber ) ) ) )
            // InternalWorkflowDSL.g:6058:2: (otherlv_0= 'percentile' otherlv_1= 'lower' otherlv_2= '=' ( (lv_lower_3_0= ruleNumber ) ) otherlv_4= 'upper' otherlv_5= '=' ( (lv_upper_6_0= ruleNumber ) ) )
            {
            // InternalWorkflowDSL.g:6058:2: (otherlv_0= 'percentile' otherlv_1= 'lower' otherlv_2= '=' ( (lv_lower_3_0= ruleNumber ) ) otherlv_4= 'upper' otherlv_5= '=' ( (lv_upper_6_0= ruleNumber ) ) )
            // InternalWorkflowDSL.g:6059:3: otherlv_0= 'percentile' otherlv_1= 'lower' otherlv_2= '=' ( (lv_lower_3_0= ruleNumber ) ) otherlv_4= 'upper' otherlv_5= '=' ( (lv_upper_6_0= ruleNumber ) )
            {
            otherlv_0=(Token)match(input,134,FOLLOW_69); 

            			newLeafNode(otherlv_0, grammarAccess.getPercentileMethodAccess().getPercentileKeyword_0());
            		
            otherlv_1=(Token)match(input,135,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getPercentileMethodAccess().getLowerKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_61); 

            			newLeafNode(otherlv_2, grammarAccess.getPercentileMethodAccess().getEqualsSignKeyword_2());
            		
            // InternalWorkflowDSL.g:6071:3: ( (lv_lower_3_0= ruleNumber ) )
            // InternalWorkflowDSL.g:6072:4: (lv_lower_3_0= ruleNumber )
            {
            // InternalWorkflowDSL.g:6072:4: (lv_lower_3_0= ruleNumber )
            // InternalWorkflowDSL.g:6073:5: lv_lower_3_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getPercentileMethodAccess().getLowerNumberParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_70);
            lv_lower_3_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPercentileMethodRule());
            					}
            					set(
            						current,
            						"lower",
            						lv_lower_3_0,
            						"xtext.json.WorkflowDSL.Number");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,136,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getPercentileMethodAccess().getUpperKeyword_4());
            		
            otherlv_5=(Token)match(input,16,FOLLOW_61); 

            			newLeafNode(otherlv_5, grammarAccess.getPercentileMethodAccess().getEqualsSignKeyword_5());
            		
            // InternalWorkflowDSL.g:6098:3: ( (lv_upper_6_0= ruleNumber ) )
            // InternalWorkflowDSL.g:6099:4: (lv_upper_6_0= ruleNumber )
            {
            // InternalWorkflowDSL.g:6099:4: (lv_upper_6_0= ruleNumber )
            // InternalWorkflowDSL.g:6100:5: lv_upper_6_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getPercentileMethodAccess().getUpperNumberParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_upper_6_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPercentileMethodRule());
            					}
            					set(
            						current,
            						"upper",
            						lv_upper_6_0,
            						"xtext.json.WorkflowDSL.Number");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "rulePercentileMethod"


    // $ANTLR start "entryRuleOutlierOptions"
    // InternalWorkflowDSL.g:6121:1: entryRuleOutlierOptions returns [EObject current=null] : iv_ruleOutlierOptions= ruleOutlierOptions EOF ;
    public final EObject entryRuleOutlierOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutlierOptions = null;


        try {
            // InternalWorkflowDSL.g:6121:55: (iv_ruleOutlierOptions= ruleOutlierOptions EOF )
            // InternalWorkflowDSL.g:6122:2: iv_ruleOutlierOptions= ruleOutlierOptions EOF
            {
             newCompositeNode(grammarAccess.getOutlierOptionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutlierOptions=ruleOutlierOptions();

            state._fsp--;

             current =iv_ruleOutlierOptions; 
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
    // $ANTLR end "entryRuleOutlierOptions"


    // $ANTLR start "ruleOutlierOptions"
    // InternalWorkflowDSL.g:6128:1: ruleOutlierOptions returns [EObject current=null] : (otherlv_0= 'scope' otherlv_1= '=' ( (lv_scope_2_0= ruleOutlierScope ) ) ) ;
    public final EObject ruleOutlierOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_scope_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6134:2: ( (otherlv_0= 'scope' otherlv_1= '=' ( (lv_scope_2_0= ruleOutlierScope ) ) ) )
            // InternalWorkflowDSL.g:6135:2: (otherlv_0= 'scope' otherlv_1= '=' ( (lv_scope_2_0= ruleOutlierScope ) ) )
            {
            // InternalWorkflowDSL.g:6135:2: (otherlv_0= 'scope' otherlv_1= '=' ( (lv_scope_2_0= ruleOutlierScope ) ) )
            // InternalWorkflowDSL.g:6136:3: otherlv_0= 'scope' otherlv_1= '=' ( (lv_scope_2_0= ruleOutlierScope ) )
            {
            otherlv_0=(Token)match(input,137,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getOutlierOptionsAccess().getScopeKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_71); 

            			newLeafNode(otherlv_1, grammarAccess.getOutlierOptionsAccess().getEqualsSignKeyword_1());
            		
            // InternalWorkflowDSL.g:6144:3: ( (lv_scope_2_0= ruleOutlierScope ) )
            // InternalWorkflowDSL.g:6145:4: (lv_scope_2_0= ruleOutlierScope )
            {
            // InternalWorkflowDSL.g:6145:4: (lv_scope_2_0= ruleOutlierScope )
            // InternalWorkflowDSL.g:6146:5: lv_scope_2_0= ruleOutlierScope
            {

            					newCompositeNode(grammarAccess.getOutlierOptionsAccess().getScopeOutlierScopeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_scope_2_0=ruleOutlierScope();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutlierOptionsRule());
            					}
            					set(
            						current,
            						"scope",
            						lv_scope_2_0,
            						"xtext.json.WorkflowDSL.OutlierScope");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleOutlierOptions"


    // $ANTLR start "entryRuleOutlierScope"
    // InternalWorkflowDSL.g:6167:1: entryRuleOutlierScope returns [String current=null] : iv_ruleOutlierScope= ruleOutlierScope EOF ;
    public final String entryRuleOutlierScope() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOutlierScope = null;


        try {
            // InternalWorkflowDSL.g:6167:52: (iv_ruleOutlierScope= ruleOutlierScope EOF )
            // InternalWorkflowDSL.g:6168:2: iv_ruleOutlierScope= ruleOutlierScope EOF
            {
             newCompositeNode(grammarAccess.getOutlierScopeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutlierScope=ruleOutlierScope();

            state._fsp--;

             current =iv_ruleOutlierScope.getText(); 
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
    // $ANTLR end "entryRuleOutlierScope"


    // $ANTLR start "ruleOutlierScope"
    // InternalWorkflowDSL.g:6174:1: ruleOutlierScope returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'all' | kw= 'all_outliers' | kw= 'lower_only' | kw= 'upper_only' ) ;
    public final AntlrDatatypeRuleToken ruleOutlierScope() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:6180:2: ( (kw= 'all' | kw= 'all_outliers' | kw= 'lower_only' | kw= 'upper_only' ) )
            // InternalWorkflowDSL.g:6181:2: (kw= 'all' | kw= 'all_outliers' | kw= 'lower_only' | kw= 'upper_only' )
            {
            // InternalWorkflowDSL.g:6181:2: (kw= 'all' | kw= 'all_outliers' | kw= 'lower_only' | kw= 'upper_only' )
            int alt67=4;
            switch ( input.LA(1) ) {
            case 138:
                {
                alt67=1;
                }
                break;
            case 139:
                {
                alt67=2;
                }
                break;
            case 140:
                {
                alt67=3;
                }
                break;
            case 141:
                {
                alt67=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalWorkflowDSL.g:6182:3: kw= 'all'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOutlierScopeAccess().getAllKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:6188:3: kw= 'all_outliers'
                    {
                    kw=(Token)match(input,139,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOutlierScopeAccess().getAll_outliersKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:6194:3: kw= 'lower_only'
                    {
                    kw=(Token)match(input,140,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOutlierScopeAccess().getLower_onlyKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:6200:3: kw= 'upper_only'
                    {
                    kw=(Token)match(input,141,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOutlierScopeAccess().getUpper_onlyKeyword_3());
                    		

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
    // $ANTLR end "ruleOutlierScope"


    // $ANTLR start "entryRuleJoin"
    // InternalWorkflowDSL.g:6209:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalWorkflowDSL.g:6209:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalWorkflowDSL.g:6210:2: iv_ruleJoin= ruleJoin EOF
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
    // InternalWorkflowDSL.g:6216:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_left_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_right_4_0= RULE_ID ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_spec_7_0= ruleJoinSpec ) ) otherlv_8= '}' ) ;
    public final EObject ruleJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_left_2_0=null;
        Token otherlv_3=null;
        Token lv_right_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_spec_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6222:2: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_left_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_right_4_0= RULE_ID ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_spec_7_0= ruleJoinSpec ) ) otherlv_8= '}' ) )
            // InternalWorkflowDSL.g:6223:2: (otherlv_0= 'join' otherlv_1= '(' ( (lv_left_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_right_4_0= RULE_ID ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_spec_7_0= ruleJoinSpec ) ) otherlv_8= '}' )
            {
            // InternalWorkflowDSL.g:6223:2: (otherlv_0= 'join' otherlv_1= '(' ( (lv_left_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_right_4_0= RULE_ID ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_spec_7_0= ruleJoinSpec ) ) otherlv_8= '}' )
            // InternalWorkflowDSL.g:6224:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_left_2_0= RULE_ID ) ) otherlv_3= ',' ( (lv_right_4_0= RULE_ID ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_spec_7_0= ruleJoinSpec ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,142,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
            		
            // InternalWorkflowDSL.g:6232:3: ( (lv_left_2_0= RULE_ID ) )
            // InternalWorkflowDSL.g:6233:4: (lv_left_2_0= RULE_ID )
            {
            // InternalWorkflowDSL.g:6233:4: (lv_left_2_0= RULE_ID )
            // InternalWorkflowDSL.g:6234:5: lv_left_2_0= RULE_ID
            {
            lv_left_2_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_left_2_0, grammarAccess.getJoinAccess().getLeftIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
            		
            // InternalWorkflowDSL.g:6254:3: ( (lv_right_4_0= RULE_ID ) )
            // InternalWorkflowDSL.g:6255:4: (lv_right_4_0= RULE_ID )
            {
            // InternalWorkflowDSL.g:6255:4: (lv_right_4_0= RULE_ID )
            // InternalWorkflowDSL.g:6256:5: lv_right_4_0= RULE_ID
            {
            lv_right_4_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_right_4_0, grammarAccess.getJoinAccess().getRightIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"right",
            						lv_right_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
            		
            otherlv_6=(Token)match(input,13,FOLLOW_72); 

            			newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalWorkflowDSL.g:6280:3: ( (lv_spec_7_0= ruleJoinSpec ) )
            // InternalWorkflowDSL.g:6281:4: (lv_spec_7_0= ruleJoinSpec )
            {
            // InternalWorkflowDSL.g:6281:4: (lv_spec_7_0= ruleJoinSpec )
            // InternalWorkflowDSL.g:6282:5: lv_spec_7_0= ruleJoinSpec
            {

            					newCompositeNode(grammarAccess.getJoinAccess().getSpecJoinSpecParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_7);
            lv_spec_7_0=ruleJoinSpec();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinRule());
            					}
            					set(
            						current,
            						"spec",
            						lv_spec_7_0,
            						"xtext.json.WorkflowDSL.JoinSpec");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleJoinSpec"
    // InternalWorkflowDSL.g:6307:1: entryRuleJoinSpec returns [EObject current=null] : iv_ruleJoinSpec= ruleJoinSpec EOF ;
    public final EObject entryRuleJoinSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinSpec = null;


        try {
            // InternalWorkflowDSL.g:6307:49: (iv_ruleJoinSpec= ruleJoinSpec EOF )
            // InternalWorkflowDSL.g:6308:2: iv_ruleJoinSpec= ruleJoinSpec EOF
            {
             newCompositeNode(grammarAccess.getJoinSpecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoinSpec=ruleJoinSpec();

            state._fsp--;

             current =iv_ruleJoinSpec; 
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
    // $ANTLR end "entryRuleJoinSpec"


    // $ANTLR start "ruleJoinSpec"
    // InternalWorkflowDSL.g:6314:1: ruleJoinSpec returns [EObject current=null] : ( ( (lv_type_0_0= ruleJoinType ) ) otherlv_1= 'on' ( (lv_conditions_2_0= ruleJoinConditions ) ) ( (lv_options_3_0= ruleJoinOptions ) )? ) ;
    public final EObject ruleJoinSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_conditions_2_0 = null;

        EObject lv_options_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6320:2: ( ( ( (lv_type_0_0= ruleJoinType ) ) otherlv_1= 'on' ( (lv_conditions_2_0= ruleJoinConditions ) ) ( (lv_options_3_0= ruleJoinOptions ) )? ) )
            // InternalWorkflowDSL.g:6321:2: ( ( (lv_type_0_0= ruleJoinType ) ) otherlv_1= 'on' ( (lv_conditions_2_0= ruleJoinConditions ) ) ( (lv_options_3_0= ruleJoinOptions ) )? )
            {
            // InternalWorkflowDSL.g:6321:2: ( ( (lv_type_0_0= ruleJoinType ) ) otherlv_1= 'on' ( (lv_conditions_2_0= ruleJoinConditions ) ) ( (lv_options_3_0= ruleJoinOptions ) )? )
            // InternalWorkflowDSL.g:6322:3: ( (lv_type_0_0= ruleJoinType ) ) otherlv_1= 'on' ( (lv_conditions_2_0= ruleJoinConditions ) ) ( (lv_options_3_0= ruleJoinOptions ) )?
            {
            // InternalWorkflowDSL.g:6322:3: ( (lv_type_0_0= ruleJoinType ) )
            // InternalWorkflowDSL.g:6323:4: (lv_type_0_0= ruleJoinType )
            {
            // InternalWorkflowDSL.g:6323:4: (lv_type_0_0= ruleJoinType )
            // InternalWorkflowDSL.g:6324:5: lv_type_0_0= ruleJoinType
            {

            					newCompositeNode(grammarAccess.getJoinSpecAccess().getTypeJoinTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_73);
            lv_type_0_0=ruleJoinType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinSpecRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"xtext.json.WorkflowDSL.JoinType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,143,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getJoinSpecAccess().getOnKeyword_1());
            		
            // InternalWorkflowDSL.g:6345:3: ( (lv_conditions_2_0= ruleJoinConditions ) )
            // InternalWorkflowDSL.g:6346:4: (lv_conditions_2_0= ruleJoinConditions )
            {
            // InternalWorkflowDSL.g:6346:4: (lv_conditions_2_0= ruleJoinConditions )
            // InternalWorkflowDSL.g:6347:5: lv_conditions_2_0= ruleJoinConditions
            {

            					newCompositeNode(grammarAccess.getJoinSpecAccess().getConditionsJoinConditionsParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_74);
            lv_conditions_2_0=ruleJoinConditions();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinSpecRule());
            					}
            					set(
            						current,
            						"conditions",
            						lv_conditions_2_0,
            						"xtext.json.WorkflowDSL.JoinConditions");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:6364:3: ( (lv_options_3_0= ruleJoinOptions ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==156) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalWorkflowDSL.g:6365:4: (lv_options_3_0= ruleJoinOptions )
                    {
                    // InternalWorkflowDSL.g:6365:4: (lv_options_3_0= ruleJoinOptions )
                    // InternalWorkflowDSL.g:6366:5: lv_options_3_0= ruleJoinOptions
                    {

                    					newCompositeNode(grammarAccess.getJoinSpecAccess().getOptionsJoinOptionsParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_options_3_0=ruleJoinOptions();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJoinSpecRule());
                    					}
                    					set(
                    						current,
                    						"options",
                    						lv_options_3_0,
                    						"xtext.json.WorkflowDSL.JoinOptions");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleJoinSpec"


    // $ANTLR start "entryRuleJoinType"
    // InternalWorkflowDSL.g:6387:1: entryRuleJoinType returns [String current=null] : iv_ruleJoinType= ruleJoinType EOF ;
    public final String entryRuleJoinType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJoinType = null;


        try {
            // InternalWorkflowDSL.g:6387:48: (iv_ruleJoinType= ruleJoinType EOF )
            // InternalWorkflowDSL.g:6388:2: iv_ruleJoinType= ruleJoinType EOF
            {
             newCompositeNode(grammarAccess.getJoinTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoinType=ruleJoinType();

            state._fsp--;

             current =iv_ruleJoinType.getText(); 
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
    // $ANTLR end "entryRuleJoinType"


    // $ANTLR start "ruleJoinType"
    // InternalWorkflowDSL.g:6394:1: ruleJoinType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'inner' | kw= 'left' | kw= 'right' | kw= 'full' | kw= 'cross' ) ;
    public final AntlrDatatypeRuleToken ruleJoinType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:6400:2: ( (kw= 'inner' | kw= 'left' | kw= 'right' | kw= 'full' | kw= 'cross' ) )
            // InternalWorkflowDSL.g:6401:2: (kw= 'inner' | kw= 'left' | kw= 'right' | kw= 'full' | kw= 'cross' )
            {
            // InternalWorkflowDSL.g:6401:2: (kw= 'inner' | kw= 'left' | kw= 'right' | kw= 'full' | kw= 'cross' )
            int alt69=5;
            switch ( input.LA(1) ) {
            case 144:
                {
                alt69=1;
                }
                break;
            case 145:
                {
                alt69=2;
                }
                break;
            case 146:
                {
                alt69=3;
                }
                break;
            case 147:
                {
                alt69=4;
                }
                break;
            case 148:
                {
                alt69=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalWorkflowDSL.g:6402:3: kw= 'inner'
                    {
                    kw=(Token)match(input,144,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJoinTypeAccess().getInnerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:6408:3: kw= 'left'
                    {
                    kw=(Token)match(input,145,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJoinTypeAccess().getLeftKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:6414:3: kw= 'right'
                    {
                    kw=(Token)match(input,146,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJoinTypeAccess().getRightKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:6420:3: kw= 'full'
                    {
                    kw=(Token)match(input,147,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJoinTypeAccess().getFullKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:6426:3: kw= 'cross'
                    {
                    kw=(Token)match(input,148,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJoinTypeAccess().getCrossKeyword_4());
                    		

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
    // $ANTLR end "ruleJoinType"


    // $ANTLR start "entryRuleJoinConditions"
    // InternalWorkflowDSL.g:6435:1: entryRuleJoinConditions returns [EObject current=null] : iv_ruleJoinConditions= ruleJoinConditions EOF ;
    public final EObject entryRuleJoinConditions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinConditions = null;


        try {
            // InternalWorkflowDSL.g:6435:55: (iv_ruleJoinConditions= ruleJoinConditions EOF )
            // InternalWorkflowDSL.g:6436:2: iv_ruleJoinConditions= ruleJoinConditions EOF
            {
             newCompositeNode(grammarAccess.getJoinConditionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoinConditions=ruleJoinConditions();

            state._fsp--;

             current =iv_ruleJoinConditions; 
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
    // $ANTLR end "entryRuleJoinConditions"


    // $ANTLR start "ruleJoinConditions"
    // InternalWorkflowDSL.g:6442:1: ruleJoinConditions returns [EObject current=null] : ( ( (lv_conditions_0_0= ruleJoinCondition ) ) (otherlv_1= 'and' ( (lv_conditions_2_0= ruleJoinCondition ) ) )* ) ;
    public final EObject ruleJoinConditions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_conditions_0_0 = null;

        EObject lv_conditions_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6448:2: ( ( ( (lv_conditions_0_0= ruleJoinCondition ) ) (otherlv_1= 'and' ( (lv_conditions_2_0= ruleJoinCondition ) ) )* ) )
            // InternalWorkflowDSL.g:6449:2: ( ( (lv_conditions_0_0= ruleJoinCondition ) ) (otherlv_1= 'and' ( (lv_conditions_2_0= ruleJoinCondition ) ) )* )
            {
            // InternalWorkflowDSL.g:6449:2: ( ( (lv_conditions_0_0= ruleJoinCondition ) ) (otherlv_1= 'and' ( (lv_conditions_2_0= ruleJoinCondition ) ) )* )
            // InternalWorkflowDSL.g:6450:3: ( (lv_conditions_0_0= ruleJoinCondition ) ) (otherlv_1= 'and' ( (lv_conditions_2_0= ruleJoinCondition ) ) )*
            {
            // InternalWorkflowDSL.g:6450:3: ( (lv_conditions_0_0= ruleJoinCondition ) )
            // InternalWorkflowDSL.g:6451:4: (lv_conditions_0_0= ruleJoinCondition )
            {
            // InternalWorkflowDSL.g:6451:4: (lv_conditions_0_0= ruleJoinCondition )
            // InternalWorkflowDSL.g:6452:5: lv_conditions_0_0= ruleJoinCondition
            {

            					newCompositeNode(grammarAccess.getJoinConditionsAccess().getConditionsJoinConditionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_75);
            lv_conditions_0_0=ruleJoinCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinConditionsRule());
            					}
            					add(
            						current,
            						"conditions",
            						lv_conditions_0_0,
            						"xtext.json.WorkflowDSL.JoinCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflowDSL.g:6469:3: (otherlv_1= 'and' ( (lv_conditions_2_0= ruleJoinCondition ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==149) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalWorkflowDSL.g:6470:4: otherlv_1= 'and' ( (lv_conditions_2_0= ruleJoinCondition ) )
            	    {
            	    otherlv_1=(Token)match(input,149,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getJoinConditionsAccess().getAndKeyword_1_0());
            	    			
            	    // InternalWorkflowDSL.g:6474:4: ( (lv_conditions_2_0= ruleJoinCondition ) )
            	    // InternalWorkflowDSL.g:6475:5: (lv_conditions_2_0= ruleJoinCondition )
            	    {
            	    // InternalWorkflowDSL.g:6475:5: (lv_conditions_2_0= ruleJoinCondition )
            	    // InternalWorkflowDSL.g:6476:6: lv_conditions_2_0= ruleJoinCondition
            	    {

            	    						newCompositeNode(grammarAccess.getJoinConditionsAccess().getConditionsJoinConditionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_75);
            	    lv_conditions_2_0=ruleJoinCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJoinConditionsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conditions",
            	    							lv_conditions_2_0,
            	    							"xtext.json.WorkflowDSL.JoinCondition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


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
    // $ANTLR end "ruleJoinConditions"


    // $ANTLR start "entryRuleJoinCondition"
    // InternalWorkflowDSL.g:6498:1: entryRuleJoinCondition returns [EObject current=null] : iv_ruleJoinCondition= ruleJoinCondition EOF ;
    public final EObject entryRuleJoinCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinCondition = null;


        try {
            // InternalWorkflowDSL.g:6498:54: (iv_ruleJoinCondition= ruleJoinCondition EOF )
            // InternalWorkflowDSL.g:6499:2: iv_ruleJoinCondition= ruleJoinCondition EOF
            {
             newCompositeNode(grammarAccess.getJoinConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoinCondition=ruleJoinCondition();

            state._fsp--;

             current =iv_ruleJoinCondition; 
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
    // $ANTLR end "entryRuleJoinCondition"


    // $ANTLR start "ruleJoinCondition"
    // InternalWorkflowDSL.g:6505:1: ruleJoinCondition returns [EObject current=null] : ( ( ( (lv_left_0_0= ruleColumn ) ) otherlv_1= '=' ( (lv_right_2_0= ruleColumn ) ) ) | ( ( (lv_left_3_0= ruleColumn ) ) ( (lv_comparator_4_0= ruleComparator ) ) ( (lv_right_5_0= ruleColumn ) ) ) ) ;
    public final EObject ruleJoinCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;

        EObject lv_left_3_0 = null;

        AntlrDatatypeRuleToken lv_comparator_4_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6511:2: ( ( ( ( (lv_left_0_0= ruleColumn ) ) otherlv_1= '=' ( (lv_right_2_0= ruleColumn ) ) ) | ( ( (lv_left_3_0= ruleColumn ) ) ( (lv_comparator_4_0= ruleComparator ) ) ( (lv_right_5_0= ruleColumn ) ) ) ) )
            // InternalWorkflowDSL.g:6512:2: ( ( ( (lv_left_0_0= ruleColumn ) ) otherlv_1= '=' ( (lv_right_2_0= ruleColumn ) ) ) | ( ( (lv_left_3_0= ruleColumn ) ) ( (lv_comparator_4_0= ruleComparator ) ) ( (lv_right_5_0= ruleColumn ) ) ) )
            {
            // InternalWorkflowDSL.g:6512:2: ( ( ( (lv_left_0_0= ruleColumn ) ) otherlv_1= '=' ( (lv_right_2_0= ruleColumn ) ) ) | ( ( (lv_left_3_0= ruleColumn ) ) ( (lv_comparator_4_0= ruleComparator ) ) ( (lv_right_5_0= ruleColumn ) ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 16:
                    {
                    int LA71_2 = input.LA(3);

                    if ( (LA71_2==RULE_ID) ) {
                        alt71=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA71_3 = input.LA(3);

                    if ( (LA71_3==RULE_ID) ) {
                        int LA71_6 = input.LA(4);

                        if ( (LA71_6==16) ) {
                            int LA71_2 = input.LA(5);

                            if ( (LA71_2==RULE_ID) ) {
                                alt71=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 71, 2, input);

                                throw nvae;
                            }
                        }
                        else if ( ((LA71_6>=150 && LA71_6<=155)) ) {
                            alt71=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 71, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 155:
                    {
                    alt71=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalWorkflowDSL.g:6513:3: ( ( (lv_left_0_0= ruleColumn ) ) otherlv_1= '=' ( (lv_right_2_0= ruleColumn ) ) )
                    {
                    // InternalWorkflowDSL.g:6513:3: ( ( (lv_left_0_0= ruleColumn ) ) otherlv_1= '=' ( (lv_right_2_0= ruleColumn ) ) )
                    // InternalWorkflowDSL.g:6514:4: ( (lv_left_0_0= ruleColumn ) ) otherlv_1= '=' ( (lv_right_2_0= ruleColumn ) )
                    {
                    // InternalWorkflowDSL.g:6514:4: ( (lv_left_0_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:6515:5: (lv_left_0_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:6515:5: (lv_left_0_0= ruleColumn )
                    // InternalWorkflowDSL.g:6516:6: lv_left_0_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getJoinConditionAccess().getLeftColumnParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_left_0_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinConditionRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_0_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getJoinConditionAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalWorkflowDSL.g:6537:4: ( (lv_right_2_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:6538:5: (lv_right_2_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:6538:5: (lv_right_2_0= ruleColumn )
                    // InternalWorkflowDSL.g:6539:6: lv_right_2_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getJoinConditionAccess().getRightColumnParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_2_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinConditionRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_2_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:6558:3: ( ( (lv_left_3_0= ruleColumn ) ) ( (lv_comparator_4_0= ruleComparator ) ) ( (lv_right_5_0= ruleColumn ) ) )
                    {
                    // InternalWorkflowDSL.g:6558:3: ( ( (lv_left_3_0= ruleColumn ) ) ( (lv_comparator_4_0= ruleComparator ) ) ( (lv_right_5_0= ruleColumn ) ) )
                    // InternalWorkflowDSL.g:6559:4: ( (lv_left_3_0= ruleColumn ) ) ( (lv_comparator_4_0= ruleComparator ) ) ( (lv_right_5_0= ruleColumn ) )
                    {
                    // InternalWorkflowDSL.g:6559:4: ( (lv_left_3_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:6560:5: (lv_left_3_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:6560:5: (lv_left_3_0= ruleColumn )
                    // InternalWorkflowDSL.g:6561:6: lv_left_3_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getJoinConditionAccess().getLeftColumnParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_76);
                    lv_left_3_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinConditionRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_3_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflowDSL.g:6578:4: ( (lv_comparator_4_0= ruleComparator ) )
                    // InternalWorkflowDSL.g:6579:5: (lv_comparator_4_0= ruleComparator )
                    {
                    // InternalWorkflowDSL.g:6579:5: (lv_comparator_4_0= ruleComparator )
                    // InternalWorkflowDSL.g:6580:6: lv_comparator_4_0= ruleComparator
                    {

                    						newCompositeNode(grammarAccess.getJoinConditionAccess().getComparatorComparatorParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_comparator_4_0=ruleComparator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinConditionRule());
                    						}
                    						set(
                    							current,
                    							"comparator",
                    							lv_comparator_4_0,
                    							"xtext.json.WorkflowDSL.Comparator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflowDSL.g:6597:4: ( (lv_right_5_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:6598:5: (lv_right_5_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:6598:5: (lv_right_5_0= ruleColumn )
                    // InternalWorkflowDSL.g:6599:6: lv_right_5_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getJoinConditionAccess().getRightColumnParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_5_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinConditionRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_5_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleJoinCondition"


    // $ANTLR start "entryRuleComparator"
    // InternalWorkflowDSL.g:6621:1: entryRuleComparator returns [String current=null] : iv_ruleComparator= ruleComparator EOF ;
    public final String entryRuleComparator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComparator = null;


        try {
            // InternalWorkflowDSL.g:6621:50: (iv_ruleComparator= ruleComparator EOF )
            // InternalWorkflowDSL.g:6622:2: iv_ruleComparator= ruleComparator EOF
            {
             newCompositeNode(grammarAccess.getComparatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparator=ruleComparator();

            state._fsp--;

             current =iv_ruleComparator.getText(); 
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
    // $ANTLR end "entryRuleComparator"


    // $ANTLR start "ruleComparator"
    // InternalWorkflowDSL.g:6628:1: ruleComparator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '==' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' ) ;
    public final AntlrDatatypeRuleToken ruleComparator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:6634:2: ( (kw= '=' | kw= '==' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' ) )
            // InternalWorkflowDSL.g:6635:2: (kw= '=' | kw= '==' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' )
            {
            // InternalWorkflowDSL.g:6635:2: (kw= '=' | kw= '==' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' )
            int alt72=7;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt72=1;
                }
                break;
            case 150:
                {
                alt72=2;
                }
                break;
            case 151:
                {
                alt72=3;
                }
                break;
            case 152:
                {
                alt72=4;
                }
                break;
            case 153:
                {
                alt72=5;
                }
                break;
            case 154:
                {
                alt72=6;
                }
                break;
            case 155:
                {
                alt72=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalWorkflowDSL.g:6636:3: kw= '='
                    {
                    kw=(Token)match(input,16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparatorAccess().getEqualsSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:6642:3: kw= '=='
                    {
                    kw=(Token)match(input,150,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparatorAccess().getEqualsSignEqualsSignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflowDSL.g:6648:3: kw= '!='
                    {
                    kw=(Token)match(input,151,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparatorAccess().getExclamationMarkEqualsSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflowDSL.g:6654:3: kw= '<'
                    {
                    kw=(Token)match(input,152,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparatorAccess().getLessThanSignKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflowDSL.g:6660:3: kw= '>'
                    {
                    kw=(Token)match(input,153,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparatorAccess().getGreaterThanSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflowDSL.g:6666:3: kw= '<='
                    {
                    kw=(Token)match(input,154,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparatorAccess().getLessThanSignEqualsSignKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalWorkflowDSL.g:6672:3: kw= '>='
                    {
                    kw=(Token)match(input,155,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparatorAccess().getGreaterThanSignEqualsSignKeyword_6());
                    		

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
    // $ANTLR end "ruleComparator"


    // $ANTLR start "entryRuleJoinOptions"
    // InternalWorkflowDSL.g:6681:1: entryRuleJoinOptions returns [EObject current=null] : iv_ruleJoinOptions= ruleJoinOptions EOF ;
    public final EObject entryRuleJoinOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinOptions = null;


        try {
            // InternalWorkflowDSL.g:6681:52: (iv_ruleJoinOptions= ruleJoinOptions EOF )
            // InternalWorkflowDSL.g:6682:2: iv_ruleJoinOptions= ruleJoinOptions EOF
            {
             newCompositeNode(grammarAccess.getJoinOptionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoinOptions=ruleJoinOptions();

            state._fsp--;

             current =iv_ruleJoinOptions; 
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
    // $ANTLR end "entryRuleJoinOptions"


    // $ANTLR start "ruleJoinOptions"
    // InternalWorkflowDSL.g:6688:1: ruleJoinOptions returns [EObject current=null] : (otherlv_0= 'suffix' otherlv_1= '=' otherlv_2= '(' ( (lv_leftSuffix_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_rightSuffix_5_0= RULE_STRING ) ) otherlv_6= ')' ) ;
    public final EObject ruleJoinOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_leftSuffix_3_0=null;
        Token otherlv_4=null;
        Token lv_rightSuffix_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:6694:2: ( (otherlv_0= 'suffix' otherlv_1= '=' otherlv_2= '(' ( (lv_leftSuffix_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_rightSuffix_5_0= RULE_STRING ) ) otherlv_6= ')' ) )
            // InternalWorkflowDSL.g:6695:2: (otherlv_0= 'suffix' otherlv_1= '=' otherlv_2= '(' ( (lv_leftSuffix_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_rightSuffix_5_0= RULE_STRING ) ) otherlv_6= ')' )
            {
            // InternalWorkflowDSL.g:6695:2: (otherlv_0= 'suffix' otherlv_1= '=' otherlv_2= '(' ( (lv_leftSuffix_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_rightSuffix_5_0= RULE_STRING ) ) otherlv_6= ')' )
            // InternalWorkflowDSL.g:6696:3: otherlv_0= 'suffix' otherlv_1= '=' otherlv_2= '(' ( (lv_leftSuffix_3_0= RULE_STRING ) ) otherlv_4= ',' ( (lv_rightSuffix_5_0= RULE_STRING ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,156,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinOptionsAccess().getSuffixKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getJoinOptionsAccess().getEqualsSignKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getJoinOptionsAccess().getLeftParenthesisKeyword_2());
            		
            // InternalWorkflowDSL.g:6708:3: ( (lv_leftSuffix_3_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:6709:4: (lv_leftSuffix_3_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:6709:4: (lv_leftSuffix_3_0= RULE_STRING )
            // InternalWorkflowDSL.g:6710:5: lv_leftSuffix_3_0= RULE_STRING
            {
            lv_leftSuffix_3_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

            					newLeafNode(lv_leftSuffix_3_0, grammarAccess.getJoinOptionsAccess().getLeftSuffixSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinOptionsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"leftSuffix",
            						lv_leftSuffix_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getJoinOptionsAccess().getCommaKeyword_4());
            		
            // InternalWorkflowDSL.g:6730:3: ( (lv_rightSuffix_5_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:6731:4: (lv_rightSuffix_5_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:6731:4: (lv_rightSuffix_5_0= RULE_STRING )
            // InternalWorkflowDSL.g:6732:5: lv_rightSuffix_5_0= RULE_STRING
            {
            lv_rightSuffix_5_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_rightSuffix_5_0, grammarAccess.getJoinOptionsAccess().getRightSuffixSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinOptionsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rightSuffix",
            						lv_rightSuffix_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getJoinOptionsAccess().getRightParenthesisKeyword_6());
            		

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
    // $ANTLR end "ruleJoinOptions"


    // $ANTLR start "entryRuleColumn"
    // InternalWorkflowDSL.g:6756:1: entryRuleColumn returns [EObject current=null] : iv_ruleColumn= ruleColumn EOF ;
    public final EObject entryRuleColumn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumn = null;


        try {
            // InternalWorkflowDSL.g:6756:47: (iv_ruleColumn= ruleColumn EOF )
            // InternalWorkflowDSL.g:6757:2: iv_ruleColumn= ruleColumn EOF
            {
             newCompositeNode(grammarAccess.getColumnRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumn=ruleColumn();

            state._fsp--;

             current =iv_ruleColumn; 
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
    // $ANTLR end "entryRuleColumn"


    // $ANTLR start "ruleColumn"
    // InternalWorkflowDSL.g:6763:1: ruleColumn returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_table_1_0= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) ) ) ;
    public final EObject ruleColumn() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_table_1_0=null;
        Token otherlv_2=null;
        Token lv_column_3_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:6769:2: ( ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_table_1_0= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) ) ) )
            // InternalWorkflowDSL.g:6770:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_table_1_0= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) ) )
            {
            // InternalWorkflowDSL.g:6770:2: ( ( (lv_name_0_0= RULE_ID ) ) | ( ( (lv_table_1_0= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                int LA73_1 = input.LA(2);

                if ( (LA73_1==32) ) {
                    alt73=2;
                }
                else if ( (LA73_1==EOF||LA73_1==14||LA73_1==16||(LA73_1>=19 && LA73_1<=20)||(LA73_1>=44 && LA73_1<=45)||LA73_1==57||(LA73_1>=84 && LA73_1<=88)||(LA73_1>=149 && LA73_1<=156)) ) {
                    alt73=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalWorkflowDSL.g:6771:3: ( (lv_name_0_0= RULE_ID ) )
                    {
                    // InternalWorkflowDSL.g:6771:3: ( (lv_name_0_0= RULE_ID ) )
                    // InternalWorkflowDSL.g:6772:4: (lv_name_0_0= RULE_ID )
                    {
                    // InternalWorkflowDSL.g:6772:4: (lv_name_0_0= RULE_ID )
                    // InternalWorkflowDSL.g:6773:5: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_name_0_0, grammarAccess.getColumnAccess().getNameIDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getColumnRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_0_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:6790:3: ( ( (lv_table_1_0= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) )
                    {
                    // InternalWorkflowDSL.g:6790:3: ( ( (lv_table_1_0= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) )
                    // InternalWorkflowDSL.g:6791:4: ( (lv_table_1_0= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) )
                    {
                    // InternalWorkflowDSL.g:6791:4: ( (lv_table_1_0= RULE_ID ) )
                    // InternalWorkflowDSL.g:6792:5: (lv_table_1_0= RULE_ID )
                    {
                    // InternalWorkflowDSL.g:6792:5: (lv_table_1_0= RULE_ID )
                    // InternalWorkflowDSL.g:6793:6: lv_table_1_0= RULE_ID
                    {
                    lv_table_1_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(lv_table_1_0, grammarAccess.getColumnAccess().getTableIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColumnRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"table",
                    							lv_table_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,32,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getColumnAccess().getFullStopKeyword_1_1());
                    			
                    // InternalWorkflowDSL.g:6813:4: ( (lv_column_3_0= RULE_ID ) )
                    // InternalWorkflowDSL.g:6814:5: (lv_column_3_0= RULE_ID )
                    {
                    // InternalWorkflowDSL.g:6814:5: (lv_column_3_0= RULE_ID )
                    // InternalWorkflowDSL.g:6815:6: lv_column_3_0= RULE_ID
                    {
                    lv_column_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(lv_column_3_0, grammarAccess.getColumnAccess().getColumnIDTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColumnRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"column",
                    							lv_column_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


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
    // $ANTLR end "ruleColumn"


    // $ANTLR start "entryRuleColumnList"
    // InternalWorkflowDSL.g:6836:1: entryRuleColumnList returns [EObject current=null] : iv_ruleColumnList= ruleColumnList EOF ;
    public final EObject entryRuleColumnList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumnList = null;


        try {
            // InternalWorkflowDSL.g:6836:51: (iv_ruleColumnList= ruleColumnList EOF )
            // InternalWorkflowDSL.g:6837:2: iv_ruleColumnList= ruleColumnList EOF
            {
             newCompositeNode(grammarAccess.getColumnListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumnList=ruleColumnList();

            state._fsp--;

             current =iv_ruleColumnList; 
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
    // $ANTLR end "entryRuleColumnList"


    // $ANTLR start "ruleColumnList"
    // InternalWorkflowDSL.g:6843:1: ruleColumnList returns [EObject current=null] : ( ( ( (lv_columns_0_0= ruleColumn ) ) (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )* ) | otherlv_3= '*' ) ;
    public final EObject ruleColumnList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_columns_0_0 = null;

        EObject lv_columns_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflowDSL.g:6849:2: ( ( ( ( (lv_columns_0_0= ruleColumn ) ) (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )* ) | otherlv_3= '*' ) )
            // InternalWorkflowDSL.g:6850:2: ( ( ( (lv_columns_0_0= ruleColumn ) ) (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )* ) | otherlv_3= '*' )
            {
            // InternalWorkflowDSL.g:6850:2: ( ( ( (lv_columns_0_0= ruleColumn ) ) (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )* ) | otherlv_3= '*' )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            else if ( (LA75_0==57) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalWorkflowDSL.g:6851:3: ( ( (lv_columns_0_0= ruleColumn ) ) (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )* )
                    {
                    // InternalWorkflowDSL.g:6851:3: ( ( (lv_columns_0_0= ruleColumn ) ) (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )* )
                    // InternalWorkflowDSL.g:6852:4: ( (lv_columns_0_0= ruleColumn ) ) (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )*
                    {
                    // InternalWorkflowDSL.g:6852:4: ( (lv_columns_0_0= ruleColumn ) )
                    // InternalWorkflowDSL.g:6853:5: (lv_columns_0_0= ruleColumn )
                    {
                    // InternalWorkflowDSL.g:6853:5: (lv_columns_0_0= ruleColumn )
                    // InternalWorkflowDSL.g:6854:6: lv_columns_0_0= ruleColumn
                    {

                    						newCompositeNode(grammarAccess.getColumnListAccess().getColumnsColumnParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_columns_0_0=ruleColumn();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColumnListRule());
                    						}
                    						add(
                    							current,
                    							"columns",
                    							lv_columns_0_0,
                    							"xtext.json.WorkflowDSL.Column");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalWorkflowDSL.g:6871:4: (otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==19) ) {
                            int LA74_1 = input.LA(2);

                            if ( (LA74_1==RULE_ID) ) {
                                alt74=1;
                            }


                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalWorkflowDSL.g:6872:5: otherlv_1= ',' ( (lv_columns_2_0= ruleColumn ) )
                    	    {
                    	    otherlv_1=(Token)match(input,19,FOLLOW_8); 

                    	    					newLeafNode(otherlv_1, grammarAccess.getColumnListAccess().getCommaKeyword_0_1_0());
                    	    				
                    	    // InternalWorkflowDSL.g:6876:5: ( (lv_columns_2_0= ruleColumn ) )
                    	    // InternalWorkflowDSL.g:6877:6: (lv_columns_2_0= ruleColumn )
                    	    {
                    	    // InternalWorkflowDSL.g:6877:6: (lv_columns_2_0= ruleColumn )
                    	    // InternalWorkflowDSL.g:6878:7: lv_columns_2_0= ruleColumn
                    	    {

                    	    							newCompositeNode(grammarAccess.getColumnListAccess().getColumnsColumnParserRuleCall_0_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_41);
                    	    lv_columns_2_0=ruleColumn();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getColumnListRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"columns",
                    	    								lv_columns_2_0,
                    	    								"xtext.json.WorkflowDSL.Column");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:6898:3: otherlv_3= '*'
                    {
                    otherlv_3=(Token)match(input,57,FOLLOW_2); 

                    			newLeafNode(otherlv_3, grammarAccess.getColumnListAccess().getAsteriskKeyword_1());
                    		

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
    // $ANTLR end "ruleColumnList"


    // $ANTLR start "entryRuleNumber"
    // InternalWorkflowDSL.g:6906:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


        try {
            // InternalWorkflowDSL.g:6906:46: (iv_ruleNumber= ruleNumber EOF )
            // InternalWorkflowDSL.g:6907:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber.getText(); 
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
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalWorkflowDSL.g:6913:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) | (kw= '.' this_INT_4= RULE_INT ) ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:6919:2: ( ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) | (kw= '.' this_INT_4= RULE_INT ) ) )
            // InternalWorkflowDSL.g:6920:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) | (kw= '.' this_INT_4= RULE_INT ) )
            {
            // InternalWorkflowDSL.g:6920:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) | (kw= '.' this_INT_4= RULE_INT ) )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_INT) ) {
                alt77=1;
            }
            else if ( (LA77_0==32) ) {
                alt77=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalWorkflowDSL.g:6921:3: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
                    {
                    // InternalWorkflowDSL.g:6921:3: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
                    // InternalWorkflowDSL.g:6922:4: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_77); 

                    				current.merge(this_INT_0);
                    			

                    				newLeafNode(this_INT_0, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_0());
                    			
                    // InternalWorkflowDSL.g:6929:4: (kw= '.' this_INT_2= RULE_INT )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==32) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalWorkflowDSL.g:6930:5: kw= '.' this_INT_2= RULE_INT
                            {
                            kw=(Token)match(input,32,FOLLOW_78); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_0_1_0());
                            				
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

                            					current.merge(this_INT_2);
                            				

                            					newLeafNode(this_INT_2, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_1_1());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflowDSL.g:6945:3: (kw= '.' this_INT_4= RULE_INT )
                    {
                    // InternalWorkflowDSL.g:6945:3: (kw= '.' this_INT_4= RULE_INT )
                    // InternalWorkflowDSL.g:6946:4: kw= '.' this_INT_4= RULE_INT
                    {
                    kw=(Token)match(input,32,FOLLOW_78); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
                    			
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_4);
                    			

                    				newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1());
                    			

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
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleRegex"
    // InternalWorkflowDSL.g:6963:1: entryRuleRegex returns [EObject current=null] : iv_ruleRegex= ruleRegex EOF ;
    public final EObject entryRuleRegex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegex = null;


        try {
            // InternalWorkflowDSL.g:6963:46: (iv_ruleRegex= ruleRegex EOF )
            // InternalWorkflowDSL.g:6964:2: iv_ruleRegex= ruleRegex EOF
            {
             newCompositeNode(grammarAccess.getRegexRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegex=ruleRegex();

            state._fsp--;

             current =iv_ruleRegex; 
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
    // $ANTLR end "entryRuleRegex"


    // $ANTLR start "ruleRegex"
    // InternalWorkflowDSL.g:6970:1: ruleRegex returns [EObject current=null] : (otherlv_0= '/' ( (lv_pattern_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_flags_3_0= RULE_STRING ) )? ) ;
    public final EObject ruleRegex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_pattern_1_0=null;
        Token otherlv_2=null;
        Token lv_flags_3_0=null;


        	enterRule();

        try {
            // InternalWorkflowDSL.g:6976:2: ( (otherlv_0= '/' ( (lv_pattern_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_flags_3_0= RULE_STRING ) )? ) )
            // InternalWorkflowDSL.g:6977:2: (otherlv_0= '/' ( (lv_pattern_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_flags_3_0= RULE_STRING ) )? )
            {
            // InternalWorkflowDSL.g:6977:2: (otherlv_0= '/' ( (lv_pattern_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_flags_3_0= RULE_STRING ) )? )
            // InternalWorkflowDSL.g:6978:3: otherlv_0= '/' ( (lv_pattern_1_0= RULE_STRING ) ) otherlv_2= '/' ( (lv_flags_3_0= RULE_STRING ) )?
            {
            otherlv_0=(Token)match(input,86,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRegexAccess().getSolidusKeyword_0());
            		
            // InternalWorkflowDSL.g:6982:3: ( (lv_pattern_1_0= RULE_STRING ) )
            // InternalWorkflowDSL.g:6983:4: (lv_pattern_1_0= RULE_STRING )
            {
            // InternalWorkflowDSL.g:6983:4: (lv_pattern_1_0= RULE_STRING )
            // InternalWorkflowDSL.g:6984:5: lv_pattern_1_0= RULE_STRING
            {
            lv_pattern_1_0=(Token)match(input,RULE_STRING,FOLLOW_79); 

            					newLeafNode(lv_pattern_1_0, grammarAccess.getRegexAccess().getPatternSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRegexRule());
            					}
            					setWithLastConsumed(
            						current,
            						"pattern",
            						lv_pattern_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,86,FOLLOW_80); 

            			newLeafNode(otherlv_2, grammarAccess.getRegexAccess().getSolidusKeyword_2());
            		
            // InternalWorkflowDSL.g:7004:3: ( (lv_flags_3_0= RULE_STRING ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_STRING) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalWorkflowDSL.g:7005:4: (lv_flags_3_0= RULE_STRING )
                    {
                    // InternalWorkflowDSL.g:7005:4: (lv_flags_3_0= RULE_STRING )
                    // InternalWorkflowDSL.g:7006:5: lv_flags_3_0= RULE_STRING
                    {
                    lv_flags_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_flags_3_0, grammarAccess.getRegexAccess().getFlagsSTRINGTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRegexRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"flags",
                    						lv_flags_3_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

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
    // $ANTLR end "ruleRegex"

    // Delegated rules


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA41 dfa41 = new DFA41(this);
    static final String dfa_1s = "\51\uffff";
    static final String dfa_2s = "\1\22\2\6\1\23\1\6\4\23\1\6\3\23\2\6\1\23\2\6\2\23\1\24\1\6\3\24\1\23\1\24\1\6\3\24\1\6\2\uffff\1\24\1\6\2\uffff\3\24";
    static final String dfa_3s = "\1\67\2\73\1\40\1\6\3\23\1\40\1\6\3\23\1\6\1\73\1\23\1\6\1\73\2\23\1\70\1\6\3\70\1\23\1\70\1\6\3\70\1\6\2\uffff\1\70\1\6\2\uffff\3\70";
    static final String dfa_4s = "\40\uffff\1\2\1\1\2\uffff\1\3\1\4\3\uffff";
    static final String dfa_5s = "\51\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\44\uffff\1\1",
            "\1\3\31\uffff\1\4\30\uffff\1\5\1\6\1\7",
            "\1\10\31\uffff\1\11\30\uffff\1\12\1\13\1\14",
            "\1\16\14\uffff\1\15",
            "\1\17",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\21\14\uffff\1\20",
            "\1\22",
            "\1\21",
            "\1\21",
            "\1\21",
            "\1\23",
            "\1\24\31\uffff\1\25\30\uffff\1\26\1\27\1\30",
            "\1\16",
            "\1\31",
            "\1\32\31\uffff\1\33\30\uffff\1\34\1\35\1\36",
            "\1\21",
            "\1\16",
            "\1\40\13\uffff\1\37\27\uffff\1\41",
            "\1\42",
            "\1\40\43\uffff\1\41",
            "\1\40\43\uffff\1\41",
            "\1\40\43\uffff\1\41",
            "\1\21",
            "\1\45\13\uffff\1\43\27\uffff\1\44",
            "\1\46",
            "\1\45\43\uffff\1\44",
            "\1\45\43\uffff\1\44",
            "\1\45\43\uffff\1\44",
            "\1\47",
            "",
            "",
            "\1\40\43\uffff\1\41",
            "\1\50",
            "",
            "",
            "\1\45\43\uffff\1\44",
            "\1\40\43\uffff\1\41",
            "\1\45\43\uffff\1\44"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2384:2: ( (otherlv_0= '[' ( (lv_lower_1_0= ruleBoundValue ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleBoundValue ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleBoundValue ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleBoundValue ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleBoundValue ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleBoundValue ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleBoundValue ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleBoundValue ) ) otherlv_19= ')' ) )";
        }
    }
    static final String dfa_7s = "\55\uffff";
    static final String dfa_8s = "\1\22\2\6\1\23\1\6\5\23\1\6\4\23\2\6\1\23\2\6\2\23\1\24\1\6\4\24\1\23\1\24\1\6\4\24\1\6\2\uffff\1\24\1\6\2\uffff\3\24";
    static final String dfa_9s = "\1\67\2\134\1\40\1\6\4\23\1\40\1\6\4\23\1\6\1\134\1\23\1\6\1\134\2\23\1\70\1\6\4\70\1\23\1\70\1\6\4\70\1\6\2\uffff\1\70\1\6\2\uffff\3\70";
    static final String dfa_10s = "\44\uffff\1\2\1\1\2\uffff\1\3\1\4\3\uffff";
    static final String dfa_11s = "\55\uffff}>";
    static final String[] dfa_12s = {
            "\1\2\44\uffff\1\1",
            "\1\3\31\uffff\1\4\31\uffff\1\6\1\5\37\uffff\1\7\1\10",
            "\1\11\31\uffff\1\12\31\uffff\1\14\1\13\37\uffff\1\15\1\16",
            "\1\20\14\uffff\1\17",
            "\1\21",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\23\14\uffff\1\22",
            "\1\24",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\25",
            "\1\26\31\uffff\1\27\31\uffff\1\31\1\30\37\uffff\1\32\1\33",
            "\1\20",
            "\1\34",
            "\1\35\31\uffff\1\36\31\uffff\1\40\1\37\37\uffff\1\41\1\42",
            "\1\23",
            "\1\20",
            "\1\44\13\uffff\1\43\27\uffff\1\45",
            "\1\46",
            "\1\44\43\uffff\1\45",
            "\1\44\43\uffff\1\45",
            "\1\44\43\uffff\1\45",
            "\1\44\43\uffff\1\45",
            "\1\23",
            "\1\51\13\uffff\1\47\27\uffff\1\50",
            "\1\52",
            "\1\51\43\uffff\1\50",
            "\1\51\43\uffff\1\50",
            "\1\51\43\uffff\1\50",
            "\1\51\43\uffff\1\50",
            "\1\53",
            "",
            "",
            "\1\44\43\uffff\1\45",
            "\1\54",
            "",
            "",
            "\1\51\43\uffff\1\50",
            "\1\44\43\uffff\1\45",
            "\1\51\43\uffff\1\50"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "4336:2: ( (otherlv_0= '[' ( (lv_lower_1_0= ruleIntervalBound ) ) otherlv_2= ',' ( (lv_upper_3_0= ruleIntervalBound ) ) otherlv_4= ']' ) | (otherlv_5= '[' ( (lv_lower_6_0= ruleIntervalBound ) ) otherlv_7= ',' ( (lv_upper_8_0= ruleIntervalBound ) ) otherlv_9= ')' ) | (otherlv_10= '(' ( (lv_lower_11_0= ruleIntervalBound ) ) otherlv_12= ',' ( (lv_upper_13_0= ruleIntervalBound ) ) otherlv_14= ']' ) | (otherlv_15= '(' ( (lv_lower_16_0= ruleIntervalBound ) ) otherlv_17= ',' ( (lv_upper_18_0= ruleIntervalBound ) ) otherlv_19= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001C80010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x8010000000000000L,0x01000013E200014FL,0x0000000000004000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000038004000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000E020440000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000001E000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0080000000040000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000050L,0x0000004000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0001C00000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x1060001000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0200000000000020L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0E00000100000040L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000004010L,0x0000000000400000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000100040070L,0x00000000000FFE00L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0200000000000002L,0x0000000001F00000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000100100070L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000100000070L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0C00000100000040L,0x0000000018000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000100000L,0x0000000800000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x00B7FFA000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0080000100000050L,0x0000004000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0100000100000050L,0x0000004000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0100000000080000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x00B0000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000100000040L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x3E00000000000004L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L,0x0000000000000050L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000003C00L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000001F0000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000000L,0x000000000FC00000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000012L});

}