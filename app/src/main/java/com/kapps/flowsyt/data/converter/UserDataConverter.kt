package com.kapps.flowsyt.data.converter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlin.math.pow

class UserDataConverter {

    fun convertUserData(userData:List<Float>): Flow<DataConvertingInfo> = flow {
        var alreadyConvertedValues = 0
        userData.forEach { _ ->
            for(i in 0..1000){
                val j = i.toDouble().pow(2.0)
            }
            emit(DataConvertingInfo(convertedDataAmount = ++alreadyConvertedValues))
        }
    }

}

data class DataConvertingInfo(
    val convertedDataAmount:Int
)