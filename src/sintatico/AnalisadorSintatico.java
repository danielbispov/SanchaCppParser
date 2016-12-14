package sintatico;/* Generated By:JavaCC: Do not edit this line. AnalisadorSintatico.java */
import java.io.*;

public class AnalisadorSintatico implements AnalisadorSintaticoConstants {

  public static String SintaticoStart(String address) throws ParseException, FileNotFoundException {

    AnalisadorSintatico expressao = new AnalisadorSintatico(new FileInputStream(address));

    try {
      switch (expressao.inicial()) {
        case 0 :
          return "Sintaxe correta!";
        case 1 :
          return "ERRO:::sint\u00e1tico";
        default :
          break;
      }
    }catch (ParseException parse) {
      return "Erro sint\u00e1tico::: pr\u00f3ximo ao [token #" + expressao.getNextToken() + "] \u005cnEntendendo erro::: " + parse.getMessage();
    }

    return "Ops! :)";

  }

//Iniciando analisador sintático
  final public int inicial() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CARACTER:
    case INTEIRO:
    case REAL:
    case VAZIO:
    case IDENTIFICADOR:
      atribuicao();
                   {if (true) return 0;}
      break;
    case SE:
      condicao();
                 {if (true) return 0;}
      break;
    case FAZER:
    case PARA:
      repeticao();
                  {if (true) return 0;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void atribuicao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CARACTER:
    case INTEIRO:
    case REAL:
    case VAZIO:
      tipo();
      jj_consume_token(IDENTIFICADOR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUAL:
        label_1:
        while (true) {
          jj_consume_token(IGUAL);
          aritmetico();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case IGUAL:
            ;
            break;
          default:
            jj_la1[1] = jj_gen;
            break label_1;
          }
        }
        jj_consume_token(PONTOVIRGULA);
        break;
      case EPARENTESE:
        jj_consume_token(EPARENTESE);
        jj_consume_token(DPARENTESE);
        jj_consume_token(ECHAVE);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PARA:
          para();
          break;
        case CARACTER:
        case INTEIRO:
        case REAL:
        case VAZIO:
        case RETORNO:
        case QUEBRAR:
        case IDENTIFICADOR:
          bloco();
          break;
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(DCHAVE);
        break;
      case PONTOVIRGULA:
        jj_consume_token(PONTOVIRGULA);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCREMENTA:
      case DECREMENTA:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INCREMENTA:
          jj_consume_token(INCREMENTA);
          break;
        case DECREMENTA:
          jj_consume_token(DECREMENTA);
          break;
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        label_2:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PONTOVIRGULA:
            ;
            break;
          default:
            jj_la1[5] = jj_gen;
            break label_2;
          }
          jj_consume_token(PONTOVIRGULA);
        }
        break;
      case NUMEROINTEIRO:
      case NUMEROREAL:
        aritmetico();
        jj_consume_token(PONTOVIRGULA);
        break;
      case IDENTIFICADOR:
        atribuirfuncao();
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void condicao() throws ParseException {
    jj_consume_token(SE);
    jj_consume_token(EPARENTESE);
    comparacao();
    jj_consume_token(DPARENTESE);
    jj_consume_token(ECHAVE);
    bloco();
    jj_consume_token(DCHAVE);
  }

  final public void para() throws ParseException {
    jj_consume_token(PARA);
    jj_consume_token(EPARENTESE);
    atribuicao();
    comparacao();
    atribuicao();
    jj_consume_token(DPARENTESE);
    jj_consume_token(ECHAVE);
    bloco();
    jj_consume_token(DCHAVE);
  }

  final public void facaenquanto() throws ParseException {
    jj_consume_token(FAZER);
    jj_consume_token(ECHAVE);
    bloco();
    jj_consume_token(DCHAVE);
    jj_consume_token(ENQUANTO);
    jj_consume_token(EPARENTESE);
    comparacao();
    jj_consume_token(DPARENTESE);
  }

  final public void repeticao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PARA:
      para();
      break;
    case FAZER:
      facaenquanto();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void tipo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CARACTER:
      jj_consume_token(CARACTER);
      break;
    case INTEIRO:
      jj_consume_token(INTEIRO);
      break;
    case REAL:
      jj_consume_token(REAL);
      break;
    case VAZIO:
      jj_consume_token(VAZIO);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void atribuirfuncao() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MENORMENOR:
      jj_consume_token(MENORMENOR);
      break;
    case MAIORMAIOR:
      jj_consume_token(MAIORMAIOR);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(ASPAS);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_3;
      }
      jj_consume_token(IDENTIFICADOR);
    }
    jj_consume_token(ASPAS);
    jj_consume_token(PONTOVIRGULA);
  }

  final public void comparacao() throws ParseException {
    atcond();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAIOR:
      jj_consume_token(MAIOR);
      atcond();
      break;
    case MENOR:
      jj_consume_token(MENOR);
      atcond();
      break;
    case IGUALIGUAL:
      jj_consume_token(IGUALIGUAL);
      atcond();
      break;
    case MAIORIGUAL:
      jj_consume_token(MAIORIGUAL);
      atcond();
      break;
    case MENORIGUAL:
      jj_consume_token(MENORIGUAL);
      atcond();
      break;
    case DIFERENTE:
      jj_consume_token(DIFERENTE);
      atcond();
      break;
    case SE:
      condicao();
      jj_consume_token(ELOGICO);
      condicao();
      break;
    case OULOGICO:
      jj_consume_token(OULOGICO);
      condicao();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PONTOVIRGULA:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_4;
      }
      jj_consume_token(PONTOVIRGULA);
    }
  }

  final public void atcond() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case NUMEROINTEIRO:
    case NUMEROREAL:
      expressao();
      break;
    case VERDADEIRO:
      jj_consume_token(VERDADEIRO);
      break;
    case FALSO:
      jj_consume_token(FALSO);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void bloco() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CARACTER:
    case INTEIRO:
    case REAL:
    case VAZIO:
    case IDENTIFICADOR:
      atribuicao();
      break;
    case QUEBRAR:
      jj_consume_token(QUEBRAR);
      jj_consume_token(PONTOVIRGULA);
      break;
    case RETORNO:
      jj_consume_token(RETORNO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        jj_consume_token(PONTOVIRGULA);
        break;
      case NUMEROINTEIRO:
      case NUMEROREAL:
        expressao();
        jj_consume_token(PONTOVIRGULA);
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void aritmetico() throws ParseException {
    expressao();
  }

  final public void expressao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMEROINTEIRO:
      jj_consume_token(NUMEROINTEIRO);
      break;
    case NUMEROREAL:
      jj_consume_token(NUMEROREAL);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public AnalisadorSintaticoTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[18];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2000fe,0x20000000,0x200a5e,0x25000000,0x0,0x4000000,0x2c0000,0x20001e,0x60,0x1e,0x0,0x200000,0x40000080,0x4000000,0x2d8000,0x2c0000,0x200a1e,0xc0000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0xc00,0x0,0xc00,0x0,0x0,0x0,0x3000,0x0,0x3f,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public AnalisadorSintatico(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AnalisadorSintatico(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalisadorSintaticoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AnalisadorSintatico(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalisadorSintaticoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AnalisadorSintatico(AnalisadorSintaticoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalisadorSintaticoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[58];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 18; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 58; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}