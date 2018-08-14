package by.yarik.meet_me_simply.view.login.fragments.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import by.yarik.meet_me_simply.R

data class AnswersAdapter(var context: Context) : PagerAdapter() {

    var answersItems: MutableList<AnswersItem>
    var answerSlogan: String
    init {
        answerSlogan = context.getString(R.string.title_slogan_reg_rec_video)
        var answersText = context.resources.getStringArray(R.array.info_why_record_video)
        var answersIcon = intArrayOf(R.drawable.answer1, R.drawable.answer2, R.drawable.answer3)
        answersItems = mutableListOf<AnswersItem>()
        for (i in 0..answersText.size - 1) {
            answersItems.add(AnswersItem(answersIcon[i], answersText[i]))
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.item_answer, container, false);

        var answersItem = answersItems[position]
        view.findViewById<TextView>(R.id.tv_answer_text).setText(answerSlogan + "\n" + answersItem.text)
        view.findViewById<ImageView>(R.id.img_answer_icon).setImageResource(answersItem.iconRes)
        (container as ViewPager).addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return answersItems.size;
    }
}