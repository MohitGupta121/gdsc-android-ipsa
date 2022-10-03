package com.example.gdscipsa

data class EventRecyclerView(val imageurl:String,val eventName:String,val eventDate:String)

data class EventsDetails(val id: Int,
                         val title: String,
                         val Date: String,
                         val ImageId: Int = 0)
object Details {

    val EventsDetailsLists = listOf(
        EventsDetails(
            id = 1,
            title = "Rohan",
            Date = "Dec 17th, 2021",
            ImageId = R.drawable.homeicon
        ),
        EventsDetails(
            id = 2,
            title = "Roy",
            Date = "Dec 17th, 2021",
            ImageId = R.drawable.team
        ),
        EventsDetails(
            id = 3,
            title = "Vishal",
            Date = "Dec 17th, 2021",
            ImageId = R.drawable.aboutus
        ),
        EventsDetails(
            id = 4,
            title = "Nikhil",
            Date = "Dec 17th, 2021",
            ImageId = R.drawable.team
        ), )
}
data class socialmedia(
    val image:Int=0,
    val link:String
)

object SocialMediaDetails{
    val SocialMediaList= listOf(
        socialmedia(
            R.drawable.ic_youtube2,
            "https://www.youtube.com/watch?v=FpkYPdtgpw0"
        ),
        socialmedia(
            R.drawable.ic_instagram2,
            "https://instagram.com/gdsc_ipsa?igshid=YmMyMTA2M2Y="
        ),
        socialmedia(
            R.drawable.ic_linkedin,
            "https://in.linkedin.com/company/gdsc-ipsa"
        ),
    )
}

data class TechnologyStack(
    val image:Int=0,
    val link:String
)
//object TechnologyStackDetails{
//    val TechnologyStackList= listOf(
//        TechnologyStack(
//
//        )
//    )
//}