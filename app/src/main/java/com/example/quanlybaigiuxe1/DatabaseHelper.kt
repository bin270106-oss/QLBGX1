package com.example.quanlybaigiuxe1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "ParkingDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        // Bảng User
        val createUserTable = """
            CREATE TABLE User (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT,
                password TEXT
            )
        """.trimIndent()

        // Bảng Xe
        val createVehicleTable = """
            CREATE TABLE Vehicle (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                plate TEXT,
                type TEXT
            )
        """.trimIndent()

        // Bảng Vé gửi xe
        val createTicketTable = """
            CREATE TABLE Ticket (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                plate TEXT,
                time_in TEXT,
                time_out TEXT,
                price INTEGER
            )
        """.trimIndent()

        db.execSQL(createUserTable)
        db.execSQL(createVehicleTable)
        db.execSQL(createTicketTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS User")
        db.execSQL("DROP TABLE IF EXISTS Vehicle")
        db.execSQL("DROP TABLE IF EXISTS Ticket")
        onCreate(db)
    }
}