###Ice Cream Cart Rewards Management System
These are the requirements for an app that the manager of an ice cream cart can use
to keep track of and reward frequent customers.

Given Requirements:
*Italics* are verbs, **Bold** are nouns
  - 1. The **ice cream cart manager** uses this system to *manage* and *keep track* of
purchases from selected **VIP customers**.
  - 2. The **VIP status** of **customers** is *tracked* through a **unique VIP ID**, which is *added*
to the system.
  - 3. For each **VIP customer**, the system needs to know **name**, **address**, **birth date**,
and assigned **VIP ID number** of the **customer**.
  - 4. **VIP customers** are given a **loyalty card** that *shows* their **name** and **VIP ID**.
  - 5. The **ice cream cart** *sells* **ice cream** and **frozen yogurt**. **VIP customers** that *show*
their** VIP ID card** when purchasing an item earn **VIP points**: they are *awarded* 1
**VIP point** for each full **dollar** *spent* (i.e., fractions of a dollar are discarded).
  - 6. At any particular point in **time**, the **ice cream car**t system should be able to
*calculate*, for each **VIP customer**, the **items** that the **customer** has *purchased* and
the **VIP points** earned by them in the current **month** and in total (i.e., since they
became **members**).
  - 7. **VIP customers** can also *pre-order* **ice creams**, but not **frozen yogurts**, as early as
a week in advance unless the **pre-order slots** for the pick-up day are *filled*.
  - 8. A **VIP customer** who earns more than 50 **VIP points** in a given month can *have*
one **free ice cream or frozen yogurt** (at any point in the future).
  - 9. A **customer** who *earns* a total of **1000 VIP points** is *upgraded* to **GOLD status** for
life.
  - 10. A **VIP customer** with **GOLD status** (1) gets one **free ice cream** or **frozen yogurt**
per month (2) can *buy* items with a **10% discount**, and (3) **accrues double points
for each purchase**.
  - 11. The **ice cream cart owner** can *generate* a **daily report** of **purchased** and **preordered**
items for the current day. A **pre-ordered item** is *counted* on the day it is
*ordered*, and not the day on which it is *picked* up.
  - 12. The **ice cream cart manager** must be able to *add* **VIP customers** to the
system and *remove* **VIP customers** from the system. When a **customer** is
removed, his or her data are *permanently deleted*.
  - 13 The **ice cream cart manager** must be able to *edit the information* stored in
the system for a **VIP custome**r, such as *change* his or her **address**.
  - 14 The **User Interface (UI)** of the app must be intuitive and responsive.
  - 15 There is no need to handle **concurrent access** to the information, as the
*application will be used on one device* at a time, at least for now.

Supplemental Requirements:
 - No supplemental requirements identified for the current version.
