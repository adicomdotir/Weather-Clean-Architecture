package com.example.domain.repository

import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}