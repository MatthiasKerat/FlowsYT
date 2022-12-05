package com.kapps.flowsyt.data

import com.kapps.flowsyt.data.converter.UserDataConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class UserRepository(
    private val userDataConverter: UserDataConverter = UserDataConverter()
) {

    fun generateUserData(userData:List<Float>): Flow<DataProgressInfo>{
        val valuesForOnePercent = userData.size/100
        return userDataConverter.convertUserData(userData).filter { dataConvertingInfo ->
            dataConvertingInfo.convertedDataAmount % valuesForOnePercent == 0
        }.map { dataConvertingInfo ->
            DataProgressInfo(
                progressPercentage = dataConvertingInfo.convertedDataAmount/valuesForOnePercent
            )
        }.flowOn(Dispatchers.IO)
    }

}

data class DataProgressInfo(
    val progressPercentage:Int
)