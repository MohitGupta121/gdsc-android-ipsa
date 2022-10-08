package com.mohit.gdsc.ipsacademy.data.models

import com.mohit.gdsc.ipsacademy.R

data class SocialMedia(
    val image: Int = 0,
    val link: String
)

object SocialMediaDetails {
    val SocialMediaList = listOf(
        SocialMedia(
            R.drawable.ic_youtube2,
            "https://www.youtube.com/watch?v=FpkYPdtgpw0"
        ),
        SocialMedia(
            R.drawable.ic_discord2,
            "https://discord.gg/MzjK8WJN"
        ),
        SocialMedia(
            R.drawable.ic_instagram2,
            "https://instagram.com/gdsc_ipsa?igshid=YmMyMTA2M2Y="
        ),
        SocialMedia(
            R.drawable.ic_linkedin,
            "https://in.linkedin.com/company/gdsc-ipsa"
        ),
    )
}

data class TechnologyStack(
    val image: Int = 0,
    val name: String,
    val link: String
)

object TechnologyStackDetails {
    val TechnologyStackList = listOf(
        TechnologyStack(
            image = R.drawable.android,
            name = "Android\nDevelopments",
            link = ""
        ),
        TechnologyStack(
            image = R.drawable.ic_flutter,
            name = "Flutter Development",
            link = ""
        ),
        TechnologyStack(
            image = R.drawable.data_science,
            name = "Data\nScience",
            link = ""
        ),
        TechnologyStack(
            image = R.drawable.ic_machine_learning,
            name = "Machine\nLearning",
            link = ""
        ),
        TechnologyStack(
            image = R.drawable.ic_web_dev,
            link = "",
            name = "Web\nDevelopment"
        ),
        TechnologyStack(
            image = R.drawable.ic_google_cloud,
            name = "Google\nCloud",
            link = ""
        ),
        TechnologyStack(
            image = R.drawable.ic_open_source,
            name = "Open\nSource",
            link = ""
        ),
        TechnologyStack(
            image = R.drawable.ic_cloud_computing,
            name = "Cloud\nComputing",
            link = ""
        ),
        TechnologyStack(
            image = R.drawable.ic_much_more,
            name = "+\nMuch More",
            link = ""
        )
    )
}