
int main(int a){

	return 0;
}


float doSomethingAssWhole(){

	if(nothing==0){
		[a wah:"ASDFSADF"];
	}
	
	return 0;
}

@interface ViewController : UIViewController

@end

@implementation ViewController

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    NSLog("khjh");
    
}

-(IBAction)gotoVoiceList:(id)sender{
    VoiceListController *v=[[VoiceListController alloc] initWithNibName:@"VoiceListController" bundle:nil];

    [self presentModalViewController:v animated:YES];
}

- (void)viewDidLoad
{

	 NSMutableArray *arr=[[NSMutableArray alloc] initWithCapacity:10];
        
        [arr addObject:@"Im 1"];
        [arr addObject:@"Im 2"];
        [arr addObject:@"Im 3"];

        for(int i=0;i<[arr count];i++){
		  	NSLog(@"%@",[arr objectAtIndex:i]);
        }
        
        [arr removeLastObject];

        for(int i=0;i<[arr count];++i){
		  	NSLog(@"%@",[arr objectAtIndex:i]);
        }
        int c=7;
        
        NSLog(@"%d",c);

    	return [super viewDidLoad];
    
	
}

- (void)viewDidUnload
{
    [super viewDidUnload];
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    return something;
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}

@end
