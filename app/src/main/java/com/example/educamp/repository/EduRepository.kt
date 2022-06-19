package com.example.educamp.repository

import com.example.educamp.manager.BluetoothManager
import com.example.educamp.network.RestApi
import javax.inject.Inject

class EduRepository @Inject constructor(private val restApi: RestApi,
                                        private val bluetoothManager: BluetoothManager) {
}