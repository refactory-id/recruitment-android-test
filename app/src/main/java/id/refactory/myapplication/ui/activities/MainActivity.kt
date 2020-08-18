package id.refactory.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.refactory.domain.User
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.adapters.UserListAdapter
import id.refactory.myapplication.ui.presenters.MainPresenter
import id.refactory.myapplication.ui.views.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView.View {
    private val presenter = MainPresenter(this)
    private var users = mutableListOf<User>()
    private var adapter: UserListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onPrepare()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onSuccessLoadUsers(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
        adapter?.notifyDataSetChanged()
    }

    override fun onPrepare() {
        adapter = UserListAdapter(this, users)
        rv_users.adapter = adapter
        presenter.onLoadUsers(mutableMapOf())
    }

    override fun onError() {
        toast("Error happen")
    }
}
