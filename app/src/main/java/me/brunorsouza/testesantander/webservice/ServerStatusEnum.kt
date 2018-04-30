package me.brunorsouza.testesantander.webservice

/**
 * Created by brunosouza.
 */
enum class ServerStatusEnum(code: Int) {

    STATUS_OK(200),
    STATUS_DELETE_OK(204),
    STATUS_CREATED(201),
    STATUS_UNAUTHORIZED(401),
    STATUS_FORBIDDEN(403),
    STATUS_NOT_FOUND(404),
    STATUS_NOT_ACCEPTABLE(406),
    STATUS_LAST_PAGE(500);

    var code: Int = 0
        internal set

    init {
        this.code = code
    }

}
