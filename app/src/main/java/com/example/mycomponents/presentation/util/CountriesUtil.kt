package com.example.mycomponents.presentation.util

import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import com.example.mycomponents.MyApplication
import com.example.mycomponents.domain.model.Country

import org.json.JSONArray
import java.util.Locale

class CountriesUtil {

    companion object {

        fun getCountriesFromJsonFile(): List<Country> {
            val context = MyApplication.getInstance().applicationContext

            val jsonString =
                context.assets.open("CountryCodes.json").bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)
            val countryList = mutableListOf<Country>()

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val countryName = jsonObject.getString("name")
                val dialCode = jsonObject.getString("dial_code")
                val countryCode = jsonObject.getString("code")

                val country = Country(
                    name = countryName,
                    dialCode = dialCode,
                    code = countryCode,
                   // flag = setFlag(countryCode = countryCode, context = context)
                )

                countryList.add(country)
            }

            return countryList
        }

        fun getCountryFromCountryCode(code: String): Country {
            val countries = getCountriesFromJsonFile()
            return countries.filter { it.code == code }[0]
        }


        fun setFlag(countryCode: String, context: Context): Bitmap? {
            val drawableResourceId = getDrawableId(countryCode, context)

            try {
                val vectorDrawable = AppCompatResources.getDrawable(context, drawableResourceId)
                return vectorDrawable?.toBitmap(width = 50, height = 50)
            }
            catch (e: Exception) {
                return null
            }
        }

        private fun getDrawableId(countryCode: String, context: Context): Int {
            val normalisedCountryImageName = "_" + countryCode.lowercase(Locale.getDefault())

            return  context.resources
                .getIdentifier(
                    normalisedCountryImageName,
                    "drawable",
                    context.packageName
                )
        }

    }
}