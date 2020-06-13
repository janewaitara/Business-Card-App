package com.janewaitara.businesscardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

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
    var businessCardList: List<BusinessCard> = listOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namesArray = resources.getStringArray(R.array.names)
        addressesArray = resources.getStringArray(R.array.addresses)
        contactsArray = resources.getStringArray(R.array.contacts)
        emailsArray = resources.getStringArray(R.array.emails)
        portfoliosArray = resources.getStringArray(R.array.portfolios)
        companiesArray = resources.getStringArray(R.array.companies)

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

        initialBusinessCard()
    }

    private fun initialBusinessCard() {

        var phone = getString(R.string.initialPhoneText)
        var emailAddress = getString(R.string.initialEmailText)

        full_name_text.text = getString(R.string.initialNameText)
        location_text.text = getString(R.string.initialLocationText)
        company_name_text.text = getString(R.string.initialCompanyText)
        phone_text.text = getString(R.string.phoneText, phone)
        email_text.text = getString(R.string.emailText, emailAddress)
        portfolioLink_text.text = getString(R.string.initialPortfolioText)


    }

}
