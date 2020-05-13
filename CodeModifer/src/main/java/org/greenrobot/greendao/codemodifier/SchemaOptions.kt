package org.greenrobot.greendao.codemodifier

import java.io.File
import kotlin.jvm.internal.Intrinsics

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