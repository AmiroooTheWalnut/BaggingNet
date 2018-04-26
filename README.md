# BaggingNet
An application for process mining. Auto-generating a network of events and predicting new partial cases.
This project consists 3 branches: 1-"master" containing the source code of the project. 2-"Libs" containing the libraries and dependancies required. 3-"Test" containing the test datasets.
Weka used for this project, however, the source of weka required minor changes. Therefore, the user should change the following code in Weka classifier:

	/**
	* The dataset header for the purposes of printing out a semi-intelligible
	* model
	*/
	protected Instances m_Instances;
	
To:
	/**
	* The dataset header for the purposes of printing out a semi-intelligible
	* model
	*/
	public Instances m_Instances;
	
There is a compiled revised Weka in the Libs branch.