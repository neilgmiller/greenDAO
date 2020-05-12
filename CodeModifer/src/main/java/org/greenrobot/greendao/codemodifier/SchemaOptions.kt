package org.greenrobot.greendao.codemodifier

import java.io.File
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"], d2 = ["Lorg/greenrobot/greendao/codemodifier/SchemaOptions;", "", "name", "", "version", "", "daoPackage", "outputDir", "Ljava/io/File;", "testsOutputDir", "(Ljava/lang/String;ILjava/lang/String;Ljava/io/File;Ljava/io/File;)V", "getDaoPackage", "()Ljava/lang/String;", "getName", "getOutputDir", "()Ljava/io/File;", "getTestsOutputDir", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "greendao-code-modifier_main"])
class SchemaOptions(val name: String, val version: Int, val daoPackage: String?, val outputDir: File, val testsOutputDir: File?) {

    fun copy(name: String, version: Int, daoPackage: String?, outputDir: File, testsOutputDir: File?): SchemaOptions {
        Intrinsics.checkParameterIsNotNull(name, "name")
        Intrinsics.checkParameterIsNotNull(outputDir, "outputDir")
        return SchemaOptions(name, version, daoPackage, outputDir, testsOutputDir)
    }

    override fun toString(): String {
        return "SchemaOptions(name=$name, version=$version, daoPackage=$daoPackage, outputDir=$outputDir, testsOutputDir=$testsOutputDir)"
    }

    override fun hashCode(): Int {
        val var10000 = name
        var var1 = (var10000.hashCode() * 31 + version) * 31
        val var10001 = daoPackage
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        var var2: File? = outputDir
        var1 = (var1 + (var2?.hashCode() ?: 0)) * 31
        var2 = testsOutputDir
        return var1 + (var2?.hashCode() ?: 0)
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is SchemaOptions) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && version == var2.version && Intrinsics.areEqual(daoPackage, var2.daoPackage) && Intrinsics.areEqual(outputDir, var2.outputDir) && Intrinsics.areEqual(testsOutputDir, var2.testsOutputDir)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}