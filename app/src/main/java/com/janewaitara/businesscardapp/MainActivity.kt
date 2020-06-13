package com.janewaitara.businesscardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    lateinit var currentName : String
    lateinit var currentAddress : String
    lateinit var currentContact : String
    lateinit var currentEmail : String
    lateinit var currentPortfolio : String
    lateinit var currentCompany : String


    companion object{

        private const val MEMBER_NAME_KEY = "MEMBER_NAME"
        private const val ADDRESS_KEY = "ADDRESS_KEY"
        private const val CONTACT_KEY = "CONTACT_KEY"
        private const val EMAIL_KEY = "EMAIL_KEY"
        private const val PORTFOLIO_KEY = "PORTFOLIO_KEY"
        private const val COMPANY_KEY = "COMPANY_KEY"

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

        businessCardList = listOf(
            BusinessCard(
                namesArray[0],
                addressesArray[0],
                contactsArray[0],
                emailsArray[0],
                portfoliosArray[0],
                companiesArray[0]
            ),
            BusinessCard(
                namesArray[1],
                addressesArray[1],
                contactsArray[1],
                emailsArray[1],
                portfoliosArray[1],
                companiesArray[1]
            ),
            BusinessCard(
                namesArray[2],
                addressesArray[2],
                contactsArray[2],
                emailsArray[2],
                portfoliosArray[2],
                companiesArray[2]
            ),
            BusinessCard(
                namesArray[3],
                addressesArray[3],
                contactsArray[3],
                emailsArray[3],
                portfoliosArray[3],
                companiesArray[3]
            ),
            BusinessCard(
                namesArray[4],
                addressesArray[4],
                contactsArray[4],
                emailsArray[4],
                portfoliosArray[4],
                companiesArray[4]
            )
        )

       // Log.d("TAG",businessCardList[0].memberName)

        change_bs_card_button.setOnClickListener { view ->
            displayNewCard()
        }

        initialBusinessCard()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

       // outState.putString(MEMBER_NAME_KEY,full_name_text.text)
    }
    /**
     * A function that is called all the time the app is created to display the first business card
     * */
    private fun initialBusinessCard() {

        val phone = getString(R.string.initialPhoneText)
        val emailAddress = getString(R.string.initialEmailText)

        full_name_text.text = getString(R.string.initialNameText)
        location_text.text = getString(R.string.initialLocationText)
        company_name_text.text = getString(R.string.initialCompanyText)
        phone_text.text = getString(R.string.phoneText, phone)
        email_text.text = getString(R.string.emailText, emailAddress)
        portfolioLink_text.text = getString(R.string.initialPortfolioText)
    }

    /**
     * creates another card when the button is clicked
     * */
    private fun displayNewCard() {

        Log.d("TAG","Display name has been called")


        val randomBusinessCard = getRandomBusinessCard()


        full_name_text.text = randomBusinessCard[0]
        location_text.text = randomBusinessCard[1]
        company_name_text.text = randomBusinessCard[2]
        phone_text.text = getString(R.string.phoneText, randomBusinessCard[3])
        email_text.text = getString(R.string.emailText, randomBusinessCard[4])
        portfolioLink_text.text = randomBusinessCard[5]

        Log.d("TAG",randomBusinessCard[0])
    }

    private fun getRandomBusinessCard(): List<String>{

        val randomBusinessCard = businessCardList.random()

        currentName = randomBusinessCard.memberName
        currentAddress = randomBusinessCard.address
        currentCompany = randomBusinessCard.companyName
        currentContact = getString(R.string.phoneText, randomBusinessCard.contact)
        currentEmail = getString(R.string.emailText, randomBusinessCard.email)
        currentPortfolio = randomBusinessCard.portfolioUrl

        var randomBusinessCardList = listOf(currentName,currentAddress,currentCompany,currentContact,currentEmail,currentPortfolio)
        return randomBusinessCardList
    }

}
