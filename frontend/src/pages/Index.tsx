import HeroAction from "@/components/HeroAction.tsx";
import expert from "@/assets/expert.jpg"

const Index = () => {
    return (
        <section className="pt-16 pb-16">
            <div className="container mx-auto px-6 flex gap-6">
                <div className="container flex flex-col">
                    <h1 className="text-5xl font-bold">Book your expert.</h1>
                    <p className="mt-6 max-w-2xl text-muted-foreground">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.Aliquam blanditiis doloremque
                        doloribus
                    </p>
                    <div className="mt-auto mb-3 flex">
                        {/*<Input*/}

                        <HeroAction/>
                    </div>
                </div>
                <div className="w-full">
                    <img alt="expert image" className="rounded-2xl shadow-lg" src={expert}/>
                </div>
            </div>
        </section>
    );
}
export default Index;