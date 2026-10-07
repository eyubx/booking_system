import {useParams} from "react-router-dom";
import {useQuery} from "@tanstack/react-query";
import {Card, CardHeader, CardContent, CardTitle} from "@/components/ui/card";

const Booking = () => {
    const {id} = useParams();
    const {data, isLoading} = useQuery({
        queryKey: [""],
        queryFn: async () => {
            return {
                id: 1000,
                in: "5 days",
                expert_name: "Le monsieur Flan",
                expert_field: "Constateur",
                date: (new Date()).toLocaleString(),
                about_me: "Mr searcher",
                about_expert: "I don't usually answer on phone."
            };
        }
    });
    return (
        <section className="container mx-auto mt-16 ">
            <h1 className="mb-8 font-bold text-2xl text-center">
                Booking #{id}
            </h1>
            {!isLoading && (
                <Card className="">
                    <CardHeader>
                        <CardTitle>Booking information:</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <p>You have a meeting in the Next <u>{data!.in}</u> with: </p>
                        <p>Expert of <b>{data?.expert_name}</b> as of {data!.date}. </p>
                        <p>Infos about you: </p>
                        <p>{data!.about_me}</p>
                        <p>Information about your expert: </p>
                        <p>{data!.about_expert}</p>
                    </CardContent>

                </Card>
            )}


        </section>
    );
}

export default Booking;