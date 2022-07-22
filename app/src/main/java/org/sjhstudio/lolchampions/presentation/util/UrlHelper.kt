package org.sjhstudio.lolchampions.presentation.util

object UrlHelper {
    const val BASE_URL = "http://ddragon.leagueoflegends.com/cdn"
    const val LOL_VERSION = "12.6.1"
}

fun getChampionImageUrl(name: String?) =
    if (!name.isNullOrEmpty())"${UrlHelper.BASE_URL}/img/champion/splash/${name}_0.jpg"
    else null