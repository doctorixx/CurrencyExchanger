package logging;

import ru.doctorixx.logging.LoggingLevel;

class Logger {
    fun log(level: LoggingLevel, message: String) {
        print(level.name)
        print(": ")
        println(message)
    }
}
