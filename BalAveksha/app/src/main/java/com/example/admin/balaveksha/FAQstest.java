package com.example.admin.balaveksha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class FAQstest extends AppCompatActivity {




    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqstest);


        Toolbar mToolbar =(Toolbar) findViewById(R.id.nav_actionbarhide);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("Frequently Asked Questions");

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("What is Mental Health?");
        listDataHeader.add("What is childhood mental health?");
        listDataHeader.add("Why is mental health important for children?");
        listDataHeader.add("Do children also suffer from mental health problems?");
        listDataHeader.add("What kind of mental hea lth problems do children suffer from?");
        listDataHeader.add("What are Childhood Psychological Disorders?");
        listDataHeader.add("What causes psychological  problems in children?");
        listDataHeader.add("What are the signs to identify psychological problems in my child?");
        listDataHeader.add("Whom do I consult if I feel my child has a psychological problem?");
        listDataHeader.add("How are psychological  problems diagnosed in children?");
        listDataHeader.add("Can mental health problems be  treated?");
        listDataHeader.add("Will my child have to take medicines?");







        // Adding child data
        List<String> quest1 = new ArrayList<String>();
        quest1.add("The World Health Organization defines mental health as \"a state of well-being in which the individual realizes his or her own abilities, can cope with the normal stresses of life, can work productively and fruitfully, and is able to make a contribution to his or her community\". Mental wellness is generally viewed as a positive attribute, such that a person can reach enhanced levels  of mental health, even if the person does not have any diagnosed mental health condit ion . This definition  of  mental  health  highlights emotional well-being,  the   capacity   to   live   a   full  and creative life, and the flexibility to deal with life's inevitable  challenges.");


        List<String> quest2 = new ArrayList<String>();
        quest2.add("Childhood Mental health refers to the capacity of children to experience emotions, develop relationships with others around them. This can also be referred to as Social emotional development in children .");


        List<String> quest3 = new ArrayList<String>();
        quest3.add("Mental   health is  an  essential  part  of  children's   overall\n" +
                "health. It has a complex interactive relationship with their physical health and their ability to succeed in school, at work and in society. Both physical and mental health affect how we think, feel and act. Good mental health allows children and young people to develop the resilience to cope with problems and grow into well-rounded, healthy adults. A positive mental health ensures that the child can effectively express emotions, make friends and explore the world around   them.\n");

        List<String> quest4 = new ArrayList<String>();
        quest4.add("Yes, Children also suffer from mental health problems. Mental health problems affect about one  in ten children and young people. They include depression, anxiety and conduct disorder etc and are often a direct response to what is happening in their Jives.");

        List<String> quest5 = new ArrayList<String>();
        quest5.add("Mental health   concerns can   include   both emotional   problems and behavioural    problems.\n" +
                "Emotional  problems  may  include  concerns  about  mood  (usually  sadness)  or  concerns  about\n" +
                "\n" + "anxiety. Behavioural problems can include concerns with anger and violence, as well as  difficulties paying attention. Common problems during childhood include stress  related  to  school, exams, anxieties related to going to school, changes in routine, location, performance in school and peer group, feeling sad about an event, hyperactivity, temper tantrums etc. However, when anxieties, stress, mood changes, conduct related issues continue for a prolonged period and are affecting the child's performance and well being then it may be a Psychological   disorder.\n");
        List<String> quest6 = new ArrayList<String>();
        quest6.add("Some of the common Psychological disorders affecting children are as follows:\n" +
                "Mental Retardation: Functioning that is significantly  below  average  in the areas of social, academic skills communicat ion, taking  care of one's self, with an IQ of 70 or below\n" +
                "Learning Disorders: Demonstrating abilities below the level expected given their age and grade in school and significant learning problems m academics.\n" +
                "Pervasive Developmental Disorder\n" +
                "\n" +
                "1.\tAutistic Disorder: It is the qualitative impairment in Social interactions including non verbal behaviours like eye contact, gestures etc and in communication as in delay or total lack of development of spoken language, stereotyped and repetitive use of words etc and repetitive and stereotyped  patterns of behaviour, interests etc.\n" +
                "2.\tAspergers: A condition in which the usual impairments of autism are seen but there is usually no language or cognitive delay\n" +
                "Attention Deficit and Disruptive Behaviour Disorders\n" +
                "\n" +
                "1.\tADHD: characterised by inattention and hyperactivity that is significantly inconsistent with the child's developmental level which leads to impairment in other  areas.\n" +
                "2.\tConduct Disorder: Conduct Disorder is characterized by a repetitive and  persistent pattern of behaviour in    which the basic rights of others or major\n" +
                "age-appropriate societal norms or rules are violate d, which may include  being  physically  cruel  to  people  and anima ls, bullies or initiates physical fights.\n" +
                "Anxiety Disorders\n" +
                "\n" +
                "1.\tSeparation\tAnxiety\n" +
                "\n" +
                " \n" +
                "\n" +
                "Disorder: Excessive anxiety concerning separation by a child from the home or from those to whom the person is attached. This anxiety is beyond that which is expected for the individual's developmental  level.\n" +
                "2.\tPost traumatic Stress  Disorders:(PTSD)  in children  and  adolescents  occurs as a result of a child's exposure to one or more traumatic events that were life-threatening or  perceived to be likely to cause serious injury to self or  others.  It  is characterised  by having frequent memories of the event,  having  upsetting and  frightening dreams, acting or feeling like the experience is happening again and developing repeated physical or emotional  symptoms  when  the  child  is  reminded  of the\n" +
                "event\n" +
                "\n" +
                "\n" +
                "Mood Disorders: Characterised by extreme changes in mood, irritability, feelings of extreme sadness or excitement. Common in Children is depress ion.\n" +
                "Substance use/abuse: When children resort to use of  addictive  substances  and  become dependent on them hampering their normal functioning in school, family and other social  situations\n" +
                "Schizophrenia: Characterised by a state of confusion, hallucinations, irrational thinking and behaviour.\n" +
                "Eating Disorders: Taking dieting and a distorted body  perception  to  extremes.  Anorexia Nervosa, Bulimia are the common forms of this  disorder.\n" +
                "Some of these illnesses, such as anxiety disorders, eating disorders, mood disorders, and schizophrenia, can occur in adults as well as children. Others, such as   behavior\n" +
                "and development disorders, elimination disorders, and learning and communication disorders, begin in childhood only, although they can continue into adulthood. In rare cases, tic disorders can develop in adults. It  is  not unusual for a child to have more than one  disorder.\n" +
                "\n");
        List<String> quest7 = new ArrayList<String>();
        quest7.add("The exact cause of most mental illnesses is not known, but research suggests that a combination of factors, including heredity , biolo gy, psychological  trauma, and environmental stress, may be involved.\n" +
                "\n" +
                "•\tHeredity (genetics): Mental illness tends to run in families, which means the likelihood to develop a mental disorder may be passed on from parents to their children.\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "•\tBiology: Some mental disorders have special chemicals in the brain called neurotransmitters. Neurotransmitters cells in the brain communicate  with these chemicals are out of balance or not properly, messages may not  make  it brain correctly, leading to symptoms. In defects in or injury to certain areas of have    been    Iinked    to   some   mental\n" +
                " \n" +
                "been  linked to\n" +
                "\n" +
                "help\tnerve each   other.  1f\n" +
                "working\n" +
                "through\tthe addition,\n" +
                "the brain also illnesses.\n" +
                " \n" +
                "\n" +
                " \n" +
                "•\tPsychological\ttrauma: Some\tmental be triggered  by psychological trauma, such as\n" +
                "o\tsevere emotional, physical, or sexual abuse or  maltreatment\n" +
                "o\tan important early loss, such as the loss of a  parent\n" +
                "o\tneglect\n" +
                " \n" +
                "illnesses\tmay\n" +
                " \n" +
                "•\tMajor Physical Illness: Suffering from major Physical illness is a very stressful situation for children and can affect the emotional and mental health of the  child.\n" +
                "•\tEnvironmental Factors: Stressful or traumatic events can trigger a mental illness in a person with a vulnerability to a mental disorder.\n");
        List<String> quest8 = new ArrayList<String>();
        quest8.add("Not every problem is serious. In fact, many everyday stresses can cause changes in your child's behaviour. For example, the birth of a sibling may cause a child to temporarily act much  younger than he  or  she  is.  It is  important  to  be able  to tell  the  difference between\n" +
                "typical behaviour changes and those associated with more serious  problems.  Pay  special attention to behaviours that include:\n" +
                "\n" +
                "•\tProblems across a variety of settings, such as at school, at home, or with  peers\n" +
                "•\tChanges in appetite or sleep\n" +
                "•\tSocial withdrawal, or fearful behaviour toward things your child normally is not afraid  of\n" +
                "•\tReturning to behaviours more common in younger children, such as bed-wetting, for a long time\n" +
                "•\tSigns of being upset , such as sadness or tearfulness\n" +
                "•\tSigns of self- dest ructive behaviour, such as head- banging , or a tendency to get hurt often\n•\tRepeated thoughts of death\n" +
                "•\tChanges in school performance, such as poor grades despite good  efforts\n" +
                "•\tDepression   shown   by   sustained,   prolonged\tnegative   mood   and   attitude,   often accompanied  by poor appetite, difficulty sleeping or thoughts of death\n" +
                "•\tSevere mood swings\n" +
                "•\tAbuse of drugs and/or alcohol\n" +
                "•\tDefying\tauthority ,\tskipping\tschool,\tstealing,\tor damaging property\n" +
                "•\tHearing voices or seeing things that are not there (ha]lucinations)\n");
        List<String> quest9 = new ArrayList<String>();
        quest9.add("You can consult a child psychiatrist or a clinical Psychologist. A child psychiatrist has a medical degree and their work is mainly to treat more severe disorders like Schizophrenia, depression which involves prescription of medications. On the other hand, Child psychologists use therapy, counselling etc for treatment and management of the  disorders.");
        List<String> quest10 = new ArrayList<String>();
        quest10.add("Mental illnesses in children are diagnosed based on signs  and symptoms that suggest a particular  disorder.  However,  this  process can be especially challenging with children. Many behaviours that are seen as symptoms of mental disorders , such as shyness, anxiety (nervousness), strange eating habits, and  temper  tantrums , can occur as a normal part of a child's development. Behaviours become symptoms when they occur very often, last a long time, occur at an unusual age or cause significant disruption to the  child's  and/or family's ability to function.\n" +
                "If symptoms  are present,  the physician  will  begin  an  evaluation   by\n" +
                "performing a complete medical history and physical exam to rule out physical illness or medication side effects as the cause of the symptoms.\n" +
                "If no physical illness is found, the child may be referred to a child and adolescent psychiatrist or psychologist , mental health professionals who are specially trained to diagnose and treat mental illness in children and teens. Psychiatrists and psychologists use specially designed interview and assessment tools to evaluate a child for a mental disorder. The Psychiatrist/Psychologist bases his or her diagnosis on reports of the child's symptoms and his or her observation of the child's  attitude and behaviour. They often must rely on reports from the child's parents , teachers, and other adults because children often have trouble explaining their problems or understanding their symptoms.\n");
        List<String> quest11 = new ArrayList<String>();
        quest11.add("Yes. Once a diagnosis is made, your child' s specialist will recommend a specific treatment. It is important to understand the various treatment choices , which often include psychotherapy or medication. Some psychological problems may not be cured like in the case of Leaming Disability, Autism, Mental Retardation but a proper support/ rehabilitation programme will successfully  control the symptoms and help the child cope with the disabilities. The most common treatment options used include:\n" +
                "\n" +
                "•\tMedication: Many mental illnesses can be effectively treated with medications.   The  drugs  often   used  to  treat  mental  disorders   in\n" +
                "children include antipsychotics, antidepressants, anti-anxiety drugs, stimulants, and mood stabilizing drugs .\n" +
                "•\tPsychotherapy: Psychotherapy (a type of counseling) addresses the emotional response  to mental illness. It is a process in which trained mental health professionals help people deal with their illness, often by talking through strategies for understanding and dealing with their symptoms, thoughts, and behaviours. Types of psychotherapy often used with children are supportive, cognitive  behavioural, interpersonal, group, and family therapy.\n" +
                "•\tCreative therapies: Certain therapies, such as art therapy or play the rapy, may be helpful, especially with young children who may have trouble communicating their thoughts and feelings.\n" +
                "•\tSpecial education: for children who are slow  learners, have ADHD/autism special educators can help m developing a program that 1s suitable to the requirements/speed of the child.\n");

        List<String> quest12 = new ArrayList<String>();
        quest12.add("Medication can be an effective part of treatment for psychological problems of childhood. The psychiatrist who recommends medication should be experienced in treating psychiatric disorders  of children . Medication is generally prescribed after a thorough diagnostic evaluation of the child and depending on the severity of the disorder. Medication may be prescribed for Psychological symptoms/disorders , including but not limited to:\n" +
                "\n" +
                "•\tAnxiety\n" +
                "•\tADHD\n" +
                "•\tDepression\n" +
                "•\tSevere Aggression\n" +
                "•\tSleep Problems\n");



        listDataChild.put(listDataHeader.get(0), quest1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), quest2);


        listDataChild.put(listDataHeader.get(2), quest3);
        listDataChild.put(listDataHeader.get(3), quest4);
        listDataChild.put(listDataHeader.get(4), quest5);
        listDataChild.put(listDataHeader.get(5), quest6);
        listDataChild.put(listDataHeader.get(6), quest7);
        listDataChild.put(listDataHeader.get(7), quest8);
        listDataChild.put(listDataHeader.get(8), quest9);
        listDataChild.put(listDataHeader.get(9), quest10);
        listDataChild.put(listDataHeader.get(10), quest11);
        listDataChild.put(listDataHeader.get(11), quest12);



    }



}
