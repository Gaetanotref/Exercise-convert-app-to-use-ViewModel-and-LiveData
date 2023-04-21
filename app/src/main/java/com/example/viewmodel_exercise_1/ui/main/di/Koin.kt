package com.example.viewmodel_exercise_1.ui.main.di

import android.content.Context
import androidx.room.Room
import com.example.viewmodel_exercise_1.ui.main.db.MyDataBase
import com.example.viewmodel_exercise_1.ui.main.db.MyInterfaceDao
import com.example.viewmodel_exercise_1.ui.main.viewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.logger.Level
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get())}
}

val roomModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            MyDataBase::class.java,
            "my-database"
        ).build()
    }
}
val instanceModuleDao = module {
    single<MyInterfaceDao> {
        val database = get<MyDataBase>()
        database.getDAO()
}
}


fun startKoin(context: Context) {
    org.koin.core.context.startKoin {
        androidLogger(Level.ERROR)
        androidContext(context)
        modules(
            listOf(
                viewModelModule, roomModule, instanceModuleDao
            )
        )
    }
}