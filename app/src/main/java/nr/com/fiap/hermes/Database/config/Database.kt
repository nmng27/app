package nr.com.fiap.hermes.Database.config

import android.content.Context // Importação corrigida
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nr.com.fiap.hermes.Models.Usuario
import nr.com.fiap.hermes.Models.dao.UsuarioDao

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDb : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile
        private var instance: UsuarioDb? = null

        fun getDatabase(context: Context): UsuarioDb {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext, // Garantir o uso do application context
                    UsuarioDb::class.java,
                    "usuario_db"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                instance = newInstance
                newInstance
            }
        }
    }
}
