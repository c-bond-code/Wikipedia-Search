package com.example.application.views.wikipediasearch;
/* Generated By:JavaCC: Do not edit this line. HTMLTokenTokenManager.java */
import java.io.*;
import java.util.ArrayList;

/** Token Manager. */
public class HTMLTokenTokenManager implements HTMLTokenConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private int jjMoveStringLiteralDfa0_0()
{
   return jjMoveNfa_0(4, 0);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 89;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((0xfc00ffffffffffffL & l) != 0L)
                  {
                     if (kind > 4)
                        kind = 4;
                  }
                  else if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddTwoStates(9, 11);
                  }
                  if ((0x100002200L & l) != 0L)
                  {
                     if (kind > 2)
                        kind = 2;
                     jjCheckNAdd(3);
                  }
                  else if (curChar == 60)
                     jjAddStates(0, 9);
                  if (curChar == 60)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 1:
                  if (curChar == 39)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 3:
                  if ((0x100002200L & l) == 0L)
                     break;
                  if (kind > 2)
                     kind = 2;
                  jjCheckNAdd(3);
                  break;
               case 5:
                  if (curChar == 60)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 7:
                  if (curChar == 62 && kind > 5)
                     kind = 5;
                  break;
               case 8:
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(9, 11);
                  break;
               case 9:
                  if ((0x500000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddStates(10, 12);
                  break;
               case 12:
                  if (curChar == 60)
                     jjAddStates(0, 9);
                  break;
               case 13:
                  if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 15:
                  if (curChar == 62 && kind > 3)
                     kind = 3;
                  break;
               case 17:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjAddStates(13, 15);
                  break;
               case 18:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 19:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 20:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 25:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjAddStates(16, 18);
                  break;
               case 26:
                  if ((0x2400L & l) != 0L && kind > 7)
                     kind = 7;
                  break;
               case 27:
                  if (curChar == 10 && kind > 7)
                     kind = 7;
                  break;
               case 28:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 33:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjAddStates(19, 21);
                  break;
               case 34:
                  if ((0x2400L & l) != 0L && kind > 8)
                     kind = 8;
                  break;
               case 35:
                  if (curChar == 10 && kind > 8)
                     kind = 8;
                  break;
               case 36:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 35;
                  break;
               case 42:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjAddStates(22, 24);
                  break;
               case 43:
                  if ((0x2400L & l) != 0L && kind > 9)
                     kind = 9;
                  break;
               case 44:
                  if (curChar == 10 && kind > 9)
                     kind = 9;
                  break;
               case 45:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 50:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjAddStates(25, 27);
                  break;
               case 51:
                  if ((0x2400L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 52:
                  if (curChar == 10 && kind > 10)
                     kind = 10;
                  break;
               case 53:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 52;
                  break;
               case 60:
                  jjAddStates(28, 29);
                  break;
               case 61:
                  if (curChar == 62 && kind > 11)
                     kind = 11;
                  break;
               case 67:
                  if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 66;
                  break;
               case 68:
                  if (curChar == 60)
                     jjstateSet[jjnewStateCnt++] = 67;
                  break;
               case 74:
                  if (curChar == 62 && kind > 12)
                     kind = 12;
                  break;
               case 75:
                  jjCheckNAddTwoStates(76, 74);
                  break;
               case 76:
                  jjCheckNAdd(74);
                  break;
               case 78:
                  if ((0xbfffffffffffffffL & l) != 0L)
                     jjAddStates(30, 31);
                  break;
               case 79:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(80, 81);
                  break;
               case 80:
                  if ((0x100002200L & l) != 0L)
                     jjCheckNAddTwoStates(80, 81);
                  break;
               case 81:
                  if (curChar == 62 && kind > 13)
                     kind = 13;
                  break;
               case 83:
                  if ((0xbfffffffffffffffL & l) != 0L)
                     jjAddStates(32, 33);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 1)
                        kind = 1;
                     jjCheckNAddTwoStates(0, 1);
                  }
                  else if ((0xf8000001f8000001L & l) != 0L)
                  {
                     if (kind > 4)
                        kind = 4;
                  }
                  break;
               case 0:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 1)
                     kind = 1;
                  jjCheckNAddTwoStates(0, 1);
                  break;
               case 2:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 1)
                     kind = 1;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 6:
                  if ((0x7fffffe00000000L & l) != 0L)
                     jjAddStates(34, 35);
                  break;
               case 14:
                  if ((0x7fffffe00000000L & l) != 0L)
                     jjAddStates(36, 37);
                  break;
               case 16:
                  if (curChar == 97)
                     jjCheckNAddStates(13, 15);
                  break;
               case 17:
                  jjCheckNAddStates(13, 15);
                  break;
               case 21:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 22:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 109)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 108)
                     jjCheckNAddStates(16, 18);
                  break;
               case 25:
                  jjCheckNAddStates(16, 18);
                  break;
               case 29:
                  if (curChar == 109)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 30:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 104)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 32:
                  if (curChar == 101)
                     jjCheckNAddStates(19, 21);
                  break;
               case 33:
                  jjCheckNAddStates(19, 21);
                  break;
               case 37:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 38:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 39:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 40:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 41:
                  if (curChar == 107)
                     jjCheckNAddStates(22, 24);
                  break;
               case 42:
                  jjCheckNAddStates(22, 24);
                  break;
               case 46:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 41;
                  break;
               case 47:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 48:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 47;
                  break;
               case 49:
                  if (curChar == 116)
                     jjCheckNAddStates(25, 27);
                  break;
               case 50:
                  jjCheckNAddStates(25, 27);
                  break;
               case 54:
                  if (curChar == 112)
                     jjstateSet[jjnewStateCnt++] = 49;
                  break;
               case 55:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 54;
                  break;
               case 56:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 55;
                  break;
               case 57:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 56;
                  break;
               case 58:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 57;
                  break;
               case 59:
                  if (curChar == 101)
                     jjCheckNAddTwoStates(60, 68);
                  break;
               case 60:
                  jjCheckNAddTwoStates(60, 68);
                  break;
               case 62:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 63:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 62;
                  break;
               case 64:
                  if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 65:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 64;
                  break;
               case 66:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 65;
                  break;
               case 69:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 59;
                  break;
               case 70:
                  if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 69;
                  break;
               case 71:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 70;
                  break;
               case 72:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 71;
                  break;
               case 73:
                  if (curChar == 98)
                     jjCheckNAddTwoStates(74, 75);
                  break;
               case 75:
                  jjCheckNAddTwoStates(76, 74);
                  break;
               case 76:
                  jjCheckNAdd(74);
                  break;
               case 77:
                  if (curChar == 97)
                     jjCheckNAdd(78);
                  break;
               case 78:
                  jjCheckNAddTwoStates(78, 79);
                  break;
               case 82:
                  if (curChar == 71)
                     jjCheckNAddTwoStates(83, 86);
                  break;
               case 83:
                  jjCheckNAddTwoStates(83, 86);
                  break;
               case 84:
                  if (curChar == 116 && kind > 14)
                     kind = 14;
                  break;
               case 85:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 84;
                  break;
               case 86:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 85;
                  break;
               case 87:
                  if (curChar == 77)
                     jjstateSet[jjnewStateCnt++] = 82;
                  break;
               case 88:
                  if (curChar == 73)
                     jjstateSet[jjnewStateCnt++] = 87;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((jjbitVec0[i2] & l2) != 0L && kind > 4)
                     kind = 4;
                  break;
               case 17:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(13, 15);
                  break;
               case 25:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(16, 18);
                  break;
               case 33:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(19, 21);
                  break;
               case 42:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(22, 24);
                  break;
               case 50:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(25, 27);
                  break;
               case 60:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(28, 29);
                  break;
               case 75:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(76, 74);
                  break;
               case 76:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAdd(74);
                  break;
               case 78:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(30, 31);
                  break;
               case 83:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(32, 33);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 89 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   13, 23, 31, 40, 48, 58, 72, 73, 77, 88, 9, 11, 11, 17, 18, 20, 
   25, 26, 28, 33, 34, 36, 42, 43, 45, 50, 51, 53, 60, 68, 78, 79, 
   83, 86, 6, 7, 14, 15, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3L, 
};
static final long[] jjtoSkip = {
   0x1fffcL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[89];
private final int[] jjstateSet = new int[178];
protected char curChar;
/** Constructor. */
public HTMLTokenTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public HTMLTokenTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 89; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedPos == 0 && jjmatchedKind > 16)
   {
      jjmatchedKind = 16;
   }
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
