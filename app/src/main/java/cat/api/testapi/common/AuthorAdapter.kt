package cat.api.testapi.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cat.api.testapi.R

class AuthorAdapter(private var authorList: List<AuthorData>, private val context: Context) : RecyclerView.Adapter<AuthorAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.author_item, parent, false))
    }

    override fun onBindViewHolder(holder: AuthorAdapter.ViewHolder, position: Int) {
        val data = authorList[position]
        holder.nameText.text = data.nomAutor
        holder.idText.text = data.idAutor.toString()
    }

    override fun getItemCount(): Int {
        return authorList.size
    }
    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var nameText: TextView
        lateinit var idText: TextView
        init {
            nameText = itemLayoutView.findViewById(R.id.nom_autor)
            idText = itemLayoutView.findViewById(R.id.id_autor)
        }
    }
}