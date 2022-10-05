package com.mohit.gdsc.ipsacademy

import com.mohit.gdsc.ipsacademy.data.models.PastEventModel

data class EventsDetails(
    val title: String,
    val Date: String,
    val ImageId: Int = 0,
    val Url:String
)
object PastEventDetails {

//    lateinit var EventsDetailsLists : List<PastEventModel>

//    val EventsDetailsLists = listOf(
//        EventsDetails(
//            title = "Compose Day-4",
//            Date = "Oct 01,2022",
//            ImageId = R.drawable.composekotlin,
//            Url = "https://gdsc.community.dev/events/details/developer-student-clubs-ips-academy-indore-presents-compose-camp-day-4-build-a-simple-complete-app-using-jetpack-compose/"
//        ),
//        EventsDetails(
//            title = "Compose Day-3",
//            Date = "Sep 30,2022",
//            ImageId = R.drawable.composekotlin,
//            Url = "https://gdsc.community.dev/events/details/developer-student-clubs-ips-academy-indore-presents-compose-camp-day-3-display-list-use-material-design-and-app-architecture/"
//        ),
//        EventsDetails(
//            title = "Compose Day-2",
//            Date = "Sep 29,2022",
//            ImageId = R.drawable.composekotlin,
//            Url = "https://gdsc.community.dev/events/details/developer-student-clubs-ips-academy-indore-presents-getting-started-with-android-development-and-jetpack-compose/"
//        ),
//        EventsDetails(
//            title = "Compose Day-1",
//            Date = "Sep 28,2022",
//            ImageId = R.drawable.composekotlin,
//            Url = "https://gdsc.community.dev/events/details/developer-student-clubs-ips-academy-indore-presents-compose-camp-day-1-your-first-android-app/"
//        ),
//        EventsDetails(
//            title = "Orientation",
//            Date = "Aug 31,2022",
//            ImageId = R.drawable.homeicon,
//            Url = "https://gdsc.community.dev/events/details/developer-student-clubs-ips-academy-indore-presents-gdsc-ips-academy-orientation/"
//        ) )
}
object FutureEventDetails {

    val EventsDetailsLists = listOf(
        EventsDetails(
            title = "No Upcoming Event",
            Date = "",
            ImageId = R.drawable.homeicon,
            Url = ""
        ) )
}