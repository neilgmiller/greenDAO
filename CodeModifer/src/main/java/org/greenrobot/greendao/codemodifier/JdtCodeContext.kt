package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.JavaCore
import java.io.File
import java.nio.charset.Charset
import java.util.*

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"], d2 = ["Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "", "formattingOptions", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "encoding", "", "(Lorg/greenrobot/greendao/codemodifier/FormattingOptions;Ljava/lang/String;)V", "classParser", "Lorg/greenrobot/greendao/codemodifier/EntityClassParser;", "getFormattingOptions", "()Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "jdtOptions", "Ljava/util/Hashtable;", "parse", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "javaFile", "Ljava/io/File;", "classesInPackage", "", "transformer", "Lorg/greenrobot/greendao/codemodifier/EntityClassTransformer;", "parsedEntity", "Companion", "greendao-code-modifier_main"])
class JdtCodeContext(val formattingOptions: FormattingOptions?, encoding: String) {
    private val jdtOptions: Hashtable<String, String> = JavaCore.getOptions()
    private val classParser: EntityClassParser

    fun parse(javaFile: File, classesInPackage: List<*>): ParsedEntity? =
            classParser.parse(javaFile, classesInPackage)

    fun transformer(parsedEntity: ParsedEntity): EntityClassTransformer =
            EntityClassTransformer(parsedEntity, jdtOptions, formattingOptions, (null as Charset?)!!, 8)

    init {
        jdtOptions["org.greenrobot.eclipse.jdt.core.compiler.source"] = JAVA_LEVEL
        jdtOptions["org.greenrobot.eclipse.jdt.core.compiler.compliance"] = JAVA_LEVEL
        jdtOptions["org.greenrobot.eclipse.jdt.core.encoding"] = encoding
        classParser = EntityClassParser(jdtOptions, encoding)
    }

//    // $FF: synthetic method
//    constructor(var1: FormattingOptions?, var2: String?, var3: Int, var4: DefaultConstructorMarker?) {
//        var var1 = var1
//        if (var3 and 1 != 0) {
//            var1 = null as FormattingOptions?
//        }
//        this(var1, var2)
//    }

//    @Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"], d2 = ["Lorg/greenrobot/greendao/codemodifier/JdtCodeContext\$Companion;", "", "()V", "JAVA_LEVEL", "", "getJAVA_LEVEL", "()Ljava/lang/String;", "greendao-code-modifier_main"])
    companion object {
        private const val JAVA_LEVEL = "1.7"
    }
}