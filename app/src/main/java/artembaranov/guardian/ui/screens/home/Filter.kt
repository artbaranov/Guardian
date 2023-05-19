package artembaranov.guardian.ui.screens.home

/**
 * Created by Artem Baranov on 19.05.2023.
 */
data class Filter(
    val id: Int,
    val name: String,
    val applied: Boolean,
) {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Filter -> {
                this.id == other.id
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + applied.hashCode()
        return result
    }
}
