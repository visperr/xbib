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
		PreambleType=8, CommentType=9, Type=10, Name=11, Number=12, Spaces=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "QuotedContent", "BracedContent", "StringType", 
			"PreambleType", "CommentType", "Type", "Name", "Number", "Spaces", "Letter", 
			"Digit", "SP"
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
			"PreambleType", "CommentType", "Type", "Name", "Number", "Spaces"
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
		"\u0004\u0000\r\u0097\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004/\b\u0004\n\u0004\f\u00042\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005;\b\u0005\n\u0005\f\u0005>\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006J\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007X\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\be\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\bj\b\b\n\b\f\bm\t\b\u0003\bo\b\b\u0001\t\u0001\t\u0004"+
		"\ts\b\t\u000b\t\f\tt\u0001\t\u0003\tx\b\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0080\b\n\n\n\f\n\u0083\t\n\u0001\u000b\u0004"+
		"\u000b\u0086\b\u000b\u000b\u000b\f\u000b\u0087\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0003\r\u008f\b\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0004\u000f\u0094\b\u000f\u000b\u000f\f\u000f\u0095\u0000\u0000\u0010"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u0000"+
		"\u001d\u0000\u001f\u0000\u0001\u0000\u0015\u0004\u0000\"\"\\\\{{}}\u0003"+
		"\u0000\\\\{{}}\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000RRrr\u0002\u0000"+
		"IIii\u0002\u0000NNnn\u0002\u0000GGgg\u0002\u0000PPpp\u0002\u0000EEee\u0002"+
		"\u0000AAaa\u0002\u0000MMmm\u0002\u0000BBbb\u0002\u0000LLll\u0002\u0000"+
		"CCcc\u0002\u0000OOoo\u0002\u0000\n\n\r\r\u0003\u0000--::__\u0002\u0000"+
		"AZaz\u0001\u000009\u0003\u0000\t\n\f\r  \u00a5\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0001!\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005%"+
		"\u0001\u0000\u0000\u0000\u0007\'\u0001\u0000\u0000\u0000\t)\u0001\u0000"+
		"\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\rA\u0001\u0000\u0000\u0000"+
		"\u000fM\u0001\u0000\u0000\u0000\u0011n\u0001\u0000\u0000\u0000\u0013p"+
		"\u0001\u0000\u0000\u0000\u0015{\u0001\u0000\u0000\u0000\u0017\u0085\u0001"+
		"\u0000\u0000\u0000\u0019\u0089\u0001\u0000\u0000\u0000\u001b\u008e\u0001"+
		"\u0000\u0000\u0000\u001d\u0090\u0001\u0000\u0000\u0000\u001f\u0093\u0001"+
		"\u0000\u0000\u0000!\"\u0005,\u0000\u0000\"\u0002\u0001\u0000\u0000\u0000"+
		"#$\u0005}\u0000\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0005=\u0000\u0000"+
		"&\u0006\u0001\u0000\u0000\u0000\'(\u0005#\u0000\u0000(\b\u0001\u0000\u0000"+
		"\u0000)0\u0005\"\u0000\u0000*/\b\u0000\u0000\u0000+,\u0005\\\u0000\u0000"+
		",/\t\u0000\u0000\u0000-/\u0003\u000b\u0005\u0000.*\u0001\u0000\u0000\u0000"+
		".+\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000"+
		"\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000"+
		"\u0000\u000020\u0001\u0000\u0000\u000034\u0005\"\u0000\u00004\n\u0001"+
		"\u0000\u0000\u00005<\u0005{\u0000\u00006;\b\u0001\u0000\u000078\u0005"+
		"\\\u0000\u00008;\t\u0000\u0000\u00009;\u0003\u000b\u0005\u0000:6\u0001"+
		"\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000"+
		";>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000"+
		"\u0000=?\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005}\u0000"+
		"\u0000@\f\u0001\u0000\u0000\u0000AB\u0005@\u0000\u0000BC\u0007\u0002\u0000"+
		"\u0000CD\u0007\u0003\u0000\u0000DE\u0007\u0004\u0000\u0000EF\u0007\u0005"+
		"\u0000\u0000FG\u0007\u0006\u0000\u0000GI\u0007\u0007\u0000\u0000HJ\u0003"+
		"\u001f\u000f\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KL\u0005{\u0000\u0000L\u000e\u0001\u0000\u0000"+
		"\u0000MN\u0005@\u0000\u0000NO\u0007\b\u0000\u0000OP\u0007\u0004\u0000"+
		"\u0000PQ\u0007\t\u0000\u0000QR\u0007\n\u0000\u0000RS\u0007\u000b\u0000"+
		"\u0000ST\u0007\f\u0000\u0000TU\u0007\r\u0000\u0000UW\u0007\t\u0000\u0000"+
		"VX\u0003\u001f\u000f\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000YZ\u0005{\u0000\u0000Z\u0010\u0001\u0000"+
		"\u0000\u0000[\\\u0005@\u0000\u0000\\]\u0007\u000e\u0000\u0000]^\u0007"+
		"\u000f\u0000\u0000^_\u0007\u000b\u0000\u0000_`\u0007\u000b\u0000\u0000"+
		"`a\u0007\t\u0000\u0000ab\u0007\u0006\u0000\u0000bd\u0007\u0003\u0000\u0000"+
		"ce\u0003\u001f\u000f\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000fo\u0003\u000b\u0005\u0000gk\u0005%\u0000"+
		"\u0000hj\b\u0010\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lo\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000n[\u0001\u0000\u0000\u0000ng\u0001"+
		"\u0000\u0000\u0000o\u0012\u0001\u0000\u0000\u0000pr\u0005@\u0000\u0000"+
		"qs\u0003\u001b\r\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000"+
		"\u0000vx\u0003\u001f\u000f\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005{\u0000\u0000z\u0014\u0001"+
		"\u0000\u0000\u0000{\u0081\u0003\u001b\r\u0000|\u0080\u0003\u001b\r\u0000"+
		"}\u0080\u0003\u001d\u000e\u0000~\u0080\u0007\u0011\u0000\u0000\u007f|"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f~\u0001\u0000"+
		"\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0016\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0086\u0003\u001d"+
		"\u000e\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000"+
		"\u0000\u0000\u0088\u0018\u0001\u0000\u0000\u0000\u0089\u008a\u0003\u001f"+
		"\u000f\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0006\f\u0000"+
		"\u0000\u008c\u001a\u0001\u0000\u0000\u0000\u008d\u008f\u0007\u0012\u0000"+
		"\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u001c\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0007\u0013\u0000\u0000\u0091\u001e\u0001\u0000\u0000"+
		"\u0000\u0092\u0094\u0007\u0014\u0000\u0000\u0093\u0092\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096 \u0001\u0000\u0000\u0000"+
		"\u0011\u0000.0:<IWdkntw\u007f\u0081\u0087\u008e\u0095\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}