package com.janewaitara.businesscardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * Arrays of the business card properties from the string arrays in the Res folder in strings.xml
     * */
    private var namesArray: Array<String> = arrayOf()
    private var addressesArray: Array<String> = arrayOf()
    private var contactsArray: Array<String> = arrayOf()
    private var emailsArray: Array<String> = arrayOf()
    private var portfoliosArray: Array<String> = arrayOf()
    private var companiesArray: Array<String> = arrayOf()


    /**
     * A list of all business Cards to display
     * */
    private var businessCardList = listOf<BusinessCard>()
    private var imageList = listOf<Int>()

    lateinit var currentName : String
    lateinit var currentAddress : String
    lateinit var currentContact : String
    lateinit var currentEmail : String
    lateinit var currentPortfolio : String
    lateinit var currentCompany : String
     var currentImage: Int = 0


    companion object{

        private const val MEMBER_NAME_KEY = "MEMBER_NAME"
        private const val ADDRESS_KEY = "ADDRESS_KEY"
        private const val CONTACT_KEY = "CONTACT_KEY"
        private const val EMAIL_KEY = "EMAIL_KEY"
        private const val PORTFOLIO_KEY = "PORTFOLIO_KEY"
        private const val COMPANY_KEY = "COMPANY_KEY"
        private const val IMAGE_KEY = "IMAGE_KEY"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namesArray = resources.getStringArray(R.array.names)
        addressesArray = resources.getStringArray(R.array.addresses)
        contactsArray = resources.getStringArray(R.array.contacts)
        emailsArray = resources.getStringArray(R.array.emails)
        portfoliosArray = resources.getStringArray(R.array.portfolios)
        companiesArray = resources.getStringArray(R.array.companies)

        Log.d("TAG","names -> ${namesArray.random()}")

        imageList = listOf(R.drawable.building,R.drawable.building1,R.drawable.building2,R.drawable.building3)

        businessCardList = listOf(
            BusinessCard(
                namesArray[0],
                addressesArray[0],
                contactsArray[0],
                emailsArray[0],
                portfoliosArray[0],
                companiesArray[0],
                imageList[0]
            ),
            BusinessCard(
                namesArray[1],
                addressesArray[1],
                contactsArray[1],
                emailsArray[1],
                portfoliosArray[1],
                companiesArray[1],
                imageList[1]
            ),
            BusinessCard(
                namesArray[2],
                addressesArray[2],
                contactsArray[2],
                emailsArray[2],
                portfoliosArray[2],
                companiesArray[2],
                imageList[2]
            ),
            BusinessCard(
                namesArray[3],
                addressesArray[3],
                contactsArray[3],
                emailsArray[3],
                portfoliosArray[3],
                companiesArray[3],
                imageList[3]
            ),
            BusinessCard(
                namesArray[4],
                addressesArray[4],
                contactsArray[4],
                emailsArray[4],
                portfoliosArray[4],
                companiesArray[4],
                imageList[3]
            ),
            BusinessCard(
                namesArray[5],
                addressesArray[5],
                contactsArray[5],
                emailsArray[5],
                portfoliosArray[5],
                companiesArray[5],
                imageList[0]
            )
        )


        change_bs_card_button.setOnClickListener { view ->
            getRandomBusinessCard()
            displayNewCard()
        }

        if (savedInstanceState != null){
            currentName = savedInstanceState.getString(MEMBER_NAME_KEY)!!
            currentAddress = savedInstanceState.getString(ADDRESS_KEY)!!
            currentCompany = savedInstanceState.getString(COMPANY_KEY)!!
            currentContact = savedInstanceState.getString(CONTACT_KEY)!!
            currentEmail = savedInstanceState.getString(EMAIL_KEY)!!
            currentPortfolio = savedInstanceState.getString(PORTFOLIO_KEY)!!
            currentImage = savedInstanceState.getInt(IMAGE_KEY)

            Log.d("Image", currentImage.toString())

        } else{

            getRandomBusinessCard()
        }

        displayNewCard()

    }
    /**
     * Saving the Business Card properties to maintain the same card when the orientation of a screen changes
     * */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(MEMBER_NAME_KEY,currentName)
        outState.putString(ADDRESS_KEY,currentAddress)
        outState.putString(COMPANY_KEY,currentCompany)
        outState.putString(CONTACT_KEY,currentContact)
        outState.putString(EMAIL_KEY,currentEmail)
        outState.putString(PORTFOLIO_KEY,currentPortfolio)
        outState.putInt(IMAGE_KEY,currentImage)

    }
    /**
     * A function that is called all the time the app is created to display the business cards
     * */
    private fun displayNewCard() {

        Log.d("TAG","Display name has been called")

        full_name_text.text = currentName
        location_text.text = currentAddress
        company_name_text.text = currentCompany
        phone_text.text = getString(R.string.phoneText, currentContact)
        email_text.text = getString(R.string.emailText, currentEmail)
        portfolioLink_text.text = currentPortfolio
        company_background_image.setImageResource(currentImage)

        Log.d("TAG",currentAddress)
    }

    /**
     * gets a random business Card from the list
     * */
    private fun getRandomBusinessCard(){

        val randomBusinessCard = businessCardList.random()

        currentName = randomBusinessCard.memberName
        currentAddress = randomBusinessCard.address
        currentCompany = randomBusinessCard.companyName
        currentContact =  randomBusinessCard.contact
        currentEmail =  randomBusinessCard.email
        currentPortfolio = randomBusinessCard.portfolioUrl
        currentImage = randomBusinessCard.imageBackground

    }

}
