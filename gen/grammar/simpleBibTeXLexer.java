// Generated from java-escape by ANTLR 4.11.1
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class simpleBibTeXLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, QuotedContent=5, BracedContent=6, StringType=7, 
		PreambleType=8, CommentType=9, Type=10, Name=11, Number=12, INACTIVE=13, 
		Spaces=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "QuotedContent", "BracedContent", "StringType", 
			"PreambleType", "CommentType", "Type", "Name", "Number", "INACTIVE", 
			"Spaces", "Letter", "Digit", "SP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'}'", "'='", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "QuotedContent", "BracedContent", "StringType", 
			"PreambleType", "CommentType", "Type", "Name", "Number", "INACTIVE", 
			"Spaces"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public simpleBibTeXLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "simpleBibTeX.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000e\u009e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"1\b\u0004\n\u0004\f\u00044\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005=\b\u0005"+
		"\n\u0005\f\u0005@\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006L\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007Z\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\bg\b\b\u0001\b\u0001\b\u0001\b\u0005\bl\b\b\n\b\f\bo\t\b\u0003"+
		"\bq\b\b\u0001\t\u0001\t\u0004\tu\b\t\u000b\t\f\tv\u0001\t\u0003\tz\b\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u0080\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u0085\b\n\n\n\f\n\u0088\t\n\u0001\u000b\u0004\u000b\u008b\b"+
		"\u000b\u000b\u000b\f\u000b\u008c\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0003\u000e\u0096\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0004\u0010\u009b\b\u0010\u000b\u0010\f\u0010\u009c\u0000"+
		"\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u0000\u001f\u0000!\u0000\u0001\u0000\u0016\u0004\u0000\""+
		"\"\\\\{{}}\u0003\u0000\\\\{{}}\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000"+
		"RRrr\u0002\u0000IIii\u0002\u0000NNnn\u0002\u0000GGgg\u0002\u0000PPpp\u0002"+
		"\u0000EEee\u0002\u0000AAaa\u0002\u0000MMmm\u0002\u0000BBbb\u0002\u0000"+
		"LLll\u0002\u0000CCcc\u0002\u0000OOoo\u0002\u0000\n\n\r\r\u0004\u0000+"+
		"+-/::__\u0002\u0000--__\u0002\u0000AZaz\u0001\u000009\u0003\u0000\t\n"+
		"\f\r  \u00ad\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0001#\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0005\'"+
		"\u0001\u0000\u0000\u0000\u0007)\u0001\u0000\u0000\u0000\t+\u0001\u0000"+
		"\u0000\u0000\u000b7\u0001\u0000\u0000\u0000\rC\u0001\u0000\u0000\u0000"+
		"\u000fO\u0001\u0000\u0000\u0000\u0011p\u0001\u0000\u0000\u0000\u0013r"+
		"\u0001\u0000\u0000\u0000\u0015\u007f\u0001\u0000\u0000\u0000\u0017\u008a"+
		"\u0001\u0000\u0000\u0000\u0019\u008e\u0001\u0000\u0000\u0000\u001b\u0090"+
		"\u0001\u0000\u0000\u0000\u001d\u0095\u0001\u0000\u0000\u0000\u001f\u0097"+
		"\u0001\u0000\u0000\u0000!\u009a\u0001\u0000\u0000\u0000#$\u0005,\u0000"+
		"\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005}\u0000\u0000&\u0004\u0001"+
		"\u0000\u0000\u0000\'(\u0005=\u0000\u0000(\u0006\u0001\u0000\u0000\u0000"+
		")*\u0005#\u0000\u0000*\b\u0001\u0000\u0000\u0000+2\u0005\"\u0000\u0000"+
		",1\b\u0000\u0000\u0000-.\u0005\\\u0000\u0000.1\t\u0000\u0000\u0000/1\u0003"+
		"\u000b\u0005\u00000,\u0001\u0000\u0000\u00000-\u0001\u0000\u0000\u0000"+
		"0/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000056\u0005\"\u0000\u00006\n\u0001\u0000\u0000\u00007>\u0005"+
		"{\u0000\u00008=\b\u0001\u0000\u00009:\u0005\\\u0000\u0000:=\t\u0000\u0000"+
		"\u0000;=\u0003\u000b\u0005\u0000<8\u0001\u0000\u0000\u0000<9\u0001\u0000"+
		"\u0000\u0000<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000AB\u0005}\u0000\u0000B\f\u0001\u0000\u0000\u0000"+
		"CD\u0005@\u0000\u0000DE\u0007\u0002\u0000\u0000EF\u0007\u0003\u0000\u0000"+
		"FG\u0007\u0004\u0000\u0000GH\u0007\u0005\u0000\u0000HI\u0007\u0006\u0000"+
		"\u0000IK\u0007\u0007\u0000\u0000JL\u0003!\u0010\u0000KJ\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0005{\u0000"+
		"\u0000N\u000e\u0001\u0000\u0000\u0000OP\u0005@\u0000\u0000PQ\u0007\b\u0000"+
		"\u0000QR\u0007\u0004\u0000\u0000RS\u0007\t\u0000\u0000ST\u0007\n\u0000"+
		"\u0000TU\u0007\u000b\u0000\u0000UV\u0007\f\u0000\u0000VW\u0007\r\u0000"+
		"\u0000WY\u0007\t\u0000\u0000XZ\u0003!\u0010\u0000YX\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0005{\u0000"+
		"\u0000\\\u0010\u0001\u0000\u0000\u0000]^\u0005@\u0000\u0000^_\u0007\u000e"+
		"\u0000\u0000_`\u0007\u000f\u0000\u0000`a\u0007\u000b\u0000\u0000ab\u0007"+
		"\u000b\u0000\u0000bc\u0007\t\u0000\u0000cd\u0007\u0006\u0000\u0000df\u0007"+
		"\u0003\u0000\u0000eg\u0003!\u0010\u0000fe\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hq\u0003\u000b\u0005\u0000"+
		"im\u0005%\u0000\u0000jl\b\u0010\u0000\u0000kj\u0001\u0000\u0000\u0000"+
		"lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000p]\u0001\u0000"+
		"\u0000\u0000pi\u0001\u0000\u0000\u0000q\u0012\u0001\u0000\u0000\u0000"+
		"rt\u0005@\u0000\u0000su\u0003\u001d\u000e\u0000ts\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wy\u0001\u0000\u0000\u0000xz\u0003!\u0010\u0000yx\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0005{\u0000"+
		"\u0000|\u0014\u0001\u0000\u0000\u0000}\u0080\u0003\u001d\u000e\u0000~"+
		"\u0080\u0003\u001f\u000f\u0000\u007f}\u0001\u0000\u0000\u0000\u007f~\u0001"+
		"\u0000\u0000\u0000\u0080\u0086\u0001\u0000\u0000\u0000\u0081\u0085\u0003"+
		"\u001d\u000e\u0000\u0082\u0085\u0003\u001f\u000f\u0000\u0083\u0085\u0007"+
		"\u0011\u0000\u0000\u0084\u0081\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0088\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0016\u0001\u0000\u0000\u0000\u0088\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u008b\u0003\u001f\u000f\u0000\u008a\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0018\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0007\u0012\u0000\u0000\u008f\u001a\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0003!\u0010\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0006\r\u0000\u0000\u0093\u001c\u0001\u0000\u0000"+
		"\u0000\u0094\u0096\u0007\u0013\u0000\u0000\u0095\u0094\u0001\u0000\u0000"+
		"\u0000\u0096\u001e\u0001\u0000\u0000\u0000\u0097\u0098\u0007\u0014\u0000"+
		"\u0000\u0098 \u0001\u0000\u0000\u0000\u0099\u009b\u0007\u0015\u0000\u0000"+
		"\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\"\u0001\u0000\u0000\u0000\u0012\u000002<>KYfmpvy\u007f\u0084\u0086"+
		"\u008c\u0095\u009c\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}