package com.example.mycomponents.infastracture

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyPermanentlyInvalidatedException
import android.security.keystore.KeyProperties
import androidx.biometric.BiometricManager
import androidx.core.content.ContextCompat
import com.example.mycomponents.MyApplication
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class BiometricUtils {

    companion object {
        fun isChangeOnDeviceBiometrics(): Boolean {
            val context = MyApplication.getInstance().applicationContext
          //  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val keyStore: KeyStore
                try {
                    if (!checkBiometricSupport(context, false)) {
                        resetKeychain()
                        return true
                    }
                    keyStore = KeyStore.getInstance("AndroidKeyStore")
                    keyStore.load(null)
                    val key = keyStore.getKey("biometrics", null) as SecretKey
                    val cipher = Cipher.getInstance("AES/GCM/NoPadding")
                    cipher.init(Cipher.ENCRYPT_MODE, key)
                    cipher.init(Cipher.DECRYPT_MODE, key, cipher.parameters)
                } catch (e: KeyPermanentlyInvalidatedException) {
                    try {
                        resetKeychain()
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                    return true
                }

                catch (e: InvalidAlgorithmParameterException) {
                    resetKeychain()
                    return true
                }
                catch (e: InvalidKeyException) {
                    createNewBiometricsKey()
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
      //      }
            return false
        }

        fun createNewBiometricsKey(): Boolean {
          //  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                val keyStore = KeyStore.getInstance("AndroidKeyStore")
                keyStore.load(null)
                keyStore.deleteEntry("biometrics")
                val builder = KeyGenParameterSpec.Builder(
                    "biometrics",
                    KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
                )
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .setUserAuthenticationRequired(true)
                    .setInvalidatedByBiometricEnrollment(true)
                    .build()
                val keyGenerator = KeyGenerator.getInstance(
                    KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore"
                )
                keyGenerator.init(builder)
                val key = keyGenerator.generateKey()
                val cipher = Cipher.getInstance("AES/GCM/NoPadding")
                cipher.init(Cipher.ENCRYPT_MODE, key)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        //    }
            return true
        }

        // TODO: refactor the code below so that it returns an enum instead of a boolean
        // TODO: give a more meaningful name to the method below, e.g. getBiometricsSupportStatus
        fun checkBiometricSupport(context: Context, notifyUser: Boolean): Boolean {
            return if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.USE_BIOMETRIC
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                false
            }

            else if (BiometricManager
                .from(context)
                .canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK) == BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED) {

                false
            }
            else if (BiometricManager
                .from(context)
                .canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK) == BiometricManager.BIOMETRIC_SUCCESS) {
                true
            }

            else {
                BiometricManager.from(context)
                    .canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK) == BiometricManager.BIOMETRIC_SUCCESS
            }
        }

        private fun resetKeychain() {
            val context = MyApplication.getInstance().applicationContext
            SharedPreferencesUtil.persistBiometricsEnabled(context, false)
            SharedPreferencesUtil.persistEmail(context, "")
            SharedPreferencesUtil.persistPassword(context, "")
            SharedPreferencesUtil.persistRememberPasswordEnable(context, false)
            createNewBiometricsKey()
        }
    }
}