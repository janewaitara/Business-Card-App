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

       // Log.d("TAG","Hello")

        change_bs_card_button.setOnClickListener { view ->
            displayNewCard()
        }


        initialBusinessCard()
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

    private fun displayNewCard() {

        Log.d("TAG","Displayname has been called")

        val randomBusinessCard = businessCardList.random()

        Log.d("TAG",randomBusinessCard.memberName)

        full_name_text.text = randomBusinessCard.memberName
        location_text.text = randomBusinessCard.address
        company_name_text.text = randomBusinessCard.companyName
        phone_text.text = getString(R.string.phoneText, randomBusinessCard.contact)
        email_text.text = getString(R.string.emailText, randomBusinessCard.email)
        portfolioLink_text.text = randomBusinessCard.portfolioUrl

        Log.d("TAG",randomBusinessCard.memberName)
    }

}
