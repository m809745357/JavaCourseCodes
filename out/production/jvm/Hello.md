```bash
E:\javaCourseCodes>javap -c -v out/production/jvm/HelloCode.class
Classfile /E:/javaCourseCodes/out/production/jvm/HelloCode.class
  Last modified 2022年1月6日; size 531 bytes
  MD5 checksum 5ca7f05a1921dbf7eeaaa65ea140451e
  Compiled from "HelloCode.java"
public class HelloCode
  minor version: 0
  major version: 55
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #2                          // HelloCode
  super_class: #3                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #3.#23         // java/lang/Object."<init>":()V
   #2 = Class              #24            // HelloCode
   #3 = Class              #25            // java/lang/Object
   #4 = Utf8               <init>
   #5 = Utf8               ()V
   #6 = Utf8               Code
   #7 = Utf8               LineNumberTable
   #8 = Utf8               LocalVariableTable
   #9 = Utf8               this
  #10 = Utf8               LHelloCode;
  #11 = Utf8               main
  #12 = Utf8               ([Ljava/lang/String;)V
  #13 = Utf8               i
  #14 = Utf8               I
  #15 = Utf8               b
  #16 = Utf8               c
  #17 = Utf8               args
  #18 = Utf8               [Ljava/lang/String;
  #19 = Utf8               a
  #20 = Utf8               StackMapTable
  #21 = Utf8               SourceFile
  #22 = Utf8               HelloCode.java
  #23 = NameAndType        #4:#5          // "<init>":()V
  #24 = Utf8               HelloCode
  #25 = Utf8               java/lang/Object
{
  public HelloCode();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 4: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LHelloCode;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=4, args_size=1
         0: bipush        10
         2: istore_1
         3: iconst_3
         4: istore_2
         5: iload_2
         6: bipush        100
         8: if_icmpgt     21
        11: iload_1
        12: iload_2
        13: iadd
        14: istore_1
        15: iinc          2, 1
        18: goto          5
        21: iload_1
        22: bipush        10
        24: if_icmple     36
        27: iload_1
        28: istore_2
        29: iload_1
        30: iload_2
        31: iadd
        32: istore_3
        33: iinc          2, 1
        36: return
      LineNumberTable:
        line 6: 0
        line 7: 3
        line 8: 11
        line 7: 15
        line 11: 21
        line 12: 27
        line 13: 29
        line 14: 33
        line 16: 36
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            5      16     2     i   I
           29       7     2     b   I
           33       3     3     c   I
            0      37     0  args   [Ljava/lang/String;
            3      34     1     a   I
      StackMapTable: number_of_entries = 3
        frame_type = 253 /* append */
          offset_delta = 5
          locals = [ int, int ]
        frame_type = 250 /* chop */
          offset_delta = 15
        frame_type = 14 /* same */
}
SourceFile: "HelloCode.java"

```