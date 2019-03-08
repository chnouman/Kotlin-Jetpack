package com.example.myapplication


import android.content.Context
import android.graphics.Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_recyclerview_example.*


class RecyclerviewExample : Fragment() {

    private val mNicolasCageMovies = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyclerview_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set title
        activity?.title = "Recyclerview Example"

        recyclerview.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        mNicolasCageMovies.add("Raising Arizona")
        mNicolasCageMovies.add("Vampire's Kiss")
        mNicolasCageMovies.add("Con Air")
        mNicolasCageMovies.add("Gone in 60 Seconds")
        mNicolasCageMovies.add("National Treasure")
        mNicolasCageMovies.add("The Wicker Man")
        mNicolasCageMovies.add("Ghost Rider")
        mNicolasCageMovies.add("Knowing")

        recyclerview.adapter = context?.let { RecyclerViewAdapter(it, mNicolasCageMovies ) }
    }


    class RecyclerViewAdapter: RecyclerView.Adapter<MovieViewHolder>{
        var items = ArrayList<String>()
        var context:Context

        constructor(context: Context, items: List<String>) : super() {
            this.context = context
            this.items = items as ArrayList<String>
        }


        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
           holder.bind(items.get(holder.adapterPosition))

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            var layoutInflater = LayoutInflater.from(context)
            return MovieViewHolder(layoutInflater,parent)
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

    class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recyclerview, parent, false)) {
        private var mTitleView: TextView? = null
        private var mYearView: TextView? = null


        init {
            mTitleView = itemView.findViewById(R.id.list_title)
            mYearView = itemView.findViewById(R.id.list_description)
            itemView.setOnClickListener { Toast.makeText(itemView.context,mTitleView?.text,Toast.LENGTH_SHORT).show() }

        }

        fun bind(movie: String) {
            mTitleView?.text = movie
            mYearView?.text = "$movie description"
        }
    }
}
