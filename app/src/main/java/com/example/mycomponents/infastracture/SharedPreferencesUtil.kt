package com.example.mycomponents.infastracture


import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.preference.PreferenceManager
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.io.IOException
import java.security.GeneralSecurityException
import java.util.Arrays


class SharedPreferencesUtil {

    companion object {
        private var sharedPreferences: SharedPreferences? = null
        private const val prefname = "SecureKeyPreference"
        private const val serverPayloadValidationPublicKey = "Application.serverPublicKey"
        private const val sessionIdKey = "Application.SessonId"
        private const val fcmToken = "Application.token"
        private const val firstTimeLogin = "firstTimeLogin"
        private const val txnId = "transaction.id"
        private const val SavePinKey = "Application.Pin"
        private const val PasscodeEnableKey = "Application.Pin.Enabled"
        private const val IsEnablePasswordInitialised = "Application.Password.Enable.Initialised"
        private const val EnablePasswordKey = "Application.Password.Enable"
        private const val BiometricsKey = "Application.Biometrics.Enabled"
        private const val PasswordKey = "Application.Password"
        private const val EmailKey = "Application.Email"
        private const val shareKycData = "Application.shareKycMerchantId"


        fun userLogsInForFirstTime(context: Context, defaultValue: Boolean = true): Boolean {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getBoolean(firstTimeLogin, defaultValue) ?: defaultValue
        }

        fun setUserLoginForFirstTimeToFalse(context: Context, value: Boolean = false) {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            preferences.edit().putBoolean(firstTimeLogin, value).apply()
        }

        fun persistSessionId(context: Context, sessionId: String?) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putString(sessionIdKey, sessionId)
                .apply()
        }

        fun getSessionId(context: Context): String? {
            return getEncryptedSharedPreferences(context)!!
                .getString(sessionIdKey, "")
        }


        private fun getEncryptedSharedPreferences(context: Context): SharedPreferences? {
            return try {
                if (sharedPreferences == null) {
                    val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                        .build()

                    sharedPreferences =
                        EncryptedSharedPreferences.create(
                            context,
                            prefname,
                            masterKey,
                            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                        )
                }
                return sharedPreferences
            } catch (e: GeneralSecurityException) {
                e.printStackTrace()
                Log.d("mariaaa", e.message!!)
                null
            } catch (e: IOException) {
                e.printStackTrace()
                Log.d("mariaaa", e.message!!)
                null
            }
        }

        fun setFcmToken(context: Context, token: String?) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putString(fcmToken, token)
                .apply()
        }

        fun getFcmToken(context: Context): String {
            return getEncryptedSharedPreferences(context)!!
                .getString(fcmToken, "N/A")!!
        }


        fun setServerPayloadValidationPublicKey(context: Context, publicKey: String?) {
            getEncryptedSharedPreferences(context)!!
                                        .edit()
                                        .putString(serverPayloadValidationPublicKey, publicKey)
                                        .apply()
        }

        fun getServerPayloadValidationPublicKey(context: Context): String {
            return getEncryptedSharedPreferences(context)!!
                                            .getString(serverPayloadValidationPublicKey, "N/A")!!
        }


        fun persistTxnId(context: Context, value: String?) {
            getEncryptedSharedPreferences(context)!!
                                            .edit()
                                            .putString(txnId, value)
                                            .apply()
        }

        fun getTxnId(context: Context): String? {
            return getEncryptedSharedPreferences(context)!!
                        .getString(txnId, "N/A")
        }


        fun persistPasscode(context: Context, passcode: String?) {
            getEncryptedSharedPreferences(context)!!
                                            .edit()
                                            .putString(SavePinKey, passcode)
                                            .apply()
        }

        fun getPersistedPasscode(context: Context): String? {
            return getEncryptedSharedPreferences(context)!!
                .getString(SavePinKey, "")
        }

        fun persistPasscodeEnable(context: Context, PasscodeEnabled: Boolean) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putBoolean(PasscodeEnableKey, PasscodeEnabled)
                .apply()
        }

        fun getPersistedPasscodeEnable(context: Context, passcodeEnabled: Boolean = false): Boolean {
            return getEncryptedSharedPreferences(context)!!
                .getBoolean(PasscodeEnableKey, passcodeEnabled)
        }


        fun persistBiometricsEnabled(context: Context, biometricsEnable: Boolean) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putBoolean(BiometricsKey, biometricsEnable)
                .apply()
        }

        fun getPersistedBiometricsEnabled(context: Context): Boolean {
            return getEncryptedSharedPreferences(context)!!
                .getBoolean(BiometricsKey, false)
        }


        fun persistEmail(context: Context, email: String?) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putString(EmailKey, email)
                .apply()
        }

        fun getPersistedEmail(context: Context): String {
            return getEncryptedSharedPreferences(context)!!
                .getString(EmailKey, "")!!
        }

        fun persistPassword(context: Context, password: String?) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putString(PasswordKey, password)
                .apply()
        }

        fun getPersistedPassword(context: Context): String {
            return getEncryptedSharedPreferences(context)!!
                .getString(PasswordKey, "")!!
        }

        fun persistRememberPasswordEnable(context: Context, passwordEnable: Boolean) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putBoolean(EnablePasswordKey, passwordEnable)
                .apply()
        }

        fun getPersistRememberPasswordEnable(context: Context): Boolean? {
            return getEncryptedSharedPreferences(context)!!
                .getBoolean(EnablePasswordKey, false)
        }

        fun setIsEnablePasswordInitialised(context: Context, isInitialised: Boolean) {
            getEncryptedSharedPreferences(context)!!
                .edit()
                .putBoolean(
                    IsEnablePasswordInitialised,
                    isInitialised
                )
                .apply()
        }

        fun getIsEnablePasswordInitialised(context: Context): Boolean {
            return getEncryptedSharedPreferences(context)!!
                .getBoolean(IsEnablePasswordInitialised, false)
        }

//        fun persistKycStatus(context: Context?, kycStatusCode: String?) {
//            isx.financial.twa.util.SharedPref.getEncryptedSharedPreferences(context)
//                .edit()
//                .putString(isx.financial.twa.util.SharedPref.KYC_STATUS_KEY, kycStatusCode)
//                .apply()
//        }
//
//        fun getPersistedKycStatus(context: Context?): KycStatus? {
//            return KycStatus.valueOf(
//                isx.financial.twa.util.SharedPref.getEncryptedSharedPreferences(context)
//                    .getString(
//                        isx.financial.twa.util.SharedPref.KYC_STATUS_KEY,
//                        KycStatus.UNDEFINED.name()
//                    )
//            )
//        }

        fun setShareKycData(context: Context, referenceNumber: String, merchantId: String) {
            val shareKycData: Set<String> = HashSet(Arrays.asList(referenceNumber, merchantId))
                getEncryptedSharedPreferences(context)!!
                    .edit() //
                    .putString(shareKycData.toString(), referenceNumber)
                    .apply()
        }

        fun getShareKycData(context: Context): String? {
//        return getEncryptedSharedPreferences(context).getStringSet(SharedPref.shareKycData, new HashSet<>());
            return getEncryptedSharedPreferences(context)!!
                .getString(shareKycData, "")
        }
    }


}

