# ANDROID STUDY JAMS (Compose Camp)

Community App of Google Developer Student Club @ IPSA

[![GitHub license](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/MohitGupta121/gdsc-android-ipsa?style=social)](https://github.com/MohitGupta121/gdsc-android-ipsa/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/MohitGupta121/gdsc-android-ipsa?style=social)](https://github.com/MohitGupta121/gdsc-android-ipsa/network/members)
<!--
<b> Problem Statement: </b>

Getting Information and all the resource related to Google Developer Student Club IPS Academy and all the Events, Hackathons, etc. that we conduct gets complicated as Information and resources are divided on multiple platforms such as the DSC Community Website, WhatsApp Group of GDSC IPSA, Discord Server of GDSC IPSA, GitHub Org of GDSC IPSA, YouTube channel of GDSC IPSA and so on. Specific Technologies can be used to Implement a solution to ease the process and concentrate all the Information related to GDSC IPSA on a single platform.

<b> Proposed Solution : </b>

This project proposes a "Community Android Application" to accumulate all the Information and Resources related to our developer community here at GDSC IPSA in one single Android Application, which will make it a one-stop destination for all community members to access all the resources from one single platform rather than searching over all our social media handles and web-pages.

<!--<img width="700" alt="sampleimages" src="https://cdn.discordapp.com/attachments/881638762877177858/930102135998263316/unknown.png">
<img width="230" alt="sampleimages" src="https://play-lh.googleusercontent.com/D0TXpAEVitRAJO4SKkBNttqbP9VKE-qCijFL8aMihVbIzhOeQVYY8__GwgnN23_FCJh7=w1920-h929-rw"> <img width="230" alt="sampleimages" src="https://play-lh.googleusercontent.com/N-ZEC3FDJC_nC9B5RDs06YI8S0UrIVvBuxnKkDokNtQzkJHUXT0svwYm--MVlYSSMw=w1920-h929-rw"> <img width="230" alt="sampleimages" src="https://play-lh.googleusercontent.com/0cKOYOfXJfaJ0TdNDYsr5p6wb6-4UrQYG1XJJn67YUL_YZSjTg5_1ST8HHTLvR8x9IE=w1920-h929-rw"> <img width="230" alt="sampleimages" src="https://play-lh.googleusercontent.com/FUfJxnoPn0yybqMcVOmLLFTA78LH9MHzC9lKSL9HdcnfaWJCUIttc53KKcpuw7HLUpM=w1920-h929-rw">-->


## Technology Stack Used :
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Firebase](https://img.shields.io/badge/firebase-%23039BE5.svg?style=for-the-badge&logo=firebase)
    	  	
# <b> Functionality & Concepts used : </b>


## Functionalities in the app :

- Find all our Social Media handles and Developer Profiles.
- Get to know more about Google Developer Student Clubs.
- See Upcoming Event and all the Details.
- See Past Events and all the Details.
- Get Past Event's Video Recording.
- Verify the Certificate's authenticity issued by GDSC IPSA via this app and get all details.
- Check out all the Profiles of the Lead as well as of the whole team here at GDSC IPSA

## Concepts used in the app :

- **JetPack Compose UI:** Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
- **Navigation Component Library + SafeArgs Plugin (Android Jetpack):** Navigation Libraries are used to make navigating throughout the app easier, using navGraph with destinations and safeArgs to pass data between destinations with type safety.
- **LiveData, ViewModel + Room DB (Android Jetpack):** LiveData, Room and ViewModels such as EventDetailViewModel and AboutViewModel are used to make the architecture of the app more robust and scalable by making sure data survives configuration changes of user devices, all data gathering and model objects are present inside ViewModels.

- **Firebase RealtimeDatabase:** Google's Firebase is used as the online Backend Database to retrieve most of the data from, such as the Event Details as well as the Data for Verified Certificates issued by GDSC IPSA.
- **DataBinding + LiveData:** DataBinding is used along with LiveData to connect Views with Data as a 2-way connection, and make sure the data on the screen changes if the data is updated in the Database.
- **BottomNavigationView:** BottomNavigationView is implemented using navController of the NavigationGraph to easily navigate between the 3 Fragments AboutFragment, HomeFragment and TeamFragment.

- **Glide + Lottie:** Third-Party Libraries such as Glide is used to load images in the app using URIs as well as Lottie is used to render smooth animations in our app as views from the raw JSON.
- **MaterialUI by Material.io from Google:** This app follows the Material UI design pattern to implement a minimal UI to provide an enhanced user experience.

<b> Application Link & Future Scope : </b>

- Download the app from [Google Play Store](https://play.google.com/store/apps/details?id=)

<!--- The app is in the Alpha stage current and is being tested, discussed and developed by the student developers here at GDSC IPSA, the app will be released to the Google Play Store as soon as it's ready for the Beta Release. For now, the app can be downloaded from : [CLICK HERE](https://github.com/DSC-PHCET/gdsc-android-app/releases/download/v1.0.0-alpha/gdsc-phcet-alpha-1.0.0.apk)-->
<!--
- We are currently discussing all the possible features that can be Implemented in this community app, in the coming months we will be adding many more functionalities to this application.

- For any discussions related to this project, [Join our Discord Server](https://discord.gg/9AnpSSjs)


<h2>Contributors:</h2> 

* **[Contributors Wiki](https://github.com/MohitGupta121/gdsc-android-ipsa/blob/develop/CODE_OF_CONDUCT.md#contributor-covenant-code-of-conduct)**

## Thanks to all the contributors ❤️

<table>
   <tr>
      <td>
         <a href = "https://github.com/MohitGupta121/gdsc-android-ipsa/graphs/contributors">
         <img src = "https://contrib.rocks/image?repo=MohitGupta121/gdsc-android-ipsa"/>
         </a>
      </td>
   </tr>
</table>
