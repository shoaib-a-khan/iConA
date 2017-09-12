// $ANTLR 3.4 /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g 2012-06-02 09:32:24
 
	package com.icona.antlr.main;  
	import java.util.Iterator;
import com.icona.helper.APIMappingTable;
import com.icona.helper.SymbolTable;
import com.icona.helper.VariableScopeTable;
import com.icona.helper.DAO.ClassDAO;
import com.icona.helper.DAO.FunctionDAO;
import com.icona.tree.nodes.BasicModifier;
import com.icona.tree.nodes.ClassInterface;
import com.icona.tree.nodes.Declaration;
import com.icona.tree.nodes.Declaration.AccessType;
import com.icona.tree.nodes.Expression;
import com.icona.tree.nodes.Expression.AssignmentExpression;
import com.icona.tree.nodes.Expression.BinaryExpression;
import com.icona.tree.nodes.Expression.CastExpression;
import com.icona.tree.nodes.Expression.ListExpression;
import com.icona.tree.nodes.Expression.PostfixExpression;
import com.icona.tree.nodes.Expression.PostfixExpression.PostfixExpressionCollector;
import com.icona.tree.nodes.Expression.PostfixExpression.PostfixExpressionCollector.PostfixExpressionType;
import com.icona.tree.nodes.Expression.PrimaryExpression;
import com.icona.tree.nodes.Expression.TertiaryExpression;
import com.icona.tree.nodes.Expression.UnaryExpression;
import com.icona.tree.nodes.Function;
import com.icona.tree.nodes.Function.FunctionType;
import com.icona.tree.nodes.GenericRef.RefType;
import com.icona.tree.nodes.Identifier;
import com.icona.tree.nodes.IdentifierType;
import com.icona.tree.nodes.Import;
import com.icona.tree.nodes.ListClass;
import com.icona.tree.nodes.ListFunction;
import com.icona.tree.nodes.ListImport;
import com.icona.tree.nodes.ListProtocol;
import com.icona.tree.nodes.MessageExpression;
import com.icona.tree.nodes.MethodType;
import com.icona.tree.nodes.Node;
import com.icona.tree.nodes.Operator.AssignmentOperator;
import com.icona.tree.nodes.Operator.AssignmentOperator.AssignmentSymbol;
import com.icona.tree.nodes.Operator.BinaryOperator;
import com.icona.tree.nodes.Operator.BinaryOperator.BinarySymbol;
import com.icona.tree.nodes.Operator.UnaryOperator;
import com.icona.tree.nodes.Operator.UnaryOperator.UnarySymbol;
import com.icona.tree.nodes.PackageDef;
import com.icona.tree.nodes.Parameter;
import com.icona.tree.nodes.Protocol;
import com.icona.tree.nodes.SourceFile;
import com.icona.tree.nodes.Specifier;
import com.icona.tree.nodes.Statement;
import com.icona.tree.nodes.Statement.JumpStatement;
import com.icona.tree.nodes.Statement.JumpStatement.JumpType;
import com.icona.tree.nodes.Statement.ListDeclaration;
import com.icona.tree.nodes.Type.ArrayType;
import com.icona.tree.nodes.Type.DataType;
import com.icona.tree.nodes.Type.DataType.BasicDataType;
import com.icona.tree.nodes.Type.DataType.ClassType;
import com.icona.tree.nodes.Type.PointerType;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ObjectiveCParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHARACTER_LITERAL", "COMMENT", "DECIMAL_LITERAL", "EscapeSequence", "Exponent", "FLOATING_POINT_LITERAL", "FloatTypeSuffix", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "IntegerTypeSuffix", "LETTER", "LINE_COMMENT", "OCTAL_LITERAL", "OctalEscape", "STRING_LITERAL", "UnicodeEscape", "WS", "'!'", "'!='", "'\"'", "'#define'", "'#endif'", "'#if'", "'#ifdef'", "'#ifndef'", "'#import'", "'#include'", "'#undef'", "'%'", "'%='", "'&&'", "'&'", "'&='", "'('", "')'", "'*'", "'*='", "'+'", "'++'", "'+='", "','", "'-'", "'--'", "'-='", "'->'", "'.'", "'.+'", "'/'", "'/='", "':'", "';'", "'<'", "'<<'", "'<<='", "'<='", "'='", "'=='", "'>'", "'>='", "'>>'", "'>>='", "'?'", "'@'", "'@class'", "'@end'", "'@implementation'", "'@interface'", "'@optional'", "'@package'", "'@private'", "'@property'", "'@protected'", "'@protocol'", "'@public'", "'@required'", "'@synthesize'", "'BOOL'", "'IBOutlet'", "'['", "'\\\\'", "']'", "'^'", "'^='", "'assign'", "'auto'", "'bool'", "'break'", "'case'", "'char'", "'const'", "'continue'", "'copy'", "'default'", "'do'", "'double'", "'else'", "'extern'", "'float'", "'for'", "'goto'", "'id'", "'if'", "'int'", "'long'", "'nonatomic'", "'readonly'", "'readwrite'", "'register'", "'retain'", "'return'", "'self'", "'short'", "'signed'", "'sizeof'", "'static'", "'struct'", "'super'", "'switch'", "'typedef'", "'unichar'", "'union'", "'unsigned'", "'void'", "'volatile'", "'while'", "'{'", "'|'", "'|='", "'||'", "'}'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__110=110;
    public static final int T__111=111;
    public static final int T__112=112;
    public static final int T__113=113;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__120=120;
    public static final int T__121=121;
    public static final int T__122=122;
    public static final int T__123=123;
    public static final int T__124=124;
    public static final int T__125=125;
    public static final int T__126=126;
    public static final int T__127=127;
    public static final int T__128=128;
    public static final int T__129=129;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__134=134;
    public static final int T__135=135;
    public static final int CHARACTER_LITERAL=4;
    public static final int COMMENT=5;
    public static final int DECIMAL_LITERAL=6;
    public static final int EscapeSequence=7;
    public static final int Exponent=8;
    public static final int FLOATING_POINT_LITERAL=9;
    public static final int FloatTypeSuffix=10;
    public static final int HEX_LITERAL=11;
    public static final int HexDigit=12;
    public static final int IDENTIFIER=13;
    public static final int IntegerTypeSuffix=14;
    public static final int LETTER=15;
    public static final int LINE_COMMENT=16;
    public static final int OCTAL_LITERAL=17;
    public static final int OctalEscape=18;
    public static final int STRING_LITERAL=19;
    public static final int UnicodeEscape=20;
    public static final int WS=21;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    protected static class CurrentFunction_scope {
        Identifier functionName;
        Function function;
    }
    protected Stack CurrentFunction_stack = new Stack();


    protected static class VariableScopeTable_scope {
        VariableScopeTable variableScopeTable;
    }
    protected Stack VariableScopeTable_stack = new Stack();



    public ObjectiveCParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ObjectiveCParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ObjectiveCParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g"; }

     
    	SourceFile src=new SourceFile(null,-1);
    	
    	
    	public String getCurrentFileNameWithoutExtension(){
    		String f=symbolTable.getCurrentFile().getName();            	 		
            String fileName=f.substring(0, f.lastIndexOf('.'));
            return fileName;
    	}
    	public SourceFile getSrc(){
    		return src;
    	}
    	public void printRawSymbolTable(){
    	     
    	     symbolTable.printRaw();
    	}
    	
    	public void printFormulatedSymbolTable(){
    	     
    	     symbolTable.printFormulated();
    	}
    	private Declaration mergeAndCreateDeclaration(Declaration declaration,Identifier identifier,ArrayType arrayType, Expression initializations,PointerType pointerType){
    		Declaration decl=(Declaration)declaration.clone();
    		decl.setIdentifier(identifier);
    		decl.setArrayDimensions(arrayType);
    		decl.setListExpression(initializations);
    		decl.setPointerType(pointerType);
    		
    		return decl;
    	}
    	
    	private BinaryExpression createAndMergeBinaryExpression(Expression parent,int line_no,BinarySymbol op,Expression prev,BinaryExpression addTo,Expression newExpression){
    		BinaryExpression temp=new BinaryExpression(parent,line_no,op);
    		
    		temp.setLhs((Expression)prev);
    		temp.setRhs((Expression)newExpression);
    		addTo.setRhs((Expression)temp);
    		
    		return temp;
    	}
    	
    	private AssignmentExpression createAndMergeAssignmentExpression(Expression parent,int line_no,AssignmentSymbol op,Expression prev,AssignmentExpression addTo,Expression newExpression){
    		AssignmentExpression temp=new AssignmentExpression(parent,line_no,op);
    		
    		temp.setTarget((Expression)prev);
    		temp.setValue((Expression)newExpression);
    		addTo.setValue((Expression)temp);
    		
    		return temp;
    	}
    	
    	private Declaration mergeSpecifierDetailsWithDeclaration(Declaration specifierDetails,Declaration declaration){
    		declaration.setModifier(specifierDetails.getModifier());
    		declaration.setSpecifier(specifierDetails.getSpecifier());
    		declaration.setDataType(specifierDetails.getDataType());
    		
    		return declaration;
    		
    	 }
      
      //TODO why use this function when you can directly add function via rule interface_declaration_list
    	private ListFunction mergeProtocolFunctions(ListFunction list1, ListFunction list2){
    	   
    	   	   if(list2 != null){
    			Iterator it = list2.getIterator();
    			while(it.hasNext()){
    			    	list1.addFunction((Function)it.next());
    			    }
    			    return list1;
    			}
    			else
    				return list1;      
    	}
       
    	
    	SymbolTable symbolTable = SymbolTable.getInstance();

    	 	
        
        //TODO have this function replaced by singleton pattern
        /*public void setSymbolTable(SymbolTable symbolTable) {
            this.symbolTable = symbolTable;
        }*/
        
        	PackageDef packageDef = symbolTable.getCurrentPackage();
    	 
    	 /*public void setPackage(PackageDef packageDef){
    	 
    	  this.packageDef = packageDef;//new PackageDef(null, 1, -1);

         }*/

    	
    	/*
    	 * Functions related to scope resolution
    	 *
    	 */
    	 
    	 String getVariableType(String id) {
    	 	for (int s=VariableScopeTable_stack.size()-1; s>=0; s--) {
    	 		if ( ((VariableScopeTable_scope)VariableScopeTable_stack.elementAt(s)).variableScopeTable.containsVariable(id) ) {
    	 			Declaration decl=((VariableScopeTable_scope)VariableScopeTable_stack.elementAt(s)).variableScopeTable.get(id);
    	 			return decl.getDataType().toStringUnformatted();
    	 		}
    	 	}
    	 	System.err.println("SCOPE TABLE:"+id+" not declared");
    	 	return null;
    	 }
    	 
    	 String getVariableType(Identifier id) {
    	 	for (int s=VariableScopeTable_stack.size()-1; s>=0; s--) {
    	 		if ( ((VariableScopeTable_scope)VariableScopeTable_stack.elementAt(s)).variableScopeTable.containsVariable(id) ) {
    	 			Declaration decl=((VariableScopeTable_scope)VariableScopeTable_stack.elementAt(s)).variableScopeTable.get(id);
    	 			return decl.getDataType().toStringUnformatted();
    	 		}
    	 	}
    	 	System.err.println("SCOPE TABLE:"+id+" not declared");
    	 	return null;
    	 }
    	 
    	 
    	 
    	 //list of imports for the current file
         ListImport importsInFile = new ListImport(null, -1); //TODO this object should be someplace else
         
         //list of classes for the current file
         ListClass classesInFile = new ListClass(packageDef, -1);
         
         //List of protocol declaration in current file
         ListProtocol protocolsInFile = new ListProtocol(packageDef, -1);
         
         public static int currentLineNumber=1;
    	 



    // $ANTLR start "translation_unit"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:221:1: translation_unit : (ed= external_declaration )+ EOF ;
    public final void translation_unit() throws RecognitionException {
        ObjectiveCParser.external_declaration_return ed =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:221:17: ( (ed= external_declaration )+ EOF )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:222:3: (ed= external_declaration )+ EOF
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:222:3: (ed= external_declaration )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==COMMENT||LA1_0==IDENTIFIER||LA1_0==LINE_COMMENT||(LA1_0 >= 25 && LA1_0 <= 32)||LA1_0==68||(LA1_0 >= 70 && LA1_0 <= 71)||LA1_0==77||LA1_0==81||LA1_0==89||(LA1_0 >= 93 && LA1_0 <= 94)||LA1_0==99||(LA1_0 >= 101 && LA1_0 <= 102)||LA1_0==105||(LA1_0 >= 107 && LA1_0 <= 108)||LA1_0==112||(LA1_0 >= 116 && LA1_0 <= 117)||(LA1_0 >= 119 && LA1_0 <= 120)||(LA1_0 >= 123 && LA1_0 <= 128)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:223:4: ed= external_declaration
            	    {
            	    pushFollow(FOLLOW_external_declaration_in_translation_unit77);
            	    ed=external_declaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input,EOF,FOLLOW_EOF_in_translation_unit86); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "translation_unit"


    public static class external_declaration_return extends ParserRuleReturnScope {
        public Function func;
        public ListDeclaration decl;
    };


    // $ANTLR start "external_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:226:1: external_declaration returns [ Function func, ListDeclaration decl] : (d= declaration |struct= struct_or_union_definition | class_interface | class_implementation | protocol_declaration | COMMENT | LINE_COMMENT | preprocessor_declaration |fd= function_definition | protocol_declaration_list | class_declaration_list );
    public final ObjectiveCParser.external_declaration_return external_declaration() throws RecognitionException {
        VariableScopeTable_stack.push(new VariableScopeTable_scope());

        ObjectiveCParser.external_declaration_return retval = new ObjectiveCParser.external_declaration_return();
        retval.start = input.LT(1);


        ListDeclaration d =null;

        ClassInterface struct =null;

        Function fd =null;

        ClassInterface class_interface1 =null;

        ClassInterface class_implementation2 =null;

        Protocol protocol_declaration3 =null;



        	((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable =new VariableScopeTable();
        	retval.decl =null;
        	retval.func =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:234:2: (d= declaration |struct= struct_or_union_definition | class_interface | class_implementation | protocol_declaration | COMMENT | LINE_COMMENT | preprocessor_declaration |fd= function_definition | protocol_declaration_list | class_declaration_list )
            int alt2=11;
            switch ( input.LA(1) ) {
            case 89:
                {
                int LA2_1 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
                }
                break;
            case 112:
                {
                int LA2_2 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
                }
                break;
            case 119:
                {
                int LA2_3 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;

                }
                }
                break;
            case 101:
                {
                int LA2_4 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 4, input);

                    throw nvae;

                }
                }
                break;
            case 127:
                {
                int LA2_5 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 5, input);

                    throw nvae;

                }
                }
                break;
            case 93:
                {
                int LA2_6 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 6, input);

                    throw nvae;

                }
                }
                break;
            case 116:
                {
                int LA2_7 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 7, input);

                    throw nvae;

                }
                }
                break;
            case 108:
                {
                int LA2_8 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 8, input);

                    throw nvae;

                }
                }
                break;
            case 107:
                {
                int LA2_9 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 9, input);

                    throw nvae;

                }
                }
                break;
            case 102:
                {
                int LA2_10 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 10, input);

                    throw nvae;

                }
                }
                break;
            case 99:
                {
                int LA2_11 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 11, input);

                    throw nvae;

                }
                }
                break;
            case 81:
                {
                int LA2_12 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 12, input);

                    throw nvae;

                }
                }
                break;
            case 117:
                {
                int LA2_13 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 13, input);

                    throw nvae;

                }
                }
                break;
            case 126:
                {
                int LA2_14 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 14, input);

                    throw nvae;

                }
                }
                break;
            case 124:
                {
                int LA2_15 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 15, input);

                    throw nvae;

                }
                }
                break;
            case 94:
                {
                int LA2_16 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 16, input);

                    throw nvae;

                }
                }
                break;
            case 128:
                {
                int LA2_17 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 17, input);

                    throw nvae;

                }
                }
                break;
            case 105:
                {
                int LA2_18 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 18, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA2_19 = input.LA(2);

                if ( (synpred2_ObjectiveC()) ) {
                    alt2=1;
                }
                else if ( (synpred10_ObjectiveC()) ) {
                    alt2=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 19, input);

                    throw nvae;

                }
                }
                break;
            case 120:
            case 123:
            case 125:
                {
                alt2=2;
                }
                break;
            case 71:
                {
                alt2=3;
                }
                break;
            case 70:
                {
                alt2=4;
                }
                break;
            case 77:
                {
                int LA2_24 = input.LA(2);

                if ( (synpred6_ObjectiveC()) ) {
                    alt2=5;
                }
                else if ( (synpred11_ObjectiveC()) ) {
                    alt2=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 24, input);

                    throw nvae;

                }
                }
                break;
            case COMMENT:
                {
                alt2=6;
                }
                break;
            case LINE_COMMENT:
                {
                alt2=7;
                }
                break;
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                {
                alt2=8;
                }
                break;
            case 68:
                {
                alt2=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:235:5: d= declaration
                    {
                    pushFollow(FOLLOW_declaration_in_external_declaration122);
                    d=declaration();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    		   //src.addChild((Node)d); 
                    		   retval.decl =d;
                    		   
                    		   ((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable.put(d); 
                    		   
                    		   d.setAllDeclarationsAccessType(AccessType.PUBLIC);

                    		  
                    	 		
                    	 		String className="ICONA_GLOBAL_"+getCurrentFileNameWithoutExtension();
                    	 		ClassInterface c=(ClassInterface)symbolTable.getObject(className,IdentifierType.CLASS);
                    	 		if(c==null){
                    	 			c=new ClassInterface(packageDef,IdentifierType.CLASS,-1);
                    	 			c.setClassName(new Identifier(className)); 
                    	 			retval.decl.setAllDeclarationParent(c);
                    	 			c.setInstanceVariables(retval.decl);
                    	 			//packageDef.addClass(c);
                    	 			//System.out.println(c.toString());
                    	 			symbolTable.addObject(className,c);
                    	 			//ClassInterface m=(ClassInterface)symbolTable.getObject(className,IdentifierType.CLASS);
                    	 	
                    	 		}else{
                    	 		
                    	 			retval.decl.setAllDeclarationParent(c);
                    	 			c.addInstanceVariables(retval.decl);
                    	 		}
                    	 		
                    	 		for(int i=0;i<retval.decl.size();i++)
                    				symbolTable.addObject(retval.decl.get(i).getIdentifier().getName(),retval.decl.get(i));
                    	 	
                    				
                    	 		

                    	   }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:270:4: struct= struct_or_union_definition
                    {
                    pushFollow(FOLLOW_struct_or_union_definition_in_external_declaration131);
                    struct=struct_or_union_definition();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    	 	symbolTable.addObject(struct.getClassName().getName(),struct);
                    	 	packageDef.addClass(struct);
                    	 }

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:274:5: class_interface
                    {
                    pushFollow(FOLLOW_class_interface_in_external_declaration139);
                    class_interface1=class_interface();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {src.addChild((Node)class_interface1); class_interface1.setImports(importsInFile); symbolTable.mergeClasses(class_interface1,  importsInFile); }

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:275:5: class_implementation
                    {
                    pushFollow(FOLLOW_class_implementation_in_external_declaration147);
                    class_implementation2=class_implementation();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    	 
                    	 ClassInterface class_ = (ClassInterface) symbolTable.getObject(class_implementation2.getClassName().getName(),IdentifierType.CLASS);
                    	 if(class_!=null)	
                    	 {	 if(class_.getInstanceVariables()!=null){
                    			Iterator<Declaration> decl = class_.getInstanceVariables().getIterator();
                    			while(decl.hasNext())
                    				decl.next();
                    		}
                    	 }
                    	 src.addChild((Node)class_implementation2); class_implementation2.setImports(importsInFile);symbolTable.mergeClasses(class_implementation2, importsInFile); /*classesInFile.addClass(class_implementation2);*/ 
                    	 }

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:288:5: protocol_declaration
                    {
                    pushFollow(FOLLOW_protocol_declaration_in_external_declaration158);
                    protocol_declaration3=protocol_declaration();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {src.addChild((Node)protocol_declaration3); protocol_declaration3.setImports(importsInFile); protocolsInFile.addProtocol(protocol_declaration3); packageDef.addProtocol(protocol_declaration3); }

                    }
                    break;
                case 6 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:289:5: COMMENT
                    {
                    match(input,COMMENT,FOLLOW_COMMENT_in_external_declaration166); if (state.failed) return retval;

                    }
                    break;
                case 7 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:289:15: LINE_COMMENT
                    {
                    match(input,LINE_COMMENT,FOLLOW_LINE_COMMENT_in_external_declaration170); if (state.failed) return retval;

                    }
                    break;
                case 8 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:289:30: preprocessor_declaration
                    {
                    pushFollow(FOLLOW_preprocessor_declaration_in_external_declaration174);
                    preprocessor_declaration();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 9 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:290:5: fd= function_definition
                    {
                    pushFollow(FOLLOW_function_definition_in_external_declaration182);
                    fd=function_definition();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    	 		fd.setFunctionType(FunctionType.GLOBAL_METHOD);
                    	 		
                    	 		//src.addChild((Node)fd); //TODO: Add global functions in a global class
                    	 		
                    	 		
                    	 		retval.func = new Function(null, IdentifierType.FUNCTION,-1);
                    	 		retval.func =fd;
                    	 		
                    	 		String className="ICONA_GLOBAL_"+getCurrentFileNameWithoutExtension();
                    	 		ClassInterface c=(ClassInterface)symbolTable.getObject(className,IdentifierType.CLASS);
                    	 		if(c==null){
                    	 			c=new ClassInterface(packageDef,IdentifierType.CLASS,currentLineNumber);
                    	 			c.setClassName(new Identifier(className));
                    	 			retval.func.setOwner(c);
                    	 			c.addFunction(retval.func);
                    	 			packageDef.addClass(c);
                    	 			//System.out.println(c.toString());
                    	 			symbolTable.addObject(className,c);
                    	 		}else{
                    	 			retval.func.setOwner(c);
                    	 			c.addFunction(retval.func);
                    	 		} 
                    	 		
                    	 		symbolTable.addObject(retval.func.getFunctionName(),retval.func);
                    	 		//symbolTable.getObject("GlobalFunction",IdentifierType.FUNCTION);
                    	 }

                    }
                    break;
                case 10 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:317:4: protocol_declaration_list
                    {
                    pushFollow(FOLLOW_protocol_declaration_list_in_external_declaration189);
                    protocol_declaration_list();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 11 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:318:4: class_declaration_list
                    {
                    pushFollow(FOLLOW_class_declaration_list_in_external_declaration194);
                    class_declaration_list();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            VariableScopeTable_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "external_declaration"



    // $ANTLR start "file_specification"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:323:1: file_specification returns [String importName] : ( '<' | '\"' ) ( IDENTIFIER ( '/' | '\\\\' | '.' )? )+ ( '>' | '\"' ) ;
    public final String file_specification() throws RecognitionException {
        String importName = null;


        Token IDENTIFIER4=null;


        		importName = "";

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:331:2: ( ( '<' | '\"' ) ( IDENTIFIER ( '/' | '\\\\' | '.' )? )+ ( '>' | '\"' ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:332:2: ( '<' | '\"' ) ( IDENTIFIER ( '/' | '\\\\' | '.' )? )+ ( '>' | '\"' )
            {
            if ( input.LA(1)==24||input.LA(1)==56 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return importName;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:332:12: ( IDENTIFIER ( '/' | '\\\\' | '.' )? )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENTIFIER) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:332:13: IDENTIFIER ( '/' | '\\\\' | '.' )?
            	    {
            	    IDENTIFIER4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_file_specification231); if (state.failed) return importName;

            	    if ( state.backtracking==0 ) { importName+=(IDENTIFIER4!=null?IDENTIFIER4.getText():null); }

            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:332:62: ( '/' | '\\\\' | '.' )?
            	    int alt3=4;
            	    switch ( input.LA(1) ) {
            	        case 52:
            	            {
            	            alt3=1;
            	            }
            	            break;
            	        case 84:
            	            {
            	            alt3=2;
            	            }
            	            break;
            	        case 50:
            	            {
            	            alt3=3;
            	            }
            	            break;
            	    }

            	    switch (alt3) {
            	        case 1 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:332:63: '/'
            	            {
            	            match(input,52,FOLLOW_52_in_file_specification239); if (state.failed) return importName;

            	            if ( state.backtracking==0 ) {importName+="/";}

            	            }
            	            break;
            	        case 2 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:332:89: '\\\\'
            	            {
            	            match(input,84,FOLLOW_84_in_file_specification245); if (state.failed) return importName;

            	            }
            	            break;
            	        case 3 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:332:97: '.'
            	            {
            	            match(input,50,FOLLOW_50_in_file_specification250); if (state.failed) return importName;

            	            if ( state.backtracking==0 ) {importName+=".";}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return importName;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            if ( input.LA(1)==24||input.LA(1)==62 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return importName;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            if ( state.backtracking==0 ) {
            ///System.out.println(importName);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return importName;
    }
    // $ANTLR end "file_specification"



    // $ANTLR start "macro_specification"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:334:1: macro_specification : '.+' ;
    public final void macro_specification() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:334:20: ( '.+' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:334:22: '.+'
            {
            match(input,51,FOLLOW_51_in_macro_specification274); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "macro_specification"


    public static class class_name_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "class_name"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:339:1: class_name : IDENTIFIER ;
    public final ObjectiveCParser.class_name_return class_name() throws RecognitionException {
        ObjectiveCParser.class_name_return retval = new ObjectiveCParser.class_name_return();
        retval.start = input.LT(1);


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:339:11: ( IDENTIFIER )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:340:2: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_class_name285); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "class_name"


    public static class superclass_name_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "superclass_name"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:342:1: superclass_name : IDENTIFIER ;
    public final ObjectiveCParser.superclass_name_return superclass_name() throws RecognitionException {
        ObjectiveCParser.superclass_name_return retval = new ObjectiveCParser.superclass_name_return();
        retval.start = input.LT(1);


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:342:16: ( IDENTIFIER )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:343:2: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_superclass_name294); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "superclass_name"



    // $ANTLR start "preprocessor_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:345:1: preprocessor_declaration : ( '#import' file_specification | '#include' file_specification | '#define' macro_specification | '#ifdef' expression | '#if' expression | '#undef' expression | '#ifndef' expression | '#endif' );
    public final void preprocessor_declaration() throws RecognitionException {
        String file_specification5 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:345:25: ( '#import' file_specification | '#include' file_specification | '#define' macro_specification | '#ifdef' expression | '#if' expression | '#undef' expression | '#ifndef' expression | '#endif' )
            int alt5=8;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt5=1;
                }
                break;
            case 31:
                {
                alt5=2;
                }
                break;
            case 25:
                {
                alt5=3;
                }
                break;
            case 28:
                {
                alt5=4;
                }
                break;
            case 27:
                {
                alt5=5;
                }
                break;
            case 32:
                {
                alt5=6;
                }
                break;
            case 29:
                {
                alt5=7;
                }
                break;
            case 26:
                {
                alt5=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:346:3: '#import' file_specification
                    {
                    match(input,30,FOLLOW_30_in_preprocessor_declaration304); if (state.failed) return ;

                    pushFollow(FOLLOW_file_specification_in_preprocessor_declaration306);
                    file_specification5=file_specification();

                    state._fsp--;
                    if (state.failed) return ;

                    if ( state.backtracking==0 ) {Import import_ = new Import(null,currentLineNumber); 
                      								import_.setImportName(new Identifier(file_specification5, IdentifierType.IMPORT));
                        							importsInFile.addImport(import_);
                        							}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:350:3: '#include' file_specification
                    {
                    match(input,31,FOLLOW_31_in_preprocessor_declaration312); if (state.failed) return ;

                    pushFollow(FOLLOW_file_specification_in_preprocessor_declaration314);
                    file_specification();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:351:3: '#define' macro_specification
                    {
                    match(input,25,FOLLOW_25_in_preprocessor_declaration319); if (state.failed) return ;

                    pushFollow(FOLLOW_macro_specification_in_preprocessor_declaration321);
                    macro_specification();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:352:3: '#ifdef' expression
                    {
                    match(input,28,FOLLOW_28_in_preprocessor_declaration325); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_preprocessor_declaration327);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:353:3: '#if' expression
                    {
                    match(input,27,FOLLOW_27_in_preprocessor_declaration331); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_preprocessor_declaration333);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:354:3: '#undef' expression
                    {
                    match(input,32,FOLLOW_32_in_preprocessor_declaration337); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_preprocessor_declaration339);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:355:3: '#ifndef' expression
                    {
                    match(input,29,FOLLOW_29_in_preprocessor_declaration343); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_preprocessor_declaration345);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:356:3: '#endif'
                    {
                    match(input,26,FOLLOW_26_in_preprocessor_declaration349); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "preprocessor_declaration"



    // $ANTLR start "protocol_interface_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:358:1: protocol_interface_declaration returns [ListFunction functions] : ( interface_declaration_list )* ( qualified_protocol_interface_declaration )* ;
    public final ListFunction protocol_interface_declaration() throws RecognitionException {
        ListFunction functions = null;


        ObjectiveCParser.interface_declaration_list_return interface_declaration_list6 =null;

        ListFunction qualified_protocol_interface_declaration7 =null;




        	ListFunction annotated_ = null;
        	ListFunction required_ = null;
        	functions = null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:374:2: ( ( interface_declaration_list )* ( qualified_protocol_interface_declaration )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:375:2: ( interface_declaration_list )* ( qualified_protocol_interface_declaration )*
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:375:2: ( interface_declaration_list )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IDENTIFIER||LA6_0==42||LA6_0==46||LA6_0==75||LA6_0==81||LA6_0==89||(LA6_0 >= 93 && LA6_0 <= 94)||LA6_0==99||(LA6_0 >= 101 && LA6_0 <= 102)||LA6_0==105||(LA6_0 >= 107 && LA6_0 <= 108)||LA6_0==112||(LA6_0 >= 116 && LA6_0 <= 117)||LA6_0==119||LA6_0==124||(LA6_0 >= 126 && LA6_0 <= 128)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:375:2: interface_declaration_list
            	    {
            	    pushFollow(FOLLOW_interface_declaration_list_in_protocol_interface_declaration373);
            	    interface_declaration_list6=interface_declaration_list();

            	    state._fsp--;
            	    if (state.failed) return functions;

            	    if ( state.backtracking==0 ) { required_ = (interface_declaration_list6!=null?interface_declaration_list6.functions:null); }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:377:2: ( qualified_protocol_interface_declaration )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==72||LA7_0==79) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:377:2: qualified_protocol_interface_declaration
            	    {
            	    pushFollow(FOLLOW_qualified_protocol_interface_declaration_in_protocol_interface_declaration382);
            	    qualified_protocol_interface_declaration7=qualified_protocol_interface_declaration();

            	    state._fsp--;
            	    if (state.failed) return functions;

            	    if ( state.backtracking==0 ) { 
            	       
            	        annotated_ = mergeProtocolFunctions( qualified_protocol_interface_declaration7, annotated_);
            	     }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

            	if(annotated_ != null && required_ !=null){
            		functions = mergeProtocolFunctions(annotated_, required_);
            	}
            	else
            		functions = annotated_!=null?annotated_: required_;
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return functions;
    }
    // $ANTLR end "protocol_interface_declaration"



    // $ANTLR start "qualified_protocol_interface_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:383:1: qualified_protocol_interface_declaration returns [ListFunction qualifiedList] : ( '@optional' interface_declaration_list | '@required' interface_declaration_list );
    public final ListFunction qualified_protocol_interface_declaration() throws RecognitionException {
        ListFunction qualifiedList = null;


        ObjectiveCParser.interface_declaration_list_return interface_declaration_list8 =null;

        ObjectiveCParser.interface_declaration_list_return interface_declaration_list9 =null;




        qualifiedList = null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:389:7: ( '@optional' interface_declaration_list | '@required' interface_declaration_list )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==72) ) {
                alt8=1;
            }
            else if ( (LA8_0==79) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return qualifiedList;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:390:7: '@optional' interface_declaration_list
                    {
                    match(input,72,FOLLOW_72_in_qualified_protocol_interface_declaration410); if (state.failed) return qualifiedList;

                    pushFollow(FOLLOW_interface_declaration_list_in_qualified_protocol_interface_declaration412);
                    interface_declaration_list8=interface_declaration_list();

                    state._fsp--;
                    if (state.failed) return qualifiedList;

                    if ( state.backtracking==0 ) { qualifiedList = (interface_declaration_list8!=null?interface_declaration_list8.functions:null);   }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:391:7: '@required' interface_declaration_list
                    {
                    match(input,79,FOLLOW_79_in_qualified_protocol_interface_declaration422); if (state.failed) return qualifiedList;

                    pushFollow(FOLLOW_interface_declaration_list_in_qualified_protocol_interface_declaration424);
                    interface_declaration_list9=interface_declaration_list();

                    state._fsp--;
                    if (state.failed) return qualifiedList;

                    if ( state.backtracking==0 ) { qualifiedList = (interface_declaration_list9!=null?interface_declaration_list9.functions:null);   }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return qualifiedList;
    }
    // $ANTLR end "qualified_protocol_interface_declaration"



    // $ANTLR start "protocol_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:394:1: protocol_declaration returns [Protocol protocol] : '@protocol' pName= protocol_name ( ':' superclass_name )? (pList= protocol_reference_list )? ( protocol_interface_declaration ) '@end' ;
    public final Protocol protocol_declaration() throws RecognitionException {
        Protocol protocol = null;


        String pName =null;

        ListProtocol pList =null;

        ObjectiveCParser.superclass_name_return superclass_name10 =null;

        ListFunction protocol_interface_declaration11 =null;



           
            protocol = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);
            //symbolTable.setCurrentParent(protocol); //Set protocol as current Parent in symboltable
            
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:402:5: ( '@protocol' pName= protocol_name ( ':' superclass_name )? (pList= protocol_reference_list )? ( protocol_interface_declaration ) '@end' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:403:2: '@protocol' pName= protocol_name ( ':' superclass_name )? (pList= protocol_reference_list )? ( protocol_interface_declaration ) '@end'
            {
            match(input,77,FOLLOW_77_in_protocol_declaration453); if (state.failed) return protocol;

            pushFollow(FOLLOW_protocol_name_in_protocol_declaration463);
            pName=protocol_name();

            state._fsp--;
            if (state.failed) return protocol;

            if ( state.backtracking==0 ) { protocol.setProtocolName( new Identifier(pName) ); }

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:407:2: ( ':' superclass_name )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==54) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:407:3: ':' superclass_name
                    {
                    match(input,54,FOLLOW_54_in_protocol_declaration471); if (state.failed) return protocol;

                    pushFollow(FOLLOW_superclass_name_in_protocol_declaration473);
                    superclass_name10=superclass_name();

                    state._fsp--;
                    if (state.failed) return protocol;

                    if ( state.backtracking==0 ) {  	 Identifier className = new Identifier((superclass_name10!=null?input.toString(superclass_name10.start,superclass_name10.stop):null),IdentifierType.CLASS);
                    			                     
                    			                        if( symbolTable.checkKeyExistence((superclass_name10!=null?input.toString(superclass_name10.start,superclass_name10.stop):null)) == true){
                    			                        
                    			                            System.out.println("ST => superclass'" + (superclass_name10!=null?input.toString(superclass_name10.start,superclass_name10.stop):null) +"' found in ST and referenced"); 
                    			                            protocol.setSuperClass((ClassInterface) symbolTable.getObject((superclass_name10!=null?input.toString(superclass_name10.start,superclass_name10.stop):null), IdentifierType.CLASS));
                    			                           
                    			                        }
                    			                        else{
                    			                        
                    			                            System.out.println("ST => superclass '" + (superclass_name10!=null?input.toString(superclass_name10.start,superclass_name10.stop):null) +"' not found..creating placeholder");
                    			                           
                    			                            ClassInterface class_ = new ClassInterface(packageDef, IdentifierType.CLASS, -1);
                    			                            class_.setClassName(className);
                    			                            protocol.setSuperClass(class_);
                    			                            symbolTable.addToUnreferencedStack(class_);
                    			                           
                    			                        }
                    			                        
                    			             }

                    }
                    break;

            }


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:429:2: (pList= protocol_reference_list )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==56) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:429:4: pList= protocol_reference_list
                    {
                    pushFollow(FOLLOW_protocol_reference_list_in_protocol_declaration491);
                    pList=protocol_reference_list();

                    state._fsp--;
                    if (state.failed) return protocol;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { protocol.setProtocolList(pList); }

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:431:2: ( protocol_interface_declaration )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:431:4: protocol_interface_declaration
            {
            pushFollow(FOLLOW_protocol_interface_declaration_in_protocol_declaration503);
            protocol_interface_declaration11=protocol_interface_declaration();

            state._fsp--;
            if (state.failed) return protocol;

            }


            if ( state.backtracking==0 ) {	
            		if(protocol_interface_declaration11!=null){
            			protocol_interface_declaration11.setAllFunctionsParent(protocol);
            			protocol.setFunctions(protocol_interface_declaration11); 
            			}
            		
            	}

            match(input,69,FOLLOW_69_in_protocol_declaration510); if (state.failed) return protocol;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return protocol;
    }
    // $ANTLR end "protocol_declaration"



    // $ANTLR start "protocol_declaration_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:443:1: protocol_declaration_list : ( '@protocol' protocol_list ';' ) ;
    public final void protocol_declaration_list() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:443:26: ( ( '@protocol' protocol_list ';' ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:444:2: ( '@protocol' protocol_list ';' )
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:444:2: ( '@protocol' protocol_list ';' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:444:3: '@protocol' protocol_list ';'
            {
            match(input,77,FOLLOW_77_in_protocol_declaration_list524); if (state.failed) return ;

            pushFollow(FOLLOW_protocol_list_in_protocol_declaration_list526);
            protocol_list();

            state._fsp--;
            if (state.failed) return ;

            match(input,55,FOLLOW_55_in_protocol_declaration_list527); if (state.failed) return ;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "protocol_declaration_list"



    // $ANTLR start "protocol_reference_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:447:1: protocol_reference_list returns [ListProtocol protocolRefList] : '<' protocol_list '>' ;
    public final ListProtocol protocol_reference_list() throws RecognitionException {
        ListProtocol protocolRefList = null;


        ListProtocol protocol_list12 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:449:2: ( '<' protocol_list '>' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:450:3: '<' protocol_list '>'
            {
            match(input,56,FOLLOW_56_in_protocol_reference_list547); if (state.failed) return protocolRefList;

            pushFollow(FOLLOW_protocol_list_in_protocol_reference_list551);
            protocol_list12=protocol_list();

            state._fsp--;
            if (state.failed) return protocolRefList;

            if ( state.backtracking==0 ) { protocolRefList = protocol_list12; }

            match(input,62,FOLLOW_62_in_protocol_reference_list556); if (state.failed) return protocolRefList;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return protocolRefList;
    }
    // $ANTLR end "protocol_reference_list"



    // $ANTLR start "protocol_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:452:1: protocol_list returns [ListProtocol listProtocol] : n1= protocol_name ( ',' n2= protocol_name )* ;
    public final ListProtocol protocol_list() throws RecognitionException {
        ListProtocol listProtocol = null;


        String n1 =null;

        String n2 =null;



         //Protocol protocol_ = (Protocol)symbolTable.getCurrentParent();
         listProtocol=new ListProtocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);
         
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:458:2: (n1= protocol_name ( ',' n2= protocol_name )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:460:2: n1= protocol_name ( ',' n2= protocol_name )*
            {
            pushFollow(FOLLOW_protocol_name_in_protocol_list583);
            n1=protocol_name();

            state._fsp--;
            if (state.failed) return listProtocol;

            if ( state.backtracking==0 ) {
            			  				   	       Protocol p1 = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);  //TODO: packageDef?? shouldn't it be the one the protocol is in
            		  							   p1.setProtocolName(new Identifier(n1));
            			                        
            	
            	    	  if( symbolTable.checkKeyExistence(n1) == true){
            		  

            			                            System.out.println("ST => protocol'" + n1 +"' found and referenced");
            			                            
            			                          //  protocol_.addReferenceProtocol ( p1 );
            			                        }
            			                        else{
            			                        
            			                            System.out.println("ST => protocol '" + n1 +"' not found..creating placeholder");
            			                           
            			                            Protocol placeHolder = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber); 
            			                            
            			                            placeHolder.setProtocolName(new Identifier(n1,IdentifierType.PROTOCOL));
            			                            
            			                            symbolTable.addToUnreferencedStack(placeHolder);
            			                            
                                                  //  protocol_.addReferenceProtocol ( p1 );
                                               
                                                    listProtocol.addProtocol(p1);
            			                       
            			                            }
            			                       
            			                         }

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:489:3: ( ',' n2= protocol_name )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==45) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:489:4: ',' n2= protocol_name
            	    {
            	    match(input,45,FOLLOW_45_in_protocol_list589); if (state.failed) return listProtocol;

            	    pushFollow(FOLLOW_protocol_name_in_protocol_list593);
            	    n2=protocol_name();

            	    state._fsp--;
            	    if (state.failed) return listProtocol;

            	    if ( state.backtracking==0 ) {
            	    	 
            	    	 				  Protocol p2 = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber);  //TODO: packageDef?? shouldn't it be the one the protocol is in
            	    	 				  							    
            	    		  	          p2.setProtocolName(new Identifier(n2));
            	    	 				  
            	    	 				  if( symbolTable.checkKeyExistence(n2) == true){
            	    		  			                        
            	    			                            System.out.println("ST => protocol'" + n2 +"' found and referenced");

            	    			                        }
            	    			                        else{
            	    			                        
            	    			                            System.out.println("ST => protocol '" + n2 +"' not found..creating placeholder");
            	    			                           
            	    			                            Protocol placeHolder = new Protocol(packageDef, IdentifierType.PROTOCOL, currentLineNumber); 
            	    			                            
            	    			                            placeHolder.setProtocolName(new Identifier(n2,IdentifierType.PROTOCOL));
            	    			                            
            	    			                            symbolTable.addToUnreferencedStack(placeHolder);
            	    			                        
            	    			                           // protocol_.addReferenceProtocol ( p2 );
            	    			                            
            	    			                            listProtocol.addProtocol(p2);
            	    			                            
            	    			                            }
            	    	                          
            	    			}

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return listProtocol;
    }
    // $ANTLR end "protocol_list"



    // $ANTLR start "protocol_name"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:519:1: protocol_name returns [String text] : v= IDENTIFIER ;
    public final String protocol_name() throws RecognitionException {
        String text = null;


        Token v=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:521:2: (v= IDENTIFIER )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:522:2: v= IDENTIFIER
            {
            v=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_protocol_name618); if (state.failed) return text;

            if ( state.backtracking==0 ) {text = (v!=null?v.getText():null);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return text;
    }
    // $ANTLR end "protocol_name"



    // $ANTLR start "class_interface"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:527:1: class_interface returns [ClassInterface classInterface] : '@interface' ( class_name ( ':' superclass_name )? ( protocol_reference_list )? ( instance_variables )? (idl= interface_declaration_list )? ) '@end' ;
    public final ClassInterface class_interface() throws RecognitionException {
        ClassInterface classInterface = null;


        ObjectiveCParser.interface_declaration_list_return idl =null;

        ObjectiveCParser.class_name_return class_name13 =null;

        ObjectiveCParser.superclass_name_return superclass_name14 =null;

        ListProtocol protocol_reference_list15 =null;

        ListDeclaration instance_variables16 =null;



             
        	((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable =new VariableScopeTable();
        	classInterface =new ClassInterface( packageDef, IdentifierType.CLASS, currentLineNumber);
        	classInterface.setIsImplementation(false);


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:537:2: ( '@interface' ( class_name ( ':' superclass_name )? ( protocol_reference_list )? ( instance_variables )? (idl= interface_declaration_list )? ) '@end' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:539:2: '@interface' ( class_name ( ':' superclass_name )? ( protocol_reference_list )? ( instance_variables )? (idl= interface_declaration_list )? ) '@end'
            {
            match(input,71,FOLLOW_71_in_class_interface645); if (state.failed) return classInterface;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:540:2: ( class_name ( ':' superclass_name )? ( protocol_reference_list )? ( instance_variables )? (idl= interface_declaration_list )? )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:541:3: class_name ( ':' superclass_name )? ( protocol_reference_list )? ( instance_variables )? (idl= interface_declaration_list )?
            {
            pushFollow(FOLLOW_class_name_in_class_interface652);
            class_name13=class_name();

            state._fsp--;
            if (state.failed) return classInterface;

            if ( state.backtracking==0 ) { classInterface.setClassName(new Identifier((class_name13!=null?input.toString(class_name13.start,class_name13.stop):null),IdentifierType.CLASS)); 	symbolTable.setCurrentClass(classInterface);}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:543:3: ( ':' superclass_name )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==54) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:544:4: ':' superclass_name
                    {
                    match(input,54,FOLLOW_54_in_class_interface667); if (state.failed) return classInterface;

                    pushFollow(FOLLOW_superclass_name_in_class_interface669);
                    superclass_name14=superclass_name();

                    state._fsp--;
                    if (state.failed) return classInterface;

                    if ( state.backtracking==0 ) {  Identifier className = new Identifier((superclass_name14!=null?input.toString(superclass_name14.start,superclass_name14.stop):null),IdentifierType.CLASS);
                    			                       classInterface.setSuperClassName(new Identifier((superclass_name14!=null?input.toString(superclass_name14.start,superclass_name14.stop):null),IdentifierType.CLASS));  
                    		
                    			                       
                    			                        if( symbolTable.checkKeyExistence((superclass_name14!=null?input.toString(superclass_name14.start,superclass_name14.stop):null)) == true){
                    			                        
                    			                            System.out.println("ST => superclass'" + (superclass_name14!=null?input.toString(superclass_name14.start,superclass_name14.stop):null) +"' found in ST and referenced");
                    			                            
                    			                            classInterface.setSuperClass ( (ClassInterface) symbolTable.getObject((superclass_name14!=null?input.toString(superclass_name14.start,superclass_name14.stop):null), IdentifierType.CLASS) );
                    			                        }
                    			                        else{
                    			                        
                    			                            System.out.println("ST => superclass '" + (superclass_name14!=null?input.toString(superclass_name14.start,superclass_name14.stop):null) +"' not found..creating placeholder");
                    			                           
                    			                            ClassInterface placeHolder = new ClassInterface(packageDef, IdentifierType.CLASS, currentLineNumber); 
                    			                            
                    			                            placeHolder.setClassName(new Identifier((superclass_name14!=null?input.toString(superclass_name14.start,superclass_name14.stop):null),IdentifierType.CLASS));
                    			                            
                    			                            symbolTable.addToUnreferencedStack(placeHolder);
                    			                            
                    			                            classInterface.setSuperClass ( placeHolder ); //or pass it null-not sure
                    			                               
                    			                        }
                    			                        
                    			                    }

                    }
                    break;

            }


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:570:6: ( protocol_reference_list )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==56) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:570:8: protocol_reference_list
                    {
                    pushFollow(FOLLOW_protocol_reference_list_in_class_interface686);
                    protocol_reference_list15=protocol_reference_list();

                    state._fsp--;
                    if (state.failed) return classInterface;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { classInterface.setProtocols(protocol_reference_list15); }

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:571:3: ( instance_variables )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==130) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:572:4: instance_variables
                    {
                    pushFollow(FOLLOW_instance_variables_in_class_interface702);
                    instance_variables16=instance_variables();

                    state._fsp--;
                    if (state.failed) return classInterface;

                    if ( state.backtracking==0 ) {classInterface.setInstanceVariables(instance_variables16); ((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable.put(instance_variables16);}

                    }
                    break;

            }


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:574:3: (idl= interface_declaration_list )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER||LA15_0==42||LA15_0==46||LA15_0==75||LA15_0==81||LA15_0==89||(LA15_0 >= 93 && LA15_0 <= 94)||LA15_0==99||(LA15_0 >= 101 && LA15_0 <= 102)||LA15_0==105||(LA15_0 >= 107 && LA15_0 <= 108)||LA15_0==112||(LA15_0 >= 116 && LA15_0 <= 117)||LA15_0==119||LA15_0==124||(LA15_0 >= 126 && LA15_0 <= 128)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:575:5: idl= interface_declaration_list
                    {
                    pushFollow(FOLLOW_interface_declaration_list_in_class_interface722);
                    idl=interface_declaration_list();

                    state._fsp--;
                    if (state.failed) return classInterface;

                    if ( state.backtracking==0 ) {
                    		 		(idl!=null?idl.functions:null).setAllFunctionsOwner(classInterface); //this is already being set
                    		 		classInterface.setFunctions((idl!=null?idl.functions:null));
                    		 		classInterface.getInstanceVariables().addAll((idl!=null?idl.declarations:null)); //TODO: Check wether This actually adds to the classInterface or instead creates new object
                    		 		
                    		 	}

                    }
                    break;

            }


            }


            match(input,69,FOLLOW_69_in_class_interface736); if (state.failed) return classInterface;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return classInterface;
    }
    // $ANTLR end "class_interface"


    public static class interface_declaration_list_return extends ParserRuleReturnScope {
        public ListFunction functions;
        public ListDeclaration declarations;
    };


    // $ANTLR start "interface_declaration_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:585:1: interface_declaration_list returns [ListFunction functions,ListDeclaration declarations] : ( declaration | class_method_declaration | instance_method_declaration | property_declaration )+ ;
    public final ObjectiveCParser.interface_declaration_list_return interface_declaration_list() throws RecognitionException {
        ObjectiveCParser.interface_declaration_list_return retval = new ObjectiveCParser.interface_declaration_list_return();
        retval.start = input.LT(1);


        ListDeclaration declaration17 =null;

        Function class_method_declaration18 =null;

        Function instance_method_declaration19 =null;



        	retval.functions = new ListFunction(null,currentLineNumber);
        	retval.declarations =new ListDeclaration(null,currentLineNumber);
        	//Protocol protocol_ = (Protocol)symbolTable.getCurrentParent();

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:593:2: ( ( declaration | class_method_declaration | instance_method_declaration | property_declaration )+ )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:594:2: ( declaration | class_method_declaration | instance_method_declaration | property_declaration )+
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:594:2: ( declaration | class_method_declaration | instance_method_declaration | property_declaration )+
            int cnt16=0;
            loop16:
            do {
                int alt16=5;
                switch ( input.LA(1) ) {
                case 89:
                    {
                    int LA16_2 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 112:
                    {
                    int LA16_3 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 119:
                    {
                    int LA16_4 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 101:
                    {
                    int LA16_5 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 127:
                    {
                    int LA16_6 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 93:
                    {
                    int LA16_7 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 116:
                    {
                    int LA16_8 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 108:
                    {
                    int LA16_9 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 107:
                    {
                    int LA16_10 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 102:
                    {
                    int LA16_11 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 99:
                    {
                    int LA16_12 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 81:
                    {
                    int LA16_13 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 117:
                    {
                    int LA16_14 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 126:
                    {
                    int LA16_15 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 124:
                    {
                    int LA16_16 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 94:
                    {
                    int LA16_17 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 128:
                    {
                    int LA16_18 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 105:
                    {
                    int LA16_19 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA16_20 = input.LA(2);

                    if ( (synpred35_ObjectiveC()) ) {
                        alt16=1;
                    }


                    }
                    break;
                case 42:
                    {
                    int LA16_21 = input.LA(2);

                    if ( (synpred36_ObjectiveC()) ) {
                        alt16=2;
                    }


                    }
                    break;
                case 46:
                    {
                    int LA16_22 = input.LA(2);

                    if ( (synpred37_ObjectiveC()) ) {
                        alt16=3;
                    }


                    }
                    break;
                case 75:
                    {
                    int LA16_23 = input.LA(2);

                    if ( (synpred38_ObjectiveC()) ) {
                        alt16=4;
                    }


                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:595:5: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_interface_declaration_list761);
            	    declaration17=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {retval.declarations.addAll(declaration17);}

            	    }
            	    break;
            	case 2 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:596:5: class_method_declaration
            	    {
            	    pushFollow(FOLLOW_class_method_declaration_in_interface_declaration_list774);
            	    class_method_declaration18=class_method_declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {retval.functions.addFunction(class_method_declaration18);}

            	    }
            	    break;
            	case 3 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:597:5: instance_method_declaration
            	    {
            	    pushFollow(FOLLOW_instance_method_declaration_in_interface_declaration_list784);
            	    instance_method_declaration19=instance_method_declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {retval.functions.addFunction(instance_method_declaration19);}

            	    }
            	    break;
            	case 4 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:598:5: property_declaration
            	    {
            	    pushFollow(FOLLOW_property_declaration_in_interface_declaration_list792);
            	    property_declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "interface_declaration_list"



    // $ANTLR start "class_method_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:602:1: class_method_declaration returns [Function function] : ( '+' method_declaration ) ;
    public final Function class_method_declaration() throws RecognitionException {
        Function function = null;


        Function method_declaration20 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:604:2: ( ( '+' method_declaration ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:605:2: ( '+' method_declaration )
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:605:2: ( '+' method_declaration )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:606:3: '+' method_declaration
            {
            match(input,42,FOLLOW_42_in_class_method_declaration817); if (state.failed) return function;

            pushFollow(FOLLOW_method_declaration_in_class_method_declaration819);
            method_declaration20=method_declaration();

            state._fsp--;
            if (state.failed) return function;

            if ( state.backtracking==0 ) {
            			function =method_declaration20;
            			function.setFunctionType(Function.FunctionType.CLASS_METHOD);
            		}

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return function;
    }
    // $ANTLR end "class_method_declaration"



    // $ANTLR start "instance_method_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:613:1: instance_method_declaration returns [Function function] : ( '-' method_declaration ) ;
    public final Function instance_method_declaration() throws RecognitionException {
        Function function = null;


        Function method_declaration21 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:615:2: ( ( '-' method_declaration ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:616:2: ( '-' method_declaration )
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:616:2: ( '-' method_declaration )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:617:3: '-' method_declaration
            {
            match(input,46,FOLLOW_46_in_instance_method_declaration842); if (state.failed) return function;

            pushFollow(FOLLOW_method_declaration_in_instance_method_declaration844);
            method_declaration21=method_declaration();

            state._fsp--;
            if (state.failed) return function;

            if ( state.backtracking==0 ) {
            			function =method_declaration21;
            			function.setFunctionType(Function.FunctionType.INSTANCE_METHOD);
            		}

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return function;
    }
    // $ANTLR end "instance_method_declaration"



    // $ANTLR start "method_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:624:1: method_declaration returns [Function function] : ( method_type )? method_selector ';' ;
    public final Function method_declaration() throws RecognitionException {
        CurrentFunction_stack.push(new CurrentFunction_scope());

        Function function = null;


        MethodType method_type22 =null;

        Function method_selector23 =null;



        	function =null;
        	MethodType methodType=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:632:2: ( ( method_type )? method_selector ';' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:633:2: ( method_type )? method_selector ';'
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:633:2: ( method_type )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:634:3: method_type
                    {
                    pushFollow(FOLLOW_method_type_in_method_declaration879);
                    method_type22=method_type();

                    state._fsp--;
                    if (state.failed) return function;

                    if ( state.backtracking==0 ) {methodType=method_type22;}

                    }
                    break;

            }


            pushFollow(FOLLOW_method_selector_in_method_declaration887);
            method_selector23=method_selector();

            state._fsp--;
            if (state.failed) return function;

            if ( state.backtracking==0 ) {
            		function =method_selector23;
            		if(methodType!=null){
            			function.setModifier(methodType.getModifier());
            			function.setSpecifier(methodType.getSpecifier());
            			function.setDataType(methodType.getDataType());
            			function.setArrayType(methodType.getArrayType());
            		}
            	
            	}

            match(input,55,FOLLOW_55_in_method_declaration892); if (state.failed) return function;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            CurrentFunction_stack.pop();

        }
        return function;
    }
    // $ANTLR end "method_declaration"



    // $ANTLR start "instance_variables"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:650:1: instance_variables returns [ListDeclaration declarations] : '{' ivd= instance_variable_declaration '}' ;
    public final ListDeclaration instance_variables() throws RecognitionException {
        ListDeclaration declarations = null;


        ListDeclaration ivd =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:652:2: ( '{' ivd= instance_variable_declaration '}' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:653:2: '{' ivd= instance_variable_declaration '}'
            {
            match(input,130,FOLLOW_130_in_instance_variables912); if (state.failed) return declarations;

            pushFollow(FOLLOW_instance_variable_declaration_in_instance_variables919);
            ivd=instance_variable_declaration();

            state._fsp--;
            if (state.failed) return declarations;

            if ( state.backtracking==0 ) {declarations =ivd; System.err.println("I have added class vars");}

            match(input,134,FOLLOW_134_in_instance_variables924); if (state.failed) return declarations;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declarations;
    }
    // $ANTLR end "instance_variables"



    // $ANTLR start "instance_variable_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:658:1: instance_variable_declaration returns [ListDeclaration declarations] : (vs= visibility_specification | struct_declaration )+ ;
    public final ListDeclaration instance_variable_declaration() throws RecognitionException {
        ListDeclaration declarations = null;


        AccessType vs =null;

        ListDeclaration struct_declaration24 =null;



        	AccessType accessType=AccessType.PRIVATE;
        	declarations =new ListDeclaration(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:664:2: ( (vs= visibility_specification | struct_declaration )+ )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:665:2: (vs= visibility_specification | struct_declaration )+
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:665:2: (vs= visibility_specification | struct_declaration )+
            int cnt18=0;
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= 73 && LA18_0 <= 74)||LA18_0==76||LA18_0==78) ) {
                    alt18=1;
                }
                else if ( (LA18_0==IDENTIFIER||LA18_0==81||LA18_0==90||(LA18_0 >= 93 && LA18_0 <= 94)||LA18_0==99||LA18_0==102||LA18_0==105||(LA18_0 >= 107 && LA18_0 <= 108)||(LA18_0 >= 116 && LA18_0 <= 117)||LA18_0==120||(LA18_0 >= 124 && LA18_0 <= 128)) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:666:4: vs= visibility_specification
            	    {
            	    pushFollow(FOLLOW_visibility_specification_in_instance_variable_declaration950);
            	    vs=visibility_specification();

            	    state._fsp--;
            	    if (state.failed) return declarations;

            	    if ( state.backtracking==0 ) {accessType=vs;}

            	    }
            	    break;
            	case 2 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:668:4: struct_declaration
            	    {
            	    pushFollow(FOLLOW_struct_declaration_in_instance_variable_declaration962);
            	    struct_declaration24=struct_declaration();

            	    state._fsp--;
            	    if (state.failed) return declarations;

            	    if ( state.backtracking==0 ) {
            	    		struct_declaration24.setAllDeclarationsAccessType(accessType);
            	    		declarations.addAll(struct_declaration24);
            	    	}

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return declarations;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declarations;
    }
    // $ANTLR end "instance_variable_declaration"



    // $ANTLR start "visibility_specification"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:675:1: visibility_specification returns [AccessType accessType] : ( '@private' | '@protected' | '@package' | '@public' );
    public final AccessType visibility_specification() throws RecognitionException {
        AccessType accessType = null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:677:2: ( '@private' | '@protected' | '@package' | '@public' )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt19=1;
                }
                break;
            case 76:
                {
                alt19=2;
                }
                break;
            case 73:
                {
                alt19=3;
                }
                break;
            case 78:
                {
                alt19=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return accessType;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }

            switch (alt19) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:678:2: '@private'
                    {
                    match(input,74,FOLLOW_74_in_visibility_specification983); if (state.failed) return accessType;

                    if ( state.backtracking==0 ) {accessType =AccessType.PRIVATE;}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:679:4: '@protected'
                    {
                    match(input,76,FOLLOW_76_in_visibility_specification990); if (state.failed) return accessType;

                    if ( state.backtracking==0 ) {accessType =AccessType.PROTECTED;}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:680:4: '@package'
                    {
                    match(input,73,FOLLOW_73_in_visibility_specification997); if (state.failed) return accessType;

                    if ( state.backtracking==0 ) {accessType =AccessType.PACKAGE;}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:681:4: '@public'
                    {
                    match(input,78,FOLLOW_78_in_visibility_specification1004); if (state.failed) return accessType;

                    if ( state.backtracking==0 ) {accessType =AccessType.PUBLIC;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return accessType;
    }
    // $ANTLR end "visibility_specification"



    // $ANTLR start "class_implementation"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:686:1: class_implementation returns [ClassInterface classImplementation] : '@implementation' ( class_name ( ':' superclass_name )? (idl= implementation_definition_list )? ) '@end' ;
    public final ClassInterface class_implementation() throws RecognitionException {
        ClassInterface classImplementation = null;


        ObjectiveCParser.implementation_definition_list_return idl =null;

        ObjectiveCParser.class_name_return class_name25 =null;

        ObjectiveCParser.superclass_name_return superclass_name26 =null;



             
             
             classImplementation =new ClassInterface(packageDef, IdentifierType.CLASS, currentLineNumber);
             classImplementation.setIsImplementation(true);
             
          //   ListFunction functions = null;
             
           //  ListDeclaration declarations = null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:698:2: ( '@implementation' ( class_name ( ':' superclass_name )? (idl= implementation_definition_list )? ) '@end' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:699:2: '@implementation' ( class_name ( ':' superclass_name )? (idl= implementation_definition_list )? ) '@end'
            {
            match(input,70,FOLLOW_70_in_class_implementation1027); if (state.failed) return classImplementation;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:700:2: ( class_name ( ':' superclass_name )? (idl= implementation_definition_list )? )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:701:3: class_name ( ':' superclass_name )? (idl= implementation_definition_list )?
            {
            pushFollow(FOLLOW_class_name_in_class_implementation1034);
            class_name25=class_name();

            state._fsp--;
            if (state.failed) return classImplementation;

            if ( state.backtracking==0 ) {
            			classImplementation.setClassName(new Identifier((class_name25!=null?input.toString(class_name25.start,class_name25.stop):null),IdentifierType.CLASS));symbolTable.setCurrentClass(classImplementation); 
            			ClassInterface ci=(ClassInterface)symbolTable.getInstance().getObject((class_name25!=null?input.toString(class_name25.start,class_name25.stop):null),IdentifierType.CLASS);
            			if(ci!=null){
            				 ((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable.put(ci.getInstanceVariables());
            				 System.err.println("Added class variable from interface"); 
            			}
            		}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:710:3: ( ':' superclass_name )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==54) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:711:4: ':' superclass_name
                    {
                    match(input,54,FOLLOW_54_in_class_implementation1050); if (state.failed) return classImplementation;

                    pushFollow(FOLLOW_superclass_name_in_class_implementation1052);
                    superclass_name26=superclass_name();

                    state._fsp--;
                    if (state.failed) return classImplementation;

                    if ( state.backtracking==0 ) { Identifier className = new Identifier((superclass_name26!=null?input.toString(superclass_name26.start,superclass_name26.stop):null),IdentifierType.CLASS);
                    			
                    			                      classImplementation.setSuperClassName(new Identifier((superclass_name26!=null?input.toString(superclass_name26.start,superclass_name26.stop):null),IdentifierType.CLASS));
                    		                       
                    			                        if( symbolTable.checkKeyExistence((superclass_name26!=null?input.toString(superclass_name26.start,superclass_name26.stop):null)) == true){
                    			                        
                    			                            System.out.println("ST => superclass'" + (superclass_name26!=null?input.toString(superclass_name26.start,superclass_name26.stop):null) +"' found and referenced");
                    			                            
                    			                            classImplementation.setSuperClass ( (ClassInterface) symbolTable.getObject((superclass_name26!=null?input.toString(superclass_name26.start,superclass_name26.stop):null), IdentifierType.CLASS) );
                    			                        }
                    			                        else{
                    			                        
                    			                            System.out.println("ST => superclass '" + (superclass_name26!=null?input.toString(superclass_name26.start,superclass_name26.stop):null) +"' not found..creating placeholder");
                    			                           
                    			                            ClassInterface placeHolder = new ClassInterface(packageDef, IdentifierType.CLASS, currentLineNumber); 
                    			                            
                    			                            placeHolder.setClassName(new Identifier((superclass_name26!=null?input.toString(superclass_name26.start,superclass_name26.stop):null),IdentifierType.CLASS));
                    			                            
                    			                            symbolTable.addToUnreferencedStack(placeHolder);
                    			                            
                    			                            classImplementation.setSuperClass ( placeHolder ); 
                    			                               
                    			                        }
                    			                      
                    			                    }

                    }
                    break;

            }


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:739:3: (idl= implementation_definition_list )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDENTIFIER||LA21_0==42||LA21_0==46||(LA21_0 >= 80 && LA21_0 <= 81)||LA21_0==89||(LA21_0 >= 93 && LA21_0 <= 94)||LA21_0==99||(LA21_0 >= 101 && LA21_0 <= 102)||LA21_0==105||(LA21_0 >= 107 && LA21_0 <= 108)||LA21_0==112||(LA21_0 >= 116 && LA21_0 <= 117)||LA21_0==119||LA21_0==124||(LA21_0 >= 126 && LA21_0 <= 128)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:740:4: idl= implementation_definition_list
                    {
                    pushFollow(FOLLOW_implementation_definition_list_in_class_implementation1078);
                    idl=implementation_definition_list();

                    state._fsp--;
                    if (state.failed) return classImplementation;

                    if ( state.backtracking==0 ) {
                    				(idl!=null?idl.functions:null).setAllFunctionsOwner(classImplementation);
                    				classImplementation.setFunctions((idl!=null?idl.functions:null));
                    				classImplementation.setInstanceVariables((idl!=null?idl.declarations:null));
                    				//functions = (idl!=null?idl.functions:null); TODO if something goes wrong uncomment
                    				//declarations = (idl!=null?idl.declarations:null);
                    			}

                    }
                    break;

            }


            }


            match(input,69,FOLLOW_69_in_class_implementation1097); if (state.failed) return classImplementation;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return classImplementation;
    }
    // $ANTLR end "class_implementation"


    public static class implementation_definition_list_return extends ParserRuleReturnScope {
        public ListFunction functions;
        public ListDeclaration declarations;
    };


    // $ANTLR start "implementation_definition_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:754:1: implementation_definition_list returns [ListFunction functions,ListDeclaration declarations] : ( function_definition | declaration | class_method_definition | instance_method_definition | property_implementation )+ ;
    public final ObjectiveCParser.implementation_definition_list_return implementation_definition_list() throws RecognitionException {
        ObjectiveCParser.implementation_definition_list_return retval = new ObjectiveCParser.implementation_definition_list_return();
        retval.start = input.LT(1);


        Function function_definition27 =null;

        ListDeclaration declaration28 =null;

        Function class_method_definition29 =null;

        Function instance_method_definition30 =null;



        retval.functions =new ListFunction(null,currentLineNumber);
        retval.declarations =new ListDeclaration(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:760:2: ( ( function_definition | declaration | class_method_definition | instance_method_definition | property_implementation )+ )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:761:2: ( function_definition | declaration | class_method_definition | instance_method_definition | property_implementation )+
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:761:2: ( function_definition | declaration | class_method_definition | instance_method_definition | property_implementation )+
            int cnt22=0;
            loop22:
            do {
                int alt22=6;
                switch ( input.LA(1) ) {
                case 89:
                    {
                    int LA22_3 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 112:
                    {
                    int LA22_4 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 119:
                    {
                    int LA22_5 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 101:
                    {
                    int LA22_6 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 127:
                    {
                    int LA22_7 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 93:
                    {
                    int LA22_8 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 116:
                    {
                    int LA22_9 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 108:
                    {
                    int LA22_10 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 107:
                    {
                    int LA22_11 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 102:
                    {
                    int LA22_12 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 99:
                    {
                    int LA22_13 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 81:
                    {
                    int LA22_14 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 117:
                    {
                    int LA22_15 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 126:
                    {
                    int LA22_16 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 124:
                    {
                    int LA22_17 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 94:
                    {
                    int LA22_18 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 128:
                    {
                    int LA22_19 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 105:
                    {
                    int LA22_20 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA22_21 = input.LA(2);

                    if ( (synpred47_ObjectiveC()) ) {
                        alt22=1;
                    }
                    else if ( (synpred48_ObjectiveC()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 42:
                    {
                    alt22=3;
                    }
                    break;
                case 46:
                    {
                    alt22=4;
                    }
                    break;
                case 80:
                    {
                    alt22=5;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:762:5: function_definition
            	    {
            	    pushFollow(FOLLOW_function_definition_in_implementation_definition_list1122);
            	    function_definition27=function_definition();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {retval.functions.addFunction(function_definition27);}

            	    }
            	    break;
            	case 2 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:763:5: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_implementation_definition_list1132);
            	    declaration28=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {retval.declarations.addAll(declaration28); ((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable.put(declaration28); }

            	    }
            	    break;
            	case 3 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:764:5: class_method_definition
            	    {
            	    pushFollow(FOLLOW_class_method_definition_in_implementation_definition_list1143);
            	    class_method_definition29=class_method_definition();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {retval.functions.addFunction(class_method_definition29);}

            	    }
            	    break;
            	case 4 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:765:5: instance_method_definition
            	    {
            	    pushFollow(FOLLOW_instance_method_definition_in_implementation_definition_list1151);
            	    instance_method_definition30=instance_method_definition();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {retval.functions.addFunction(instance_method_definition30);}

            	    }
            	    break;
            	case 5 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:766:5: property_implementation
            	    {
            	    pushFollow(FOLLOW_property_implementation_in_implementation_definition_list1158);
            	    property_implementation();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "implementation_definition_list"



    // $ANTLR start "class_method_definition"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:769:1: class_method_definition returns [Function function] : ( '+' method_definition ) ;
    public final Function class_method_definition() throws RecognitionException {
        CurrentFunction_stack.push(new CurrentFunction_scope());

        Function function = null;


        Function method_definition31 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:772:2: ( ( '+' method_definition ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:773:2: ( '+' method_definition )
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:773:2: ( '+' method_definition )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:774:3: '+' method_definition
            {
            match(input,42,FOLLOW_42_in_class_method_definition1185); if (state.failed) return function;

            pushFollow(FOLLOW_method_definition_in_class_method_definition1187);
            method_definition31=method_definition();

            state._fsp--;
            if (state.failed) return function;

            if ( state.backtracking==0 ) { 
            			function =method_definition31;
            			function.setFunctionType(Function.FunctionType.CLASS_METHOD);
            		}

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            CurrentFunction_stack.pop();

        }
        return function;
    }
    // $ANTLR end "class_method_definition"



    // $ANTLR start "instance_method_definition"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:781:1: instance_method_definition returns [Function function] : ( '-' method_definition ) ;
    public final Function instance_method_definition() throws RecognitionException {
        CurrentFunction_stack.push(new CurrentFunction_scope());

        Function function = null;


        Function method_definition32 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:784:2: ( ( '-' method_definition ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:785:2: ( '-' method_definition )
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:785:2: ( '-' method_definition )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:786:3: '-' method_definition
            {
            match(input,46,FOLLOW_46_in_instance_method_definition1216); if (state.failed) return function;

            pushFollow(FOLLOW_method_definition_in_instance_method_definition1218);
            method_definition32=method_definition();

            state._fsp--;
            if (state.failed) return function;

            if ( state.backtracking==0 ) { 
            			function =method_definition32;
            			function.setFunctionType(Function.FunctionType.INSTANCE_METHOD);
            		}

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            CurrentFunction_stack.pop();

        }
        return function;
    }
    // $ANTLR end "instance_method_definition"



    // $ANTLR start "method_definition"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:794:1: method_definition returns [Function function] : ( method_type )? method_selector cs= compound_statement ;
    public final Function method_definition() throws RecognitionException {
        Function function = null;


        Statement.CompoundStatement cs =null;

        MethodType method_type33 =null;

        Function method_selector34 =null;



        	MethodType methodType=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:799:2: ( ( method_type )? method_selector cs= compound_statement )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:800:2: ( method_type )? method_selector cs= compound_statement
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:800:2: ( method_type )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==38) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:801:3: method_type
                    {
                    pushFollow(FOLLOW_method_type_in_method_definition1250);
                    method_type33=method_type();

                    state._fsp--;
                    if (state.failed) return function;

                    if ( state.backtracking==0 ) {methodType=method_type33;}

                    }
                    break;

            }


            pushFollow(FOLLOW_method_selector_in_method_definition1260);
            method_selector34=method_selector();

            state._fsp--;
            if (state.failed) return function;

            if ( state.backtracking==0 ) {
            		function =method_selector34;
            		if(methodType!=null){
            			function.setModifier(methodType.getModifier());
            			function.setSpecifier(methodType.getSpecifier());
            			function.setDataType(methodType.getDataType());
            			function.setArrayType(methodType.getArrayType());
            		}
            		
            		((CurrentFunction_scope)CurrentFunction_stack.peek()).function =function;
            	}

            pushFollow(FOLLOW_compound_statement_in_method_definition1272);
            cs=compound_statement();

            state._fsp--;
            if (state.failed) return function;

            if ( state.backtracking==0 ) {
            		function.setCompoundStatement((Statement)cs);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return function;
    }
    // $ANTLR end "method_definition"



    // $ANTLR start "method_selector"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:821:1: method_selector returns [Function function] : ( selector | ( ( keyword_declarator )+ ( parameter_list )? ) );
    public final Function method_selector() throws RecognitionException {
        Function function = null;


        ObjectiveCParser.selector_return selector35 =null;

        Parameter keyword_declarator36 =null;

        ListDeclaration parameter_list37 =null;



        	function =new Function(null, IdentifierType.FUNCTION, currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:827:2: ( selector | ( ( keyword_declarator )+ ( parameter_list )? ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==IDENTIFIER) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==55||LA26_1==130) ) {
                    alt26=1;
                }
                else if ( (LA26_1==54) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return function;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA26_0==54) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return function;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:828:2: selector
                    {
                    pushFollow(FOLLOW_selector_in_method_selector1297);
                    selector35=selector();

                    state._fsp--;
                    if (state.failed) return function;

                    if ( state.backtracking==0 ) {
                    		Identifier identifier=new Identifier((selector35!=null?input.toString(selector35.start,selector35.stop):null),IdentifierType.FUNCTION);
                    		function.setIdentifier(identifier);
                    		
                    		
                    	}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:835:2: ( ( keyword_declarator )+ ( parameter_list )? )
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:835:2: ( ( keyword_declarator )+ ( parameter_list )? )
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:836:3: ( keyword_declarator )+ ( parameter_list )?
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:836:3: ( keyword_declarator )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDENTIFIER) ) {
                            int LA24_2 = input.LA(2);

                            if ( (LA24_2==54) ) {
                                alt24=1;
                            }


                        }
                        else if ( (LA24_0==54) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:837:4: keyword_declarator
                    	    {
                    	    pushFollow(FOLLOW_keyword_declarator_in_method_selector1316);
                    	    keyword_declarator36=keyword_declarator();

                    	    state._fsp--;
                    	    if (state.failed) return function;

                    	    if ( state.backtracking==0 ) {
                    	    				function.addParameter(keyword_declarator36);
                    	    			}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return function;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:842:3: ( parameter_list )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==IDENTIFIER||LA25_0==81||LA25_0==89||(LA25_0 >= 93 && LA25_0 <= 94)||LA25_0==99||(LA25_0 >= 101 && LA25_0 <= 102)||LA25_0==105||(LA25_0 >= 107 && LA25_0 <= 108)||LA25_0==112||(LA25_0 >= 116 && LA25_0 <= 117)||LA25_0==119||LA25_0==124||(LA25_0 >= 126 && LA25_0 <= 128)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:843:4: parameter_list
                            {
                            pushFollow(FOLLOW_parameter_list_in_method_selector1335);
                            parameter_list37=parameter_list();

                            state._fsp--;
                            if (state.failed) return function;

                            if ( state.backtracking==0 ) {
                            				function.setDeclarationList(parameter_list37);
                            			}

                            }
                            break;

                    }


                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return function;
    }
    // $ANTLR end "method_selector"



    // $ANTLR start "keyword_declarator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:850:1: keyword_declarator returns [Parameter parameter] : ( selector )? ':' ( method_type )* id= IDENTIFIER ;
    public final Parameter keyword_declarator() throws RecognitionException {
        Parameter parameter = null;


        Token id=null;
        ObjectiveCParser.selector_return selector38 =null;

        MethodType method_type39 =null;



        	parameter =new Parameter(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:855:2: ( ( selector )? ':' ( method_type )* id= IDENTIFIER )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:856:2: ( selector )? ':' ( method_type )* id= IDENTIFIER
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:856:2: ( selector )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDENTIFIER) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:857:3: selector
                    {
                    pushFollow(FOLLOW_selector_in_keyword_declarator1368);
                    selector38=selector();

                    state._fsp--;
                    if (state.failed) return parameter;

                    if ( state.backtracking==0 ) {
                    			parameter.setSelector(new Identifier((selector38!=null?input.toString(selector38.start,selector38.stop):null),IdentifierType.SELECTOR));
                    		}

                    }
                    break;

            }


            match(input,54,FOLLOW_54_in_keyword_declarator1377); if (state.failed) return parameter;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:861:6: ( method_type )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==38) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:862:3: method_type
            	    {
            	    pushFollow(FOLLOW_method_type_in_keyword_declarator1383);
            	    method_type39=method_type();

            	    state._fsp--;
            	    if (state.failed) return parameter;

            	    if ( state.backtracking==0 ) {
            	    			parameter.addType(method_type39);
            	    		}

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_keyword_declarator1393); if (state.failed) return parameter;

            if ( state.backtracking==0 ) { parameter.setParameterName(new Identifier((id!=null?id.getText():null),IdentifierType.PARAM_DECLARATION));}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return parameter;
    }
    // $ANTLR end "keyword_declarator"



    // $ANTLR start "parameter_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:868:1: parameter_list returns [ListDeclaration declarationList] : pdl= parameter_declaration_list ;
    public final ListDeclaration parameter_list() throws RecognitionException {
        ListDeclaration declarationList = null;


        ListDeclaration pdl =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:870:2: (pdl= parameter_declaration_list )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:871:2: pdl= parameter_declaration_list
            {
            pushFollow(FOLLOW_parameter_declaration_list_in_parameter_list1414);
            pdl=parameter_declaration_list();

            state._fsp--;
            if (state.failed) return declarationList;

            if ( state.backtracking==0 ) {
            		declarationList =pdl;
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declarationList;
    }
    // $ANTLR end "parameter_list"



    // $ANTLR start "parameter_declaration_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:876:1: parameter_declaration_list returns [ListDeclaration declarationList] : pd1= parameter_declaration ( ',' pd2= parameter_declaration )* ;
    public final ListDeclaration parameter_declaration_list() throws RecognitionException {
        VariableScopeTable_stack.push(new VariableScopeTable_scope());

        ListDeclaration declarationList = null;


        Declaration pd1 =null;

        Declaration pd2 =null;



        	declarationList =new ListDeclaration(null,currentLineNumber);
        	((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable =new VariableScopeTable();

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:883:3: (pd1= parameter_declaration ( ',' pd2= parameter_declaration )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:883:5: pd1= parameter_declaration ( ',' pd2= parameter_declaration )*
            {
            pushFollow(FOLLOW_parameter_declaration_in_parameter_declaration_list1446);
            pd1=parameter_declaration();

            state._fsp--;
            if (state.failed) return declarationList;

            if ( state.backtracking==0 ) {
              		declarationList.add(pd1);
              		((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable.put(pd1);
              	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:887:4: ( ',' pd2= parameter_declaration )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==45) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:888:5: ',' pd2= parameter_declaration
            	    {
            	    match(input,45,FOLLOW_45_in_parameter_declaration_list1461); if (state.failed) return declarationList;

            	    pushFollow(FOLLOW_parameter_declaration_in_parameter_declaration_list1465);
            	    pd2=parameter_declaration();

            	    state._fsp--;
            	    if (state.failed) return declarationList;

            	    if ( state.backtracking==0 ) {
            	      			declarationList.add(pd2);
            	      			((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable.put(pd1);
            	      		}

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            VariableScopeTable_stack.pop();

        }
        return declarationList;
    }
    // $ANTLR end "parameter_declaration_list"



    // $ANTLR start "parameter_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:896:1: parameter_declaration returns [Declaration declaration] : ds= declaration_specifiers ( (dec= declarator )? |ad= abstract_declarator ) ;
    public final Declaration parameter_declaration() throws RecognitionException {
        Declaration declaration = null;


        ObjectiveCParser.declaration_specifiers_return ds =null;

        ObjectiveCParser.declarator_return dec =null;

        ObjectiveCParser.abstract_declarator_return ad =null;



        	declaration =new Declaration(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:901:3: (ds= declaration_specifiers ( (dec= declarator )? |ad= abstract_declarator ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:901:5: ds= declaration_specifiers ( (dec= declarator )? |ad= abstract_declarator )
            {
            pushFollow(FOLLOW_declaration_specifiers_in_parameter_declaration1505);
            ds=declaration_specifiers();

            state._fsp--;
            if (state.failed) return declaration;

            if ( state.backtracking==0 ) {
              
              	(ds!=null?ds.modifier:null).setParent((Statement)declaration);
            	(ds!=null?ds.specifier:null).setParent((Statement)declaration);
            		
            	declaration.setModifier((ds!=null?ds.modifier:null));
            	declaration.setSpecifier((ds!=null?ds.specifier:null));
            	declaration.setDataType((ds!=null?ds.dataType:null));
            	
              }

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:910:5: ( (dec= declarator )? |ad= abstract_declarator )
            int alt31=2;
            switch ( input.LA(1) ) {
            case 40:
                {
                int LA31_1 = input.LA(2);

                if ( (synpred60_ObjectiveC()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                alt31=1;
                }
                break;
            case 45:
                {
                int LA31_3 = input.LA(2);

                if ( (synpred60_ObjectiveC()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 3, input);

                    throw nvae;

                }
                }
                break;
            case 55:
                {
                int LA31_4 = input.LA(2);

                if ( (synpred60_ObjectiveC()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 4, input);

                    throw nvae;

                }
                }
                break;
            case 130:
                {
                int LA31_5 = input.LA(2);

                if ( (synpred60_ObjectiveC()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 5, input);

                    throw nvae;

                }
                }
                break;
            case 39:
                {
                int LA31_6 = input.LA(2);

                if ( (synpred60_ObjectiveC()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 6, input);

                    throw nvae;

                }
                }
                break;
            case EOF:
                {
                int LA31_7 = input.LA(2);

                if ( (synpred60_ObjectiveC()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 7, input);

                    throw nvae;

                }
                }
                break;
            case 83:
                {
                alt31=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return declaration;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:912:4: (dec= declarator )?
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:912:4: (dec= declarator )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==IDENTIFIER||LA30_0==40) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:913:5: dec= declarator
                            {
                            pushFollow(FOLLOW_declarator_in_parameter_declaration1524);
                            dec=declarator();

                            state._fsp--;
                            if (state.failed) return declaration;

                            if ( state.backtracking==0 ) {
                              			declaration.setIdentifier((dec!=null?dec.identifier:null));
                              			declaration.setArrayDimensions((dec!=null?dec.arrayType:null));
                              		}

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:919:6: ad= abstract_declarator
                    {
                    pushFollow(FOLLOW_abstract_declarator_in_parameter_declaration1545);
                    ad=abstract_declarator();

                    state._fsp--;
                    if (state.failed) return declaration;

                    if ( state.backtracking==0 ) {
                      		declaration.setArrayDimensions((ad!=null?ad.arrayType:null));
                      	}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declaration;
    }
    // $ANTLR end "parameter_declaration"


    public static class abstract_declarator_return extends ParserRuleReturnScope {
        public Identifier identifier;
        public ArrayType arrayType;
        public ListDeclaration declarationList;
        public PointerType pointerType;
    };


    // $ANTLR start "abstract_declarator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:928:1: abstract_declarator returns [Identifier identifier,ArrayType arrayType,ListDeclaration declarationList,PointerType pointerType] : ( '*' ( type_qualifier )* dec= abstract_declarator | ( '[' (c= constant_expression )? ']' )+ |);
    public final ObjectiveCParser.abstract_declarator_return abstract_declarator() throws RecognitionException {
        ObjectiveCParser.abstract_declarator_return retval = new ObjectiveCParser.abstract_declarator_return();
        retval.start = input.LT(1);


        ObjectiveCParser.abstract_declarator_return dec =null;

        Expression c =null;



        	retval.arrayType =null;
        	Expression dimension=null;
        	retval.identifier =null;
        	retval.arrayType =null;
        	retval.declarationList =null;
        	retval.pointerType =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:939:3: ( '*' ( type_qualifier )* dec= abstract_declarator | ( '[' (c= constant_expression )? ']' )+ |)
            int alt35=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt35=1;
                }
                break;
            case 83:
                {
                alt35=2;
                }
                break;
            case EOF:
            case 39:
            case 45:
            case 55:
            case 130:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:941:2: '*' ( type_qualifier )* dec= abstract_declarator
                    {
                    match(input,40,FOLLOW_40_in_abstract_declarator1586); if (state.failed) return retval;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:941:6: ( type_qualifier )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==94||LA32_0==128) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:941:6: type_qualifier
                    	    {
                    	    pushFollow(FOLLOW_type_qualifier_in_abstract_declarator1588);
                    	    type_qualifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    pushFollow(FOLLOW_abstract_declarator_in_abstract_declarator1593);
                    dec=abstract_declarator();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    	 	retval.identifier =(dec!=null?dec.identifier:null);
                    	 	retval.arrayType =(dec!=null?dec.arrayType:null);
                    	 	retval.declarationList =(dec!=null?dec.declarationList:null);
                    	 	
                    	 	retval.pointerType =(dec!=null?dec.pointerType:null);
                    	 	
                    	 	if(retval.pointerType==null){
                    	 		retval.pointerType =new PointerType();
                    	 	}
                    	 	retval.pointerType.incrementPointer();
                    	 	
                    	 	
                    	 }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:961:3: ( '[' (c= constant_expression )? ']' )+
                    {
                    if ( state.backtracking==0 ) { retval.arrayType =new ArrayType(); }

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:962:4: ( '[' (c= constant_expression )? ']' )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==83) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:962:5: '[' (c= constant_expression )? ']'
                    	    {
                    	    match(input,83,FOLLOW_83_in_abstract_declarator1625); if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {dimension=null;}

                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:964:4: (c= constant_expression )?
                    	    int alt33=2;
                    	    int LA33_0 = input.LA(1);

                    	    if ( (LA33_0==CHARACTER_LITERAL||LA33_0==DECIMAL_LITERAL||LA33_0==FLOATING_POINT_LITERAL||LA33_0==HEX_LITERAL||LA33_0==IDENTIFIER||LA33_0==OCTAL_LITERAL||LA33_0==STRING_LITERAL||LA33_0==22||LA33_0==36||LA33_0==38||LA33_0==40||LA33_0==43||(LA33_0 >= 46 && LA33_0 <= 47)||LA33_0==67||LA33_0==83||LA33_0==115||LA33_0==118||LA33_0==135) ) {
                    	        alt33=1;
                    	    }
                    	    switch (alt33) {
                    	        case 1 :
                    	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:964:5: c= constant_expression
                    	            {
                    	            pushFollow(FOLLOW_constant_expression_in_abstract_declarator1639);
                    	            c=constant_expression();

                    	            state._fsp--;
                    	            if (state.failed) return retval;

                    	            if ( state.backtracking==0 ) {
                    	              		dimension=c;	
                    	              	}

                    	            }
                    	            break;

                    	    }


                    	    if ( state.backtracking==0 ) {retval.arrayType.addDimensionExpression(dimension);}

                    	    match(input,85,FOLLOW_85_in_abstract_declarator1653); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:969:5: 
                    {
                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "abstract_declarator"



    // $ANTLR start "abstract_declarator_suffix"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:971:1: abstract_declarator_suffix : ( '[' ( constant_expression )? ']' | '(' ( parameter_declaration_list )? ')' );
    public final void abstract_declarator_suffix() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:973:3: ( '[' ( constant_expression )? ']' | '(' ( parameter_declaration_list )? ')' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==83) ) {
                alt38=1;
            }
            else if ( (LA38_0==38) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }
            switch (alt38) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:973:5: '[' ( constant_expression )? ']'
                    {
                    match(input,83,FOLLOW_83_in_abstract_declarator_suffix1674); if (state.failed) return ;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:973:9: ( constant_expression )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==CHARACTER_LITERAL||LA36_0==DECIMAL_LITERAL||LA36_0==FLOATING_POINT_LITERAL||LA36_0==HEX_LITERAL||LA36_0==IDENTIFIER||LA36_0==OCTAL_LITERAL||LA36_0==STRING_LITERAL||LA36_0==22||LA36_0==36||LA36_0==38||LA36_0==40||LA36_0==43||(LA36_0 >= 46 && LA36_0 <= 47)||LA36_0==67||LA36_0==83||LA36_0==115||LA36_0==118||LA36_0==135) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:973:9: constant_expression
                            {
                            pushFollow(FOLLOW_constant_expression_in_abstract_declarator_suffix1676);
                            constant_expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,85,FOLLOW_85_in_abstract_declarator_suffix1679); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:974:5: '(' ( parameter_declaration_list )? ')'
                    {
                    match(input,38,FOLLOW_38_in_abstract_declarator_suffix1685); if (state.failed) return ;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:974:10: ( parameter_declaration_list )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==IDENTIFIER||LA37_0==81||LA37_0==89||(LA37_0 >= 93 && LA37_0 <= 94)||LA37_0==99||(LA37_0 >= 101 && LA37_0 <= 102)||LA37_0==105||(LA37_0 >= 107 && LA37_0 <= 108)||LA37_0==112||(LA37_0 >= 116 && LA37_0 <= 117)||LA37_0==119||LA37_0==124||(LA37_0 >= 126 && LA37_0 <= 128)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:974:10: parameter_declaration_list
                            {
                            pushFollow(FOLLOW_parameter_declaration_list_in_abstract_declarator_suffix1688);
                            parameter_declaration_list();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,39,FOLLOW_39_in_abstract_declarator_suffix1691); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "abstract_declarator_suffix"


    public static class selector_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "selector"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:976:1: selector : IDENTIFIER ;
    public final ObjectiveCParser.selector_return selector() throws RecognitionException {
        ObjectiveCParser.selector_return retval = new ObjectiveCParser.selector_return();
        retval.start = input.LT(1);


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:976:9: ( IDENTIFIER )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:977:1: IDENTIFIER
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selector1701); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "selector"



    // $ANTLR start "method_type"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:979:1: method_type returns [MethodType methodType] : '(' type_name ')' ;
    public final MethodType method_type() throws RecognitionException {
        MethodType methodType = null;


        MethodType type_name40 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:981:2: ( '(' type_name ')' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:982:2: '(' type_name ')'
            {
            match(input,38,FOLLOW_38_in_method_type1714); if (state.failed) return methodType;

            pushFollow(FOLLOW_type_name_in_method_type1719);
            type_name40=type_name();

            state._fsp--;
            if (state.failed) return methodType;

            if ( state.backtracking==0 ) {methodType =type_name40;}

            match(input,39,FOLLOW_39_in_method_type1724); if (state.failed) return methodType;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return methodType;
    }
    // $ANTLR end "method_type"



    // $ANTLR start "type_name"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:986:1: type_name returns [MethodType methodType] : sql= specifier_qualifier_list ad= abstract_declarator ;
    public final MethodType type_name() throws RecognitionException {
        MethodType methodType = null;


        ObjectiveCParser.specifier_qualifier_list_return sql =null;

        ObjectiveCParser.abstract_declarator_return ad =null;



        	methodType =new MethodType(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:992:2: (sql= specifier_qualifier_list ad= abstract_declarator )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:993:2: sql= specifier_qualifier_list ad= abstract_declarator
            {
            pushFollow(FOLLOW_specifier_qualifier_list_in_type_name1747);
            sql=specifier_qualifier_list();

            state._fsp--;
            if (state.failed) return methodType;

            if ( state.backtracking==0 ) {
            		methodType.setModifier((sql!=null?sql.modifier:null));
            		methodType.setSpecifier((sql!=null?sql.specifier:null));
            		methodType.setDataType((sql!=null?sql.dataType:null));

            	}

            pushFollow(FOLLOW_abstract_declarator_in_type_name1757);
            ad=abstract_declarator();

            state._fsp--;
            if (state.failed) return methodType;

            if ( state.backtracking==0 ) {
                	methodType.setArrayType((ad!=null?ad.arrayType:null));
                	methodType.setPointerType((ad!=null?ad.pointerType:null));
                }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return methodType;
    }
    // $ANTLR end "type_name"



    // $ANTLR start "struct_or_union_definition"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1008:1: struct_or_union_definition returns [ClassInterface struct] : ( 'typedef' )? ( 'struct' | 'union' ) id= IDENTIFIER '{' (sd= struct_declaration )+ '}' (id2= IDENTIFIER )? ';' ;
    public final ClassInterface struct_or_union_definition() throws RecognitionException {
        ClassInterface struct = null;


        Token id=null;
        Token id2=null;
        ListDeclaration sd =null;



        	struct =new ClassInterface(packageDef,IdentifierType.CLASS,currentLineNumber);
        	

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1017:3: ( ( 'typedef' )? ( 'struct' | 'union' ) id= IDENTIFIER '{' (sd= struct_declaration )+ '}' (id2= IDENTIFIER )? ';' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1018:3: ( 'typedef' )? ( 'struct' | 'union' ) id= IDENTIFIER '{' (sd= struct_declaration )+ '}' (id2= IDENTIFIER )? ';'
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1018:3: ( 'typedef' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==123) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1018:4: 'typedef'
                    {
                    match(input,123,FOLLOW_123_in_struct_or_union_definition1790); if (state.failed) return struct;

                    }
                    break;

            }


            if ( input.LA(1)==120||input.LA(1)==125 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_or_union_definition1809); if (state.failed) return struct;

            if ( state.backtracking==0 ) {struct.setClassName(new Identifier((id!=null?id.getText():null)));}

            match(input,130,FOLLOW_130_in_struct_or_union_definition1815); if (state.failed) return struct;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1022:3: (sd= struct_declaration )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==IDENTIFIER||LA40_0==81||LA40_0==90||(LA40_0 >= 93 && LA40_0 <= 94)||LA40_0==99||LA40_0==102||LA40_0==105||(LA40_0 >= 107 && LA40_0 <= 108)||(LA40_0 >= 116 && LA40_0 <= 117)||LA40_0==120||(LA40_0 >= 124 && LA40_0 <= 128)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1023:4: sd= struct_declaration
            	    {
            	    pushFollow(FOLLOW_struct_declaration_in_struct_or_union_definition1827);
            	    sd=struct_declaration();

            	    state._fsp--;
            	    if (state.failed) return struct;

            	    if ( state.backtracking==0 ) {
            	      		if(struct.getInstanceVariables()==null){
            	      			struct.setInstanceVariables(sd);
            	      		}else{
            	      			struct.addInstanceVariables(sd);
            	      		}
            	      	}

            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return struct;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);


            match(input,134,FOLLOW_134_in_struct_or_union_definition1838); if (state.failed) return struct;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1031:7: (id2= IDENTIFIER )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDENTIFIER) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1031:8: id2= IDENTIFIER
                    {
                    id2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_or_union_definition1843); if (state.failed) return struct;

                    if ( state.backtracking==0 ) {struct.setClassName(new Identifier((id2!=null?id2.getText():null)));}

                    }
                    break;

            }


            match(input,55,FOLLOW_55_in_struct_or_union_definition1848); if (state.failed) return struct;

            }

            if ( state.backtracking==0 ) {
            	struct.getInstanceVariables().setAllDeclarationsAccessType(AccessType.PUBLIC);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return struct;
    }
    // $ANTLR end "struct_or_union_definition"



    // $ANTLR start "struct_or_union_specifier"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1037:1: struct_or_union_specifier returns [Identifier identifier] : ( 'struct' | 'union' ) (id= IDENTIFIER ) ;
    public final Identifier struct_or_union_specifier() throws RecognitionException {
        Identifier identifier = null;


        Token id=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1039:3: ( ( 'struct' | 'union' ) (id= IDENTIFIER ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1040:3: ( 'struct' | 'union' ) (id= IDENTIFIER )
            {
            if ( input.LA(1)==120||input.LA(1)==125 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return identifier;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1041:3: (id= IDENTIFIER )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1041:5: id= IDENTIFIER
            {
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_or_union_specifier1893); if (state.failed) return identifier;

            if ( state.backtracking==0 ) {identifier =new Identifier((id!=null?id.getText():null));}

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return identifier;
    }
    // $ANTLR end "struct_or_union_specifier"



    // $ANTLR start "struct_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1043:1: struct_declaration returns [ListDeclaration declarationList] : sql= specifier_qualifier_list sdl= struct_declarator_list[specifierDetails] ';' ;
    public final ListDeclaration struct_declaration() throws RecognitionException {
        ListDeclaration declarationList = null;


        ObjectiveCParser.specifier_qualifier_list_return sql =null;

        ListDeclaration sdl =null;



        	Declaration specifierDetails=new Declaration(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1048:2: (sql= specifier_qualifier_list sdl= struct_declarator_list[specifierDetails] ';' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1048:4: sql= specifier_qualifier_list sdl= struct_declarator_list[specifierDetails] ';'
            {
            pushFollow(FOLLOW_specifier_qualifier_list_in_struct_declaration1920);
            sql=specifier_qualifier_list();

            state._fsp--;
            if (state.failed) return declarationList;

            if ( state.backtracking==0 ) {
            		specifierDetails.setModifier((sql!=null?sql.modifier:null));
            		specifierDetails.setSpecifier((sql!=null?sql.specifier:null));
            		specifierDetails.setDataType((sql!=null?sql.dataType:null));
            	}

            pushFollow(FOLLOW_struct_declarator_list_in_struct_declaration1929);
            sdl=struct_declarator_list(specifierDetails);

            state._fsp--;
            if (state.failed) return declarationList;

            if ( state.backtracking==0 ) {
            		declarationList =sdl;
            	}

            match(input,55,FOLLOW_55_in_struct_declaration1937); if (state.failed) return declarationList;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declarationList;
    }
    // $ANTLR end "struct_declaration"



    // $ANTLR start "struct_declarator_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1062:1: struct_declarator_list[Declaration specifierDetails] returns [ListDeclaration declarationList] : sd= struct_declarator ( ',' sdx= struct_declarator )* ;
    public final ListDeclaration struct_declarator_list(Declaration specifierDetails) throws RecognitionException {
        ListDeclaration declarationList = null;


        Declaration sd =null;

        Declaration sdx =null;



        	declarationList =new ListDeclaration(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1067:2: (sd= struct_declarator ( ',' sdx= struct_declarator )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1068:3: sd= struct_declarator ( ',' sdx= struct_declarator )*
            {
            pushFollow(FOLLOW_struct_declarator_in_struct_declarator_list1965);
            sd=struct_declarator();

            state._fsp--;
            if (state.failed) return declarationList;

            if ( state.backtracking==0 ) {
             		declarationList.add(mergeSpecifierDetailsWithDeclaration(specifierDetails,sd));
             	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1071:3: ( ',' sdx= struct_declarator )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==45) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1072:4: ',' sdx= struct_declarator
            	    {
            	    match(input,45,FOLLOW_45_in_struct_declarator_list1977); if (state.failed) return declarationList;

            	    pushFollow(FOLLOW_struct_declarator_in_struct_declarator_list1981);
            	    sdx=struct_declarator();

            	    state._fsp--;
            	    if (state.failed) return declarationList;

            	    if ( state.backtracking==0 ) {
            	     			declarationList.add(mergeSpecifierDetailsWithDeclaration(specifierDetails,sdx));
            	     		}

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declarationList;
    }
    // $ANTLR end "struct_declarator_list"



    // $ANTLR start "struct_declarator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1078:1: struct_declarator returns [Declaration declaration] : (dec= declarator | (dec= declarator )? ':' c= constant );
    public final Declaration struct_declarator() throws RecognitionException {
        Declaration declaration = null;


        ObjectiveCParser.declarator_return dec =null;

        ObjectiveCParser.constant_return c =null;



        	declaration =new Declaration(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1083:2: (dec= declarator | (dec= declarator )? ':' c= constant )
            int alt44=2;
            switch ( input.LA(1) ) {
            case 40:
                {
                int LA44_1 = input.LA(2);

                if ( (synpred75_ObjectiveC()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA44_2 = input.LA(2);

                if ( (synpred75_ObjectiveC()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return declaration;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;

                }
                }
                break;
            case 54:
                {
                alt44=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return declaration;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1084:3: dec= declarator
                    {
                    pushFollow(FOLLOW_declarator_in_struct_declarator2015);
                    dec=declarator();

                    state._fsp--;
                    if (state.failed) return declaration;

                    if ( state.backtracking==0 ) {
                    	 	declaration.setIdentifier((dec!=null?dec.identifier:null));
                    	 	declaration.setArrayDimensions((dec!=null?dec.arrayType:null));
                    	 	//TODO: IMP (dec!=null?dec.declarationList:null) not handled, see what it can be used for and handle it
                    	 }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1091:4: (dec= declarator )? ':' c= constant
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1091:4: (dec= declarator )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==IDENTIFIER||LA43_0==40) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1092:5: dec= declarator
                            {
                            pushFollow(FOLLOW_declarator_in_struct_declarator2039);
                            dec=declarator();

                            state._fsp--;
                            if (state.failed) return declaration;

                            if ( state.backtracking==0 ) {
                            	 			declaration.setIdentifier((dec!=null?dec.identifier:null));
                            	 			declaration.setArrayDimensions((dec!=null?dec.arrayType:null));
                            	 			//TODO: IMP (dec!=null?dec.declarationList:null) not handled, see what it can be used for and handle it
                            	 		}

                            }
                            break;

                    }


                    match(input,54,FOLLOW_54_in_struct_declarator2048); if (state.failed) return declaration;

                    pushFollow(FOLLOW_constant_in_struct_declarator2052);
                    c=constant();

                    state._fsp--;
                    if (state.failed) return declaration;

                    if ( state.backtracking==0 ) {
                    	 		PrimaryExpression val=new PrimaryExpression(declaration,currentLineNumber,(c!=null?input.toString(c.start,c.stop):null),RefType.CONSTANT);
                    	 		declaration.setInitializationExpression(val);
                    	 	}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declaration;
    }
    // $ANTLR end "struct_declarator"


    public static class specifier_qualifier_list_return extends ParserRuleReturnScope {
        public BasicModifier modifier;
        public Specifier specifier;
        public DataType dataType;
    };


    // $ANTLR start "specifier_qualifier_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1104:1: specifier_qualifier_list returns [BasicModifier modifier,Specifier specifier,DataType dataType] : ( (ts= type_specifier_ivar |tq= type_qualifier )+ |tsc= type_specifier_class (tq= type_qualifier )* );
    public final ObjectiveCParser.specifier_qualifier_list_return specifier_qualifier_list() throws RecognitionException {
        ObjectiveCParser.specifier_qualifier_list_return retval = new ObjectiveCParser.specifier_qualifier_list_return();
        retval.start = input.LT(1);


        ObjectiveCParser.type_specifier_ivar_return ts =null;

        int tq =0;

        Identifier tsc =null;


         
        //Setting parent to null as its parent rule can define itself who the parent is
        	retval.modifier =new BasicModifier(null);
        	retval.specifier =new Specifier(null);
        	retval.dataType =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1112:2: ( (ts= type_specifier_ivar |tq= type_qualifier )+ |tsc= type_specifier_class (tq= type_qualifier )* )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==81||LA47_0==90||(LA47_0 >= 93 && LA47_0 <= 94)||LA47_0==99||LA47_0==102||(LA47_0 >= 107 && LA47_0 <= 108)||(LA47_0 >= 116 && LA47_0 <= 117)||LA47_0==120||(LA47_0 >= 124 && LA47_0 <= 128)) ) {
                alt47=1;
            }
            else if ( (LA47_0==IDENTIFIER||LA47_0==105) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1113:3: (ts= type_specifier_ivar |tq= type_qualifier )+
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1113:3: (ts= type_specifier_ivar |tq= type_qualifier )+
                    int cnt45=0;
                    loop45:
                    do {
                        int alt45=3;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==81||LA45_0==90||LA45_0==93||LA45_0==99||LA45_0==102||(LA45_0 >= 107 && LA45_0 <= 108)||(LA45_0 >= 116 && LA45_0 <= 117)||LA45_0==120||(LA45_0 >= 124 && LA45_0 <= 127)) ) {
                            alt45=1;
                        }
                        else if ( (LA45_0==94||LA45_0==128) ) {
                            alt45=2;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1114:3: ts= type_specifier_ivar
                    	    {
                    	    pushFollow(FOLLOW_type_specifier_ivar_in_specifier_qualifier_list2087);
                    	    ts=type_specifier_ivar();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {
                    	    			
                    	    			if((ts!=null?ts.dataType:null)!=null){
                    	    				retval.dataType =(ts!=null?ts.dataType:null);
                    	    				
                    	    			}
                    	    			else{	
                    	    				retval.specifier.setSpecifier((ts!=null?ts.nativeSpecifier:null));
                    	    				
                    	    			}
                    	    		}

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1127:5: tq= type_qualifier
                    	    {
                    	    pushFollow(FOLLOW_type_qualifier_in_specifier_qualifier_list2104);
                    	    tq=type_qualifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {
                    	    			retval.modifier.setModifier(tq);
                    	    			
                    	    	 }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt45 >= 1 ) break loop45;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(45, input);
                                throw eee;
                        }
                        cnt45++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1137:4: tsc= type_specifier_class (tq= type_qualifier )*
                    {
                    pushFollow(FOLLOW_type_specifier_class_in_specifier_qualifier_list2136);
                    tsc=type_specifier_class();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new ClassType(tsc);}

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1137:72: (tq= type_qualifier )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==94||LA46_0==128) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1137:73: tq= type_qualifier
                    	    {
                    	    pushFollow(FOLLOW_type_qualifier_in_specifier_qualifier_list2142);
                    	    tq=type_qualifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {retval.modifier.setModifier(tq);}

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "specifier_qualifier_list"


    public static class type_specifier_ivar_return extends ParserRuleReturnScope {
        public DataType dataType;
        public Specifier.NativeSpecifier nativeSpecifier;
    };


    // $ANTLR start "type_specifier_ivar"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1141:1: type_specifier_ivar returns [DataType dataType,Specifier.NativeSpecifier nativeSpecifier] : ( 'void' | 'char' | 'short' | 'long' | 'int' | 'float' | 'double' | 'BOOL' | 'bool' | 'signed' | 'unsigned' | 'unichar' |ss= struct_or_union_specifier );
    public final ObjectiveCParser.type_specifier_ivar_return type_specifier_ivar() throws RecognitionException {
        ObjectiveCParser.type_specifier_ivar_return retval = new ObjectiveCParser.type_specifier_ivar_return();
        retval.start = input.LT(1);


        Identifier ss =null;



        	retval.dataType =null;
        	retval.nativeSpecifier =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1147:2: ( 'void' | 'char' | 'short' | 'long' | 'int' | 'float' | 'double' | 'BOOL' | 'bool' | 'signed' | 'unsigned' | 'unichar' |ss= struct_or_union_specifier )
            int alt48=13;
            switch ( input.LA(1) ) {
            case 127:
                {
                alt48=1;
                }
                break;
            case 93:
                {
                alt48=2;
                }
                break;
            case 116:
                {
                alt48=3;
                }
                break;
            case 108:
                {
                alt48=4;
                }
                break;
            case 107:
                {
                alt48=5;
                }
                break;
            case 102:
                {
                alt48=6;
                }
                break;
            case 99:
                {
                alt48=7;
                }
                break;
            case 81:
                {
                alt48=8;
                }
                break;
            case 90:
                {
                alt48=9;
                }
                break;
            case 117:
                {
                alt48=10;
                }
                break;
            case 126:
                {
                alt48=11;
                }
                break;
            case 124:
                {
                alt48=12;
                }
                break;
            case 120:
            case 125:
                {
                alt48=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1148:4: 'void'
                    {
                    match(input,127,FOLLOW_127_in_type_specifier_ivar2173); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.VOID);}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1149:4: 'char'
                    {
                    match(input,93,FOLLOW_93_in_type_specifier_ivar2180); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.CHAR);}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1150:4: 'short'
                    {
                    match(input,116,FOLLOW_116_in_type_specifier_ivar2188); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.SHORT;}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1151:4: 'long'
                    {
                    match(input,108,FOLLOW_108_in_type_specifier_ivar2194); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.LONG;}

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1152:4: 'int'
                    {
                    match(input,107,FOLLOW_107_in_type_specifier_ivar2202); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.INT);}

                    }
                    break;
                case 6 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1153:4: 'float'
                    {
                    match(input,102,FOLLOW_102_in_type_specifier_ivar2209); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.FLOAT);}

                    }
                    break;
                case 7 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1154:4: 'double'
                    {
                    match(input,99,FOLLOW_99_in_type_specifier_ivar2216); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.DOUBLE);}

                    }
                    break;
                case 8 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1155:4: 'BOOL'
                    {
                    match(input,81,FOLLOW_81_in_type_specifier_ivar2223); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.BOOLEAN);}

                    }
                    break;
                case 9 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1156:4: 'bool'
                    {
                    match(input,90,FOLLOW_90_in_type_specifier_ivar2230); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.BOOLEAN);}

                    }
                    break;
                case 10 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1157:4: 'signed'
                    {
                    match(input,117,FOLLOW_117_in_type_specifier_ivar2237); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.SIGNED;}

                    }
                    break;
                case 11 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1158:4: 'unsigned'
                    {
                    match(input,126,FOLLOW_126_in_type_specifier_ivar2244); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.UNSIGNED;}

                    }
                    break;
                case 12 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1159:4: 'unichar'
                    {
                    match(input,124,FOLLOW_124_in_type_specifier_ivar2251); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.UNICHAR);}

                    }
                    break;
                case 13 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1161:5: ss= struct_or_union_specifier
                    {
                    pushFollow(FOLLOW_struct_or_union_specifier_in_type_specifier_ivar2265);
                    ss=struct_or_union_specifier();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new ClassType(ss);}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_specifier_ivar"



    // $ANTLR start "type_specifier_class"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1165:1: type_specifier_class returns [Identifier identifier] : ( ( 'id' ( protocol_reference_list )? ) | ( class_name ( protocol_reference_list )? ) |id= IDENTIFIER );
    public final Identifier type_specifier_class() throws RecognitionException {
        Identifier identifier = null;


        Token id=null;
        ObjectiveCParser.class_name_return class_name41 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1166:32: ( ( 'id' ( protocol_reference_list )? ) | ( class_name ( protocol_reference_list )? ) |id= IDENTIFIER )
            int alt51=3;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==105) ) {
                alt51=1;
            }
            else if ( (LA51_0==IDENTIFIER) ) {
                int LA51_2 = input.LA(2);

                if ( (synpred96_ObjectiveC()) ) {
                    alt51=2;
                }
                else if ( (true) ) {
                    alt51=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return identifier;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return identifier;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }
            switch (alt51) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1167:3: ( 'id' ( protocol_reference_list )? )
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1167:3: ( 'id' ( protocol_reference_list )? )
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1167:4: 'id' ( protocol_reference_list )?
                    {
                    match(input,105,FOLLOW_105_in_type_specifier_class2289); if (state.failed) return identifier;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1167:9: ( protocol_reference_list )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==56) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1167:11: protocol_reference_list
                            {
                            pushFollow(FOLLOW_protocol_reference_list_in_type_specifier_class2293);
                            protocol_reference_list();

                            state._fsp--;
                            if (state.failed) return identifier;

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {identifier =new Identifier("id",IdentifierType.ID);}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:4: ( class_name ( protocol_reference_list )? )
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:4: ( class_name ( protocol_reference_list )? )
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:5: class_name ( protocol_reference_list )?
                    {
                    pushFollow(FOLLOW_class_name_in_type_specifier_class2306);
                    class_name41=class_name();

                    state._fsp--;
                    if (state.failed) return identifier;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:16: ( protocol_reference_list )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==56) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:18: protocol_reference_list
                            {
                            pushFollow(FOLLOW_protocol_reference_list_in_type_specifier_class2310);
                            protocol_reference_list();

                            state._fsp--;
                            if (state.failed) return identifier;

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {identifier =new Identifier((class_name41!=null?input.toString(class_name41.start,class_name41.stop):null),IdentifierType.CLASS);}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1169:6: id= IDENTIFIER
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type_specifier_class2325); if (state.failed) return identifier;

                    if ( state.backtracking==0 ) {identifier =new Identifier((id!=null?id.getText():null),IdentifierType.CLASS);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return identifier;
    }
    // $ANTLR end "type_specifier_class"



    // $ANTLR start "function_definition"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1173:1: function_definition returns [Function functionDefinition] : ds= declaration_specifiers declarator c= compound_statement ;
    public final Function function_definition() throws RecognitionException {
        CurrentFunction_stack.push(new CurrentFunction_scope());

        Function functionDefinition = null;


        ObjectiveCParser.declaration_specifiers_return ds =null;

        Statement.CompoundStatement c =null;

        ObjectiveCParser.declarator_return declarator42 =null;



        	functionDefinition =new Function(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1180:2: (ds= declaration_specifiers declarator c= compound_statement )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1181:2: ds= declaration_specifiers declarator c= compound_statement
            {
            pushFollow(FOLLOW_declaration_specifiers_in_function_definition2357);
            ds=declaration_specifiers();

            state._fsp--;
            if (state.failed) return functionDefinition;

            if ( state.backtracking==0 ) {
            		functionDefinition.setModifier((ds!=null?ds.modifier:null));
            		functionDefinition.setDataType((ds!=null?ds.dataType:null));
            		functionDefinition.setSpecifier((ds!=null?ds.specifier:null));
            	}

            pushFollow(FOLLOW_declarator_in_function_definition2361);
            declarator42=declarator();

            state._fsp--;
            if (state.failed) return functionDefinition;

            if ( state.backtracking==0 ) {
            		functionDefinition.setIdentifier((declarator42!=null?declarator42.identifier:null));
            		functionDefinition.setArrayType((declarator42!=null?declarator42.arrayType:null));
            		functionDefinition.setDeclarationList((declarator42!=null?declarator42.declarationList:null));
            		
            		
            		((CurrentFunction_scope)CurrentFunction_stack.peek()).function =functionDefinition;
            	}

            pushFollow(FOLLOW_compound_statement_in_function_definition2369);
            c=compound_statement();

            state._fsp--;
            if (state.failed) return functionDefinition;

            if ( state.backtracking==0 ) {
            		functionDefinition.setCompoundStatement(c);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            CurrentFunction_stack.pop();

        }
        return functionDefinition;
    }
    // $ANTLR end "function_definition"



    // $ANTLR start "declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1202:1: declaration returns [ListDeclaration declarations] : ds= declaration_specifiers (idl= init_declarator_list[tempDecl] )? ';' ;
    public final ListDeclaration declaration() throws RecognitionException {
        ListDeclaration declarations = null;


        ObjectiveCParser.declaration_specifiers_return ds =null;

        ListDeclaration idl =null;




        	Declaration tempDecl=new Declaration((Node)src,currentLineNumber);
        	

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1210:2: (ds= declaration_specifiers (idl= init_declarator_list[tempDecl] )? ';' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1211:2: ds= declaration_specifiers (idl= init_declarator_list[tempDecl] )? ';'
            {
            pushFollow(FOLLOW_declaration_specifiers_in_declaration2399);
            ds=declaration_specifiers();

            state._fsp--;
            if (state.failed) return declarations;

            if ( state.backtracking==0 ) {
            	
            		(ds!=null?ds.modifier:null).setParent((Statement)tempDecl);
            		(ds!=null?ds.specifier:null).setParent((Statement)tempDecl);
            		
            		tempDecl.setModifier((ds!=null?ds.modifier:null));
            		tempDecl.setSpecifier((ds!=null?ds.specifier:null));
            		tempDecl.setDataType((ds!=null?ds.dataType:null));
            		
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1222:2: (idl= init_declarator_list[tempDecl] )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==IDENTIFIER||LA52_0==40) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1223:3: idl= init_declarator_list[tempDecl]
                    {
                    pushFollow(FOLLOW_init_declarator_list_in_declaration2411);
                    idl=init_declarator_list(tempDecl);

                    state._fsp--;
                    if (state.failed) return declarations;

                    if ( state.backtracking==0 ) {
                    			declarations =idl;
                    		}

                    }
                    break;

            }


            match(input,55,FOLLOW_55_in_declaration2422); if (state.failed) return declarations;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declarations;
    }
    // $ANTLR end "declaration"


    public static class declaration_specifiers_return extends ParserRuleReturnScope {
        public BasicModifier modifier;
        public Specifier specifier;
        public DataType dataType;
    };


    // $ANTLR start "declaration_specifiers"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1230:1: declaration_specifiers returns [BasicModifier modifier,Specifier specifier,DataType dataType] : ( (s= storage_class_specifier |ts= type_specifier |tq= type_qualifier )+ |tsc= type_specifier_class (tq= type_qualifier )* );
    public final ObjectiveCParser.declaration_specifiers_return declaration_specifiers() throws RecognitionException {
        ObjectiveCParser.declaration_specifiers_return retval = new ObjectiveCParser.declaration_specifiers_return();
        retval.start = input.LT(1);


        int s =0;

        ObjectiveCParser.type_specifier_return ts =null;

        int tq =0;

        Identifier tsc =null;


         
        //Setting parent to null as its parent rule can define itself who the parent is
        	retval.modifier =new BasicModifier(null);
        	retval.specifier =new Specifier(null);
        	retval.dataType =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1239:2: ( (s= storage_class_specifier |ts= type_specifier |tq= type_qualifier )+ |tsc= type_specifier_class (tq= type_qualifier )* )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==81||LA55_0==89||(LA55_0 >= 93 && LA55_0 <= 94)||LA55_0==99||(LA55_0 >= 101 && LA55_0 <= 102)||(LA55_0 >= 107 && LA55_0 <= 108)||LA55_0==112||(LA55_0 >= 116 && LA55_0 <= 117)||LA55_0==119||LA55_0==124||(LA55_0 >= 126 && LA55_0 <= 128)) ) {
                alt55=1;
            }
            else if ( (LA55_0==IDENTIFIER||LA55_0==105) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1240:2: (s= storage_class_specifier |ts= type_specifier |tq= type_qualifier )+
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1240:2: (s= storage_class_specifier |ts= type_specifier |tq= type_qualifier )+
                    int cnt53=0;
                    loop53:
                    do {
                        int alt53=4;
                        switch ( input.LA(1) ) {
                        case 89:
                        case 101:
                        case 112:
                        case 119:
                            {
                            alt53=1;
                            }
                            break;
                        case 81:
                        case 93:
                        case 99:
                        case 102:
                        case 107:
                        case 108:
                        case 116:
                        case 117:
                        case 124:
                        case 126:
                        case 127:
                            {
                            alt53=2;
                            }
                            break;
                        case 94:
                        case 128:
                            {
                            alt53=3;
                            }
                            break;

                        }

                        switch (alt53) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1241:3: s= storage_class_specifier
                    	    {
                    	    pushFollow(FOLLOW_storage_class_specifier_in_declaration_specifiers2451);
                    	    s=storage_class_specifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {
                    	    			retval.modifier.setModifier(s);
                    	    			
                    	    		}

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1247:5: ts= type_specifier
                    	    {
                    	    pushFollow(FOLLOW_type_specifier_in_declaration_specifiers2467);
                    	    ts=type_specifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {	
                    	    			if((ts!=null?ts.dataType:null)!=null){
                    	    				retval.dataType =(ts!=null?ts.dataType:null); 
                    	    				
                    	    			}
                    	    			else{	
                    	    				retval.specifier.setSpecifier((ts!=null?ts.nativeSpecifier:null));
                    	    			
                    	    			}
                    	    		}

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1259:5: tq= type_qualifier
                    	    {
                    	    pushFollow(FOLLOW_type_qualifier_in_declaration_specifiers2482);
                    	    tq=type_qualifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {
                    	    			retval.modifier.setModifier(tq);

                    	    		}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt53 >= 1 ) break loop53;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(53, input);
                                throw eee;
                        }
                        cnt53++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1266:3: tsc= type_specifier_class (tq= type_qualifier )*
                    {
                    pushFollow(FOLLOW_type_specifier_class_in_declaration_specifiers2499);
                    tsc=type_specifier_class();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new ClassType(tsc);}

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1266:71: (tq= type_qualifier )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==94||LA54_0==128) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1266:72: tq= type_qualifier
                    	    {
                    	    pushFollow(FOLLOW_type_qualifier_in_declaration_specifiers2505);
                    	    tq=type_qualifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {retval.modifier.setModifier(tq);}

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declaration_specifiers"



    // $ANTLR start "init_declarator_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1270:1: init_declarator_list[Declaration tempDecl] returns [ListDeclaration declarationList] : id1= init_declarator ( ',' idx= init_declarator )* ;
    public final ListDeclaration init_declarator_list(Declaration tempDecl) throws RecognitionException {
        ListDeclaration declarationList = null;


        ObjectiveCParser.init_declarator_return id1 =null;

        ObjectiveCParser.init_declarator_return idx =null;



        	declarationList =new ListDeclaration(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1275:2: (id1= init_declarator ( ',' idx= init_declarator )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1275:3: id1= init_declarator ( ',' idx= init_declarator )*
            {
            pushFollow(FOLLOW_init_declarator_in_init_declarator_list2533);
            id1=init_declarator();

            state._fsp--;
            if (state.failed) return declarationList;

            if ( state.backtracking==0 ) {
            		declarationList.add(mergeAndCreateDeclaration(tempDecl,(id1!=null?id1.identifier:null),(id1!=null?id1.arrayType:null),(id1!=null?id1.initializations:null),(id1!=null?id1.pointerType:null)));

            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1280:2: ( ',' idx= init_declarator )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==45) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1281:3: ',' idx= init_declarator
            	    {
            	    match(input,45,FOLLOW_45_in_init_declarator_list2544); if (state.failed) return declarationList;

            	    pushFollow(FOLLOW_init_declarator_in_init_declarator_list2548);
            	    idx=init_declarator();

            	    state._fsp--;
            	    if (state.failed) return declarationList;

            	    if ( state.backtracking==0 ) {
            	    			declarationList.add(mergeAndCreateDeclaration(tempDecl,(idx!=null?idx.identifier:null),(idx!=null?idx.arrayType:null),(idx!=null?idx.initializations:null),(idx!=null?idx.pointerType:null)));
            	    		}

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return declarationList;
    }
    // $ANTLR end "init_declarator_list"


    public static class init_declarator_return extends ParserRuleReturnScope {
        public Identifier identifier;
        public ArrayType arrayType;
        public Expression initializations;
        public PointerType pointerType;
    };


    // $ANTLR start "init_declarator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1290:1: init_declarator returns [Identifier identifier,ArrayType arrayType, Expression initializations,PointerType pointerType ] : d= declarator ( '=' exp1= initializer )? ;
    public final ObjectiveCParser.init_declarator_return init_declarator() throws RecognitionException {
        ObjectiveCParser.init_declarator_return retval = new ObjectiveCParser.init_declarator_return();
        retval.start = input.LT(1);


        ObjectiveCParser.declarator_return d =null;

        ListExpression exp1 =null;



        retval.initializations =null;
        ListExpression listExpression=null;
        retval.pointerType =null;
        //ListExpression listExpression=new ListExpression(null,-1);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1303:3: (d= declarator ( '=' exp1= initializer )? )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1303:3: d= declarator ( '=' exp1= initializer )?
            {
            pushFollow(FOLLOW_declarator_in_init_declarator2591);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {
            	 	retval.identifier =(d!=null?d.identifier:null);
            	 	retval.arrayType =(d!=null?d.arrayType:null);
            	 	retval.pointerType =(d!=null?d.pointerType:null);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1309:2: ( '=' exp1= initializer )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==60) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1309:3: '=' exp1= initializer
                    {
                    match(input,60,FOLLOW_60_in_init_declarator2599); if (state.failed) return retval;

                    pushFollow(FOLLOW_initializer_in_init_declarator2607);
                    exp1=initializer();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    		listExpression=exp1;
                    	}

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {
            retval.initializations =(Expression)listExpression;
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "init_declarator"



    // $ANTLR start "initializer"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1318:1: initializer returns [ListExpression expression ] : (exp1= assignment_expression | '{' exp2= initializer ( ',' exp3= initializer )* '}' );
    public final ListExpression initializer() throws RecognitionException {
        ListExpression expression = null;


        AssignmentExpression exp1 =null;

        ListExpression exp2 =null;

        ListExpression exp3 =null;



        expression =null;
        ListExpression listExpression=new ListExpression(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1328:5: (exp1= assignment_expression | '{' exp2= initializer ( ',' exp3= initializer )* '}' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==CHARACTER_LITERAL||LA59_0==DECIMAL_LITERAL||LA59_0==FLOATING_POINT_LITERAL||LA59_0==HEX_LITERAL||LA59_0==IDENTIFIER||LA59_0==OCTAL_LITERAL||LA59_0==STRING_LITERAL||LA59_0==22||LA59_0==36||LA59_0==38||LA59_0==40||LA59_0==43||(LA59_0 >= 46 && LA59_0 <= 47)||LA59_0==67||LA59_0==83||LA59_0==115||LA59_0==118||LA59_0==135) ) {
                alt59=1;
            }
            else if ( (LA59_0==130) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1328:5: exp1= assignment_expression
                    {
                    pushFollow(FOLLOW_assignment_expression_in_initializer2643);
                    exp1=assignment_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {
                    			listExpression.addExpression(exp1);
                    		}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1332:4: '{' exp2= initializer ( ',' exp3= initializer )* '}'
                    {
                    match(input,130,FOLLOW_130_in_initializer2650); if (state.failed) return expression;

                    pushFollow(FOLLOW_initializer_in_initializer2654);
                    exp2=initializer();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {
                    			listExpression.addExpression(exp2);

                    		
                    		}

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1338:3: ( ',' exp3= initializer )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==45) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1338:4: ',' exp3= initializer
                    	    {
                    	    match(input,45,FOLLOW_45_in_initializer2663); if (state.failed) return expression;

                    	    pushFollow(FOLLOW_initializer_in_initializer2667);
                    	    exp3=initializer();

                    	    state._fsp--;
                    	    if (state.failed) return expression;

                    	    if ( state.backtracking==0 ) {
                    	    			listExpression.addExpression(exp3);
                    	    			}

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    match(input,134,FOLLOW_134_in_initializer2681); if (state.failed) return expression;

                    }
                    break;

            }
            if ( state.backtracking==0 ) {
            expression =listExpression; //At the end of rule returning the list expression
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "initializer"


    public static class declarator_return extends ParserRuleReturnScope {
        public Identifier identifier;
        public ArrayType arrayType;
        public ListDeclaration declarationList;
        public PointerType pointerType;
    };


    // $ANTLR start "declarator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1346:1: declarator returns [Identifier identifier,ArrayType arrayType,ListDeclaration declarationList,PointerType pointerType] : ( '*' ( type_qualifier )* dec= declarator |d= direct_declarator );
    public final ObjectiveCParser.declarator_return declarator() throws RecognitionException {
        ObjectiveCParser.declarator_return retval = new ObjectiveCParser.declarator_return();
        retval.start = input.LT(1);


        ObjectiveCParser.declarator_return dec =null;

        ObjectiveCParser.direct_declarator_return d =null;



        	retval.identifier =null;
        	retval.arrayType =null;
        	retval.declarationList =null;
        	retval.pointerType =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1354:2: ( '*' ( type_qualifier )* dec= declarator |d= direct_declarator )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==40) ) {
                alt61=1;
            }
            else if ( (LA61_0==IDENTIFIER) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1355:3: '*' ( type_qualifier )* dec= declarator
                    {
                    match(input,40,FOLLOW_40_in_declarator2709); if (state.failed) return retval;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1355:7: ( type_qualifier )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==94||LA60_0==128) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1355:7: type_qualifier
                    	    {
                    	    pushFollow(FOLLOW_type_qualifier_in_declarator2711);
                    	    type_qualifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);


                    pushFollow(FOLLOW_declarator_in_declarator2716);
                    dec=declarator();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    	 	retval.identifier =(dec!=null?dec.identifier:null);
                    	 	retval.arrayType =(dec!=null?dec.arrayType:null);
                    	 	retval.declarationList =(dec!=null?dec.declarationList:null);
                    	 	
                    	 	retval.pointerType =(dec!=null?dec.pointerType:null);
                    	 	
                    	 	if(retval.pointerType==null){
                    	 		retval.pointerType =new PointerType();
                    	 	}
                    	 	retval.pointerType.incrementPointer();
                    	 	
                    	 	
                    	 }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1370:3: d= direct_declarator
                    {
                    pushFollow(FOLLOW_direct_declarator_in_declarator2727);
                    d=direct_declarator();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    	 	retval.identifier =(d!=null?d.identifier:null);
                    	 	retval.arrayType =(d!=null?d.arrayType:null);
                    	 	retval.declarationList =(d!=null?d.declarationList:null);
                    	 }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declarator"


    public static class direct_declarator_return extends ParserRuleReturnScope {
        public Identifier identifier;
        public ArrayType arrayType;
        public ListDeclaration declarationList;
    };


    // $ANTLR start "direct_declarator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1378:1: direct_declarator returns [Identifier identifier,ArrayType arrayType,ListDeclaration declarationList] : id= identifier (ds= declarator_suffix )* ;
    public final ObjectiveCParser.direct_declarator_return direct_declarator() throws RecognitionException {
        ObjectiveCParser.direct_declarator_return retval = new ObjectiveCParser.direct_declarator_return();
        retval.start = input.LT(1);


        ObjectiveCParser.identifier_return id =null;

        ObjectiveCParser.declarator_suffix_return ds =null;



        	retval.identifier =null;
        	retval.arrayType =null;
        	retval.declarationList =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1387:2: (id= identifier (ds= declarator_suffix )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1388:4: id= identifier (ds= declarator_suffix )*
            {
            pushFollow(FOLLOW_identifier_in_direct_declarator2761);
            id=identifier();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {
            	  	retval.identifier =new Identifier((id!=null?input.toString(id.start,id.stop):null),IdentifierType.DECLARATION);
            	  }

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1392:4: (ds= declarator_suffix )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==38||LA62_0==83) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1393:5: ds= declarator_suffix
            	    {
            	    pushFollow(FOLLOW_declarator_suffix_in_direct_declarator2780);
            	    ds=declarator_suffix();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {
            	    	  		if((ds!=null?ds.declarationList:null)!=null)
            	    	  			retval.declarationList =(ds!=null?ds.declarationList:null);
            	    	  		if(retval.arrayType==null)
            	    	  			retval.arrayType =new ArrayType();
            	    	  		
            	    	  		if((ds!=null?ds.dimension:0)==-1)
            	    	  			retval.arrayType.addDimension();
            	    	  		else
            	    	  			retval.arrayType.addDimension((ds!=null?ds.dimension:0));
            	    	  	}

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "direct_declarator"


    public static class declarator_suffix_return extends ParserRuleReturnScope {
        public int dimension;
        public ListDeclaration declarationList;
    };


    // $ANTLR start "declarator_suffix"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1412:1: declarator_suffix returns [int dimension,ListDeclaration declarationList] : ( '[' (c= constant )? ']' | '(' ( parameter_list )? ')' );
    public final ObjectiveCParser.declarator_suffix_return declarator_suffix() throws RecognitionException {
        ObjectiveCParser.declarator_suffix_return retval = new ObjectiveCParser.declarator_suffix_return();
        retval.start = input.LT(1);


        ObjectiveCParser.constant_return c =null;

        ListDeclaration parameter_list43 =null;



        	retval.dimension =-1;
        	retval.declarationList =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1418:2: ( '[' (c= constant )? ']' | '(' ( parameter_list )? ')' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==83) ) {
                alt65=1;
            }
            else if ( (LA65_0==38) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1419:2: '[' (c= constant )? ']'
                    {
                    match(input,83,FOLLOW_83_in_declarator_suffix2825); if (state.failed) return retval;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1420:3: (c= constant )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==CHARACTER_LITERAL||LA63_0==DECIMAL_LITERAL||LA63_0==FLOATING_POINT_LITERAL||LA63_0==HEX_LITERAL||LA63_0==OCTAL_LITERAL) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1421:4: c= constant
                            {
                            pushFollow(FOLLOW_constant_in_declarator_suffix2837);
                            c=constant();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) {
                            				retval.dimension =Integer.parseInt((c!=null?input.toString(c.start,c.stop):null));
                            			}

                            }
                            break;

                    }


                    match(input,85,FOLLOW_85_in_declarator_suffix2851); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1431:2: '(' ( parameter_list )? ')'
                    {
                    match(input,38,FOLLOW_38_in_declarator_suffix2870); if (state.failed) return retval;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1432:3: ( parameter_list )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==IDENTIFIER||LA64_0==81||LA64_0==89||(LA64_0 >= 93 && LA64_0 <= 94)||LA64_0==99||(LA64_0 >= 101 && LA64_0 <= 102)||LA64_0==105||(LA64_0 >= 107 && LA64_0 <= 108)||LA64_0==112||(LA64_0 >= 116 && LA64_0 <= 117)||LA64_0==119||LA64_0==124||(LA64_0 >= 126 && LA64_0 <= 128)) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1433:4: parameter_list
                            {
                            pushFollow(FOLLOW_parameter_list_in_declarator_suffix2880);
                            parameter_list43=parameter_list();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) {retval.declarationList =parameter_list43;}

                            }
                            break;

                    }


                    match(input,39,FOLLOW_39_in_declarator_suffix2894); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declarator_suffix"


    public static class type_specifier_return extends ParserRuleReturnScope {
        public Specifier.NativeSpecifier nativeSpecifier;
        public DataType dataType;
    };


    // $ANTLR start "type_specifier"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1442:1: type_specifier returns [Specifier.NativeSpecifier nativeSpecifier,DataType dataType] : ( 'void' | 'char' | 'short' | 'long' | 'int' | 'float' | 'double' | 'BOOL' | 'signed' | 'unsigned' | 'unichar' );
    public final ObjectiveCParser.type_specifier_return type_specifier() throws RecognitionException {
        ObjectiveCParser.type_specifier_return retval = new ObjectiveCParser.type_specifier_return();
        retval.start = input.LT(1);



        	retval.nativeSpecifier =null;
        	retval.dataType =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1448:2: ( 'void' | 'char' | 'short' | 'long' | 'int' | 'float' | 'double' | 'BOOL' | 'signed' | 'unsigned' | 'unichar' )
            int alt66=11;
            switch ( input.LA(1) ) {
            case 127:
                {
                alt66=1;
                }
                break;
            case 93:
                {
                alt66=2;
                }
                break;
            case 116:
                {
                alt66=3;
                }
                break;
            case 108:
                {
                alt66=4;
                }
                break;
            case 107:
                {
                alt66=5;
                }
                break;
            case 102:
                {
                alt66=6;
                }
                break;
            case 99:
                {
                alt66=7;
                }
                break;
            case 81:
                {
                alt66=8;
                }
                break;
            case 117:
                {
                alt66=9;
                }
                break;
            case 126:
                {
                alt66=10;
                }
                break;
            case 124:
                {
                alt66=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }

            switch (alt66) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1449:4: 'void'
                    {
                    match(input,127,FOLLOW_127_in_type_specifier2926); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.VOID);}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1450:4: 'char'
                    {
                    match(input,93,FOLLOW_93_in_type_specifier2933); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.CHAR);}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1451:4: 'short'
                    {
                    match(input,116,FOLLOW_116_in_type_specifier2941); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.SHORT;}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1452:4: 'long'
                    {
                    match(input,108,FOLLOW_108_in_type_specifier2947); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.LONG;}

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1453:4: 'int'
                    {
                    match(input,107,FOLLOW_107_in_type_specifier2955); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.INT);}

                    }
                    break;
                case 6 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1454:4: 'float'
                    {
                    match(input,102,FOLLOW_102_in_type_specifier2962); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.FLOAT);}

                    }
                    break;
                case 7 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1455:4: 'double'
                    {
                    match(input,99,FOLLOW_99_in_type_specifier2969); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.DOUBLE);}

                    }
                    break;
                case 8 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1456:4: 'BOOL'
                    {
                    match(input,81,FOLLOW_81_in_type_specifier2976); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.BOOLEAN);}

                    }
                    break;
                case 9 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1457:4: 'signed'
                    {
                    match(input,117,FOLLOW_117_in_type_specifier2983); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.SIGNED;}

                    }
                    break;
                case 10 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1458:4: 'unsigned'
                    {
                    match(input,126,FOLLOW_126_in_type_specifier2990); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.nativeSpecifier =Specifier.NativeSpecifier.UNSIGNED;}

                    }
                    break;
                case 11 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1459:4: 'unichar'
                    {
                    match(input,124,FOLLOW_124_in_type_specifier2997); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.dataType =new BasicDataType(DataType.BasicDataType.NativeType.UNICHAR);}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_specifier"



    // $ANTLR start "type_qualifier"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1463:1: type_qualifier returns [int modifierType] : ( 'const' | 'volatile' );
    public final int type_qualifier() throws RecognitionException {
        int modifierType = 0;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1465:2: ( 'const' | 'volatile' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==94) ) {
                alt67=1;
            }
            else if ( (LA67_0==128) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return modifierType;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }
            switch (alt67) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1466:4: 'const'
                    {
                    match(input,94,FOLLOW_94_in_type_qualifier3024); if (state.failed) return modifierType;

                    if ( state.backtracking==0 ) {modifierType =BasicModifier.CONST;}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1467:4: 'volatile'
                    {
                    match(input,128,FOLLOW_128_in_type_qualifier3032); if (state.failed) return modifierType;

                    if ( state.backtracking==0 ) {modifierType =BasicModifier.VOLATILE;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return modifierType;
    }
    // $ANTLR end "type_qualifier"



    // $ANTLR start "storage_class_specifier"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1470:1: storage_class_specifier returns [int modifierType] : ( 'auto' | 'register' | 'static' | 'extern' );
    public final int storage_class_specifier() throws RecognitionException {
        int modifierType = 0;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1473:2: ( 'auto' | 'register' | 'static' | 'extern' )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt68=1;
                }
                break;
            case 112:
                {
                alt68=2;
                }
                break;
            case 119:
                {
                alt68=3;
                }
                break;
            case 101:
                {
                alt68=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return modifierType;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }

            switch (alt68) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1474:4: 'auto'
                    {
                    match(input,89,FOLLOW_89_in_storage_class_specifier3056); if (state.failed) return modifierType;

                    if ( state.backtracking==0 ) {modifierType =BasicModifier.AUTO;}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1475:4: 'register'
                    {
                    match(input,112,FOLLOW_112_in_storage_class_specifier3064); if (state.failed) return modifierType;

                    if ( state.backtracking==0 ) {modifierType =BasicModifier.REGISTER;}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1476:4: 'static'
                    {
                    match(input,119,FOLLOW_119_in_storage_class_specifier3072); if (state.failed) return modifierType;

                    if ( state.backtracking==0 ) {modifierType =BasicModifier.STATIC;}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1477:4: 'extern'
                    {
                    match(input,101,FOLLOW_101_in_storage_class_specifier3080); if (state.failed) return modifierType;

                    if ( state.backtracking==0 ) {modifierType =BasicModifier.EXTERN;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return modifierType;
    }
    // $ANTLR end "storage_class_specifier"



    // $ANTLR start "statement"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1482:1: statement returns [Statement statement] : (sel_stmt= selection_statement |decl= declaration |exp= expression ';' |cmp_stmt= compound_statement |itr_stmt= iteration_statement |label_stmt= labeled_statement |jmp_stmt= jump_statement | ';' );
    public final Statement statement() throws RecognitionException {
        Statement statement = null;


        Statement sel_stmt =null;

        ListDeclaration decl =null;

        Expression exp =null;

        Statement.CompoundStatement cmp_stmt =null;

        Statement itr_stmt =null;

        Statement label_stmt =null;

        Statement jmp_stmt =null;



        statement =null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1488:4: (sel_stmt= selection_statement |decl= declaration |exp= expression ';' |cmp_stmt= compound_statement |itr_stmt= iteration_statement |label_stmt= labeled_statement |jmp_stmt= jump_statement | ';' )
            int alt69=8;
            switch ( input.LA(1) ) {
            case 106:
            case 122:
                {
                alt69=1;
                }
                break;
            case 81:
            case 89:
            case 93:
            case 94:
            case 99:
            case 101:
            case 102:
            case 105:
            case 107:
            case 108:
            case 112:
            case 116:
            case 117:
            case 119:
            case 124:
            case 126:
            case 127:
            case 128:
                {
                alt69=2;
                }
                break;
            case IDENTIFIER:
                {
                int LA69_21 = input.LA(2);

                if ( (synpred128_ObjectiveC()) ) {
                    alt69=2;
                }
                else if ( (synpred129_ObjectiveC()) ) {
                    alt69=3;
                }
                else if ( (synpred132_ObjectiveC()) ) {
                    alt69=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return statement;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 21, input);

                    throw nvae;

                }
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
            case 22:
            case 36:
            case 38:
            case 40:
            case 43:
            case 46:
            case 47:
            case 67:
            case 83:
            case 115:
            case 118:
            case 135:
                {
                alt69=3;
                }
                break;
            case 130:
                {
                alt69=4;
                }
                break;
            case 98:
            case 103:
            case 129:
                {
                alt69=5;
                }
                break;
            case 92:
            case 97:
                {
                alt69=6;
                }
                break;
            case 91:
            case 95:
            case 104:
            case 114:
                {
                alt69=7;
                }
                break;
            case 55:
                {
                alt69=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return statement;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }

            switch (alt69) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1489:4: sel_stmt= selection_statement
                    {
                    pushFollow(FOLLOW_selection_statement_in_statement3113);
                    sel_stmt=selection_statement();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {
                         statement =sel_stmt;
                         }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1493:7: decl= declaration
                    {
                    pushFollow(FOLLOW_declaration_in_statement3130);
                    decl=declaration();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {
                        	statement = decl; 
                        	statement.setParent(((CurrentFunction_scope)CurrentFunction_stack.peek()).function); 
                        	((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable.put(decl);
                        }

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1498:7: exp= expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_statement3142);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return statement;

                    match(input,55,FOLLOW_55_in_statement3144); if (state.failed) return statement;

                    if ( state.backtracking==0 ) { statement =(Statement)exp;statement.setParent(((CurrentFunction_scope)CurrentFunction_stack.peek()).function); }

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1499:7: cmp_stmt= compound_statement
                    {
                    pushFollow(FOLLOW_compound_statement_in_statement3155);
                    cmp_stmt=compound_statement();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) { statement =cmp_stmt; statement.setParent(((CurrentFunction_scope)CurrentFunction_stack.peek()).function);}

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1500:7: itr_stmt= iteration_statement
                    {
                    pushFollow(FOLLOW_iteration_statement_in_statement3166);
                    itr_stmt=iteration_statement();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {statement =itr_stmt; statement.setParent(((CurrentFunction_scope)CurrentFunction_stack.peek()).function);}

                    }
                    break;
                case 6 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1501:7: label_stmt= labeled_statement
                    {
                    pushFollow(FOLLOW_labeled_statement_in_statement3179);
                    label_stmt=labeled_statement();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) { statement = label_stmt; statement.setParent(((CurrentFunction_scope)CurrentFunction_stack.peek()).function);}

                    }
                    break;
                case 7 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1502:7: jmp_stmt= jump_statement
                    {
                    pushFollow(FOLLOW_jump_statement_in_statement3191);
                    jmp_stmt=jump_statement();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) { statement = jmp_stmt; statement.setParent(((CurrentFunction_scope)CurrentFunction_stack.peek()).function);}

                    }
                    break;
                case 8 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1503:7: ';'
                    {
                    match(input,55,FOLLOW_55_in_statement3202); if (state.failed) return statement;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "statement"



    // $ANTLR start "jump_statement"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1506:1: jump_statement returns [Statement statement] : ( 'goto' identifier ';' | 'continue' ';' | 'break' ';' | 'return' ( expression )? ';' );
    public final Statement jump_statement() throws RecognitionException {
        Statement statement = null;


        Expression expression44 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1508:3: ( 'goto' identifier ';' | 'continue' ';' | 'break' ';' | 'return' ( expression )? ';' )
            int alt71=4;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt71=1;
                }
                break;
            case 95:
                {
                alt71=2;
                }
                break;
            case 91:
                {
                alt71=3;
                }
                break;
            case 114:
                {
                alt71=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return statement;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }

            switch (alt71) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1508:5: 'goto' identifier ';'
                    {
                    match(input,104,FOLLOW_104_in_jump_statement3221); if (state.failed) return statement;

                    pushFollow(FOLLOW_identifier_in_jump_statement3223);
                    identifier();

                    state._fsp--;
                    if (state.failed) return statement;

                    match(input,55,FOLLOW_55_in_jump_statement3225); if (state.failed) return statement;

                    if ( state.backtracking==0 ) {statement =new JumpStatement(null,currentLineNumber,JumpType.GOTO);}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1509:5: 'continue' ';'
                    {
                    match(input,95,FOLLOW_95_in_jump_statement3232); if (state.failed) return statement;

                    match(input,55,FOLLOW_55_in_jump_statement3234); if (state.failed) return statement;

                    if ( state.backtracking==0 ) {statement =new JumpStatement(null,currentLineNumber,JumpType.CONTINUE);}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1510:5: 'break' ';'
                    {
                    match(input,91,FOLLOW_91_in_jump_statement3242); if (state.failed) return statement;

                    match(input,55,FOLLOW_55_in_jump_statement3244); if (state.failed) return statement;

                    if ( state.backtracking==0 ) {statement =new JumpStatement(null,currentLineNumber,JumpType.BREAK);}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1511:5: 'return' ( expression )? ';'
                    {
                    match(input,114,FOLLOW_114_in_jump_statement3252); if (state.failed) return statement;

                    if ( state.backtracking==0 ) { 
                      		statement =new JumpStatement(null,currentLineNumber,JumpType.RETURN);
                      		((JumpStatement)statement).setCastingTypeInReturn(((Function)((CurrentFunction_scope)CurrentFunction_stack.peek()).function).getDataType());
                      }

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1516:4: ( expression )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==CHARACTER_LITERAL||LA70_0==DECIMAL_LITERAL||LA70_0==FLOATING_POINT_LITERAL||LA70_0==HEX_LITERAL||LA70_0==IDENTIFIER||LA70_0==OCTAL_LITERAL||LA70_0==STRING_LITERAL||LA70_0==22||LA70_0==36||LA70_0==38||LA70_0==40||LA70_0==43||(LA70_0 >= 46 && LA70_0 <= 47)||LA70_0==67||LA70_0==83||LA70_0==115||LA70_0==118||LA70_0==135) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1517:5: expression
                            {
                            pushFollow(FOLLOW_expression_in_jump_statement3269);
                            expression44=expression();

                            state._fsp--;
                            if (state.failed) return statement;

                            if ( state.backtracking==0 ) {((JumpStatement)statement).setExpression(expression44);}

                            }
                            break;

                    }


                    match(input,55,FOLLOW_55_in_jump_statement3279); if (state.failed) return statement;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "jump_statement"



    // $ANTLR start "labeled_statement"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1521:1: labeled_statement returns [Statement Stmt] : (v= identifier ':' s= statement | 'case' ce= constant_expression ':' s= statement | 'default' ':' s= statement );
    public final Statement labeled_statement() throws RecognitionException {
        Statement Stmt = null;


        ObjectiveCParser.identifier_return v =null;

        Statement s =null;

        Expression ce =null;




           Statement.LabelStatement lStmt = null;
           Statement.CaseDefaultStatement cStmt = null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1529:3: (v= identifier ':' s= statement | 'case' ce= constant_expression ':' s= statement | 'default' ':' s= statement )
            int alt72=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt72=1;
                }
                break;
            case 92:
                {
                alt72=2;
                }
                break;
            case 97:
                {
                alt72=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return Stmt;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }

            switch (alt72) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1529:6: v= identifier ':' s= statement
                    {
                    pushFollow(FOLLOW_identifier_in_labeled_statement3308);
                    v=identifier();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { lStmt = new Statement.LabelStatement( null, - 1 );  lStmt.setIdentifier( (v!=null?v.identifier:null) ); }

                    match(input,54,FOLLOW_54_in_labeled_statement3317); if (state.failed) return Stmt;

                    pushFollow(FOLLOW_statement_in_labeled_statement3336);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { lStmt.setStatement( s ); Stmt = ( Statement ) lStmt; }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1533:5: 'case' ce= constant_expression ':' s= statement
                    {
                    match(input,92,FOLLOW_92_in_labeled_statement3350); if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { cStmt = new Statement.CaseDefaultStatement( null, - 1); }

                    pushFollow(FOLLOW_constant_expression_in_labeled_statement3363);
                    ce=constant_expression();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { cStmt.setConstExpression( ce ); }

                    match(input,54,FOLLOW_54_in_labeled_statement3373); if (state.failed) return Stmt;

                    pushFollow(FOLLOW_statement_in_labeled_statement3384);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { cStmt.setStatement( s ); Stmt = ( Statement ) cStmt; }

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1538:5: 'default' ':' s= statement
                    {
                    match(input,97,FOLLOW_97_in_labeled_statement3398); if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) {cStmt = new Statement.CaseDefaultStatement( null, - 1 ); }

                    match(input,54,FOLLOW_54_in_labeled_statement3406); if (state.failed) return Stmt;

                    pushFollow(FOLLOW_statement_in_labeled_statement3417);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { cStmt.setStatement( s ); Stmt = ( Statement ) cStmt; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return Stmt;
    }
    // $ANTLR end "labeled_statement"



    // $ANTLR start "selection_statement"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1544:1: selection_statement returns [Statement statement] : ( 'if' '(' exp= expression ')' stmtIf= statement ( 'else' stmtElse= statement )? | 'switch' '(' exp= expression ')' switch_stmt= statement );
    public final Statement selection_statement() throws RecognitionException {
        Statement statement = null;


        Expression exp =null;

        Statement stmtIf =null;

        Statement stmtElse =null;

        Statement switch_stmt =null;



        statement =null;
        Statement.If statement_i=null;
        Statement.Switch statement_s=null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1557:3: ( 'if' '(' exp= expression ')' stmtIf= statement ( 'else' stmtElse= statement )? | 'switch' '(' exp= expression ')' switch_stmt= statement )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==106) ) {
                alt74=1;
            }
            else if ( (LA74_0==122) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return statement;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1558:3: 'if' '(' exp= expression ')' stmtIf= statement ( 'else' stmtElse= statement )?
                    {
                    match(input,106,FOLLOW_106_in_selection_statement3448); if (state.failed) return statement;

                    match(input,38,FOLLOW_38_in_selection_statement3450); if (state.failed) return statement;

                    pushFollow(FOLLOW_expression_in_selection_statement3458);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {
                       statement_i=new Statement.If(null,currentLineNumber);
                        statement_i.setExpression(exp);
                       }

                    match(input,39,FOLLOW_39_in_selection_statement3467); if (state.failed) return statement;

                    pushFollow(FOLLOW_statement_in_selection_statement3475);
                    stmtIf=statement();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {
                          statement_i.setIfStatement(stmtIf);
                        
                        }

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1568:5: ( 'else' stmtElse= statement )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==100) ) {
                        int LA73_1 = input.LA(2);

                        if ( (synpred140_ObjectiveC()) ) {
                            alt73=1;
                        }
                    }
                    switch (alt73) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1568:6: 'else' stmtElse= statement
                            {
                            match(input,100,FOLLOW_100_in_selection_statement3483); if (state.failed) return statement;

                            pushFollow(FOLLOW_statement_in_selection_statement3492);
                            stmtElse=statement();

                            state._fsp--;
                            if (state.failed) return statement;

                            if ( state.backtracking==0 ) {
                                  statement_i.setElseStatement(stmtElse);
                                  
                                 }

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {statement =(Statement)statement_i;}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1574:8: 'switch' '(' exp= expression ')' switch_stmt= statement
                    {
                    match(input,122,FOLLOW_122_in_selection_statement3511); if (state.failed) return statement;

                    match(input,38,FOLLOW_38_in_selection_statement3520); if (state.failed) return statement;

                    pushFollow(FOLLOW_expression_in_selection_statement3538);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {
                           statement_s=new Statement.Switch(null,currentLineNumber);
                            statement_s.setExpression(exp);
                           }

                    match(input,39,FOLLOW_39_in_selection_statement3557); if (state.failed) return statement;

                    pushFollow(FOLLOW_statement_in_selection_statement3568);
                    switch_stmt=statement();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {
                           statement_s.setSwitchStatement(switch_stmt);
                           statement =(Statement)statement_s;
                           }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "selection_statement"



    // $ANTLR start "iteration_statement"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1589:1: iteration_statement returns [Statement Stmt] : ( 'while' '(' e= expression ')' s= statement | 'do' s= statement 'while' '(' e= expression ')' ';' | 'for' '(' ( (e1= expression )? ';' |decl= declaration )? (e2= expression )? ';' (e3= expression )? ')' s= statement );
    public final Statement iteration_statement() throws RecognitionException {
        Statement Stmt = null;


        Expression e =null;

        Statement s =null;

        Expression e1 =null;

        ListDeclaration decl =null;

        Expression e2 =null;

        Expression e3 =null;



            Stmt = null;
            Statement.While whileStmt = null; 
            Statement.ForLoop forStmt = null;
            Statement.doWhile doStmt = null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1597:3: ( 'while' '(' e= expression ')' s= statement | 'do' s= statement 'while' '(' e= expression ')' ';' | 'for' '(' ( (e1= expression )? ';' |decl= declaration )? (e2= expression )? ';' (e3= expression )? ')' s= statement )
            int alt79=3;
            switch ( input.LA(1) ) {
            case 129:
                {
                alt79=1;
                }
                break;
            case 98:
                {
                alt79=2;
                }
                break;
            case 103:
                {
                alt79=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return Stmt;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1597:5: 'while' '(' e= expression ')' s= statement
                    {
                    match(input,129,FOLLOW_129_in_iteration_statement3601); if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) {  whileStmt = new Statement.While( null, currentLineNumber ); }

                    match(input,38,FOLLOW_38_in_iteration_statement3612); if (state.failed) return Stmt;

                    pushFollow(FOLLOW_expression_in_iteration_statement3627);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { whileStmt.setExpression( e ); }

                    match(input,39,FOLLOW_39_in_iteration_statement3635); if (state.failed) return Stmt;

                    pushFollow(FOLLOW_statement_in_iteration_statement3648);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { whileStmt.setStatement( s );  Stmt = ( Statement ) whileStmt; }

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1603:5: 'do' s= statement 'while' '(' e= expression ')' ';'
                    {
                    match(input,98,FOLLOW_98_in_iteration_statement3659); if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { doStmt = new Statement.doWhile( null, currentLineNumber ); }

                    pushFollow(FOLLOW_statement_in_iteration_statement3677);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { doStmt.setStatement( s ); }

                    match(input,129,FOLLOW_129_in_iteration_statement3690); if (state.failed) return Stmt;

                    match(input,38,FOLLOW_38_in_iteration_statement3703); if (state.failed) return Stmt;

                    pushFollow(FOLLOW_expression_in_iteration_statement3719);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { doStmt.setExpression( e ); }

                    match(input,39,FOLLOW_39_in_iteration_statement3733); if (state.failed) return Stmt;

                    match(input,55,FOLLOW_55_in_iteration_statement3746); if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { Stmt = ( Statement ) doStmt; }

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1611:5: 'for' '(' ( (e1= expression )? ';' |decl= declaration )? (e2= expression )? ';' (e3= expression )? ')' s= statement
                    {
                    match(input,103,FOLLOW_103_in_iteration_statement3765); if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { forStmt = new Statement.ForLoop( null, currentLineNumber ); }

                    match(input,38,FOLLOW_38_in_iteration_statement3777); if (state.failed) return Stmt;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:10: ( (e1= expression )? ';' |decl= declaration )?
                    int alt76=3;
                    switch ( input.LA(1) ) {
                        case 38:
                            {
                            int LA76_1 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA76_2 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            else if ( (synpred146_ObjectiveC()) ) {
                                alt76=2;
                            }
                            }
                            break;
                        case CHARACTER_LITERAL:
                        case DECIMAL_LITERAL:
                        case FLOATING_POINT_LITERAL:
                        case HEX_LITERAL:
                        case OCTAL_LITERAL:
                            {
                            int LA76_3 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 67:
                            {
                            int LA76_4 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case STRING_LITERAL:
                            {
                            int LA76_5 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 83:
                            {
                            int LA76_6 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 115:
                            {
                            int LA76_7 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 43:
                            {
                            int LA76_8 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 47:
                            {
                            int LA76_9 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 36:
                            {
                            int LA76_10 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 40:
                            {
                            int LA76_11 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 46:
                            {
                            int LA76_12 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 135:
                            {
                            int LA76_13 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 22:
                            {
                            int LA76_14 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 118:
                            {
                            int LA76_15 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 55:
                            {
                            int LA76_16 = input.LA(2);

                            if ( (synpred145_ObjectiveC()) ) {
                                alt76=1;
                            }
                            }
                            break;
                        case 81:
                        case 89:
                        case 93:
                        case 94:
                        case 99:
                        case 101:
                        case 102:
                        case 105:
                        case 107:
                        case 108:
                        case 112:
                        case 116:
                        case 117:
                        case 119:
                        case 124:
                        case 126:
                        case 127:
                        case 128:
                            {
                            alt76=2;
                            }
                            break;
                    }

                    switch (alt76) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:12: (e1= expression )? ';'
                            {
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:12: (e1= expression )?
                            int alt75=2;
                            int LA75_0 = input.LA(1);

                            if ( (LA75_0==CHARACTER_LITERAL||LA75_0==DECIMAL_LITERAL||LA75_0==FLOATING_POINT_LITERAL||LA75_0==HEX_LITERAL||LA75_0==IDENTIFIER||LA75_0==OCTAL_LITERAL||LA75_0==STRING_LITERAL||LA75_0==22||LA75_0==36||LA75_0==38||LA75_0==40||LA75_0==43||(LA75_0 >= 46 && LA75_0 <= 47)||LA75_0==67||LA75_0==83||LA75_0==115||LA75_0==118||LA75_0==135) ) {
                                alt75=1;
                            }
                            switch (alt75) {
                                case 1 :
                                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:13: e1= expression
                                    {
                                    pushFollow(FOLLOW_expression_in_iteration_statement3801);
                                    e1=expression();

                                    state._fsp--;
                                    if (state.failed) return Stmt;

                                    if ( state.backtracking==0 ) { forStmt.setExprInit( e1 ); }

                                    }
                                    break;

                            }


                            match(input,55,FOLLOW_55_in_iteration_statement3807); if (state.failed) return Stmt;

                            }
                            break;
                        case 2 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:80: decl= declaration
                            {
                            pushFollow(FOLLOW_declaration_in_iteration_statement3813);
                            decl=declaration();

                            state._fsp--;
                            if (state.failed) return Stmt;

                            if ( state.backtracking==0 ) {forStmt.setDeclInit(decl); }

                            }
                            break;

                    }


                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1615:10: (e2= expression )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==CHARACTER_LITERAL||LA77_0==DECIMAL_LITERAL||LA77_0==FLOATING_POINT_LITERAL||LA77_0==HEX_LITERAL||LA77_0==IDENTIFIER||LA77_0==OCTAL_LITERAL||LA77_0==STRING_LITERAL||LA77_0==22||LA77_0==36||LA77_0==38||LA77_0==40||LA77_0==43||(LA77_0 >= 46 && LA77_0 <= 47)||LA77_0==67||LA77_0==83||LA77_0==115||LA77_0==118||LA77_0==135) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1615:12: e2= expression
                            {
                            pushFollow(FOLLOW_expression_in_iteration_statement3846);
                            e2=expression();

                            state._fsp--;
                            if (state.failed) return Stmt;

                            if ( state.backtracking==0 ) { forStmt.setExprCondition( e2 ); }

                            }
                            break;

                    }


                    match(input,55,FOLLOW_55_in_iteration_statement3862); if (state.failed) return Stmt;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1617:10: (e3= expression )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==CHARACTER_LITERAL||LA78_0==DECIMAL_LITERAL||LA78_0==FLOATING_POINT_LITERAL||LA78_0==HEX_LITERAL||LA78_0==IDENTIFIER||LA78_0==OCTAL_LITERAL||LA78_0==STRING_LITERAL||LA78_0==22||LA78_0==36||LA78_0==38||LA78_0==40||LA78_0==43||(LA78_0 >= 46 && LA78_0 <= 47)||LA78_0==67||LA78_0==83||LA78_0==115||LA78_0==118||LA78_0==135) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1617:12: e3= expression
                            {
                            pushFollow(FOLLOW_expression_in_iteration_statement3879);
                            e3=expression();

                            state._fsp--;
                            if (state.failed) return Stmt;

                            if ( state.backtracking==0 ) { forStmt.setExprLast( e3 ); }

                            }
                            break;

                    }


                    match(input,39,FOLLOW_39_in_iteration_statement3894); if (state.failed) return Stmt;

                    pushFollow(FOLLOW_statement_in_iteration_statement3909);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return Stmt;

                    if ( state.backtracking==0 ) { forStmt.setStatement( s ); Stmt = ( Statement ) forStmt;  }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return Stmt;
    }
    // $ANTLR end "iteration_statement"



    // $ANTLR start "compound_statement"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1622:1: compound_statement returns [Statement.CompoundStatement statement] : '{' (stmt_list= statement_list )? '}' ;
    public final Statement.CompoundStatement compound_statement() throws RecognitionException {
        VariableScopeTable_stack.push(new VariableScopeTable_scope());

        Statement.CompoundStatement statement = null;


        Statement.StatementList stmt_list =null;



        statement =new Statement.CompoundStatement(null,currentLineNumber);
        ((VariableScopeTable_scope)VariableScopeTable_stack.peek()).variableScopeTable =new VariableScopeTable();

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1629:4: ( '{' (stmt_list= statement_list )? '}' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1630:4: '{' (stmt_list= statement_list )? '}'
            {
            match(input,130,FOLLOW_130_in_compound_statement3939); if (state.failed) return statement;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1632:5: (stmt_list= statement_list )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==CHARACTER_LITERAL||LA80_0==DECIMAL_LITERAL||LA80_0==FLOATING_POINT_LITERAL||LA80_0==HEX_LITERAL||LA80_0==IDENTIFIER||LA80_0==OCTAL_LITERAL||LA80_0==STRING_LITERAL||LA80_0==22||LA80_0==36||LA80_0==38||LA80_0==40||LA80_0==43||(LA80_0 >= 46 && LA80_0 <= 47)||LA80_0==55||LA80_0==67||LA80_0==81||LA80_0==83||LA80_0==89||(LA80_0 >= 91 && LA80_0 <= 95)||(LA80_0 >= 97 && LA80_0 <= 99)||(LA80_0 >= 101 && LA80_0 <= 108)||LA80_0==112||(LA80_0 >= 114 && LA80_0 <= 119)||LA80_0==122||LA80_0==124||(LA80_0 >= 126 && LA80_0 <= 130)||LA80_0==135) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1632:6: stmt_list= statement_list
                    {
                    pushFollow(FOLLOW_statement_list_in_compound_statement3953);
                    stmt_list=statement_list();

                    state._fsp--;
                    if (state.failed) return statement;

                    if ( state.backtracking==0 ) {
                           statement.setStatement(stmt_list);
                       
                        }

                    }
                    break;

            }


            match(input,134,FOLLOW_134_in_compound_statement3968); if (state.failed) return statement;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            VariableScopeTable_stack.pop();

        }
        return statement;
    }
    // $ANTLR end "compound_statement"



    // $ANTLR start "statement_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1640:1: statement_list returns [Statement.StatementList statement] : (stmt= statement )+ ;
    public final Statement.StatementList statement_list() throws RecognitionException {
        Statement.StatementList statement = null;


        Statement stmt =null;



        statement =new Statement.StatementList(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1645:2: ( (stmt= statement )+ )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1646:2: (stmt= statement )+
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1646:2: (stmt= statement )+
            int cnt81=0;
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==CHARACTER_LITERAL||LA81_0==DECIMAL_LITERAL||LA81_0==FLOATING_POINT_LITERAL||LA81_0==HEX_LITERAL||LA81_0==IDENTIFIER||LA81_0==OCTAL_LITERAL||LA81_0==STRING_LITERAL||LA81_0==22||LA81_0==36||LA81_0==38||LA81_0==40||LA81_0==43||(LA81_0 >= 46 && LA81_0 <= 47)||LA81_0==55||LA81_0==67||LA81_0==81||LA81_0==83||LA81_0==89||(LA81_0 >= 91 && LA81_0 <= 95)||(LA81_0 >= 97 && LA81_0 <= 99)||(LA81_0 >= 101 && LA81_0 <= 108)||LA81_0==112||(LA81_0 >= 114 && LA81_0 <= 119)||LA81_0==122||LA81_0==124||(LA81_0 >= 126 && LA81_0 <= 130)||LA81_0==135) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1647:2: stmt= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statement_list3991);
            	    stmt=statement();

            	    state._fsp--;
            	    if (state.failed) return statement;

            	    if ( state.backtracking==0 ) {
            	     	if(stmt!=null) statement.addStatement(stmt); 
            	     }

            	    }
            	    break;

            	default :
            	    if ( cnt81 >= 1 ) break loop81;
            	    if (state.backtracking>0) {state.failed=true; return statement;}
                        EarlyExitException eee =
                            new EarlyExitException(81, input);
                        throw eee;
                }
                cnt81++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "statement_list"



    // $ANTLR start "expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1655:1: expression returns [Expression expression] : exp1= assignment_expression ( ',' expx= assignment_expression )* ;
    public final Expression expression() throws RecognitionException {
        Expression expression = null;


        AssignmentExpression exp1 =null;

        AssignmentExpression expx =null;



        expression =null;
        ListExpression listExpression=new ListExpression(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1664:2: (exp1= assignment_expression ( ',' expx= assignment_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1665:2: exp1= assignment_expression ( ',' expx= assignment_expression )*
            {
            pushFollow(FOLLOW_assignment_expression_in_expression4025);
            exp1=assignment_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		listExpression.addExpression(exp1);
            		//src.addChild((Statement) exp1);//TODO the src.addChild here should be removed, only for testing purpose
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1670:2: ( ',' expx= assignment_expression )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==45) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1671:3: ',' expx= assignment_expression
            	    {
            	    match(input,45,FOLLOW_45_in_expression4036); if (state.failed) return expression;

            	    pushFollow(FOLLOW_assignment_expression_in_expression4040);
            	    expx=assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			listExpression.addExpression(expx);
            	    			//src.addChild((Statement) expx);//TODO the src.addChild here should be removed, only for testing purpose
            	    		}

            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
            expression =(Expression)listExpression; //At the end of rule returning the list expression
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "expression"



    // $ANTLR start "assignment_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1678:1: assignment_expression returns [AssignmentExpression expression] : exp1= conditional_expression (op= assignment_operator expx= assignment_expression )? ;
    public final AssignmentExpression assignment_expression() throws RecognitionException {
        AssignmentExpression expression = null;


        TertiaryExpression exp1 =null;

        AssignmentSymbol op =null;

        AssignmentExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	AssignmentExpression addTo=null; //Will tell where to add 
        	expression =new AssignmentExpression(null,currentLineNumber,null);
        	addTo=expression;
        	AssignmentSymbol symbol=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1687:2: (exp1= conditional_expression (op= assignment_operator expx= assignment_expression )? )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1688:2: exp1= conditional_expression (op= assignment_operator expx= assignment_expression )?
            {
            pushFollow(FOLLOW_conditional_expression_in_assignment_expression4070);
            exp1=conditional_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		expression.setTarget((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1693:2: (op= assignment_operator expx= assignment_expression )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==34||LA83_0==37||LA83_0==41||LA83_0==44||LA83_0==48||LA83_0==53||LA83_0==58||LA83_0==60||LA83_0==65||LA83_0==87||LA83_0==132) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1694:3: op= assignment_operator expx= assignment_expression
                    {
                    pushFollow(FOLLOW_assignment_operator_in_assignment_expression4086);
                    op=assignment_operator();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {symbol=op;}

                    pushFollow(FOLLOW_assignment_expression_in_assignment_expression4097);
                    expx=assignment_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {
                    			if(prev == null){
                    				expression.setOperator(op);
                    				expression.setValue((Expression) expx);
                    			}
                    			else{
                    				addTo=createAndMergeAssignmentExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
                    			}
                    			prev=expx;
                    			
                    		}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "assignment_expression"



    // $ANTLR start "assignment_operator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1710:1: assignment_operator returns [AssignmentSymbol symbol] : ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' );
    public final AssignmentSymbol assignment_operator() throws RecognitionException {
        AssignmentSymbol symbol = null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1712:2: ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' )
            int alt84=11;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt84=1;
                }
                break;
            case 41:
                {
                alt84=2;
                }
                break;
            case 53:
                {
                alt84=3;
                }
                break;
            case 34:
                {
                alt84=4;
                }
                break;
            case 44:
                {
                alt84=5;
                }
                break;
            case 48:
                {
                alt84=6;
                }
                break;
            case 58:
                {
                alt84=7;
                }
                break;
            case 65:
                {
                alt84=8;
                }
                break;
            case 37:
                {
                alt84=9;
                }
                break;
            case 87:
                {
                alt84=10;
                }
                break;
            case 132:
                {
                alt84=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return symbol;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }

            switch (alt84) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1713:4: '='
                    {
                    match(input,60,FOLLOW_60_in_assignment_operator4127); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.EQUAL;}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1714:4: '*='
                    {
                    match(input,41,FOLLOW_41_in_assignment_operator4134); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.MUL_EQUAL;}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1715:4: '/='
                    {
                    match(input,53,FOLLOW_53_in_assignment_operator4141); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.DIV_EQUAL;}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1716:4: '%='
                    {
                    match(input,34,FOLLOW_34_in_assignment_operator4148); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.MOD_EQUAL;}

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1717:4: '+='
                    {
                    match(input,44,FOLLOW_44_in_assignment_operator4155); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.ADD_EQUAL;}

                    }
                    break;
                case 6 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1718:4: '-='
                    {
                    match(input,48,FOLLOW_48_in_assignment_operator4162); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.SUB_EQUAL;}

                    }
                    break;
                case 7 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1719:4: '<<='
                    {
                    match(input,58,FOLLOW_58_in_assignment_operator4169); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.SHL_EQUAL;}

                    }
                    break;
                case 8 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1720:4: '>>='
                    {
                    match(input,65,FOLLOW_65_in_assignment_operator4176); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.SHR_EQUAL;}

                    }
                    break;
                case 9 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1721:4: '&='
                    {
                    match(input,37,FOLLOW_37_in_assignment_operator4183); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.BITWISE_AND_EQUAL;}

                    }
                    break;
                case 10 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1722:4: '^='
                    {
                    match(input,87,FOLLOW_87_in_assignment_operator4190); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.BITWISE_XOR_EQUAL;}

                    }
                    break;
                case 11 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1723:4: '|='
                    {
                    match(input,132,FOLLOW_132_in_assignment_operator4197); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =AssignmentOperator.AssignmentSymbol.BITWISE_OR_EQUAL;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return symbol;
    }
    // $ANTLR end "assignment_operator"



    // $ANTLR start "conditional_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1727:1: conditional_expression returns [TertiaryExpression expression] : exp1= logical_or_expression ( '?' exp2= logical_or_expression ':' exp3= logical_or_expression )? ;
    public final TertiaryExpression conditional_expression() throws RecognitionException {
        TertiaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression exp2 =null;

        BinaryExpression exp3 =null;



        	expression =new TertiaryExpression(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1732:2: (exp1= logical_or_expression ( '?' exp2= logical_or_expression ':' exp3= logical_or_expression )? )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1733:2: exp1= logical_or_expression ( '?' exp2= logical_or_expression ':' exp3= logical_or_expression )?
            {
            pushFollow(FOLLOW_logical_or_expression_in_conditional_expression4224);
            exp1=logical_or_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		expression.setConditionExpression((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1737:2: ( '?' exp2= logical_or_expression ':' exp3= logical_or_expression )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==66) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1738:3: '?' exp2= logical_or_expression ':' exp3= logical_or_expression
                    {
                    match(input,66,FOLLOW_66_in_conditional_expression4235); if (state.failed) return expression;

                    pushFollow(FOLLOW_logical_or_expression_in_conditional_expression4239);
                    exp2=logical_or_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {
                    			expression.setIfExpression((Expression)exp2);
                    		}

                    match(input,54,FOLLOW_54_in_conditional_expression4248); if (state.failed) return expression;

                    pushFollow(FOLLOW_logical_or_expression_in_conditional_expression4252);
                    exp3=logical_or_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {
                    			expression.setElseExpression((Expression)exp3);
                    		}

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "conditional_expression"



    // $ANTLR start "constant_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1748:1: constant_expression returns [Expression expression] : exp= conditional_expression ;
    public final Expression constant_expression() throws RecognitionException {
        Expression expression = null;


        TertiaryExpression exp =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1750:3: (exp= conditional_expression )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1750:3: exp= conditional_expression
            {
            pushFollow(FOLLOW_conditional_expression_in_constant_expression4279);
            exp=conditional_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) { expression = exp; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "constant_expression"



    // $ANTLR start "logical_or_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1752:1: logical_or_expression returns [BinaryExpression expression] : exp1= logical_and_expression ( '||' expx= logical_and_expression )* ;
    public final BinaryExpression logical_or_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1760:2: (exp1= logical_and_expression ( '||' expx= logical_and_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1761:2: exp1= logical_and_expression ( '||' expx= logical_and_expression )*
            {
            pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression4302);
            exp1=logical_and_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1765:2: ( '||' expx= logical_and_expression )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==133) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1766:3: '||' expx= logical_and_expression
            	    {
            	    match(input,133,FOLLOW_133_in_logical_or_expression4313); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {expression.setOperator(BinaryOperator.LogicalOperator.OR);}

            	    pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression4325);
            	    expx=logical_and_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "logical_or_expression"



    // $ANTLR start "logical_and_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1780:1: logical_and_expression returns [BinaryExpression expression] : exp1= inclusive_or_expression ( '&&' expx= inclusive_or_expression )* ;
    public final BinaryExpression logical_and_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1788:2: (exp1= inclusive_or_expression ( '&&' expx= inclusive_or_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1789:2: exp1= inclusive_or_expression ( '&&' expx= inclusive_or_expression )*
            {
            pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression4353);
            exp1=inclusive_or_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1792:2: ( '&&' expx= inclusive_or_expression )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==35) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1793:3: '&&' expx= inclusive_or_expression
            	    {
            	    match(input,35,FOLLOW_35_in_logical_and_expression4362); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {expression.setOperator(BinaryOperator.LogicalOperator.AND);}

            	    pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression4373);
            	    expx=inclusive_or_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "logical_and_expression"



    // $ANTLR start "inclusive_or_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1808:1: inclusive_or_expression returns [BinaryExpression expression] : exp1= exclusive_or_expression ( '|' expx= exclusive_or_expression )* ;
    public final BinaryExpression inclusive_or_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1816:2: (exp1= exclusive_or_expression ( '|' expx= exclusive_or_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1817:2: exp1= exclusive_or_expression ( '|' expx= exclusive_or_expression )*
            {
            pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression4403);
            exp1=exclusive_or_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1821:2: ( '|' expx= exclusive_or_expression )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==131) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1822:3: '|' expx= exclusive_or_expression
            	    {
            	    match(input,131,FOLLOW_131_in_inclusive_or_expression4414); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {expression.setOperator(BinaryOperator.BitwiseOperator.OR);}

            	    pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression4426);
            	    expx=exclusive_or_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "inclusive_or_expression"



    // $ANTLR start "exclusive_or_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1837:1: exclusive_or_expression returns [BinaryExpression expression] : exp1= and_expression ( '^' expx= and_expression )* ;
    public final BinaryExpression exclusive_or_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1845:2: (exp1= and_expression ( '^' expx= and_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1846:2: exp1= and_expression ( '^' expx= and_expression )*
            {
            pushFollow(FOLLOW_and_expression_in_exclusive_or_expression4456);
            exp1=and_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1850:2: ( '^' expx= and_expression )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==86) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1851:3: '^' expx= and_expression
            	    {
            	    match(input,86,FOLLOW_86_in_exclusive_or_expression4467); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {expression.setOperator(BinaryOperator.BitwiseOperator.XOR);}

            	    pushFollow(FOLLOW_and_expression_in_exclusive_or_expression4479);
            	    expx=and_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "exclusive_or_expression"



    // $ANTLR start "and_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1866:1: and_expression returns [BinaryExpression expression] : exp1= equality_expression ( '&' expx= equality_expression )* ;
    public final BinaryExpression and_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1874:2: (exp1= equality_expression ( '&' expx= equality_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1875:2: exp1= equality_expression ( '&' expx= equality_expression )*
            {
            pushFollow(FOLLOW_equality_expression_in_and_expression4509);
            exp1=equality_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1879:2: ( '&' expx= equality_expression )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==36) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1880:3: '&' expx= equality_expression
            	    {
            	    match(input,36,FOLLOW_36_in_and_expression4520); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {expression.setOperator(BinaryOperator.BitwiseOperator.AND);}

            	    pushFollow(FOLLOW_equality_expression_in_and_expression4531);
            	    expx=equality_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "and_expression"



    // $ANTLR start "equality_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1895:1: equality_expression returns [BinaryExpression expression] : exp1= relational_expression ( ( '!=' | '==' ) expx= relational_expression )* ;
    public final BinaryExpression equality_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	BinarySymbol op=null;
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1904:2: (exp1= relational_expression ( ( '!=' | '==' ) expx= relational_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1905:2: exp1= relational_expression ( ( '!=' | '==' ) expx= relational_expression )*
            {
            pushFollow(FOLLOW_relational_expression_in_equality_expression4561);
            exp1=relational_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) { 
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1909:2: ( ( '!=' | '==' ) expx= relational_expression )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==23||LA92_0==61) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1910:3: ( '!=' | '==' ) expx= relational_expression
            	    {
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1910:3: ( '!=' | '==' )
            	    int alt91=2;
            	    int LA91_0 = input.LA(1);

            	    if ( (LA91_0==23) ) {
            	        alt91=1;
            	    }
            	    else if ( (LA91_0==61) ) {
            	        alt91=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expression;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 91, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt91) {
            	        case 1 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1911:4: '!='
            	            {
            	            match(input,23,FOLLOW_23_in_equality_expression4578); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.RelationalOperator.NOT_EQUAL;}

            	            }
            	            break;
            	        case 2 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1912:6: '=='
            	            {
            	            match(input,61,FOLLOW_61_in_equality_expression4588); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.RelationalOperator.EQUAL;}

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_relational_expression_in_equality_expression4605);
            	    expx=relational_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setOperator(op);
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "equality_expression"



    // $ANTLR start "relational_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1928:1: relational_expression returns [BinaryExpression expression] : exp1= shift_expression ( ( '<' | '>' | '<=' | '>=' ) expx= shift_expression )* ;
    public final BinaryExpression relational_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	BinarySymbol op=null;
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1937:2: (exp1= shift_expression ( ( '<' | '>' | '<=' | '>=' ) expx= shift_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1938:2: exp1= shift_expression ( ( '<' | '>' | '<=' | '>=' ) expx= shift_expression )*
            {
            pushFollow(FOLLOW_shift_expression_in_relational_expression4632);
            exp1=shift_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) { 
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1941:2: ( ( '<' | '>' | '<=' | '>=' ) expx= shift_expression )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==56||LA94_0==59||(LA94_0 >= 62 && LA94_0 <= 63)) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1942:3: ( '<' | '>' | '<=' | '>=' ) expx= shift_expression
            	    {
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1942:3: ( '<' | '>' | '<=' | '>=' )
            	    int alt93=4;
            	    switch ( input.LA(1) ) {
            	    case 56:
            	        {
            	        alt93=1;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt93=2;
            	        }
            	        break;
            	    case 59:
            	        {
            	        alt93=3;
            	        }
            	        break;
            	    case 63:
            	        {
            	        alt93=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expression;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 93, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt93) {
            	        case 1 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1943:4: '<'
            	            {
            	            match(input,56,FOLLOW_56_in_relational_expression4647); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.RelationalOperator.LESS;}

            	            }
            	            break;
            	        case 2 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1944:6: '>'
            	            {
            	            match(input,62,FOLLOW_62_in_relational_expression4657); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.RelationalOperator.GREATER;}

            	            }
            	            break;
            	        case 3 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1945:6: '<='
            	            {
            	            match(input,59,FOLLOW_59_in_relational_expression4667); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.RelationalOperator.LESS_EQUAL;}

            	            }
            	            break;
            	        case 4 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1946:6: '>='
            	            {
            	            match(input,63,FOLLOW_63_in_relational_expression4677); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.RelationalOperator.GREATER_EQUAL;}

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_shift_expression_in_relational_expression4694);
            	    expx=shift_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setOperator(op);
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "relational_expression"



    // $ANTLR start "shift_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1962:1: shift_expression returns [BinaryExpression expression] : exp1= additive_expression ( ( '<<' | '>>' ) expx= shift_expression )* ;
    public final BinaryExpression shift_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	BinarySymbol op=null;
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1971:2: (exp1= additive_expression ( ( '<<' | '>>' ) expx= shift_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1972:2: exp1= additive_expression ( ( '<<' | '>>' ) expx= shift_expression )*
            {
            pushFollow(FOLLOW_additive_expression_in_shift_expression4720);
            exp1=additive_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) { 
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1975:2: ( ( '<<' | '>>' ) expx= shift_expression )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==57) ) {
                    int LA96_2 = input.LA(2);

                    if ( (synpred176_ObjectiveC()) ) {
                        alt96=1;
                    }


                }
                else if ( (LA96_0==64) ) {
                    int LA96_3 = input.LA(2);

                    if ( (synpred176_ObjectiveC()) ) {
                        alt96=1;
                    }


                }


                switch (alt96) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1976:3: ( '<<' | '>>' ) expx= shift_expression
            	    {
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1976:3: ( '<<' | '>>' )
            	    int alt95=2;
            	    int LA95_0 = input.LA(1);

            	    if ( (LA95_0==57) ) {
            	        alt95=1;
            	    }
            	    else if ( (LA95_0==64) ) {
            	        alt95=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expression;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 95, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt95) {
            	        case 1 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1977:4: '<<'
            	            {
            	            match(input,57,FOLLOW_57_in_shift_expression4735); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.ShiftOperator.SHL;}

            	            }
            	            break;
            	        case 2 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1978:6: '>>'
            	            {
            	            match(input,64,FOLLOW_64_in_shift_expression4745); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.ShiftOperator.SHR;}

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_shift_expression_in_shift_expression4761);
            	    expx=shift_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setOperator(op);
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "shift_expression"



    // $ANTLR start "additive_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1994:1: additive_expression returns [BinaryExpression expression] : exp1= multiplicative_expression ( ( '+' | '-' ) expx= multiplicative_expression )* ;
    public final BinaryExpression additive_expression() throws RecognitionException {
        BinaryExpression expression = null;


        BinaryExpression exp1 =null;

        BinaryExpression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	BinarySymbol op=null;
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2003:2: (exp1= multiplicative_expression ( ( '+' | '-' ) expx= multiplicative_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2004:2: exp1= multiplicative_expression ( ( '+' | '-' ) expx= multiplicative_expression )*
            {
            pushFollow(FOLLOW_multiplicative_expression_in_additive_expression4788);
            exp1=multiplicative_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) { 
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2007:2: ( ( '+' | '-' ) expx= multiplicative_expression )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==42||LA98_0==46) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2008:3: ( '+' | '-' ) expx= multiplicative_expression
            	    {
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2008:3: ( '+' | '-' )
            	    int alt97=2;
            	    int LA97_0 = input.LA(1);

            	    if ( (LA97_0==42) ) {
            	        alt97=1;
            	    }
            	    else if ( (LA97_0==46) ) {
            	        alt97=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expression;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 97, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt97) {
            	        case 1 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2009:4: '+'
            	            {
            	            match(input,42,FOLLOW_42_in_additive_expression4803); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.ArithOperator.ADD;}

            	            }
            	            break;
            	        case 2 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2010:5: '-'
            	            {
            	            match(input,46,FOLLOW_46_in_additive_expression4812); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.ArithOperator.SUB;}

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression4828);
            	    expx=multiplicative_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    			if(prev == null){
            	    				expression.setOperator(op);
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "additive_expression"



    // $ANTLR start "multiplicative_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2026:1: multiplicative_expression returns [BinaryExpression expression] : exp1= cast_expression ( ( '*' | '/' | '%' ) expx= cast_expression )* ;
    public final BinaryExpression multiplicative_expression() throws RecognitionException {
        BinaryExpression expression = null;


        Expression exp1 =null;

        Expression expx =null;



        	Expression prev=null; //Will tell the prvious expression added;
        	BinaryExpression addTo=null; //Will tell where to add
        	BinarySymbol op=null;
        	expression =new BinaryExpression(null,currentLineNumber,null);
        	addTo=expression;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2035:2: (exp1= cast_expression ( ( '*' | '/' | '%' ) expx= cast_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2036:2: exp1= cast_expression ( ( '*' | '/' | '%' ) expx= cast_expression )*
            {
            pushFollow(FOLLOW_cast_expression_in_multiplicative_expression4855);
            exp1=cast_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) { 
            		expression.setLhs((Expression)exp1);
            	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2039:2: ( ( '*' | '/' | '%' ) expx= cast_expression )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==33||LA100_0==40||LA100_0==52) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2040:3: ( '*' | '/' | '%' ) expx= cast_expression
            	    {
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2040:3: ( '*' | '/' | '%' )
            	    int alt99=3;
            	    switch ( input.LA(1) ) {
            	    case 40:
            	        {
            	        alt99=1;
            	        }
            	        break;
            	    case 52:
            	        {
            	        alt99=2;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt99=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return expression;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 99, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt99) {
            	        case 1 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2041:4: '*'
            	            {
            	            match(input,40,FOLLOW_40_in_multiplicative_expression4869); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.ArithOperator.MUL;}

            	            }
            	            break;
            	        case 2 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2042:6: '/'
            	            {
            	            match(input,52,FOLLOW_52_in_multiplicative_expression4879); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.ArithOperator.DIV;}

            	            }
            	            break;
            	        case 3 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2043:6: '%'
            	            {
            	            match(input,33,FOLLOW_33_in_multiplicative_expression4889); if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {op=BinaryOperator.ArithOperator.MOD;}

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_cast_expression_in_multiplicative_expression4905);
            	    expx=cast_expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) { 
            	    			if(prev == null){
            	    				expression.setOperator(op);
            	    				expression.setRhs((Expression) expx);
            	    			}
            	    			else{
            	    				addTo=createAndMergeBinaryExpression(null,currentLineNumber,expression.getOperator(),prev,addTo,(Expression)expx);
            	    			}
            	    			prev=expx;
            	    			
            	    		}

            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "multiplicative_expression"



    // $ANTLR start "cast_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2059:1: cast_expression returns [Expression expression] : ( '(' type_name ')' c= cast_expression |ex= unary_expression );
    public final Expression cast_expression() throws RecognitionException {
        Expression expression = null;


        Expression c =null;

        UnaryExpression ex =null;

        MethodType type_name45 =null;



        	CastExpression castExpression=new CastExpression(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2067:2: ( '(' type_name ')' c= cast_expression |ex= unary_expression )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==38) ) {
                int LA101_1 = input.LA(2);

                if ( (synpred182_ObjectiveC()) ) {
                    alt101=1;
                }
                else if ( (true) ) {
                    alt101=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expression;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA101_0==CHARACTER_LITERAL||LA101_0==DECIMAL_LITERAL||LA101_0==FLOATING_POINT_LITERAL||LA101_0==HEX_LITERAL||LA101_0==IDENTIFIER||LA101_0==OCTAL_LITERAL||LA101_0==STRING_LITERAL||LA101_0==22||LA101_0==36||LA101_0==40||LA101_0==43||(LA101_0 >= 46 && LA101_0 <= 47)||LA101_0==67||LA101_0==83||LA101_0==115||LA101_0==118||LA101_0==135) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }
            switch (alt101) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2068:2: '(' type_name ')' c= cast_expression
                    {
                    match(input,38,FOLLOW_38_in_cast_expression4936); if (state.failed) return expression;

                    pushFollow(FOLLOW_type_name_in_cast_expression4938);
                    type_name45=type_name();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input,39,FOLLOW_39_in_cast_expression4940); if (state.failed) return expression;

                    pushFollow(FOLLOW_cast_expression_in_cast_expression4944);
                    c=cast_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) { 
                    		castExpression.setCastedType(type_name45);
                    		castExpression.setChildCastExpression((Expression)c); 
                    	}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2073:2: ex= unary_expression
                    {
                    pushFollow(FOLLOW_unary_expression_in_cast_expression4955);
                    ex=unary_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {castExpression.setUnaryExpression(ex);}

                    }
                    break;

            }
            if ( state.backtracking==0 ) {
            	expression =castExpression;
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "cast_expression"



    // $ANTLR start "unary_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2076:1: unary_expression returns [UnaryExpression expression] : (exp= postfix_expression | '++' exp= unary_expression | '--' exp= unary_expression |op= unary_operator exp= cast_expression | 'sizeof' ( '(' type_name ')' | unary_expression ) );
    public final UnaryExpression unary_expression() throws RecognitionException {
        UnaryExpression expression = null;


        Expression exp =null;

        UnarySymbol op =null;



        	UnarySymbol operator=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2081:2: (exp= postfix_expression | '++' exp= unary_expression | '--' exp= unary_expression |op= unary_operator exp= cast_expression | 'sizeof' ( '(' type_name ')' | unary_expression ) )
            int alt103=5;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
            case 38:
            case 67:
            case 83:
            case 115:
                {
                alt103=1;
                }
                break;
            case 43:
                {
                alt103=2;
                }
                break;
            case 47:
                {
                alt103=3;
                }
                break;
            case 22:
            case 36:
            case 40:
            case 46:
            case 135:
                {
                alt103=4;
                }
                break;
            case 118:
                {
                alt103=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }

            switch (alt103) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2082:4: exp= postfix_expression
                    {
                    pushFollow(FOLLOW_postfix_expression_in_unary_expression4984);
                    exp=postfix_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new UnaryExpression(null,currentLineNumber,null,(Expression)exp);}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2083:4: '++' exp= unary_expression
                    {
                    match(input,43,FOLLOW_43_in_unary_expression4991); if (state.failed) return expression;

                    pushFollow(FOLLOW_unary_expression_in_unary_expression4995);
                    exp=unary_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new UnaryExpression(null,currentLineNumber,UnarySymbol.PRE_INC,(Expression)exp);}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2084:4: '--' exp= unary_expression
                    {
                    match(input,47,FOLLOW_47_in_unary_expression5003); if (state.failed) return expression;

                    pushFollow(FOLLOW_unary_expression_in_unary_expression5007);
                    exp=unary_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new UnaryExpression(null,currentLineNumber,UnarySymbol.PRE_DEC,(Expression)exp);}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2085:4: op= unary_operator exp= cast_expression
                    {
                    pushFollow(FOLLOW_unary_operator_in_unary_expression5017);
                    op=unary_operator();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {operator=op;}

                    pushFollow(FOLLOW_cast_expression_in_unary_expression5022);
                    exp=cast_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new UnaryExpression(null,currentLineNumber,operator,(Expression)exp);}

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2086:4: 'sizeof' ( '(' type_name ')' | unary_expression )
                    {
                    match(input,118,FOLLOW_118_in_unary_expression5028); if (state.failed) return expression;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2086:13: ( '(' type_name ')' | unary_expression )
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==38) ) {
                        int LA102_1 = input.LA(2);

                        if ( (synpred187_ObjectiveC()) ) {
                            alt102=1;
                        }
                        else if ( (true) ) {
                            alt102=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return expression;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 102, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA102_0==CHARACTER_LITERAL||LA102_0==DECIMAL_LITERAL||LA102_0==FLOATING_POINT_LITERAL||LA102_0==HEX_LITERAL||LA102_0==IDENTIFIER||LA102_0==OCTAL_LITERAL||LA102_0==STRING_LITERAL||LA102_0==22||LA102_0==36||LA102_0==40||LA102_0==43||(LA102_0 >= 46 && LA102_0 <= 47)||LA102_0==67||LA102_0==83||LA102_0==115||LA102_0==118||LA102_0==135) ) {
                        alt102=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return expression;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 102, 0, input);

                        throw nvae;

                    }
                    switch (alt102) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2086:14: '(' type_name ')'
                            {
                            match(input,38,FOLLOW_38_in_unary_expression5031); if (state.failed) return expression;

                            pushFollow(FOLLOW_type_name_in_unary_expression5033);
                            type_name();

                            state._fsp--;
                            if (state.failed) return expression;

                            match(input,39,FOLLOW_39_in_unary_expression5035); if (state.failed) return expression;

                            }
                            break;
                        case 2 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2086:34: unary_expression
                            {
                            pushFollow(FOLLOW_unary_expression_in_unary_expression5039);
                            unary_expression();

                            state._fsp--;
                            if (state.failed) return expression;

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "unary_expression"



    // $ANTLR start "unary_operator"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2089:1: unary_operator returns [UnarySymbol symbol] : ( '&' | '*' | '-' | '~' | '!' );
    public final UnarySymbol unary_operator() throws RecognitionException {
        UnarySymbol symbol = null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2091:2: ( '&' | '*' | '-' | '~' | '!' )
            int alt104=5;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt104=1;
                }
                break;
            case 40:
                {
                alt104=2;
                }
                break;
            case 46:
                {
                alt104=3;
                }
                break;
            case 135:
                {
                alt104=4;
                }
                break;
            case 22:
                {
                alt104=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return symbol;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }

            switch (alt104) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2092:4: '&'
                    {
                    match(input,36,FOLLOW_36_in_unary_operator5062); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =UnaryOperator.UnarySymbol.REFERENCE;}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2093:4: '*'
                    {
                    match(input,40,FOLLOW_40_in_unary_operator5070); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =UnaryOperator.UnarySymbol.DEREFERENCE;}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2094:4: '-'
                    {
                    match(input,46,FOLLOW_46_in_unary_operator5077); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =UnaryOperator.UnarySymbol.SIGN_MINUS;}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2095:4: '~'
                    {
                    match(input,135,FOLLOW_135_in_unary_operator5084); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =UnaryOperator.UnarySymbol.BITWISE_NOT;}

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2096:4: '!'
                    {
                    match(input,22,FOLLOW_22_in_unary_operator5091); if (state.failed) return symbol;

                    if ( state.backtracking==0 ) {symbol =UnaryOperator.UnarySymbol.LOGICAL_NOT;}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return symbol;
    }
    // $ANTLR end "unary_operator"



    // $ANTLR start "postfix_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2100:1: postfix_expression returns [PostfixExpression expression] : exp1= primary_expression ( '[' exp2= expression ']' | '(' (ael= argument_expression_list )? ')' | '.' id1= identifier | '->' id2= identifier | '++' | '--' )* ;
    public final PostfixExpression postfix_expression() throws RecognitionException {
        PostfixExpression expression = null;


        PrimaryExpression exp1 =null;

        Expression exp2 =null;

        ListExpression ael =null;

        ObjectiveCParser.identifier_return id1 =null;

        ObjectiveCParser.identifier_return id2 =null;



        	expression =new PostfixExpression(null,currentLineNumber);
        	ListExpression expressions=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2106:2: (exp1= primary_expression ( '[' exp2= expression ']' | '(' (ael= argument_expression_list )? ')' | '.' id1= identifier | '->' id2= identifier | '++' | '--' )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2107:2: exp1= primary_expression ( '[' exp2= expression ']' | '(' (ael= argument_expression_list )? ')' | '.' id1= identifier | '->' id2= identifier | '++' | '--' )*
            {
            pushFollow(FOLLOW_primary_expression_in_postfix_expression5117);
            exp1=primary_expression();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {expression.setPrimaryExpression(exp1);}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2109:2: ( '[' exp2= expression ']' | '(' (ael= argument_expression_list )? ')' | '.' id1= identifier | '->' id2= identifier | '++' | '--' )*
            loop106:
            do {
                int alt106=7;
                switch ( input.LA(1) ) {
                case 83:
                    {
                    alt106=1;
                    }
                    break;
                case 38:
                    {
                    alt106=2;
                    }
                    break;
                case 50:
                    {
                    alt106=3;
                    }
                    break;
                case 49:
                    {
                    alt106=4;
                    }
                    break;
                case 43:
                    {
                    alt106=5;
                    }
                    break;
                case 47:
                    {
                    alt106=6;
                    }
                    break;

                }

                switch (alt106) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2110:8: '[' exp2= expression ']'
            	    {
            	    match(input,83,FOLLOW_83_in_postfix_expression5134); if (state.failed) return expression;

            	    pushFollow(FOLLOW_expression_in_postfix_expression5138);
            	    exp2=expression();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    match(input,85,FOLLOW_85_in_postfix_expression5140); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    	      	expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.ARRAY,exp2));
            	    	      	expression.setArr(true);
            	    	      }

            	    }
            	    break;
            	case 2 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2114:8: '(' (ael= argument_expression_list )? ')'
            	    {
            	    match(input,38,FOLLOW_38_in_postfix_expression5151); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {expressions=null;}

            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2115:8: (ael= argument_expression_list )?
            	    int alt105=2;
            	    int LA105_0 = input.LA(1);

            	    if ( (LA105_0==CHARACTER_LITERAL||LA105_0==DECIMAL_LITERAL||LA105_0==FLOATING_POINT_LITERAL||LA105_0==HEX_LITERAL||LA105_0==IDENTIFIER||LA105_0==OCTAL_LITERAL||LA105_0==STRING_LITERAL||LA105_0==22||LA105_0==36||LA105_0==38||LA105_0==40||LA105_0==43||(LA105_0 >= 46 && LA105_0 <= 47)||LA105_0==67||LA105_0==83||LA105_0==115||LA105_0==118||LA105_0==135) ) {
            	        alt105=1;
            	    }
            	    switch (alt105) {
            	        case 1 :
            	            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2115:9: ael= argument_expression_list
            	            {
            	            pushFollow(FOLLOW_argument_expression_list_in_postfix_expression5165);
            	            ael=argument_expression_list();

            	            state._fsp--;
            	            if (state.failed) return expression;

            	            if ( state.backtracking==0 ) {expressions=ael;}

            	            }
            	            break;

            	    }


            	    match(input,39,FOLLOW_39_in_postfix_expression5181); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    	       
            	    	       	
            	    	       	Function f=(Function)symbolTable.getObject(expression.toString(),IdentifierType.FUNCTION);
            	    	        if(f!=null)
            	    	        	expression.getPrimaryExpression().setGlobalReference(f.getOwnerName());
            	    	       	expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.FUNCTION_CALL,expressions));
            	    	       }

            	    }
            	    break;
            	case 3 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2124:8: '.' id1= identifier
            	    {
            	    match(input,50,FOLLOW_50_in_postfix_expression5193); if (state.failed) return expression;

            	    pushFollow(FOLLOW_identifier_in_postfix_expression5197);
            	    id1=identifier();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    	       	expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.DEREFER,(id1!=null?id1.identifier:null)));
            	    	       }

            	    }
            	    break;
            	case 4 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2127:8: '->' id2= identifier
            	    {
            	    match(input,49,FOLLOW_49_in_postfix_expression5209); if (state.failed) return expression;

            	    pushFollow(FOLLOW_identifier_in_postfix_expression5213);
            	    id2=identifier();

            	    state._fsp--;
            	    if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    	       	expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.POINTER_DEREFER,(id2!=null?id2.identifier:null)));
            	    	       }

            	    }
            	    break;
            	case 5 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2130:5: '++'
            	    {
            	    match(input,43,FOLLOW_43_in_postfix_expression5220); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    	       	expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.POST_INC,new UnaryOperator(UnarySymbol.POST_INC)));
            	    	       }

            	    }
            	    break;
            	case 6 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2133:5: '--'
            	    {
            	    match(input,47,FOLLOW_47_in_postfix_expression5228); if (state.failed) return expression;

            	    if ( state.backtracking==0 ) {
            	    	       	expression.addPostfix(new PostfixExpressionCollector(PostfixExpressionType.POST_DEC,new UnaryOperator(UnarySymbol.POST_INC)));
            	    	       }

            	    }
            	    break;

            	default :
            	    break loop106;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "postfix_expression"



    // $ANTLR start "argument_expression_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2140:1: argument_expression_list returns [ListExpression expressions] : a1= assignment_expression ( ',' ax= assignment_expression )* ;
    public final ListExpression argument_expression_list() throws RecognitionException {
        ListExpression expressions = null;


        AssignmentExpression a1 =null;

        AssignmentExpression ax =null;



        	expressions =new ListExpression(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2145:3: (a1= assignment_expression ( ',' ax= assignment_expression )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2145:5: a1= assignment_expression ( ',' ax= assignment_expression )*
            {
            pushFollow(FOLLOW_assignment_expression_in_argument_expression_list5260);
            a1=assignment_expression();

            state._fsp--;
            if (state.failed) return expressions;

            if ( state.backtracking==0 ) {
              		expressions.addExpression(a1);
              	}

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2148:4: ( ',' ax= assignment_expression )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==45) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2148:6: ',' ax= assignment_expression
            	    {
            	    match(input,45,FOLLOW_45_in_argument_expression_list5269); if (state.failed) return expressions;

            	    pushFollow(FOLLOW_assignment_expression_in_argument_expression_list5278);
            	    ax=assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return expressions;

            	    if ( state.backtracking==0 ) {
            	      			expressions.addExpression(ax);
            	      		}

            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expressions;
    }
    // $ANTLR end "argument_expression_list"



    // $ANTLR start "primary_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2155:1: primary_expression returns [PrimaryExpression expression] : (id1= IDENTIFIER |id2= constant | ( '@' )? id3= STRING_LITERAL | ( '(' exp= expression ')' ) |mexp= message_expression | 'self' );
    public final PrimaryExpression primary_expression() throws RecognitionException {
        PrimaryExpression expression = null;


        Token id1=null;
        Token id3=null;
        ObjectiveCParser.constant_return id2 =null;

        Expression exp =null;

        MessageExpression mexp =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2157:2: (id1= IDENTIFIER |id2= constant | ( '@' )? id3= STRING_LITERAL | ( '(' exp= expression ')' ) |mexp= message_expression | 'self' )
            int alt109=6;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt109=1;
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
                {
                alt109=2;
                }
                break;
            case STRING_LITERAL:
            case 67:
                {
                alt109=3;
                }
                break;
            case 38:
                {
                alt109=4;
                }
                break;
            case 83:
                {
                alt109=5;
                }
                break;
            case 115:
                {
                alt109=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }

            switch (alt109) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2158:4: id1= IDENTIFIER
                    {
                    id1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression5309); if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,(id1!=null?id1.getText():null),RefType.IDENTIFIER);}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2159:4: id2= constant
                    {
                    pushFollow(FOLLOW_constant_in_primary_expression5318);
                    id2=constant();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,(id2!=null?input.toString(id2.start,id2.stop):null),RefType.CONSTANT);}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2160:4: ( '@' )? id3= STRING_LITERAL
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2160:4: ( '@' )?
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==67) ) {
                        alt108=1;
                    }
                    switch (alt108) {
                        case 1 :
                            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2160:5: '@'
                            {
                            match(input,67,FOLLOW_67_in_primary_expression5326); if (state.failed) return expression;

                            }
                            break;

                    }


                    id3=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_primary_expression5332); if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,(id3!=null?id3.getText():null),RefType.STRING);}

                    }
                    break;
                case 4 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2161:4: ( '(' exp= expression ')' )
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2161:4: ( '(' exp= expression ')' )
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2161:5: '(' exp= expression ')'
                    {
                    match(input,38,FOLLOW_38_in_primary_expression5340); if (state.failed) return expression;

                    pushFollow(FOLLOW_expression_in_primary_expression5344);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    match(input,39,FOLLOW_39_in_primary_expression5346); if (state.failed) return expression;

                    }


                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,exp);expression.setHasParanthesis(true);}

                    }
                    break;
                case 5 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2162:4: mexp= message_expression
                    {
                    pushFollow(FOLLOW_message_expression_in_primary_expression5356);
                    mexp=message_expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,mexp);}

                    }
                    break;
                case 6 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2163:4: 'self'
                    {
                    match(input,115,FOLLOW_115_in_primary_expression5363); if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,"this",RefType.IDENTIFIER);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "primary_expression"



    // $ANTLR start "message_expression"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2167:1: message_expression returns [MessageExpression expression] : ( '[' rece= receiver message_selector ']' ) ;
    public final MessageExpression message_expression() throws RecognitionException {
        MessageExpression expression = null;


        Expression rece =null;

        MessageExpression message_selector46 =null;



        	Expression rec=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2172:2: ( ( '[' rece= receiver message_selector ']' ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2173:2: ( '[' rece= receiver message_selector ']' )
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2173:2: ( '[' rece= receiver message_selector ']' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2173:3: '[' rece= receiver message_selector ']'
            {
            match(input,83,FOLLOW_83_in_message_expression5389); if (state.failed) return expression;

            pushFollow(FOLLOW_receiver_in_message_expression5396);
            rece=receiver();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {rec=rece;}

            pushFollow(FOLLOW_message_selector_in_message_expression5402);
            message_selector46=message_selector();

            state._fsp--;
            if (state.failed) return expression;

            if ( state.backtracking==0 ) {
            			expression =message_selector46;
            			expression.setReceiver(rec);
            			
            			ClassDAO cDao=APIMappingTable.getClassMapping(expression.getReceiverName());
            			
            			if(cDao!=null){
            				expression.setMappedReceiverName(cDao.className.getName());
            				
            			}
            			
            			String receiverType=getVariableType(expression.getReceiverName() ); 
            			if(receiverType!=null){
            				FunctionDAO dao=APIMappingTable.getFunctionMapping(receiverType,expression.getFunctionName() );
            				if(dao!=null){
            					
            					if(expression.getMessageName()!=null){ 
            						expression.setMessageName(dao.functionName);
            					}
            					else{
            						expression.setMappedMessageName(dao.functionName.getName());
            					}
            					expression.setTotalMappedParameterLength(dao.getNumberOfParameters());
            				}
            			}
            		}

            match(input,85,FOLLOW_85_in_message_expression5407); if (state.failed) return expression;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "message_expression"



    // $ANTLR start "receiver"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2204:1: receiver returns [Expression expression] : (exp= expression | class_name | 'super' );
    public final Expression receiver() throws RecognitionException {
        Expression expression = null;


        Expression exp =null;

        ObjectiveCParser.class_name_return class_name47 =null;


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2206:4: (exp= expression | class_name | 'super' )
            int alt110=3;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
            case 22:
            case 36:
            case 38:
            case 40:
            case 43:
            case 46:
            case 47:
            case 67:
            case 83:
            case 115:
            case 118:
            case 135:
                {
                alt110=1;
                }
                break;
            case IDENTIFIER:
                {
                int LA110_2 = input.LA(2);

                if ( (synpred206_ObjectiveC()) ) {
                    alt110=1;
                }
                else if ( (synpred207_ObjectiveC()) ) {
                    alt110=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expression;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 110, 2, input);

                    throw nvae;

                }
                }
                break;
            case 121:
                {
                alt110=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }

            switch (alt110) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2207:4: exp= expression
                    {
                    pushFollow(FOLLOW_expression_in_receiver5428);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =exp;}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2208:4: class_name
                    {
                    pushFollow(FOLLOW_class_name_in_receiver5434);
                    class_name47=class_name();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,(class_name47!=null?input.toString(class_name47.start,class_name47.stop):null),RefType.IDENTIFIER);}

                    }
                    break;
                case 3 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2209:4: 'super'
                    {
                    match(input,121,FOLLOW_121_in_receiver5442); if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression =new PrimaryExpression(null,currentLineNumber,"super",RefType.IDENTIFIER);}

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "receiver"



    // $ANTLR start "message_selector"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2212:1: message_selector returns [MessageExpression expression] : ( selector | ( keyword_argument )+ );
    public final MessageExpression message_selector() throws RecognitionException {
        MessageExpression expression = null;


        ObjectiveCParser.selector_return selector48 =null;

        Parameter keyword_argument49 =null;



        	expression =new MessageExpression(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2217:2: ( selector | ( keyword_argument )+ )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==IDENTIFIER) ) {
                int LA112_1 = input.LA(2);

                if ( (LA112_1==85) ) {
                    alt112=1;
                }
                else if ( (LA112_1==54) ) {
                    alt112=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expression;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 112, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA112_0==54) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return expression;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;

            }
            switch (alt112) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2218:2: selector
                    {
                    pushFollow(FOLLOW_selector_in_message_selector5464);
                    selector48=selector();

                    state._fsp--;
                    if (state.failed) return expression;

                    if ( state.backtracking==0 ) {expression.setMessageName(new Identifier((selector48!=null?input.toString(selector48.start,selector48.stop):null),IdentifierType.SELECTOR));}

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2219:4: ( keyword_argument )+
                    {
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2219:4: ( keyword_argument )+
                    int cnt111=0;
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==IDENTIFIER||LA111_0==54) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2220:3: keyword_argument
                    	    {
                    	    pushFollow(FOLLOW_keyword_argument_in_message_selector5475);
                    	    keyword_argument49=keyword_argument();

                    	    state._fsp--;
                    	    if (state.failed) return expression;

                    	    if ( state.backtracking==0 ) {expression.addParameter(keyword_argument49);}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt111 >= 1 ) break loop111;
                    	    if (state.backtracking>0) {state.failed=true; return expression;}
                                EarlyExitException eee =
                                    new EarlyExitException(111, input);
                                throw eee;
                        }
                        cnt111++;
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expression;
    }
    // $ANTLR end "message_selector"



    // $ANTLR start "keyword_argument"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2225:1: keyword_argument returns [Parameter parameter] : ( selector )? ':' expression ;
    public final Parameter keyword_argument() throws RecognitionException {
        Parameter parameter = null;


        ObjectiveCParser.selector_return selector50 =null;

        Expression expression51 =null;



        parameter =new Parameter(null,currentLineNumber);

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2230:2: ( ( selector )? ':' expression )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2231:2: ( selector )? ':' expression
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2231:2: ( selector )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==IDENTIFIER) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2232:3: selector
                    {
                    pushFollow(FOLLOW_selector_in_keyword_argument5507);
                    selector50=selector();

                    state._fsp--;
                    if (state.failed) return parameter;

                    if ( state.backtracking==0 ) {parameter.setSelector(new Identifier((selector50!=null?input.toString(selector50.start,selector50.stop):null),IdentifierType.SELECTOR));}

                    }
                    break;

            }


            match(input,54,FOLLOW_54_in_keyword_argument5516); if (state.failed) return parameter;

            pushFollow(FOLLOW_expression_in_keyword_argument5518);
            expression51=expression();

            state._fsp--;
            if (state.failed) return parameter;

            if ( state.backtracking==0 ) {parameter.setMessageCallingExpression(expression51);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return parameter;
    }
    // $ANTLR end "keyword_argument"



    // $ANTLR start "property_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2238:1: property_declaration : '@property' ( property_attributes_declaration )? ( 'IBOutlet' )? struct_declaration ;
    public final void property_declaration() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2239:2: ( '@property' ( property_attributes_declaration )? ( 'IBOutlet' )? struct_declaration )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2239:4: '@property' ( property_attributes_declaration )? ( 'IBOutlet' )? struct_declaration
            {
            match(input,75,FOLLOW_75_in_property_declaration5532); if (state.failed) return ;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2239:16: ( property_attributes_declaration )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==38) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2239:16: property_attributes_declaration
                    {
                    pushFollow(FOLLOW_property_attributes_declaration_in_property_declaration5534);
                    property_attributes_declaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2239:49: ( 'IBOutlet' )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==82) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2239:49: 'IBOutlet'
                    {
                    match(input,82,FOLLOW_82_in_property_declaration5537); if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_struct_declaration_in_property_declaration5540);
            struct_declaration();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "property_declaration"



    // $ANTLR start "property_attributes_declaration"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2242:1: property_attributes_declaration : '(' property_attributes_list ')' ;
    public final void property_attributes_declaration() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2243:5: ( '(' property_attributes_list ')' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2243:7: '(' property_attributes_list ')'
            {
            match(input,38,FOLLOW_38_in_property_attributes_declaration5557); if (state.failed) return ;

            pushFollow(FOLLOW_property_attributes_list_in_property_attributes_declaration5559);
            property_attributes_list();

            state._fsp--;
            if (state.failed) return ;

            match(input,39,FOLLOW_39_in_property_attributes_declaration5561); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "property_attributes_declaration"



    // $ANTLR start "property_attributes_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2246:1: property_attributes_list : ( property_attribute | property_attribute ( ',' property_attribute )* );
    public final void property_attributes_list() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2247:5: ( property_attribute | property_attribute ( ',' property_attribute )* )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==88||LA117_0==96||(LA117_0 >= 109 && LA117_0 <= 111)||LA117_0==113) ) {
                int LA117_1 = input.LA(2);

                if ( (synpred213_ObjectiveC()) ) {
                    alt117=1;
                }
                else if ( (true) ) {
                    alt117=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 117, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }
            switch (alt117) {
                case 1 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2247:7: property_attribute
                    {
                    pushFollow(FOLLOW_property_attribute_in_property_attributes_list5578);
                    property_attribute();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2248:7: property_attribute ( ',' property_attribute )*
                    {
                    pushFollow(FOLLOW_property_attribute_in_property_attributes_list5586);
                    property_attribute();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2248:26: ( ',' property_attribute )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==45) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2248:27: ',' property_attribute
                    	    {
                    	    match(input,45,FOLLOW_45_in_property_attributes_list5589); if (state.failed) return ;

                    	    pushFollow(FOLLOW_property_attribute_in_property_attributes_list5591);
                    	    property_attribute();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop116;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "property_attributes_list"



    // $ANTLR start "property_attribute"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2251:1: property_attribute : ( 'nonatomic' | 'readwrite' | 'readonly' | 'retain' | 'assign' | 'copy' );
    public final void property_attribute() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2252:5: ( 'nonatomic' | 'readwrite' | 'readonly' | 'retain' | 'assign' | 'copy' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:
            {
            if ( input.LA(1)==88||input.LA(1)==96||(input.LA(1) >= 109 && input.LA(1) <= 111)||input.LA(1)==113 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "property_attribute"



    // $ANTLR start "property_implementation"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2257:1: property_implementation : '@synthesize' property_synthesize_list ';' ;
    public final void property_implementation() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2258:5: ( '@synthesize' property_synthesize_list ';' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2258:7: '@synthesize' property_synthesize_list ';'
            {
            match(input,80,FOLLOW_80_in_property_implementation5652); if (state.failed) return ;

            pushFollow(FOLLOW_property_synthesize_list_in_property_implementation5654);
            property_synthesize_list();

            state._fsp--;
            if (state.failed) return ;

            match(input,55,FOLLOW_55_in_property_implementation5656); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "property_implementation"



    // $ANTLR start "property_synthesize_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2261:1: property_synthesize_list : property_synthesize_item ( ',' property_synthesize_item )* ;
    public final void property_synthesize_list() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2262:5: ( property_synthesize_item ( ',' property_synthesize_item )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2262:7: property_synthesize_item ( ',' property_synthesize_item )*
            {
            pushFollow(FOLLOW_property_synthesize_item_in_property_synthesize_list5673);
            property_synthesize_item();

            state._fsp--;
            if (state.failed) return ;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2262:32: ( ',' property_synthesize_item )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==45) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2262:33: ',' property_synthesize_item
            	    {
            	    match(input,45,FOLLOW_45_in_property_synthesize_list5676); if (state.failed) return ;

            	    pushFollow(FOLLOW_property_synthesize_item_in_property_synthesize_list5678);
            	    property_synthesize_item();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "property_synthesize_list"



    // $ANTLR start "property_synthesize_item"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2265:1: property_synthesize_item : identifier ;
    public final void property_synthesize_item() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2266:5: ( identifier )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2266:7: identifier
            {
            pushFollow(FOLLOW_identifier_in_property_synthesize_item5697);
            identifier();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "property_synthesize_item"



    // $ANTLR start "class_declaration_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2270:1: class_declaration_list : ( '@class' class_list ';' ) ;
    public final void class_declaration_list() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2270:23: ( ( '@class' class_list ';' ) )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2271:2: ( '@class' class_list ';' )
            {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2271:2: ( '@class' class_list ';' )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2271:3: '@class' class_list ';'
            {
            match(input,68,FOLLOW_68_in_class_declaration_list5716); if (state.failed) return ;

            pushFollow(FOLLOW_class_list_in_class_declaration_list5718);
            class_list();

            state._fsp--;
            if (state.failed) return ;

            match(input,55,FOLLOW_55_in_class_declaration_list5719); if (state.failed) return ;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "class_declaration_list"



    // $ANTLR start "class_list"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2274:1: class_list : class_name ( ',' class_name )* ;
    public final void class_list() throws RecognitionException {
        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2274:11: ( class_name ( ',' class_name )* )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2275:2: class_name ( ',' class_name )*
            {
            pushFollow(FOLLOW_class_name_in_class_list5730);
            class_name();

            state._fsp--;
            if (state.failed) return ;

            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2275:13: ( ',' class_name )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==45) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2275:14: ',' class_name
            	    {
            	    match(input,45,FOLLOW_45_in_class_list5733); if (state.failed) return ;

            	    pushFollow(FOLLOW_class_name_in_class_list5735);
            	    class_name();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "class_list"


    public static class identifier_return extends ParserRuleReturnScope {
        public Identifier identifier;
    };


    // $ANTLR start "identifier"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2289:1: identifier returns [ Identifier identifier ] : v= IDENTIFIER ;
    public final ObjectiveCParser.identifier_return identifier() throws RecognitionException {
        ObjectiveCParser.identifier_return retval = new ObjectiveCParser.identifier_return();
        retval.start = input.LT(1);


        Token v=null;

        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2291:3: (v= IDENTIFIER )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2291:3: v= IDENTIFIER
            {
            v=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier5832); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.identifier = new Identifier( input.toString(retval.start,input.LT(-1)) ); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "identifier"


    public static class constant_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "constant"
    // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2293:1: constant : ( DECIMAL_LITERAL | HEX_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | FLOATING_POINT_LITERAL );
    public final ObjectiveCParser.constant_return constant() throws RecognitionException {
        ObjectiveCParser.constant_return retval = new ObjectiveCParser.constant_return();
        retval.start = input.LT(1);


        try {
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2293:9: ( DECIMAL_LITERAL | HEX_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | FLOATING_POINT_LITERAL )
            // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:
            {
            if ( input.LA(1)==CHARACTER_LITERAL||input.LA(1)==DECIMAL_LITERAL||input.LA(1)==FLOATING_POINT_LITERAL||input.LA(1)==HEX_LITERAL||input.LA(1)==OCTAL_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constant"

    // $ANTLR start synpred2_ObjectiveC
    public final void synpred2_ObjectiveC_fragment() throws RecognitionException {
        ListDeclaration d =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:235:5: (d= declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:235:5: d= declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred2_ObjectiveC122);
        d=declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_ObjectiveC

    // $ANTLR start synpred6_ObjectiveC
    public final void synpred6_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:288:5: ( protocol_declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:288:5: protocol_declaration
        {
        pushFollow(FOLLOW_protocol_declaration_in_synpred6_ObjectiveC158);
        protocol_declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_ObjectiveC

    // $ANTLR start synpred10_ObjectiveC
    public final void synpred10_ObjectiveC_fragment() throws RecognitionException {
        Function fd =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:290:5: (fd= function_definition )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:290:5: fd= function_definition
        {
        pushFollow(FOLLOW_function_definition_in_synpred10_ObjectiveC182);
        fd=function_definition();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred10_ObjectiveC

    // $ANTLR start synpred11_ObjectiveC
    public final void synpred11_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:317:4: ( protocol_declaration_list )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:317:4: protocol_declaration_list
        {
        pushFollow(FOLLOW_protocol_declaration_list_in_synpred11_ObjectiveC189);
        protocol_declaration_list();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred11_ObjectiveC

    // $ANTLR start synpred35_ObjectiveC
    public final void synpred35_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:595:5: ( declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:595:5: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred35_ObjectiveC761);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred35_ObjectiveC

    // $ANTLR start synpred36_ObjectiveC
    public final void synpred36_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:596:5: ( class_method_declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:596:5: class_method_declaration
        {
        pushFollow(FOLLOW_class_method_declaration_in_synpred36_ObjectiveC774);
        class_method_declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred36_ObjectiveC

    // $ANTLR start synpred37_ObjectiveC
    public final void synpred37_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:597:5: ( instance_method_declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:597:5: instance_method_declaration
        {
        pushFollow(FOLLOW_instance_method_declaration_in_synpred37_ObjectiveC784);
        instance_method_declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred37_ObjectiveC

    // $ANTLR start synpred38_ObjectiveC
    public final void synpred38_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:598:5: ( property_declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:598:5: property_declaration
        {
        pushFollow(FOLLOW_property_declaration_in_synpred38_ObjectiveC792);
        property_declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred38_ObjectiveC

    // $ANTLR start synpred47_ObjectiveC
    public final void synpred47_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:762:5: ( function_definition )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:762:5: function_definition
        {
        pushFollow(FOLLOW_function_definition_in_synpred47_ObjectiveC1122);
        function_definition();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred47_ObjectiveC

    // $ANTLR start synpred48_ObjectiveC
    public final void synpred48_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:763:5: ( declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:763:5: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred48_ObjectiveC1132);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred48_ObjectiveC

    // $ANTLR start synpred60_ObjectiveC
    public final void synpred60_ObjectiveC_fragment() throws RecognitionException {
        ObjectiveCParser.declarator_return dec =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:912:4: ( (dec= declarator )? )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:912:4: (dec= declarator )?
        {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:912:4: (dec= declarator )?
        int alt121=2;
        int LA121_0 = input.LA(1);

        if ( (LA121_0==IDENTIFIER||LA121_0==40) ) {
            alt121=1;
        }
        switch (alt121) {
            case 1 :
                // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:913:5: dec= declarator
                {
                pushFollow(FOLLOW_declarator_in_synpred60_ObjectiveC1524);
                dec=declarator();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred60_ObjectiveC

    // $ANTLR start synpred75_ObjectiveC
    public final void synpred75_ObjectiveC_fragment() throws RecognitionException {
        ObjectiveCParser.declarator_return dec =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1084:3: (dec= declarator )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1084:3: dec= declarator
        {
        pushFollow(FOLLOW_declarator_in_synpred75_ObjectiveC2015);
        dec=declarator();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred75_ObjectiveC

    // $ANTLR start synpred96_ObjectiveC
    public final void synpred96_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:4: ( ( class_name ( protocol_reference_list )? ) )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:4: ( class_name ( protocol_reference_list )? )
        {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:4: ( class_name ( protocol_reference_list )? )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:5: class_name ( protocol_reference_list )?
        {
        pushFollow(FOLLOW_class_name_in_synpred96_ObjectiveC2306);
        class_name();

        state._fsp--;
        if (state.failed) return ;

        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:16: ( protocol_reference_list )?
        int alt129=2;
        int LA129_0 = input.LA(1);

        if ( (LA129_0==56) ) {
            alt129=1;
        }
        switch (alt129) {
            case 1 :
                // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1168:18: protocol_reference_list
                {
                pushFollow(FOLLOW_protocol_reference_list_in_synpred96_ObjectiveC2310);
                protocol_reference_list();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }

    }
    // $ANTLR end synpred96_ObjectiveC

    // $ANTLR start synpred128_ObjectiveC
    public final void synpred128_ObjectiveC_fragment() throws RecognitionException {
        ListDeclaration decl =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1493:7: (decl= declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1493:7: decl= declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred128_ObjectiveC3130);
        decl=declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred128_ObjectiveC

    // $ANTLR start synpred129_ObjectiveC
    public final void synpred129_ObjectiveC_fragment() throws RecognitionException {
        Expression exp =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1498:7: (exp= expression ';' )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1498:7: exp= expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred129_ObjectiveC3142);
        exp=expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,55,FOLLOW_55_in_synpred129_ObjectiveC3144); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred129_ObjectiveC

    // $ANTLR start synpred132_ObjectiveC
    public final void synpred132_ObjectiveC_fragment() throws RecognitionException {
        Statement label_stmt =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1501:7: (label_stmt= labeled_statement )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1501:7: label_stmt= labeled_statement
        {
        pushFollow(FOLLOW_labeled_statement_in_synpred132_ObjectiveC3179);
        label_stmt=labeled_statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_ObjectiveC

    // $ANTLR start synpred140_ObjectiveC
    public final void synpred140_ObjectiveC_fragment() throws RecognitionException {
        Statement stmtElse =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1568:6: ( 'else' stmtElse= statement )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1568:6: 'else' stmtElse= statement
        {
        match(input,100,FOLLOW_100_in_synpred140_ObjectiveC3483); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred140_ObjectiveC3492);
        stmtElse=statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred140_ObjectiveC

    // $ANTLR start synpred145_ObjectiveC
    public final void synpred145_ObjectiveC_fragment() throws RecognitionException {
        Expression e1 =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:12: ( (e1= expression )? ';' )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:12: (e1= expression )? ';'
        {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:12: (e1= expression )?
        int alt134=2;
        int LA134_0 = input.LA(1);

        if ( (LA134_0==CHARACTER_LITERAL||LA134_0==DECIMAL_LITERAL||LA134_0==FLOATING_POINT_LITERAL||LA134_0==HEX_LITERAL||LA134_0==IDENTIFIER||LA134_0==OCTAL_LITERAL||LA134_0==STRING_LITERAL||LA134_0==22||LA134_0==36||LA134_0==38||LA134_0==40||LA134_0==43||(LA134_0 >= 46 && LA134_0 <= 47)||LA134_0==67||LA134_0==83||LA134_0==115||LA134_0==118||LA134_0==135) ) {
            alt134=1;
        }
        switch (alt134) {
            case 1 :
                // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:13: e1= expression
                {
                pushFollow(FOLLOW_expression_in_synpred145_ObjectiveC3801);
                e1=expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,55,FOLLOW_55_in_synpred145_ObjectiveC3807); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred145_ObjectiveC

    // $ANTLR start synpred146_ObjectiveC
    public final void synpred146_ObjectiveC_fragment() throws RecognitionException {
        ListDeclaration decl =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:80: (decl= declaration )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1613:80: decl= declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred146_ObjectiveC3813);
        decl=declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred146_ObjectiveC

    // $ANTLR start synpred176_ObjectiveC
    public final void synpred176_ObjectiveC_fragment() throws RecognitionException {
        BinaryExpression expx =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1976:3: ( ( '<<' | '>>' ) expx= shift_expression )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:1976:3: ( '<<' | '>>' ) expx= shift_expression
        {
        if ( input.LA(1)==57||input.LA(1)==64 ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        pushFollow(FOLLOW_shift_expression_in_synpred176_ObjectiveC4761);
        expx=shift_expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred176_ObjectiveC

    // $ANTLR start synpred182_ObjectiveC
    public final void synpred182_ObjectiveC_fragment() throws RecognitionException {
        Expression c =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2068:2: ( '(' type_name ')' c= cast_expression )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2068:2: '(' type_name ')' c= cast_expression
        {
        match(input,38,FOLLOW_38_in_synpred182_ObjectiveC4936); if (state.failed) return ;

        pushFollow(FOLLOW_type_name_in_synpred182_ObjectiveC4938);
        type_name();

        state._fsp--;
        if (state.failed) return ;

        match(input,39,FOLLOW_39_in_synpred182_ObjectiveC4940); if (state.failed) return ;

        pushFollow(FOLLOW_cast_expression_in_synpred182_ObjectiveC4944);
        c=cast_expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred182_ObjectiveC

    // $ANTLR start synpred187_ObjectiveC
    public final void synpred187_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2086:14: ( '(' type_name ')' )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2086:14: '(' type_name ')'
        {
        match(input,38,FOLLOW_38_in_synpred187_ObjectiveC5031); if (state.failed) return ;

        pushFollow(FOLLOW_type_name_in_synpred187_ObjectiveC5033);
        type_name();

        state._fsp--;
        if (state.failed) return ;

        match(input,39,FOLLOW_39_in_synpred187_ObjectiveC5035); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred187_ObjectiveC

    // $ANTLR start synpred206_ObjectiveC
    public final void synpred206_ObjectiveC_fragment() throws RecognitionException {
        Expression exp =null;


        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2207:4: (exp= expression )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2207:4: exp= expression
        {
        pushFollow(FOLLOW_expression_in_synpred206_ObjectiveC5428);
        exp=expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred206_ObjectiveC

    // $ANTLR start synpred207_ObjectiveC
    public final void synpred207_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2208:4: ( class_name )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2208:4: class_name
        {
        pushFollow(FOLLOW_class_name_in_synpred207_ObjectiveC5434);
        class_name();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred207_ObjectiveC

    // $ANTLR start synpred213_ObjectiveC
    public final void synpred213_ObjectiveC_fragment() throws RecognitionException {
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2247:7: ( property_attribute )
        // /Users/zohaibrauf/Documents/workspace/ObjCFYPA/src/com/icona/antlr/main/ObjectiveC.g:2247:7: property_attribute
        {
        pushFollow(FOLLOW_property_attribute_in_synpred213_ObjectiveC5578);
        property_attribute();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred213_ObjectiveC

    // Delegated rules

    public final boolean synpred36_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred213_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred213_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred140_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred140_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred146_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred146_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred207_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred207_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred176_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred176_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred187_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred187_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred182_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred182_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred129_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred129_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred206_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred206_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred145_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred145_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_ObjectiveC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_ObjectiveC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_external_declaration_in_translation_unit77 = new BitSet(new long[]{0x00000001FE012020L,0xF9B11A68620220D0L,0x0000000000000001L});
    public static final BitSet FOLLOW_EOF_in_translation_unit86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_external_declaration122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_or_union_definition_in_external_declaration131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_interface_in_external_declaration139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_implementation_in_external_declaration147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocol_declaration_in_external_declaration158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_external_declaration166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_COMMENT_in_external_declaration170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_preprocessor_declaration_in_external_declaration174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_in_external_declaration182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocol_declaration_list_in_external_declaration189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_declaration_list_in_external_declaration194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_file_specification224 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_file_specification231 = new BitSet(new long[]{0x4014000001002000L,0x0000000000100000L});
    public static final BitSet FOLLOW_52_in_file_specification239 = new BitSet(new long[]{0x4000000001002000L});
    public static final BitSet FOLLOW_84_in_file_specification245 = new BitSet(new long[]{0x4000000001002000L});
    public static final BitSet FOLLOW_50_in_file_specification250 = new BitSet(new long[]{0x4000000001002000L});
    public static final BitSet FOLLOW_set_in_file_specification261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_macro_specification274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_class_name285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_superclass_name294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_preprocessor_declaration304 = new BitSet(new long[]{0x0100000001000000L});
    public static final BitSet FOLLOW_file_specification_in_preprocessor_declaration306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_preprocessor_declaration312 = new BitSet(new long[]{0x0100000001000000L});
    public static final BitSet FOLLOW_file_specification_in_preprocessor_declaration314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_preprocessor_declaration319 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_macro_specification_in_preprocessor_declaration321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_preprocessor_declaration325 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_preprocessor_declaration327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_preprocessor_declaration331 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_preprocessor_declaration333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_preprocessor_declaration337 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_preprocessor_declaration339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_preprocessor_declaration343 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_preprocessor_declaration345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_preprocessor_declaration349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interface_declaration_list_in_protocol_interface_declaration373 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862028900L,0x0000000000000001L});
    public static final BitSet FOLLOW_qualified_protocol_interface_declaration_in_protocol_interface_declaration382 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008100L});
    public static final BitSet FOLLOW_72_in_qualified_protocol_interface_declaration410 = new BitSet(new long[]{0x0000440000002000L,0xD0B11A6862020800L,0x0000000000000001L});
    public static final BitSet FOLLOW_interface_declaration_list_in_qualified_protocol_interface_declaration412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_qualified_protocol_interface_declaration422 = new BitSet(new long[]{0x0000440000002000L,0xD0B11A6862020800L,0x0000000000000001L});
    public static final BitSet FOLLOW_interface_declaration_list_in_qualified_protocol_interface_declaration424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_protocol_declaration453 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_protocol_name_in_protocol_declaration463 = new BitSet(new long[]{0x0140440000002000L,0xD0B11A6862028920L,0x0000000000000001L});
    public static final BitSet FOLLOW_54_in_protocol_declaration471 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_superclass_name_in_protocol_declaration473 = new BitSet(new long[]{0x0100440000002000L,0xD0B11A6862028920L,0x0000000000000001L});
    public static final BitSet FOLLOW_protocol_reference_list_in_protocol_declaration491 = new BitSet(new long[]{0x0000440000002000L,0xD0B11A6862028920L,0x0000000000000001L});
    public static final BitSet FOLLOW_protocol_interface_declaration_in_protocol_declaration503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_protocol_declaration510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_protocol_declaration_list524 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_protocol_list_in_protocol_declaration_list526 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_protocol_declaration_list527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_protocol_reference_list547 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_protocol_list_in_protocol_reference_list551 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_protocol_reference_list556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocol_name_in_protocol_list583 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_protocol_list589 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_protocol_name_in_protocol_list593 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_protocol_name618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_class_interface645 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_class_name_in_class_interface652 = new BitSet(new long[]{0x0140440000002000L,0xD0B11A6862020820L,0x0000000000000005L});
    public static final BitSet FOLLOW_54_in_class_interface667 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_superclass_name_in_class_interface669 = new BitSet(new long[]{0x0100440000002000L,0xD0B11A6862020820L,0x0000000000000005L});
    public static final BitSet FOLLOW_protocol_reference_list_in_class_interface686 = new BitSet(new long[]{0x0000440000002000L,0xD0B11A6862020820L,0x0000000000000005L});
    public static final BitSet FOLLOW_instance_variables_in_class_interface702 = new BitSet(new long[]{0x0000440000002000L,0xD0B11A6862020820L,0x0000000000000001L});
    public static final BitSet FOLLOW_interface_declaration_list_in_class_interface722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_class_interface736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_interface_declaration_list761 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862020800L,0x0000000000000001L});
    public static final BitSet FOLLOW_class_method_declaration_in_interface_declaration_list774 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862020800L,0x0000000000000001L});
    public static final BitSet FOLLOW_instance_method_declaration_in_interface_declaration_list784 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862020800L,0x0000000000000001L});
    public static final BitSet FOLLOW_property_declaration_in_interface_declaration_list792 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862020800L,0x0000000000000001L});
    public static final BitSet FOLLOW_42_in_class_method_declaration817 = new BitSet(new long[]{0x0040004000002000L});
    public static final BitSet FOLLOW_method_declaration_in_class_method_declaration819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_instance_method_declaration842 = new BitSet(new long[]{0x0040004000002000L});
    public static final BitSet FOLLOW_method_declaration_in_instance_method_declaration844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_type_in_method_declaration879 = new BitSet(new long[]{0x0040000000002000L});
    public static final BitSet FOLLOW_method_selector_in_method_declaration887 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_method_declaration892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_instance_variables912 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864025600L,0x0000000000000001L});
    public static final BitSet FOLLOW_instance_variable_declaration_in_instance_variables919 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_instance_variables924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_visibility_specification_in_instance_variable_declaration950 = new BitSet(new long[]{0x0000000000002002L,0xF1301A4864025600L,0x0000000000000001L});
    public static final BitSet FOLLOW_struct_declaration_in_instance_variable_declaration962 = new BitSet(new long[]{0x0000000000002002L,0xF1301A4864025600L,0x0000000000000001L});
    public static final BitSet FOLLOW_74_in_visibility_specification983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_visibility_specification990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_visibility_specification997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_visibility_specification1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_class_implementation1027 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_class_name_in_class_implementation1034 = new BitSet(new long[]{0x0040440000002000L,0xD0B11A6862030020L,0x0000000000000001L});
    public static final BitSet FOLLOW_54_in_class_implementation1050 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_superclass_name_in_class_implementation1052 = new BitSet(new long[]{0x0000440000002000L,0xD0B11A6862030020L,0x0000000000000001L});
    public static final BitSet FOLLOW_implementation_definition_list_in_class_implementation1078 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_class_implementation1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_in_implementation_definition_list1122 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862030000L,0x0000000000000001L});
    public static final BitSet FOLLOW_declaration_in_implementation_definition_list1132 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862030000L,0x0000000000000001L});
    public static final BitSet FOLLOW_class_method_definition_in_implementation_definition_list1143 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862030000L,0x0000000000000001L});
    public static final BitSet FOLLOW_instance_method_definition_in_implementation_definition_list1151 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862030000L,0x0000000000000001L});
    public static final BitSet FOLLOW_property_implementation_in_implementation_definition_list1158 = new BitSet(new long[]{0x0000440000002002L,0xD0B11A6862030000L,0x0000000000000001L});
    public static final BitSet FOLLOW_42_in_class_method_definition1185 = new BitSet(new long[]{0x0040004000002000L});
    public static final BitSet FOLLOW_method_definition_in_class_method_definition1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_instance_method_definition1216 = new BitSet(new long[]{0x0040004000002000L});
    public static final BitSet FOLLOW_method_definition_in_instance_method_definition1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_type_in_method_definition1250 = new BitSet(new long[]{0x0040000000002000L});
    public static final BitSet FOLLOW_method_selector_in_method_definition1260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_compound_statement_in_method_definition1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_method_selector1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyword_declarator_in_method_selector1316 = new BitSet(new long[]{0x0040000000002002L,0xD0B11A6862020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameter_list_in_method_selector1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_keyword_declarator1368 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_keyword_declarator1377 = new BitSet(new long[]{0x0000004000002000L});
    public static final BitSet FOLLOW_method_type_in_keyword_declarator1383 = new BitSet(new long[]{0x0000004000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_keyword_declarator1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_declaration_list_in_parameter_list1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_declaration_list1446 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_parameter_declaration_list1461 = new BitSet(new long[]{0x0000000000002000L,0xD0B11A6862020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_declaration_list1465 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_parameter_declaration1505 = new BitSet(new long[]{0x0000010000002002L,0x0000000000080000L});
    public static final BitSet FOLLOW_declarator_in_parameter_declaration1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstract_declarator_in_parameter_declaration1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_abstract_declarator1586 = new BitSet(new long[]{0x0000010000000000L,0x0000000040080000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_qualifier_in_abstract_declarator1588 = new BitSet(new long[]{0x0000010000000000L,0x0000000040080000L,0x0000000000000001L});
    public static final BitSet FOLLOW_abstract_declarator_in_abstract_declarator1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_abstract_declarator1625 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000280008L,0x0000000000000080L});
    public static final BitSet FOLLOW_constant_expression_in_abstract_declarator1639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_abstract_declarator1653 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_abstract_declarator_suffix1674 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000280008L,0x0000000000000080L});
    public static final BitSet FOLLOW_constant_expression_in_abstract_declarator_suffix1676 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_abstract_declarator_suffix1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_abstract_declarator_suffix1685 = new BitSet(new long[]{0x0000008000002000L,0xD0B11A6862020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameter_declaration_list_in_abstract_declarator_suffix1688 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_abstract_declarator_suffix1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selector1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_method_type1714 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_name_in_method_type1719 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_method_type1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_specifier_qualifier_list_in_type_name1747 = new BitSet(new long[]{0x0000010000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_abstract_declarator_in_type_name1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_struct_or_union_definition1790 = new BitSet(new long[]{0x0000000000000000L,0x2100000000000000L});
    public static final BitSet FOLLOW_set_in_struct_or_union_definition1796 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_struct_or_union_definition1809 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_struct_or_union_definition1815 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_struct_declaration_in_struct_or_union_definition1827 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000041L});
    public static final BitSet FOLLOW_134_in_struct_or_union_definition1838 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_struct_or_union_definition1843 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_struct_or_union_definition1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_struct_or_union_specifier1878 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_struct_or_union_specifier1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_specifier_qualifier_list_in_struct_declaration1920 = new BitSet(new long[]{0x0040010000002000L});
    public static final BitSet FOLLOW_struct_declarator_list_in_struct_declaration1929 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_struct_declaration1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_declarator_in_struct_declarator_list1965 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_struct_declarator_list1977 = new BitSet(new long[]{0x0040010000002000L});
    public static final BitSet FOLLOW_struct_declarator_in_struct_declarator_list1981 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_declarator_in_struct_declarator2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_struct_declarator2039 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_struct_declarator2048 = new BitSet(new long[]{0x0000000000020A50L});
    public static final BitSet FOLLOW_constant_in_struct_declarator2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_specifier_ivar_in_specifier_qualifier_list2087 = new BitSet(new long[]{0x0000000000000002L,0xF130184864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_qualifier_in_specifier_qualifier_list2104 = new BitSet(new long[]{0x0000000000000002L,0xF130184864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_specifier_class_in_specifier_qualifier_list2136 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_qualifier_in_specifier_qualifier_list2142 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_127_in_type_specifier_ivar2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_type_specifier_ivar2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_type_specifier_ivar2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_type_specifier_ivar2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_type_specifier_ivar2202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_type_specifier_ivar2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_type_specifier_ivar2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_type_specifier_ivar2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_type_specifier_ivar2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_type_specifier_ivar2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_type_specifier_ivar2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_type_specifier_ivar2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_or_union_specifier_in_type_specifier_ivar2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_type_specifier_class2289 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_protocol_reference_list_in_type_specifier_class2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_name_in_type_specifier_class2306 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_protocol_reference_list_in_type_specifier_class2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type_specifier_class2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_function_definition2357 = new BitSet(new long[]{0x0000010000002000L});
    public static final BitSet FOLLOW_declarator_in_function_definition2361 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_compound_statement_in_function_definition2369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_declaration2399 = new BitSet(new long[]{0x0080010000002000L});
    public static final BitSet FOLLOW_init_declarator_list_in_declaration2411 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_declaration2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_storage_class_specifier_in_declaration_specifiers2451 = new BitSet(new long[]{0x0000000000000002L,0xD0B1186862020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_specifier_in_declaration_specifiers2467 = new BitSet(new long[]{0x0000000000000002L,0xD0B1186862020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_qualifier_in_declaration_specifiers2482 = new BitSet(new long[]{0x0000000000000002L,0xD0B1186862020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_specifier_class_in_declaration_specifiers2499 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_qualifier_in_declaration_specifiers2505 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list2533 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_init_declarator_list2544 = new BitSet(new long[]{0x0000010000002000L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list2548 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_declarator_in_init_declarator2591 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_init_declarator2599 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000084L});
    public static final BitSet FOLLOW_initializer_in_init_declarator2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_initializer2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_initializer2650 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000084L});
    public static final BitSet FOLLOW_initializer_in_initializer2654 = new BitSet(new long[]{0x0000200000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_45_in_initializer2663 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000084L});
    public static final BitSet FOLLOW_initializer_in_initializer2667 = new BitSet(new long[]{0x0000200000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_initializer2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_declarator2709 = new BitSet(new long[]{0x0000010000002000L,0x0000000040000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_qualifier_in_declarator2711 = new BitSet(new long[]{0x0000010000002000L,0x0000000040000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_declarator_in_declarator2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_direct_declarator_in_declarator2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_direct_declarator2761 = new BitSet(new long[]{0x0000004000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_declarator_suffix_in_direct_declarator2780 = new BitSet(new long[]{0x0000004000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_declarator_suffix2825 = new BitSet(new long[]{0x0000000000020A50L,0x0000000000200000L});
    public static final BitSet FOLLOW_constant_in_declarator_suffix2837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_declarator_suffix2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_declarator_suffix2870 = new BitSet(new long[]{0x0000008000002000L,0xD0B11A6862020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parameter_list_in_declarator_suffix2880 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_declarator_suffix2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_type_specifier2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_type_specifier2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_type_specifier2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_type_specifier2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_type_specifier2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_type_specifier2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_type_specifier2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_type_specifier2976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_type_specifier2983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_type_specifier2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_type_specifier2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_type_qualifier3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_type_qualifier3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_storage_class_specifier3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_storage_class_specifier3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_storage_class_specifier3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_storage_class_specifier3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selection_statement_in_statement3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement3142 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_statement3144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_statement3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iteration_statement_in_statement3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labeled_statement_in_statement3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jump_statement_in_statement3191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_jump_statement3221 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_identifier_in_jump_statement3223 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_jump_statement3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_jump_statement3232 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_jump_statement3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_jump_statement3242 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_jump_statement3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_jump_statement3252 = new BitSet(new long[]{0x0080C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_jump_statement3269 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_jump_statement3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_labeled_statement3308 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_labeled_statement3317 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_labeled_statement3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_labeled_statement3350 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_constant_expression_in_labeled_statement3363 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_labeled_statement3373 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_labeled_statement3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_labeled_statement3398 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_labeled_statement3406 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_labeled_statement3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_selection_statement3448 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_selection_statement3450 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_selection_statement3458 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_selection_statement3467 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_selection_statement3475 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_selection_statement3483 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_selection_statement3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_selection_statement3511 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_selection_statement3520 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_selection_statement3538 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_selection_statement3557 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_selection_statement3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_iteration_statement3601 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_iteration_statement3612 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_iteration_statement3627 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_iteration_statement3635 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_iteration_statement3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_iteration_statement3659 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_iteration_statement3677 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_iteration_statement3690 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_iteration_statement3703 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_iteration_statement3719 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_iteration_statement3733 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_iteration_statement3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_iteration_statement3765 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_iteration_statement3777 = new BitSet(new long[]{0x0080C950004A2A50L,0xD0F91A68620A0008L,0x0000000000000081L});
    public static final BitSet FOLLOW_expression_in_iteration_statement3801 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_iteration_statement3807 = new BitSet(new long[]{0x0080C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_declaration_in_iteration_statement3813 = new BitSet(new long[]{0x0080C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_iteration_statement3846 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_iteration_statement3862 = new BitSet(new long[]{0x0000C9D0004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_iteration_statement3879 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_iteration_statement3894 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_iteration_statement3909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_compound_statement3939 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x00000000000000C7L});
    public static final BitSet FOLLOW_statement_list_in_compound_statement3953 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_compound_statement3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list3991 = new BitSet(new long[]{0x0080C950004A2A52L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_assignment_expression_in_expression4025 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_expression4036 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_assignment_expression_in_expression4040 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_conditional_expression_in_assignment_expression4070 = new BitSet(new long[]{0x1421122400000002L,0x0000000000800002L,0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_operator_in_assignment_expression4086 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_assignment_expression_in_assignment_expression4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_assignment_operator4127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_assignment_operator4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_assignment_operator4141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_assignment_operator4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_assignment_operator4155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_assignment_operator4162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_assignment_operator4169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_assignment_operator4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_assignment_operator4183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_assignment_operator4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_assignment_operator4197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_or_expression_in_conditional_expression4224 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_conditional_expression4235 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_logical_or_expression_in_conditional_expression4239 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_conditional_expression4248 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_logical_or_expression_in_conditional_expression4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_expression_in_constant_expression4279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression4302 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_logical_or_expression4313 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression4325 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression4353 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_logical_and_expression4362 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression4373 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression4403 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_inclusive_or_expression4414 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression4426 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression4456 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_exclusive_or_expression4467 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression4479 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_equality_expression_in_and_expression4509 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_and_expression4520 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_equality_expression_in_and_expression4531 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression4561 = new BitSet(new long[]{0x2000000000800002L});
    public static final BitSet FOLLOW_23_in_equality_expression4578 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_61_in_equality_expression4588 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression4605 = new BitSet(new long[]{0x2000000000800002L});
    public static final BitSet FOLLOW_shift_expression_in_relational_expression4632 = new BitSet(new long[]{0xC900000000000002L});
    public static final BitSet FOLLOW_56_in_relational_expression4647 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_62_in_relational_expression4657 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_59_in_relational_expression4667 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_63_in_relational_expression4677 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_shift_expression_in_relational_expression4694 = new BitSet(new long[]{0xC900000000000002L});
    public static final BitSet FOLLOW_additive_expression_in_shift_expression4720 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_57_in_shift_expression4735 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_64_in_shift_expression4745 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_shift_expression_in_shift_expression4761 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression4788 = new BitSet(new long[]{0x0000440000000002L});
    public static final BitSet FOLLOW_42_in_additive_expression4803 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_46_in_additive_expression4812 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression4828 = new BitSet(new long[]{0x0000440000000002L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression4855 = new BitSet(new long[]{0x0010010200000002L});
    public static final BitSet FOLLOW_40_in_multiplicative_expression4869 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_52_in_multiplicative_expression4879 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_33_in_multiplicative_expression4889 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression4905 = new BitSet(new long[]{0x0010010200000002L});
    public static final BitSet FOLLOW_38_in_cast_expression4936 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_name_in_cast_expression4938 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_cast_expression4940 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_cast_expression_in_cast_expression4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_expression_in_cast_expression4955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfix_expression_in_unary_expression4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_unary_expression4991 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_unary_expression_in_unary_expression4995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_unary_expression5003 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_unary_expression_in_unary_expression5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_operator_in_unary_expression5017 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_cast_expression_in_unary_expression5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_unary_expression5028 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_38_in_unary_expression5031 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_name_in_unary_expression5033 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_unary_expression5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_expression_in_unary_expression5039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_unary_operator5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_unary_operator5070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_unary_operator5077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_unary_operator5084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_unary_operator5091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_postfix_expression5117 = new BitSet(new long[]{0x0006884000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_postfix_expression5134 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_postfix_expression5138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_postfix_expression5140 = new BitSet(new long[]{0x0006884000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_38_in_postfix_expression5151 = new BitSet(new long[]{0x0000C9D0004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_argument_expression_list_in_postfix_expression5165 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_postfix_expression5181 = new BitSet(new long[]{0x0006884000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_50_in_postfix_expression5193 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_identifier_in_postfix_expression5197 = new BitSet(new long[]{0x0006884000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_49_in_postfix_expression5209 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_identifier_in_postfix_expression5213 = new BitSet(new long[]{0x0006884000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_43_in_postfix_expression5220 = new BitSet(new long[]{0x0006884000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_47_in_postfix_expression5228 = new BitSet(new long[]{0x0006884000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list5260 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_argument_expression_list5269 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list5278 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression5309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primary_expression5318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primary_expression5326 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_primary_expression5332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_primary_expression5340 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_primary_expression5344 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_primary_expression5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_message_expression_in_primary_expression5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_primary_expression5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_message_expression5389 = new BitSet(new long[]{0x0000C950004A2A50L,0x0248000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_receiver_in_message_expression5396 = new BitSet(new long[]{0x0040000000002000L});
    public static final BitSet FOLLOW_message_selector_in_message_expression5402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_message_expression5407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_receiver5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_name_in_receiver5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_receiver5442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_message_selector5464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyword_argument_in_message_selector5475 = new BitSet(new long[]{0x0040000000002002L});
    public static final BitSet FOLLOW_selector_in_keyword_argument5507 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_keyword_argument5516 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_expression_in_keyword_argument5518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_property_declaration5532 = new BitSet(new long[]{0x0000004000002000L,0xF1301A4864060000L,0x0000000000000001L});
    public static final BitSet FOLLOW_property_attributes_declaration_in_property_declaration5534 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864060000L,0x0000000000000001L});
    public static final BitSet FOLLOW_82_in_property_declaration5537 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_struct_declaration_in_property_declaration5540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_property_attributes_declaration5557 = new BitSet(new long[]{0x0000000000000000L,0x0002E00101000000L});
    public static final BitSet FOLLOW_property_attributes_list_in_property_attributes_declaration5559 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_property_attributes_declaration5561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_attribute_in_property_attributes_list5578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_attribute_in_property_attributes_list5586 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_property_attributes_list5589 = new BitSet(new long[]{0x0000000000000000L,0x0002E00101000000L});
    public static final BitSet FOLLOW_property_attribute_in_property_attributes_list5591 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_80_in_property_implementation5652 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_property_synthesize_list_in_property_implementation5654 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_property_implementation5656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_synthesize_item_in_property_synthesize_list5673 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_property_synthesize_list5676 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_property_synthesize_item_in_property_synthesize_list5678 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_identifier_in_property_synthesize_item5697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_class_declaration_list5716 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_class_list_in_class_declaration_list5718 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_class_declaration_list5719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_name_in_class_list5730 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_class_list5733 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_class_name_in_class_list5735 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifier5832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred2_ObjectiveC122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocol_declaration_in_synpred6_ObjectiveC158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_in_synpred10_ObjectiveC182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocol_declaration_list_in_synpred11_ObjectiveC189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred35_ObjectiveC761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_method_declaration_in_synpred36_ObjectiveC774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instance_method_declaration_in_synpred37_ObjectiveC784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_declaration_in_synpred38_ObjectiveC792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_definition_in_synpred47_ObjectiveC1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred48_ObjectiveC1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_synpred60_ObjectiveC1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_synpred75_ObjectiveC2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_name_in_synpred96_ObjectiveC2306 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_protocol_reference_list_in_synpred96_ObjectiveC2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred128_ObjectiveC3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred129_ObjectiveC3142 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_synpred129_ObjectiveC3144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labeled_statement_in_synpred132_ObjectiveC3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_synpred140_ObjectiveC3483 = new BitSet(new long[]{0x0080C950004A2A50L,0xD4FD1FEEFA0A0008L,0x0000000000000087L});
    public static final BitSet FOLLOW_statement_in_synpred140_ObjectiveC3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred145_ObjectiveC3801 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_synpred145_ObjectiveC3807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred146_ObjectiveC3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred176_ObjectiveC4730 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_shift_expression_in_synpred176_ObjectiveC4761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred182_ObjectiveC4936 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_name_in_synpred182_ObjectiveC4938 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred182_ObjectiveC4940 = new BitSet(new long[]{0x0000C950004A2A50L,0x0048000000080008L,0x0000000000000080L});
    public static final BitSet FOLLOW_cast_expression_in_synpred182_ObjectiveC4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred187_ObjectiveC5031 = new BitSet(new long[]{0x0000000000002000L,0xF1301A4864020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_name_in_synpred187_ObjectiveC5033 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred187_ObjectiveC5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred206_ObjectiveC5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_class_name_in_synpred207_ObjectiveC5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_attribute_in_synpred213_ObjectiveC5578 = new BitSet(new long[]{0x0000000000000002L});

}